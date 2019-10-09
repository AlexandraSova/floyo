<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Г О Р О Д</title>
    <link href="<c:url value="/res/css/admin.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/res/css/w3.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>

<jsp:include page="../header.jsp"/>
<div class = "w3-container table-container">
    <h2>Г О Р О Д</h2>
    <table class="w3-table-all w3-hoverable">
        <tr class="w3-light-grey">
            <th>id</th>
            <th>name</th>
            <th>country</th>
            <th>region</th>
            <th></th>
        </tr>
            <tr>
                <td>${city.id}</td>
                <td>${city.name}</td>
                <td>${city.country}</td>
                <td>${city.region}</td>
                <td>
                    <a href="${baseURL}/edit/${city.id}">Редактировать</a>
                    <a href="${baseURL}/delete/${city.id}">Удалить</a>
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