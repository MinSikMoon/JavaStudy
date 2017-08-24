package nested.classes;

public class Outer {
	//constructor - outer
	public Outer() {}
	
	//instance member class : static�� �پ��� �Ⱥپ��� ���� : outer ��ü�� ������ ���� �� �ִ�.
	public class insMemberCls{
		public insMemberCls() {}
		public int field1;
		//static int field2; //static class�� �ƴϱ⿡ static ����, �޼ҵ� �� �� ����.
		public void method1() {}
		//static void method2() {}
	}
	
	//static member class 
	public static class sttMemberCls{
		public sttMemberCls() {}
		public int field1;
		public static int field2; //static member class �̱⿡ static ���� 
		void method1() {}
		static void method2() {}
	}
	
	//method for study local class
	public void methodForLocalCls() {
		class localCls{
			localCls(){} //����� ������ �޼ҵ� �ȿ� �ִ� class�̹Ƿ� ���� �����ڰ� �ʿ����.
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
