package designPattern.singleton;

public class SingletonFalse1 {
	//1. private const // singletonFalse1�� ���� ������ ���� ���� �Ҵ�ȴ�. 
	private static SingletonFalse1 singletonFalse1 = new SingletonFalse1();
	
	//2. getter : �� �޼ҵ带 ���ؼ��� ������ �� �ֵ���
	public static SingletonFalse1 getObj() {
		return singletonFalse1;
	}
	
	//������ �̰� �����ڷε� ������ �� �ִٴ� ��
}
