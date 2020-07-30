package com.foodbank.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class JsonAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {

        if (request.getHeader("Content-Type").equals("application/json")) {

            response.getWriter().print("{\"responseCode\": \"SUCCESS\"}");
            response.getWriter().flush();
        } else {

            super.onAuthenticationSuccess(request, response, auth);
        }
    }
}
