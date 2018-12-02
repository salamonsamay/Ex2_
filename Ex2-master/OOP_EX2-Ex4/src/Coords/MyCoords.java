package Coords;

import Geom.Point3D;

public class MyCoords implements coords_converter {
	/**
	 * This interface represents a basic coordinate system converter, including:
	 * 1. The 3D vector between two lat,lon, alt points 
	 * 2. Adding a 3D vector in meters to a global point.
	 * 3. convert a 3D vector from meters to polar coordinates
	 * @author Boaz Ben-Moshe
	 *
	 */
	/** computes a new point which is the gps point transformed by a 3D vector (in meters)*/
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
		double x,y,z;
		x = Math.sqrt(Math.pow(local_vector_in_meter.x(),2)+Math.pow(local_vector_in_meter.y(),2)+Math.pow(local_vector_in_meter.z(),2));
		y = Math.tan(local_vector_in_meter.y()/local_vector_in_meter.x());
		z = Math.tan(Math.sqrt(Math.pow(local_vector_in_meter.x(),2)+Math.pow(local_vector_in_meter.y(),2))/local_vector_in_meter.z());	
		return new Point3D(x+gps.x(),y+gps.y(),z+gps.z());
	}
	/** computes the 3D distance (in meters) between the two gps like points */
	public double distance3d(Point3D gps0, Point3D gps1) {
		Point3D gps = new Point3D(vector3D(gps0 , gps1));
		return Math.sqrt(Math.pow(gps.x() , 2) + Math.pow(gps.y(), 2));
	}
	/** computes the 3D vector (in meters) between two gps like points */
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		double LonNorm = Math.cos(gps0.x()*Math.PI/180),EarthR = 6371000;
		double Radianlat,Radianlon;
		Radianlat = (gps1.x() - gps0.x())*(Math.PI/180);
		Radianlon = (gps1.y() - gps0.y())*(Math.PI/180);
		return new Point3D(Math.sin(Radianlat)*EarthR , Math.sin(Radianlon)*EarthR*LonNorm , gps1.z() - gps0.z());
	}
	/** computes the polar representation of the 3D vector be gps0-->gps1 
	 * Note: this method should return an azimuth (aka yaw), elevation (pitch), and distance*/
	//זווית גובה ודיסטנס
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		double[]a = new double[3];
		Point3D v = new Point3D(vector3D(gps0 , gps1));
		a[0] = Math.toDegrees((Math.atan2(v.z() , v.x())));                    //yaw
		a[1] = Math.toDegrees(Math.atan2(Math.sqrt(v.x()*v.x() + v.z()*v.z()) , v.y()));    //pitch
		a[2] = Math.toDegrees(distance3d(gps0 , gps1));
		return a;
	}
	/**
	 * return true iff this point is a valid lat, lon , lat coordinate: [-180,+180],[-90,+90],[-450, +inf]
	 * @param p
	 * @return
	 */
	public boolean isValid_GPS_Point(Point3D p) {
		if(p.x() > 180 || p.x() < (-180)|| p.y() > 90 || p.y() < (-90) || p.z() < (-450))return false;
		return true;
	}
}
