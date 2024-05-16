package utlidades;

import java.awt.Image;
import java.sql.Blob;
import java.sql.SQLException;

import javax.swing.ImageIcon;

public class Util {

	public static  ImageIcon blobToImgIcon (Blob miImgBlob) {
		  ImageIcon scaledIcon = null;
		
    if (miImgBlob != null) {
        try {
            byte[] imageData = miImgBlob.getBytes(1, (int) miImgBlob.length());
            if (imageData != null && imageData.length > 0) {
                ImageIcon icon = new ImageIcon(imageData);
                Image image = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                 scaledIcon = new ImageIcon(image);
            } 
        } catch (SQLException e) {
            System.err.println("Error reading image data from Blob: " + e.getMessage());
            e.printStackTrace();
        }
    }  
    return scaledIcon;
	}
	
	

}
