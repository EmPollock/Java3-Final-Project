package com.pollock.ch05;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

@WebServlet(name = "StoreServlet", value = "/ch05/shop")
public class StoreServlet extends HttpServlet {
    /*
        page=
            browse
            addToCart&productId=1
            viewCart
            empty
            removeFromCart&productId=1

        ex /shop?page=browse
    */
    private final Map<Integer, String> products = new Hashtable<>();

    @Override
    public void init() throws ServletException {
        products.put(1, "Butterfinger");
        products.put(2, "Reese's");
        products.put(3, "Laffy Taffy");
        products.put(4, "Snickers");
        products.put(5, "Three Musketeers");
        products.put(6, "Whatchamacallit");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if(page == null){
            page = "browse";
        }
        switch(page){
            case "addToCart":
                addToCart(request, response);
                break;
            case "viewCart":
                viewCart(request, response);
                break;
            case "emptyCart":

                break;
            case "removeFromCart":

                break;
            case "browse":
            default:
                browse(request, response);
        }
    }

    private void browse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INF/ch05/browse.jsp").forward(request, response);
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String itemId = request.getParameter("itemId");
        int item;
        try{
            item = Integer.parseInt(itemId);
        } catch (NumberFormatException ex){
            response.sendRedirect("shop");
            return;
        }
        if(!products.containsKey(item)){
            response.sendRedirect("shop");
            return;
        }
        HttpSession session = request.getSession();
        if(session.getAttribute("cart") == null){
            session.setAttribute("cart", new Hashtable<Integer, Integer>());//id, quantity
        }
        Hashtable<Integer, Integer> cart = (Hashtable<Integer, Integer>)session.getAttribute("cart");
        if(!cart.containsKey(item)){
            cart.put(item, 1);
        }
        else{
            cart.put(item, cart.get(item)+1);
        }
        response.sendRedirect("shop?page=viewCart");
    }

    private void viewCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INF/ch05/viewCart.jsp").forward(request, response);
    }
}
