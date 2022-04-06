<%@ page import="com.pollock.songs.Song" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/include/songHeader.jsp"/>
<jsp:include page="/WEB-INF/include/songNavbar.jsp"/>

<%
    ArrayList<Song> playlist = (ArrayList<Song>) session.getAttribute("playlist");
%>

<main class="flex-shrink-0">
    <div class="container">
        <h1 class="mt-5">Playlist</h1>
        <%
            if(playlist != null && playlist.size() > 0) {
        %>
        <a href="songs?go=empty" class="btn btn-primary">Remove all songs</a>
        <div class="table">
            <%
                for(Song song : playlist){
            %>
            <div class="row">
                <div class="col">
                    <iframe width="560" height="315" src="<%=song.getYoutube()%>" title="YouTube video player"
                    frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope;
                    picture-in-picture" allowfullscreen></iframe>
                </div>
                <div class="col">
                    <a href="songs?go=remove&song=<%=song.getSongID()%>" class="btn btn-secondary">Remove from Playlist</a>
                </div>
            </div>
            <%
                }
            %>
        </div>
        <%
            } else {
        %>
        <p>Sorry, your playlist is empty. View the Song List to find some to add!</p>
        <%
            }
            String message = (String) request.getAttribute("message");
            if(message != null){
        %>
        <p>${message}</p>
        <% } %>
    </div>
<jsp:include page="/WEB-INF/include/footer.jsp"/>
