

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadExcel 
{
	static FileWriter writer;
	static BufferedWriter out;// = new BufferedWriter(new FileWriter("file.txt"));
	
	//The main method reads in the dvd database from the excel file and does various operations depending
	//on its requirements by calling different methods;
	public static void main(String[] args) 
		{
			try
			{
				out = new BufferedWriter(new FileWriter("Present Included.txt"));
				writer=new FileWriter("test.csv");
				FileInputStream file = new FileInputStream(new File("With Present.xlsx"));

				//Create Workbook instance holding reference to .xlsx file
				XSSFWorkbook workbook = new XSSFWorkbook(file);

				//Get first/desired sheet from the workbook
				XSSFSheet sheet = workbook.getSheetAt(0);

				//Iterate through each rows one by one
				Iterator<Row> rowIterator = sheet.iterator();
				
				BarcodeGenerator object=new BarcodeGenerator();
				CSV_VER2 token=new CSV_VER2();
				String title=null;
				String author=null;
				String call="";
//				String callNum1="";
				String callNum2="";
				String callNum3="";
				String result1="";
				String result2="";
				String result3="";
				String result4="";
				String result5="";
				String present="";
				String presentResult="";
				
				while (rowIterator.hasNext()) 
				{
					Row row = rowIterator.next();
					//For each row, iterate through all the columns
					Iterator<Cell> cellIterator = row.cellIterator();
					int i=0;
					while (cellIterator.hasNext()) 
					{
						Cell cell = cellIterator.next();
						if(i==0)
						{
							cell.setCellType(Cell.CELL_TYPE_STRING);
							present=cell.getStringCellValue();
							if(present.equals("0"))
							{
								presentResult="lst";
							}
							else
							{
								presentResult="in";
							}
						}
						if(i==1)
						{
							cell.setCellType(Cell.CELL_TYPE_STRING);
							call=cell.getStringCellValue();
							result1="Call Number: "+call;
						}
						else if(i==2)
						{
							cell.setCellType(Cell.CELL_TYPE_STRING);
							title=cell.getStringCellValue();
							result2="Title: "+title;
						}
						else if(i==3)
						{
							cell.setCellType(Cell.CELL_TYPE_STRING);
							author=cell.getStringCellValue();
							result3="Author: "+author;
						}
						else if(i==4)
						{
							cell.setCellType(Cell.CELL_TYPE_STRING);
							callNum2=cell.getStringCellValue();
							result4="Call : "+callNum2+"\n"+"Title :"+title+"\nAuthor: "+author;
						}
						else if(i==5)
						{
							cell.setCellType(Cell.CELL_TYPE_STRING);
							callNum3=cell.getStringCellValue();
							result5="Call : "+callNum3+"\n"+"Title :"+title+"\nAuthor: "+author;
						}
						
						i++;
					}
					object.printSummary(i-1, result1, result2, result3, result4, result5,call,callNum2,callNum3);

//					exportToCsv(i-1, result1, result2, result3, result4, result5,call,callNum2,callNum3);
					writeToFile(i-1, result1, result2, result3, result4, result5,call,callNum2,callNum3,presentResult);
				}
				out.close();
				writer.flush();
				writer.close();
				
//				object.joinImage();//calls join image to join the bar codes together
				file.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	public static void writeToFile(int id,String s1,String s2,String s3,String s4,String s5,String c1,String c2,String c3,String preResult)throws Exception
	{
		if(id==3)
		{
			out.write(s1);
			out.write("\t");
			out.write(s2);
			out.write("\t");
			out.write(s3);
			out.write("\t");
			out.write("Copy 1 of 1");
			out.write("\t");
			out.write(preResult);
//			out.write('\n');
			out.newLine();
		}
		else if(id==4)
		{
			out.write(s1);
			out.write("\t");
			out.write(s2);
			out.write("\t");
			out.write(s3);
			out.write("\t");
			out.write("Copy 1 of 2");
			out.write("\t");
			out.write(preResult);
//			out.write('\n');
			out.newLine();

			out.write("Call Number: "+c2);
			out.write("\t");
			out.write(s2);
			out.write("\t");
			out.write(s3);
			out.write("\t");
			out.write("Copy 2 of 2");
			out.write("\t");
			out.write(preResult);
//			out.write('\n');
			out.newLine();
		}
		else if(id==5)
		{
			out.write(s1);
			out.write("\t");
			out.write(s2);
			out.write("\t");
			out.write(s3);
			out.write("\t");
			out.write("Copy 1 of 3");
			out.write("\t");
			out.write(preResult);
//			out.write('\n');
			out.newLine();
			
			out.write("Call Number: "+c2);
			out.write("\t");
			out.write(s2);
			out.write("\t");
			out.write(s3);
			out.write("\t");
			out.write("Copy 2 of 3");
			out.write("\t");
			out.write(preResult);
//			out.write('\n');
			out.newLine();
			
			out.write("Call Number: "+c3);
			out.write("\t");
			out.write(s2);
			out.write("\t");
			out.write(s3);
			out.write("\t");
			out.write("Copy 3 of 3");
			out.write("\t");
			out.write(preResult);
//			out.write('\n');
			out.newLine();
		}
	}
	/*
	 * This method exports all the data in the dvd database  to a csv file separating them with commas.
	 */
	public static void exportToCsv(int id,String s1,String s2,String s3,String s4,String s5,String c1,String c2,String c3)throws Exception
	{
		if(id==2)
		{
			writer.append(s1);
			writer.append(',');
			writer.append(s2);
			writer.append(',');
			writer.append(s3);
			writer.append(',');
			writer.append("");
			writer.append('\n');
		}
		else if(id==3)
		{
			writer.append(s1);
			writer.append(',');
			writer.append(s2);
			writer.append(',');
			writer.append(s3);
			writer.append(',');
			writer.append("Copy 1 of 2");
			writer.append('\n');

			writer.append("Call Number: "+c2);
			writer.append(',');
			writer.append(s2);
			writer.append(',');
			writer.append(s3);
			writer.append(',');
			writer.append("Copy 2 of 2");
			writer.append('\n');
		}
		else if(id==4)
		{
			writer.append(s1);
			writer.append(',');
			writer.append(s2);
			writer.append(',');
			writer.append(s3);
			writer.append(',');
			writer.append("Copy 1 of 3");
			writer.append('\n');
			
			writer.append("Call Number: "+c2);
			writer.append(',');
			writer.append(s2);
			writer.append(',');
			writer.append(s3);
			writer.append(',');
			writer.append("Copy 2 of 3");
			writer.append('\n');
			
			writer.append("Call Number: "+c3);
			writer.append(',');
			writer.append(s2);
			writer.append(',');
			writer.append(s3);
			writer.append(',');
			writer.append("Copy 3 of 3");
			writer.append('\n');
		}

	}
}
