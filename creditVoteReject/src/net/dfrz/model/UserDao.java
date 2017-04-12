package net.dfrz.model;

import java.util.List;

import net.dfrz.domain.User;

/**
 * 
 * @author ����
 * @version ���û������Ľӿ���
 */
public interface UserDao {

	/**
	 * �û���¼
	 * 
	 * @param user
	 *            ��¼���û�
	 */
	public void login(User user);

	/**
	 * �û��˳�
	 */
	public void exit();

	/**
	 * ��ȡ�ѵ�¼�û�����Ϣ
	 * 
	 * @return �����û�
	 */
	public User whoLogining();

	/**
	 * ͨ���û����������ȡ�û�
	 * 
	 * @param loginName
	 *            �û���
	 * @param password
	 *            ����
	 * @return ���ϸ��û�����������û��ļ���
	 */
	public List<User> quaryUser(String loginName, String password);

	/**
	 * ��ѯ�Ƿ���ڸ��û���
	 * 
	 * @param loginName
	 *            �û���
	 * @return ���ϸ��û������û��ļ���
	 */
	public List<User> quaryUser(String loginName);

	/**
	 * ��ѯ�г��ĵ�¼��
	 * 
	 * @param loginName
	 *            �û���
	 * @return ���ϸ��û����ļ���
	 */
	public List<User> quaryGovernors(String loginName);

	/**
	 * ����û�
	 * 
	 * @param user
	 *            ��Ҫ��ӵ��û�
	 */
	public void addUser(User user);

	/**
	 * ��ѯ�����ߵĵ�¼��
	 * 
	 * @param logName
	 *            �û���
	 * @return ���ϸ��û����ļ���
	 */
	public List<User> quaryRounders(String logName);

}
