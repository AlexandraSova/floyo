<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>К Л И Е Н Т Ы</title>
    <link href="<c:url value="/res/css/admin.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/res/css/w3.css"/>" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/res/js/jquery-3.4.1.js"></script>
    <script src="/res/js/choosen.js"></script>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="w3-container table-container">
    <c:if test="${empty client.id}">
        <c:url value="${baseURL}/add" var="var"/>
        <h2>Д О Б А В И Т Ь</h2>
    </c:if>
    <c:if test="${!empty client.id}">
        <c:url value="${baseURL}/edit" var="var"/>
        <h2>И З М Е Н И Т Ь</h2>
    </c:if>
    <form action="${var}" method="POST">
        <c:if test="${!empty client.id}">
            <input type="hidden" name="id" value="${client.id}">
            <input type="hidden" name="client.city.id" value="${client.city.id}">
        </c:if>

        <label for="name">name</label>
        <input type="text" name="name" id="name" value="${client.name}">

        <label for="mail">mail</label>
        <input type="text" name="mail" id="mail" value="${client.mail}">

        <label for="phone">phone</label>
        <input type="text" name="phone" id="phone" value="${client.phone}">

        <label for="city.id">city</label>
        <select class="chosen" name="city.id" id="city.id">
            <option hidden disabled selected value> -- выбрать город --</option>
            <c:forEach var="city" items="${citiesList}">
                <c:if test="${city.id.equals(client.city.id)}">
                    <option selected value="${city.id}">${city.toUserString()}</option>
                </c:if>
                <c:if test="${!city.id.equals(client.city.id)}">
                    <option value="${city.id}">${city.toUserString()}</option>
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