<%@include file="taglib.jsp" %>
<%@page errorPage="error.jsp" %>
<c:set var="title" value="${transistor.partNum} Details"/>
<c:import url="head.jsp"/>

<html>
<body>

<div class="container-fluid">
    <h2>${title}</h2>

    <h4>Database Details:</h4>
    <dl class="row">
        <dt class="col-sm-3">Part Number:</dt>
        <dd class="col-sm-9">${transistor.partNum}</dd>

        <dt class="col-sm-3">Technology:</dt>
        <dd class="col-sm-9">${transistor.technology}</dd>

        <dt class="col-sm-3">Description:</dt>
        <dd class="col-sm-9">${transistor.descr}</dd>

        <dt class="col-sm-3">Quantity:</dt>
        <dd class="col-sm-9">${transistor.qty}</dd>

        <dt class="col-sm-3">Package Type:</dt>
        <dd class="col-sm-9">${transistor.packageName}</dd>

        <dt class="col-sm-3">Cost:</dt>
        <dd class="col-sm-9">${transistor.cost}</dd>

        </dd>
    </dl>

    <form action="ManageParts" class="form-inline">
        <div class="form-group">
            <label for="newQty">Change Quantity</label>
            <input type="text" class="form-control" id="newQty" name="newQty" aria-describedby="newQty"
                   value="${transistor.qty}">
            <input type="hidden" id="partNum" name="partNum" value="${param.partNum}">
            <input type="hidden" id="partType" name="partType" value="transistor">
        </div>
        <button type="submit" name="submit" value="changeQty" class="btn btn-primary">Update Quantity</button>
    </form>

    <br>
    <h4>Market Details Provided by Mouser.com:</h4>
    <c:if test="${not empty apiPart}">
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
                <a href="${apiPart.dataSheetUrl}" target="_blank">Click Here</a>
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
    <p><a href="transistorSearch.jsp">Back to Transistor Search</a></p>
    <p><a href="index.jsp">Back to Part Search</a></p>
</div>

</body>
</html>