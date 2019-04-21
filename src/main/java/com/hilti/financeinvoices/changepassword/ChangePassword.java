package com.hilti.financeinvoices.changepassword;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ChangePassword extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField txtEnterUserId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
					frame.setVisible(true);
					frame.setTitle("CHANGE PASSWORD");
					
					java.awt.Image icon=Toolkit.getDefaultToolkit().getImage("./resources/Hilti_opt.png");
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
	public ChangePassword() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./resources/newHilti.jpg"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 664, 421);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblE = new JLabel("Existing Password");
		lblE.setForeground(new Color(178, 34, 34));
		lblE.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblE.setBounds(143, 20, 168, 35);
		contentPane.add(lblE);
		
		txtEnterUserId = new JTextField();
		txtEnterUserId.setForeground(new Color(0, 0, 0));
		txtEnterUserId.setBounds(143, 71, 320, 43);
		contentPane.add(txtEnterUserId);
		txtEnterUserId.setColumns(10);
		txtEnterUserId.setBorder(new LineBorder(new Color(128, 128, 128)));

		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setForeground(new Color(178, 34, 34));
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewPassword.setBounds(143, 143, 141, 20);
		contentPane.add(lblNewPassword);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(0, 0, 0));
		textField_1.setBounds(143, 189, 320, 43);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(128, 128, 128)));
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setBounds(241, 271, 91, 29);
		contentPane.add(btnNewButton);
	}

}
