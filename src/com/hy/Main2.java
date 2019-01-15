package com.hy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * volatite 保证可见性，不保证原子性
 * @author Pactera
 *
 */
public class Main2 {
	private static volatile  int x = 0;
	
	public static void main(String[] args) throws InterruptedException {
	   ExecutorService executors = Executors.newCachedThreadPool();
	   for (int i = 0; i < 5; i++) {
		   executors.submit(() -> {
			   for (int j = 0; j < 1000; j++) {
				    x++;
				    
			  }
		   });
     	}
	   executors.shutdown();
	   TimeUnit.SECONDS.sleep(2);
	   System.out.println(x);
     }

}
