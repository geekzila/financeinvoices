package com.hilti.financeinvoices.db;

import java.sql.*;
import javax.swing.*;

/**
 * 
 * @author Bhawana
 *
 */
public class ConnectionUtil {
	Connection conn = null;

	public static Connection connectdb() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:FTR2.db");
			return conn;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}