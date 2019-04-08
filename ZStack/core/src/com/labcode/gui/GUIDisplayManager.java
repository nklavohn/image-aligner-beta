package com.labcode.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.labcode.gui.panel.Panel;
import com.labcode.project.Project;
import com.labcode.zstack.ZStack;

public class GUIDisplayManager {
	
	public void drawShapes1(UserInterface ui) {
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		ZStack.shapes.begin(ShapeType.Filled);

		ui.project.drawShapes1();
		
		for(Panel panel : ui.panels) {
			if(panel.isVisible()) {
				panel.drawShapes1();
			}
		}
		ZStack.shapes.end();
		Gdx.gl.glDisable(GL20.GL_BLEND);
	}
	
	public void drawBatch1(UserInterface ui) {
		ZStack.batch.begin();
		ui.project.drawBatch1();
		
		for(Panel panel : ui.panels) {
			if(panel.isVisible()) {
				panel.drawBatch1();
			}
		}
		ZStack.batch.end();
	}
	
	public void drawShapes2(UserInterface ui) {
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		ZStack.shapes.begin(ShapeType.Filled);
		for(Panel panel : ui.panels) {
			if(panel.isVisible()) {
				panel.drawShapes2();
			}
		}
		ZStack.shapes.end();
		Gdx.gl.glDisable(GL20.GL_BLEND);
	}
	
	public void drawBatch2(UserInterface ui) {
		ZStack.batch.begin();
		for(Panel panel : ui.panels) {
			//adjust to only run loop for the visible panels, stored in a visible panels array or somethingl ike that
			if(panel.isVisible()) {
				panel.drawBatch2();
			}
		}
		ZStack.batch.end();
	}
	
	public void drawShapes3(UserInterface ui) {
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		ZStack.shapes.begin(ShapeType.Filled);
		for(Panel panel : ui.panels) {
			panel.drawShapes3();
		}
		ZStack.shapes.end();
		Gdx.gl.glDisable(GL20.GL_BLEND);
	}
}
