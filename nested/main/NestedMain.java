package nested.main;

import nested.classes.Outer;

public class NestedMain {

	public static void main(String[] args) {
		Outer ot = new Outer(); //outerclass 만들기
		
		Outer.insMemberCls a = ot.new insMemberCls(); //public 제한자를 class와 method에 붙였기에 현재 다른 package에서도 접근이 가능한 것임.
		//접근이 가능하다? -> 소스코드상에서 쓸수 있다는 것. 이클립스 자동으로 뜨는것. 
		
	}

}
