
import javax.swing.JFrame;
public class Main {
	public static boolean mute = true;
	public static void main(String[] args) 
	{
		GUILayout gui = new GUILayout();
		gui.setVisible(true);
		gui.setResizable(false);
		gui.setSize(1310, 600);
		gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		

	}
	
	public boolean getMute()
	{
		return mute;
	}
	public void setMute(boolean flag)
	{
		mute = flag;
	}
	


}