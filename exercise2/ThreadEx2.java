package exercise2;

public class ThreadEx2 extends Thread{
	public static SharedVariable sharedVariable;
	public static int turn = 0;
	public static int count;
	
	public ThreadEx2(){
	}
	
	public void run(){
		for (int i=0; i<count; i++)
			sharedVariable.setV(sharedVariable.getV()+1);
		turn++;
	}
}
