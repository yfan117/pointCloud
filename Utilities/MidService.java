package Utilities;

import java.util.ArrayList;

import Beans.Point;
import Beans.Triangle;

public class MidService {

public static int displayX = 1920;
public static int displayY = 1080;
//public static float fieldOfView = 3.14f/2f;
public static float fieldOfView = (float) Math.toRadians(30);
public static float Zfar = 100f;
public static float Znear = 0.1f;

public static ArrayList<Triangle> mesh = new ArrayList<>();

public static ArrayList<Point> pointCloud = new ArrayList<>();

}
