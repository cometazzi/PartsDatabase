<%@include file="taglib.jsp" %>
<c:import url="head.jsp" />
<!--%@page errorPage = "error.jsp" %-->
<html>
<body>

<h2>Parts Database</h2>

<p>Parts Database is free to use, but to make changes you must <a href="logIn">register</a>.</p>
<br>
<c:choose>
    <c:when test="${empty userName}">
        <a href = "logIn">Log in</a>
    </c:when>
    <c:otherwise>
        <h3>Welcome ${userName}</h3>
    </c:otherwise>
</c:choose>
<br>
<a href="capacitorSearch.jsp">Search Capacitors</a><br>
<a href="transistorSearch.jsp">Search Transistors</a><br>
<a href="chipAmpSearch.jsp">Search ChipAmps</a><br>
</body>
</html>