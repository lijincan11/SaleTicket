
import java.util.Vector;

/*
 * ��ѯ
 * */
public class Poll {

	public Poll() {
		// TODO Auto-generated constructor stub
	}
	Vector<Customer> list = new Vector<>();
	
	
	//���̵߳ȴ�ʱ�����̼߳ӵ�������
	public void add(Customer customer) {
		list.add(customer);
	}
	
	//���ؼ����������
	public int Number() {
		return list.size();
	}

	//���ؼ��ϵ�ָ��Ԫ��
	public Customer get(int i) {
		return list.get(i);
	}
	
	public synchronized void poll() {
			for (int i = 0; i < Number(); i++) {
				Customer customer =  list.get(i);//������ѯ�õ�i���˿Ϳ��ܲ�������
				
				if (GiveMoney.GiveMoney(customer)) {
					System.out.println(customer.threadName + "�Ѿ�����Ʊ�����뿪");
					customer.interrupt();
					list.remove(i);
					System.out.println("�ȴ�����������" +Number());
					return ;
				}

			}
		
	}
}
