package com.example.lab05.Servlet;

import com.example.lab05.DAO.ProductDAO;
import com.example.lab05.Model.Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private ProductDAO productDAO;
    @Override
    public void init(){
        productDAO = ProductDAO.getInstance();
        productDAO.add(new Product(1,"iphone 11","black",4500000));
        productDAO.add(new Product(2,"iphone 12","white",4500000));
        productDAO.add(new Product(3,"iphone 13","red",4500000));
        productDAO.add(new Product(4,"iphone 14","golden",44500000));
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String prodDelID = req.getParameter("prodDelID");
        if(prodDelID != null){
            productDAO.delete(Integer.parseInt(prodDelID));
        }
        List<Product> listProducts = productDAO.readAll();
        String message = "";
        req.setAttribute("listProducts", listProducts);
        req.setAttribute("message",message);
        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        rd.forward(req , resp);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String price = req.getParameter("numPrice");
        String message = "";
        // post add new prod
        if(!(Objects.equals(name, "") || Objects.equals(price, "")))
            productDAO.add(new Product(name,Integer.parseInt(price)));
        else
            message = "Vui lòng nhập đầy đủ thông tin";
        // show all prod
        req.setAttribute("message",message);
        List<Product> listProducts = productDAO.readAll();
        req.setAttribute("listProducts", listProducts);
        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        rd.forward(req , resp);
    }
        public void destroy(){
        productDAO.close();
    }
}
