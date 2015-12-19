package com.demo.serviceimpl;

import java.util.List;

public class CommonUtil {

	
	//int a = 18;//二进制10010
	// s=IsOne(a,2);//判断第二位是否为1
	

	public static boolean IsOne(int b,int pos)
	{
	 return (b>>(pos-1) & 0x01)==1;
	}
	
	//取得总权限
	public static int getTotalAuth(List<Integer> authorities){
		int authority = 0;
		for(Integer author: authorities){
			authority |= author;
		}
		
		return authority;
	}
}
