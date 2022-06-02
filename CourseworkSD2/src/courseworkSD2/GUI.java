package courseworkSD2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.JLabel;
import javax.swing.border.*;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

//this class represents the GUI, implements the main method and implements the Observer interface
public class GUI extends JFrame implements myObserver {

	private static final long serialVersionUID = 7013300195224733648L;
	
	OpeningWindow newOpening;
	private JPanel contentPane;
	private Game theGame;
	private ArrayList <GridPanel> theGridPanels;
	private int gridSize;
	private Border border2;
	private ImageIcon masterShipIcon;
	private ImageIcon battleCruiserIcon;
	private ImageIcon battleStarIcon;
	private ImageIcon battleShooterIcon;
	
	private JButton startBtn;
	private JButton moveBtn;
	private JButton saveBtn;
	private JButton loadBtn;
	private JButton modeBtn;	
	private JTextField txtSkywars;
	private JLabel modeLbl;
	private JLabel masterShipIconLbl;
	private JLabel battleShooterIconLbl;
	private JLabel battleStarIconLbl;
	private JLabel battleCruiserIconLbl;
	private JButton newGameBtn;
	private JTextField txtMasterShip;
	private JTextField txtBattlestar;
	private JTextField txtBattleshooter;
	private JTextField txtBattlecruiser;
	private JTextPane infoText;
	private JPanel gridLayoutPanel;
	private JTextField logTextBox;
	private JTextField captainsLog;
	private JTextField enemiesText;
	private JTextPane playAgainText;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//creates an opening window object
					OpeningWindow newOpening = new OpeningWindow();
					newOpening.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI(Game theGame) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		
		setTheGame(theGame);
		theGridPanels = new ArrayList <GridPanel>();
		gridSize = theGame.getTheGrid().getGridSize();
		border2 = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		//creates null image variables to be used for importing images
		BufferedImage newMasterShipImage = null;
		BufferedImage newBattleCruiserImage = null;
		BufferedImage newBattleShooterImage = null;
		BufferedImage newBattleStarImage = null;
		
