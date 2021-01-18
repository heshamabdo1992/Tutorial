package A83_Excel_ReadAndWrote;

// This method read from excelfile.xlsx only
public class TestEngMahmoudUtils {

	
	public static void main(String[] args) {

	utils.ReadExcel_CellData test = new utils.ReadExcel_CellData("./ReadFrom/", "CalcInput.xls");

	
	// test.getColCount(sheetindex, rownum)
	int ColumnCount = test.getColCount(0, 0);

	System.out.println("the column count is: " + ColumnCount);

	// test.getRowCount(sheetindex)
	int RowCount = test.getRowCount(0)+1;

	System.out.println("the row count is: " + RowCount);

	// test.getCellData(sheetindex, rownum, colnum)
	int x = test.getCellNumericData(0, 2, 0);

	System.out.println("the cell value is: " + x);

	for (int i = 0; i <= ColumnCount; i++) {

		String LastLine = test.getCellStringData(0, 3, i);
		System.out.print(LastLine+ " ");
	}
	System.out.println();
}
}
