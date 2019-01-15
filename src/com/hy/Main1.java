package com.hy;

/**
 * volatite 保证可见性，不保证原子性
 * @author Pactera
 *
 */
public class Main1 {
	private volatile static int i = 0;
	public static void main(String[] args) throws InterruptedException {
	   new Thread(()->
	     {
	         while(i < 3){
	         }
		     System.out.println("ThreadA end ");
	     }
	   ).start();
	   
	   Thread.sleep(2000);
	   new Thread(new Runnable() {
		@Override
		public void run() {
			i = 3;
            System.out.println("ThreadB end");
		}
	}).start();
		

	}

}
