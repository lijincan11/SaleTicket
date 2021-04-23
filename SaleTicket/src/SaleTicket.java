
class SaleTicket {
	// 临界资源是售票员手里的钱

	protected static int[] MONEY = {0,1,0,0};	//分别代表5元 10元 20元 50元的张数
	Poll poll = new Poll();
	
	public synchronized boolean chan(Customer customer) {

		if (customer.money == 20) {
			MONEY[2]++;// 先收下钱
			// 20元结束
		} else if (customer.money == 10) {// money == 10 开始
			MONEY[1]++;

		} // money =10 结束
		else if (customer.money == 5) {
			MONEY[0]++;
			System.out.println(customer.threadName + "结束,此时售票员手中的钱:5元有" + MONEY[0] + "张 , 10元有：" + MONEY[1]
					+ "张,  20元有:" + MONEY[2] + ",  50元有:" + MONEY[3] + "张");
			if (poll.Number() != 0) {	//轮询
				 poll.poll();
			}	
			return true;// money=5结束
		} else if (customer.money == 50) {// money = 50开始
			MONEY[3]++;// 先收下钱	
			}
		
		boolean isLeavg = GiveMoney.GiveMoney(customer);
		if (isLeavg == false) {
			poll.add(customer);
			try {
				System.out.println(customer.threadName + "结束,此时售票员手中的钱:5元有" + MONEY[0] + "张 , 10元有：" + MONEY[1]
						+ "张,  20元有:" + MONEY[2] + ",  50元有:" + MONEY[3] + "张");
				System.out.println("等待找零人数：" +poll.Number());
				if (poll.Number() != 0) {	//如果这个人不能找零，看其他人是否可以找零
					 poll.poll();
				}
				this.wait();// 最开始不能找钱，就告诉他，让他先等一会儿
			} catch (InterruptedException e) {
			}
		}else {			
			return true;//找零成功
		}
		
			return false;

	}
}
