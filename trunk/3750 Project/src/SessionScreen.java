import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class SessionScreen extends JFrame {
	private ImageIcon header, footer;
	private JPanel sessions;
	private JButton create, join;
	private JTextField seshIDField, seshPassField;
	private JLabel prompt, seshID, seshPass, headerLabel;
	
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
		
		sessions = new JPanel(new GridLayout(3,2));
		seshID = new JLabel("Session ID: ");
		seshIDField = new JTextField(10);
		sessions.add(seshID);
		sessions.add(seshIDField);
		
		seshPass = new JLabel("Session Password: ");
		seshPassField = new JTextField(10);
		sessions.add(seshPass);
		sessions.add(seshPassField);
		
		create = new JButton("Generate a Session ID/Password");
		create.addActionListener(new CreateListener());
		join = new JButton("Join a Current Session");
		join.addActionListener(new JoinListener());
		sessions.add(create);
		sessions.add(join);
		
		add(sessions, BorderLayout.SOUTH);
	}
	
	private class CreateListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
		}
	}
	
	private class JoinListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
		}
		
	}
}