import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] money = {5,10,20,50};
		int ticket = 1;
		Random random = new Random();
		
		
		String name = "顾客";
		int i = 1;//顾客名变量
		while (true) {
			int index = random.nextInt(4);
			if (ticket % 10 == 0) {
				int continues;
				try {
					Thread.sleep(20);//让本线程最后输出
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println("已经卖了" + ticket + "张票了，请问是否继续?(按1继续，按0退出)");
				
				Scanner scanner = new Scanner(System.in);
				continues = scanner.nextInt();
				
				while( continues != 1) {
					switch (continues) {
					
					case 0:
						System.out.println("卖票已结束");
						return ;
					default:
						System.out.println("输入的数据有误，请重新输入:");
						continues = scanner.nextInt();
						break;
					}
				}				
			}//if结束
			
			Customer customer = new Customer(name+i, money[index]);
			customer.start();
			
			i++;
			ticket++;
		}
		
				
	}

}
