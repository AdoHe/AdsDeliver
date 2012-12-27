package edu.tongji.se.action;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ImageUploadAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final int BUFFER_SIZE = 16 * 1024;
	
	private File image;
	private String imageFileName;
	private String imageContentType;
	private int imageHeigth;
	private int imageWidth;
	private String imageFilePath;
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private static String getExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos);
	}

    @Override
	public String execute() throws FileNotFoundException, IOException
    {
		
		Random r = new Random();
        //生成随机文件名：当前年月日时分秒+五位随机数（为了在实际项目中防止文件同名而进行的处理）   
        int rannum = (int) (r.nextDouble() * (99999 - 10000 + 1)) + 10000; //获取随机数
		
        System.out.println(type);
        System.out.println(imageFileName);
        imageFileName = new Date().getTime() + "_" + rannum + getExtention(imageFileName);
        System.out.println(imageFileName);
        System.out.println(new Date().getTime());
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        System.out.println(sf.format(date));
        
        String path = "/upload/";
        
        String realPathAddress = ServletActionContext.getServletContext().getRealPath(path);
        System.out.println(realPathAddress);
        File folder = new File(realPathAddress);
        if(!folder.exists())
        {
        	folder.mkdirs();
        }
        
        //服务器上文件的真实路径
        String realFileAddress = ServletActionContext.getServletContext().getRealPath(path + imageFileName);
        File realFile = new File(realFileAddress);
        
        FileOutputStream outStream = new FileOutputStream(realFile);
		FileInputStream inStream = new FileInputStream(image);
		
		byte[] buffer = new byte[1024];
		int length = 0;
        
		while((length = inStream.read(buffer)) > 0)
		{
			outStream.write(buffer, 0, length);
		}
		
		inStream.close();
		outStream.close();

		if(type.equals("banner"))
		{
			String cutBannerImageName = ImageUploadAction.cutImage(realFileAddress, imageFileName, 32, 32);
			System.out.println(cutBannerImageName);
		}else
		{
			String cutContentImageName = ImageUploadAction.cutImage(realFileAddress, imageFileName, 540, 480);
			System.out.println(cutContentImageName);
		}
        imageFilePath = ServletActionContext.getRequest().getContextPath() + path + imageFileName;
		/*File imageFile = new File(imageFilePath);
                
		try {
			FileUtils.copyFile(image, imageFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImageIcon bi=new ImageIcon(imageFile.getPath());
                bi.setImage(bi.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
		System.out.println(bi.getIconHeight()+" "+bi.getIconWidth());
		setImageHeigth(bi.getIconHeight());
		setImageWidth(bi.getIconWidth());*/
		return SUCCESS;
	}

    public static String cutImage(String srcPath, String fileName, int width, int height) throws IOException
    {
    	File srcFile = new File(srcPath);
    	
    	BufferedImage image = ImageIO.read(srcFile);
    	int srcWidth = image.getWidth();
    	int srcHeight = image.getHeight();
    	
    	int newWidth = 0;
    	int newHeight = 0;
    	int x = 0;
    	int y = 0;
    	
    	double scale_w = (double)width/srcWidth;
    	double scale_h = (double)height/srcHeight;
    	
    	if(scale_w < scale_h)
    	{
    		newHeight = height;
    		newWidth = (int)(srcWidth*scale_h);
    		x = (newWidth - width)/2;
    	}else
    	{
    		newHeight = (int)(srcHeight*scale_w);
    		newWidth = width;
    		y = (newHeight - height)/2;
    	}
    	
    	BufferedImage newImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
    	newImage.getGraphics().drawImage(image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH),
    			0, 0, null);
    	
    	String srcFileName = srcFile.getName();
    	String fileSurfix = srcFileName.substring(srcFileName.lastIndexOf(".") + 1);
    	String destFileName = UUID.randomUUID().toString() + "." + fileSurfix;
    	File destFile = new File(srcFile.getParent(), fileName);
    	
    	//
    	ImageIO.write(newImage.getSubimage(x, y, width, height), fileSurfix, destFile);
    	
    	return destFileName;
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

	public String getImageFilePath() {
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}
	
	

	
}
