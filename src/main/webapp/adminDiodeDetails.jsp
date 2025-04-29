<%@include file="taglib.jsp" %>
<c:import url="head.jsp"/>
<%@page errorPage="error.jsp" %>
<html>
<body>

<script type="text/javascript" class="init">
    $(document).ready(function () {
        $('#diodeTable').DataTable({searching: false});
    });
</script>

<h2>${param.partNum} Details</h2>

<table id="diodeTable" class="display" cellspacing="0" width="100%">
    <thead>
    <th>Part Number</th>
    <th>Description</th>
    <th>Quantity</th>
    <th>Package Type</th>
    <th>Cost</th>
    </thead>
    <tbody>

    <tr>
        <td>${param.partNum}</td>
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
                        <option value="15">whiteLED</option>
                        <option value="16">bicolorLED</option>
                        <option value="17">redLED</option>
                        <option value="18">blueLED</option>
                        <option value="19">yellowLED</option>
                        <option value="20">orangeLED</option>
                        <option value="21">DO-3</option>
                        <option value="27">DO-4</option>
                        <option value="22">DO-5</option>
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
        <input type="hidden" id="partType" name="partType" value="diode">
        <br>

        <button type="submit" name="submit" value="editDiode" class="btn btn-primary">Edit Diode</button>
        <button type="submit" name="submit" value="deleteDiode" class="btn btn-primary">Delete Diode</button>
        <a href="adminDiodeAdd.jsp">
            <button type="button" class="btn btn-primary">Add New Diode</button>
        </a>

    </div>

</form>

<a href="diodeSearch.jsp">Return to Search Diodes</a><br>
<a href="index.jsp">Return to Index</a><br>

</body>
</html>