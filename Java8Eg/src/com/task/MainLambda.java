package com.task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainLambda {
	public static void main(String[] args) {
//		Task t = new Task();
//		t.connect();
		
//		Runnable run = new MyTaskThread();
//		Thread thread = new Thread(run);
//		thread.start();
		
		Runnable r = new Runnable() {
			public void run() {
				Task task = new Task();
				task.connect();
			}
		};
		Thread t1 = new Thread(r);
		t1.start();
		
//		JAVA 8
		Runnable re = () ->  {
				Task task = new Task();
				task.disconnect();
		};
		Thread t2 = new Thread(re);
		t2.start();
		
		Thread t3 = new Thread(()->{
			Task task = new Task();
			task.disconnect();
		});
		t3.start();
		
		new Thread(()->{
			new Task().disconnect();
		}).start();
		
		new Thread(new Task()::connect).start();
		
		 User u1 = new User(11,"Nilima","nilima@gmail.com");
		 User u2 = new User(12,"Praveen","prav@gmail.com");
		 User u3 = new User(13,"Aarika","arika@gmail.com");
		  
		 List<User> li = new ArrayList<User>();
		 li.add(u1);
		 li.add(u2);
		 li.add(u3);
		 	System.out.println("User List :" + li);
//		 li.forEach(System.out::println);
		 
		 Iterator<User> i = li.iterator(); while (i.hasNext()) {
			 System.out.println(i.next()); 
		 }
//		 li.forEach(lis->System.out.println(lis));
		 new OtherFI().biPredict();
		
		
	}
}
