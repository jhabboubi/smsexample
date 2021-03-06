package org.perscholas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /*
            - controllers should be separated e.g. @RequestMapping("admin"), @RequestMapping("student")
            - provide as much as possible e.g. get/post/put/delete mappings
     */
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/template")
    public String template(){
        return "template";
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }


    @GetMapping("/403")
    public String access(){
        return "403";
    }


}
