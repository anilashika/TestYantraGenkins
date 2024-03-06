package com.GenericUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;



public class JavaUtils {
	/**
	 * This method is used to append random no
	 * @return
	 */
	public int getRandomNum()
	{
		Random ran=new Random();
		int random=ran.nextInt(500);//takes 0 t0 500
		return random;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSystemDate()
	{
	Date dt=new Date();	
String date=dt.toString();
		return date;
		
	}
	/**
	 * 
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		Date dt=new Date();
		String date=dateformat.format(dt);
		return date;
		
	}

}
