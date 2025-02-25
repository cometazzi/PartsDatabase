<%@include file="taglib.jsp" %>
<%@page errorPage = "error.jsp" %>
<c:set var="title" value="Search Results" />
<c:import url="head.jsp" />


<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#transistorTable').DataTable();
    } );
</script>

<html>
<body>

<div class="container-fluid">
    <h2>${title}: </h2>
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
        <c:forEach var="part" items="${transistors}">
            <tr>
                <td>${part.partNum}</td>
                <td>${part.technology}</td>
                <td>${part.descr}</td>
                <td>${part.qty}</td>
                <td>${part.packageName}</td>
                <td>${part.cost}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <p>Click <a href="index.jsp">here</a> to return.</p>
</div>
