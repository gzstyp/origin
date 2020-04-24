package com.fwtai.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2020-04-21 9:21
 * @QQ号码 444141300
 * @Email service@dwlai.com
 * @官网 http://www.fwtai.com
*/
@RestController
@RequestMapping("api")
public class ApiController{

    @Resource
    private HttpServletRequest request;

    // http://127.0.0.1:8030/api/login
    @GetMapping("login")
    public void login(final HttpServletResponse response){
        final JSONObject json = new JSONObject();
        final String password = request.getParameter("password");
        json.put("age","18");
        json.put("name","甜果果");
        json.put("password",password);
        json.put("code",200);
        json.put("msg","操作成功");
        json.put("data","表格数据");
        responseJson(json.toJSONString(),response);
    }

    public void responseJson(final String json,final HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Cache-Control","no-cache");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(String.valueOf(JSON.parse(json)));
            writer.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(writer != null){
                writer.close();
                writer = null;
            }
        }
    }
}