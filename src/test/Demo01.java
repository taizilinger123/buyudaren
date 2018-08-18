package test;
/**
 *接口演示
 *子类中对于重写父类抽象方法称为：实现抽象方法
 */
public class Demo01 {
	public static void main(String[] args) {
      Cat cat = new Cat();
      //Hunter hh = new Hunter();//编译错误
      Hunter h = cat;
      Runner r = cat;
      h.hunt();
      //r.hunt();//编译错误，Runner类型上没有定义hunt()方法
	}
}//maxSpeed最大速度
interface Runner{//可以跑的
	/*public static final*/ int DEFAULT_SPEED = 100;//常量
	/*public abstract */int maxSpeed();//抽象方法
}
interface Hunter extends Runner{//猎手
	void hunt();
}//implements 实现，就是继承
class Cat implements Hunter,Runner{
	public void hunt() {
		System.out.println("打猎，快跑"+maxSpeed());
	}
	public int maxSpeed() {		
		return DEFAULT_SPEED;//继承于Runner
	}
}
//如下代表俄罗斯方块的概要功能设计
interface  Tetris{
	void softDropAction();
	void hardDropAction();
	void moveLeftAction();
	void moveRightAction();
	void rotateRightAction();
	void startAction();
	void pauseAction();
	void continueAction();
	void gameOverAction();	
}











