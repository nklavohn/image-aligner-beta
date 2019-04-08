package com.labcode.project;

import java.util.ArrayList;

public class Layer {

	private ArrayList<ConfocalImage> images = new ArrayList<ConfocalImage>();
	private boolean isVisible;
	
	public Layer() {
	}
	
	public Layer(ConfocalImage image) {
		images.add(image);
		isVisible = true;
	}
	
	/** Displays the layer by drawing all the images it is comprised of
	 */
	public void drawLayer(Project project) {
		for(ConfocalImage image : images) {
			image.drawImage(project);
		}
	}
		
	/* Getters and setters */
	public ArrayList<ConfocalImage> getImages() { return images; }
	public boolean isVisible() { return isVisible; }
	public void setIsVisible(boolean b) { isVisible = b; }
}
