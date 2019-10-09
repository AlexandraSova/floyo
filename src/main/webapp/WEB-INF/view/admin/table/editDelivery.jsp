<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Д О С Т А В К А</title>
    <link href="<c:url value="/res/css/admin.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/res/css/w3.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="../header.jsp"/>

<div class = "w3-container table-container">
    <c:if test="${empty delivery.id}">
        <c:url value="${baseURL}/add" var="var"/>
        <h2>Д О Б А В И Т Ь</h2>
    </c:if>
    <c:if test="${!empty delivery.id}">
        <c:url value="${baseURL}/edit" var="var"/>
        <h2>И З М Е Н И Т Ь</h2>
    </c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty delivery.id}">
        <input type="hidden" name="id" value="${delivery.id}">
    </c:if>

    <label for="name">name</label>
    <input type="text" name="name" id="name" value="${delivery.name}">

    <label for="price">mail</label>
    <input type="number" name="price" id="price" value="${delivery.price}">

    <button class="w3-button w3-black w3-section" type="submit">
        <i class="fa fa-paper-plane"></i> С О Х Р А Н И Т Ь
    </button>
</div>
</form>
<jsp:include page="../footer.jsp"/>
</body>
</html>