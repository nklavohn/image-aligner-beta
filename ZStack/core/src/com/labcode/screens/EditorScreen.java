package com.labcode.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.labcode.gui.ColorManager;
import com.labcode.project.Project;
import com.labcode.zstack.ZStack;

public class EditorScreen implements Screen {
	
	private ArrayList<Project> projects = new ArrayList<Project>();
	private int curProj;
	
	public EditorScreen() {
		Gdx.input.setInputProcessor(ZStack.stage);
		projects.add(new Project());
		curProj = 0;
	}
	
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		//Clears the screen and refills the background with a dark color
		Color color = ColorManager.getBackgroundColor();
		Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//Updating viewport doodads
		ZStack.sViewport.getCamera().update();
		ZStack.batch.setProjectionMatrix(ZStack.sViewport.getCamera().combined);
		ZStack.shapes.setProjectionMatrix(ZStack.sViewport.getCamera().combined);
		
		projects.get(curProj).update(delta);
		projects.get(curProj).render();
	}

	@Override
	public void resize(int width, int height) {
		ZStack.width = width;
		ZStack.height = height;		
		((OrthographicCamera)ZStack.sViewport.getCamera()).setToOrtho(false);
		ZStack.batch.setProjectionMatrix(ZStack.sViewport.getCamera().combined);
		ZStack.shapes.setProjectionMatrix(ZStack.sViewport.getCamera().combined);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
