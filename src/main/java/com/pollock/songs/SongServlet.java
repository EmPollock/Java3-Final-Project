package com.pollock.songs;

import com.pollock.support.Ticket;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(name = "SongServlet", value = "/songs")
public class SongServlet extends HttpServlet {
    private Map<Integer, Song> songDB = new LinkedHashMap<>();;
    private volatile int SONG_ID = 0;

    @Override
    public void init() throws ServletException {
        // add songs to songDB
        songDB.put(0, new Song("Mingulay Boat Song", "The Irish Rovers", "https://www.youtube.com/embed/xy0OcjkVdGM"));
        songDB.put(1, new Song("Rosibella", "The Dreadnoughts", "https://www.youtube.com/embed/O-JH_Q-I_kw"));
        songDB.put(2, new Song("The Rocky Road to Dublin", "The High Kings", "https://www.youtube.com/embed/Btj18wNLooQ"));
        songDB.put(3, new Song("Row Me Bully Boys", "Rambling Sailors", "https://www.youtube.com/embed/yt3eDutA-oc"));
        songDB.put(4, new Song("Pique la Baleine", "The Dreadnoughts", "https://www.youtube.com/embed/lyi3oyhyC5k"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String go = (String)request.getParameter("go");
        if(go == null){
            go = "view";
        }

        switch(go){
            case "add":
                addSong(request, response);
                break;
            case "list":
                viewPlaylist(request, response);
                break;
            case "empty":
                emptyPlaylist(request, response);
                break;
            case "remove":
                removeSong(request, response);
                break;
            case "logout":
                logout(request, response);
                break;
            case "view":
            default:
                viewSongs(request, response);
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        request.setAttribute("loggedOut", true);
        response.sendRedirect("login");
    }

    private void emptyPlaylist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();

        if(session.getAttribute("username") == null){
            response.sendRedirect("login");
            return;
        }

        session.removeAttribute("playlist");
        viewPlaylist(request, response);
    }

    private void removeSong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();

        if(session.getAttribute("username") == null){
            response.sendRedirect("login");
            return;
        }

        ArrayList<Song> playlist = getPlaylist(session);
        String idString = request.getParameter("song");

        Song song = getSong(idString);
        if(song == null){
            request.setAttribute("message", "Error: could not find song to remove.");
        }
        else {
            playlist.remove(song);
            request.setAttribute("message", "Successfully removed song from playlist.");
        }

        session.setAttribute("playlist", playlist);
        viewPlaylist(request, response);
    }

    private void viewPlaylist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        if(session.getAttribute("username") == null){
            response.sendRedirect("login");
            return;
        }
        ArrayList<Song> playlist = getPlaylist(session);

        request.setAttribute("playlist", playlist);
        request.getRequestDispatcher("/WEB-INF/songs/playlist.jsp").forward(request, response);
    }

    private void addSong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();

        if(session.getAttribute("username") == null){
            response.sendRedirect("login");
            return;
        }

        ArrayList<Song> playlist = getPlaylist(session);
        String idString = request.getParameter("song");

        Song song = getSong(idString);
        if(song == null){
            request.setAttribute("message", "Error: could not add song to playlist.");
        }
        else{
            boolean contains = false;
            for(Song s : playlist) {
                if(s.getSongID() == song.getSongID()){
                    contains = true;
                    break;
                }
            }
            if(contains){
                request.setAttribute("message", "Error: could not add song to playlist; Song already in playlist");
            }
            else {
                playlist.add(song);
                request.setAttribute("message", "Successfully added song to playlist.");
            }
        }
        session.setAttribute("playlist", playlist);
        viewSongs(request, response);
    }

    private ArrayList<Song> getPlaylist(HttpSession session){
        ArrayList<Song> playlist;

        if(session.getAttribute("playlist") != null){
            playlist = (ArrayList<Song>) session.getAttribute("playlist");
        } else{
            playlist = new ArrayList<Song>();
        }

        return playlist;
    }

    private Song getSong(String idStr){
        if(idStr == null || idStr.length() == 0){
            return null;
        }
        try{
            int id = Integer.parseInt(idStr);
            return songDB.get(id);
        } catch (NumberFormatException ex){
            return null;
        }
    }

    private void viewSongs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("username") == null){
            response.sendRedirect("login");
            return;
        }
        request.setAttribute("songDB", songDB);
        request.getRequestDispatcher("/WEB-INF/songs/viewSongs.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
