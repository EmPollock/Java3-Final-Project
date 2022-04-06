<%@ page import="com.pollock.songs.Song" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/include/songHeader.jsp"/>
<jsp:include page="/WEB-INF/include/songNavbar.jsp"/>

<%
    //@SuppressWarnings("unchecked")
    Map<Integer, Song> songDB = (Map<Integer, Song>)request.getAttribute("songDB");
%>

<main class="flex-shrink-0">
    <div class="container">
        <h1 class="mt-5">Songs</h1>
        <%
            if(songDB != null && songDB.size() > 0) {
        %>
        <div class="table">
            <%
                for(int id : songDB.keySet()){
                    Song song = songDB.get(id);
            %>
                <div class="row">
                    <div class="col">
                        <%=song.getName()%> - <%=song.getArtist()%>
                    </div>
                    <div class="col">
                        <a href="songs?go=add&song=<%= id %>" class="btn btn-secondary">Add to Playlist</a>
                    </div>
                </div>
            <%
                }
            %>
        </div>
        <%
            } else {
        %>
            <p>Sorry, no songs to display. Try again later.</p>
        <%
            }
            String message = (String) request.getAttribute("message");
            if(message != null){
        %>
        <p>${message}</p>
        <% } %>
    </div>

<jsp:include page="/WEB-INF/include/footer.jsp"/>
