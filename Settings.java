import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Settings extends JFrame{

		private JPanel panel;
		private JButton option1;
		private JButton option2;
		private JButton option3;
		private JButton back;
		private JLabel background_label;
	public Settings() 
	{
		initComponents();		
	}
	private void initComponents()
	{
		//instantiate JPanel
		panel = new JPanel();
		
		//instantiate JButtons
		option1 = new JButton();
		option2 = new JButton();
		option3 = new JButton();
		back = new JButton();
		
		//instantiate JLabel (background image)
		background_label = new JLabel();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
				
		panel.setLayout(null);
		
		//set back button
		 back.setIcon(new ImageIcon( "./src/back.PNG"   ) );
		 //add info button to the panel
		 panel.add(back);
		 back.setBounds(30, 510, 40, 37);
		 
		 back.addActionListener(new java.awt.event.ActionListener()
			{
				public void actionPerformed(java.awt.event.ActionEvent evt)
				{
					dispose();
					GUILayout gui = new GUILayout();
					gui.setVisible(true);
					gui.setResizable(false);
					gui.setSize(1310, 570);
					gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				}
			});
			
		 
		//set playAI button
		 option1.setIcon(new ImageIcon( "./src/1280.PNG"   ) );
		 //add info button to the panel
		 panel.add(option1);
		 option1.setBounds(400,300,483,44);
		 
		//set play2 mode
		 option2.setIcon(new ImageIcon( "./src/1680.PNG"   ) );
		 //add info button to the panel
		 panel.add(option2);
		 option2.setBounds(400, 400, 483, 44);
		 
		//set play2 mode
		 option3.setIcon(new ImageIcon( "./src/1920.PNG"   ) );
		 //add info button to the panel
		 panel.add(option3);
		 option3.setBounds(400, 500, 483, 44);
		 
		
		//add the background image
	       background_label.setIcon(new javax.swing.ImageIcon("./src/background.PNG")); 
	       // add the background image to the panel 
	       panel.add(background_label);
	        background_label.setBounds(0, 0, 1310, 570);
	        
	        
	        this.setContentPane(panel);
				
				
				
	}
	
}
