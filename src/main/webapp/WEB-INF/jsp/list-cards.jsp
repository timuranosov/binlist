<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <br>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3>Cards</h3>
        </div>
        <br>
        <form action="/card" method="get" id="searchCardForm" role="form">
            <input type="hidden" id="searchAction" name="searchAction" value="searchByBin">
            <div class="form-group col-xs-6">
                <input type="text" name="bin" id="binId" class="form-control"
                       required minlength="6" maxlength="6"
                       pattern="\d*"
                       placeholder="Enter the first 6 digits of your credit/debit card"/>
            </div>
            <button type="submit" class="btn btn-info">
                <span class="glyphicon glyphicon-search"></span> Search
            </button>
            <br>
            <br>
        </form>
        <div class="panel-body">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th width="20%">Scheme/Network</th>
                    <th width="10%">Type</th>
                    <th width="20%">Bank</th>
                    <th width="10%">Brand</th>
                    <th width="10%">Prepaid</th>
                    <th width="10%">Length</th>
                    <th width="20%">Country</th>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${not empty cards}">
                        <c:forEach items="${cards}" var="card">
                            <tr>
                                <td>${fn:toUpperCase(card.scheme)}</td>
                                <td>${fn:toUpperCase(card.type)}</td>
                                <td>${card.bank.name}</td>
                                <td>${card.brand}</td>
                                <td>${card.prepaid}</td>
                                <td>${card.cardNumber.length}</td>
                                <td>${card.country.name}</td>
                            </tr>
                        </c:forEach>
                    </c:when>
                </c:choose>
                </tbody>
            </table>
        </div>
    </div>
</div>