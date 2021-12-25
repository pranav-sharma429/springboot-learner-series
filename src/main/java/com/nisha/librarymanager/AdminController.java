package com.nisha.librarymanager;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AdminController {

    // @RequestMapping(value = "/test", method = RequestMethod.GET)
    @GetMapping("/test")
    String test() {
        return "vicky";
    }

    @GetMapping("/test2")
    Map map() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "vicky");
        return map;
    }
}
