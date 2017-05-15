package annotation.basic;

public class PrintAnnotedClass {
	@PrintAnnotation
	public void method1(){
		System.out.println("method1 is called");
	}
	
	@PrintAnnotation("*") //value값 넣어준다. 
	public void method2(){
		System.out.println("method2 is called");
	}
	
	@PrintAnnotation(value="?", number = 20)
	public void method3(){
		System.out.println("method3 is called");
	}
}
