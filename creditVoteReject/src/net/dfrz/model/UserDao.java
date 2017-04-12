package net.dfrz.model;

import java.util.List;

import net.dfrz.domain.User;

/**
 * 
 * @author 发呆
 * @version 对用户操作的接口类
 */
public interface UserDao {

	/**
	 * 用户登录
	 * 
	 * @param user
	 *            登录的用户
	 */
	public void login(User user);

	/**
	 * 用户退出
	 */
	public void exit();

	/**
	 * 获取已登录用户的信息
	 * 
	 * @return 在线用户
	 */
	public User whoLogining();

	/**
	 * 通过用户名和密码获取用户
	 * 
	 * @param loginName
	 *            用户名
	 * @param password
	 *            密码
	 * @return 符合该用户名和密码的用户的集合
	 */
	public List<User> quaryUser(String loginName, String password);

	/**
	 * 查询是否存在该用户名
	 * 
	 * @param loginName
	 *            用户名
	 * @return 符合该用户名的用户的集合
	 */
	public List<User> quaryUser(String loginName);

	/**
	 * 查询行长的登录名
	 * 
	 * @param loginName
	 *            用户名
	 * @return 符合该用户名的集合
	 */
	public List<User> quaryGovernors(String loginName);

	/**
	 * 添加用户
	 * 
	 * @param user
	 *            需要添加的用户
	 */
	public void addUser(User user);

	/**
	 * 查询传阅者的登录名
	 * 
	 * @param logName
	 *            用户名
	 * @return 符合该用户名的集合
	 */
	public List<User> quaryRounders(String logName);

}
