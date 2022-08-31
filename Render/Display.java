package Render;

import javax.swing.JFrame;

//import Controller.KeyboardController;
//import Controller.MouseController;
import Utilities.MidService;

public class Display {
	
	Renderer render;
	
	public Display() {
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(MidService.displayX, MidService.displayY);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		render = new Renderer();
		frame.add(render);
		
//		MouseController mouseController = new MouseController();
//		render.addMouseListener(mouseController);
//		render.addMouseMotionListener(mouseController);
//		
//		KeyboardController keyboardController = new KeyboardController();
//		frame.addKeyListener(keyboardController);
		
		
		
		
		frame.setVisible(true);
		frame.invalidate();
	}

	public void update() {
		render.update();
	}
}
