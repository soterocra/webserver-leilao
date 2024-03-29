package com.leilaodequadrinhos.api.model.task.user;

import com.leilaodequadrinhos.api.model.dao.UserDao;
import com.leilaodequadrinhos.api.model.dao.impl.jdbc.UserDAO;
import com.leilaodequadrinhos.api.model.entities.User;
import com.leilaodequadrinhos.api.model.task.Task;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLogin implements Task {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();

        UserDao userDao = new UserDAO();
        User user = userDao.findByEmail(request.getParameter("email"));

        if (user == null) {
            return "Usuario ou senha incorretos";
        } else if (user.getPassword().equals(request.getParameter("password"))) {
            user.setPassword(null);
            request.getSession(true).setAttribute("user", user);
            return "Logado";
        } else {
            return "Usuario ou senha incorretos";
        }
    }
}