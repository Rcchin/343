import java.util.ArrayList;

import javax.swing.ImageIcon;


public class GroupCard extends Card{

	private int power;
	private int transfer;
	private int resist;
	private int income;
	private int origPower;
	//private int origTransfer;
	private int origResist;
	private ArrayList<String> allign;
	//0 is inward arrow; 1 is outward arrow; -1 is none
	private int up;
	private int down;
	private int left;
	private int right;
	//private boolean isIllum;
	
	public GroupCard(String n, ArrayList<String> e, ArrayList<String> c,
	boolean b, boolean illum, int p, int t, int r, int i, ArrayList<String> a, int u,
	int ri, int d, int l) {
		super(n, e, c, b, illum);
		power = p; transfer = t; resist = r; income = i; 
		allign = a; //isIllum = illum;
		up = u; down = d; left = l; right = ri;
		origPower = power; origResist = resist;
	}
	public int getPower()
	{
		return power;
	}
	public int getTransfer()
	{
		return transfer;
	}
	public int getResist()
	{
		return resist;
	}
	public int getIncome()
	{
		return income;
	}
	public ArrayList<String> getAllign()
	{
		return allign;
	}
	public int getUp()
	{
		return up;
	}
	public int getDown()
	{
		return down;
	}
	public int getLeft()
	{
		return left;
	}
	public int getRight()
	{
		return right;
	}
	public void setPower(int p)
	{
		power = p;
	}
	public void setResist(int r)
	{
		resist = r;
	}
}
