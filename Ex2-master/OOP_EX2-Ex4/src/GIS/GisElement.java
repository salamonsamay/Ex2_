package GIS;

import java.util.ArrayList;

import Coords.MyCoords;
import Geom.Geom_element;
import Geom.Point3D;

public class GisElement implements GIS_element{

	private Geom_element g;
	private Meta_data m;
	private Point3D point3d;
	
	public GisElement(Meta_data m ,Point3D point3d) {
		this.m = m;
		this.point3d = point3d;
	}
		
    public Geom_element getGeom() {	
    	return g;
	}
	public Meta_data getData() { 
		return m;
	}
	public Point3D getPoint3D() {
		return point3d;
	}
	public void translate(Point3D vec) {
		MyCoords coords = new MyCoords();
		point3d = coords.add(point3d,vec);
	}

}
