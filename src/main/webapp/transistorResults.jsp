<%@include file="taglib.jsp" %>
<%@page errorPage = "error.jsp" %>
<c:set var="title" value="Search Results" />
<c:import url="head.jsp" />


<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#userTable').DataTable();
    } );
</script>

<html>
<body>

<div class="container-fluid">
    <h2>${title}: </h2>
    <table id="transistorTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>Name</th>
        <th>User Name</th>
        <th>Age</th>
        <th>Orders</th>
        </thead>
        <tbody>
        <c:forEach var="part" items="${users}">
            <tr>
                <td>${user.firstName} ${user.lastName}</td>
                <td>${user.userName}</td>
                <td>${user.age}</td>
                <td>
                    <ul>
                        <c:forEach var="order" items="${user.orders}">
                            <li>${order.description}</li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <p>Click <a href="index.jsp">here</a> to return.</p>
</div>
