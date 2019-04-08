package com.labcode.gui.tool;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.labcode.edithistory.HistoryEvent;
import com.labcode.gui.clicklistener.ClickListener;
import com.labcode.math.Vector;
import com.labcode.project.Project;

public class TranslateTool extends Tool {

	private Vector diff;
	
	public TranslateTool(Project project) {
		super(project);
	}
	
	@Override
	public boolean applyHotkeys() {
		setIsActive(Gdx.input.isKeyPressed(Keys.SPACE));
		return isActive();
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
		Vector initialPressPos = ClickListener.getMousePos();
		diff = initialPressPos.sub(project.getCoordSystemHandler().getOriginPos());
	}

	@Override
	public void isTouched() {
		if(diff != null) {
			Vector newOriginPos = ClickListener.getMousePos().sub(diff);
			project.getCoordSystemHandler().setOriginPos(newOriginPos);
		}
	}

	@Override
	public void isTouchReleased() {
		diff = null;
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
