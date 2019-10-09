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
    <h2>Д О С Т А В К А</h2>
    <table class="w3-table-all w3-hoverable">
        <tr class="w3-light-grey">
            <th>id</th>
            <th>name</th>
            <th>price</th>
            <th></th>
        </tr>
            <tr>
                <td>${delivery.id}</td>
                <td>${delivery.name}</td>
                <td>${delivery.price}</td>
                <td>
                    <a href="${baseURL}/edit/${delivery.id}">Редактировать</a>
                    <a href="${baseURL}/delete/${delivery.id}">Удалить</a>
                </td>
            </tr>
    </table>

    <button onclick="location.href='${baseURL}/add'" class="w3-button w3-black w3-section" type="button">
        <i class="fa fa-paper-plane"></i> Д О Б А В И Т Ь
    </button>
</div>
<jsp:include page="../footer.jsp"/>

</body>
</html>