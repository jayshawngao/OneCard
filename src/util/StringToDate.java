package util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.chrono.JapaneseChronology;

public class StringToDate {

	public static java.sql.Date revert(String s){
		java.util.Date d1= new java.util.Date();
		SimpleDateFormat sdf=null;
		sdf=new SimpleDateFormat("yyyy-MM-dd");
		try{
			d1 = sdf.parse(s);
			}catch(Exception e){
			e.printStackTrace();
			}
		return new java.sql.Date(d1.getTime());
	}
}
