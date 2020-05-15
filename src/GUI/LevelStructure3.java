package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.border.Border;
import org.json.simple.parser.ParseException;

public class LevelStructure3 implements ActionListener
{
	static GridBagConstraints gbc = new GridBagConstraints();
	
	static JButton mainMenuButton, enterButton, hintButton;
	static JTextArea metasploitOutputTextArea, taskOutPutArea;
	static JTextField metasploitInputTextField;
	static JPanel center_NorthPanel;
	static JScrollPane scrollPane;

	static Color bgColor = new Color(211,211,211);
	//new Color(6,152,114)
	// new Color(211,211,211)
	static Color darkBgColor = new Color(65,65,65);

	static int consoleCounter = 0;
	static String consoleNumber = "0";
	static int argumentType = 0;
	static int numberOfThreads = 0;
	static String currentHint = " ";
	//static Scanner reader;

	//static Scanner reader;

	
	
	
	public static JPanel levelStructure3()
	{
		JPanel levelStructure = new JPanel();
		levelStructure.setLayout(new BorderLayout());
	   	Border raisedBorder1 = BorderFactory.createLineBorder(new Color(189,189,189),3);
		
		Font font1 = new Font("Courier", Font.BOLD,20);
		Font font2 = new Font("Courier", Font.BOLD,15);
		Font font3 = new Font("Courier", Font.BOLD,13);

		
		
		/* This section sets up the west part of the level that contains 
		 * main menu button and Metasploit image
		 */
	
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new GridBagLayout());
		westPanel.setBackground(bgColor);
			
			JPanel west_NorthPanel = new JPanel();
			west_NorthPanel.setLayout(new GridLayout(4,1));
			mainMenuButton = new JButton("Return to Menu");
			//mainMenuButton.setBackground(bgColor);
			
