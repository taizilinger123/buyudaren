package fish;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

public class Fish implements Runnable {
	private int x;/* ctrl+alt+�¼�ͷ�����Ƶ�ǰ�е���һ�� */
	private int y;
	private int width;
	private int height;
	private int index;
	private BufferedImage[] images;
	private BufferedImage image;
	private int step;// �ƶ�����

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
	/** ��Runnable�ж���ĳ��󷽷�*/
	public void run() {
		while(true) {
			move();
			try {
				/** ѡ�� Thread.sleep(1000/10);�ͻ����try...catch��ͺ���*/
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
		//����ͼƬ
		image = images[index++%images.length];
	}

	/** ���� */
	public void getOut() {
		Random random = new Random();
		x = 800;
		y = random.nextInt(480 - height);
		step = random.nextInt(4) + 2;
	}

	/** ��鵱ǰ���Ƿ���ץ�� */
	public boolean catchBy(Net net) {
		int dx = net.getX() - this.x;
		int dy = net.getY() - this.y;
		return dx >= 0 && dx < width && dy >= 0 && dy < height;
	}
    //Source->Format�����д������
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
