<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>З А К А З Ы</title>
    <link href="<c:url value="/res/css/admin.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/res/css/w3.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>

<jsp:include page="../header.jsp"/>
<div class="w3-container table-container">
    <h2>З А К А З Ы</h2>
    <table class="w3-table-all w3-hoverable">
        <tr class="w3-light-grey">
            <th>id</th>
            <th>Дата</th>
            <th>Время</th>
            <th>Клиент</th>
            <th>Состав заказа</th>
            <th>Адрес доставки</th>
            <th>Доставка</th>
            <th>Комментарий</th>
            <th>Статус</th>
            <th>Сумма заказа</th>
            <th></th>
        </tr>
        <c:forEach var="order" items="${ordersList}">
            <tr>
                <td>${order.id}</td>
                <td>${order.date}</td>
                <td>${order.time}</td>
                <td>
                    <ul class="w3-ul">
                        <li>Имя: ${order.client.name}</li>
                        <li>Телефон: ${order.client.phone}</li>
                        <li>e-mail: ${order.client.mail}</li>
                    </ul>
                </td>
                <td>
                    <ul class="w3-ul">
                        <c:forEach var="orderline" items="${order.orderLineEntities}">
                            <li>
                                <ul class="w3-ul">
                                    <li>Товар:
                                        <a title="${orderline.product.toString()}"
                                           href="${baseProductURL}/${orderline.product.id}">
                                                ${orderline.product.article}
                                        </a>
                                    </li>
                                    <li>Количество: ${orderline.amount}</li>
                                </ul>
                            </li>
                        </c:forEach>
                    </ul>
                </td>
                <td>
                    ${order.client.city.toUserString()}, ${order.address}
                </td>
                <td>${order.delivery.name}, ${order.delivery.price} р.</td>
                <td>${order.comment}</td>
                <td>${order.status.id}</td>
                <td>Посчитать</td>
                <td>
                    <a href="${baseURL}/edit/${order.id}">Редактировать</a>
                    <a href="${baseURL}/delete/${order.id}">Удалить</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <button onclick="location.href='${baseURL}/add'" class="w3-button w3-black w3-section" type="button">
        <i class="fa fa-paper-plane"></i> Д О Б А В И Т Ь
    </button>
</div>
<jsp:include page="../footer.jsp"/>

</body>
</html>