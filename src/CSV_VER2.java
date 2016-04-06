

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author samy
 */
public class CSV_VER2 {

	
/*	public static void run() {

		String csvFile = "Results3.csv";
		String[][] arrayStrings=new String[4][6];

		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";


		try {



			br = new BufferedReader(new FileReader(csvFile));


			boolean firstTime=false;
			int i=0;
			while ((line = br.readLine()) != null) {
				firstTime=false;

				arrayStrings[i] = line.split(cvsSplitBy);

				i++;
				if(i==4)
				{
					i=0;
					generateCsvFile(arrayStrings);
				}

			}



		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}


	}
*/

public  void generateCsvFile(String call,String author,String title,String copyNum)
	{
		try
		{
			FileWriter writer = new FileWriter("xyu.csv",false);

			//            writer.append(" ");
			//        writer.append(',');

			writer.append(call);
			writer.append(',');
			writer.append(author);
			writer.append(',');
			writer.append(title);
			writer.append(',');
			writer.append(copyNum);
			writer.append('\n');

			//generate whatever data you want

			writer.flush();
			writer.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		} 
	}


	/*private static void generateCsvFile(String[][] values)
	{
		try
		{
			FileWriter writer = new FileWriter("xyu.csv",true);


			writer.append("Intersect");
			writer.append(',');

			writer.append(values[0][1]);
			writer.append(',');
			writer.append(values[1][1]);
			writer.append(',');
			writer.append(values[2][1]);
			writer.append(',');
			writer.append(values[3][1]);
			writer.append(','); 
			writer.append(values[1][5]);


			writer.append('\n');

			writer.append("NewFeatures");
			writer.append(',');

			writer.append(values[0][2]);
			writer.append(',');
			writer.append(values[1][2]);
			writer.append(',');
			writer.append(values[2][2]);
			writer.append(',');
			writer.append(values[3][2]);
			writer.append(','); 
			writer.append(values[1][5]);




			writer.append('\n');        

			writer.append("Improvements");
			writer.append(',');
			writer.append(values[0][3]);
			writer.append(',');
			writer.append(values[1][3]);
			writer.append(',');
			writer.append(values[2][3]);
			writer.append(',');
			writer.append(values[3][3]);
			writer.append(','); 
			writer.append(values[1][5]);


			writer.append('\n');

			writer.append("SqrCommits");
			writer.append(',');
			writer.append(values[0][4]);
			writer.append(',');
			writer.append(values[1][4]);
			writer.append(',');
			writer.append(values[2][4]);
			writer.append(',');
			writer.append(values[3][4]);
			writer.append(','); 
			writer.append(values[1][5]);

			writer.append('\n');

			//generate whatever data you want

			writer.flush();
			writer.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		} 

	}*/
}