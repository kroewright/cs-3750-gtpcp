import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Archive class that handles the archive function of the GTPCP
 * application. Allows users to go back and review previous sessions and
 * add any new notes to previous cases.
 * 
 * @author The Feds
 * @version 1.0 11/12/13 
 *
 */
public class ArchiveClass extends JFrame {
		public static final int WIDTH = 700;
		public static final int HEIGHT = 400;
		private JPanel newPanel;
		private JLabel newLabelID;
		private JLabel newLabelDate;
		private JLabel newPrompt;
		private JTextField sessionID;
		private JTextField sessionDate;
		private JButton search;
		private JButton cancel;
			

		public ArchiveClass() {
			setSize(WIDTH, HEIGHT);
			
			newPanel = new JPanel();
			
			setTitle("Archive");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

			newLabelID = new JLabel("Please enter the ID number of the session you would like to find:");
			sessionID = new JTextField(20);

			newLabelDate = new JLabel("OR enter the date of the session you would like to find:");
			sessionDate = new JTextField(20);
			
			newPrompt = new JLabel("Press ENTER or click Search below");
			search = new JButton("Search");
			search.addActionListener(new SearchListener());

			cancel = new JButton("Cancel");
			cancel.addActionListener(new CancelListener());


			newPanel.add(newLabelID);
			newPanel.add(sessionID);
			newPanel.add(newLabelDate);
			newPanel.add(sessionDate);
			newPanel.add(newPrompt);

			newPanel.add(search);
			newPanel.add(cancel);

			add(newPanel);
			setVisible(true);
		}
		
		private class SearchListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				//stuff
			}
		}
		
		private class CancelListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				sessionID.setText("");
				sessionDate.setText("");
				setVisible(false);
			}
		}
	
//	public static void main(String[] args) {
//		ArchiveClass a = new ArchiveClass();	
//	}	
}
