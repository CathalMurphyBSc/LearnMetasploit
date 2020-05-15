package GUI;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BasicStructure 
{
	
	// get dimensions of current screen 
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	Double ResY = screenSize.getHeight();
	int resY = ResY.intValue();
	Double ResX = screenSize.getWidth();
	int resX = ResX.intValue();
	
	
	static CardLayout cl =  new CardLayout();
	public static JFrame frame = new JFrame("Learn Metasploit");
	public static JPanel deck = new JPanel();
		JPanel MainMenuCard = new cards.MainMenuPanel();
		JPanel LevelOneCard = new cards.LevelOnePanel();
		JPanel LevelTwoCard = new cards.LevelTwoPanel();
		JPanel LevelThreeCard = new cards.LevelThreePanel();

	
	
	public BasicStructure()
	{
		
		deck.setLayout(cl);
			deck.add(MainMenuCard, "1");
			deck.add(LevelOneCard, "3");
			deck.add(LevelTwoCard, "4");
			deck.add(LevelThreeCard, "5");
			
		frame.add(deck);
		frame.pack();
		frame.setResizable(false);
		deck.setBorder(new EmptyBorder(200, 300, 200, 300));
		deck.setBackground(new Color(23,98,131));
		
		Double width = frame.getSize().getWidth();
		int aWidth = width.intValue();
		Double height = frame.getSize().getHeight();
		int aHeight = height.intValue();
		
		int loc1 = resX/2 - (aWidth/2);
		int loc2 = resY/2 - (aHeight/2);
		
		frame.setLocation((loc1),(loc2));
		frame.setVisible(true);
		
	}
	
	
	
	public static void gotoCard(String x)
	{
		if(x == "1")
		{
			deck.setBorder(new EmptyBorder(200, 300, 200, 300));
		}
		else if(x == "2") 
		{
			deck.setBorder(new EmptyBorder(50, 50, 50, 50));
		}
		else if(x == "3") 
		{
			deck.setBorder(new EmptyBorder(50, 50, 50, 50));
		}
		else if(x == "4") 
		{
			deck.setBorder(new EmptyBorder(50, 50, 50, 50));
		}
		else if(x == "5")
		{
			deck.setBorder(new EmptyBorder(50, 50, 50, 50));
		}
		cl.show(deck, x);
	}
	
	public static Dimension getScreenSize()
	{
		Double width = frame.getSize().getWidth();
		Double height = frame.getSize().getHeight();
		
		width = (width - 200) / 2 ;
		Double anotherWidth = width - (2/8 * width);
		
		height = (height - 200)/2;
		Double anotherHeight = height -(2/6 * height);
		
		//return frame.getSize();
		System.out.println(anotherWidth + " and " + anotherHeight);
		
		int finalWidth = anotherWidth.intValue();
		int finalHeight = anotherHeight.intValue();
		
		return new Dimension(finalWidth,finalHeight);
	}
	
	public static void main(String args[])
	{
		BasicStructure instance = new BasicStructure();
		
	}
	
	

}
