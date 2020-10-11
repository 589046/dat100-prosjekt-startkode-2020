package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	// konverter tidsinformasjon i gps data punkt til antall sekunder fra midnatt
	// dvs. ignorer information om dato og omregn tidspunkt til sekunder
	// Eksempel - tidsinformasjon (som String): 2017-08-13T08:52:26.000Z
	// skal omregnes til sekunder (som int): 8 * 60 * 60 + 52 * 60 + 26

	private static int TIME_STARTINDEX = 11; // startindex for tidspunkt i timestr

	public static int toSeconds(String timestr) {
		int hr = Integer.parseInt(timestr.substring(11, 13)); // substring metoden hentar ut ein del av ein string
		int min = Integer.parseInt(timestr.substring(14, 16)); // for 2017-08-13T08:52:26.000Z vill .substring(11,13)
		int sec = Integer.parseInt(timestr.substring(17, 19)); // hente ut "08" dvs den 11 char i stringen og den 12 og
																// den 13
		int secs = hr * 3600 + min * 60 + sec;

		return secs;
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		return new GPSPoint(toSeconds(timeStr), Double.parseDouble(latitudeStr), Double.parseDouble(longitudeStr),
				Double.parseDouble(elevationStr));
	}
}
