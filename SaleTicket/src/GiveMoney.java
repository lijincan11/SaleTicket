
public class GiveMoney {
	


	public static synchronized boolean GiveMoney(Customer customer) {
		
		synchronized(GiveMoney.class) {
			
			int i;
			int mod = customer.money - 5; // 还要找零的余额
			int[] delMoney = { 0, 0, 0, 0 }; // 要减去的钱
			int[] moneyLevel = { 5, 10, 20, 50 }; // 把所有钱放到数组中
			for (i = moneyLevel.length - 1; i >= 0; i--) { // 先从面值最大的钱开始取，依次减小面值
				int num = mod / moneyLevel[i]; // 当前找零需要的张数

				if (num <= SaleTicket.MONEY[i]) {
					mod = mod - (num * moneyLevel[i]); // 剩余的钱
					delMoney[i] += num; // 把要减的钱暂存在数组里

				} else {
					int m = SaleTicket.MONEY[i]; // 取出下标为i的张数
					mod -= m * moneyLevel[i];
					delMoney[i] += m; // 把要减的钱暂存在数组里
				}

			}

			if (mod == 0) { // 判断是否能找开
				System.out.print("售票员给" + customer.threadName + "找零：");
				for (i = moneyLevel.length - 1; i >= 0; i--) {
					SaleTicket.MONEY[i] -= delMoney[i]; // 将暂存的数组的钱真正从零钱库减去
					if (delMoney[i] != 0) {
						System.out.print(moneyLevel[i] + "元" + delMoney[i] + "张,");
					}
					
				}
				
				System.out.println("此时售票员手中的钱:5元有" + SaleTicket.MONEY[0] + "张 , 10元有：" + SaleTicket.MONEY[1]
						+ "张,  20元有:" + SaleTicket.MONEY[2] + ",  50元有:" + SaleTicket.MONEY[3] + "张");
				return true;
			}
			return false;
		}
		
		
		
	}

	

}
