package Group4Package;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Container;
import java.awt.CardLayout;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Title: GameFrame
 *
 * @author Armaan Amazan
 *
 *         Description: Java Client for the game. Updates with information and
 *         serves as user interface.
 *
 */
public class ClientFrame extends JFrame {
	private JTextField textField;
	protected boolean playerSelected;
	protected String currentPlayerName;
	private fileIO mainFile;
	private LinkedList newList;

	protected JLabel lblNoPlayerSelected;

	/**
	 * Launches the application. TODO make I/O be the first thing that happens
	 * after client runs, then you can manipulate the player, dice and game
	 * objects as you like
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFrame frame = new ClientFrame();
					frame.setVisible(true);
					frame.setSize(500, 400);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// TODO Also incredibly redundant

	/**
	 * Client constructor.
	 */
	public ClientFrame() {
		setTitle("Liar's Dice -- Group 4, CSE360");
		getContentPane().setLayout(new CardLayout(0, 0));

		JPanel mainMenu = new JPanel(); // Main menu panel
		mainMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainMenu.setBackground(new Color(0, 128, 0));
		getContentPane().add(mainMenu, "mainMenu");
		GridBagLayout gbl_mainMenu = new GridBagLayout();
		gbl_mainMenu.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_mainMenu.rowHeights = new int[] { 40, 0, 40, 0, 35, 0, 23, 0 };
		gbl_mainMenu.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_mainMenu.rowWeights = new double[] { 1.0, 0.0, 0.0, 2.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		mainMenu.setLayout(gbl_mainMenu);

		JLabel label = new JLabel("Liar's Dice");
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		mainMenu.add(label, gbc_label);

		JLabel label_1 = new JLabel("CSE360 Group 4");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 1;
		mainMenu.add(label_1, gbc_label_1);

		JButton button = new JButton("New Game");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO move to playerSelect
				CardLayout cardLayoutTemp = (CardLayout) getContentPane().getLayout();
				cardLayoutTemp.show(getContentPane(), "playerSelect");
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 3;
		mainMenu.add(button, gbc_button);

		JButton button_1 = new JButton("Leaderboards");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO move to leaderboards panel
				CardLayout tempcl = (CardLayout) getContentPane().getLayout();
				tempcl.show(getContentPane(), "leaderboards");
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 1;
		gbc_button_1.gridy = 4;
		mainMenu.add(button_1, gbc_button_1);

		JButton btnCredits = new JButton("Credits");
		btnCredits.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO show credits panel
				CardLayout tempcl = (CardLayout) getContentPane().getLayout();
				tempcl.show(getContentPane(), "credits");
			}
		});
		GridBagConstraints gbc_btnCredits = new GridBagConstraints();
		gbc_btnCredits.insets = new Insets(0, 0, 5, 5);
		gbc_btnCredits.gridx = 1;
		gbc_btnCredits.gridy = 5;
		mainMenu.add(btnCredits, gbc_btnCredits);

		JButton button_3 = new JButton("Quit");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO save file before exit
				System.exit(0);
			}
		});
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 0, 5);
		gbc_button_3.gridx = 1;
		gbc_button_3.gridy = 6;
		mainMenu.add(button_3, gbc_button_3);

		JPanel playerSelect = new JPanel();
		playerSelect.setBorder(new EmptyBorder(5, 5, 5, 5));
		playerSelect.setBackground(new Color(0, 128, 0));
		getContentPane().add(playerSelect, "playerSelect");
		GridBagLayout gbl_playerSelect = new GridBagLayout();
		gbl_playerSelect.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_playerSelect.rowHeights = new int[] { 40, 0, 40, 0, 35, 0, 23, 0 };
		gbl_playerSelect.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_playerSelect.rowWeights = new double[] { 1.0, 0.0, 0.0, 2.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		playerSelect.setLayout(gbl_playerSelect);

		JLabel lblSelectYourProfile = new JLabel("Type Player Name:");
		GridBagConstraints gbc_lblSelectYourProfile = new GridBagConstraints();
		gbc_lblSelectYourProfile.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectYourProfile.gridx = 0;
		gbc_lblSelectYourProfile.gridy = 2;
		playerSelect.add(lblSelectYourProfile, gbc_lblSelectYourProfile);

		JButton btnStart = new JButton("Returning Player!");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					newList = new LinkedList();
					mainFile.fileIn(textField.getText(), true);
					newList = mainFile.LLStart();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO choose player object from linked list
				// TODO instantiate game after player object creation
				CardLayout tempcl = (CardLayout) getContentPane().getLayout();
				tempcl.show(getContentPane(), "gameInstance");
			}
		});
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.insets = new Insets(0, 0, 5, 0);
		gbc_btnStart.gridx = 0;
		gbc_btnStart.gridy = 3;
		playerSelect.add(btnStart, gbc_btnStart);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		playerSelect.add(textField, gbc_textField);
		textField.setColumns(10);

		JButton btnStart2 = new JButton("New Player!");
		btnStart2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					newList = new LinkedList();
					mainFile.fileIn(textField.getText(), false);
					newList = mainFile.LLStart();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				// TODO player needs to be freshly instantiated with their name
				// as their string,
				// but otherwise it's just to make sure that there's something
				// for the game to
				// update at the end of the game.
			}
		});
		GridBagConstraints gbc_btnStart2 = new GridBagConstraints();
		gbc_btnStart2.insets = new Insets(0, 0, 5, 0);
		gbc_btnStart2.gridx = 2;
		gbc_btnStart2.gridy = 4;
		playerSelect.add(btnStart2, gbc_btnStart2);

		JPanel gameInstance = new JPanel();
		gameInstance.setBorder(new EmptyBorder(5, 5, 5, 5));
		gameInstance.setBackground(new Color(0, 128, 0));
		getContentPane().add(gameInstance, "gameInstance");
		GridBagLayout gbl_gameInstance = new GridBagLayout();
		gbl_gameInstance.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_gameInstance.rowHeights = new int[] { 40, 0, 40, 0, 35, 0, 23, 0 };
		gbl_gameInstance.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_gameInstance.rowWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gameInstance.setLayout(gbl_gameInstance);

		JLabel lblComputer = new JLabel("Computer # of Dice:");
		GridBagConstraints gbc_lblComputer = new GridBagConstraints();
		gbc_lblComputer.anchor = GridBagConstraints.EAST;
		gbc_lblComputer.insets = new Insets(0, 0, 5, 5);
		gbc_lblComputer.gridx = 0;
		gbc_lblComputer.gridy = 0;
		gameInstance.add(lblComputer, gbc_lblComputer);

		JTextPane textPane = new JTextPane();
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.insets = new Insets(0, 0, 5, 5);
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 1;
		gbc_textPane.gridy = 0;
		gameInstance.add(textPane, gbc_textPane);

		JLabel lblCpuBid = new JLabel("CPU Bid:");
		GridBagConstraints gbc_lblCpuBid = new GridBagConstraints();
		gbc_lblCpuBid.anchor = GridBagConstraints.EAST;
		gbc_lblCpuBid.insets = new Insets(0, 0, 5, 5);
		gbc_lblCpuBid.gridx = 0;
		gbc_lblCpuBid.gridy = 1;
		gameInstance.add(lblCpuBid, gbc_lblCpuBid);

		JTextPane textPane_2 = new JTextPane();
		GridBagConstraints gbc_textPane_2 = new GridBagConstraints();
		gbc_textPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_textPane_2.fill = GridBagConstraints.BOTH;
		gbc_textPane_2.gridx = 1;
		gbc_textPane_2.gridy = 1;
		gameInstance.add(textPane_2, gbc_textPane_2);

		JLabel lblOutcome = new JLabel("Outcome:");
		GridBagConstraints gbc_lblOutcome = new GridBagConstraints();
		gbc_lblOutcome.anchor = GridBagConstraints.EAST;
		gbc_lblOutcome.insets = new Insets(0, 0, 5, 5);
		gbc_lblOutcome.gridx = 0;
		gbc_lblOutcome.gridy = 3;
		gameInstance.add(lblOutcome, gbc_lblOutcome);

		JTextPane textPane_3 = new JTextPane(); // blank until call, then it
												// shows outcome until another
												// "first" bid is made
		GridBagConstraints gbc_textPane_3 = new GridBagConstraints();
		gbc_textPane_3.insets = new Insets(0, 0, 5, 5);
		gbc_textPane_3.fill = GridBagConstraints.BOTH;
		gbc_textPane_3.gridx = 1;
		gbc_textPane_3.gridy = 3;
		gameInstance.add(textPane_3, gbc_textPane_3);

		JLabel lblYourDice = new JLabel("Your dice:");
		GridBagConstraints gbc_lblYourDice = new GridBagConstraints();
		gbc_lblYourDice.anchor = GridBagConstraints.EAST;
		gbc_lblYourDice.insets = new Insets(0, 0, 5, 5);
		gbc_lblYourDice.gridx = 0;
		gbc_lblYourDice.gridy = 5;
		gameInstance.add(lblYourDice, gbc_lblYourDice);

		JTextPane textPane_1 = new JTextPane();
		GridBagConstraints gbc_textPane_1 = new GridBagConstraints();
		gbc_textPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_textPane_1.fill = GridBagConstraints.BOTH;
		gbc_textPane_1.gridx = 1;
		gbc_textPane_1.gridy = 5;
		gameInstance.add(textPane_1, gbc_textPane_1);

		JLabel lblPlayer = new JLabel("Choose a Bid or Call");
		GridBagConstraints gbc_lblPlayer = new GridBagConstraints();
		gbc_lblPlayer.anchor = GridBagConstraints.EAST;
		gbc_lblPlayer.insets = new Insets(0, 0, 0, 5);
		gbc_lblPlayer.gridx = 0;
		gbc_lblPlayer.gridy = 6;
		gameInstance.add(lblPlayer, gbc_lblPlayer);

		JComboBox comboBox_1 = new JComboBox(); // TODO this needs to either
												// have less bids as bids get
												// higher or it needs to show an
												// error message if your bid is
												// too low.
												// We might have to create an
												// array with a bid hierarchy...
		comboBox_1.setToolTipText("Make a bid!");
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 6;
		gameInstance.add(comboBox_1, gbc_comboBox_1);

		JButton btnCall = new JButton("Make your choice!");
		btnCall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCall.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO throws special case in game that ends bidding loop and
				// judges the dice if call is selected in comboBox
				// TODO needs to start the bidding loop again from scratch if
				// player is called
			}
		});
		GridBagConstraints gbc_btnCall = new GridBagConstraints();
		gbc_btnCall.gridx = 2;
		gbc_btnCall.gridy = 6;
		gameInstance.add(btnCall, gbc_btnCall);

		JPanel leaderboards = new JPanel();
		leaderboards.setBackground(new Color(0, 128, 0));
		getContentPane().add(leaderboards, "leaderboards");
		GridBagLayout gbl_leaderboards = new GridBagLayout();
		gbl_leaderboards.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_leaderboards.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_leaderboards.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_leaderboards.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		leaderboards.setLayout(gbl_leaderboards);

		JList list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 6;
		gbc_list.gridy = 3;
		leaderboards.add(list, gbc_list);

		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO go back to main menu panel
				CardLayout tempcl = (CardLayout) getContentPane().getLayout();
				tempcl.show(getContentPane(), "mainMenu");
			}
		});
		GridBagConstraints gbc_btnBack_1 = new GridBagConstraints();
		gbc_btnBack_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack_1.anchor = GridBagConstraints.EAST;
		gbc_btnBack_1.gridx = 10;
		gbc_btnBack_1.gridy = 6;
		leaderboards.add(btnBack_1, gbc_btnBack_1);

		JPanel credits = new JPanel();
		credits.setBackground(new Color(0, 128, 0));
		getContentPane().add(credits, "credits");
		GridBagLayout gbl_credits = new GridBagLayout();
		gbl_credits.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_credits.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_credits.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_credits.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		credits.setLayout(gbl_credits);

		JLabel lblCredits = new JLabel("Credits:");
		GridBagConstraints gbc_lblCredits = new GridBagConstraints();
		gbc_lblCredits.insets = new Insets(0, 0, 5, 5);
		gbc_lblCredits.gridx = 2;
		gbc_lblCredits.gridy = 1;
		credits.add(lblCredits, gbc_lblCredits);

		JLabel lblArmaanAmazan = new JLabel("Armaan Amazan");
		GridBagConstraints gbc_lblArmaanAmazan = new GridBagConstraints();
		gbc_lblArmaanAmazan.insets = new Insets(0, 0, 5, 5);
		gbc_lblArmaanAmazan.gridx = 4;
		gbc_lblArmaanAmazan.gridy = 2;
		credits.add(lblArmaanAmazan, gbc_lblArmaanAmazan);

		JLabel lblBrettCaley = new JLabel("Brett Caley");
		GridBagConstraints gbc_lblBrettCaley = new GridBagConstraints();
		gbc_lblBrettCaley.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrettCaley.gridx = 6;
		gbc_lblBrettCaley.gridy = 3;
		credits.add(lblBrettCaley, gbc_lblBrettCaley);

		JLabel lblNathanielMartin = new JLabel("Nathaniel Martin");
		GridBagConstraints gbc_lblNathanielMartin = new GridBagConstraints();
		gbc_lblNathanielMartin.insets = new Insets(0, 0, 5, 5);
		gbc_lblNathanielMartin.gridx = 4;
		gbc_lblNathanielMartin.gridy = 4;
		credits.add(lblNathanielMartin, gbc_lblNathanielMartin);

		JLabel lblAaronPrieger = new JLabel("Aaron Prieger");
		GridBagConstraints gbc_lblAaronPrieger = new GridBagConstraints();
		gbc_lblAaronPrieger.insets = new Insets(0, 0, 5, 5);
		gbc_lblAaronPrieger.gridx = 6;
		gbc_lblAaronPrieger.gridy = 5;
		credits.add(lblAaronPrieger, gbc_lblAaronPrieger);

		JLabel lblAndrewPurificacion = new JLabel("Andrew Purificacion");
		GridBagConstraints gbc_lblAndrewPurificacion = new GridBagConstraints();
		gbc_lblAndrewPurificacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblAndrewPurificacion.gridx = 4;
		gbc_lblAndrewPurificacion.gridy = 6;
		credits.add(lblAndrewPurificacion, gbc_lblAndrewPurificacion);

		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout tempcl = (CardLayout) getContentPane().getLayout();
				tempcl.show(getContentPane(), "mainMenu");
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.anchor = GridBagConstraints.EAST;
		gbc_btnBack.gridx = 8;
		gbc_btnBack.gridy = 10;
		credits.add(btnBack, gbc_btnBack);
	}

}
