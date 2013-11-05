import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CreateScreen extends JFrame {
	private ImageIcon header;
	private JLabel firstName, lastName, userName, password, passReenter, email, phone, prompt, promptspace, headerLabel;
	private JTextField first, last, user, pass, pass2, emailAddy, phoneNum;
	private JButton continueButton;
	private JPanel userPanel, buttons;

	public CreateScreen(){
		super("Create New User Account");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,1));
		
		header = new ImageIcon("about.jpg");
		headerLabel = new JLabel(header);
		add(headerLabel);
		
		userPanel = new JPanel(new GridLayout(8,2));
		prompt = new JLabel("Please enter the following information to create your account: ");
		promptspace = new JLabel(" ");
		userPanel.add(prompt);
		userPanel.add(promptspace);
		
		firstName = new JLabel("First Name: ");
		first = new JTextField(10);
		userPanel.add(firstName);
		userPanel.add(first);
		
		lastName = new JLabel("Last Name: ");
		last = new JTextField(10);
		userPanel.add(lastName);
		userPanel.add(last);
		
		userName = new JLabel("Enter a Username: ");
		user = new JTextField(10);
		userPanel.add(userName);
		userPanel.add(user);
		
		password = new JLabel("Enter a password: ");
		pass = new JTextField(10);
		userPanel.add(password);
		userPanel.add(pass);
		
		passReenter = new JLabel("Re-Enter your password: ");
		pass2 = new JTextField(10);
		userPanel.add(passReenter);
		userPanel.add(pass2);
		
		email = new JLabel("Email: ");
		emailAddy = new JTextField(10);
		userPanel.add(email);
		userPanel.add(emailAddy);
		
		phone = new JLabel("Phone Number: ");
		phoneNum = new JTextField(10);
		userPanel.add(phone);
		userPanel.add(phoneNum);

		add(userPanel);
		
		buttons = new JPanel();
		continueButton = new JButton("Continue");
		continueButton.addActionListener(new ContinueListener());
		buttons.add(continueButton);
		add(buttons);
	}
	
	private class ContinueListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			SessionScreen sesh = new SessionScreen();
			sesh.pack();
			sesh.setVisible(true);
			setVisible(false);
			
		}
		
	}
}
