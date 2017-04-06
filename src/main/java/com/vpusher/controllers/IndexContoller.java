package com.vpusher.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by vpusher on 4/6/17.
 */

@Controller
public class IndexContoller {

    @GetMapping(path = "/")
    public String index(HttpServletRequest request, Model model) {
        return "index";
    }

}