			mainMenuButton.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {if(e.getSource() == mainMenuButton){GUI.BasicStructure.gotoCard("1");}}});
			west_NorthPanel.setBackground(bgColor);
			west_NorthPanel.add(mainMenuButton);
			
			final JButton hintButton = new JButton("Ask for a hint");
			hintButton.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {if(e.getSource() == hintButton){getHint();}}});
			west_NorthPanel.add(hintButton);
			
			final JButton connectButton = new JButton("Connect to Console");
			connectButton.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {if(e.getSource() == connectButton){consoleConnect(); taskOutPutArea.setText("1. Great! Now you are connected to the Metasploit Framework. Type 'nmap 192.168.1.101' to scan the target computer!");GUI.BasicStructure.gotoCard("1");GUI.BasicStructure.gotoCard("5");}}});
			west_NorthPanel.add(connectButton);
			
			final JButton resetButton = new JButton("Reset Console");
			resetButton.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {if(e.getSource() == resetButton){try {resetConsole();} catch (IOException e1) {e1.printStackTrace();} catch (ParseException e1) {e1.printStackTrace();}}}});
			west_NorthPanel.add(resetButton);


			gbc.gridx = 0;
	   		gbc.gridy = 0;
	   		gbc.gridwidth = 1;
	   		gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			
	   		westPanel.add(west_NorthPanel,gbc);
						
			JPanel west_SouthPanel = new JPanel();
			JLabel imageLabel = new JLabel();
			west_SouthPanel.setBackground(bgColor);
			west_SouthPanel.add(imageLabel);
			
			gbc.gridx = 0;
	   		gbc.gridy = 1;
	   		gbc.gridwidth = 1;
	   		gbc.weightx = 1.0;
			gbc.weighty = 1.0;
	   		
	   		westPanel.add(west_SouthPanel,gbc);
	   		
	
			
		/* This section sets up the center part of the level that contains 
		 * Metasploit Instance and allows user to enter commands
		 */
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setBackground(bgColor);

			JPanel center_NorthPanel = new JPanel();
				center_NorthPanel.setLayout(new BorderLayout());
				JLabel metasploitLabel = new JLabel("Metasploit Framework");
				metasploitLabel.setForeground(new Color(0,0,0));
				metasploitLabel.setBackground(new Color(189,189,189));
				metasploitLabel.setHorizontalAlignment(SwingConstants.CENTER);
				metasploitLabel.setOpaque(true);
				center_NorthPanel.setBackground(bgColor);
				center_NorthPanel.add(metasploitLabel, BorderLayout.NORTH);
				
				metasploitOutputTextArea = new JTextArea(10,80);
				//metasploitOutputTextArea.setLineWrap(true);
				metasploitOutputTextArea.setColumns(80);
				metasploitOutputTextArea.setFont(new Font("Courier", Font.BOLD,11));
				metasploitOutputTextArea.setBackground(darkBgColor);
				metasploitOutputTextArea.setForeground(new Color(0,201,0));
				scrollPane = new JScrollPane(metasploitOutputTextArea);
				center_NorthPanel.add(scrollPane, BorderLayout.CENTER);
			
			center_NorthPanel.setBorder(raisedBorder1);
			centerPanel.add(center_NorthPanel, BorderLayout.CENTER);
			
			JPanel center_SouthPanel = new JPanel();
				center_SouthPanel.setLayout(new GridBagLayout());
				metasploitInputTextField = new JTextField(30);
				metasploitInputTextField.addKeyListener(new KeyListener() 
					{
						public void keyPressed(java.awt.event.KeyEvent e) 
						{
							if(e.getKeyCode() == KeyEvent.VK_ENTER)
							{
										
								 if(consoleCounter !=0)
									try {
										if(metasploitInputTextField.getText() != "exit" && consoleCounter == 1 )
										{
											metasploitOutputTextArea.append("\nUser > "+metasploitInputTextField.getText() + "\n" + "\n");
											String input =	metasploitInputTextField.getText();
											nextHelpText(input);
											
											
											scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
											scrollPane.getHorizontalScrollBar().setValue(scrollPane.getHorizontalScrollBar().getMinimum());
											
											char[] argument = new char[input.length()];
											argument = input.toCharArray();
											
											if(argument[0] == 'n' && argument[1] == 'm' && argument[2] == 'a' && argument[3] == 'p')	
											{
												//System.out.println("thats nmap alright");
												input = input + " > nmap.txt";
												argumentType = 1;
											}
											else
											{
												argumentType = 0;

											}
											
											
											metasploit.metasploitConsole.consoleInterface(input, consoleNumber);

											SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
												
												@Override
												protected Void doInBackground() throws Exception {
													numberOfThreads = 1;

													if(argumentType == 1)
													{
														

														BufferedReader reader = new BufferedReader(new FileReader("/root/nmap.txt"));


														
														String textResponse = metasploit.metasploitConsole.consoleResponse(consoleNumber).toString();
														metasploitOutputTextArea.append(textResponse);


														for(int i=0; i<30; i++)
														{

															if (nmapProcess(reader) == true)
															{
																scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
															}
															

														}
														reader.close();

													}
													else
													{
														for(int i=0; i<30; i++)
														{
															if (processInput() == true)
															{
																scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
															}

														}
													}

													return null;
												}
												
											};
											if(numberOfThreads != 0)
											{
												numberOfThreads = 0;
												worker.cancel(true);
												
												
												worker = new SwingWorker<Void, Void>() {
													
													@Override
													
													protected Void doInBackground() throws Exception {
														numberOfThreads = 1;

														if(argumentType == 1)
														{
															

															BufferedReader reader = new BufferedReader(new FileReader("/root/nmap.txt"));


															
															String textResponse = metasploit.metasploitConsole.consoleResponse(consoleNumber).toString();
															metasploitOutputTextArea.append(textResponse);


															for(int i=0; i<30; i++)
															{

																if (nmapProcess(reader) == true)
																{
																	scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
																}
																

															}
															reader.close();

														}
														else
														{
															for(int i=0; i<30; i++)
															{
																if (processInput() == true)
																{
																	scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
																}

															}
														}

														return null;
													}
													
												};
												
												
												
												
								
												worker.execute();
											}
											else
											{
												worker.execute();
											}
											
											
											
											
											metasploitInputTextField.setText("");
										}
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
							}
						}
		
						@Override
						public void keyReleased(KeyEvent e) 
						{
							// TODO Auto-generated method stub
							
						}
		
						@Override
						public void keyTyped(KeyEvent e) 
						{
							// TODO Auto-generated method stub
						}
						});
					
				
				
				gbc.gridx = 0;
		   		gbc.gridy = 0;
		   		gbc.gridwidth = 1;
		   		gbc.fill = GridBagConstraints.HORIZONTAL;
		   		center_SouthPanel.setBackground(bgColor);
		   		center_SouthPanel.add(metasploitInputTextField,gbc);
		   		
				enterButton = new JButton("Submit");
				enterButton.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) 
				{if(consoleCounter !=0)
					try {
						if(metasploitInputTextField.getText() != "exit" && consoleCounter == 1 )
						{
							metasploitOutputTextArea.append("\nUser > "+metasploitInputTextField.getText() + "\n" + "\n");
							String input =	metasploitInputTextField.getText();
							
							
							scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
							scrollPane.getHorizontalScrollBar().setValue(scrollPane.getHorizontalScrollBar().getMinimum());
							
							char[] argument = new char[input.length()];
							argument = input.toCharArray();
							
							if(argument[0] == 'n' && argument[1] == 'm' && argument[2] == 'a' && argument[3] == 'p')	
							{
								//System.out.println("thats nmap alright");
								input = input + " > nmap.txt";
								argumentType = 1;
							}
							else
							{
								argumentType = 0;

							}
							
							
							metasploit.metasploitConsole.consoleInterface(input, consoleNumber);
							
							
							SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
								
								@Override
								
								protected Void doInBackground() throws Exception {
									numberOfThreads = 1;

									if(argumentType == 1)
									{
										

										BufferedReader reader = new BufferedReader(new FileReader("/root/nmap.txt"));


										
										String textResponse = metasploit.metasploitConsole.consoleResponse(consoleNumber).toString();
										metasploitOutputTextArea.append(textResponse);


										for(int i=0; i<30; i++)
										{

											if (nmapProcess(reader) == true)
											{
												scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
											}
											

										}
										reader.close();

									}
									else
									{
										for(int i=0; i<30; i++)
										{
											if (processInput() == true)
											{
												scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
											}

										}
									}

									return null;
								}
								
							};
							if(numberOfThreads != 0)
							{
								numberOfThreads = 0;
								worker.cancel(true);
								
								
								worker = new SwingWorker<Void, Void>() {
									
									@Override
									
									protected Void doInBackground() throws Exception {
										numberOfThreads = 1;

										if(argumentType == 1)
										{
											

											BufferedReader reader = new BufferedReader(new FileReader("/root/nmap.txt"));


											
											String textResponse = metasploit.metasploitConsole.consoleResponse(consoleNumber).toString();
											metasploitOutputTextArea.append(textResponse);


											for(int i=0; i<30; i++)
											{

												if (nmapProcess(reader) == true)
												{
													scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
												}
												

											}
											reader.close();

										}
										else
										{
											for(int i=0; i<30; i++)
											{
												if (processInput() == true)
												{
													scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
												}

											}
										}

										return null;
									}
									
								};
								
								
								
								
				
								worker.execute();
							}
							else
							{
								worker.execute();
							}
							
							
							
							metasploitInputTextField.setText("");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}});

				gbc.gridx = 1;
		   		gbc.gridy = 0;
		   		gbc.gridwidth = 1;
		   		gbc.fill = GridBagConstraints.HORIZONTAL;
		   		center_SouthPanel.add(enterButton,gbc);

		   	center_SouthPanel.setBorder(raisedBorder1);
			centerPanel.add(center_SouthPanel, BorderLayout.SOUTH);

			
			

		
		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new GridBagLayout());
		eastPanel.setBackground(bgColor);
			
		
			JPanel east_NorthPanel = new JPanel();
			east_NorthPanel.setLayout(new GridBagLayout());
			east_NorthPanel.setBackground(bgColor);
			
			taskOutPutArea = new JTextArea(20,35);
			taskOutPutArea.setLineWrap(true);
			taskOutPutArea.setWrapStyleWord(true);
			taskOutPutArea.setText("Welcome to Level One! To get started click 'Connect to Console' on the left!");
			taskOutPutArea.setFont(font3);
			taskOutPutArea.setBackground(new Color(0,0,0,0));
			taskOutPutArea.setEditable(false);
			
			JScrollPane scrollPane2 = new JScrollPane(taskOutPutArea);
		
			
			
			gbc.gridx = 0;
	   		gbc.gridy = 0;
	   		gbc.gridwidth = 2;
	   		gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			east_NorthPanel.add(scrollPane2,gbc);

			
			gbc.gridx = 0;
	   		gbc.gridy = 0;
	   		gbc.gridwidth = 1;
	   		gbc.weightx = 1.0;
			gbc.weighty = 1.0;
	   		eastPanel.add(east_NorthPanel,gbc);
					
	   		
			JPanel east_SouthPanel = new JPanel();
			JLabel imageLabel2 = new JLabel();
			URL url = LevelStructure.class.getResource("/images/metasploit-og1.png");
			ImageIcon metasploitIcon2 = new ImageIcon(url);
			
			imageLabel2.setIcon(metasploitIcon2);
			
			east_SouthPanel.setBackground(bgColor);
			east_SouthPanel.add(imageLabel2);
			
			gbc.gridx = 0;
	   		gbc.gridy = 1;
	   		gbc.gridwidth = 1;
	   		gbc.weightx = 1.0;
			gbc.weighty = 1.0;
	   		
	   		eastPanel.add(east_SouthPanel,gbc);

		levelStructure.add(westPanel, BorderLayout.WEST);
		levelStructure.add(centerPanel, BorderLayout.CENTER);
		levelStructure.add(eastPanel, BorderLayout.EAST);
		return levelStructure;

		
	
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static Boolean processInput()
	{
		Boolean isNotEmpty = false;
		try {
		
			
			String textResponse;
			
				textResponse = metasploit.metasploitConsole.consoleResponse(consoleNumber).toString();
				if(!textResponse.equals(""))
				{
					metasploitOutputTextArea.append(textResponse);
					isNotEmpty = true;
					Thread.sleep(20);
					return isNotEmpty;
				}
				else
				{
					Thread.sleep(500);
					return isNotEmpty;
				}
				
				
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isNotEmpty;
		
	}
	
	public static Boolean nmapProcess(BufferedReader reader)
	{
		Boolean isNotEmpty = false;
		
		
		
		try {
			String line;
			while((line = reader.readLine()) != null)
			{
				metasploitOutputTextArea.append(line + "\n");
				
				isNotEmpty = true;

			}
			if((line = reader.readLine()) == null) {
				Thread.sleep(500);
				return isNotEmpty;

			}
			
			Thread.sleep(10);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isNotEmpty;
	}
	
	public static void consoleConnect()
	{
		if(consoleCounter == 0)
		{

			consoleCounter = 1;
			
			metasploitOutputTextArea.setText("");
			consoleNumber = metasploit.metasploitConsole.createConsoleInstance(metasploit.metasploitConsole.authToken());
			metasploitOutputTextArea.append(metasploit.metasploitConsole.consoleResponse(consoleNumber).toString());
		}
		else
		{
			metasploitOutputTextArea.append("\n#! CONSOLE ALREADY ENABLED");

		}
	}

	public static void resetConsole() throws IOException, ParseException
	{
		if(consoleCounter == 1)
		{
			metasploit.metasploitConsole.deleteConsoleResp(consoleNumber);
			metasploitOutputTextArea.setText("");
			consoleCounter = 0;
		}
		else
		{
			metasploitOutputTextArea.append("\n#! NO CURRENT CONSOLE ENABLED");
		}
		
	}
	
	public static void nextHelpText(String input)
	{
		switch(input) 
		{
		case "nmap 192.168.1.101":
			taskOutPutArea.setText("2. The target seems to be running an SSH service on port 22. Type 'search ssh_login' to find a brute force module!\n \nCompletion: 12.5%");
			currentHint = "\n#!: Type 'search ssh_login'";
			GUI.BasicStructure.gotoCard("1");
			GUI.BasicStructure.gotoCard("5");
			break;
		case "search ssh_login":
			taskOutPutArea.setText("3. Select the ssh_login module. Make sure you choose the one without the _pubkey suffix.\n \nCompletion: 25%");
			currentHint = "\n#!: Type 'use auxiliary/scanner/ssh/ssh_login'";
			GUI.BasicStructure.gotoCard("1");
			GUI.BasicStructure.gotoCard("5");
			break;
		case "use auxiliary/scanner/ssh/ssh_login":
			taskOutPutArea.setText("4. Display the options for this module.\n \nCompletion: 37.5%");
			currentHint = "\n#!: Type 'show options'";
			GUI.BasicStructure.gotoCard("1");
			GUI.BasicStructure.gotoCard("5");
			break;
		case "show options":
			taskOutPutArea.setText("5. Set the RHOSTS parameter to the target IP address.\n \nCompletion: 50%");
			currentHint = "\n#!: Type 'set RHOSTS 192.168.1.101'";
			GUI.BasicStructure.gotoCard("1");
			GUI.BasicStructure.gotoCard("5");
			break;
		case "set RHOSTS 192.168.1.101":
			taskOutPutArea.setText("6. Set the verbose option to 'true'.\n \nCompletion: 62.5%");
			currentHint = "\n#!: Type 'set VERBOSE true'";
			GUI.BasicStructure.gotoCard("1");
			GUI.BasicStructure.gotoCard("5");
			break;
		case "set VERBOSE true":
			taskOutPutArea.setText("7. Next set the STOP_ON_SUCCESS parameter to 'true'.\n \nCompletion: 75%");
			currentHint = "\n#!: Type 'set STOP_ON_SUCCESS true";
			GUI.BasicStructure.gotoCard("1");
			GUI.BasicStructure.gotoCard("5");
			break;
		case "set STOP_ON_SUCCESS true":
			taskOutPutArea.setText("8. Next we have to set the USERPASS_FILE perameter. Set it to '/root/userpass_file.txt'\n \nCompletion: 87.5%");
			currentHint = "\n#!: Type 'set USERPASS_FILE /root/userpass_file.txt";
			GUI.BasicStructure.gotoCard("1");
			GUI.BasicStructure.gotoCard("5");
			break;
		case "set USERPASS_FILE /root/userpass_file.txt":
			taskOutPutArea.setText("Now that the exploit is set up, run it!\n \nCompletion: 100%!");
			currentHint = "\n#!: Type 'exploit'";
			GUI.BasicStructure.gotoCard("1");
			GUI.BasicStructure.gotoCard("5");
			break;
		case "exploit":
			taskOutPutArea.setText("Wait until the console says a Command Shell Session is opened and then type sessions -l to lsit the sessions available.");
			currentHint = "\n#!: Type 'sessions -l";
			GUI.BasicStructure.gotoCard("1");
			GUI.BasicStructure.gotoCard("5");
			break;
		case "run":
			taskOutPutArea.setText("Wait until the console says a Command Shell Session is opened and then type sessions -l to lsit the sessions available.");
			currentHint = "\n#!: Type 'sessions -l";
			GUI.BasicStructure.gotoCard("1");
			GUI.BasicStructure.gotoCard("5");
			break;
		case "sessions -l":
			taskOutPutArea.setText("Now you must connect to the console by typing 'sessions -i #' where the # is the number of the session created.");
			currentHint = "\n#!: Type 'sessions -i #' where # is your session number.";
			GUI.BasicStructure.gotoCard("1");
			GUI.BasicStructure.gotoCard("5");
			break;
		case "whoami":
			taskOutPutArea.setText("Congratulations, you appear to be logged in as msfadmin! You have successfully hacked into this computer!");
			currentHint = "\n#!: You have completed all of the levels, Congrats!";
			GUI.BasicStructure.gotoCard("1");
			GUI.BasicStructure.gotoCard("5");
			break;
			
			
	
		}
		
		char[] inputArray = input.toCharArray();
		
		if(inputArray[0] == 's' && inputArray[1] == 'e' && inputArray[2] == 's' && inputArray[3] == 's' && inputArray[4] == 'i' && inputArray[5] == 'o' && inputArray[6] == 'n' && inputArray[7] == 's' && inputArray[8] == ' ' && inputArray[9] == '-' && inputArray[10] == 'i')
			{
			
			taskOutPutArea.setText("Now you have connected to the victims computer! Type 'whoami' to see what user you are logged in as!");
			currentHint = "\n#!: Type 'whoami";
			GUI.BasicStructure.gotoCard("1");
			GUI.BasicStructure.gotoCard("5");
					
			}
		
		
			
	}
	
	public static void getHint()
	{
		
		
		
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			
			@Override
			
			protected Void doInBackground() throws Exception {
		
				metasploitOutputTextArea.append(currentHint);
				Thread.sleep(10);
				scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
				scrollPane.getHorizontalScrollBar().setValue(scrollPane.getHorizontalScrollBar().getMinimum());

				return null;
			}
			
		};
		
		worker.execute();

		
	}
	

}
