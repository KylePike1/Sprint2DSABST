package com.keyin.sprint2searchtreekylepike.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;


@Controller
public class CustomErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        // Get the error status code (optional logic for customization)
        Object status = request.getAttribute("javax.servlet.error.status_code");
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            if (statusCode == 404) {
                // Redirect to homepage if the error is a 404
                return "redirect:/";
            }
        }
        // Return the error page for other error codes
        return "error"; // This corresponds to error.html
    }

    public String getErrorPath() {
        return "/error";
    }
}