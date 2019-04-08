package com.labcode.gui;

import com.badlogic.gdx.graphics.Color;

public abstract class ColorManager {

	public static final Color WHITE = new Color(1, 1, 1, 1);
	public static final Color LIGHT_GRAY = new Color(0.8f, 0.8f, 0.8f, 1);
	public static final Color GRAY = new Color(0.6f, 0.6f, 0.6f, 1);
	public static final Color DARK_GRAY = new Color(0.35f, 0.35f, 0.35f, 1);
	public static final Color DARKER_GRAY = new Color(0.17f, 0.17f, 0.17f, 1);
	public static final Color BASICALLY_BLACK = new Color(0.1f, 0.1f, 0.1f, 1);
	public static final Color BLACK = new Color(0, 0, 0, 1);
	
	private static Color gridColor, originColor, primaryColor, secondaryColor, tertiaryColor, quatenaryColor, 
			backgroundColor, iconColorInactive, iconColorActive, selectedImageTint, menuBarColor;
	
	/** Sets the colors to default values
	 */
	public static void setToDefault() {
		gridColor = new Color(0.2f, 0.2f, 0.2f, 1);
		originColor = new Color(0.8f, 0.5f, 0.5f, 1);
		primaryColor = GRAY;
		secondaryColor = LIGHT_GRAY;
		tertiaryColor = DARK_GRAY;
		quatenaryColor = DARKER_GRAY;
		backgroundColor = BASICALLY_BLACK;
		iconColorInactive = new Color(0.9f, 0.9f, 0.9f, 1);
		iconColorActive = new Color(0.8f, 0.8f, 0.8f, 1);
		selectedImageTint = new Color(0, 1, 1, 1);
		menuBarColor = new Color(0.25f, 0.25f, 0.5f, 0.6f);
	}
	
	/* Getters and setters for all of the colors */
	public static Color getGridColor() { return gridColor; }
	public static Color getOriginColor() { return originColor; }
	public static Color getPrimaryColor() { return primaryColor; }
	public static Color getSecondaryColor() { return secondaryColor; }
	public static Color getTertiaryColor() { return tertiaryColor; }
	public static Color getBackgroundColor() { return backgroundColor; }
	public static Color getIconColorActive() { return iconColorActive; }
	public static Color getIconColorInactive() { return iconColorInactive; }
	public static Color getSelectedImageTint() { return selectedImageTint; }
	public static Color getQuatenaryColor() { return quatenaryColor; }
	public static Color getMenuBarColor() { return menuBarColor; }
	
	public static void setGridColor(Color color) { gridColor = color; }
	public static void setOriginColor(Color color) { originColor = color; }
	public static void setPrimaryColor(Color color) { primaryColor = color; }
	public static void setSecondaryColor(Color color) { secondaryColor = color; }
	public static void setTertiaryColor(Color color) { tertiaryColor = color; }
	public static void setBackgroundColor(Color color) { backgroundColor = color; }
	public static void setIconColorActive(Color color) { iconColorActive = color; }
	public static void setIconColorInactive(Color color) { iconColorInactive = color; }
	public static void setSelectedImageTint(Color color) { selectedImageTint = color; }
	public static void setQuatenaryColor(Color color) { quatenaryColor = color; }
	public static void setMenuBarColor(Color color) { menuBarColor = color; }
}
