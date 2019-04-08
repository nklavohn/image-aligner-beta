package com.labcode.gui.clicklistener;

import com.labcode.gui.Active;
import com.labcode.math.Vector;

public abstract class Button extends RectClickListener implements Active {

	protected boolean isActive;
	
	public Button(String name, Vector cPos, Vector dim) {
		super(name, cPos, dim);
		isActive = false;
	}
	
	public abstract void drawButtonBatch();
	public abstract void drawButtonShapes();
	public abstract void runShutdown();
	
	@Override public void setIsActive(boolean b) { isActive = b; }
	@Override public void setInactive() { isActive = false; }
	@Override public boolean isActive() { return isActive; }
	@Override public void setActive() { isActive = true; }
}
