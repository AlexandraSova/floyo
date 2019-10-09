<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Т О В А Р Ы</title>
    <link href="<c:url value="/res/css/admin.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/res/css/w3.css"/>" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/res/js/jquery-3.4.1.js"></script>
    <script src = "/res/js/choosen.js"></script>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="w3-container table-container">
    <c:if test="${empty product.id}">
        <c:url value="${baseURL}/add" var="var"/>
        <h2>Д О Б А В И Т Ь</h2>
    </c:if>
    <c:if test="${!empty product.id}">
        <c:url value="${baseURL}/edit" var="var"/>
        <h2>И З М Е Н И Т Ь</h2>
    </c:if>
    <form action="${var}" method="POST">
        <c:if test="${!empty product.id}">
            <input type="hidden" name="id" value="${product.id}">

        </c:if>

        <label for="name">name</label>
        <input type="text" name="name" id="name" value="${product.name}">

        <label for="article">article</label>
        <input type="text" name="article" id="article" value="${product.article}">

        <label for="category.id">category</label>
        <select class="chosen" id="category.id" name="category.id">
            <option hidden disabled selected value> -- выбрать категорию --</option>
            <c:forEach var="category" items="${categoriesList}">
                <c:if test="${category.id.equals(product.category.id)}">
                    <option value="${product.category.id}"
                            selected>${product.category.id}, ${product.category.name}</option>
                </c:if>
                <c:if test="${!category.id.equals(product.category.id)}">
                    <option value="${category.id}">${category.id}, ${category.name}</option>
                </c:if>
            </c:forEach>
        </select>

        <label for="collection.id">collection</label>
        <select class="chosen" id="collection.id" name="collection.id">
            <option hidden disabled selected value> -- выбрать коллекцию --</option>
            <c:forEach var="collection" items="${collectionsList}">
                <c:if test="${collection.id.equals(product.collection.id)}">
                    <option value="${product.collection.id}" selected>${product.collection.id}</option>
                </c:if>
                <c:if test="${!collection.id.equals(product.collection.id)}">
                    <option value="${collection.id}">${collection.id}</option>
                </c:if>
            </c:forEach>
        </select>

        <label for="characteristic_code">characteristic_code</label>
        <input type="text" name="characteristic_code" id="characteristic_code" value="${product.characteristic_code}">

        <label for="size.id">size</label>
        <select class="chosen" id="size.id" name="size.id">
            <option hidden disabled selected value> -- выбрать размер --</option>
            <c:forEach var="size" items="${sizesList}">
                <c:if test="${size.id.equals(product.size.id)}">
                    <option value="${product.size.id}" selected>${product.size.id}</option>
                </c:if>
                <c:if test="${!size.id.equals(product.size.id)}">
                    <option value="${size.id}">${size.id}</option>
                </c:if>
            </c:forEach>
        </select>

        <label for="characteristic_name">characteristic_name</label>
        <input type="text" name="characteristic_name" id="characteristic_name" value="${product.characteristic_name}">

        <label for="amount">amount</label>
        <input type="number" name="amount" id="amount" value="${product.amount}">

        <label for="price">price</label>
        <input type="number" name="price" id="price" value="${product.price}">

        <label for="discount">discount</label>
        <input type="number" name="discount" id="discount" value="${product.discount}">

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