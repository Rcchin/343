

import javax.swing.*;
import java.awt.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.sound.*;

import sun.audio.*;
public class GUILayout extends JFrame 
{
	//private variables declaration
	//declare the buttons
	//along with the JLabel that will store the background image
	private JButton info;
	private JButton play;
	private JButton quit;
	private JButton settings;
	private JLabel background_label;
	private JPanel panel;
	private Sound s;
	private Main music;
	
	//constructor for this class
	public GUILayout() 
	{
		music = new Main();
		s = new Sound("./src/main.wav");
		initComponents();
	    
	}
	
	private void initComponents()
	{
	
		
		//instantiate JPanel
		panel = new JPanel();
		
		//instantiate JButtons
		play = new JButton();
		info = new JButton();
		settings = new JButton();
		quit = new JButton();
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
		
		//set the Icon for the play button
		play.setIcon(new ImageIcon("./src/play.PNG"));
		
		play.addActionListener(new java.awt.event.ActionListener() 
		{
		
			
			
		
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				
				s.stop();
				PlayMenu gui = new PlayMenu();
				gui.setVisible(true);
				gui.setResizable(false);
				gui.setSize(1310, 600);
				gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			
				  
				dispose();
				
			}
		});
		
		info.addActionListener(new java.awt.event.ActionListener()
				{
					public void actionPerformed(java.awt.event.ActionEvent evt)
					{
						
						try {
						    Desktop.getDesktop().browse(new URL("https://github.com/Rcchin/343/blob/master/IlluminatiPlayerManual.pdf").toURI());
						} catch (Exception e) {}
					}
				});
		
		quit.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				
				System.exit(0);
			}
		});
		
		settings.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				s.stop();
				Settings gui = new Settings();
				gui.setVisible(true);
				gui.setResizable(false);
				gui.setSize(1310, 600);
				gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				dispose();
				
			}
		});
		
		
		 //add play button to the panel
		panel.add(play);
		 play.setBounds(30, 360, 40, 40);
		 
		 
		 
		 //set the Icon for the info button
		 info.setIcon(new ImageIcon( "./src/info.PNG"   ) );
		 //add info button to the panel
		 panel.add(info);
		 info.setBounds(30,410,40,33);
		
		 
		 //set the Icon for the settings button
		 settings.setIcon(new javax.swing.ImageIcon("./src/settings.PNG"));
		 //add settings button the the panel
	        panel.add(settings);
	        settings.setBounds(30, 460, 40, 40);
	      
	        //set the Icon for the quit button
	        quit.setIcon(new javax.swing.ImageIcon("./src/quit.PNG")); 
	        //add quit button to the panel
	        panel.add(quit);
	       
	        quit.setBounds(30, 510, 40, 37);
	       
	        
	        //add the background image
	       background_label.setIcon(new javax.swing.ImageIcon("./src/background.PNG")); 
	       // add the background image to the panel 
	       panel.add(background_label);
	        background_label.setBounds(0, 0, 1310, 600);
	        
	      		 
		this.setContentPane(panel);
		
		
	}
	

	
}