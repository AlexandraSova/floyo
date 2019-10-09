<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>К О Л Л Е К Ц И И</title>
    <link href="<c:url value="/res/css/admin.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/res/css/w3.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="w3-container table-container">
    <c:if test="${empty collection.id}">
        <c:url value="${baseURL}/add" var="var"/>
        <h2>Д О Б А В И Т Ь</h2>
    </c:if>
    <c:if test="${!empty collection.id}">
        <c:url value="${baseURL}/edit" var="var"/>
        <h2>И З М Е Н И Т Ь</h2>
    </c:if>
    <form action="${var}" method="POST">
        <label for="id">name</label>
        <input type="number" name="id" id="id" value="${collection.id}">

        <button class="w3-button w3-black w3-section" type="submit">
            <i class="fa fa-paper-plane"></i> С О Х Р А Н И Т Ь
        </button>

    </form>
</div>
<jsp:include page="../footer.jsp"/>
</body>
</html>