
import java.util.Vector;

/*
 * 轮询
 * */
public class Poll {

	public Poll() {
		// TODO Auto-generated constructor stub
	}
	Vector<Customer> list = new Vector<>();
	
	
	//当线程等待时，把线程加到集合里
	public void add(Customer customer) {
		list.add(customer);
	}
	
	//返回集合里的数量
	public int Number() {
		return list.size();
	}

	//返回集合的指定元素
	public Customer get(int i) {
		return list.get(i);
	}
	
	public synchronized void poll() {
			for (int i = 0; i < Number(); i++) {
				Customer customer =  list.get(i);//利用轮询让第i个顾客看能不能找零
				
				if (GiveMoney.GiveMoney(customer)) {
					System.out.println(customer.threadName + "已经买完票，已离开");
					customer.interrupt();
					list.remove(i);
					System.out.println("等待找零人数：" +Number());
					return ;
				}

			}
		
	}
}
