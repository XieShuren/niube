package niube;

public class TestPrintStackTrace
{
   public static void f() throws Exception{
       throw new MyException();
   }
   public static void g() throws Exception{
	   try {
		   f();
	   }catch(Exception e) {
           e.printStackTrace();
       }
   }
   public static void main(String[] args) {
       try {
           g();
       }catch(Exception e) {
           e.printStackTrace();
       }
   }
}