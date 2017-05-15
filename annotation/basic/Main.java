package annotation.basic;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		// 어노테이션 공부 메인
		
		//1. 어노테이션이 적용된 클래스로부터 메소드 정보들을 얻어온다.
		Method[] declaredMethods = PrintAnnotedClass.class.getDeclaredMethods();
		//1. 배열을 돌면서 처리한다.
		for(Method mtd : declaredMethods){
			//2. PrintAnnotation이 적용되었는지 확인한다.
			if(mtd.isAnnotationPresent(PrintAnnotation.class)){
				//3. 해당 메소드에 적용된 PrintAnnotation 객체를 얻어낸다.
				PrintAnnotation pat = mtd.getAnnotation(PrintAnnotation.class);
				//3. 해당 메소드 이름 출력
				System.out.println("method name : " + mtd.getName());
				//3. 메소드 별로 다른 어노테이션의 value 값 출력
				for(int i = 0; i<pat.number(); i++){
					System.out.print(pat.value());
				}
				System.out.println();
				//3. 이제 메소드도 불러본다.
				try{
					mtd.invoke(new PrintAnnotedClass());
					System.out.println();
				}catch(Exception e){
					System.out.println();
				}
			}
			
			
		}

	}

}
