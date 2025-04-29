<%@include file="taglib.jsp" %>
<c:import url="head.jsp"/>
<%@page errorPage="error.jsp" %>
<html>
<body>

<script type="text/javascript" class="init">
    $(document).ready(function () {
        $('#chipAmpTable').DataTable({searching: false});
    });
</script>

<h2>${param.partNum} Details</h2>

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

    <tr>
        <td>${param.partNum}</td>
        <td>${param.partTech}</td>
        <td>${param.partDesc}</td>
        <td>${param.partQty}</td>
        <td>${param.partPkg}</td>
        <td>${param.partCost}</td>

    </tr>
    </tbody>
</table>


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
                <td><label for="newPartNum">Change Part Number</label></td>
                <td><input type="text" class="form-control" id="newPartNum" name="newPartNum"
                           aria-describedby="newPartNum" value="${param.partNum}"></td>
            </tr>
            <tr>

                <td><label for="newDesc">Change Description</label></td>
                <td><input type="text" class="form-control" id="newDesc" name="newDesc" aria-describedby="newDesc"
                           value="${param.partDesc}"></td>
            </tr>

            <tr>
                <td><label for="newQty">Change Quantity</label></td>
                <td><input type="text" class="form-control" id="newQty" name="newQty" aria-describedby="newQty"
                           value="${param.partQty}"></td>
            </tr>

            <tr>
                <td><label for="newCost">Change Cost</label></td>
                <td><input type="text" class="form-control" id="newCost" name="newCost" aria-describedby="newCost"
                           value="${param.partCost}"></td>
            </tr>
        </table>
        <input type="hidden" id="partNum" name="partNum" value="${param.partNum}">
        <input type="hidden" id="partType" name="partType" value="chipAmp">
        <br>

        <button type="submit" name="submit" value="editChipAmp" class="btn btn-primary">Edit ChipAmp</button>
        <button type="submit" name="submit" value="deleteChipAmp" class="btn btn-primary">Delete ChipAmp</button>
        <a href="adminChipAmpAdd.jsp">
            <button type="button" class="btn btn-primary">Add New ChipAmp</button>
        </a>

    </div>

</form>

<a href="chipAmpSearch.jsp">Return to Search ChipAmps</a><br>
<a href="index.jsp">Return to Index</a><br>

</body>
</html>