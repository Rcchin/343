import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
public class AttackMenu extends JFrame{
	private JPanel panel;
	private JLabel menuLabel;
	private JButton control;
	private JButton neutralize;
	private JButton destroy;
	private JButton back; //not needed
	
	public AttackMenu() 
	{
		initComponents();		
	}

	private void initComponents() {
		//initiate JPanel
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.gray);
		
		//initiate label
		menuLabel = new JLabel();
		
		//initiate buttons
		control = new JButton();
		neutralize = new JButton();
		destroy = new JButton();
		back = new JButton();
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		//set label
		menuLabel.setBounds(200, 25, 100, 50);
		menuLabel.setForeground(Color.yellow);
		menuLabel.setFont(new Font(menuLabel.getName(), Font.PLAIN, 20));
		menuLabel.setText("Attack:");
		panel.add(menuLabel);
		
		//set attack to control button
		control.setBounds(50, 100, 160, 40);
		control.setText("Attack to Control");
		panel.add(control);
		
		//set attack to neutralize button
		neutralize.setBounds(260, 100, 160, 40);
		neutralize.setText("Attack to Neutralize");
		panel.add(neutralize);
		
		//set attack to destroy button
		destroy.setBounds(155, 180, 160, 40);
		destroy.setText("Attack to Destroy");
		panel.add(destroy);
		
		//set back button
		back.setIcon(new ImageIcon( "./src/back.PNG"   ) );
		panel.add(back);
		back.setBounds(20, 230, 40, 37);
		 
		back.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				
				ActionsMenu ac = new ActionsMenu();
				ac.setVisible(true);
				ac.setResizable(false);
				ac.setSize(500, 300);
				ac.setLocation(1280/3, 800/3);
				ac.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		
		control.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				
			}
		});
		
		neutralize.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				
			}
		});
		
		destroy.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				
			}
		});
		
		this.setContentPane(panel);
	}
}

