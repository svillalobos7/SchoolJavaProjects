/* Stephanie Villalobos
 * CSC471
 * Project2
 *  
 */
package Project2;
import java.io.File;
import java.util.Scanner;
import java.util.Vector;

public class readfile 
{
	private Scanner x;
	
	public void openFile()
	{
		try
		{
			x = new Scanner(new File("/Users/stephanievillalobos/Desktop/readtext.txt"));
		}
		catch(Exception e)
		{
			System.out.println("count not locate file");
		}
	
		while(x.hasNext()) 
		{
			
			String s = x.nextLine();
			System.out.println(s);
			
		}
	
		x.close();
	}
}
