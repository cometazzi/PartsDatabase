<%@include file="taglib.jsp" %>
<!--%@page errorPage = "error.jsp" % -->
<c:set var="title" value="Update Success" />
<c:import url="head.jsp" />

<body>

<h2>${title}</h2>

${Transistor.qty} Quantity updated to ${updatedTransistor}
<br>
<a href="index.jsp">Return to Index</a>
</body>
</html>
