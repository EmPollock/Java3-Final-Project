package com.pollock.ch07;

import com.pollock.finalproject.Person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

@WebServlet(name = "DirectoryServlet", value = "/ch07/directory")
public class DirectoryServlet extends HttpServlet {
    private static final String FILE_PATH = "WEB-INF/ch07/people.csv";
    private static SortedSet<DirectoryPerson> people;

    private void readFromFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(people == null){
            try(Scanner in = new Scanner(new File(getServletContext().getRealPath(FILE_PATH)))){
                people = new TreeSet<>();
                int lineCount = 0;
                String line = in.nextLine();
                String[] fields;
                String firstName;
                String lastName;
                String picture;
                while(in.hasNextLine()){
                    lineCount++;
                    line = in.nextLine();
                    fields = line.split(",");
                    // ignoring fields[0] because we don't care about Mr Mrs and Miss
                    firstName = fields[1];
                    lastName = fields[2];
                    picture = fields[3];
                    people.add(new DirectoryPerson(firstName, lastName, picture));
                }
            } catch(FileNotFoundException e){
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html><html><head>");
                    out.println("<title>Data error</title>");
                    out.println("</head><body>");
                    out.println("<h1>Error reading data</h1>");
                    out.println("</body></html>");
                }
                return;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            readFromFile(request, response);
        } catch (IOException ex) {
            return; // should redirect to some error page "file cannot be found"
                    // but for this example, not doing that for brevity
        }

        int page = 1;
        int itemsPerPage = 16;

        int maxPages = people.size() / itemsPerPage;
        if(people.size() % itemsPerPage != 0) {
            maxPages++;
        }

        String pageStr = request.getParameter("page");
        if(pageStr != null && !pageStr.equals("")) {
            try {
                page = Integer.parseInt(pageStr);
                if(page < 1){
                    page = 1;
                } else if(page > maxPages) {
                    page = maxPages;
                }
            } catch(NumberFormatException e) {
                page = 1;
            }
        }
        int beginItem = (page - 1) * itemsPerPage;
        int endItem = beginItem + itemsPerPage - 1;
        int pagesPerPage = 5;
        int beginPage = page / pagesPerPage * pagesPerPage > 0 ? page / pagesPerPage * pagesPerPage : 1;
        int endPage = beginPage + pagesPerPage - 1 > maxPages ? (maxPages / pagesPerPage + 1) * pagesPerPage - 1 : beginPage + pagesPerPage - 1;

        request.setAttribute("begin", beginItem);
        request.setAttribute("end", endItem);
        request.setAttribute("maxPages", maxPages);
        request.setAttribute("currentPage", page);
        request.setAttribute("beginPage", beginPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("people", people);
        request.getRequestDispatcher("/WEB-INF/ch07/directory.jsp").forward(request, response);
    }
}
