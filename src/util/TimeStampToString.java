package util;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
public class TimeStampToString {

	public static String revert(java.sql.Timestamp ts,int flag ){
		String str = null;
		SimpleDateFormat sdf=null;
		if(flag==0) 
			sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		else
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		str=sdf.format(ts);
        return str;
	}
}
