<%@include file="taglib.jsp" %>
<!--%@page errorPage = "error.jsp" % -->
<c:set var="title" value="Update Success"/>
<c:import url="head.jsp"/>

<body>

<script type="text/javascript" class="init">
    $(document).ready(function () {
        $('#chipAmpTable').DataTable();
    });
</script>

<h2>${title}</h2>

<table id="chipAmpTable" class="display" cellspacing="0" width="100%">
    <thead>
    <th>Part Number</th>
    <th>Technology</th>
    <th>Description</th>
    <th>Quantity</th>
    <th>Package Type</th>
    <th>Cost</th>
    </thead>
    <tbody>
    <c:forEach var="part" items="${updatedChipAmp}">

        <tr>
            <td>${part.partNum}</td>
            <td>${part.technology}</td>
            <td>${part.descr}</td>
            <td>${part.qty}</td>
            <td>${part.packageName}</td>
            <td>${part.cost}</td>
            <td>
                <a href="chipAmpDetails.jsp?partNum=${part.partNum}&partTech=${part.technology}&partDesc=${part.descr}&partQty=${part.qty}&partPkg=${part.packageName}&partCost=${part.cost}">View
                    Details</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<td>
    <a href="chipAmpMarketDetails?partNum=${part.partNum}">
        <button type="button" class="btn btn-primary">View Details</button>
    </a>
</td>
</body>
</html>
