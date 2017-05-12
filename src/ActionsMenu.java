import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
public class ActionsMenu extends JFrame{
	private JPanel panel;
	private JLabel menuLabel;
	private JButton attack;
	private JButton moneyTransfer;
	private JButton moveGroup;
	private JButton back; //not needed
	
	public ActionsMenu() 
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
		attack = new JButton();
		moneyTransfer = new JButton();
		moveGroup = new JButton();
		//back = new JButton(); not needed
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		//set label
		menuLabel.setBounds(200, 25, 100, 50);
		menuLabel.setForeground(Color.yellow);
		menuLabel.setFont(new Font(menuLabel.getName(), Font.PLAIN, 20));
		menuLabel.setText("Actions:");
		panel.add(menuLabel);
		
		//set attack button
		attack.setBounds(50, 100, 160, 40);
		attack.setText("Attack");
		panel.add(attack);
		
		//set moneyTransfer button
		moneyTransfer.setBounds(260, 100, 160, 40);
		moneyTransfer.setText("Money Transfer");
		panel.add(moneyTransfer);
		
		//set moveGroup button
		moveGroup.setBounds(155, 180, 160, 40);
		moveGroup.setText("Move Group");
		panel.add(moveGroup);
		
		
		attack.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				AttackMenu ac = new AttackMenu();
				ac.setVisible(true);
				ac.setResizable(false);
				ac.setAlwaysOnTop(true);
				ac.setSize(500, 300);
				ac.setLocation(1280/3, 800/3);
				ac.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		
		moneyTransfer.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				
			}
		});
		
		moveGroup.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				
			}
		});
		
		this.setContentPane(panel);
	}
}
