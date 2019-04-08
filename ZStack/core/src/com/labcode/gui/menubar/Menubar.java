package com.labcode.gui.menubar;

import java.awt.SystemColor;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.labcode.gui.ColorManager;
import com.labcode.gui.panel.Panel;
import com.labcode.math.Vector;
import com.labcode.project.Project;
import com.labcode.zstack.ZStack;

public class Menubar extends Panel {

	private Project project;
	private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
	
	public Menubar(Project project) {
		super("Menubar", new Vector(0, ZStack.height - 22), new Vector(ZStack.width, 22));
		this.project = project;
		
		initializeMenuBar();
		isVisible = true;
	}

	/** Creates the menu item with the given name and position
	 * @param name
	 * @param pos Vector of the bottom left corner
	 * @return
	 */
	private MenuItem createMenuItem(String name, Vector pos) {
		Label label = new Label(name, ZStack.skin);
		Vector dim = new Vector(label.getWidth() + smallPad, super.dim.y);
		MenuItem item = new MenuItem(name, pos.add(dim.scl(0.5f)), dim, label);
		return item;
	}
	
	@Override
	public void drawBatch1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawBatch2() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void drawPanel() {
		ZStack.shapes.set(ShapeType.Filled);
		Color color = ColorManager.getTertiaryColor();
		ZStack.shapes.setColor(color.r, color.g, color.b, 0.6f);
		ZStack.shapes.rect(pos.x, pos.y, dim.x, dim.y);
	}

	@Override
	public void drawShapes1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawShapes2() {
		drawPanel();
	}

	@Override
	public void drawShapes3() {
		// TODO Auto-generated method stub
		
	}
	
	/** basically just constructs the menubar... making the menu items and everything
	 */
	private void initializeMenuBar() {
		Vector miPos = new Vector(smallPad, ZStack.height - dim.y + smallPad/2);
		String[] strings = { "File", "Edit", "View", "Tools", "Help" };
		
		menuItems.add(initFile(miPos));
		menuItems.add(initEdit(miPos.setAdd(menuItems.get(menuItems.size()-1).getDim().x, 0)));
		menuItems.add(initView(miPos.setAdd(menuItems.get(menuItems.size()-1).getDim().x, 0)));
		menuItems.add(initTools(miPos.setAdd(menuItems.get(menuItems.size()-1).getDim().x, 0)));
		menuItems.add(initHelp(miPos.setAdd(menuItems.get(menuItems.size()-1).getDim().x, 0)));


		

		

		

		
		/*
		for(String string : strings) {
			Label miLabel = new Label(string, ZStack.skin);
			Vector miDim = new Vector(miLabel.getWidth() + smallPad, dim.y);
			MenuItem item = new MenuItem(string, miPos.add(miDim.scl(0.5f)), miDim, miLabel);
			menuItems.add(item);
			miPos.x += miDim.x;
		}*/
	}
	
	/*
    FILE
	    New Project         (Ctrl + N)
	    New Group           (Ctrl + Shift + N)
	    Duplicate Project   (Ctrl + Shift + D)
	
	    Open Recent         
	    Open...             (Ctrl + O)
	
	    Save                (Ctrl + S)
	    Save As...          (Ctrl + Shift + S)
	    Export              (Ctrl + E)
	    Export As...        (Ctrl + Shift + E)
	
	    Close Current Project
	    Quit App            (Ctrl + Q)
	 */
	/**
	 * @param pos the bottom left corner of the menuitem
	 * @return
	 */
	private MenuItem initFile(Vector pos) {
		MenuItem file = createMenuItem("File", pos);
		Dropdown dropdown = new Dropdown("File", pos);
		ArrayList<ListItem> listItems = new ArrayList<ListItem>();
		listItems.add(new MessageOpener("New Project", "(Ctrl + N)", pos.setAdd(0, Dropdown.pad)) {
			@Override
			public void applyFunction() {
				
			}
		});
		dropdown.setListItems(listItems);
		
		return file;
	}
	
	private MenuItem initEdit(Vector pos) {
		MenuItem edit = new MenuItem("Edit", null, null, new Label("Edit", ZStack.skin));

		return edit;
	}
	
	private MenuItem initView(Vector pos) {
		MenuItem view = new MenuItem("View", null, null, new Label("View", ZStack.skin));

		return view;
	}
	
	private MenuItem initTools(Vector pos) {
		MenuItem tools = new MenuItem("Tools", null, null, new Label("Tools", ZStack.skin));

		return tools;
	}
	
	private MenuItem initHelp(Vector pos) {
		MenuItem help = new MenuItem("Help", null, null, new Label("Help", ZStack.skin));

		return help;
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
	public void handleHover(float deltaTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleKeyPress() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleResize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateClickHandlers() {
		// TODO Auto-generated method stub
		
	}

}
