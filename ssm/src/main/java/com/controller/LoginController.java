package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	@ResponseBody
	public String login(){
		System.out.println(getIp());
		test();
		return "welcome";
	}
	
	@Autowired
	private  HttpServletRequest request;
	public String getIp(){
		String ip = request.getHeader("X-Forwarded-For");
		if(ip != null && !"unKnown".equalsIgnoreCase(ip)){
		  //多次反向代理后会有多个ip值，第一个ip才是真实ip
	        int index = ip.indexOf(",");
	        if(index != -1){
	            return ip.substring(0,index);
	        }else{
	           return ip;
	        }
		}
		ip = request.getHeader("X-Real-IP");
		if(ip != null && !"unKnown".equalsIgnoreCase(ip)){
			return ip;
		}
		 return request.getRemoteAddr();
	}
	
	public void test(){
        String str6 = "b";  
        String str7 = "a" + str6;  
        String str67 = "ab";  
        System.out.println("str7 = str67 : "+ (str7 == str67));  
        //↑str6为变量，在运行期才会被解析。  
        final String str8 = "b";  
        String str9 = "a" + str8;  
        String str89 = "ab";  
        System.out.println("str9 = str89 : "+ (str9 == str89)); 
	}
}
