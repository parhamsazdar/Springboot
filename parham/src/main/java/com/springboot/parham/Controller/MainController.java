package com.springboot.parham.Controller;


import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {


    @RequestMapping(value = {"/path/{username}/{password}", "/path/{username}/"}, method = RequestMethod.GET)
    public String path(@PathVariable(value = "username") String username, @PathVariable(value = "password", required = false) String password) {
        return "Hello " + username + " with password " + password;

    }


    @RequestMapping(value = {"/pathQueryParam"}, method = RequestMethod.POST)
    public String param(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        return "Hello " + username + " with password " + password;

    }

    @RequestMapping(value = "/body")
    public String body(@RequestBody User body) {
        return body.getName() + " " + body.getPassword();
    }

    @RequestMapping(value = "/json")
    public String bodyJson() {

        List<User> users = new ArrayList<>();
        User user_1 = new User("parham", "1234");
        User user_2 = new User("baran", "1234");
        users.add(user_1);
        users.add(user_2);
        return new Gson().toJson(users);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String firstRest() {
        return "First Rest";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String SecondRest() {
        return "Second Rest";
    }

    @PostMapping(value = "/post")
    public String post() {
        return "Post Api";
    }


    @GetMapping(value = "/get")
    public String get() {
        return "Get Api";
    }

}
