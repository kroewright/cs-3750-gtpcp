import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class GTPCP extends JFrame {
	private ImageIcon header, footer;
	private JButton login, createUser;
	private JLabel headerLabel, footerLabel, welcomeLabel, 
					unPrompt, passPrompt;
	private JTextField username, password;
	private JPanel buttonPanel, loginPanel;
	
	public GTPCP(){
		super("GTPCP");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,1));
		
		header = new ImageIcon("about.jpg");
		headerLabel = new JLabel(header);
		
		add(headerLabel);
		
		welcomeLabel = new JLabel("<html>Welcome to the Georgia Tech Police Communication Portal<br><br>"
				+ "Please log in with your username and password or create a new account below</html>");
		
		unPrompt = new JLabel("Username: ");
		username = new JTextField(10);
		
		passPrompt = new JLabel("Password: ");
		password = new JTextField(10);
		
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
	}
	
	private class LoginListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//JOptionPane woo = new JOptionPane();
			JOptionPane.showMessageDialog(loginPanel, "You're Logged In, woo!");
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
	
	public static void main(String[] args){
		GTPCP splash = new GTPCP();
		splash.pack();
		splash.setVisible(true);
	}
}
