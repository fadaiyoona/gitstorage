package net.dfrz.control;

import net.dfrz.domain.User;
import net.dfrz.log.Log;
import net.dfrz.model.UserDao;
import net.dfrz.model.impl.UserImpl;

public class BackStageManagement {

	// ����û�
	public static void addUser(User user) {
		UserDao userDao = new UserImpl();

		userDao.addUser(user);
		Log.addLog("�����һ���û�");
	}
}
