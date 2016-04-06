import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class JoinImage 
{
	/*public static void main(String[] args)throws Exception
	{
		BufferedImage result = new BufferedImage(600, 720,BufferedImage.TYPE_INT_RGB);
		Graphics g = result.getGraphics();
		String image[]= {"Call Number 26.png","Call Number 27.png","Call Number 28.png","Call Number 29.png","Call Number 30.png","Call Number 75.png","Call Number 76.png"};
		int x=0;
		int y=0;
		for(int i=0;i<image.length;i++)
		{
			BufferedImage bi = ImageIO.read(new File(image[i]));
			
			g.drawImage(bi, x, y, null);
			x += 150;
			if(x >= result.getWidth())
			{
				x = 0;
				y += bi.getHeight();
			}
		}
		ImageIO.write(result,"png",new File("result.png"));
	}*/
	public void joinImage(ArrayList<String>a) throws IOException
	{
		BufferedImage result = new BufferedImage(600, 720,BufferedImage.TYPE_INT_RGB);
		Graphics g = result.getGraphics();
		int x=0;
		int y=0;
		int fileNameIncrementer=1;
		String fileName="result"+fileNameIncrementer+".png";
		for(int i=0;i<a.size();i++)
		{
			BufferedImage bi = ImageIO.read(new File(a.get(i)));
			
			g.drawImage(bi, x, y, null);
			x += 150;
			if(x >= result.getWidth())
			{
				x = 0;
				y += bi.getHeight();
			}
			if(y>=result.getHeight())
			{
				ImageIO.write(result,"png",new File(fileName));
				fileNameIncrementer++;
				result = new BufferedImage(600, 720,BufferedImage.TYPE_INT_RGB);
				g = result.getGraphics();
				x=0;
				y=0;
			}
		}
//		ImageIO.write(result,"png",new File("result.png"));
	}
}
