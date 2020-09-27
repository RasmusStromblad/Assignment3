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
				chooseFile();
			}
		});
	}

	public void chooseFile() {
		// Open the GUI to choose a file from the system
		int returnValue = frame.getFileChooser().showOpenDialog(null);
		// If the user presses the 'Okey' button
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			// Set the selected file to the file selected from the window
			File selectedFile = frame.getFileChooser().getSelectedFile();
			// Call setFile with the selected file as parameter
			setFile(selectedFile);
		}
	}

	public void setFile(File selectedFile) {
		// Get the file path of the selected file
		File file = new File(selectedFile.getAbsolutePath());

		try {
			// Get the workbook of the file
			Workbook workbook = Workbook.getWorkbook(file);
			// Get the sheet in the workbook, on position 0
			Sheet sheet = workbook.getSheet(0);

			// Clear header in table in frame
			frame.getHeaders().clear();

			// Add a cell value as header for every column in the sheet
			for (int i = 0; i < sheet.getColumns(); i++) {
				Cell cell1 = sheet.getCell(i, 0);
				frame.getHeaders().add(cell1.getContents());
			}

			// Clear the data in table
			frame.getData().clear();

			// Get all data from one column, then go on to get all the data from the next
			// column. Keep going until all column data have been gathered.
			for (int j = 1; j < sheet.getRows(); j++) {
				Vector data = new Vector();
				for (int i = 0; i < sheet.getColumns(); i++) {
					Cell cell = sheet.getCell(i, j);
					// Store the column data in variable data
					data.add(cell.getContents());
				}
				// Add line space and then add the data to the data later to be displayed in
				// frame
				data.add("\n");
				frame.getData().add(data);
			}

			// Call the setData in frame to display all the data
			frame.setTable();
		} catch (Exception e) {
			frame.getLbl_response().setText("Wrong format of imported file. Legal file format: .xls");
		}
	}

}
