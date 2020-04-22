package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName GithubLogin
 * @Description github第三方登录
 * @Author Rex
 * @Date 2020-04-11 19:53
 * @Version 1.0
 **/
@Controller
public class GithubLogin {

    private static final String client_id = "81ab7cad90754371b50b";
    private static final String clientSecret = "71329918bbd240785de32ec50f2075675c952cca";
    private static final String URL = "https://github.com/login/oauth/access_token";

    @GetMapping("/oauth/redirect")
    public String getOauth(String code) throws Exception {
        OkHttpClient client = new OkHttpClient();
        // 回调获取code
        System.out.println("回调code:" + code);
        // 根据code 获取令牌
        JSONObject json = new JSONObject();
        json.put("client_id", client_id);
        json.put("client_secret", clientSecret);
        json.put("code", code);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json.toJSONString());
        Request request = new Request.Builder().url(URL).post(body).build();

        Response response = client.newCall(request).execute();
        String string = response.body().string();
        String[] split = string.split("&");
        String[] strings = split[0].split("=");
        String token = strings[1];
        System.out.println("token:" + token);

        // 查询用户信息
        Request build = new Request.Builder()
                .url("https://api.github.com/user")
                .addHeader("Authorization", "token " + token).build();
        Response execute = client.newCall(build).execute();
        JSONObject o = JSONObject.parseObject(execute.body().string());
        String name = o.getString("login");
        System.out.println(name);
        return "home.html?name=" + name;
    }
}
