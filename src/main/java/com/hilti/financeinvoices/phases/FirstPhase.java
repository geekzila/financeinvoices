/**
 * 
 */
package com.hilti.financeinvoices.phases;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.hilti.financeinvoices.changepassword.ChangePassword;
import com.hilti.financeinvoices.levels.LevelOne;
import com.hilti.financeinvoices.levels.LevelThree;
import com.hilti.financeinvoices.levels.LevelTwo;
import com.hilti.financeinvoices.levels.LevelZero;

/**
 * @author kloudone
 *
 */
public class FirstPhase extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String[] option = new String[] { "Select Your Check Point", "Check_Point_0", "Check_Point_1", "Check_Point_2",
			"Check_Point_3" };

	private JPanel contentPane;
	private JTextField txtEnterYourUser;
	private JTextField txtEnterYourSecure;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstPhase frame = new FirstPhase();
					frame.setVisible(true);
					frame.setTitle("USER LOGIN");
					// getClass().getClassLoader().getResource("resources/images/logo.png")))
					// "./resources/Hilti_opt.png"
					java.awt.Image icon = Toolkit.getDefaultToolkit()
							.getImage(getClass().getClassLoader().getResource("Hilti_opt.png"));
					frame.setIconImage(icon);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FirstPhase() {
		// TODO Auto-generated constructor stub

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 450, 300);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);
		contentPane = new JPanel();
		// contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		// getClass().getClassLoader().getResource("Hilti_opt.png")
		lblNewLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("company.jpg")));
		lblNewLabel.setBounds(398, 28, 628, 915);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(944, 83, 497, 802);
		contentPane.add(panel);
		panel.setLayout(null);

		txtEnterYourUser = new JTextField();
		txtEnterYourUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEnterYourUser.setText("Enter Your User ID");

		txtEnterYourUser.setBounds(116, 199, 329, 50);
		panel.add(txtEnterYourUser);
		txtEnterYourUser.setColumns(10);

		txtEnterYourSecure = new JTextField();
		txtEnterYourSecure.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEnterYourSecure.setText("Enter Your Secure Password");
		txtEnterYourSecure.setColumns(10);
		txtEnterYourSecure.setBounds(116, 278, 329, 50);
		panel.add(txtEnterYourSecure);

		comboBox_1 = new JComboBox(option);

		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setBounds(116, 347, 329, 50);
		panel.add(comboBox_1);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(new Color(105, 105, 105));
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblLogin.setBounds(214, 88, 220, 57);
		panel.add(lblLogin);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_1.getSelectedIndex() == 1) {
					LevelZero levelZero = new LevelZero();
					levelZero.setVisible(true);
				} else if (comboBox_1.getSelectedIndex() == 2) {
					LevelOne levelOne = new LevelOne();
					levelOne.setVisible(true);
				} else if (comboBox_1.getSelectedIndex() == 3) {
					LevelTwo levelTwo = new LevelTwo();
					levelTwo.setVisible(true);
				} else if (comboBox_1.getSelectedIndex() == 4) {
					LevelThree levelThree = new LevelThree();
					levelThree.setVisible(true);
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(116, 453, 329, 40);
		panel.add(btnNewButton);

		JLabel lblChangePassword = new JLabel("<HTML><U>Change Password</U></HTML>");
		lblChangePassword.setBounds(217, 533, 187, 31);
		panel.add(lblChangePassword);
		lblChangePassword.setForeground(new Color(178, 34, 34));
		lblChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChangePassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Yay you clicked me");
				ChangePassword changePassword = new ChangePassword();
				changePassword.setVisible(true);
			}

		});

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("change_password-512.png")));
		;
		lblNewLabel_2.setBounds(176, 538, 36, 24);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Hilti_opt.png")));
		lblNewLabel_1.setBounds(375, 16, 107, 20);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("man.png")));
		lblNewLabel_3.setBounds(55, 204, 49, 40);
		panel.add(lblNewLabel_3);

		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(getClass().getClassLoader().getResource("lock_secure_security_password-512.png")));
		label.setBounds(52, 274, 49, 58);
		panel.add(label);

		JLabel label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icon-people.png")));
		label_1.setBounds(52, 352, 49, 40);
		panel.add(label_1);

		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

}
