package com.hilti.financeinvoices.levels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.hilti.financeinvoices.db.ConnectionUtil;

public class LevelOne extends JFrame {

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

	private static final int BOOLEAN_COLUMN = 9;

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	DefaultTableModel model;
	
	public class CheckBoxModelListener implements TableModelListener {

		public void tableChanged(TableModelEvent e) {
			int row = e.getFirstRow();

			int column = e.getColumn();
			int idFromClient = 0;
			Boolean checked = false;
			TableModel model = (TableModel) e.getSource();
			idFromClient = (Integer) model.getValueAt(row, 0);
			if (column == BOOLEAN_COLUMN) {
				model = (TableModel) e.getSource();
				checked = (Boolean) model.getValueAt(row, column);
			}
			updateStatus(checked, idFromClient);
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelOne frame = new LevelOne();
					frame.setVisible(true);
					frame.setTitle("Level 1");
					java.awt.Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("Hilti_opt.png"));
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
	public LevelOne() {
		connection = ConnectionUtil.connectdb();
		JTable table = createTable();
		
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

		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBox_2 = new JComboBox(year);
		comboBox_2.setBounds(588, 28, 100, 30);
		panel.add(comboBox_2);
		comboBox_2.setBackground(new Color(255, 255, 255));
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBox_1 = new JComboBox(months);
		comboBox_1.setBounds(270, 28, 100, 30);
		panel.add(comboBox_1);
		comboBox_1.setBackground(new Color(255, 255, 255));

		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBox = new JComboBox(option);
		comboBox.setBounds(981, 28, 100, 30);
		panel.add(comboBox);
		comboBox.setBackground(new Color(255, 255, 255));

		JButton btnShow = new JButton("Display");
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnShow.setBounds(1234, 28, 115, 36);
		panel.add(btnShow);
		//	String vipvalue1=comboBox_VIP_1.getSelectedItem().toString();

		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					System.out.println("Display Clicked");
					String month = comboBox_1.getSelectedItem().toString();
					String year = comboBox_2.getSelectedItem().toString();
					String cycle = comboBox.getSelectedItem().toString();
					System.out.println(month + year + cycle);
					// Start Date
					// End Date
					// Month - January
					// Year - 2019
					// 01-Jan-2019
					String startDate = "";
					String endDate = "";
					switch (month) {
					case "January":
						startDate = "01/" + 01 + "/" + year;
						endDate = "31/" + 01 + "/" + year;
						break;
						
					case "February":
						startDate = "01/" + 02 + "/" + year;
						endDate = "29/" + 02 + "/" + year;
						break;

					default:
						break;
					}
					// Between Query
					// Select * from P_Payment where PaymentDate Between startDate And endDate And PaymentCycle = cycle;
					addRowToJTable(table, startDate, endDate, cycle);
					table.getModel().addTableModelListener(new CheckBoxModelListener());
			}
		});

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

	public void addRowToJTable(JTable jTable, String startDate, String endDate, String cycle) {
//		String[] cols = { "SNo", "Invoice Name", "Vendor Code", "Vendor Name", "Invoice Date", "Invoice Amount", "Amount Payable", "Payment Date", "Payment Cycle", "UserFlag" };

		model = (DefaultTableModel) jTable.getModel();
		List<Invoice> list = getInvoice(startDate, endDate, cycle);
		Object rowData[] = new Object[4];
		for (int i = 0; i < list.size(); i++) {
			rowData[0] = list.get(i).getSno();
			rowData[1] = list.get(i).getInvoiceName();
			rowData[2] = list.get(i).getVendorCode();
			rowData[3] = list.get(i).getVendorName();
			rowData[4] = list.get(i).getInvoiceDate();
			rowData[5] = list.get(i).getInvoiceAmount();
			rowData[6] = list.get(i).getAmountPayable();
			rowData[7] = list.get(i).getPaymentDate();
			rowData[8] = list.get(i).getPaymentCycle();
			rowData[9] = list.get(i).getLevel1Flag();
			
			model.addRow(rowData);
		}

	}

	public List<Invoice> getInvoice(String startDate, String endDate, String cycle) {

		List<Invoice> invoice = new ArrayList<Invoice>();
//Select * from P_Payment where PaymentDate Between startDate And endDate And PaymentCycle = cycle
		String sql = "SELECT * FROM P_Payment_approval_tracking where paymentCycle = " + cycle + " AND paymentDate BETWEEN " + startDate + " AND " + endDate;

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer sno = resultSet.getInt("sno");
				String invoiceName = resultSet.getString("invoiceName");
				String vendorCode = resultSet.getString("vendorCode");
				String vendorName = resultSet.getString("vendorName");
				String invoiceDate = resultSet.getString("invoiceDate");
				String invoiceAmount = resultSet.getString("invoiceAmount");
				String amountPayable = resultSet.getString("amountPayable");
				String paymentDate = resultSet.getString("paymentDate");
				String paymentCycle = resultSet.getString("paymentCycle");
				String userFlag = resultSet.getString("level1Flag");
				Invoice invoiceFromDb = new Invoice();
				invoiceFromDb.setSno(sno);
				invoiceFromDb.setVendorCode(vendorCode);
				invoiceFromDb.setVendorName(vendorName);
				invoiceFromDb.setInvoiceName(invoiceName);
				invoiceFromDb.setInvoiceDate(invoiceDate);
				invoiceFromDb.setInvoiceAmount(invoiceAmount);
				invoiceFromDb.setAmountPayable(amountPayable);
				invoiceFromDb.setPaymentCycle(paymentCycle);
				invoiceFromDb.setPaymentDate(paymentDate);
				invoiceFromDb.setLevel1Flag(userFlag);
				invoice.add(invoiceFromDb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return invoice;
	}

	public void updateStatus(Boolean status, Integer id) {

		String sql = "UPDATE P_Payment_approval_tracking SET status = ? WHERE id = ?";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setBoolean(1, status);
			preparedStatement.setInt(2, id);
			int updated = preparedStatement.executeUpdate();
			if (updated != 0) {
				System.out.println("Updated Successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JTable createTable() {

		String[] cols = { "SNo", "Invoice Name", "Vendor Code", "Vendor Name", "Invoice Date", "Invoice Amount", "Amount Payable", "Payment Date", "Payment Cycle", "UserFlag" };

		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, cols) {
			@Override
			public Class getColumnClass(int column) {
				return column == BOOLEAN_COLUMN ? Boolean.class : String.class;
			}
		};

		table = new JTable(model);
		return table;
	}
}
