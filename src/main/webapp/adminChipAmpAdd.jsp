<%@include file="taglib.jsp" %>
<c:import url="head.jsp"/>
<%@page errorPage="error.jsp" %>
<html>
<body>

<h1>Add New ChipAmp</h1>


<form action="AdminManageParts" class="form-inline">
    <div class="form-group">

        <table>
            <tr>
                <td><label for="newPkg">Select Package</label>
                    <select name="newPkg" id="newPkg">
                        <option value="1">DIP-4</option>
                        <option value="2">DIP-6</option>
                        <option value="3">DIP-8</option>
                        <option value="4">DIP-14</option>
                        <option value="5">DIP-16</option>
                        <option value="6">DIP-18</option>
                        <option value="7">DIP-20</option>
                        <option value="8">SIP-8</option>
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
        <input type="hidden" id="partType" name="partType" value="chipAmp">
        <br>

        <button type="submit" name="submit" value="addNewChipAmp" class="btn btn-primary">Add New ChipAmp</button>

        <a href="chipAmpSearch.jsp">
            <button type="button" class="btn btn-primary">Cancel</button>
        </a>

    </div>

</form>

<a href="chipAmpSearch.jsp">Return to Search ChipAmps</a><br>
<a href="index.jsp">Return to Index</a><br>

</body>
</html>