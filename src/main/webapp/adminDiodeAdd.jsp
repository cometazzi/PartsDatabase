<%@include file="taglib.jsp" %>
<c:import url="head.jsp"/>
<%@page errorPage="error.jsp" %>
<html>
<body>

<h1>Add New Diode</h1>


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
    <input type="hidden" id="partType" name="partType" value="diode">
    <br>

    <button type="submit" name="submit" value="addNewDiode" class="btn btn-primary">Add New Diode</button>

    <a href="diodeSearch.jsp">
      <button type="button" class="btn btn-primary">Cancel</button>
    </a>

  </div>

</form>

<a href="diodeSearch.jsp">Return to Search Diodes</a><br>
<a href="index.jsp">Return to Index</a><br>

</body>
</html>