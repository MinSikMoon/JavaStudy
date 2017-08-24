package designPattern.singleton;

public class SingletonFalse1 {
	//1. private const // singletonFalse1은 정적 변수라 가장 먼저 할당된다. 
	private static SingletonFalse1 singletonFalse1 = new SingletonFalse1();
	
	//2. getter : 이 메소드를 통해서만 생성할 수 있도록
	public static SingletonFalse1 getObj() {
		return singletonFalse1;
	}
	
	//문제는 이걸 생성자로도 생성할 수 있다는 것
}
