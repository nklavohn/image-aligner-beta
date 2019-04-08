package com.labcode.gui.clicklistener;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.labcode.math.Vector;
import com.labcode.zstack.ZStack;

public abstract class CircClickListener extends ClickListener {

	protected Vector cPos;  //the position of the center of the listener
	protected float radius;  //the radius of the circular hitbox of the listener
	
	public CircClickListener(String name, Vector cPos, float radius) {
		this.cPos = cPos;
		this.radius = radius;
		this.name = name;
	}
	
	/**
	 * for debugging purposes, displays a red circle around the hitbox
	 */
	@Override
	public void debugDisplay() {
		ZStack.shapes.setColor(Color.RED);
		ZStack.shapes.set(ShapeType.Line);
		ZStack.shapes.circle(cPos.x, cPos.y, radius);
	}
	
	/**
	 * Returns true if the CircClickListener was just touched
	 * @return boolean
	 */
	@Override
	public boolean isTouched() {
		return Gdx.input.justTouched() && isBeneathCursor();
	}

	/**
	 * Returns true if the cursor is hovering over the RectClickListener
	 * @return boolean
	 */
	@Override
	public boolean isBeneathCursor() {
		Vector mousePos = getMousePos();
		return mousePos.dst2(cPos) <= radius*radius;
	}
	
	/**
	 * a good ol' toString()
	 * @return String
	 */
	public String toString() { 
		return "pos: " + cPos.toString() + " rad: " + (int)radius; 
	}

	public Vector getCPos() { return cPos; }
	public float getRadius() { return radius; }
	public void setCPos(Vector cPos) { this.cPos = cPos; }
	public void setRadius(float radius) { this.radius = radius; }
}
