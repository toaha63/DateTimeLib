# DateTimeLib
A greatest library for problem 2k38. In year 2038,all 32 bit processor will overflow for counting Date & Time. This java Library can help your 32 bit processor to count date & time correctly.If you use this library in your project, please give credit only.
Also you can contribute in this library.

@Use like this in your java project:


package your.package;
import org.toaha.Datter;
public class Main extends Datter {
  public static void main(String[] args) {

		String date = "11:59:57PM - 28/02/3028";
		
		Datter datter = new Datter();
		
		System.out.println("Initial DateTime: " + date);

		while (true) {
	    	date = datter.updateDateTime(date);

			System.out.println("Current Unix Time: " + datter.calculateUnixTime(date));
			
			System.out.println("Updated DateTime: " + date);
			
			try {
			
				Thread.sleep(1000);
				
			} catch (Exception e) {
			
				e.printStackTrace();
				
			}
		}
	}
}

Happy Computing.
