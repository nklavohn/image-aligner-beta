package com.labcode.gui.clicklistener;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.labcode.math.Vector;
import com.labcode.zstack.ZStack;

public abstract class RectClickListener extends ClickListener {

	protected Vector cPos;  //position of the center of the click listener
	protected Vector dim;  //dimensions of the click listener
	
	public RectClickListener(String name, Vector cPos, Vector dim) {
		this.cPos = cPos;
		this.dim = dim;
		this.name = name;
	}

	/**
	 * for debugging purposes, displays a red box around the hitbox
	 */
	@Override
	public void debugDisplay() {
		ZStack.shapes.setColor(Color.RED);
		ZStack.shapes.set(ShapeType.Line);
		ZStack.shapes.rect(cPos.x - dim.x/2, cPos.y - dim.y/2, dim.x, dim.y);
	}
	
	/**
	 * Returns true if the cursor is hovering over the RectClickListener
	 * @return boolean
	 */
	@Override
	public boolean isBeneathCursor() {
		Vector mousePos = getMousePos();
		Vector diff = mousePos.sub(cPos);
		return Math.abs(diff.x) <= dim.x/2f && Math.abs(diff.y) <= dim.y/2f;
	}
	
	/**
	 * Returns true if the RectClickListener was just touched
	 * @return boolean
	 */
	@Override
	public boolean isTouched() {
		return Gdx.input.justTouched() && isBeneathCursor();
	}
	
	/**
	 * a good ol' toString()
	 * @return String
	 */
	public String toString() { 
		return super.toString() + " pos: " + cPos.toString() + " dim: " + dim.toString(); 
	}
	
	public Vector getCPos() { return cPos; }
	public Vector getDim() { return dim; }
	public void setCPos(Vector cPos) { this.cPos = cPos; }
	public void setDim(Vector dim) { this.dim = dim; }
}
