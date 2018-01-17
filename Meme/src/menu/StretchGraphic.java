package menu;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import guiTeacher.components.Graphic;

public class StretchGraphic extends Graphic {

	public StretchGraphic(int x, int y, int w, int h, String imageLocation) {
		super(x, y, w, h, imageLocation);
		// TODO Auto-generated constructor stub
	}
	
	public void loadImages(String imageLocation, int w, int h) {
		try{
			//get the full-size image
			ImageIcon icon = new ImageIcon(imageLocation);

			//use image size of original
			if(w==0 && h == 0){
				image = new BufferedImage(icon.getIconWidth(),icon.getIconHeight(),BufferedImage.TYPE_INT_ARGB);
				Graphics2D g = image.createGraphics();
				g.drawImage(icon.getImage(), 0, 0, null);
			}else{
				//make a full-size image
				image = new BufferedImage(icon.getIconWidth(),icon.getIconHeight(),BufferedImage.TYPE_INT_ARGB);
				Graphics2D g = image.createGraphics();
				g.drawImage(icon.getImage(), 0, 0, null);
				
				//scale the image to size
				AffineTransform scale = new AffineTransform();
				
				//make it fit to the smaller of the two
				double scaleWidth = w/(double)icon.getIconWidth();
				double scaleHeight = h/(double)icon.getIconHeight();
				double smallerOfTwo = (scaleWidth < scaleHeight)? scaleWidth : scaleHeight;
				
//				scale.scale(w/(double)icon.getIconWidth(), h/(double)icon.getIconHeight());
				scale.scale(scaleWidth, scaleHeight);
				AffineTransformOp scaleOp = new AffineTransformOp(scale, AffineTransformOp.TYPE_BILINEAR);
				image = scaleOp.filter(image,new BufferedImage((int)(image.getWidth()*smallerOfTwo), (int)(image.getHeight()*smallerOfTwo), BufferedImage.TYPE_INT_ARGB));
//				g.drawImage(icon.getImage(), 0, 0, w, h, 0,0,icon.getIconWidth(), icon.getIconHeight(), null);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
