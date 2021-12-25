package com.nisha.librarymanager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("/testui")
    @ResponseBody()
    String test() {
        return "home";
    }
}
