package com.trip.plannr.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by welcome on 5/28/2016.
 */
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("POST method called");
        out.println("parameters: " + parameters(request));
        out.println("headers: " + headers(request));
    }

    private String parameters(HttpServletRequest request) {
        StringBuilder builder = new StringBuilder();
        for (Enumeration e = request.getParameterNames(); e.hasMoreElements();) {
            String name = (String) e.nextElement();
            builder.append("|" + name + "->" + request.getParameter(name)+"\n");
        }
        return builder.toString();
    }

    private String headers(HttpServletRequest request) {
        StringBuilder builder = new StringBuilder();
        for (Enumeration e = request.getHeaderNames(); e.hasMoreElements();) {
            String name = (String) e.nextElement();
            builder.append("|" + name + "->" + request.getHeader(name)+"\n");
        }
        return builder.toString();
    }
}
