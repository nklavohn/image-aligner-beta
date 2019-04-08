package com.labcode.gui.panel;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Align;
import com.labcode.gui.tool.Tool;
import com.labcode.gui.tool.TranslateTool;
import com.labcode.gui.ColorManager;
import com.labcode.gui.clicklistener.IconButton;
import com.labcode.math.Vector;
import com.labcode.project.Project;
import com.labcode.zstack.ZStack;

public class Toolbox extends Panel {
	
	private ArrayList<IconButton> buttons = new ArrayList<IconButton>();
	private ArrayList<Tool> tools = new ArrayList<Tool>();
	private TranslateTool translateTool;
	
	public Toolbox(Project project) {
		super("Toolbox", new Vector(ZStack.width - 40, 40), new Vector(40, ZStack.height - 80));
		
		int iconSpacing = 35;
		int width = 40;
		
		String[] strings = {"Select", "MoveImage", "RotateImage", "Zoom", "Crop"};
		super.dim.set(width, strings.length * iconSpacing + 5);
		super.pos.set(ZStack.width - width, ZStack.height/2 - dim.y/2);
		
		Vector cPos = new Vector(pos.x + dim.x/2, pos.y + dim.y - dim.x/2);
		Vector iconDim = new Vector(32, 32);
		Vector rel = new Vector(-225, -10);
		
		for(String s : strings) {
			buttons.add(new IconButton(s, name, cPos.clone(), iconDim, Gdx.files.internal("icons/" + s + ".png"), rel, Align.right));
			tools.add(Tool.getTool(s, project));
			cPos.y -= iconSpacing;
		}
		
		translateTool = new TranslateTool(project);
		isVisible = true;
	}

	/** unused */
	@Override
	public void drawBatch1() {}

	/** Batch 2 */
	@Override
	public void drawBatch2() {
		for(IconButton btn : buttons) {
			btn.drawButtonBatch();
		}
	}

	@Override
	public void drawPanel() {
		ZStack.shapes.set(ShapeType.Filled);
		Color color = ColorManager.getTertiaryColor();
		ZStack.shapes.setColor(color.r, color.g, color.b, 0.6f);
		ZStack.shapes.rect(pos.x, pos.y, dim.x, dim.y);
	}
	
	/** unused */
	@Override
	public void drawShapes1() {}

	/** ShapeRenderer 2 */
	@Override
	public void drawShapes2() {
		drawPanel();
		for(IconButton btn : buttons) {
			btn.drawButtonShapes();
		}
	}

	/** unused */
	@Override
	public void drawShapes3() {}
	
	/** This is run every frame. Deals with hovering actions above 
	 * @param deltaTime the change in time during the past frame, Gdx.graphics.getDeltaTime()
	 */
	@Override
	public void handleHover(float deltaTime) {
		for(IconButton btn : buttons) {
			btn.onHover(deltaTime);
		}
	}
	
	/** Handles the keypresses for the toolbox
	 */
	@Override
	public void handleKeyPress() {
		//hot keys for all the tools displayed in the panel
		int index = -1;
		for(int i = 0; i < tools.size(); i++) {
			if(tools.get(i).applyHotkeys()) {
				index = i;
				buttons.get(i).setActive();
				tools.get(i).setActive();
				break;
			}
		}
		
		if(index != -1) {
			for(int i = 0; i < buttons.size(); i++) {
				if(i != index) {
					if(buttons.get(i).isActive()) {
						buttons.get(i).setInactive();
						tools.get(i).setInactive();
					}
				}
			}
		}
		//and also for the translate tool
		translateTool.applyHotkeys();
	}

	@Override
	public void handleResize() {
		
	}
	
	/** This is run every frame that Gdx.input.justTouched() returns true. It will check to see if any icon buttons were clicked
	 */
	@Override
	public void isJustTouched() throws NullPointerException {
		//translate tool
		if(translateTool.isActive()) {
			translateTool.isJustTouched();
		//all the other tools
		} else {
			int index = -1;
			for(int i = 0; i < buttons.size(); i++) {
				if(buttons.get(i).isJustTouched()) {
					index = i;
					tools.get(i).setActive();
					break;
				}
			}
			
			if(index != -1) {
				for(int i = 0; i < buttons.size(); i++) {
					if(i != index) {
						if(buttons.get(i).isActive()) {
							buttons.get(i).setInactive();
							tools.get(i).setInactive();
						}
					}
				}
			}
		}
	}
	
	@Override
	public void isTouched() throws NullPointerException {
		//translate tool
		if(translateTool.isActive()) {
			translateTool.isTouched();
		
		//all the other tools
		} else {
			
		}
	}

	@Override
	public void isTouchReleased() throws NullPointerException {
		//translate tool
		if(translateTool.isActive()) {
			translateTool.isTouched();
			
		//all the other tools
		} else {
			
		}
	}

	@Override
	public void updateClickHandlers() {
		
	}
}
