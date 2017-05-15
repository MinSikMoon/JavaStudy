package annotation.basic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//어노테이션 적용범위를 지정한다. 
//어노테이션을 생성자에 적용할 수는 없다. 
//어노테이션이 언제까지 유지될 건지 지정해야한다. 
//SOURCE => 소스코드에서만 존재, 바이트 코드에서는 사라짐
//CLASS => 바이트에도 어노테이션 정보가 있되, 리플렉션으로 어노테이션 정보를 얻을 수는 없음
//RUNTIME=> 리플렉션으로 런타임시에 어노테이션 정보를 얻을 수 있음.
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	//어노테이션은 멤버를 가질 수 있고, 디폴트값을 가질 수 있다.
	//차이점은 메소드처럼 ()를 붙여줘야 한다. 
	//이 어노테이션을 쓸때 멤버들에 값을 넣을때는 이렇게 쓴다.
	//@MyAnnotation(strElem = "value", intElem = "value")
	//intElem은 디폴트 값이 있어서 생략가능하지만 strElem은 반드시 값을 넣어줘야 한다. 
	//value라는 멤버를 가지고 있으면 ("value") 이렇게만 해줘도 딘다. 
	String value();
	String strElem();
	int intElem() default 777;
	
}
