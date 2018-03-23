package niube.test;

public class Child extends Parent{

	public Child() {
		super(1);
		System.out.println("initChild1");
	}
	
	public Child(int a) {
		System.out.println("initChild2");
	}
	
	public Child(String a) {
		System.out.println("initChild3");
	}
	public static void main(String[] args) {
		new Child();
	}
}
