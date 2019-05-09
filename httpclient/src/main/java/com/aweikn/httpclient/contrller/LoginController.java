package com.aweikn.httpclient.contrller;// 2019/5/8


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {


    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam(value = "username") String username){
        return "Wecome to " + username;
    }


    @RequestMapping(value = "/loginout",method=RequestMethod.POST)
    @ResponseBody
    public String loginout(@RequestParam(value = "username") String username){
        return "Wecome to " + username;
    }
}
