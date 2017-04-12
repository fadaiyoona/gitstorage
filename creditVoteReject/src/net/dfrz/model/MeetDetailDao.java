package net.dfrz.model;

import java.io.File;
import java.util.Map;

import net.dfrz.domain.MeetDetail;
import net.dfrz.domain.User;

/**
 * 
 * @author ����
 * @version �Ի�����ϸ�����Ľӿ���
 */
public interface MeetDetailDao {

	/**
	 * ��ӻ�����ϸ
	 * 
	 * @param meetDetail
	 *            ������ϸ
	 */
	public void add(MeetDetail meetDetail);

	/**
	 * ������ǩ������ϸ
	 * 
	 * @return ��ǩ����ļ���
	 */
	public Map<Integer, MeetDetail> queryMeetDetailShenQian();

	/**
	 * �����˻ػ�����ϸ
	 * 
	 * @return �˻��������ļ���
	 */
	public Map<Integer, MeetDetail> queryBackJudgeMeetDetail();

	/**
	 * ���»���Ľ��
	 * 
	 * @param id
	 *            ��Ҫ���µĻ����id
	 * @param money
	 *            �޸ĵĻ���Ķ��
	 */
	public void updateMeetDetailMoney(String id, String money);

	/**
	 * ��ѯ���л�����ϸ
	 * 
	 * @return ���л���ļ���
	 */
	public Map<Integer, MeetDetail> queryMeetDetail();

	/**
	 * ������д��Excel
	 * 
	 * @param meetDetails
	 *            ��Ҫд��Excel�Ļ���
	 * @param file
	 *            д���Excel�ı�
	 */
	public void write(Map<Integer, MeetDetail> meetDetails, File file);

	/**
	 * �����߲�ѯ������ϸ
	 * 
	 * @param onlineUser
	 *            ������
	 * @return �������ܿ����Ļ���ļ���
	 */
	public Map<Integer, MeetDetail> queryMeetDetailByRounder(User onlineUser);
}
