import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabelImageText extends JPanel
{
    public LabelImageText()
    {
        JLabel label1 = new JLabel( new ColorIcon(Color.WHITE, 100, 100) );
        label1.setText( "Call: 234\nTitle: Friday Night\nAuthor: JOhn Ford\n" );
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.CENTER);
        add( label1 );

    }


    public static class ColorIcon implements Icon
    {
        private Color color;
        private int width;
        private int height;

        public ColorIcon(Color color, int width, int height)
        {
            this.color = color;
            this.width = width;
            this.height = height;
        }

        public int getIconWidth()
        {
            return width;
        }

        public int getIconHeight()
        {
            return height;
        }

        public void paintIcon(Component c, Graphics g, int x, int y)
        {
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }
    }

    private static void createAndShowUI()throws Exception
    {
        JFrame frame = new JFrame("LabelImageText");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new LabelImageText() );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );

        Container content = frame.getContentPane();
        BufferedImage img = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        content.printAll(g2d);

        g2d.dispose();
        ImageIO.write(img, "png", new File("test.png"));
    }

    public static void main(String[] args)throws Exception
    {
    	createAndShowUI();
    }
}