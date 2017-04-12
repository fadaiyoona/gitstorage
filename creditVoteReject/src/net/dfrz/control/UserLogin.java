package net.dfrz.control;

import net.dfrz.domain.User;
import net.dfrz.model.UserDao;
import net.dfrz.model.impl.UserImpl;

public class UserLogin {

	// 判断是否正确登录
	public static boolean isLogin(String loginName, String password) {
		UserDao userDao = new UserImpl();

		if (userDao.quaryUser(loginName, password).size() != 1)
			return false;
		else
			return true;
	}

	// 用户登录
	public static User login(String loginName, String password) {
		UserDao userDao = new UserImpl();
		User user = new User();

		user.setLogName(loginName);
		user.setPassword(password);

		userDao.login(user);

		return userDao.whoLogining();
	}
}
