package com.patterns.commadline;

public class Person {
	public  static void main(String[] args) {
	
	Television tele=new Television();
	RemoteControl rc=new RemoteControl();
	OnCommand oc=new OnCommand(tele);
	rc.setCmd(oc);
	rc.pressButton();
	
	OffCommand ofc=new OffCommand(tele);
	rc.setCmd(ofc);
	rc.pressButton();
	}

}
