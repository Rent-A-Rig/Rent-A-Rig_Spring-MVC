package cova.rar.service;

import cova.rar.dao.UserDao;
import cova.rar.entities.Login;
import cova.rar.entities.User;

import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

  @Autowired
  public UserDao userDao;

  public int register(User user) {
    return userDao.register(user);
  }

  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }

}
