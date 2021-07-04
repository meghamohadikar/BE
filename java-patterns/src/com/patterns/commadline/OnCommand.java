package com.patterns.commadline;

public class OnCommand implements Command {
	
	Television tv;
	
	public OnCommand(Television tv) {
		this.tv = tv;
	}
	
	@Override
	public void execute() {
		tv.on();

	}

}
