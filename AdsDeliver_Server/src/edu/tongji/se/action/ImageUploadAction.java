package edu.tongji.se.action;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.ImageIcon;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ImageUploadAction extends ActionSupport {

	private static final int BUFFER_SIZE = 16 * 1024;
	
	private File image;
	private String imageFileName;
	private String imageContentType;
	private int imageHeigth;
	private int imageWidth;
	
	
	private static String getExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos);
	}

    @Override
	public String execute() {
		
		imageFileName = image.getName();
		
		Random r = new Random();
        //生成随机文件名：当前年月日时分秒+五位随机数（为了在实际项目中防止文件同名而进行的处理）   
        int rannum = (int) (r.nextDouble() * (99999 - 10000 + 1)) + 10000; //获取随机数
		
        System.out.println(imageFileName);
        imageFileName = new Date().getTime() + "_" + rannum + getExtention(imageFileName);
        System.out.println(imageFileName);
        System.out.println(new Date().getTime());
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        System.out.println(sf.format(date));
        
       

                
		File imageFile = new File(ServletActionContext.getServletContext()
				.getRealPath("/images/")
				+ "/" + imageFileName);
                
		try {
			FileUtils.copyFile(image, imageFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImageIcon bi=new ImageIcon(imageFile.getPath());
                bi.setImage(bi.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
		System.out.println(bi.getIconHeight()+" "+bi.getIconWidth());
		setImageHeigth(bi.getIconHeight());
		setImageWidth(bi.getIconWidth());
		return SUCCESS;
	}


	public File getImage() {
		return image;
	}


	public void setImage(File image) {
		this.image = image;
	}


	public String getImageFileName() {
		return imageFileName;
	}


	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}


	public String getImageContentType() {
		return imageContentType;
	}


	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}


	public int getImageHeigth() {
		return imageHeigth;
	}


	public void setImageHeigth(int imageHeigth) {
		this.imageHeigth = imageHeigth;
	}


	public int getImageWidth() {
		return imageWidth;
	}


	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}
	
	

	
}
