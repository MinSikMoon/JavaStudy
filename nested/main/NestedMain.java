package nested.main;

import nested.classes.Outer;

public class NestedMain {

	public static void main(String[] args) {
		Outer ot = new Outer(); //outerclass �����
		
		Outer.insMemberCls a = ot.new insMemberCls(); //public �����ڸ� class�� method�� �ٿ��⿡ ���� �ٸ� package������ ������ ������ ����.
		//������ �����ϴ�? -> �ҽ��ڵ�󿡼� ���� �ִٴ� ��. ��Ŭ���� �ڵ����� �ߴ°�. 
		a.method1();
		a.field1 = 777;
		
		
		Outer.sttMemberCls b = new Outer.sttMemberCls(); //static member class 
		b.field1 = 777;
		Outer.sttMemberCls.field2 = 7777;
		
		ot.methodForLocalCls(); //�� �޼ҵ带 ȣ���ϸ� �޼ҵ忡 ���ǵ� ���� Ŭ������ �����ǰ� ���������
		
		
	}

}
