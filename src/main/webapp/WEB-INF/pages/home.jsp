<%@ page isELIgnored="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<div align="center">
    <h1>Item List</h1>
    <table border="1">

        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Action</th>

        <c:forEach var="product" items="${listItems}">
            <tr>

                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td><a href="editItem?id=${product.id}">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp; <a href="deleteItem?id=${product.id}">Delete</a></td>

            </tr>
        </c:forEach>
    </table>
    <h4>
        Add new Item <a href="newItem">here</a>
    </h4>
</div>
</body>
</html>
