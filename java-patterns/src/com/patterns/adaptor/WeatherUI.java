package com.patterns.adaptor;

public class WeatherUI {

		public void showTemp(int zip) {//returns temp by using zipcode
			WeatherAdaptor adp=new WeatherAdaptor();
			System.out.println(adp.findtemp(zip));
			
		}
		public static void main(String[] args) {
			WeatherUI ui=new WeatherUI();
			ui.showTemp(02);
		}
}
