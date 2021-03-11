package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserServiceImpl;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.web.mvc.controller.PageController;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/register")
public class UserRegisterController implements PageController {

    @Resource(name = "bean/UserService")
    private UserService userService;

    /*public UserRegisterController() {
        userService = new UserServiceImpl();
    }*/

    @GET
    @POST
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);

        boolean isSuccess = userService.register(user);

        request.setAttribute("user",user);

        return isSuccess ? "register-success.jsp" : "register-fail.jsp";
    }
}
