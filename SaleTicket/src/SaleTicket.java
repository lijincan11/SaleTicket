
class SaleTicket {
	// �ٽ���Դ����ƱԱ�����Ǯ

	protected static int[] MONEY = {0,1,0,0};	//�ֱ����5Ԫ 10Ԫ 20Ԫ 50Ԫ������
	Poll poll = new Poll();
	
	public synchronized boolean chan(Customer customer) {

		if (customer.money == 20) {
			MONEY[2]++;// ������Ǯ
			// 20Ԫ����
		} else if (customer.money == 10) {// money == 10 ��ʼ
			MONEY[1]++;

		} // money =10 ����
		else if (customer.money == 5) {
			MONEY[0]++;
			System.out.println(customer.threadName + "����,��ʱ��ƱԱ���е�Ǯ:5Ԫ��" + MONEY[0] + "�� , 10Ԫ�У�" + MONEY[1]
					+ "��,  20Ԫ��:" + MONEY[2] + ",  50Ԫ��:" + MONEY[3] + "��");
			if (poll.Number() != 0) {	//��ѯ
				 poll.poll();
			}	
			return true;// money=5����
		} else if (customer.money == 50) {// money = 50��ʼ
			MONEY[3]++;// ������Ǯ	
			}
		
		boolean isLeavg = GiveMoney.GiveMoney(customer);
		if (isLeavg == false) {
			poll.add(customer);
			try {
				System.out.println(customer.threadName + "����,��ʱ��ƱԱ���е�Ǯ:5Ԫ��" + MONEY[0] + "�� , 10Ԫ�У�" + MONEY[1]
						+ "��,  20Ԫ��:" + MONEY[2] + ",  50Ԫ��:" + MONEY[3] + "��");
				System.out.println("�ȴ�����������" +poll.Number());
				if (poll.Number() != 0) {	//�������˲������㣬���������Ƿ��������
					 poll.poll();
				}
				this.wait();// �ʼ������Ǯ���͸������������ȵ�һ���
			} catch (InterruptedException e) {
			}
		}else {			
			return true;//����ɹ�
		}
		
			return false;

	}
}
