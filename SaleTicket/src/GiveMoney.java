
public class GiveMoney {
	


	public static synchronized boolean GiveMoney(Customer customer) {
		
		synchronized(GiveMoney.class) {
			
			int i;
			int mod = customer.money - 5; // ��Ҫ��������
			int[] delMoney = { 0, 0, 0, 0 }; // Ҫ��ȥ��Ǯ
			int[] moneyLevel = { 5, 10, 20, 50 }; // ������Ǯ�ŵ�������
			for (i = moneyLevel.length - 1; i >= 0; i--) { // �ȴ���ֵ����Ǯ��ʼȡ�����μ�С��ֵ
				int num = mod / moneyLevel[i]; // ��ǰ������Ҫ������

				if (num <= SaleTicket.MONEY[i]) {
					mod = mod - (num * moneyLevel[i]); // ʣ���Ǯ
					delMoney[i] += num; // ��Ҫ����Ǯ�ݴ���������

				} else {
					int m = SaleTicket.MONEY[i]; // ȡ���±�Ϊi������
					mod -= m * moneyLevel[i];
					delMoney[i] += m; // ��Ҫ����Ǯ�ݴ���������
				}

			}

			if (mod == 0) { // �ж��Ƿ����ҿ�
				System.out.print("��ƱԱ��" + customer.threadName + "���㣺");
				for (i = moneyLevel.length - 1; i >= 0; i--) {
					SaleTicket.MONEY[i] -= delMoney[i]; // ���ݴ�������Ǯ��������Ǯ���ȥ
					if (delMoney[i] != 0) {
						System.out.print(moneyLevel[i] + "Ԫ" + delMoney[i] + "��,");
					}
					
				}
				
				System.out.println("��ʱ��ƱԱ���е�Ǯ:5Ԫ��" + SaleTicket.MONEY[0] + "�� , 10Ԫ�У�" + SaleTicket.MONEY[1]
						+ "��,  20Ԫ��:" + SaleTicket.MONEY[2] + ",  50Ԫ��:" + SaleTicket.MONEY[3] + "��");
				return true;
			}
			return false;
		}
		
		
		
	}

	

}
