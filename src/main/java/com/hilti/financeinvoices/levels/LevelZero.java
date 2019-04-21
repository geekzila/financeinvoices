package com.hilti.financeinvoices.levels;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.hilti.financeinvoices.utils.ExcelUtils;

public class LevelZero extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	File selectedFile;
	JLabel lblNewLabel;
	final String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	final String jdbcURL = "jdbc:sqlserver://10.62.1.11:1433;databasename=HDBIN;integratedSecurity=true;";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelZero frame = new LevelZero();
					frame.setVisible(true);
					frame.setTitle("Level Zero");

					java.awt.Image icon = Toolkit.getDefaultToolkit()
							.getImage(getClass().getClassLoader().getResource("Hilti_opt.png"));
					frame.setIconImage(icon);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LevelZero() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 664, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(46, 69, 541, 215);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("UPLOAD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					System.out.println(selectedFile.getAbsolutePath());
					try {
						ExcelUtils excelUtils = new ExcelUtils();
						excelUtils.parseExcelFile(selectedFile);
					} catch (ClassNotFoundException | InvalidFormatException | SQLException | IOException e1) {
						e1.printStackTrace();
					}
			}
		});
		btnNewButton.setBounds(336, 66, 115, 37);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Select File");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					selectedFile = fileChooser.getSelectedFile();
					// System.out.println(selectedFile);
					System.out.println(selectedFile.getName());
					// Need to check the extensions
					String fileName = selectedFile.getName();
					String[] fileExtenstion = fileName.split("[\\s@&.?$+-]+");
					String extenstion = fileExtenstion[1];
					if (!extenstion.equals("xlsx")) {
						System.out.println("Please upload xlsx file");
						JOptionPane.showOptionDialog(null, "Please upload xlsx file.", null, JOptionPane.CLOSED_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, null, null);
					}
				}
				lblNewLabel.setText(selectedFile.getName());

			}
		});
		btnNewButton_1.setBounds(107, 66, 115, 37);
		panel.add(btnNewButton_1);

		lblNewLabel = new JLabel();

		lblNewLabel.setBounds(260, 129, 281, 20);
		panel.add(lblNewLabel);

		JLabel lblYourSelectedFile = new JLabel("Your Selected File is:");
		lblYourSelectedFile.setBounds(105, 129, 162, 20);
		panel.add(lblYourSelectedFile);
	}

}
