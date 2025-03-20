<%@include file="taglib.jsp" %>
<c:import url="head.jsp" />
<!-- %@page errorPage = "error.jsp" % -->
<html>
<body>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#transistorTable').DataTable();
    } );
</script>

<h2>${param.partNum} Details</h2>

<table id="transistorTable" class="display" cellspacing="0" width="100%">
    <thead>
    <th>Part Number</th>
    <th>Technology</th>
    <th>Description</th>
    <th>Quantity</th>
    <th>Package Type</th>
    <th>Cost</th>
    </thead>
    <tbody>

    <tr>
        <td>${param.partNum}</td>
        <td>${param.partTech}</td>
        <td>${param.partDesc}</td>
        <td>${param.partQty}</td>
        <td>${param.partPkg}</td>
        <td>${param.partCost}</td>

    </tr>
    </tbody>
</table>


<form action="UpdateTransistorQTY" class="form-inline">
    <div class="form-group">
        <label for="newQty">Change Quantity</label>
        <input type="text" class="form-control" id="newQty" name="newQty" aria-describedby="newQty" value="${param.partQty}">
        <input type="hidden" id="partNum" name="partNum" value="${param.partNum}">
    </div>
    <button type="submit" name="submit" value="changeQty"  class="btn btn-primary">Update Quantity</button>
</form>

<a href="searchTransistor.jsp">Return to Search Transistors</a><br>
<a href="index.jsp">Return to Index</a><br>
</body>
</html>