<%@include file="taglib.jsp" %>
<%@page errorPage = "error.jsp" %>
<c:set var="title" value="Update Success" />
<c:import url="head.jsp" />

<body>

<script type="text/javascript" class="init">
  $(document).ready( function () {
    $('#transistorTable').DataTable();
  } );
</script>

<h2>${title}</h2>

<table id="capacitorTable" class="display" cellspacing="0" width="100%">
  <thead>
  <th>Part Number</th>
  <th>Description</th>
  <th>Quantity</th>
  <th>Cost</th>
  </thead>
  <tbody>
  <c:forEach var="part" items="${updatedCapacitor}">

    <tr>
      <td>${part.partNum}</td>
      <td>${part.descr}</td>
      <td>${part.qty}</td>
      <td>${part.cost}</td>
      <td><a href="capacitorDetails.jsp?partNum=${part.partNum}&partDesc=${part.descr}&partQty=${part.qty}&partCost=${part.cost}">View Details</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<br>
<a href="capacitorSearch.jsp">Return to Search Capacitors</a><br>
<a href="index.jsp">Return to Index</a><br>
</body>
</html>
