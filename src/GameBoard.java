import java.awt.Color;
import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;
public class GameBoard extends JFrame{
	private JPanel panel;
	private JPanel boardPanel;
	private JPanel menuPanel;
	private JButton actions;
	private JButton freeActions;
	private JButton endTurn;
	private JButton quit;
	private JLabel actionLeftLabel;
	private JLabel player1Label;
	private JLabel player2Label;
	private int numActions = 2;
	private CardPanel[][] boardGrid = new CardPanel[10][9];
	private String illum1;
	private String illum2;
	private ArrayList<Card> illum = new ArrayList<Card> ();
	private String player1;
	private String player2;
	private Sound s;
	private Main music;
	
	public GameBoard(String p1, String p2) 
	{
		music = new Main();
		s = new Sound("./src/game.wav");
		player1 = p1;
		if(p2 == null)
			player2 = "A.I.";
		else
			player2 = p2;
		initComponents();		
	}

	private void initComponents() {
		
		//plays music
		boolean check = music.getMute();
		if( check == true)
		{
			s.play();
		}
		//initiate JPanels
		panel = new JPanel();
		boardPanel = new JPanel();
		menuPanel = new JPanel();
		
		panel.setLayout(null);
		boardPanel.setLayout(null);
		menuPanel.setLayout(null);
		
		menuPanel.setBackground(Color.gray);
		menuPanel.setBounds(0,0,1280,50);
		
		boardPanel.setBackground(Color.black);
		boardPanel.setBounds(0,50,1280,750);
		
		
		//initiate buttons
		actions = new JButton();
		freeActions = new JButton();
		endTurn = new JButton();
		quit = new JButton();
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		//set actions button
		actions.setBounds(50, 5, 160, 40);
		actions.setText("Actions");
		menuPanel.add(actions);
		
		//set free actions button
		freeActions.setBounds(260, 5, 160, 40);
		freeActions.setText("Free Actions");
		menuPanel.add(freeActions);
		
		//set end turn button
		endTurn.setBounds(490, 5, 160, 40);
		endTurn.setBackground(new Color(249,73,73));//only works for Windows	
		endTurn.setText("End Turn");
		menuPanel.add(endTurn);
		
		//initiate labels
		String text = "Actions Left: " + numActions;
		actionLeftLabel = new JLabel(text, JLabel.CENTER);
		player1Label = new JLabel(player1, JLabel.CENTER);
		player2Label = new JLabel(player2, JLabel.CENTER);
		
		//set JLabel
		actionLeftLabel.setBounds(720, 5, 160, 40);
		player2Label.setBounds(1200, 50, 80, 40);
		player1Label.setBounds(1200, 650, 80, 40);
		
			//create border for label
			Border border = BorderFactory.createLineBorder(Color.black, 2);
			actionLeftLabel.setBorder(border);
			add(actionLeftLabel);
		
		actionLeftLabel.setBackground(new Color(255,255,153));
		actionLeftLabel.setOpaque(true);
		menuPanel.add(actionLeftLabel);
		
		player1Label.setForeground(Color.white);
		boardPanel.add(player1Label);
		
		player2Label.setForeground(Color.white);
		boardPanel.add(player2Label);
		
		//set quit game button
		quit.setIcon(new ImageIcon( "./src/quit.PNG"   ) );
		menuPanel.add(quit);
		quit.setBounds(1230, 5, 40, 37);
		
		actions.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				ActionsMenu ac = new ActionsMenu();
				ac.setVisible(true);
				ac.setResizable(false);
				ac.setAlwaysOnTop(true);
				ac.setSize(500, 300);
				ac.setLocation(1280/3, 800/3);
				ac.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		
		freeActions.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				FreeActionsMenu fac = new FreeActionsMenu();
				fac.setVisible(true);
				fac.setResizable(false);
				fac.setAlwaysOnTop(true);
				fac.setSize(500, 300);
				fac.setLocation(1280/3, 800/3);
				fac.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		
		quit.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				s.stop();
				dispose();
				//Maybe add code to go back to game menu?
				PlayMenu gui = new PlayMenu();
				gui.setVisible(true);
				gui.setResizable(false);
				gui.setSize(1310, 600);
				gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		
		//file directory to folder with the Illuminati Cards
		File dir = new File("./src/Cards/IlluminatiCards");
		
		//file array to hold the Illuminati Card files
		File [] IlluminatiCards = dir.listFiles();
		Random randomNum = new Random();
		
		//generate 2 random numbers.
		//these will be used to select the Illuminati card based on index
		int cardindex1 =  randomNum.nextInt(7) + 1;
		int cardindex2 = randomNum.nextInt(7) + 1;
		
		//if Index2 == Index1, then generate another random number
		while (cardindex2 == cardindex1)
		{
			cardindex2 = randomNum.nextInt(7) + 1;
		}
		
		
		//display both Illuminati cards
		 JOptionPane.showMessageDialog(null, " ", "Player 1 Illuminati", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("./src/Cards/IlluminatiCards/"+IlluminatiCards[cardindex1].getName()) );
		 JOptionPane.showMessageDialog(null, " ", "Player 2 Illuminati", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("./src/Cards/IlluminatiCards/"+IlluminatiCards[cardindex2].getName()) );
		
		illum1 = IlluminatiCards[cardindex1].getName();
		illum2 = IlluminatiCards[cardindex2].getName();
		
		illum.add(new Card("CardBack", null, null, false, false));
		illum.add(new Card("CardBack", null, null, false, false));
		
		//read file to get info about cards' stats
		 try {
			Scanner in = new Scanner(new File("./src/CardStats.txt"));
			String[] stats = new String[14];
			while(in.hasNextLine())
			{
				String s = in.nextLine();
				stats = s.trim().split("\\s*,\\s*"); 
				if((stats[0] + ".PNG").equals(illum1))
				{
					illum.set(0,new GroupCard(stats[0], null, null, true, true, 
							Integer.parseInt(stats[5]), Integer.parseInt(stats[6]), 
							Integer.parseInt(stats[7]), Integer.parseInt(stats[8]), 
							null, Integer.parseInt(stats[10]), Integer.parseInt(stats[11]), 
							Integer.parseInt(stats[12]), Integer.parseInt(stats[13])));
				}
				else if((stats[0]+ ".PNG").equals(illum2))
				{
					illum.set(1,new GroupCard(stats[0], null, null, true, true, 
							Integer.parseInt(stats[5]), Integer.parseInt(stats[6]), 
							Integer.parseInt(stats[7]), Integer.parseInt(stats[8]), 
							null, Integer.parseInt(stats[10]), Integer.parseInt(stats[11]), 
							Integer.parseInt(stats[12]), Integer.parseInt(stats[13])));
				}
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		 
		drawInitialBoard(); 
		this.setContentPane(panel);
		panel.add(boardPanel);
		panel.add(menuPanel);
						
	}
	public void resetActionLabel()
	{
		numActions = 2;
		actionLeftLabel.setText("Actions Left: " + numActions);
	}
	public void decreaseActionLabel()
	{
		if(numActions > 0)
			numActions--;
		actionLeftLabel.setText("Actions Left: " + numActions);
	}
	public void drawInitialBoard()
	{
		//Code to add grid of panels to board
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				CardPanel c = new CardPanel(null, i, j);
				boardGrid[i][j] = c;
				c.setBounds((i*120),j*80,120,80);
				//Setup borders
				Border b;
				if(i == 0 && j == 3)
					b = BorderFactory.createLineBorder(Color.yellow, 3);//Deck
				else if(i == 0 && j == 5)
					b = BorderFactory.createLineBorder(Color.magenta, 3);//Discard Pile
				else if(j == 0)
					b = BorderFactory.createLineBorder(Color.red, 3);//Player2's Specials
				else if(j == 8)
					b = BorderFactory.createLineBorder(Color.blue, 3);//Player1's Specials
				else if(i == 4 && j == 2)
					b = BorderFactory.createLineBorder(new Color(102,0,0), 3);//Dark Red Player2's Illuminati
				else if(i == 7 && j == 6)
					b = BorderFactory.createLineBorder(new Color(0,0,102), 3);//Dark Blue Player1's Illuminati
				else if(i == 1 || (i == 0 && j != 4))
					b = BorderFactory.createLineBorder(Color.green, 3);//Uncontrolled Groups
				else if(i == 0)
					b = BorderFactory.createLineBorder(Color.white, 1);//Not used panels
				else
					b = BorderFactory.createLineBorder(Color.gray, 3);//Regular
				c.setBackground(Color.black);
				c.setBorder(b);
				boardPanel.add(c);
			}
		}
		boardGrid[0][3].setCard(new Card("CardBack", null, null, false, false));
		boardGrid[8][6].setCard(new GroupCard("California", null, null, true, false, 
				5, -1, 4, 5, null, 1, -1, 1, 0));
		boardGrid[8][6].setBorder(BorderFactory.createLineBorder(new Color(0,0,102), 3));
		
		boardGrid[6][6].setCard(new GroupCard("Big Media", null, null, true, false, 
				4, 3, 6, 3, null, 1, 0, 1, 1));
		boardGrid[6][6].setBorder(BorderFactory.createLineBorder(new Color(0,0,102), 3));
		
		boardGrid[6][2].setCard(new GroupCard("Comic Books", null, null, true, false, 
				1, -1, 1, 2, null, 1, -1, -1, 0));
		boardGrid[6][2].setBorder(BorderFactory.createLineBorder(new Color(102,0,0), 3));
		
		boardGrid[5][2].setCard(new GroupCard("Congressional Wives", null, null, true, false,
				1, -1, 4, 1, null, -1, 1, -1, 0));
		boardGrid[5][2].setBorder(BorderFactory.createLineBorder(new Color(102,0,0), 3));
		
		boardGrid[1][7].setCard(new GroupCard("KGB", null, null, true, false,
				2, 2, 6, 0, null, -1, 0, 1, -1));
		
		boardGrid[7][6].setCard(illum.get(0));
		boardGrid[4][2].setCard(illum.get(1));
		
	}
}
