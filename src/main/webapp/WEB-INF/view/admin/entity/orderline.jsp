<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>П У Н К Т  З А К А З А</title>
    <link href="<c:url value="/res/css/admin.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/res/css/w3.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>

<jsp:include page="../header.jsp"/>
<div class="w3-container table-container">
    <h2>П У Н К Т  З А К А З А</h2>
    <table class="w3-table-all w3-hoverable">
        <tr class="w3-light-grey">
            <th>id</th>
            <th>product</th>
            <th>amount</th>
            <th>order</th>
            <th></th>
        </tr>
            <tr>
                <td>${orderline.id}</td>
                <td>
                    <a title="${orderline.product.toString()}"
                       href="${baseProductURL}/${orderline.product.id}">
                            ${orderline.product.article}
                    </a>
                </td>
                <td>${orderline.amount}</td>
                <td>
                    <a title="${orderline.order.toString()}"
                       href="${baseOrderURL}/${orderline.order.id}">
                            ${orderline.order.id}
                    </a>
                </td>
                <td>
                    <a href="${baseURL}/edit/${orderline.id}">Редактировать</a>
                    <a href="${baseURL}/delete/${orderline.id}">Удалить</a>
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