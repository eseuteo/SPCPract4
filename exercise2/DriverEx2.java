package exercise2;

public class DriverEx2 {
	public static void main(String[] args) {
		ThreadEx2.sharedVariable = new SharedVariable(0);
		ThreadEx2.count = 100000;
		new ThreadEx2().start();
		new ThreadEx2().start();
		
		while (ThreadEx2.turn < 2)
			Thread.yield();
		
		System.out.println(ThreadEx2.sharedVariable.getV());
	}
}
