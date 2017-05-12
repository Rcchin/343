import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Card {

	private String name;
	private ArrayList<String> effect;
	private ArrayList<String> condition;
	private boolean bigger;
	private boolean isIllum;
	
	public Card(String n, ArrayList<String> e, ArrayList<String> c, boolean b, boolean i)
	{
		name = n;
		effect = e;
		condition = c;
		bigger = b;
		isIllum = i;
	}
	
	public String getName()
	{
		return name;
	}
	
	public ArrayList<String> getEffect()
	{
		return effect;
	}
	
	public ArrayList<String> getCondition()
	{
		return condition;
	}
	public ImageIcon getImageIcon()
	{
		if(isIllum)
			return new ImageIcon( "./src/Cards/IlluminatiCards/" + name + ".png");
		else
			return new ImageIcon( "./src/Cards/" + name + ".png");
	}
	public boolean showBigger()
	{
		return bigger;
	}
}
