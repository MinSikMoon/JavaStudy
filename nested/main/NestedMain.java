package nested.main;

import nested.classes.Outer;

public class NestedMain {

	public static void main(String[] args) {
		Outer ot = new Outer(); //outerclass �����
		
		Outer.insMemberCls a = ot.new insMemberCls(); //public �����ڸ� class�� method�� �ٿ��⿡ ���� �ٸ� package������ ������ ������ ����.
		//������ �����ϴ�? -> �ҽ��ڵ�󿡼� ���� �ִٴ� ��. ��Ŭ���� �ڵ����� �ߴ°�. 
		
	}

}
