
import java.awt.event.ActionEvent;

import javax.swing.*;

public class PlayMenu extends JFrame{

		private JPanel panel;
		private JButton playAI;
		private JButton play2;
		private JButton back;
		private JLabel background_label;
		private Sound s;
		private Main music;
	
		
	public PlayMenu() 
	{
		music = new Main();
		s = new Sound("./src/standby.wav");
		initComponents();		
	}
	private void initComponents()
	{
		//plays music
		boolean check = music.getMute();
		if( check == true)
		{
			s.play();
		}
				
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
					s.stop();
					dispose();
					GUILayout gui = new GUILayout();
					gui.setVisible(true);
					gui.setResizable(false);
					gui.setSize(1310, 600);
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
	        
	        //when user clicks to play in AI mode, they are prompted to enter their name.
	        playAI.addActionListener(new java.awt.event.ActionListener()
	        {

				@Override
				public void actionPerformed(ActionEvent e) 
				{
				
					s.stop();
					//option window comes up prompting the user to enter their name.
					String playerName_AI = JOptionPane.showInputDialog("Enter your player name ");
					
					//if the user didn't type anything don't proceed
					if (playerName_AI == null || playerName_AI.length() < 1)
					{
						dispose();
						PlayMenu pm = new PlayMenu();
						pm.setVisible(true);
						pm.setResizable(false);
						pm.setSize(1310, 570);
						pm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
					
					//otherwise, display the GameBoard
					else  
					{
						dispose();
						GameBoard board = new GameBoard(playerName_AI, null);
						board.setVisible(true);
						board.setResizable(false);
						board.setSize(1280, 800);
						board.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
					
					
					
				}

				
	        	
	        });
	        
	      //when user clicks to play in 2 Player mode, they are prompted to enter their name.
	        play2.addActionListener(new java.awt.event.ActionListener()
	        	{
	        	
	        		
	        	
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						s.stop();
						//boolean values to ensure that names have been entered for Player1 and Player2
						boolean name_validate1 = false , name_validate2 = false;
						
						//window to prompt player 1 to enter their name.
						String playerName1 = JOptionPane.showInputDialog("Enter Player 1 Name ");
						
						String playerName2 = null;
						//if player 1 Name field is empty, don't proceed.
						if (playerName1 == null || playerName1.length() < 1)
						{
							dispose();
							PlayMenu pm = new PlayMenu();
							pm.setVisible(true);
							pm.setResizable(false);
							pm.setSize(1310, 570);
							pm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						}
						else
						{
							//player 1 name validation has passed
							name_validate1 = true;
							
							//window to prompt player 2 to enter their name
							playerName2 = JOptionPane.showInputDialog("Enter Player 2 Name ");
							
							//if player 2 name field is empty, don't proceed.
							if (playerName2 == null || playerName2.length() < 1)
							{
								dispose();
								PlayMenu pm = new PlayMenu();
								pm.setVisible(true);
								pm.setResizable(false);
								pm.setSize(1310, 570);
								pm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							}
							else
							{
								//player 2 name validation has passed
								name_validate2 = true;
							}
							
						}
						
						//if both name validations have passed, then show the game board
						if(name_validate1 && name_validate2 == true)
						{
							dispose();
							GameBoard board = new GameBoard(playerName1, playerName2);
							board.setVisible(true);
							board.setResizable(false);
							board.setSize(1280, 800);
							board.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						}
						
						
						
					}
	        		
	        	}
	        		);
	        
	        this.setContentPane(panel);
				
				
				
	}
	
}

