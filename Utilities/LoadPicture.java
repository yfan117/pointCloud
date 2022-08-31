package Utilities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import Beans.Point;

public class LoadPicture{
	
	public static void getPointCloud(String pictureURL) throws IOException
	{
		BufferedImage image = ImageIO.read(new File(pictureURL));
		int halfW = image.getWidth(null)/2;
		int halfY = image.getHeight(null)/2;
		
		for(int z = -25; z < 25; z+=5)
		{
			for(int y = -halfY; y < halfY; y+=5) {
				for( int x = -halfW; x < halfW; x+=5) {
					
					if(image.getRGB(x + halfW, y + halfY) != 0)
					{
						MidService.pointCloud.add(new Point(x, y, z));
					}
				}
			}
		}
		
	}

}
