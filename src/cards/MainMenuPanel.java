package cards;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;


public class MainMenuPanel extends JPanel implements ActionListener 
{
	public static JButton levelIntro, levelOne, levelTwo, levelThree, exitProgram;
	GridBagConstraints gbc = new GridBagConstraints();
	
	public MainMenuPanel()
	{
		setLayout(new GridBagLayout());
		Border raisedBorder1 = BorderFactory.createLineBorder(new Color(211,211,211),3);
		this.setBorder(raisedBorder1);
		
		Font font1 = new Font("Courier", Font.BOLD,20);
		Font font2 = new Font("Courier", Font.BOLD,15); 
		
		JLabel welcome = new JLabel("Learning Metasploit");
		welcome.setFont(font1);
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 3;
			gbc.insets = new Insets(5,5,5,5);
			gbc.fill = GridBagConstraints.HORIZONTAL;
		add(welcome,gbc);
		
		/*
		levelIntro = new JButton("Introduction.");
		levelIntro.setFont(font2);
		levelIntro.setHorizontalAlignment(SwingConstants.CENTER);
		levelIntro.addActionListener(this);
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.gridwidth = 3;
			gbc.fill = GridBagConstraints.HORIZONTAL;
		add(levelIntro,gbc);
		*/
		
		levelOne = new JButton("Level One.");
		levelOne.setFont(font2);
		levelOne.setHorizontalAlignment(SwingConstants.CENTER);
		levelOne.addActionListener(this);
			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.gridwidth = 3;
			gbc.fill = GridBagConstraints.HORIZONTAL;
		add(levelOne,gbc);
		
		levelTwo = new JButton("Level Two.");
		levelTwo.setFont(font2);
		levelTwo.setHorizontalAlignment(SwingConstants.CENTER);
		levelTwo.addActionListener(this);
			gbc.gridx = 0;
			gbc.gridy = 3;
			gbc.gridwidth = 3;
			gbc.fill = GridBagConstraints.HORIZONTAL;
		add(levelTwo,gbc);
		
		levelThree = new JButton("Level Three.");
		levelThree.setFont(font2);
		levelThree.setHorizontalAlignment(SwingConstants.CENTER);
		levelThree.addActionListener(this);
			gbc.gridx = 0;
			gbc.gridy = 4;
			gbc.gridwidth = 3;
			gbc.fill = GridBagConstraints.HORIZONTAL;
		add(levelThree,gbc);
		
		exitProgram = new JButton("Exit Program");
		exitProgram.setFont(font2);
		exitProgram.setHorizontalAlignment(SwingConstants.CENTER);
		exitProgram.addActionListener(this);
			gbc.gridx = 0;
			gbc.gridy = 5;
			gbc.gridwidth = 3;
			gbc.fill = GridBagConstraints.HORIZONTAL;
		add(exitProgram,gbc);
		
		

		this.setBackground(new Color(6,152,114));
		setPreferredSize(new Dimension(1300,900));
		
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == levelIntro)
		{
			GUI.BasicStructure.gotoCard("2");
		}
		else if(e.getSource() == levelOne)
		{
			GUI.BasicStructure.gotoCard("3");
		}
		else if(e.getSource() == levelTwo)
		{
			GUI.BasicStructure.gotoCard("4");

		}
		else if(e.getSource() == levelThree)
		{
			GUI.BasicStructure.gotoCard("5");

		}
		else if(e.getSource() == exitProgram)
		{
			System.exit(0);
		}
		
	}
	
}
