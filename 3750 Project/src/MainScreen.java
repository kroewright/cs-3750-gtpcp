import javax.swing.*;

import chat2.ClientGUI;

import java.awt.*;
import java.awt.event.*;


public class MainScreen extends JFrame{

	private ImageIcon header, footer;
	private JLabel headerLabel, whiteBoardLabel, forumLabel, vidChatLabel;
	private JButton forumButton, whiteBoardButton, vidChatButton, 
						helpButton, archiveButton, goBackButton, exitButton;
	private JPanel whiteBoardPanel, forumPanel, vidChatPanel, buttonPanel;
	private JScrollPane scrolly;
	private JTextArea whiteboard;
	private ClientGUI chat;
	
	
	public MainScreen(int numFeats, String whichFeats){
		super("GT PD Communication Portal");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		header = new ImageIcon("about.jpg");
		headerLabel = new JLabel(header);
		add(headerLabel, BorderLayout.NORTH);
		
		whiteBoardPanel = new JPanel();
		whiteBoardPanel.setSize(200, 200);
		forumPanel = new JPanel();
		forumPanel.setSize(300,400);
		vidChatPanel = new JPanel();
		vidChatPanel.setSize(250,250);
		
		//whiteBoardLabel = new JLabel("WhiteBoard");
		//whiteBoardPanel.add(whiteBoardLabel);
		whiteboard = new JTextArea("This is the whiteboard, make notes here", 40,40);
		scrolly = new JScrollPane(whiteboard);
		whiteBoardPanel.add(scrolly);
		
		
		chat = new ClientGUI("localhost", 1500);
		//forumLabel = new JLabel(chat);
		forumPanel.add(chat);
		
		//vidChatLabel = new JLabel("");
		footer = new ImageIcon("head.jpg");
		vidChatLabel= new JLabel(footer);
		vidChatPanel.add(vidChatLabel);
		
		whiteBoardPanel.setVisible(false);
		forumPanel.setVisible(false);
		vidChatPanel.setVisible(false);
		
		add(whiteBoardPanel, BorderLayout.CENTER);
		add(forumPanel, BorderLayout.WEST);
		add(vidChatPanel, BorderLayout.EAST);
		
		
		
		if (numFeats == 3 && whichFeats == "all"){
//			add(whiteBoardPanel);
//			add(forumPanel);
//			add(vidChatPanel);
			whiteBoardPanel.setVisible(true);
			forumPanel.setVisible(true);
			vidChatPanel.setVisible(true);
			
		}
		else if(numFeats == 2 && whichFeats == "wb and vid"){
//			add(whiteBoardPanel);
//			add(vidChatPanel);
			whiteBoardPanel.setVisible(true);
			forumPanel.setVisible(false);
			vidChatPanel.setVisible(true);
		}
		else if(numFeats == 2 && whichFeats == "wb and forum"){
//			add(whiteBoardPanel);
//			add(forumPanel);
			whiteBoardPanel.setVisible(true);
			forumPanel.setVisible(true);
			vidChatPanel.setVisible(false);
		}
		
		else if(numFeats == 2 && whichFeats == "vid and forum"){
//			add(vidChatPanel);
//			add(forumPanel);
			
			whiteBoardPanel.setVisible(false);
			forumPanel.setVisible(true);
			vidChatPanel.setVisible(true);
		}
		else if(numFeats == 1 && whichFeats == "vid"){
//			add(vidChatPanel);
			whiteBoardPanel.setVisible(false);
			forumPanel.setVisible(false);
			vidChatPanel.setVisible(false);
		}
		else if(numFeats == 1 && whichFeats == "forum"){
//			add(forumPanel);
			whiteBoardPanel.setVisible(false);
			forumPanel.setVisible(true);
			vidChatPanel.setVisible(false);
		}
		else if(numFeats == 1 && whichFeats == "wb"){
//			add(whiteBoardPanel);
			whiteBoardPanel.setVisible(true);
			forumPanel.setVisible(false);
			vidChatPanel.setVisible(false);
		}
		
		buttonPanel = new JPanel(new GridLayout(2, 3));
		forumButton = new JButton("Forum");
		forumButton.addActionListener(new ForumListener());
		whiteBoardButton = new JButton("WhiteBoard");
		whiteBoardButton.addActionListener(new WBListener());
		vidChatButton = new JButton("VidChat");
		vidChatButton.addActionListener(new VCListener());
		
		archiveButton = new JButton("Search the Archive");
		archiveButton.addActionListener(new ArchListener());
		
		helpButton = new JButton("Help");
		helpButton.addActionListener(new HelpListener());
		
		exitButton = new JButton("Exit and Logout");
		exitButton.addActionListener(new ExitListener());
		
		buttonPanel.add(forumButton);
		buttonPanel.add(whiteBoardButton);
		buttonPanel.add(vidChatButton);
		buttonPanel.add(archiveButton);
		buttonPanel.add(helpButton);
		buttonPanel.add(exitButton);
		
		add(buttonPanel, BorderLayout.SOUTH);
		
	}
	
	private class ForumListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			boolean show = forumPanel.isVisible();
			forumPanel.setVisible(!show);
		}
	}
	private class WBListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			boolean show = whiteBoardPanel.isVisible();
			whiteBoardPanel.setVisible(!show);
		}
	}
	private class VCListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			boolean show = vidChatPanel.isVisible();
			vidChatPanel.setVisible(!show);
		}
	}
	
	private class HelpListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			HelpScreen halp = new HelpScreen();
			halp.pack();
			halp.setVisible(true);
		}
		
	}
		
	private class ExitListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(whiteBoardPanel, "You're logged out, goodbye!");
			System.exit(0);
		}
	}
	
	private class ArchListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ArchiveClass arch = new ArchiveClass();
			//arch.pack();
			arch.setVisible(true);
		}
	}	
	
//	public static void main(String[] args){
//		MainScreen test = new MainScreen(2, "vid");
//		test.pack();
//		test.setVisible(true);
//	}
}

