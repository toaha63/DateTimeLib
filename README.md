# DateTimeLib
A greatest library for problem 2k38. In years 2038, all 32-bit processors will overflow for counting Date & Time. This Java library can help your 32-bit processor to count date & time correctly. If you use this library in your project, please give credit only. Also, you can contribute to this library.

## Usage
You need to set current time manually.Then, your 32 bit processor can automatic count time. Use it like this in your Java project:

```java
package your.package;

import org.toaha.Datter;

public class Main extends Datter
{
    public static void main(String[] args)
    {
        String date = "03:14:07PM - 19/01/2038"; //Maintain this format always.
        
        Datter datter = new Datter();
        
        System.out.println("Initial DateTime: " + date);

        while(true)
        {
            date = datter.updateDateTime(date);

            System.out.println("Current Unix Time: " + datter.calculateUnixTime(date));
            System.out.println("Updated DateTime: " + date);
            
            try
            {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
