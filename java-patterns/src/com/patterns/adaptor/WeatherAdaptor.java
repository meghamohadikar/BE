package com.patterns.adaptor;

public class WeatherAdaptor {
	public int findtemp(int zipcode) {
		String city=null;
		if(zipcode==02) {
			city="Nagpur";
		}
		WeatherFinder find=new WeatherFinderImpl() ;
		int temp = find.find(city);
		return temp;
		
		
	}

}
