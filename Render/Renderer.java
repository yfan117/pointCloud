package Render;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.sound.midi.MidiDevice;
import javax.swing.JPanel;

import Beans.Point;
import Beans.Triangle;
import Beans.Vertex;
import Utilities.MidService;

public class Renderer extends JPanel{
    
    public Renderer() {
        
    }
    
//    double a = MidService.displayY / MidService.displayX;
    double a = 1;
    double f = 1 / (Math.tan(MidService.fieldOfView/2));
    double l = MidService.Zfar / (MidService.Zfar - MidService.Znear);
    double offSet = MidService.Zfar / (MidService.Zfar - MidService.Znear) * MidService.Znear;
    double angle = 0;

    
    public void update() {
        
        angle -= 0.025;
        this.setBackground(Color.DARK_GRAY);
        
        repaint();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        super.paintComponent(g2d);
        g2d.setColor(Color.WHITE);
//        for(Point element: MidService.pointCloud) 
        for(int i = 0; i < MidService.pointCloud.size(); i++) 
        {
        	Point p = rotateY(MidService.pointCloud.get(i));
//        	Point p = rotateX(element);
        	p = projection(p);
//        	Point p = projection(MidService.pointCloud.get(i));
        	
        	int offSetX = (int) (MidService.displayX/2);
        	int offSetY = (int) (MidService.displayY/2);

        	
        	g2d.drawRect((int)p.x + offSetX, (int)p.y+offSetY, 1, 1);
        }
    }
    
    
    public Point projection(Point v)
    {
        
        double x = (v.x * a * f);
        double y = (v.y * f);
        double z = (v.z * l - offSet);
        double w = v.z;
        
//        if((500 - v.z)!= 0)
        {
            double temp = 100/(500 - v.z);
            if(temp != 0.0) {
                x *= temp;
                y *= temp;
                z *= temp;
            }
        }

        return new Point((int)x, (int)y, (int)z);
    }
    
	public Point rotateX(Point v)
	{
		double x = v.x;
		double y = v.y * Math.cos(angle) + v.z * (-Math.sin(angle));
		double z = v.y * Math.sin(angle) + v.z * Math.cos(angle);
		
		return new Point((int)x, (int)y, (int)z);
	}
	
    public Point rotateY(Point v)
    {
        double x = v.x * Math.cos(angle) + v.z * Math.sin(angle);
        double y = v.y;
        double z = v.x * (-Math.sin(angle)) + v.z * Math.cos(angle);
        
        return new Point((int)x, (int)y, (int)z);
    }
    
    public Point rotateZ(Point v)
    {
        double x = v.x * Math.cos(angle) + v.y * (-Math.sin(angle));
        double y = v.x * Math.sin(angle) + v.y * Math.cos(angle);
        double z = v.z;
        
        return new Point((int)x, (int)y, (int)z);
    }

}