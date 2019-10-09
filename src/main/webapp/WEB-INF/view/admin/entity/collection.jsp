<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>К О Л Л Е К Ц И Я</title>
    <link href="<c:url value="/res/css/admin.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/res/css/w3.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>

<jsp:include page="../header.jsp"/>
<div class = "w3-container table-container">
    <h2>К О Л Л Е К Ц И Я</h2>
    <table class="w3-table-all w3-hoverable">
        <tr class="w3-light-grey">
            <th>id</th>
            <th></th>
        </tr>
            <tr>
                <td>${collection.id}</td>
                <td>
                    <a href="${baseURL}/edit/${collection.id}">Редактировать</a>
                    <a href="${baseURL}/delete/${collection.id}">Удалить</a>
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