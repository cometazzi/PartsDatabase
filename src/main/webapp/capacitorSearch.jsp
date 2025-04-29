<%@include file="taglib.jsp" %>
<c:import url="head.jsp"/>
<%@page errorPage="error.jsp" %>
<html>
<body>

<h2>Capacitor Search</h2>

<form action="searchParts" class="form-inline">
    <div class="form-group">
        <label for="searchTerm">Search</label>
        <input type="text" class="form-control" id="searchTerm" name="searchTerm" aria-describedby="searchTermHelp"
               placeholder="Enter Part Number">
        <input type="hidden" id="partType" name="partType" value="capacitor">
    </div>
    <button type="submit" name="submit" value="search" class="btn btn-primary">Search Capacitors</button>
    <button type="submit" name="submit" value="viewAll" class="btn btn-primary">View All Capacitors</button>
</form>
</body>
</html>