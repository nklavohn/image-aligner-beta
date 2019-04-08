package com.labcode.gui.tool;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.labcode.edithistory.HistoryEvent;
import com.labcode.project.Project;

public class ZoomTool extends Tool {

	public ZoomTool(Project project) {
		super(project);
	}
	
	@Override
	public boolean applyHotkeys() {
		return Gdx.input.isKeyJustPressed(Keys.Z);
	}

	@Override
	public void debugDisplay() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayToolShapes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayToolBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void isJustTouched() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void isTouched() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void isTouchReleased() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHover() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyPress() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected HistoryEvent writeHistoryEvent() {
		// TODO Auto-generated method stub
		return null;
	}

}
