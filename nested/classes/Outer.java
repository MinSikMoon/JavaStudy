package nested.classes;

public class Outer {
	//constructor - outer
	public Outer() {}
	
	//instance member class : static이 붙었나 안붙었나 차이 : outer 객체를 생성뒤 만들 수 있다.
	public class insMemberCls{
		public insMemberCls() {}
		public int field1;
		//static int field2; //static class가 아니기에 static 변수, 메소드 쓸 수 없다.
		public void method1() {}
		//static void method2() {}
	}
	
	//static member class 
	public static class sttMemberCls{
		public sttMemberCls() {}
		public int field1;
		public static int field2; //static member class 이기에 static 가능 
		void method1() {}
		static void method2() {}
	}
	
	//method for study local class
	public void methodForLocalCls() {
		class localCls{
			localCls(){} //얘들은 어차피 메소드 안에 있는 class이므로 접근 제한자가 필요없음.
			int field1;
			//static int field2; 
			void method1() {}
			//static void method2() {}
		}
		
		localCls lccls = new localCls();
		lccls.field1 = 7;
		lccls.method1();
	}
	
}
