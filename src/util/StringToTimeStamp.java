package util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class StringToTimeStamp {

	public static Timestamp revert(String s,int flag){
		java.util.Date d1= new java.util.Date();
		SimpleDateFormat sdf=null;
		if(flag==0) sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		else sdf=new SimpleDateFormat("yyyy-MM-dd");
		try{
		d1 = sdf.parse(s);
		}catch(Exception e){
		e.printStackTrace();
		}
		java.sql.Timestamp ts=new Timestamp(d1.getTime());
		return ts;
	}
}
