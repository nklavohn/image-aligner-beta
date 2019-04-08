package com.labcode.gui.menubar;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.labcode.gui.ColorManager;
import com.labcode.math.Vector;
import com.labcode.zstack.ZStack;

public class LineBreak extends ListItem {
	
	public LineBreak(Vector pos) {
		super(null, null, pos);
	}

	/** unused */
	@Override
	public void applyFunction() {
		// TODO Auto-generated method stub
		
	}
	
	/** unused */
	@Override
	public void displayBatch2() {}

	@Override
	public void displayShapes2() {
		ZStack.shapes.set(ShapeType.Line);
		ZStack.shapes.setColor(ColorManager.getQuatenaryColor());
		Vector cPos = getCPos();
		int deltax = Dropdown.DEFAULT_WIDTH / 2 - Dropdown.pad;
		ZStack.shapes.line(cPos.x - deltax, cPos.y, cPos.x + deltax, cPos.y);
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
