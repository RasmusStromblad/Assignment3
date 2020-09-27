import java.io.*;
import java.util.*;
import javax.swing.*;

import javax.swing.table.*;

public class Frame extends JFrame {

	static String keep = "";
	static File file;

	private Frame frame;
	private Vector headers;
	private Vector data;
	private JButton btn_import;
	private JFileChooser fileChooser;
	private JTable table_content;
	private JScrollPane scrollPane_content;
	private DefaultTableModel tableModel_tableContent;

	public Frame() {
		getContentPane().setLayout(null);

		btn_import = new JButton("Import file");
		btn_import.setBounds(10, 550, 118, 23);
		getContentPane().add(btn_import);

		scrollPane_content = new JScrollPane();
		scrollPane_content.setBounds(10, 20, 1000, 500);
		getContentPane().add(scrollPane_content);

		table_content = new JTable();
		scrollPane_content.setViewportView(table_content);

		headers = new Vector();
		data = new Vector();
		fileChooser = new JFileChooser();

	}

	public void setTable() {

		tableModel_tableContent = new DefaultTableModel(data, headers);

		table_content.setModel(tableModel_tableContent);
		table_content.setAutoCreateRowSorter(true);
		getContentPane().add(scrollPane_content);

	}

	public Frame getFrame() {
		return frame;
	}

	public void setFrame(Frame frame) {
		this.frame = frame;
	}

	public JTable getTable_content() {
		return table_content;
	}

	public void setTable_content(JTable table_content) {
		this.table_content = table_content;
	}

	public JScrollPane getScrollPane_content() {
		return scrollPane_content;
	}

	public void setScrollPane_content(JScrollPane scrollPane_content) {
		this.scrollPane_content = scrollPane_content;
	}

	public DefaultTableModel getTableModel_tableContent() {
		return tableModel_tableContent;
	}

	public void setTableModel_tableContent(DefaultTableModel tableModel_tableContent) {
		this.tableModel_tableContent = tableModel_tableContent;
	}

	public static String getKeep() {
		return keep;
	}

	public static void setKeep(String keep) {
		Frame.keep = keep;
	}

	public static void setFile(File file) {
		Frame.file = file;
	}

	public static File getFile() {
		return file;
	}

	public Vector getHeaders() {
		return headers;
	}

	public void setHeaders(Vector headers) {
		this.headers = headers;
	}

	public Vector getData() {
		return data;
	}

	public void setData(Vector data) {
		this.data = data;
	}

	public JButton getBtn_import() {
		return btn_import;
	}

	public void setBtn_import(JButton btn_import) {
		this.btn_import = btn_import;
	}

	public JFileChooser getFileChooser() {
		return fileChooser;
	}

	public void setFileChooser(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}

}