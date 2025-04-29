<%@include file="taglib.jsp" %>
<%@page errorPage="error.jsp" %>
<c:set var="title" value="Update Success"/>
<c:import url="head.jsp"/>

<body>

<script type="text/javascript" class="init">
    $(document).ready(function () {
        $('#linearICTable').DataTable();
    });
</script>

<h2>${title}</h2>

<table id="linearICTable" class="display" cellspacing="0" width="100%">
    <thead>
    <th>Part Number</th>
    <th>Description</th>
    <th>Quantity</th>
    <th>Package Type</th>
    <th>Cost</th>
    </thead>
    <tbody>
    <c:forEach var="part" items="${updatedLinearIC}">

        <tr>
            <td>${part.partNum}</td>
            <td>${part.descr}</td>
            <td>${part.qty}</td>
            <td>${part.packageName}</td>
            <td>${part.cost}</td>
            <td>
                <a href="linearICDetails.jsp?partNum=${part.partNum}&partDesc=${part.descr}&partQty=${part.qty}&partPkg=${part.packageName}&partCost=${part.cost}">View
                    Details</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="linearICSearch.jsp">Return to Search LinearICs</a><br>
<a href="index.jsp">Return to Index</a><br>
</body>
</html>
