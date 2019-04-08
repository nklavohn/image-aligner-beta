package com.labcode.gui.menubar;

import javax.swing.Icon;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.labcode.gui.clicklistener.IconButton;
import com.labcode.math.Vector;
import com.labcode.zstack.ZStack;

public class HotKeyApplier extends ListItem {
	
	private IconButton icon;

	public HotKeyApplier(String name, String shortcut, Vector pos, IconButton icon) {
		super(name, shortcut, pos);
		this.icon = icon;
	}
	
	@Override
	public void applyFunction() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void displayBatch2() {
		icon.drawButtonBatch();
	}

	@Override
	public void displayShapes2() {
		// TODO Auto-generated method stub
		
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

	
}
