package daily.d20180531;

public enum Fruit{
	Apple("apple") {public String getName() {
		 throw new RuntimeException();
		}
	},
	Orange("orange");
	
	Fruit(String name) {
		this.name = name;
	}
	private String name;
	
	public String getName() {
		return name;
	}
//	public void setName(String name) {
//		this.name = name;
//	}
	
}
