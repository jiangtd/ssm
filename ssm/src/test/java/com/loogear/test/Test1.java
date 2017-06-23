package com.loogear.test;

import java.net.InetAddress;

public class Test1 {
	public static void main(String[] args) {
/*	    InetAddress ia=null;
	    StringBuffer str1 = new StringBuffer();
	    StringBuilder str2 = new StringBuilder();
	    try {
	        ia=ia.getLocalHost();
	         
	        String localname=ia.getHostName();
	        String localip=ia.getHostAddress();
	        System.out.println("本机名称是："+ localname);
	        System.out.println("本机的ip是 ："+localip);
	    } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }*/
		Test1 tt = new Test1();
		System.out.println(tt.test2());
	}
	
	public int test2(){
		try{
			System.out.println("try");
			return 123;
		}catch(Exception e){
			System.out.println("exception");
			return 456;
		}finally {
			System.out.println("finally");
			return 789;
		}
	}

}
