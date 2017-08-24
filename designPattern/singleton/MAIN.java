package designPattern.singleton;

public class MAIN {

	public static void main(String[] args) {
		SingletonFalse1 s1  = SingletonFalse1.getObj();
		SingletonFalse1 s2  = SingletonFalse1.getObj();
		
		System.out.println(s1 == s2); //같은 객체라고 나온다.
		
		//하지만 문제점은 객체 생성이 가능하다는 점 
		SingletonFalse1 s3 = new SingletonFalse1(); //이게 되면 안된다.
		System.out.println(s1 == s3);
		
	}

}
