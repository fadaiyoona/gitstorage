package net.dfrz.model;

import java.util.List;
import java.util.Map;

import net.dfrz.domain.Meet;
import net.dfrz.domain.MeetDetail;

/**
 * 
 * @author ����
 * @version �Ի����Ҫ�����Ľӿ���
 */
public interface MeetDao {

	/**
	 * ��ӻ����Ҫ
	 * 
	 * @param meet
	 *            ��Ҫ��ӵĻ����Ҫ
	 */
	public void add(Meet meet);

	/**
	 * ���¶����г���ǩ�Ľ��
	 * 
	 * @param id
	 *            ��ǩ�����id
	 * @param judge
	 *            ��ǩ�Ľ��
	 */
	public void updateMeet(String id, String judge);

	/**
	 * ��ѯ���е�����
	 * 
	 * @return �������ݿ������е�����
	 */
	public List<String> quarySetDate();

	/**
	 * ��ѯ�������
	 * 
	 * @param beginDate
	 *            �������Ŀ�ʼ����
	 * @param endDate
	 *            �������Ľ�������
	 * @return �������ļ��� <������ϸ,�����Ҫ>
	 */
	public Map<MeetDetail, Meet> quaryMeetDetail(String beginDate,
			String endDate);

	/**
	 * ��ѯ��ʷ��¼жȡ
	 * 
	 * @param beginDate
	 *            ��ʷ��¼�Ŀ�ʼ����
	 * @param endDate
	 *            ��ʷ��¼�Ľ���ʱ��
	 * @return ��ʷ��¼�ļ��� <������ϸ,�����Ҫ>
	 */
	public Map<MeetDetail, Meet> quaryMeetDetailHistory(String beginDate,
			String endDate);

	/**
	 * ��ʷ��¼д���ı�
	 * 
	 * @param meets
	 *            ��ʷ��¼
	 * @param address
	 *            �洢���ı���ַ
	 */
	public void write(Map<MeetDetail, Meet> meets, String address);
}
