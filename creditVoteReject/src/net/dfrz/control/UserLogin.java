package net.dfrz.control;

import net.dfrz.domain.User;
import net.dfrz.model.UserDao;
import net.dfrz.model.impl.UserImpl;

public class UserLogin {

	// �ж��Ƿ���ȷ��¼
	public static boolean isLogin(String loginName, String password) {
		UserDao userDao = new UserImpl();

		if (userDao.quaryUser(loginName, password).size() != 1)
			return false;
		else
			return true;
	}

	// �û���¼
	public static User login(String loginName, String password) {
		UserDao userDao = new UserImpl();
		User user = new User();

		user.setLogName(loginName);
		user.setPassword(password);

		userDao.login(user);

		return userDao.whoLogining();
	}
}
