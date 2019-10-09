<%@ page import="ru.floyo.admin.controller.entity.*" %>
<%@ page import="ru.floyo.admin.controller.AdminHomeController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Navbar (sit on top) -->
<div class="w3-top">
    <div class="w3-bar w3-white w3-wide w3-padding w3-card">
        <a href="<%=AdminHomeController.baseURL%>" class="w3-bar-item w3-button"><b>F L O Y O</b></a>
        <!-- Float links to the right. Hide them on small screens -->
        <div class="w3-right w3-hide-small">
            <a href="<%=CityController.baseURL%>" class="w3-bar-item w3-button admin_header_item">Города</a>
            <a href="<%=CategoryController.baseURL%>" class="w3-bar-item w3-button admin_header_item">Категории</a>
            <a href="<%=CollectionController.baseURL%>" class="w3-bar-item w3-button admin_header_item">Коллекции</a>
            <a href="<%=SizeController.baseURL%>" class="w3-bar-item w3-button admin_header_item">Размеры</a>
            <a href="<%=DeliveryController.baseURL%>" class="w3-bar-item w3-button admin_header_item">Доставка</a>
            <a href="<%=OrderLineController.baseURL%>" class="w3-bar-item w3-button admin_header_item">Пункты</a>
            <a href="<%=OrderStatusController.baseURL%>" class="w3-bar-item w3-button admin_header_item">Статусы</a>
            <a href="<%=ClientController.baseURL%>" class="w3-bar-item w3-button admin_header_item">Клиенты</a>
            <a href="<%=ProductController.baseURL%>" class="w3-bar-item w3-button admin_header_item">Товары</a>
            <a href="<%=OrderController.baseURL%>" class="w3-bar-item w3-button admin_header_item">Заказы</a>
        </div>
    </div>
</div>