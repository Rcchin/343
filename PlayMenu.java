import javax.swing.*;

public class PlayMenu extends JFrame{

		private JPanel panel;
		private JButton playAI;
		private JButton play2;
		private JButton back;
		private JLabel background_label;
	public PlayMenu() 
	{
		initComponents();		
	}
	private void initComponents()
	{
		//instantiate JPanel
		panel = new JPanel();
		
		//instantiate JButtons
		playAI = new JButton();
		play2 = new JButton();
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
		 playAI.setIcon(new ImageIcon( "./src/play1.PNG"   ) );
		 //add info button to the panel
		 panel.add(playAI);
		 playAI.setBounds(400,300,484,39);
		 
		//set play2 mode
		 play2.setIcon(new ImageIcon( "./src/play2.PNG"   ) );
		 //add info button to the panel
		 panel.add(play2);
		 play2.setBounds(400, 400, 484, 39);
		 
		
		//add the background image
	       background_label.setIcon(new javax.swing.ImageIcon("./src/background.PNG")); 
	       // add the background image to the panel 
	       panel.add(background_label);
	        background_label.setBounds(0, 0, 1310, 570);
	        
	        
	        this.setContentPane(panel);
				
				
				
	}
	
}
