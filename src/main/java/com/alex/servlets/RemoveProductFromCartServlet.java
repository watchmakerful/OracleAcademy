package com.alex.servlets;

import com.alex.entity.Product;
import com.alex.service.api.ProductService;
import com.alex.service.api.UserService;
import com.alex.service.impl.ProductServiceImpl;
import com.alex.service.impl.UserServiceImpl;
import com.alex.utils.Transformer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Алексей on 13.08.2016.
 */
public class RemoveProductFromCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        long userId = (Long) (session.getAttribute("user"));
        long productId = Long.parseLong(request.getParameter("productid"));
//
        ProductService productService = ProductServiceImpl.getInstance();
        Product currentProduct = Transformer.transformProductDtoToProduct(productService.getProductById(productId));
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        for (Product product : cart) {
            if (product.getId() == currentProduct.getId()) {
                cart.remove(product);
                break;
            }
        }



        session.setAttribute("cart", cart);


        response.sendRedirect("userinfo.jsp");


    }
}
