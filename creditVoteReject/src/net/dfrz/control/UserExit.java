package net.dfrz.control;

import net.dfrz.log.Log;
import net.dfrz.model.UserDao;
import net.dfrz.model.impl.UserImpl;

public class UserExit {

	// �û��˳�
	public static void exit() {
		UserDao userDao = new UserImpl();

		userDao.exit();
		Log.addLog("�˳�");
	}

}
