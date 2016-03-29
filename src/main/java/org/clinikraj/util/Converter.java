package org.clinikraj.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


// TODO: Auto-generated Javadoc
/**
 * The Class Converter.
 */

import javax.servlet.http.HttpSession;


import org.hibernate.Session;
//import org.green.model.Userprivilege;


public class Converter {
	
	/**
	 * String array to string.
	 *
	 * @param args the args
	 * @return the string buffer
	 */
	public static StringBuffer StringArrayToString(String[] args)
	{
		
		StringBuffer str =new StringBuffer();
		   if(args!=null && args.length!=0 )
		     {
		    
			     int len=args.length-1;
			     String temp="";
			     for(int i=0; i<args.length; i++)
			     {
					   temp = args[i];
					    
					   if(len!=(i))
					   {
					    str.append("'"+temp+"'"+",");
					   
					   }
					   else
					   {
					    str.append("'"+temp+"'");
					   
					   }
			   
			  }
		     }
		return str;
		
	}
	
	/**
	 * Stringto datefor db.
	 *
	 * @param date the date
	 * @return the date
	 * @throws ParseException the parse exception
	 */
	public static Date StringtoDateforDB(String date) throws ParseException
	  {
	   
	   String inputstrdate=date==null?"":date;
	   DateFormat inputdate=new SimpleDateFormat("dd-MM-yyyy");
	   Date indate=inputdate.parse(inputstrdate);
	   DateFormat outputdate=new SimpleDateFormat("yyyy-MM-dd");
	   String outstrdate=outputdate.format(indate);
	   return outputdate.parse(outstrdate);
	   
	  }
	 
 	/**
 	 * Format date.
 	 *
 	 * @param date the date
 	 * @return the string
 	 * @throws ParseException the parse exception
 	 */
 	public static String FormatDate(String date) throws ParseException
	  {
	   
	   String inputstrdate=date==null?"":date;
	   DateFormat inputdate=new SimpleDateFormat("yyyy-MM-dd");
	   Date indate=inputdate.parse(inputstrdate);
	   DateFormat outputdate=new SimpleDateFormat("dd-MM-yyyy");
	   String outstrdate=outputdate.format(indate);
	   return outstrdate;
	   
	  }
	 public static String FormatTimestamp(String date) throws ParseException
	  {
	   
	   String inputstrdate=date==null?"":date;
	   DateFormat inputdate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   Date indate=inputdate.parse(inputstrdate);
	   DateFormat outputdate=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	   String outstrdate=outputdate.format(indate);
	   return outstrdate;
	   
	  }
	/*public static void roleprivilleges(HttpSession session,Userprivilege userprivilege)
	 {
		 session.removeAttribute("DELETE");
		 session.removeAttribute("INSERT");
		 session.removeAttribute("UPDATE");
		 session.removeAttribute("READ");
		 session.removeAttribute("REPORT");
		 
		 System.out.println(" DELETE----for -->"+userprivilege.getDeleteflag()+"\t"+"INSERT--->"+userprivilege.getInsertflag()+"\t"+
		                    " UPDATE----->"+userprivilege.getUpdateflag()+"\t"+" REport --->"+userprivilege.getReportflag());
		 System.out.println("----------UPDATE FLAG--------------"+userprivilege.getUpdateflag());
		 session.setAttribute("DELETE", userprivilege.getDeleteflag());
		 session.setAttribute("INSERT", userprivilege.getInsertflag());
		 session.setAttribute("UPDATE", userprivilege.getUpdateflag());
		 session.setAttribute("READ", userprivilege.getReadflag());
		 session.setAttribute("REPORT", userprivilege.getReportflag());
		 
	}*/

	
	 public static int AgeCalculation(Date patientdob){
			Calendar cal1=Calendar.getInstance();
			Calendar cal2=Calendar.getInstance();
			int factor = 0;
			int age;
			Date date1 = patientdob;
			Date date2=new Date();
			cal1.setTime(date1);
			cal2.setTime(date2);
			if(cal2.get(Calendar.DAY_OF_YEAR) < cal1.get(Calendar.DAY_OF_YEAR)) {
			      factor = -1; 
			}
			age = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR) + factor;
			return age;
		}
	
}
