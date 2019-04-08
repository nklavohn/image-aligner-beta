package com.labcode.gui.menubar;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.labcode.gui.Active;
import com.labcode.gui.ColorManager;
import com.labcode.gui.clicklistener.Button;
import com.labcode.gui.clicklistener.RectClickListener;
import com.labcode.gui.clicklistener.TextButton;
import com.labcode.gui.panel.Panel;
import com.labcode.math.Vector;
import com.labcode.zstack.ZStack;

public class MenuItem extends TextButton {
	
	private Dropdown dropdown;
	
	public MenuItem(String name, Vector cPos, Vector dim, Label label) {
		super(name, cPos, dim, label, ColorManager.getQuatenaryColor());
		super.addToStage();
		label.setPosition(label.getX(), label.getY() - 3);
	}
	
	@Override
	public void drawButtonShapes() {
		debugDisplay();
	}

	@Override
	public boolean isJustTouched() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void runShutdown() {
		// TODO Auto-generated method stub
		
	}
}
