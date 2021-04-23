
public class Customer extends Thread// 继承Thread类，创建多个线程
{
	String threadName;
	int money;
	public volatile boolean exit = false; // 判断是否需要销毁
	static SaleTicket buy = new SaleTicket();

	public Customer(String threadName, int money) {
		this.threadName = threadName;
		this.money = money;
	}

	@Override
	public void run() {
		synchronized (buy) {
			System.out.println(threadName + "手上有" + money + "元");
			exit = buy.chan(new Customer(this.threadName, this.money));
			while (!exit)
				;
			
			System.out.println(threadName + "已经买完票，已离开");
		}
	}
}
