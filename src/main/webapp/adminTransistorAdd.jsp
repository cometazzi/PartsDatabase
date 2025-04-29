<%@include file="taglib.jsp" %>
<c:import url="head.jsp"/>
<%@page errorPage="error.jsp" %>
<html>
<body>

<h1>Add New Transistor</h1>


<form action="AdminManageParts" class="form-inline">
    <div class="form-group">

        <table>
            <tr>
                <td><label for="newPkg">Select Package</label>
                    <select name="newPkg" id="newPkg">
                        <option value="9">TO-3</option>
                        <option value="10">TO-5</option>
                        <option value="11">TO-18</option>
                        <option value="12">TO-92</option>
                        <option value="13">TO-126</option>
                        <option value="14">TO-220</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label for="newPartNum">Enter Part Number</label></td>
                <td><input type="text" class="form-control" id="newPartNum" name="newPartNum"
                           aria-describedby="newPartNum"></td>
            </tr>

            <tr>
                <td><label for="newTech">Enter Technology</label></td>
                <td><input type="text" class="form-control" id="newTech" name="newTech" aria-describedby="newDesc"></td>
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
        <input type="hidden" id="partType" name="partType" value="transistor">
        <br>

        <button type="submit" name="submit" value="addNewTransistor" class="btn btn-primary">Add New Transistor</button>

        <a href="transistorSearch.jsp">
            <button type="button" class="btn btn-primary">Cancel</button>
        </a>

    </div>

</form>

<a href="transistorSearch.jsp">Return to Search Transistors</a><br>
<a href="index.jsp">Return to Index</a><br>

</body>
</html>