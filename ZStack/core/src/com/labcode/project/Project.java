package com.labcode.project;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.labcode.gui.Active;
import com.labcode.gui.ColorManager;
import com.labcode.gui.UserInterface;
import com.labcode.math.CoordSystemHandler;
import com.labcode.math.DimensionHandler;
import com.labcode.math.Vector;
import com.labcode.zstack.ZStack;

public class Project implements Active {
	
	protected CoordSystemHandler coordSystemHandler;
	protected DimensionHandler dimensionHandler;
	protected UserInterface ui = new UserInterface(this);
	
	private String name;
	private ArrayList<Layer> layers = new ArrayList<Layer>();
	private boolean isActive;
	
	public Project() {
		isActive = true;
		dimensionHandler = new DimensionHandler();
		coordSystemHandler = new CoordSystemHandler(dimensionHandler);
		
		Layer layer = new Layer();
		layer.getImages().add(new ConfocalImage(Gdx.files.internal("icons/MoveImage.png"), new Vector(0,0), new Vector(200,200), 20));
	}
	
	/** Draws axes coming from the origin
	 */
	public void drawShapes1() {
		Vector originPos = coordSystemHandler.getOriginPos();
		ZStack.shapes.setColor(ColorManager.getPrimaryColor());
		ZStack.shapes.set(ShapeType.Line);
		ZStack.shapes.line(originPos.x, -1, originPos.x, ZStack.height + 1);
		ZStack.shapes.line(-1, originPos.y, ZStack.width, originPos.y);
	}

	/** Displays the project by drawing all of the layers it is comprised of
	 */
	public void drawBatch1() {
		for(Layer layer : layers) {
			if(layer.isVisible()) {
				layer.drawLayer(this);
			}
		}
	}
	
	public void drawShapes2() {
		
	}
	
	/** Renders everything... both the project itself and everything in the interface
	 */
	public void render() {
		ui.render();
	}
	
	/** Updates everything for the current frame.... passed to the userinterface
	 * @param delta
	 */
	public void update(float delta) {
		ui.update(delta);
	}
	
	/* Getters and setters */
	
	@Override public boolean isActive() { return isActive; }
	@Override public void setIsActive(boolean b) { isActive = b; }
	@Override public void setActive() { isActive = true; }
	@Override public void setInactive() { isActive = false; }
	
	public ArrayList<Layer> getLayers() { return layers; }
	public void setName(String name) { this.name = name; }
	public String getName() { return name; }
	public CoordSystemHandler getCoordSystemHandler() { return coordSystemHandler; }
	public DimensionHandler getDimensionHandler() { return dimensionHandler; }
}
