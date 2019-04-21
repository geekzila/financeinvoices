package com.hilti.financeinvoices.levels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class LevelThree extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	String[] option = new String[] { "10th", "20th", "30th" };
	String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December" };
	String[] year = { "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012",
			"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025",
			"2026", "2027", "2028", "2029", "2030" };
	JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelThree frame = new LevelThree();
					frame.setVisible(true);
					frame.setTitle("Level 1");
					java.awt.Image icon = Toolkit.getDefaultToolkit().getImage("./resources/Hilti_opt.png");
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
	public LevelThree() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(0, 0, 1883, 120);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel label = new JLabel("Payment Authorization");
		label.setForeground(new Color(178, 34, 34));
		label.setFont(new Font("Tahoma", Font.BOLD, 22));
		label.setBounds(15, 41, 273, 38);
		panel_2.add(label);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(324, 16, 1544, 84);
		panel_2.add(panel);
		panel.setLayout(null);

		JComboBox comboBox_2 = new JComboBox(year);
		comboBox_2.setBounds(588, 28, 100, 30);
		panel.add(comboBox_2);
		comboBox_2.setBackground(new Color(255, 255, 255));

		JComboBox comboBox_1 = new JComboBox(months);
		comboBox_1.setBounds(270, 28, 100, 30);
		panel.add(comboBox_1);
		comboBox_1.setBackground(new Color(255, 255, 255));

		JComboBox comboBox = new JComboBox(option);
		comboBox.setBounds(981, 28, 100, 30);
		panel.add(comboBox);
		comboBox.setBackground(new Color(255, 255, 255));

		JButton btnShow = new JButton("Display");
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnShow.setBounds(1234, 28, 115, 36);
		panel.add(btnShow);

		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSave.setBounds(1389, 29, 115, 36);
		panel.add(btnSave);

		JLabel lblSelectMonth = new JLabel("Select Month");
		lblSelectMonth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelectMonth.setBounds(109, 33, 179, 20);
		panel.add(lblSelectMonth);

		JLabel lblSelectYear = new JLabel("Select Year");
		lblSelectYear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelectYear.setBounds(423, 33, 131, 20);
		panel.add(lblSelectYear);

		JLabel lblSelectPaymentCycle = new JLabel("Select Payment Cycle");
		lblSelectPaymentCycle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelectPaymentCycle.setBounds(751, 33, 215, 20);
		panel.add(lblSelectPaymentCycle);
		// --------------------------------------------------------------------First
		// panel---------------------------------//

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 136, 1898, 888);
		contentPane.add(scrollPane);

		// table=new JTable(model);
		scrollPane.setViewportView(table);
		table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
		table.setRowHeight(30);

	}

}
