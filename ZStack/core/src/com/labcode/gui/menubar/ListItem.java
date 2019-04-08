package com.labcode.gui.menubar;

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.labcode.gui.clicklistener.RectClickListener;
import com.labcode.math.Vector;
import com.labcode.zstack.ZStack;

public abstract class ListItem extends RectClickListener {
	
	public static final int itemHeight = 15;

	private ArrayList<Label> labels;
	
	/** Constructor, makes the labels for the item based on parametrized strings
	 * @param name
	 * @param shortcut
	 * @param pos Vector the bottom left corner
	 */
	public ListItem(String nameString, String shortcutString, Vector pos) {
		super(nameString, pos.add(Dropdown.DEFAULT_WIDTH/2, itemHeight/2), new Vector(Dropdown.DEFAULT_WIDTH, itemHeight));
		Label name = new Label(nameString, ZStack.skin);
		name.setAlignment(Align.left);
		name.setPosition(pos.x + 25, pos.y);
		name.setName(nameString);
		
		Label shortcut = new Label(shortcutString, ZStack.skin);
		shortcut.setAlignment(Align.right);
		shortcut.setPosition(pos.x + dim.x - Dropdown.pad, pos.y);
		shortcut.setName(shortcutString);
		
		labels.add(name);
		labels.add(shortcut);
	}
	
	public abstract void displayBatch2();
	public abstract void displayShapes2();
	public abstract void applyFunction();
	
	/** adds the labels to the stage
	 */
	public void addToStage() {
		for(Label label : labels) 
			ZStack.stage.addActor(label);
	}
	
	/** Remove the labels from the stage
	 */
	public void removeFromStage() {
		for(Label label : labels)
			label.remove();
	}
	
	/* Getters and setters */
	public Vector getPos() { return cPos.add(dim.scl(-0.5f)); }
}
