package com.labcode.gui.clicklistener;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.labcode.math.Vector;
import com.labcode.zstack.ZStack;

public class TextButton extends Button {

	private Label label;
	private Color color;
	private boolean fill;
	
	public TextButton(String name, Vector cPos, Vector dim, Label label, Color color) {
		super(name, cPos, dim);
		label.setPosition(cPos.x, cPos.y, Align.center);
		label.setWidth(dim.x);
		label.setHeight(dim.y);
		this.label = label;
		this.color = color;
	}
	
	/** Adds text button label to the stage
	 */
	public void addToStage() {
		ZStack.stage.addActor(label);
	}
	
	/** Removes text button label from the stage
	 */
	public void clearStage() {
		label.remove();
	}
	
	/** unused */
	@Override
	public void drawButtonBatch() {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void drawButtonShapes() {
		debugDisplay();
		ZStack.shapes.set(ShapeType.Filled);
		ZStack.shapes.setColor(color);
		ZStack.shapes.rect(cPos.x - dim.x/2, cPos.y-dim.y/2, dim.x, dim.y);
	}

	@Override
	public boolean isJustTouched() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onHover(float deltaTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void runShutdown() {
		// TODO Auto-generated method stub
		
	}

}
