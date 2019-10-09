<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>З А К А З Ы</title>
    <link href="<c:url value="/res/css/admin.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/res/css/w3.css"/>" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/res/js/jquery-3.4.1.js"></script>
    <script src = "/res/js/choosen.js"></script>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="w3-container table-container">
    <c:if test="${empty order.id}">
        <c:url value="${baseURL}/add" var="var"/>
        <h2>Д О Б А В И Т Ь</h2>
    </c:if>
    <c:if test="${!empty order.id}">
        <c:url value="${baseURL}/edit" var="var"/>
        <h2>И З М Е Н И Т Ь</h2>
    </c:if>
    <form action="${var}" method="POST">
        <c:if test="${!empty order.id}">
            <input type="hidden" name="id" value="${order.id}">
        </c:if>

        <label for="date">date</label>
        <input type="date" name="date" id="date" value="${order.date}">

        <label for="time">time</label>
        <input type="time" name="time" id="time" value="${order.time}">

        <label for="client.id">client id</label>
        <select class="chosen" name="client.id" id="client.id">
            <option hidden disabled selected value> -- выбрать клиента --</option>
            <c:forEach var="client" items="${clientsList}">
                <c:if test="${client.id.equals(order.client.id)}">
                    <option value="${client.id}" selected>${client.name}, ${client.phone}, ${client.mail}, ${client.city.toUserString()}</option>
                </c:if>
                <c:if test="${!client.id.equals(order.client.id)}">
                    <option value="${client.id}">${client.name}, ${client.phone}, ${client.mail}, ${client.city.toUserString()}</option>
                </c:if>
            </c:forEach>
        </select>

        <label for="delivery.id">delivery id</label>
        <select class="chosen" name="delivery.id" id="delivery.id">
            <option hidden disabled selected value> -- выбрать доставку --</option>
            <c:forEach var="delivery" items="${deliveriesList}">
                <c:if test="${delivery.id.equals(order.delivery.id)}">
                    <option value="${delivery.id}" selected>${delivery.name} (${delivery.price} р.)</option>
                </c:if>
                <c:if test="${!delivery.id.equals(order.delivery.id)}">
                    <option value="${delivery.id}">${delivery.name} (${delivery.price} р.)</option>
                </c:if>
            </c:forEach>
        </select>

        <label for="comment">comment</label>
        <input type="text" name="comment" id="comment" value="${order.comment}">

        <label for="status.id">status</label>
        <select class="chosen" name="status.id" id="status.id">
            <option hidden disabled selected value> -- выбрать статус --</option>
            <c:forEach var="status" items="${statusesList}">
                <c:if test="${status.id.equals(order.status.id)}">
                    <option value="${status.id}" selected>${status.id}</option>
                </c:if>
                <c:if test="${!status.id.equals(order.status.id)}">
                    <option value="${status.id}">${status.id}</option>
                </c:if>
            </c:forEach>
        </select>

        <button class="w3-button w3-black w3-section" type="submit">
            <i class="fa fa-paper-plane"></i> С О Х Р А Н И Т Ь
        </button>

    </form>
</div>
<script type="text/javascript">
    $(".chosen").chosen();
</script>
<jsp:include page="../footer.jsp"/>
</body>
</html>