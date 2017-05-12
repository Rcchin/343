import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Settings extends JFrame{
//declare variables
		private JPanel panel;
		private JCheckBox easy,medium,hard,on,off;
		private JButton back;
		private JLabel background_label;
		Main music;
		private Sound s;
		
	public Settings() 
	{
		music = new Main();
	//This first part gets the standby or options music.
		s = new Sound("./src/standby.wav");
	//runs method to open panel
		initComponents();		
	}
	private void initComponents()
	{
		//instantiate JPanel and other components.
		panel = new JPanel();
		
	
		back = new JButton();
		//plays music
		boolean check = music.getMute();
		if( check == true)
		{
		s.play();
		}
		
		//instantiate JLabel (background image)
		background_label = new JLabel();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
				
		panel.setLayout(null);
		
		//set back button
		 back.setIcon(new ImageIcon( "./src/back.PNG"   ) );
		 //add info button to the panel
		 panel.add(back);
		 back.setBounds(30, 510, 40, 37);
		 
		 //action listener for back
		 back.addActionListener(new java.awt.event.ActionListener()
			{
				public void actionPerformed(java.awt.event.ActionEvent evt)
				{
					s.stop();
					dispose();
					GUILayout gui = new GUILayout();
					gui.setVisible(true);
					gui.setResizable(false);
					gui.setSize(1310, 600);
					gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				}
			});
			
		 
	
		 
		//set up check boxes
		 //creates a box component to hold checkboxes and put it on the panel
		 Box botBox = Box.createVerticalBox();
		 
		 //initializes check boxes
	        easy = new JCheckBox("Easy");
	        medium = new JCheckBox("Medium");
	        hard = new JCheckBox("Hard");
	     //creates buttongroup so you can only select one option
	        ButtonGroup botGroup = new ButtonGroup();
	        botGroup.add(easy);
	        botGroup.add(medium);
	        botGroup.add(hard);
	      //adds to box  
	        botBox.add(easy);
	        botBox.add(medium);
	        botBox.add(hard);
	       //changes setting of box so you can change the color to anything.
	        botBox.setOpaque(true);
	        botBox.setBackground(Color.gray);
	      //gives border so you can read the option
	        botBox.setBorder(BorderFactory.createTitledBorder("AI Difficulty Setting:"));
	      //adds to panel and sets size.
	        panel.add(botBox);
	       
	        botBox.setBounds(575,400,200,100);
	       
	        Box topBox = Box.createVerticalBox();
	        //initializes check boxes
	        on = new JCheckBox("ON");
	        off = new JCheckBox("OFF");
	        
	     //creates buttongroup so you can only select one option
	        ButtonGroup topGroup = new ButtonGroup();
	        topGroup.add(on);
	        topGroup.add(off);
	      
	      //adds to box  
	        topBox.add(on);
	        topBox.add(off);
	        
	       //changes setting of box so you can change the color to anything.
	        topBox.setOpaque(true);
	        topBox.setBackground(Color.gray);
	      //gives border so you can read the option
	        topBox.setBorder(BorderFactory.createTitledBorder("Music Setting:"));
	      //adds to panel and sets size.
	        panel.add(topBox);
	       
	        topBox.setBounds(575,300,200,100);
	        
	        //add action listener for topBox or music setting
	        on.addActionListener(new java.awt.event.ActionListener()
			{
				public void actionPerformed(java.awt.event.ActionEvent evt)
				{
					s.play();
					music.setMute(true);

				}
			});
	        
	        off.addActionListener(new java.awt.event.ActionListener()
			{
				public void actionPerformed(java.awt.event.ActionEvent evt)
				{
					s.stop();
					music.setMute(false);

				}
			});
		
		//add the background image
	       background_label.setIcon(new javax.swing.ImageIcon("./src/background.PNG")); 
	       // add the background image to the panel 
	       panel.add(background_label);
	        background_label.setBounds(0, 0, 1310, 570);
	        
	        
	        this.setContentPane(panel);
				
				
				
	}

	

	
}
