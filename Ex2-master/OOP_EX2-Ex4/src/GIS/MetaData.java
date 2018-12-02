package GIS;

import Geom.Point3D;
import java.util.Date;

import com.sun.media.jfxmedia.events.NewFrameEvent;

import java.time.Instant;

public class MetaData implements Meta_data{
	private String MAC;
	private String SSID;
	private String AuthMode;
	private String FirstSeen;
	private String Channel;
	private String RSSI;
	private String Type;
	private String AccuracyMeters;
	
	public MetaData(String MAC,String SSID,String AuthMode,String FirstSeen,String Channel,String RSSI,String AccuracyMeters,String Type) {
		setMAC(MAC);
		setSSID(SSID);
		setAuthMode(AuthMode);
		setFirstSeen(FirstSeen);
		setChannel(Channel);
		setRSSI(RSSI);
		setAccuracyMeters(AccuracyMeters);
		setType(Type);
	}
	
	public String getMAC() {
		return MAC;
	}
	public void setMAC(String mAC) {
		MAC = mAC;
	}
	public String getSSID() {
		return SSID;
	}
	public void setSSID(String sSID) {
		SSID = sSID;
	}
	public String getAuthMode() {
		return AuthMode;
	}
	public void setAuthMode(String authMode) {
		AuthMode = authMode;
	}
	public String getFirstSeen() {
		return FirstSeen;
	}
	public void setFirstSeen(String firstSeen) {
		FirstSeen = firstSeen;
	}
	public String getChannel() {
		return Channel;
	}
	public void setChannel(String channel) {
		Channel = channel;
	}
	public String getRSSI() {
		return RSSI;
	}
	public void setRSSI(String rSSI) {
		RSSI = rSSI;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getAccuracyMeters() {
		return AccuracyMeters;
	}
	public void setAccuracyMeters(String accuracyMeters) {
		AccuracyMeters = accuracyMeters;
	}
	
	
	/** returns the Universal Time Clock associated with this data; */
	public long getUTC() {
		Date date = new Date();
	    return date.getTime();
	}
	@Override
	public String toString() {
		return "MyMeta_data [MAC=" + MAC + ", SSID=" + SSID + ", AuthMode=" + AuthMode + ", FirstSeen=" + FirstSeen
				+ ", Channel=" + Channel + ", RSSI=" + RSSI + ", Type=" + Type + ", AccuracyMeters=" + AccuracyMeters
				+ "]";
	}
	/**
	 * @return the orientation: yaw, pitch and roll associated with this data;
	 */
	public Point3D get_Orientation() {
		return null;
	}
	/*
	public static void main(String[]args) {
		Date date = new Date();
		System.out.println(date);
		System.out.println(date.getTime());
	}
	*/
}
