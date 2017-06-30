package com.loogear.test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 多线程API
 * volatile
 * join（）
 * interrupte()
 * synchronized
 * @author loogear
 *
 */
public class ThredTest2 {
	public static void main(String[] args) {
		try {
			Thread1 tt = new Thread1();
			tt.start();
			Thread.sleep(2000);
			tt.interrupt();
			//tt.join();
			System.out.println("end");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("B异常运行了。。。");
			e.printStackTrace();
		}
		
	}

}
class Thread1 extends Thread{
	public void run(){
		super.run();
		try{
			for (int i=0;i<500000;i++){
				if (this.interrupted()){
					System.out.println("中断了。。。");
					throw new InterruptedException();
				}
				System.out.println("i="+(i+1));
			}
			System.out.println("for下面");
			
			
		}catch(InterruptedException e){
			System.out.println("抛出异常了");
			e.printStackTrace();
		}
	}
}

class Test {
	public void test(){
		Map<String, String> map = new HashMap<String, String>(16, 0.75F);//初始容量16，加载因子0.75
		Map<String, String> map2 = new HashMap<String, String>();//初始容量16，加载因子0.75
		Map<String, String> map1 = new Hashtable<String,String>();
		String str = "123";
		String set = "123";
		System.out.println(str.equals(123));
		Map<Object,Object> map3 = new ConcurrentHashMap<Object, Object>();
		
	}
}
