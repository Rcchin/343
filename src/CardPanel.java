import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.border.Border;

public class CardPanel extends JPanel{

	private Card card;
	private JLabel image;
	private int xCoord;
	private int yCoord;
	public CardPanel(Card c, int x, int y)
	{
		card = c;
		xCoord = x;
		yCoord = y;
		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		image = new JLabel();
		image.setBounds(2,0,120,80);//Images need to fit into this area
		if(card != null)
		{
			add(image, SwingConstants.CENTER);
		}
		
	}
	private void addHover()
	{
		if(card != null)
		{
			addMouseListener(new java.awt.event.MouseListener()
			{
				JFrame bigImage = new JFrame();
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
					JPanel panel = new JPanel();
					JLabel imageLabel = new JLabel();
					
					panel.setLayout(null);
					panel.setBackground(Color.black);
					panel.setBounds(0,0,350,250);
					
					imageLabel.setBounds(0,0,350,240);
					imageLabel.setIcon(scaleImage(350,240));
					
					panel.add(imageLabel, SwingConstants.CENTER);
					bigImage.setContentPane(panel);
					
					bigImage.setVisible(true);
					bigImage.setResizable(false);
					bigImage.setSize(350, 250);
					bigImage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
					bigImage.dispose();
				}
				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		
	}
	public Card getCard()
	{
		return card;
	}
	
	public void setCard(Card c)
	{
		if(card == null)
		{
			card = c;
			image.setIcon(scaleImage(115,77));
			add(image, SwingConstants.CENTER);
			if(card.showBigger())
				addHover();
		}
		else
		{
			card = c;
			image.setIcon(scaleImage(115,77));
		}
	}
	public ImageIcon scaleImage(int w, int h)
    {
		ImageIcon icon = card.getImageIcon(); // load the image to a imageIcon
		Image i = icon.getImage(); // transform it 
		Image newimg = i.getScaledInstance(w, h,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		icon = new ImageIcon(newimg);  // transform it back
		return icon;
    }
}
