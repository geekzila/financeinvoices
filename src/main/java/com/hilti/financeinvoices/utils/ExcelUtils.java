/**
 * 
 */
package com.hilti.financeinvoices.utils;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.hilti.financeinvoices.db.ConnectionUtil;

/**
 * @author kloudone
 *
 */
public class ExcelUtils {
	static DataFormatter dataFormatter = new DataFormatter();
	static Date date = new Date();
	static SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
	static String strDate = formatter.format(date);
	PreparedStatement pstm;
	Connection conn;

	public ExcelUtils() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated constructor stub
		//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//conn = DriverManager
			//	.getConnection("jdbc:sqlserver://10.62.1.11:1433;databasename=HDBIN;integratedSecurity=true;");
		conn = ConnectionUtil.connectdb();
	}

	public void parseExcelFile(File selectedFile) throws InvalidFormatException, IOException, SQLException {
		Workbook workbook = WorkbookFactory.create(new File(selectedFile.getAbsolutePath()));

		Sheet sheet = workbook.getSheetAt(0);
		Row row;
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			row = sheet.getRow(i);
			int sno = (int) row.getCell(0).getNumericCellValue();

			String invoiceName = row.getCell(1).getStringCellValue();

			String vendorCode = row.getCell(2).getStringCellValue();

			String vendorName = row.getCell(3).getStringCellValue();

			String invoiceDate = dataFormatter.formatCellValue(row.getCell(4));

			int invoiceAmount = (int) row.getCell(5).getNumericCellValue();

			int amountPayable = (int) row.getCell(6).getNumericCellValue();

			String paymentDate = dataFormatter.formatCellValue(row.getCell(7));

			String sql = "INSERT INTO P_Payment_approval_tracking(SN,InvoiceName,VendorCode,VendorName,InvoiceDate,InvoiceAmount,AmountPayable,PaymentDate,Level1Flag,LevelFlagDate) VALUES('"
					+ sno + "','" + invoiceName + "','" + vendorCode + "','" + vendorName + "','" + invoiceDate + "','"
					+ invoiceAmount + "','" + amountPayable + "','" + paymentDate + "',0,'" + strDate + "')";
			conn.prepareStatement(sql);
			pstm.execute();
		}
	}
}
