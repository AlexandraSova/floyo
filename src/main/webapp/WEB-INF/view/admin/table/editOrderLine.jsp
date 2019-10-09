<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>П У Н К Т Ы    З А К А З А</title>
    <link href="<c:url value="/res/css/admin.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/res/css/w3.css"/>" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/res/js/jquery-3.4.1.js"></script>
    <script src = "/res/js/choosen.js"></script>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="w3-container table-container">
    <c:if test="${empty orderline.id}">
        <c:url value="${baseURL}/add" var="var"/>
        <h2>Д О Б А В И Т Ь</h2>
    </c:if>
    <c:if test="${!empty orderline.id}">
        <c:url value="${baseURL}/edit" var="var"/>
        <h2>И З М Е Н И Т Ь</h2>
    </c:if>
    <form action="${var}" method="POST">
        <c:if test="${!empty orderline.id}">
            <input type="hidden" name="id" value="${orderline.id}">
        </c:if>

        <label for="product.id">product</label>
        <select class="chosen" name="product.id" id="product.id">
            <option hidden disabled selected value> -- выбрать продукт --</option>
            <c:forEach var="product" items="${productsList}">
                <c:if test="${product.id.equals(orderline.product.id)}">
                    <option title="${product.toString()}" value="${product.id}"
                            selected>${product.article}</option>
                </c:if>
                <c:if test="${!product.id.equals(orderline.product.id)}">
                    <option title="${product.toString()}"
                            value="${product.id}">${product.article}</option>
                </c:if>
            </c:forEach>
        </select>

        <label for="amount">amount</label>
        <input type="number" name="amount" id="amount" value="${orderline.amount}">

        <label for="order.id">order</label>
        <select class="chosen" name="order.id" id="order.id">
            <option hidden disabled selected value> -- выбрать заказ --</option>
            <c:forEach var="order" items="${ordersList}">
                <c:if test="${order.id.equals(orderline.order.id)}">
                    <option title="${order.toString()}" value="${order.id}"
                            selected>${order.id}</option>
                </c:if>
                <c:if test="${!order.id.equals(orderline.order.id)}">
                    <option title="${order.toString()}"
                            value="${order.id}">${order.id}</option>
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