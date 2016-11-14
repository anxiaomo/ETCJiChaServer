package com.xks.parkjicha.controller;

import com.xks.parkjicha.bean.LoginReqBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anxiaomo on 2016/11/7.
 */
@Controller
@RequestMapping("/jicha")
public class test {
    @RequestMapping(params = "method=ajax", method = RequestMethod.POST)
    @ResponseBody
    public List getAjax(@RequestBody LoginReqBean pushdata) {
        System.out.print(pushdata.getPassword());
        List<String> list = new ArrayList<>();
        list.add("s");
        list.add("d");
        list.add("a");
        return list;
    }
    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String index( HttpSession httpSession) {
        /*httpSession.setAttribute("workedid","12");*/
        return "index";
    }
    @RequestMapping(value="/lo", method = RequestMethod.GET)
    public String index1() {
        return "index";
    }
    @RequestMapping(value="/ajaxjson", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> ajaxjson(@RequestBody LoginReqBean pushdata) {
        Map<String,Object> map=new HashMap();
        map.put("we", 20);
        return map;
    }
}
