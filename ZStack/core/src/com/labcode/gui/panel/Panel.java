package com.labcode.gui.panel;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.labcode.gui.ColorManager;
import com.labcode.gui.Visible;
import com.labcode.gui.clicklistener.ClickListener;
import com.labcode.math.Vector;
import com.labcode.zstack.ZStack;

public abstract class Panel implements Visible {
	
	public static int smallPad = 8;
	public static int pad = 15;
	private static int stgHeight = 20;
	protected static int titleHeight = 40;
	protected Vector dim; //dimensions of the panel
	protected Vector pos; //position of the bottom left corner of the panel
	protected String name;
	protected boolean isVisible;
	
	public Panel(String name, Vector pos, Vector dim) {
		this.name = name;
		this.pos = pos;
		this.dim = dim;
	}
	
	public abstract void drawBatch1();
	public abstract void drawBatch2();
	public abstract void drawShapes1();
	public abstract void drawShapes2();
	public abstract void drawShapes3();
	public abstract void isJustTouched();
	public abstract void isTouched();
	public abstract void isTouchReleased();
	public abstract void handleHover(float deltaTime);
	public abstract void handleKeyPress();
	public abstract void handleResize();
	public abstract void updateClickHandlers();
	
	/** Removes any actors from the stage which are from the panel which added them (tests the name of the actor)
	 */
	public void clearPanelStage() {
		for(int i = ZStack.stage.getActors().size; i >= 0; i--) {
			Actor actor = ZStack.stage.getActors().get(i);
			if(actor != null && actor.getName() != null && actor.getName().length() >= name.length()) {
				if(actor.getName().substring(0, name.length()).equals(name)) ZStack.stage.getActors().removeIndex(i);
			}
		}
	}
	
	/** Draws a box according to the parametrized values
	 * @param x
	 * @param y position of bottom left corner
	 * @param width
	 * @param height dimensions of the box
	 */
	public void drawBox(int x, int y, int width, int height) {
		ZStack.shapes.set(ShapeType.Filled);
		ZStack.shapes.setColor(ColorManager.getTertiaryColor());
		ZStack.shapes.rect(x, y, width, height);
		
		ZStack.shapes.set(ShapeType.Line);
		ZStack.shapes.setColor(ColorManager.getSecondaryColor());
		ZStack.shapes.rect(x, y, width, height);
	}
	
	/** Draws the panel background according to its dimensions
	 */
	public void drawPanel() {
		ZStack.shapes.set(ShapeType.Filled);
		Color color = ColorManager.getPrimaryColor();
		ZStack.shapes.setColor(color.r, color.g, color.b, 0.6f);
		ZStack.shapes.rect(pos.x, pos.y, dim.x, dim.y);
	}
	
	/** Draws the box at the top of the panel in which the Title is displayed
	 */
	public void drawTitleBox() {
		ZStack.shapes.set(ShapeType.Filled);
		ZStack.shapes.setColor(ColorManager.getSecondaryColor());
		ZStack.shapes.rect(pos.x, pos.y + dim.y - titleHeight, dim.x, titleHeight);
	}
	
	public boolean isBeneathCursor() {
		Vector mousePos = ClickListener.getMousePos();
		Vector diff = mousePos.sub(pos.add(dim.scl(0.5f)));
		return Math.abs(diff.x) <= dim.x/2 && Math.abs(diff.y) <= dim.y/2;
	}

	@Override public boolean isVisible() { return isVisible; }
	@Override public void setIsVisible(boolean b) { isVisible = b; }
	@Override public void setVisible() { isVisible = true; }
	@Override public void setInvisible() { isVisible = false; }
	
	public static int getStgHeight() { return stgHeight; }
	public Vector getPos() { return pos; }
	public Vector getDim() { return dim; }
}
