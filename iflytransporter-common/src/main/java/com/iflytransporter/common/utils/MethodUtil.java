package com.iflytransporter.common.utils;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.time.DateFormatUtils;

public class MethodUtil {
	
	public static String generateCaptcha(){
		Random rad=new Random();  
        String result  = rad.nextInt(1000000) +"";  
        if(result.length()!=6){  
            return generateCaptcha();  
        }  
		return result;
	}
	public static String generateFourRand(){
		Random rad=new Random();  
        String result  = rad.nextInt(10000) +"";  
        if(result.length()!=2){  
            return generateFourRand();  
        }  
		return result;
	}
	/**
     * 生成订单编号
     * @param userId
     * @return orderNum
     */
    public final static String genOrderNum(String userId) {
    	DecimalFormat dft = new DecimalFormat("00");
    	Date date = new Date();
        String dateStr = DateFormatUtils.format(date, "yyMMddHH");
        
        Integer hashCode=  userId.hashCode();
        Integer userIdMod = hashCode % 100;
        if(userIdMod<0){
        	userIdMod = Math.abs(userIdMod);
        }
        String userIdModFormat = dft.format(userIdMod);
        System.out.println(userIdModFormat+":"+generateFourRand());
        String orderNum = dateStr + userIdModFormat + generateFourRand();
        // System.out.println(orderNum + " , " + orderNum.length());
        //log.info("userId,orderNum:" + userId + "," + orderNum);
        return orderNum;
    }
    public static void main(String[] args){
    	hash();
    }
    public static void hash(){
    	int is9 =0;
    	int no9 =0;
    	for(int i =0;i<1000;i++){
    		String uuid = UUIDUtil.UUID();
//    		genOrderNum(uuid);
    		System.out.println(genOrderNum(uuid));
    	}
    	System.out.println(is9);
    	System.out.println(no9);
    }
}
