package com.patterns.commadline;

public class RemoteControl {//invoker
	
	private Command cmd;

	public Command getCmd() {
		return cmd;
	}

	public void setCmd(Command cmd) {
		this.cmd = cmd;
	}

	public void pressButton() {
		cmd.execute();
	}
}
