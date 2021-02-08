package io.lindx.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * MainServlet
 */
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("we are in main method");
        
        req.getSession().setAttribute("user", "Tom2");

        System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName());

        HttpSession session = req.getSession();

        System.out.println("sessio: " + session.getId());

        req.getRequestDispatcher("main.jsp").forward(req, resp);
      
    }
}