package com.labcode.zstack;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.labcode.gui.ColorManager;
import com.labcode.screens.EditorScreen;

public class ZStack extends ApplicationAdapter {
	
	protected Screen screen; //the screen
	
	public static OrthographicCamera camera;
	public static ScreenViewport sViewport;
	public static SpriteBatch batch;
	public static ShapeRenderer shapes;
	public static Stage stage;
	public static Skin skin;
	public static final int DEF_WIDTH = 1000;  //the default width and height of the screen
	public static final int DEF_HEIGHT = 600;  //the default width and height of the screen
	public static int width = DEF_WIDTH;
	public static int height = DEF_HEIGHT; 
	
	private int mode = 0;
	
	/**
	 * A switch around the setScreen method, pass in the id for a screen to set it
	 * @param screen
	 */
	public void changeScreen(int screen) {
		switch (screen) {
		case 0:
			this.setScreen(new EditorScreen());
			break;
		default:
			this.setScreen(new EditorScreen());
			break;
		}
	}
	
	/**Essentially takes the place of the constructor
	 */
	@Override
	public void create () {
		camera = new OrthographicCamera();
		sViewport = new ScreenViewport(camera);
		batch = new SpriteBatch();
		shapes = new ShapeRenderer();
		stage = new Stage(sViewport);
		skin = new Skin(Gdx.files.internal("uiskins/uiskin.json"));
				
		shapes.setProjectionMatrix(batch.getProjectionMatrix());
		shapes.setAutoShapeType(true);
		
		ColorManager.setToDefault();
		
		changeScreen(mode);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		shapes.dispose();
		stage.dispose();
	}
	
	/**Renders the screen if the screen is non null
	 */
	@Override
	public void render () {
		if (screen != null) screen.render(Gdx.graphics.getDeltaTime());
	}
	
	/**Resizes the current screen if it is non null
	 * @param width int representing the new width
	 * @param height int representing the new height
	 */
	@Override
	public void resize (int width, int height) {
		if (screen != null) screen.resize(width, height);
	}

	/** @return the currently active {@link Screen}. */
	public Screen getScreen () {
		return screen;
	}
	
	/** Sets the current screen. {@link Screen#hide()} is called on any old screen, and {@link Screen#show()} is called on the new
	 * screen, if any.
	 * @param screen may be {@code null} */
	public void setScreen (Screen screen) {
		if (this.screen != null) this.screen.hide();
		this.screen = screen;
		if (this.screen != null) {
			this.screen.show();
			this.screen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		}
	}
}
