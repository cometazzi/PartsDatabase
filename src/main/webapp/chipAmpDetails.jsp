<%@include file="taglib.jsp" %>
<c:import url="head.jsp"/>
<%@page errorPage="error.jsp" %>
<html>
<body>

<div class="container-fluid">
    <h2>${title}</h2>

    <h4>Database Details:</h4>
    <dl class="row">
        <dt class="col-sm-3">Part Number:</dt>
        <dd class="col-sm-9">${chipAmp.partNum}</dd>

        <dt class="col-sm-3">Technology:</dt>
        <dd class="col-sm-9">${chipAmp.technology}</dd>

        <dt class="col-sm-3">Description:</dt>
        <dd class="col-sm-9">${chipAmp.descr}</dd>

        <dt class="col-sm-3">Quantity:</dt>
        <dd class="col-sm-9">${chipAmp.qty}</dd>

        <dt class="col-sm-3">Package Type:</dt>
        <dd class="col-sm-9">${chipAmp.packageName}</dd>

        <dt class="col-sm-3">Cost:</dt>
        <dd class="col-sm-9">${chipAmp.cost}</dd>

        </dd>
    </dl>
    <form action="ManageParts" class="form-inline">
        <div class="form-group">
            <label for="newQty">Change Quantity</label>
            <input type="text" class="form-control" id="newQty" name="newQty" aria-describedby="newQty"
                   value="${chipAmp.qty}">
            <input type="hidden" id="partNum" name="partNum" value="${param.partNum}">
            <input type="hidden" id="partType" name="partType" value="chipAmp">
        </div>
        <button type="submit" name="submit" value="changeQty" class="btn btn-primary">Update Quantity</button>
    </form>
    <br>
    <c:if test="${not empty apiPart}">
        <h4>Market Details Provided by Mouser.com:</h4>
        <dl class="row">
            <dt class="col-sm-3">Mouser Part Number:</dt>
            <dd class="col-sm-9">${apiPart.mouserPartNumber}</dd>

            <dt class="col-sm-3">Availability:</dt>
            <dd class="col-sm-9">${apiPart.availability}</dd>

            <dt class="col-sm-3">Description (Mouser):</dt>
            <dd class="col-sm-9">${apiPart.description}</dd>

            <dt class="col-sm-3">Price For 1:</dt>
            <dd class="col-sm-9">${apiPart.currency} ${apiPart.priceFor1}</dd>

            <dt class="col-sm-3">Price For 10:</dt>
            <dd class="col-sm-9">${apiPart.currency} ${apiPart.priceFor10}</dd>

            <dt class="col-sm-3">Price For 100:</dt>
            <dd class="col-sm-9">${apiPart.currency} ${apiPart.priceFor100}</dd>

            <dt class="col-sm-3">Datasheet (Mouser):</dt>
            <dd class="col-sm-9">
                <c:if test="${empty apiPart.dataSheetUrl}">
                    <p>Datasheet Not Available</p>
                </c:if>
                <c:if test="${not empty apiPart.dataSheetUrl}">
                    <a href="${apiPart.dataSheetUrl}" target="_blank">Click Here</a>
                </c:if>
            </dd>
        </dl>
    </c:if>
    <c:if test="${empty apiPart}">
        <p>Mouser market data not available for this part.</p>
    </c:if>
    <c:if test="${not empty mouserError}">
        <p class="text-danger">${mouserError}</p>
    </c:if>

    <br>
    <p><a href="chipAmpSearch.jsp">Back to ChipAmp Search</a></p>
    <p><a href="index.jsp">Back to Part Search</a></p>
</div>

</body>
</html>