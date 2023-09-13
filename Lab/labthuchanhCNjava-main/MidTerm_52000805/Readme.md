- This web application is built on the Spring Boot platform and constructed with Maven using the Java language. It integrates platforms such as Thymeleaf and Hibernate.

- This web application works by the user sending a request to the server, and from the server sending a request to the API. The API then responds to the server, which in turn responds to the user.(client-server architecture)

- Step by step run this project: 

    + Download XAMPP or a similar application.

    + Install the necessary tools: Make sure you have the Java Development Kit (JDK) and a build tool Maven installed on your computer.

    + Download the project: Download this project source code.

    + Import file spring_ecommerce.sql in XAMPP or a similar application.

    + Build the project: Navigate to the project directory and use the build tool to build the project.

    + Run the project: Once the project is built, you can run it using the build tool.

    + Access the application: Once the application is running, you can access it by opening a web browser and navigating to http://localhost:8080, assuming that the application is configured to run on port 8080.

- Full CURL commands or Postman snapshots to verify the APIs

    + cURL: "/api/brand/get-all"
![brand get all](./cURL/brand-get-all.png)

    + cURL: "/api/cart/add"
![brand get all](./cURL/cart-add.png)

    + cURL: "/api/cart/total/{id}"
![brand get all](./cURL/cart-cal-total-by-user-id.png)

    + cURL: "/api/cart/delete/{id}"
![brand get all](./cURL/cart-delete-by-id.png)

    + cURL: /api/cart/all-by-id/{id}"
![brand get all](./cURL/cart-find-by-user-id.png)

    + cURL: "/api/category/get-all"
![brand get all](./cURL/category-get-all.png)

    + cURL: "/api/customer/find/{id}"
![brand get all](./cURL/customer-find-by-id.png)

    + cURL: "/api/cart/delete/{id}"
![brand get all](./cURL/customer-update.png)

    + cURL: "/api/order/add"
![brand get all](./cURL/order-add.png)

    + cURL: "/api/product/find-by-brand-id/{id}"
![brand get all](./cURL/product-find-by-brand-id.png)

    + cURL: "/api/product/find/{id}"
![brand get all](./cURL/product-find-by-id.png)

    + cURL: "/api/product/get-all"
![brand get all](./cURL/product-get-all.png)

    + cURL: "/api/product/search/{id}"
![brand get all](./cURL/product-search-by-range.png)

    + cURL: "/api/auth/login/user-valid"
![brand get all](./cURL/user-check-valid.png)

    + cURL: "/api/user/add"
![brand get all](./cURL/user-signup.png)
