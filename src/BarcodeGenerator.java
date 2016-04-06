import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

public class BarcodeGenerator 
{
	static ArrayList<String>a=new ArrayList<String>();
	
	//Constructor
	public BarcodeGenerator()
	{}
	
	//===================================================================
	/*
	 * This method joins individual barcode pictures to a single A4 page calculatin the dimenssions 
	 * So that there is no need to print the barcodes seperately
	 */
	public void joinImage() throws IOException
	{
		BufferedImage result = new BufferedImage(620, 720,BufferedImage.TYPE_INT_BGR);
		Graphics2D drawer = result.createGraphics() ;
		drawer.setBackground(Color.RED);
		drawer.clearRect(0,0,(int)620,(int)720);
		
		Graphics g = result.getGraphics();
		int x=0;
		int y=0;
		int fileNameIncrementer=1;
		String fileName="result"+fileNameIncrementer+".png";
		for(int i=0;i<a.size();i++)
		{
			BufferedImage bi = ImageIO.read(new File(a.get(i)));
			
			g.drawImage(bi, x, y, null);
			x += 155;
			if(x >= result.getWidth())
			{
				x = 0;
				y += bi.getHeight();
			}
			if(y>=result.getHeight())
			{
				ImageIO.write(result,"png",new File(fileName));
				fileNameIncrementer++;
				fileName="result"+fileNameIncrementer+".png";
				result = new BufferedImage(600, 720,BufferedImage.TYPE_INT_RGB);
				drawer = result.createGraphics() ;
				drawer.setBackground(Color.RED);
				drawer.clearRect(0,0,(int)620,(int)720);
				g = result.getGraphics();
				x=0;
				y=0;
			}
		}
//		ImageIO.write(result,"png",new File("result.png"));
	}
	//===================================================================
	/*
	 * This method prints the summary of the dvd database 
	 * It prints out the call number, title ,author and whether its a duplicate or not 
	 */
	public void printSummary(int id,String s1,String s2,String s3,String s4,String s5,String c1,String c2,String c3) throws Exception
	{
		if(id==2)
		{
			System.out.println(s1+"\n"+s2+"\n"+s3+"\n");
//			drawBarCode("Call Number "+c1,c1);
		}
		else if(id==3)
		{
			System.out.println(s1+"\n"+s2+"\n"+s3+"\nCopy 1 of 2"+"\n");
//			drawBarCode("Call Number "+c1,c1);
			System.out.println(s4+"\n"+"Copy 2 of 2\n");
//			drawBarCode("Call Number "+c2,c2);
		}
		else if(id==4)
		{
			System.out.println(s1+"\n"+s2+"\n"+s3+"\nCopy 1 of 3"+"\n");
//			drawBarCode("Call Number "+c1,c1);
			System.out.println(s4+"\n"+"Copy 2 of 3\n");
			drawBarCode("Call Number "+c2,c2);
			System.out.println(s5+"\n"+"Copy 3 of 3\n");
//			drawBarCode("Call Number "+c3,c3);
		}
	}
	
	//===================================================================
	/*
	 * This method draws barcode depending on the call number given as a string
	 * And then saves them in each sepeate png file
	 */
	public static void drawBarCode(String fileName,String data) throws Exception
	{
		Barcode barcode = BarcodeFactory.createCode39(data,false);
		barcode.setBarHeight(60);
		barcode.setBarWidth(2);
		String s=fileName+".png";
		a.add(s);
		System.out.println("Data To Encode: "+data);
		File imgFile = new File(s);
		//Write the bar code to PNG file
		BarcodeImageHandler.savePNG(barcode, imgFile);
		System.out.println("BareCode Created Successfully");
	}
}
