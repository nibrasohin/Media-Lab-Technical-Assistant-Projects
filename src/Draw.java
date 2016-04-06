import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Draw {
	public Draw()
	{
		
	}
	/*public static void main(String[] args) throws Exception 
	{
	    
	}*/
	
	public void write(File f)throws Exception
	{

		final BufferedImage image = ImageIO.read(new File("Barcode.png"));

		Graphics g = image.getGraphics();
		g.setFont(g.getFont().deriveFont(30f));
		g.drawString("Hello World!", 5, 5);
		g.dispose();
		ImageIO.write(image, "png", new File("test.png"));
	}
}
