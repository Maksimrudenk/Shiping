package org.study.shiping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    @GetMapping("/")
    public String index() {
        return "index"; // index.html
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // dashboard.html
    }

    @GetMapping("/create-order")
    public String createOrder() {
        return "create-order"; // create-order.html
    }
}

