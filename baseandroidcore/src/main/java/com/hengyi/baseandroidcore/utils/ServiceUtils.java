package com.hengyi.baseandroidcore.utils;

import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;

public class ServiceUtils {
	/** 
	 * 判断某个服务是否正在运行的方法 
	 *  
	 * @param mContext 
	 * @param serviceName 
	 *            是包名+服务的类名（例如：net.loonggg.testbackstage.TestService） 
	 * @return true代表正在运行，false代表服务没有正在运行 
	 */  
	public static boolean isServiceWork(Context mContext, String serviceName) {  
	    boolean isWork = false;  
	    ActivityManager myAM = (ActivityManager) mContext  
	            .getSystemService(Context.ACTIVITY_SERVICE);  
	    List<RunningServiceInfo> myList = myAM.getRunningServices(80);  
	    if (myList.size() <= 0) {  
	        return false;  
	    }  
	    for (int i = 0; i < myList.size(); i++) {  
	        String mName = myList.get(i).service.getClassName().toString(); 
	        if (mName.equals(serviceName)) {  
	            isWork = true;  
	            break;  
	        }  
	    }  
	    return isWork;  
	}

	//启动服务
	public static void StartService(Context mContext,Class cla){
		Intent intent = null;
		intent = new Intent(mContext,cla);
		mContext.startService(intent);
	}

	public static void StartService(Context mContext,Class cla,String[] names, Object... param){
		Intent intent = null;
		intent = new Intent(mContext,cla);
		for (int i = 0; i < param.length; i++) {
			if (param[i].getClass().equals(Integer.class)) {
				intent.putExtra(names[i], (Integer) param[i]);
			} else if (param[i].getClass().equals(String.class)) {
				intent.putExtra(names[i], (String) param[i]);
			} else if (param[i].getClass().equals(Boolean.class)) {
				intent.putExtra(names[i], (Boolean) param[i]);
			} else if (param[i].getClass().equals(Float.class)) {
				intent.putExtra(names[i], (Float) param[i]);
			} else if (param[i].getClass().equals(Double.class)) {
				intent.putExtra(names[i], (Double) param[i]);
			}
		}
		mContext.startService(intent);
	}

	public static void CloseService(Context mContext,Class cla){
		Intent intent = null;
		intent = new Intent(mContext,cla);
		mContext.stopService(intent);
	}
	
}
