package com.alex.servlets;

import com.alex.dto.ProductDto;
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
 * Created by Алексей on 10.08.2016.
 */
public class AddProductToCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Long userId = (Long) (session.getAttribute("user"));
        Long productId = Long.parseLong(request.getParameter("productid"));
        if (userId == null) {
            response.sendRedirect("login.html");
            return;
        }


        ProductService productService = ProductServiceImpl.getInstance();
        Product currentProduct = Transformer.transformProductDtoToProduct(productService.getProductById(productId));
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        boolean productExists = false;
        boolean added = true;
        for (Product product : cart) {
            if ((product.getId() == productId)) {
                if (product.getCount() < currentProduct.getCount())
                    product.setCount(product.getCount() + 1);
                else added = false;
                productExists = true;
            }
        }

        if (!productExists) {
            currentProduct.setCount(1);
            cart.add(currentProduct);
        }


        session.setAttribute("cart", cart);


        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        if (added)
            out.println("<h3> Product added successfully. </h3>");
        else
            out.println("<h3> Can't add this product anymore. </h3>");
        out.println("<meta http-equiv=\"refresh\" content=\"2;products.jsp\">");
        out.println("</body>");
        out.println("</html>");


    }
}
