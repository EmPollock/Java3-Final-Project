<%@ page import="com.pollock.songs.Song" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/include/songHeader.jsp"/>
<jsp:include page="/WEB-INF/include/songNavbar.jsp"/>

<main class="flex-shrink-0">
    <div class="container">
        <h1 class="mt-5">Playlist</h1>
        <c:choose>
            <c:when test="${playlist == null || fn:length(playlist) == 0}">
                <p>Sorry, your playlist is empty. View the Song List to find some to add!</p>
            </c:when>
            <c:otherwise>
                <a href="<c:url value="/songs">
                    <c:param name="go" value="empty"/>
                </c:url>" class="btn btn-primary">Remove all songs</a>
                <div class="table">
                    <c:forEach items="${playlist}" var="song">
                    <div class="row">
                        <div class="col">
                            <iframe width="560" height="315" src="${song.youtube}" title="YouTube video player"
                                    frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope;
                    picture-in-picture" allowfullscreen></iframe>
                        </div>
                        <div class="col">
                            <a href="<c:url value="/songs">
                                <c:param name="go" value="remove"/>
                                <c:param name="song" value="${song.songID}"/>
                            </c:url>" class="btn btn-secondary">Remove from Playlist</a>
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </c:otherwise>
        </c:choose>
        <c:if test="${message != null}">
            <p>${message}</p>
        </c:if>
    </div>
<jsp:include page="/WEB-INF/include/footer.jsp"/>
