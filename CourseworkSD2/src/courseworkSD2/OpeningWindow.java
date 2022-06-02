package courseworkSD2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class OpeningWindow extends JFrame {

	private static final long serialVersionUID = 3032014610605958301L;

	private JPanel openingPane;
	
	private JTextPane message;
	private JButton enterBtn;


	public OpeningWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		
		//adds elements and values to the opening window
		openingPane = new JPanel();
    	openingPane.setBackground(Color.BLACK);	
    	openingPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    	setContentPane(openingPane);
    	openingPane.setLayout(null);
    	openingPane.add(getMessage());
    	openingPane.add(getEnterBtn());
    	enterBtn.setBounds(190, 273, 117, 29);
	}
	
	//creates a message to be displayed to the user
	private JTextPane getMessage() {
		if (message == null) {
			message = new JTextPane();
			message.setBackground(Color.BLACK);
			StyledDocument document = message.getStyledDocument();
			SimpleAttributeSet centerAlign = new SimpleAttributeSet();
			StyleConstants.setAlignment(centerAlign, StyleConstants.ALIGN_CENTER);
			document.setParagraphAttributes(0, document.getLength(), centerAlign, false);
			message.setText("Welcome to SkyWars! Your mission is to destroy as many enemy ships as possible. Press the Start button on the next window to begin, then press the Move button to fly and engage enemies. Switch to Offensive mode to take on more enemies at once. Press the button below to begin...");
			message.setForeground(new Color(255, 215, 0));
			message.setFont(new Font("Silom", Font.PLAIN, 16));
			message.setBounds(81, 38, 338, 187);
		}
		return message;
	}
	
	private JButton getEnterBtn() {
		if (enterBtn == null) {
			enterBtn = new JButton("Enter");
			enterBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Game theGame = new Game();
					GUI gui = new GUI(theGame);
					theGame.addObserver(gui);
					gui.setVisible(true);
					JComponent component = (JComponent) e.getSource();
					Window window = SwingUtilities.getWindowAncestor(component);
					window.dispose();
				}
			});
			enterBtn.setForeground(Color.GRAY);
			enterBtn.setFont(new Font("Silom", Font.BOLD, 13));
			enterBtn.setBackground(Color.GRAY);
		}
		return enterBtn;
	}
}
