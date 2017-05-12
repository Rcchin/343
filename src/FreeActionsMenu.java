import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class FreeActionsMenu extends JFrame{
	private JPanel panel;
	private JLabel menuLabel;
	private JButton dropGroup;
	private JButton donate;
	
	public FreeActionsMenu() 
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
		dropGroup = new JButton();
		donate = new JButton();
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		//set label
		menuLabel.setBounds(180, 25, 160, 50);
		menuLabel.setForeground(Color.yellow);
		menuLabel.setFont(new Font(menuLabel.getName(), Font.PLAIN, 20));
		menuLabel.setText("Free Actions:");
		panel.add(menuLabel);
		
		//set drop group button
		dropGroup.setBounds(50, 100, 160, 40);
		dropGroup.setText("Drop Group");
		panel.add(dropGroup);
		
		//set donate button
		donate.setBounds(260, 100, 160, 40);
		donate.setText("Donate");
		panel.add(donate);
		
		dropGroup.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				
			}
		});
		
		donate.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				
			}
		});
		
		this.setContentPane(panel);
	}
}