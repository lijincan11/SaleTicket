import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] money = {5,10,20,50};
		int ticket = 1;
		Random random = new Random();
		
		
		String name = "�˿�";
		int i = 1;//�˿�������
		while (true) {
			int index = random.nextInt(4);
			if (ticket % 10 == 0) {
				int continues;
				try {
					Thread.sleep(20);//�ñ��߳�������
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println("�Ѿ�����" + ticket + "��Ʊ�ˣ������Ƿ����?(��1��������0�˳�)");
				
				Scanner scanner = new Scanner(System.in);
				continues = scanner.nextInt();
				
				while( continues != 1) {
					switch (continues) {
					
					case 0:
						System.out.println("��Ʊ�ѽ���");
						return ;
					default:
						System.out.println("�����������������������:");
						continues = scanner.nextInt();
						break;
					}
				}				
			}//if����
			
			Customer customer = new Customer(name+i, money[index]);
			customer.start();
			
			i++;
			ticket++;
		}
		
				
	}

}
