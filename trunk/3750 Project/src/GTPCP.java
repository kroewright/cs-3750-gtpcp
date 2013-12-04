import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class GTPCP extends JFrame {
	private ImageIcon header, footer;
	private JButton login, createUser, exitButton, helpButton;
	private JLabel headerLabel, footerLabel, welcomeLabel, 
					unPrompt, passPrompt;
	private JTextField username;
	private JPasswordField password;
	private JPanel buttonPanel, loginPanel, exitPanel;
	
	public GTPCP(){
		super("GTPCP");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		header = new ImageIcon("about.jpg");
		headerLabel = new JLabel(header);
		
		add(headerLabel);
		
		welcomeLabel = new JLabel("<html>Welcome to the Georgia Tech Police Communication Portal<br><br>"
				+ "Please log in with your username and password or create a new account below</html>");
		
		unPrompt = new JLabel("Username: ");
		username = new JTextField(10);
		
		passPrompt = new JLabel("Password: ");
		password = new JPasswordField(10);
		
		loginPanel = new JPanel(new GridLayout(5,1));
		loginPanel.add(welcomeLabel);
		loginPanel.add(unPrompt);
		loginPanel.add(username);
		loginPanel.add(passPrompt);
		loginPanel.add(password);
		
		add(loginPanel);
		
		login = new JButton("Login");
		login.addActionListener(new LoginListener());
		
		createUser = new JButton("Create Account");
		createUser.addActionListener(new CreateListener());
		
		buttonPanel = new JPanel();
		buttonPanel.add(createUser);
		buttonPanel.add(login);
		
		add(buttonPanel);
		
		helpButton = new JButton("Help");
		helpButton.addActionListener(new HelpListener());
		
		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ExitListener());
		
		
		exitPanel = new JPanel();
		exitPanel.add(helpButton);
		exitPanel.add(exitButton);
		add(exitPanel);
	}
	
	private class LoginListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//JOptionPane woo = new JOptionPane();
			JOptionPane.showMessageDialog(loginPanel, "You're Logged In!");
			SessionScreen sesh = new SessionScreen();
			sesh.pack();
			sesh.setVisible(true);
			setVisible(false);
	
		}	
	}
	
	private class CreateListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			CreateScreen screen = new CreateScreen();
			screen.pack();
			screen.setVisible(true);
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
			JOptionPane.showMessageDialog(loginPanel, "Goodbye!");
			System.exit(0);
		}
	}
	public static void main(String[] args){
		GTPCP splash = new GTPCP();
		splash.pack();
		splash.setVisible(true);
	}
}
