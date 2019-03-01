package niube.innerClass;

public class Circle {

	private int radius;
	
	static String name;
	
	public boolean flag;
	
	private void draw() {}
	
	static class Drawer {
		
		private static void doSomething() {
//			draw();
		}
	}
}
