import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class HelpScreen extends JFrame {
	private JLabel helpPrompt, headerLabel;
	private JPanel helpPanel;
	private JButton returnToPrev;
	private ImageIcon header, footer;
	
	
	public HelpScreen(){
		super("GTPCP Help");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(2,1));
		helpPanel = new JPanel();
		
		header = new ImageIcon("about.jpg");
		headerLabel = new JLabel(header);
		
		add(headerLabel);
		
		helpPrompt = new JLabel("<html>This is where your questions about the GTPCP <br>will be answered in time<br><br><br></html>");
		
		returnToPrev = new JButton("Return to Previous Screen");
		returnToPrev.addActionListener(new ReturnListener());
		
		helpPanel.add(helpPrompt);
		helpPanel.add(returnToPrev);
		
		add(helpPanel);
	}
	
	private class ReturnListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			setVisible(false);
		}
		
	}
}
