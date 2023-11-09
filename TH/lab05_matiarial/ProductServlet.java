package controller;

import entity.Product;
import service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static final ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        /product?action=del&id=1
        String action = request.getParameter("action");
        String id = request.getParameter("id");
        if (action != null && action.equals("del") && id != null) {
            Product product = productService.findById(Integer.parseInt(id));
            if (product != null) {
                productService.delete(product);
                request.setAttribute("message", "Delete product successfully");
                request.setAttribute("type", "success");
            } else {
                request.setAttribute("message", "Cannot delete product");
                request.setAttribute("type", "danger");
            }
        }

        List<Product> products = (List<Product>) productService.findAll();
        request.setAttribute("products", products);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name").trim();
        String price = request.getParameter("price").trim();

        Product product = productService.save(new Product(name, Double.parseDouble(price)));
        if (product == null) {
            request.setAttribute("message", "Cannot add product");
            request.setAttribute("type", "danger");
        } else {
            request.setAttribute("message", "Add product successfully");
            request.setAttribute("type", "success");
        }

        List<Product> products = (List<Product>) productService.findAll();
        request.setAttribute("products", products);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}