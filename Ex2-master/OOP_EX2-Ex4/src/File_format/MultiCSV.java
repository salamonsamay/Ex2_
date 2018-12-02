package File_format;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.Scanner;

import GIS.GIS_element;
import GIS.GisElement;
import GIS.GisLayer;
import GIS.GisProject;
import GIS.MetaData;
import Geom.Point3D;

public class MultiCSV {
	
	public static void main(String[]args) throws IOException {
		File f = new File("C:\\Users\\user\\Desktop\\‏‏תיקיה חדשה");
		search(f);
	}
	
	
	public static GisProject search(File directory) throws IOException{
	   GisProject project = new GisProject();
	   serach(directory,project);
       return project;
       
    }
	
    private static void serach(File directory, GisProject project) throws IOException{
  	    Formatter Kml = new Formatter("C:\\Users\\user\\Desktop\\x3.kml");
  	  String[][] t;
        String a="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\n";
        String b="<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>"+"\n";
        Kml.format("%s",a);
        Kml.format("%s",b);
        
        if(directory.listFiles()==null  ){
            return;
        }
        if(directory.listFiles().length==0){
            return;
        }
        for(int i=0;i<directory.listFiles().length;i++){
            if(directory.listFiles()[i].isDirectory()){
                 serach(directory.listFiles()[i],project);
            }
            else if(directory.listFiles()[i].getName().contains(".csv")){   //get in to the directory
            	t = read(directory.listFiles()[i]);    //return string matrix of the gislayer
            	project.add(inlaize(t));    //add the gislayer to gisproject
                for(int j = 2 ; j < t.length ; j++) {
                    String st=  "<Placemark>"+"\n"+
                            "<name><![CDATA["+t[j][1]+"]]></name>"+"\n"+
                            "<description>"+
                            "<![CDATA[BMAC: <b>"+t[j][0]+"</b><br/>"+
                            "Capabilities: <b>"+t[j][2]+"</b><br/>"+
                            "Channel: <b>"+t[j][4]+"</b><br/>"+
                            "RSSI: <b>"+t[j][5]+"</b><br/>"+
                            "AltitudeMeters: <b>"+t[j][8]+"</b><br/>"+
                            "AccuracyMeters: <b>"+t[j][9]+"</b><br/>"+
                            "Type: <b>"+t[j][10]+"</b><br/>"+
                            "Date: <b>"+project.get_Meta_data().getUTC()+"</b>]]>"+
                            "</description>"+
                            "<styleUrl>#red</styleUrl>"+"\n"+
                            "<Point>\n<coordinates>"+t[j][7]+","+t[j][6]+"</coordinates></Point>"+"\n"+
                            "</Placemark>"+"\n";

                    Kml.format("%s ",st);
                }
            }
        }

        String lastdata= "</Folder>\n" +
                "</Document></kml>";
        Kml.format("%s",lastdata);
        Kml.close();
    }
       	
    
    public static String[][] read(File f) throws IOException  {
        int count=0;
        Scanner in=new Scanner(f);
        while (in.hasNext()){
            count++;
            in.nextLine();
        }
        in=new Scanner(f);
        String line="";
        String tabelData[][]=new String[count][11];

        int startLine=2;
        in.nextLine();
        in.nextLine();
        while (in.hasNext()){
            line=in.nextLine();
            tabelData[startLine++]=line.split(",");
        }
        return tabelData;
    }


    public static GisLayer inlaize(String[][] s) throws IOException {
    	GisLayer layer = new GisLayer();
        double lat,lon,alt;
        for(int i = 2 ; i < s.length ; i++) {
            lat = Double.parseDouble(s[i][6]);
            lon = Double.parseDouble(s[i][7]);
            alt = Double.parseDouble(s[i][8]);
            MetaData m = new MetaData(s[i][0],s[i][1],s[i][2],s[i][3],s[i][4],s[i][5],s[i][9],s[i][10]);
            Point3D p = new Point3D(lat,lon,alt);
            GIS_element element = new GisElement(m,p);
            layer.add(element);
        }
        return layer;
    }


}
