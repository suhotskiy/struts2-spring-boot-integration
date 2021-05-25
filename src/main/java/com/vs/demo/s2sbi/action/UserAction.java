package com.vs.demo.s2sbi.action;

import com.opensymphony.xwork2.ActionSupport;
import com.vs.demo.s2sbi.domain.User;
import com.vs.demo.s2sbi.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Component;

import java.util.List;

@Namespace("/users")
@Component
public class UserAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private List<User> users;

    @Getter
    @Setter
    private User user;

    private final UserService userService;

    public UserAction(UserService userService) {
        this.userService = userService;
    }

    @Action(value = "/list", results = {
        @Result(name = "success", location = "/users.jsp")
    })
    public String listUsers() throws Exception {
        users = userService.getUsers();
        return SUCCESS;
    }

    @Action(value = "/add", results = {
            @Result(name = "success", location = "/users.jsp")
    })
    public String addUser() {
        userService.addUser(user);
        users = (List<User>) userService.getUsers();
        return SUCCESS;
    }

}
