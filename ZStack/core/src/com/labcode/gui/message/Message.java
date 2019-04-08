package com.labcode.gui.message;

import com.labcode.math.Vector;

public abstract class Message {

	protected Vector pos;
	protected Vector dim;
	protected String name;
	
	public abstract void create();
	public abstract void onClick();
	public abstract void onHover();
	public abstract void dispose();
	
	public void addCancelButton() {
		
	}
}
