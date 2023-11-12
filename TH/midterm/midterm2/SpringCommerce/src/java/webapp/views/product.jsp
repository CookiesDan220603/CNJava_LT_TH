<%@ page import="store.springcommerce.model.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Product Page</title>
</head>
<body>
<h1>Product List</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <%!
        private Product[] products;
    %><% for (Product product : products) { %>
    <tr>
        <td><%= product.getId() %></td>
        <td><%= product.getName() %></td>
        <td><%= product.getPrice() %></td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
```

Trong ví dụ trên, chúng ta sử dụng vòng lặp để lặp qua danh sách sản phẩm và hiển thị thông tin về mỗi sản phẩm trong bảng.