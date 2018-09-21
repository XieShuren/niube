package daily.d20180816;

public class OurHome {
	private final Girl you;
	private final Man i;
	public OurHome(Girl you, Man i) {
		this.you = you;
		this.i = i;
	}
	public void doAnyThing() {
		//we can do anything when together
		if (together()){
			//sleep,eat,trip,defeat tough...
		}
	}
	private boolean together() {
		return i.love(you);
	}
}
