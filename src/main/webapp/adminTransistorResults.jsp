<%@include file="taglib.jsp" %>
<%@page errorPage="error.jsp" %>
<c:set var="title" value="Search Results"/>
<c:import url="head.jsp"/>


<script type="text/javascript" class="init">
    $(document).ready(function () {
        $('#transistorTable').DataTable();
    });
</script>

<html>
<body>

<div class="container-fluid">
    <h2>${title}: </h2>
    <table id="transistorTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>Image</th>
        <th>Part Number</th>
        <th>Technology</th>
        <th>Description</th>
        <th>Quantity</th>
        <th>Package Type</th>
        <th>Cost</th>
        <th>Details</th>
        </thead>
        <tbody>
        <c:forEach var="part" items="${transistors}">

            <tr>
                <td><img src="images/${part.imageUrl}" width="50" height="50"></td>
                <td>${part.partNum}</td>
                <td>${part.technology}</td>
                <td>${part.descr}</td>
                <td>${part.qty}</td>
                <td>${part.packageName}</td>
                <td>${part.cost}</td>
                <td>
                    <a href="adminTransistorDetails.jsp?partNum=${part.partNum}&partTech=${part.technology}&partDesc=${part.descr}&partQty=${part.qty}&partPkg=${part.packageName}&partCost=${part.cost}">
                        <button type="button" class="btn btn-primary">Edit Details</button>
                    </a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <br>
    <p>Click <a href="transistorSearch.jsp">here</a> to return to Transistor Search.</p>
    <p>Click <a href="index.jsp">here</a> to return to Part Search</p>

</div>
