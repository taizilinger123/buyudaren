package fish;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JPanel;

public class Pool extends JPanel {

	private BufferedImage backgroud;
	private Net net;
	private Fish[] all;

	public Pool() throws Exception {
		backgroud = ImageIO.read(new File("bg.jpg"));
		net = new Net("net09.png");
		all = new Fish[] { 
				new Fish("fish01"), new Fish("fish02"), 
				new Fish("fish03"), new Fish("fish04"),
				new Fish("fish05"), new Fish("fish06"),
				new Fish("fish07"), new Fish("fish08"),
				new Fish("fish09"), new Fish("fish13"),
				new Fish("fish014"), new Fish("fish014") };
	}

	public void paint(Graphics g) {
		g.drawImage(backgroud, 0, 0, null);
		for (Fish fish : all) {
			int x = fish.getX();
			int y = fish.getY();
			g.drawImage(fish.getImage(), x, y, null);
		}
		if (net.isShow()) {
			Image img = net.getImage();
			int x = net.getX() - net.getWidth() / 2;
			int y = net.getY() - net.getHeight() / 2;
			g.drawImage(img, x, y, null);
		}
	}

	public void action() throws Exception {
		// 启动每条鱼，让鱼自己去游动(run)
		for (Fish fish : all) {
			// Thread 线程API,可以启动鱼自己去游动
			Thread t = new Thread(fish);
			t.start();// 启动(start)鱼自己去游动(run())
		}

		MouseAdapter l = new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				catchFish();// 抓鱼
			}

			public void mouseMoved(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				net.setX(x);
				net.setY(y);

			}

			public void mouseEntered(MouseEvent e) {
				net.setShow(true);// Show显示
			}

			public void mouseExited(MouseEvent e) {
				net.setShow(false);
			}
		};
		this.addMouseListener(l);
		this.addMouseMotionListener(l);

		while (true) {
			repaint();// 观察鱼去哪里了！
			Thread.sleep(1000 / 24);
		}
	}

	protected void catchFish() {
//		for (Fish fish : all) {
		for(int i=all.length-1;i>=0;i--) {
			Fish fish = all[i];
			if (fish.catchBy(net)) {
				fish.getOut();
				break;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame("捞鱼");
		frame.setSize(800, 520);
		frame.setLocationRelativeTo(null);
		Pool pool = new Pool();
		frame.add(pool);
		frame.setVisible(true);
		pool.action();
	}
}
