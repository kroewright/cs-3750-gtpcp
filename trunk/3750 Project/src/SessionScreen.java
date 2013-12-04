import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class SessionScreen extends JFrame {
	private ImageIcon header, footer;
	private JPanel sessions;
	private JButton create, join, help, exit;
	private JTextField officeIDField, seshIDField;
	private JPasswordField seshPassField;
	private JLabel prompt, officeID, seshID, seshPass, headerLabel;
	
	public SessionScreen(){
		super("Join/Create Session");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		header = new ImageIcon("about.jpg");
		headerLabel = new JLabel(header);
		
		add(headerLabel, BorderLayout.NORTH);

		prompt = new JLabel("<html>Use your session ID and password to join a session "
				+ "already in progress or choose create session ID to start a new session.<br><br></html>");
		add(prompt, BorderLayout.CENTER);
		
		sessions = new JPanel(new GridLayout(5,2));
		
		officeID = new JLabel("Office ID: ");
		officeIDField = new JTextField(10);
		sessions.add(officeID);
		sessions.add(officeIDField);
		
		seshID = new JLabel("Session ID: ");
		seshIDField = new JTextField(10);
		sessions.add(seshID);
		sessions.add(seshIDField);
		
		seshPass = new JLabel("Session Password: ");
		seshPassField = new JPasswordField(10);
		sessions.add(seshPass);
		sessions.add(seshPassField);
		
		create = new JButton("Generate a Session ID/Password");
		create.addActionListener(new CreateListener());
		join = new JButton("Join a Current Session");
		join.addActionListener(new JoinListener());
		sessions.add(create);
		sessions.add(join);
		
		help = new JButton("Help");
		help.addActionListener(new HelpListener());
		exit = new JButton("Exit");
		exit.addActionListener(new ExitListener());
		
		sessions.add(help);
		sessions.add(exit);
		
		add(sessions, BorderLayout.SOUTH);
	}
	
	private class CreateListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			seshIDField.setText("12345");
			seshPassField.setText("12345");
			//generates or otherwise gets new session info
		}
	}
	
	private class JoinListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//transmits the session ID/pass/office ID info to wherever it needs to go
			
			JOptionPane.showMessageDialog(sessions, "Welcome to your session!");
			FeatureScreen feats = new FeatureScreen();
			feats.pack();
			feats.setVisible(true);
			setVisible(false);
			
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
			JOptionPane.showMessageDialog(sessions, "You're logged out, goodbye!");
			System.exit(0);
		}
	}
}