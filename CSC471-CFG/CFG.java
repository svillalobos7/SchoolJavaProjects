/*Stephanie Villalobos
 * CSC471
 * Project2
 *  
 */
package Project2;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Vector;
public class CFG 
{
	Vector<String[]> cfg;
	ArrayList<String> nonTerminals;
	
	public CFG(Vector<String[]> cfg)
	{
		this.cfg = cfg;
		nonTerminals = new ArrayList<>();
		nonTerminals.add(cfg.get(0)[0]);
		
		for(int i = 1; i < cfg.size(); i++)
		{
			nonTerminals.add(cfg.get(i)[0]);
		}
		LinkedHashSet<String> s = new LinkedHashSet<String>();
		s.addAll(nonTerminals);
		nonTerminals.clear();
		nonTerminals.addAll(s);
	}
	
}
