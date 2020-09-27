import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Controller {

	private Frame frame;
	private String fileName = "";

	public Frame getFrame() {
		return frame;
	}

	public void setFrame(Frame frame) {
		this.frame = frame;
	}

	public Controller(Frame frame) {
		this.frame = frame;

		declareEvents();

	}

	public void declareEvents() {

		frame.getBtn_import().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hej");
				chooseFile();
				
			}
		});
	}

	public void setFile(File selectedFile) {

		File file = new File(selectedFile.getAbsolutePath());
		
		
		try {
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);
			frame.getHeaders().clear();
			for (int i = 0; i < sheet.getColumns(); i++) {
				Cell cell1 = sheet.getCell(i, 0);
				frame.getHeaders().add(cell1.getContents());
			}
			frame.getData().clear();
			for (int j = 1; j < sheet.getRows(); j++) {
				Vector d = new Vector();
				for (int i = 0; i < sheet.getColumns(); i++) {
					Cell cell = sheet.getCell(i, j);
					d.add(cell.getContents());
				}
				d.add("\n");
				frame.getData().add(d);
			}
			frame.setTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public File chooseFile() {
		JFileChooser fileChooser = new JFileChooser();
		int returnValue = frame.getFileChooser().showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = frame.getFileChooser().getSelectedFile();
			setFile(selectedFile);
			return selectedFile;
		}
		return null;
	}
	
	

}
