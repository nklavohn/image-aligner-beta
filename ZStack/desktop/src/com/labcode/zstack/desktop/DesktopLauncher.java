package com.labcode.zstack.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.labcode.zstack.ZStack;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = ZStack.width;
		config.height = ZStack.height;
		config.title = "ZStackBeta";
		config.resizable = true;
		new LwjglApplication(new ZStack(), config);
	}
}
