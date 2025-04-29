<%@include file="taglib.jsp" %>
<c:import url="head.jsp"/>
<%@page errorPage="error.jsp" %>
<html>
<body>

<script type="text/javascript" class="init">
  $(document).ready(function () {
    $('#linearICTable').DataTable({searching: false});
  });
</script>

<h2>${param.partNum} Details</h2>

<table id="linearICTable" class="display" cellspacing="0" width="100%">
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
          <select name="newPkg" id="newPkg value=${param.partPackage}">
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
    <input type="hidden" id="partType" name="partType" value="linearIC">
    <br>

    <button type="submit" name="submit" value="editLinearIC" class="btn btn-primary">Edit LinearIC</button>
    <button type="submit" name="submit" value="deleteLinearIC" class="btn btn-primary">Delete LinearIC</button>
    <a href="adminLinearICAdd.jsp">
      <button type="button" class="btn btn-primary">Add New LinearIC</button>
    </a>

  </div>

</form>

<a href="linearICSearch.jsp">Return to Search LinearICs</a><br>
<a href="index.jsp">Return to Index</a><br>

</body>
</html>