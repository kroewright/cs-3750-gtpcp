import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FeatureScreen extends JFrame {
	private ImageIcon header, footer, forum, whiteBoard, vidChat;
	private JLabel headerLabel, featurePrompt;
	private JButton forumButton, whiteBoardButton, vidChatButton, 
						helpButton, continueButton, goBackButton, exitButton;
	private JPanel featPanel, navigPanel, navigPanel2, headerPanel;
	
	public FeatureScreen(){
		super("Feature Selection");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,1));
		
		header = new ImageIcon("about.jpg");
		headerLabel = new JLabel(header);
		//headerPanel = new JPanel(new BorderLayout());
		add(headerLabel);
		
		headerPanel = new JPanel(new BorderLayout());
		featurePrompt = new JLabel("Please choose which features you'd like to open: ");
		headerPanel.add(featurePrompt, BorderLayout.NORTH);
			
		featPanel = new JPanel();
		forum = new ImageIcon("speechbubble_blue.png");
		forumButton = new JButton(forum);
		featPanel.add(forumButton);

		whiteBoard = new ImageIcon("Document-write-icon.png");
		whiteBoardButton = new JButton(whiteBoard);
		featPanel.add(whiteBoardButton);
		
		vidChat = new ImageIcon("video_conference_icon.jpg");
		vidChatButton = new JButton(vidChat);
		featPanel.add(vidChatButton);
		headerPanel.add(featPanel, BorderLayout.SOUTH);
		
		add(headerPanel);
		
		navigPanel = new JPanel(new GridLayout(2,1));
		navigPanel2 = new JPanel();
		
		goBackButton = new JButton("Back to Previous Screen");
		continueButton = new JButton("Continue");
		helpButton = new JButton("Help");
		exitButton = new JButton("Exit");
		
		navigPanel2.add(helpButton);
		navigPanel2.add(exitButton);
		navigPanel.add(goBackButton);
		navigPanel.add(continueButton);
		navigPanel.add(navigPanel2);
		
		add(navigPanel);
		//add(navigPanel2);
	}
	
}
