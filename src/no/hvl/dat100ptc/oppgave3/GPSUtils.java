package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max;

		max = da[0];

		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}

		return max;
	}

	public static double findMin(double[] da) {

		double min = da[0];

		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}

		return min;
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {
		double[] latitudes = new double[gpspoints.length];
		
		for (int i = 0; i < latitudes.length; i++) {
			latitudes[i] = gpspoints[i].getLatitude();
		}
		
		return latitudes;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double[] longitudes = new double[gpspoints.length];
		
		for (int i = 0; i < longitudes.length; i++) {
			longitudes[i] = gpspoints[i].getLongitude();
		}
		
		return longitudes;

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {
		
		double latitude1 = Math.toRadians(gpspoint1.getLatitude()); 
		double latitude2 = Math.toRadians(gpspoint2.getLatitude());
		
		double longitude1 = Math.toRadians(gpspoint1.getLongitude()); 
		double longitude2 = Math.toRadians(gpspoint2.getLongitude());
	
		double a = Math.pow((Math.sin((latitude2-latitude1)/2)), 2) + Math.cos(latitude1) * Math.cos(latitude2)
				* Math.pow((Math.sin((longitude2-longitude1)/2)), 2);
		
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double d = 6371000 * c;
		
		return d;
	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs = gpspoint2.getTime() - gpspoint1.getTime();
		
		double dis = distance(gpspoint1, gpspoint2);
		
		double speed = dis / secs * 3.6; // distanse / tid
		
		return speed;
	}

	public static String formatTime(int secs) {

		String timestr = "";
		String TIMESEP = ":";
		
		int hr = 0;
		int min = 0;
		
		while (secs >= 60) {
			min++;
			secs -= 60;
		} while (min >= 60) {
			hr++;
			min -= 60;
		}
		
		timestr = String.format("  %02d:%02d:%02d", hr, min, secs);
		
		return timestr;
	}

	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;
		
		str = String.format("% 10.02f", d);
		
		return str;
	}
}
