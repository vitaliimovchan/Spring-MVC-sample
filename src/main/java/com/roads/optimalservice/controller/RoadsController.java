package com.roads.optimalservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/roads")
public class RoadsController {

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public @ResponseBody  String getInit(){
        return "Init successful";
    }
}
