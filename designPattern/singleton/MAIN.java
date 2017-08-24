package designPattern.singleton;

public class MAIN {

	public static void main(String[] args) {
		SingletonFalse1 s1  = SingletonFalse1.getObj();
		SingletonFalse1 s2  = SingletonFalse1.getObj();
		
		System.out.println(s1 == s2); //���� ��ü��� ���´�.
		
		//������ �������� ��ü ������ �����ϴٴ� �� 
		SingletonFalse1 s3 = new SingletonFalse1(); //�̰� �Ǹ� �ȵȴ�.
		System.out.println(s1 == s3);
		
		//���� �ذ�
		//SingletonBasic s4 = new SingletonBasic(); //�⺻ �����ڰ� private�̱⿡ �̷��� �� �� ����. ������ ��ü ������ ���� ���Ѵ�. 
		
	}

}
