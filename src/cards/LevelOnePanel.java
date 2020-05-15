/*
 * The approach to all of the cards is that we use the framework created in the LevelStructure
 * class for the main and unchanging parts of each level. LevelStructure expects a JPanel to be passed
 * into it when called. This is because it expects the contextual help panel to be fed into it which is created in each 
 * level panel. Contextual help is the only thing that changes between levels.
 */

package cards;
import javax.swing.JPanel;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import GUI.LevelStructure;

public class LevelOnePanel extends JPanel implements ActionListener 
{
	public static JButton returnToMenuButton;
	GridBagConstraints gbc = new GridBagConstraints();
	
	
	
	// Colours and Fonts for all the family!
	static Color bgColor = new Color(211,211,211);
	static Color darkBgColor = new Color(65,65,65);
	Font font1 = new Font("Courier", Font.BOLD,20);
	Font font2 = new Font("Courier", Font.BOLD,15);
	Font font3 = new Font("Courier", Font.BOLD,13);
	JButton nextButton, previousButton;


	
	public LevelOnePanel()
	{
		setLayout(new GridLayout(0,1));
		Border raisedBorder1 = BorderFactory.createLineBorder(new Color(211,211,211),3);
		this.setBorder(raisedBorder1);

		JPanel levelStructure = LevelStructure.levelStructure();
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 1;
			gbc.insets = new Insets(0,0,0,0);
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.fill = GridBagConstraints.HORIZONTAL;
		add(levelStructure,gbc);
		
		
		
	

	}
	
	
	/*
	public JPanel east_NorthPanel()
	{
		JPanel east_NorthPanel = new JPanel();
		east_NorthPanel.setLayout(new GridBagLayout());
		east_NorthPanel.setBackground(bgColor);
		
		taskOutPutArea = new JTextArea(20,35);
		//taskOutPutArea.setLineWrap(true);
		taskOutPutArea.setWrapStyleWord(true);
		taskOutPutArea.setFont(font3);
		taskOutPutArea.setBackground(new Color(0,0,0,0));
		taskOutPutArea.setEditable(true);
		
		JScrollPane scrollPane2 = new JScrollPane(taskOutPutArea);
		scrollPane2.getVerticalScrollBar().setValue(scrollPane2.getVerticalScrollBar().getMaximum());
		scrollPane2.getHorizontalScrollBar().setValue(scrollPane2.getHorizontalScrollBar().getMaximum());
		scrollPane2.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);

			gbc.gridx = 0;
	   		gbc.gridy = 0;
	   		gbc.gridwidth = 2;
	   		gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			east_NorthPanel.add(scrollPane2,gbc);

		
	
		previousButton = new JButton("<---");
		//previousButton.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {if(e.getSource() == previousButton){taskOutPutArea.setText(null);}}});
		previousButton.addActionListener(this);
			gbc.gridx = 0;
	   		gbc.gridy = 1;
	   		gbc.gridwidth = 1;
	   		gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			east_NorthPanel.add(previousButton,gbc);
	
		
		nextButton = new JButton("--->");
		//nextButton.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {if(e.getSource() == nextButton){;;}}});
		nextButton.addActionListener(this);
			gbc.gridx = 1;
	   		gbc.gridy = 1;
	   		gbc.gridwidth = 1;
	   		gbc.weightx = 1.0;
			gbc.weighty = 1.0;
		
		east_NorthPanel.add(nextButton,gbc);
		
		return east_NorthPanel;
	}
	*/
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == returnToMenuButton)
		{
			GUI.BasicStructure.gotoCard("1");			
		}
		
		
	}
	
	

	
	
	
}
