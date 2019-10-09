<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Т О В А Р Ы</title>
    <link href="<c:url value="/res/css/admin.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/res/css/w3.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>

<jsp:include page="../header.jsp"/>
<div class = "w3-container table-container">
<h2>Т О В А Р Ы</h2>
<table class="w3-table-all w3-hoverable">
    <tr class="w3-light-grey">
        <th>id</th>
        <th>name</th>
        <th>article</th>
        <th>category</th>
        <th>collection</th>
        <th>characteristic_code</th>
        <th>size</th>
        <th>characteristic_name</th>
        <th>amount</th>
        <th>price</th>
        <th>discount</th>
        <th></th>
    </tr>
    <c:forEach var="product" items="${productsList}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.article}</td>
            <td>${product.category.id}</td>
            <td>${product.collection.id}</td>
            <td>${product.characteristic_code}</td>
            <td>${product.size.id}</td>
            <td>${product.characteristic_name}</td>
            <td>${product.amount}</td>
            <td>${product.price}</td>
            <td>${product.discount}</td>
            <td>
                <a href="${baseURL}/edit/${product.id}">Редактировать</a>
                <a href="${baseURL}/delete/${product.id}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>

<button onclick="location.href='${baseURL}/add'" class="w3-button w3-black w3-section" type="button">
    <i class="fa fa-paper-plane"></i> Д О Б А В И Т Ь
</button>
</div>>
<jsp:include page="../footer.jsp"/>

</body>
</html>