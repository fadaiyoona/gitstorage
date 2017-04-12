package net.dfrz.resource;

import java.util.ResourceBundle;

public class Resource {
	public static String MeetDetailsInfoExcelPath;
	public static String LogPath;

	static {
		ResourceBundle rb = ResourceBundle.getBundle("net.dfrz.resource.res");
		LogPath = rb.getString("LogPath");
		MeetDetailsInfoExcelPath = rb.getString("MeetDetailsInfoExcelPath");
	}
}
