package net.dfrz.model;

import java.util.Map;

import net.dfrz.domain.MeetDetail;
import net.dfrz.domain.State;
import net.dfrz.domain.User;

/**
 * 
 * @author ����
 * @version �������������Ľӿ���
 */
public interface MultipleSignDao {

	/**
	 * �ж϶��˻�ǩģʽ�Ƿ���
	 * 
	 * @return true:�ѿ������˻�ǩģʽ false:δ�������˻�ǩģʽ
	 */
	public boolean queryState();

	/**
	 * ���˻�ǩ
	 * 
	 * @param id
	 *            ���˻�ǩ�Ļ����ID
	 * @param judge
	 *            ���˻�ǩ�Ľ��
	 * @param onlineUser
	 *            ���ζ��˻�ǩ����
	 */
	public void updateMultipleSign(String id, String judge, User onlineUser);

	/**
	 * �򿪶��˻�ǩ����
	 * 
	 * @param state
	 *            ���˻�ǩ�Ķ���
	 */
	public void open(State state);

	/**
	 * �رն��˻�ǩ����
	 * 
	 * @param state
	 *            ���˻�ǩ�Ķ���
	 */
	public void close(State state);

	/**
	 * ��ȡ��������������г�������
	 * 
	 * @return �г�����(governor1,governor2,...,governorn)
	 */
	public String getSignByTheGovernor();

	/**
	 * ��ȡ������ǩ�Ļ���
	 * 
	 * @param user
	 *            ���������ǩ���г�
	 * @return ���г�����Ķ�����ǩ����
	 */
	public Map<Integer, MeetDetail> queryMultipleSignMeetDetails(User user);
}
