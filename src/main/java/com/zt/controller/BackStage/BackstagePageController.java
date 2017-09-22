package com.zt.controller.BackStage;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/")
@Controller
public class BackstagePageController {

    @RequestMapping(value = "backLogin.html")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "index.html")
    public String Index(){
        return "backStage";
    }


}
