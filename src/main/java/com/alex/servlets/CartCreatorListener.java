package com.alex.servlets;

/**
 * Created by Алексей on 14.08.2016.
 */
import com.alex.entity.Product;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kovantonlenko on 12/21/2015.
 */
public class CartCreatorListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        List<Product> cart = new LinkedList<>();
        se.getSession().setAttribute("cart",cart);


    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        se.getSession().removeAttribute("cart");
    }
}

