
public class Customer extends Thread// �̳�Thread�࣬��������߳�
{
	String threadName;
	int money;
	public volatile boolean exit = false; // �ж��Ƿ���Ҫ����
	static SaleTicket buy = new SaleTicket();

	public Customer(String threadName, int money) {
		this.threadName = threadName;
		this.money = money;
	}

	@Override
	public void run() {
		synchronized (buy) {
			System.out.println(threadName + "������" + money + "Ԫ");
			exit = buy.chan(new Customer(this.threadName, this.money));
			while (!exit)
				;
			
			System.out.println(threadName + "�Ѿ�����Ʊ�����뿪");
		}
	}
}
