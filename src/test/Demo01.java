package test;
/**
 *�ӿ���ʾ
 *�����ж�����д������󷽷���Ϊ��ʵ�ֳ��󷽷�
 */
public class Demo01 {
	public static void main(String[] args) {
      Cat cat = new Cat();
      //Hunter hh = new Hunter();//�������
      Hunter h = cat;
      Runner r = cat;
      h.hunt();
      //r.hunt();//�������Runner������û�ж���hunt()����
	}
}//maxSpeed����ٶ�
interface Runner{//�����ܵ�
	/*public static final*/ int DEFAULT_SPEED = 100;//����
	/*public abstract */int maxSpeed();//���󷽷�
}
interface Hunter extends Runner{//����
	void hunt();
}//implements ʵ�֣����Ǽ̳�
class Cat implements Hunter,Runner{
	public void hunt() {
		System.out.println("���ԣ�����"+maxSpeed());
	}
	public int maxSpeed() {		
		return DEFAULT_SPEED;//�̳���Runner
	}
}
//���´������˹����ĸ�Ҫ�������
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











