<%@ page import="com.pollock.songs.Song" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/include/songHeader.jsp"/>
<jsp:include page="/WEB-INF/include/songNavbar.jsp"/>

<main class="flex-shrink-0">
    <div class="container">
        <h1 class="mt-5">Songs</h1>
        <c:choose>
            <c:when test="${songDB == null || songDB.size == 0}">
                <p>Sorry, no songs to display. Try again later.</p>
            </c:when>
            <c:otherwise>
                <div class="table">
                    <c:forEach var="entry" items="${songDB}">
                        <div class="row">
                            <div class="col">
                                ${entry.value.name} - ${entry.value.artist}

                            </div>
                            <div class="col">
                                <a href="<c:url value="/songs">
                                    <c:param name="go" value="add"/>
                                    <c:param name="song" value="${entry.value.songID}"/>
                                </c:url>" class="btn btn-secondary">Add to Playlist</a>
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