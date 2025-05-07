<%@include file="taglib.jsp" %>
<%@page errorPage="error.jsp" %>
<c:set var="title" value="Search Results"/>
<c:import url="head.jsp"/>


<script type="text/javascript" class="init">
    $(document).ready(function () {
        $('#resistorTable').DataTable();
    });
</script>

<html>
<body>

<div class="container-fluid">
    <h2>${title}: </h2>
    <table id="resistorTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>Image</th>
        <th>Value</th>
        <th>Quantity</th>
        <th>Cost</th>
        </thead>
        <tbody>
        <c:forEach var="part" items="${resistors}">

            <tr>
                <td><img src="images/${part.imageUrl}" width="50" height="50"></td>
                <td>${part.partNum}</td>
                <td>${part.qty}</td>
                <td>${part.cost}</td>
            </tr>
        </c:forEach>
        <br>
        <em>Resistor quantities are not modifiable</em>
        <br><br>
        </tbody>
    </table>

    <br>
    <p>Click <a href="resistorSearch.jsp">here</a> to return to Resistor Search.</p>
    <p>Click <a href="index.jsp">here</a> to return to Part Search</p>

</div>
