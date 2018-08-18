package fish;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

public class Fish implements Runnable {
	private int x;/* ctrl+alt+下箭头：复制当前行到下一行 */
	private int y;
	private int width;
	private int height;
	private int index;
	private BufferedImage[] images;
	private BufferedImage image;
	private int step;// 移动步伐

	public Fish(String perfix) throws Exception {
		//prefix = "fish01"
		// fish01_01.png ~ fish01_10.png -> images
		images = new BufferedImage[10];
		for (int i = 1; i <= 10; i++) {
			// i=1 2 3 ... 10
			String file = perfix + "_0" + i + ".png";
			images[i] = ImageIO.read(new File(file));
		}
		image = images[0];
		width = image.getWidth();
		height = image.getHeight();
		Random random = new Random();
		x = random.nextInt(800 - width);
		y = random.nextInt(480 - height);
		step = random.nextInt(4) + 2;
	}
	/** 在Runnable中定义的抽象方法*/
	public void run() {
		while(true) {
			move();
			try {
				/** 选中 Thread.sleep(1000/10);就会出现try...catch点就好了*/
				Thread.sleep(1000/10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void move() {
		x -= step;
		if (x < -width) {
			getOut();
		}
		//更换图片
		image = images[index++%images.length];
	}

	/** 滚蛋 */
	public void getOut() {
		Random random = new Random();
		x = 800;
		y = random.nextInt(480 - height);
		step = random.nextInt(4) + 2;
	}

	/** 检查当前鱼是否被网抓到 */
	public boolean catchBy(Net net) {
		int dx = net.getX() - this.x;
		int dy = net.getY() - this.y;
		return dx >= 0 && dx < width && dy >= 0 && dy < height;
	}
    //Source->Format让所有代码对齐
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

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public BufferedImage[] getImages() {
		return images;
	}

	public void setImages(BufferedImage[] images) {
		this.images = images;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

}