		//imports images from the images folder
		try {
			newMasterShipImage = ImageIO.read(GUI.class.getResource("/images/MasterShip-resized.PNG"));
			newBattleCruiserImage = ImageIO.read(GUI.class.getResource("/images/BattleCruiser-resized.PNG"));
			newBattleShooterImage = ImageIO.read(GUI.class.getResource("/images/BattleShooter-resized.PNG"));
			newBattleStarImage = ImageIO.read(GUI.class.getResource("/images/BattleStar-resized.PNG"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//sets those images to be used to display in the GUI
		masterShipIcon = new ImageIcon(newMasterShipImage);
		battleCruiserIcon = new ImageIcon(newBattleCruiserImage);
		battleShooterIcon = new ImageIcon(newBattleShooterImage);
		battleStarIcon = new ImageIcon(newBattleStarImage);
		
		//creates the content pane and adds all the GUI elements to it
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getStartBtn());
		contentPane.add(getMoveBtn());
		contentPane.add(getSaveBtn());
		contentPane.add(getLoadBtn());
		contentPane.add(getModeBtn());
		contentPane.add(getTxtSkywars());
		contentPane.add(getModeLbl());
		contentPane.add(getMasterShipIconLbl());
		contentPane.add(getBattleShooterIconLbl());
		contentPane.add(getBattleStarIconLbl());
		contentPane.add(getBattleCruiserIconLbl());
		contentPane.add(getNewGameBtn());
		contentPane.add(getTxtMasterShip());
		contentPane.add(getTxtBattlestar());
		contentPane.add(getTxtBattleshooter());
		contentPane.add(getTxtBattlecruiser());
		contentPane.add(getInfoText());
		contentPane.add(getGridLayoutPanel());
		contentPane.add(getLogTextBox());
		contentPane.add(getCaptainsLog());
		contentPane.add(getEnemiesText());
		contentPane.add(getPlayAgainText());
	}
	private JButton getStartBtn() {
		if (startBtn == null) {
			startBtn = new JButton("Start");
			startBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//calls the start method from the 'Game' class and disables the start button
					theGame.Start();
					getStartBtn().setEnabled(false);
				}
			});
			startBtn.setFont(new Font("Silom", Font.BOLD, 13));
			startBtn.setBackground(Color.GRAY);
			startBtn.setForeground(Color.GRAY);
			startBtn.setBounds(6, 293, 103, 29);
		}
		return startBtn;
	}	
	private JButton getMoveBtn() {
		if (moveBtn == null) {
			moveBtn = new JButton("Move");
			moveBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//calls the move method from the 'Game' class
					theGame.Move();
				}
			});
			moveBtn.setFont(new Font("Silom", Font.BOLD, 13));
			moveBtn.setForeground(Color.GRAY);
			moveBtn.setBounds(105, 293, 103, 29);
		}
		return moveBtn;
	}
	private JButton getSaveBtn() {
		if (saveBtn == null) {
			saveBtn = new JButton("Save Game");
			saveBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int counter = 0;

					//checks that the game has at least been started before the game was saved
					for(Row tempRow : theGame.getTheGrid().getTheRows()) {
						for(Square tempSquare : tempRow.getTheSquares()) {
							counter = counter + tempSquare.getTheShips().size();
						}
					}
					//if there is at least one ship on the grid then the game is saved
					if(counter > 0) {
						try {
							FileOutputStream fileOut = new FileOutputStream("/tmp/game.ser");
							ObjectOutputStream gameOut = new ObjectOutputStream(fileOut);
							gameOut.writeObject(theGame);
							gameOut.close();
							fileOut.close();
						} catch (IOException exc) {
							exc.printStackTrace();
						}
					}
				}
			});
			saveBtn.setFont(new Font("Silom", Font.BOLD, 13));
			saveBtn.setBackground(Color.GRAY);
			saveBtn.setForeground(Color.GRAY);
			saveBtn.setBounds(395, 270, 103, 29);
		}
		return saveBtn;
	}
	private JButton getLoadBtn() {
		if (loadBtn == null) {
			loadBtn = new JButton("Load Game");
			loadBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						//removes window from previous game
						JComponent component = (JComponent) e.getSource();
						Window window = SwingUtilities.getWindowAncestor(component);
						window.dispose();
						//loads in the saved game and creates a new GUI to display it in
						FileInputStream fileIn = new FileInputStream("/tmp/game.ser");
						ObjectInputStream gameIn = new ObjectInputStream(fileIn);
						theGame = (Game) gameIn.readObject();
						gameIn.close();
						fileIn.close();
						GUI newGUI = new GUI(theGame);
						newGUI.setVisible(true);
						theGame.addObserver(newGUI);
						theGame.notifyObservers();
					} catch (IOException exc) {
						exc.printStackTrace();
					} catch (ClassNotFoundException exc) {
						exc.printStackTrace();
					}
				}
			});
			loadBtn.setFont(new Font("Silom", Font.BOLD, 13));
			loadBtn.setBackground(Color.GRAY);
			loadBtn.setForeground(Color.GRAY);
			loadBtn.setBounds(395, 293, 103, 29);
		}
		return loadBtn;
	}
	private JButton getNewGameBtn() {
		if (newGameBtn == null) {
			newGameBtn = new JButton("New Game");
			newGameBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//removes window from previous game
					JComponent component = (JComponent) e.getSource();
					Window window = SwingUtilities.getWindowAncestor(component);
					window.dispose();
					//creates new game and a new GUI to display it in
					theGame = new Game();
					GUI newGUI = new GUI(theGame);
					theGame.addObserver(newGUI);
					newGUI.setVisible(true);
				}
			});
			newGameBtn.setForeground(Color.GRAY);
			newGameBtn.setFont(new Font("Silom", Font.BOLD, 13));
			newGameBtn.setBackground(Color.GRAY);
			newGameBtn.setBounds(395, 247, 103, 29);
		}
		return newGameBtn;
	}
	private JButton getModeBtn() {
		if (modeBtn == null) {
			modeBtn = new JButton("Offensive");
			modeBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//calls the setMasterShipMode from the 'Game' class
					theGame.setMasterShipMode();
					//updates elements of the GUI based on what the current mode is
					//tried to put this in the 'updateGUI' method but it didn't work
					//quite as well
					if (modeBtn.getForeground() == Color.RED) {
						modeBtn.setText("Defensive");
						modeBtn.setForeground(Color.CYAN);
						modeLbl.setText("Mode: Offensive");
						modeLbl.setForeground(Color.RED);
						infoText.setText("You are the master ship. You can currently take on 2 enemy ships at a time.");
					} else {
						modeBtn.setText("Offensive");
						modeBtn.setForeground(Color.RED);
						modeLbl.setText("Mode: Defensive");
						modeLbl.setForeground(Color.CYAN);
						infoText.setText("You are the master ship. You can currently take on 1 enemy ship at a time.");
					}
				} 						
			});
			modeBtn.setFont(new Font("Silom", Font.BOLD, 13));
			modeBtn.setBackground(Color.RED);
			modeBtn.setForeground(Color.RED);
			modeBtn.setBounds(204, 293, 103, 29);
		}
		return modeBtn;
	}
	private JTextField getTxtSkywars() {
		if (txtSkywars == null) {
			txtSkywars = new JTextField();
			txtSkywars.setFont(new Font("Silom", Font.BOLD | Font.ITALIC, 18));
			txtSkywars.setForeground(new Color(255, 215, 0));
			txtSkywars.setBackground(Color.BLACK);
			txtSkywars.setHorizontalAlignment(SwingConstants.CENTER);
			txtSkywars.setText("SKYWARS");
			txtSkywars.setBounds(325, 6, 130, 26);
			txtSkywars.setColumns(10);
			txtSkywars.setBorder(border2);
		}
		return txtSkywars;
	}
	private JLabel getModeLbl() {
		if (modeLbl == null) {
			modeLbl = new JLabel("Mode: Defensive");
			modeLbl.setFont(new Font("Silom", Font.PLAIN, 13));
			modeLbl.setForeground(Color.CYAN);
			modeLbl.setBounds(91, 270, 144, 16);
		}
		return modeLbl;
	}
	private JLabel getMasterShipIconLbl() {
		if (masterShipIconLbl == null) {
			masterShipIconLbl = new JLabel("");
			masterShipIconLbl.setForeground(new Color(255, 255, 255));
			masterShipIconLbl.setBounds(298, 53, 65, 65);
			masterShipIconLbl.setIcon(masterShipIcon);
		}
		return masterShipIconLbl;
	}
	private JLabel getBattleShooterIconLbl() {
		if (battleShooterIconLbl == null) {
			battleShooterIconLbl = new JLabel("");
			battleShooterIconLbl.setForeground(Color.WHITE);
			battleShooterIconLbl.setBounds(360, 135, 65, 65);
			battleShooterIconLbl.setIcon(battleShooterIcon);
		}
		return battleShooterIconLbl;
	}
	private JLabel getBattleStarIconLbl() {
		if (battleStarIconLbl == null) {
			battleStarIconLbl = new JLabel("");
			battleStarIconLbl.setForeground(Color.WHITE);
			battleStarIconLbl.setBounds(300, 130, 65, 65);
			battleStarIconLbl.setIcon(battleStarIcon);
		}
		return battleStarIconLbl;
	}
	private JLabel getBattleCruiserIconLbl() {
		if (battleCruiserIconLbl == null) {
			battleCruiserIconLbl = new JLabel("");
			battleCruiserIconLbl.setForeground(Color.WHITE);
			battleCruiserIconLbl.setBounds(432, 135, 65, 65);
			battleCruiserIconLbl.setIcon(battleCruiserIcon);
		}
		return battleCruiserIconLbl;
	}	
	private JTextField getTxtMasterShip() {
		if (txtMasterShip == null) {
			txtMasterShip = new JTextField();
			txtMasterShip.setFont(new Font("Silom", Font.PLAIN, 8));
			txtMasterShip.setForeground(new Color(255, 255, 255));
			txtMasterShip.setBackground(new Color(0, 0, 0));
			txtMasterShip.setText("Master Ship");
			txtMasterShip.setBounds(284, 40, 70, 26);
			txtMasterShip.setColumns(10);
		}
		return txtMasterShip;
	}
	private JTextField getTxtBattlestar() {
		if (txtBattlestar == null) {
			txtBattlestar = new JTextField();
			txtBattlestar.setText("BattleStar");
			txtBattlestar.setForeground(Color.WHITE);
			txtBattlestar.setFont(new Font("Silom", Font.PLAIN, 8));
			txtBattlestar.setColumns(10);
			txtBattlestar.setBackground(Color.BLACK);
			txtBattlestar.setBounds(285, 115, 60, 26);
		}
		return txtBattlestar;
	}
	private JTextField getTxtBattleshooter() {
		if (txtBattleshooter == null) {
			txtBattleshooter = new JTextField();
			txtBattleshooter.setText("BattleShooter");
			txtBattleshooter.setForeground(Color.WHITE);
			txtBattleshooter.setFont(new Font("Silom", Font.PLAIN, 8));
			txtBattleshooter.setColumns(10);
			txtBattleshooter.setBackground(Color.BLACK);
			txtBattleshooter.setBounds(343, 115, 70, 26);
		}
		return txtBattleshooter;
	}
	private JTextField getTxtBattlecruiser() {
		if (txtBattlecruiser == null) {
			txtBattlecruiser = new JTextField();
			txtBattlecruiser.setText("BattleCruiser");
			txtBattlecruiser.setForeground(Color.WHITE);
			txtBattlecruiser.setFont(new Font("Silom", Font.PLAIN, 8));
			txtBattlecruiser.setColumns(10);
			txtBattlecruiser.setBackground(Color.BLACK);
			txtBattlecruiser.setBounds(413, 115, 70, 26);
		}
		return txtBattlecruiser;
	}
	private JTextPane getInfoText() {
		if (infoText == null) {
			infoText = new JTextPane();
			infoText.setBackground(new Color(0, 0, 0));
			infoText.setForeground(new Color(255, 255, 255));
			infoText.setFont(new Font("Silom", Font.PLAIN, 9));
			infoText.setText("You are the master ship. You can currently take on 1 enemy ship at a time.");
			infoText.setBounds(362, 44, 93, 59);
		}
		return infoText;
	}	
	private JPanel getGridLayoutPanel() {
		if (gridLayoutPanel == null) {
			gridLayoutPanel = new GridLayoutPanel();
			gridLayoutPanel.setLayout(new GridLayout(gridSize, gridSize));
			
			//gets the grid data model and creates new GridPanel objects to add to the
			//the GridLayoutPanel
			for(Row tempRow : theGame.getTheGrid().getTheRows()) {
				for(Square tempSquare : tempRow.getTheSquares()) {
					GridPanel newGridPanel = new GridPanel();
					newGridPanel.setSquare(tempSquare);
					theGridPanels.add(newGridPanel);
					gridLayoutPanel.add(newGridPanel);
				}
			}
		}
		return gridLayoutPanel;
	}	
	private JTextField getLogTextBox() {
		if (logTextBox == null) {
			logTextBox = new JTextField();
			logTextBox.setBackground(new Color(0, 0, 0));
			logTextBox.setForeground(new Color(255, 255, 255));
			logTextBox.setBounds(284, 198, 199, 29);
			logTextBox.setFont(new Font("Silom", Font.PLAIN, 9));
			logTextBox.setColumns(10);
			logTextBox.setText("Captain's Log:");
		}
		return logTextBox;
	}	
	private JTextField getCaptainsLog() {
		if (captainsLog == null) {
			captainsLog = new JTextField();
			captainsLog.setBackground(new Color(0, 0, 0));
			captainsLog.setForeground(new Color(255, 255, 255));
			captainsLog.setBounds(283, 217, 200, 26);
			captainsLog.setFont(new Font("Silom", Font.PLAIN, 9));
			captainsLog.setColumns(10);
		}
		return captainsLog;
	}
	private JTextField getEnemiesText() {
		if (enemiesText == null) {
			enemiesText = new JTextField();
			enemiesText.setBackground(new Color(0, 0, 0));
			enemiesText.setForeground(new Color(255, 255, 255));
			enemiesText.setBounds(283, 235, 200, 26);
			enemiesText.setFont(new Font("Silom", Font.PLAIN, 9));
			enemiesText.setColumns(10);
		}
		return enemiesText;
	}	
	private JTextPane getPlayAgainText() {
		if (playAgainText == null) {
			playAgainText = new JTextPane();
			playAgainText.setBackground(new Color(0, 0, 0));
			playAgainText.setForeground(new Color(255, 215, 0));
			playAgainText.setText("Play Again? Hit New Game");
			playAgainText.setBounds(322, 270, 65, 62);
			playAgainText.setFont(new Font("Silom", Font.PLAIN, 11));
			//makes sure text is set in centre
			StyledDocument document = playAgainText.getStyledDocument();
			SimpleAttributeSet centerAlign = new SimpleAttributeSet();
			StyleConstants.setAlignment(centerAlign, StyleConstants.ALIGN_CENTER);
			document.setParagraphAttributes(0, document.getLength(), centerAlign, false);
			playAgainText.setVisible(false);
		}
		return playAgainText;
	}
	
	public Game getTheGame() {
		return theGame;
	}

	public void setTheGame(Game theGame) {
		this.theGame = theGame;
	}

	public ArrayList<GridPanel> getTheGridPanels() {
		return theGridPanels;
	}

	public void setTheGridPanels(ArrayList<GridPanel> theGridPanels) {
		this.theGridPanels = theGridPanels;
	}

	public void setGridLayoutPanel(JPanel gridLayoutPanel) {
		this.gridLayoutPanel = gridLayoutPanel;
	}

	//method for updating the GUI
	public void updateGUI(Game theGame) {
		//makes sure start button is disabled if a game is loaded
		getStartBtn().setEnabled(false);
		
		//removes the GridPanels from the GridLayoutPanel and also removes from the
		//GridPanels array list
		getGridLayoutPanel().removeAll();
		theGridPanels.removeAll(theGridPanels);

		//creates a new set of GridPanels and adds them to the GridLayoutPanel
		for(Row tempRow : theGame.getTheGrid().getTheRows()) {
			for(Square tempSquare : tempRow.getTheSquares()) {
				GridPanel newGridPanel = new GridPanel();
				newGridPanel.setSquare(tempSquare);
				theGridPanels.add(newGridPanel);
				gridLayoutPanel.add(newGridPanel);
			}
		}

		//these update various text elements for displaying data on the screen
		logTextBox.setText("Captain's Log:");
		
		if(theGame.isEnemyDestroyedThisTurn()) {
			logTextBox.setText("Captain's Log: HIT!");
		}
		
		captainsLog.setText("" +theGame.getEnemiesDestroyed() +" enemies destroyed.");
		
		enemiesText.setText("" +theGame.getTheEnemyShips().size() +" enemies active");

		if(theGame.isEnemyCreated() == true) {
			captainsLog.setText("New enemy and " +theGame.getEnemiesDestroyed() +" enemies destroyed.");
		}

		if(theGame.isMasterShipDestroyed() == true) {
			captainsLog.setText("Master Ship destroyed!");
			enemiesText.setText("You destroyed " +theGame.getEnemiesDestroyed() +" ships.");
			getMoveBtn().setEnabled(false);
			playAgainText.setVisible(true);
		}
		
		//these loops determine which icons to show on which square of the grid representation
		for(Row tempRow : theGame.getTheGrid().getTheRows()) {
			for(Square tempSquare : tempRow.getTheSquares()) {
				for(GridPanel tempGridPanel : theGridPanels) {
					//checks to see if the square in the GridPanel matches the current Square
					//from the row's square array list
					if(tempGridPanel.getSquare() == tempSquare) {
						if(tempSquare.getTheShips().size() > 1) {
							//sets up a new grid layout manager when there is more than one ship
							//on a square
							tempGridPanel.setLayout(new GridLayout(2,2));
							for(Ship tempShip : tempSquare.getTheShips()) {
								GridLabel newLabel = new GridLabel();
								//uses each ships small icon for the GridLabel when there is more
								//than one ship
								newLabel.setIcon(tempShip.getSmallIcon());
								tempGridPanel.add(newLabel);
							}						
						} else {
							for(Ship tempShip : tempSquare.getTheShips()) {
								//uses the ships regular icon for the label
								tempGridPanel.getLabel().setIcon(tempShip.getIcon());
							}
						}
					}
				}
			}
		}
	//end of method	
	}
//end of class
}




