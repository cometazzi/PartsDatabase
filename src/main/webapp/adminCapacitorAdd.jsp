<%@include file="taglib.jsp" %>
<c:import url="head.jsp"/>
<%@page errorPage="error.jsp" %>
<html>
<body>

<h1>Add New Capacitor</h1>


<form action="AdminManageParts" class="form-inline">
    <div class="form-group">
        <label for="capacitorType">Select Type</label></td>
        <select name="capacitorType" id="capacitorType">
            <option value="24">Ceramic</option>
            <option value="25">Mylar</option>
            <option value="26">Electrolytic</option>
        </select>
        <table>
            <tr>
                <td><label for="newPartNum">Enter Part Number</label></td>
                <td><input type="text" class="form-control" id="newPartNum" name="newPartNum"
                           aria-describedby="newPartNum"></td>
            </tr>
            <tr>

                <td><label for="newDesc">Enter Description</label></td>
                <td><input type="text" class="form-control" id="newDesc" name="newDesc" aria-describedby="newDesc"></td>
            </tr>

            <tr>
                <td><label for="newQty">Enter Quantity</label></td>
                <td><input type="text" class="form-control" id="newQty" name="newQty" aria-describedby="newQty"></td>
            </tr>

            <tr>
                <td><label for="newCost">Enter Cost</label></td>
                <td><input type="text" class="form-control" id="newCost" name="newCost" aria-describedby="newCost"></td>
            </tr>
        </table>
        <input type="hidden" id="partType" name="partType" value="capacitor">
        <br>

        <button type="submit" name="submit" value="addNewCapacitor" class="btn btn-primary">Add New Capacitor</button>

        <a href="capacitorSearch.jsp">
            <button type="button" class="btn btn-primary">Cancel</button>
        </a>

    </div>

</form>

<a href="capacitorSearch.jsp">Return to Search Capacitors</a><br>
<a href="index.jsp">Return to Index</a><br>

</body>
</html>