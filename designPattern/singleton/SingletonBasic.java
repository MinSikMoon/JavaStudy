package designPattern.singleton;

public class SingletonBasic {
	//1. static singleton ��ü ���� �ϳ� �����.
	private static SingletonBasic singleton = new SingletonBasic();
	
	//2. �ܺο��� ���� ���ϵ��� �⺻ �����ڵ� privateȭ �Ѵ�.
	private SingletonBasic() {}
	
	//3. singleton getter
	public static SingletonBasic getSingleton() {
		return singleton;
	}
}
