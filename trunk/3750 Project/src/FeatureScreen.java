import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FeatureScreen extends JFrame {
	private ImageIcon header, footer, forum, whiteBoard, vidChat;
	private JLabel headerLabel, featurePrompt;
	private JButton forumButton, whiteBoardButton, vidChatButton, searchArch,
						helpButton, continueButton, goBackButton, exitButton;
	private JPanel featPanel, navigPanel, navigPanel2, headerPanel, fPanel, wbPanel, vcPanel;
	private JCheckBox forumBox, whiteBoardBox, vidChatBox;
	
	public FeatureScreen(){
		super("Feature Selection");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		header = new ImageIcon("about.jpg");
		headerLabel = new JLabel(header);
		
		headerPanel = new JPanel(new BorderLayout());
		featurePrompt = new JLabel("Please choose which features you'd like to open: ");
		headerPanel.add(headerLabel, BorderLayout.NORTH);
		headerPanel.add(featurePrompt,BorderLayout.SOUTH);
		add(headerPanel);
			
		featPanel = new JPanel();
		
		fPanel = new JPanel(new BorderLayout());
		
		forum = new ImageIcon("speechbubble_blue.png");
		forumButton = new JButton(forum);
		forumButton.addActionListener(new ForumListener());
		forumBox = new JCheckBox("Forum/Chat");
		fPanel.add(forumButton, BorderLayout.NORTH);
		fPanel.add(forumBox);
		
		featPanel.add(fPanel);

		wbPanel = new JPanel(new BorderLayout());
		whiteBoard = new ImageIcon("Document-write-icon.png");
		whiteBoardButton = new JButton(whiteBoard);
		whiteBoardButton.addActionListener(new WBListener());
		whiteBoardBox = new JCheckBox("WhiteBoard");
		wbPanel.add(whiteBoardButton, BorderLayout.NORTH);
		wbPanel.add(whiteBoardBox, BorderLayout.SOUTH);
		featPanel.add(wbPanel);
		
		vcPanel = new JPanel(new BorderLayout());
		vidChat = new ImageIcon("video_conference_icon.jpg");
		vidChatButton = new JButton(vidChat);
		vidChatButton.addActionListener(new VidListener());
		vidChatBox = new JCheckBox("VideoChat");
		vcPanel.add(vidChatButton, BorderLayout.NORTH);
		vcPanel.add(vidChatBox, BorderLayout.SOUTH);
		featPanel.add(vcPanel);
		add(featPanel);
			
		navigPanel = new JPanel();
		navigPanel2 = new JPanel();
		JPanel navigPanel3 = new JPanel(new GridLayout(2,1));
		
		//goBackButton = new JButton("Back to Previous Screen");
		//goBackButton.addActionListener(new ReturnListener());
		continueButton = new JButton("Continue");
		continueButton.addActionListener(new ContinueListener());
		helpButton = new JButton("Help");
		helpButton.addActionListener(new HelpListener());
		searchArch = new JButton("Search the Archives");
		searchArch.addActionListener(new ArchListener());
		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ExitListener());
		
		navigPanel2.add(helpButton);
		navigPanel.add(searchArch);
		navigPanel2.add(exitButton);
		//navigPanel.add(goBackButton);
		navigPanel.add(continueButton);
			
		navigPanel3.add(navigPanel);
		navigPanel3.add(navigPanel2);
		
		add(navigPanel3);
	}
	
	private class ForumListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			forumBox.setSelected(!forumBox.isSelected());
		}
	}
	private class WBListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			whiteBoardBox.setSelected(!whiteBoardBox.isSelected());
			
		}
	}
	private class VidListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			vidChatBox.setSelected(!vidChatBox.isSelected());
		}
	}
	
	private class ContinueListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			boolean vid, forum, board;
			MainScreen mainScreen;
			
			vid = vidChatBox.isSelected();
			forum = forumBox.isSelected();
			board = whiteBoardBox.isSelected();
			
			if (vid && forum && board){
				mainScreen = new MainScreen(3, "all");
				mainScreen.pack();
				mainScreen.setVisible(true);
				setVisible(false);
			}
			else if(vid && forum && !board){
				mainScreen = new MainScreen(2, "vid and forum");
				mainScreen.pack();
				mainScreen.setVisible(true);
				setVisible(false);
			}
			else if (vid && !forum && board){
				mainScreen = new MainScreen(2, "wb and vid");
				mainScreen.pack();
				mainScreen.setVisible(true);
				setVisible(false);
			}
			else if (!vid && forum && board){
				mainScreen = new MainScreen(2, "wb and forum");
				mainScreen.pack();
				mainScreen.setVisible(true);
				setVisible(false);
			}
			else if (vid && !forum && !board){
				mainScreen = new MainScreen(1, "vid");
				mainScreen.pack();
				mainScreen.setVisible(true);
				setVisible(false);
			}
			else if(!vid && forum && !board){
				mainScreen = new MainScreen(1, "forum");
				mainScreen.pack();
				mainScreen.setVisible(true);
				setVisible(false);
			}
			else if(!vid && !forum && board){
				mainScreen = new MainScreen(1, "wb");
				mainScreen.pack();
				mainScreen.setVisible(true);
				setVisible(false);
			}
			else{
				JOptionPane.showMessageDialog(featPanel, "You must choose at least 1 feature to open.");
			}
			
		}
		
	}
	
	private class HelpListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			HelpScreen halp = new HelpScreen();
			halp.pack();
			halp.setVisible(true);
		}
		
	}
	
//	private class ReturnListener implements ActionListener{
//		public void actionPerformed(ActionEvent e){
//			screen.setVisible(true);
//			setVisible(false);
//		}
		
	private class ExitListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(featPanel, "You're logged out, goodbye!");
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
}
