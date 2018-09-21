package daily.d20180620;

public class DynamicVariableTabTest {

	public static void main(String[] args) {
		String sb = new StringBuilder("ja").append("va").toString();
		System.out.println(sb.intern() == sb);
	}
}
