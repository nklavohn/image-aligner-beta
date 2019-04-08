package com.labcode.gui.clicklistener;

public interface Clickable {
		
	//intended to check if the object is clicked
	public abstract boolean isTouched();
	
	//intended to return true if and only if the object is beneath the cursor
	public abstract boolean isBeneathCursor();
	
	//intended to run when object is just clicked on
	public abstract boolean isJustTouched();
	
	//intended to run continuously while hovering
	public abstract void onHover(float deltaTime);
}
