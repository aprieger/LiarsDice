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
import java.awt.CardLayout;
import javax.swing.JComboBox;

/**
 * Title: GameFrame 
 * Description: Java Client for the game. Updates with information
 * and serves as user interface.
 * @author Armaan Amazan
 *
 */
public class ClientFrame extends JFrame {
	private JTextField textField;

	public ClientFrame() {
		getContentPane().setLayout(new CardLayout(0, 0));

		JPanel mainMenu = new JPanel(); // Main menu panel
		mainMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainMenu.setBackground(new Color(0, 128, 0));
		getContentPane().add(mainMenu, "name_3925652528036");
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
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 3;
		mainMenu.add(button, gbc_button);

		JButton button_1 = new JButton("Leaderboards");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 1;
		gbc_button_1.gridy = 4;
		mainMenu.add(button_1, gbc_button_1);

		JButton button_2 = new JButton("Options");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 1;
		gbc_button_2.gridy = 5;
		mainMenu.add(button_2, gbc_button_2);

		JButton button_3 = new JButton("Quit");
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 0, 5);
		gbc_button_3.gridx = 1;
		gbc_button_3.gridy = 6;
		mainMenu.add(button_3, gbc_button_3);

		JPanel playerSelect = new JPanel();
		playerSelect.setBorder(new EmptyBorder(5, 5, 5, 5));
		playerSelect.setBackground(new Color(0, 128, 0));
		getContentPane().add(playerSelect, "name_3934677713321");
		GridBagLayout gbl_playerSelect = new GridBagLayout();
		gbl_playerSelect.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_playerSelect.rowHeights = new int[] { 40, 0, 40, 0, 35, 0, 23, 0 };
		gbl_playerSelect.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_playerSelect.rowWeights = new double[] { 1.0, 0.0, 0.0, 2.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		playerSelect.setLayout(gbl_playerSelect);

		JLabel lblSelectYourProfile = new JLabel("Select your profile:");
		GridBagConstraints gbc_lblSelectYourProfile = new GridBagConstraints();
		gbc_lblSelectYourProfile.anchor = GridBagConstraints.EAST;
		gbc_lblSelectYourProfile.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectYourProfile.gridx = 0;
		gbc_lblSelectYourProfile.gridy = 2;
		playerSelect.add(lblSelectYourProfile, gbc_lblSelectYourProfile);

		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 2;
		playerSelect.add(comboBox, gbc_comboBox);

		JLabel lblCreateNewProfile = new JLabel("Create new profile:");
		GridBagConstraints gbc_lblCreateNewProfile = new GridBagConstraints();
		gbc_lblCreateNewProfile.anchor = GridBagConstraints.EAST;
		gbc_lblCreateNewProfile.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreateNewProfile.gridx = 0;
		gbc_lblCreateNewProfile.gridy = 3;
		playerSelect.add(lblCreateNewProfile, gbc_lblCreateNewProfile);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		playerSelect.add(textField, gbc_textField);
		textField.setColumns(10);

		JButton btnStart = new JButton("Start!");
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.anchor = GridBagConstraints.WEST;
		gbc_btnStart.insets = new Insets(0, 0, 5, 5);
		gbc_btnStart.gridx = 1;
		gbc_btnStart.gridy = 4;
		playerSelect.add(btnStart, gbc_btnStart);

		JPanel gameInstance = new JPanel();
		gameInstance.setBorder(new EmptyBorder(5, 5, 5, 5));
		gameInstance.setBackground(new Color(0, 128, 0));
		getContentPane().add(gameInstance, "name_4209398013977");
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

		JTextPane textPane_3 = new JTextPane();
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

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("Make a bid!");
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 6;
		gameInstance.add(comboBox_1, gbc_comboBox_1);

		JButton btnCall = new JButton("Call!");
		GridBagConstraints gbc_btnCall = new GridBagConstraints();
		gbc_btnCall.gridx = 2;
		gbc_btnCall.gridy = 6;
		gameInstance.add(btnCall, gbc_btnCall);
	}

}
