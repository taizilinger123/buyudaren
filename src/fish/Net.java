package fish;
import java.io.File;
import  javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Net {
	   private int x;/*中心点*/
	   private int y;/*中心点*/
	   private int width;
	   private int height;
	   private BufferedImage image;
	   private boolean show;
	   public Net(String img) throws Exception{
	   //从文件系统加载图片
	   image = ImageIO.read(new File(img));
	   width = image.getWidth();
	   height = image.getHeight();
	   }
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	public boolean isShow() {
		return show;
	}
	public void setShow(boolean show) {
		this.show = show;
	}
	   
}
