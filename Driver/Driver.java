package Driver;

import java.io.IOException;

import Beans.Point;
import Beans.Triangle;
import Beans.Vertex;
import Render.Display;
import Utilities.LoadPicture;
import Utilities.MidService;

public class Driver {

	public static void main(String[] args) throws IOException {
		
		Display display = new Display();
		
		LoadPicture.getPointCloud("D:\\resource\\images\\logo4.png");

		while(true)
		{
			display.update();
			
			try {
				Thread.sleep(1000/30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
