package com.zx.controller;

import com.zx.pojo.User;
import com.zx.service.UserService;
import com.zx.util.JsonData;
import com.zx.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * Created by zhangxin on 2015-07-27.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Description("标识 @ModelAttribute 的方法会在每个方法调用前被执行并赋值")
    @ModelAttribute
    private void getUser(@RequestParam(value = "userId", required = false) String userId,
                         Map<String, Object> map) {
        System.out.println("---------------> ModelAttribute");
        if (userId != null) {
            System.out.println("---------------> userId = " + userId);
            map.put("user", userService.get(userId));
        }
    }

    @Description("用户页面")
    @RequestMapping("findUser")
    public String findUser(User user, Map<String, Object> map,
                           @RequestParam(value = "pageNum", defaultValue = Pagination.DEFAULT_PAGE_NUM_STR) Integer pageNum) {
        map.put("pagination", userService.findUser(user, pageNum, Pagination.PAGE_SIZE_5));
        return "user/userList";
    }

    @Description("用户列表信息页面")
    @RequestMapping("findUserContent")
    public String findUserContent(User user, Map<String, Object> map,
                                  @RequestParam(value = "pageNum", defaultValue = Pagination.DEFAULT_PAGE_NUM_STR) Integer pageNum) throws ServletException, IOException {
        map.put("pagination", userService.findUser(user, pageNum, Pagination.PAGE_SIZE_5));
        return "user/userListContent";
    }

    @Description("保存用户信息")
    @ResponseBody
    @RequestMapping("saveUser")
    public JsonData saveUser(User user) {
        JsonData jsonData = new JsonData();
        try {
            user.setUserState(User.USER_STATE_YES);
            user.setCreateTime(new Date());
            userService.save(user);
            jsonData.setState(true);
        } catch (Exception e) {
            jsonData.setMsg(e.getMessage());
        }
        return jsonData;
    }

    @Description("更新用户信息")
    @ResponseBody
    @RequestMapping("updateUser")
    public JsonData updateUser(User user) {
        JsonData jsonData = new JsonData();
        try {
            userService.update(user);
            jsonData.setState(true);
        } catch (Exception e) {
            jsonData.setMsg(e.getMessage());
        }
        return jsonData;
    }

    @Description("更新用户信息")
    @ResponseBody
    @RequestMapping("deleteUser")
    public JsonData deleteUser(@RequestParam("userId") String userId) {
        JsonData jsonData = new JsonData();
        try {
            userService.delete(userId);
            jsonData.setState(true);
        } catch (Exception e) {
            jsonData.setMsg(e.getMessage());
        }
        return jsonData;
    }

}
