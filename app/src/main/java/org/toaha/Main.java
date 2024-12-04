package org.toaha;

import org.toaha.Datter;



/* 
 A greatest library for problem 2k38 for your 32bit processor.It is Main Java class.Controll full library like this Main.java. 
 
 Learn more about here: https://en.m.wikipedia.org/wiki/Year_2038_problem

@If you use my library in your project or anywhere, please give me credit only.

@Author: Hasin Israk Toaha (SSC 2025)(Constant T)
    Facebook: facebook.com/constant.t.10/   
    Mail: toaha.banaripara@gmail.com
    
@   Written in JavaNIDE ,in 12:17AM, 04/12/2024
@Happy Coding!

*/



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
