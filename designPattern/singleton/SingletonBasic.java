package designPattern.singleton;

public class SingletonBasic {
	//1. static singleton 객체 변수 하나 만든다.
	private static SingletonBasic singleton = new SingletonBasic();
	
	//2. 외부에서 생성 못하도록 기본 생성자도 private화 한다.
	private SingletonBasic() {}
	
	//3. singleton getter
	public static SingletonBasic getSingleton() {
		return singleton;
	}
}
