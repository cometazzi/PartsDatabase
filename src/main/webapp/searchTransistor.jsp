<%@include file="taglib.jsp" %>
<c:import url="head.jsp" />
<%@page errorPage = "error.jsp" %>
<html>
<body>

<h2>Electronic Parts Search</h2>

<form action="searchTransistors" class="form-inline">
    <div class="form-group">
        <label for="searchTerm">Search</label>
        <input type="text" class="form-control" id="searchTerm" name="searchTerm" aria-describedby="searchTermHelp" placeholder="Enter Part Number">
    </div>
    <button type="submit" name="submit" value="search" class="btn btn-primary">Search Transistors</button>
    <button type="submit" name="submit" value="viewAll" class="btn btn-primary">View All Transistors</button>
</form>
</body>
</html>