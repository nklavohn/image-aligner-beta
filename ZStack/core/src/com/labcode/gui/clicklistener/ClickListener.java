package com.labcode.gui.clicklistener;

import com.labcode.math.Vector;

public abstract class ClickListener implements Clickable {
	
	public static Vector mousePos = new Vector();
	protected String name;
	
	//intended to draw a red shape around the hitbox of the ClickListener, primarily for debugging purposes
	public abstract void debugDisplay();
	
	/** Returns a vector representing the position of the mouse in the screen coordinate system, measured in pixels
	 * @return Vector, mouseScrnPos
	 */
	public static Vector getMousePos() {
		return mousePos;
	}
	
	/** Sets the mousePos vector to x and y so zillions of copies of this vector aren't made per frame
	 * @param x
	 * @param y
	 */
	public static void setMousePos(float x, float y) {
		mousePos.set(x, y);
	}
	
	/** An override of the object toString method
	 */
	@Override
	public String toString() { 
		return name; 
	}
}
