package com.example.ottodemo;

import android.os.Handler;
import android.os.Looper;

import com.squareup.otto.Bus;

public class BusProvider extends Bus{
	
	/**
	 * 通过单例模式返回唯一的bus对象,而且重写父类的post方法,通过handler实现任意线程可以调用
	 */
	private Handler mHandler = new Handler(Looper.getMainLooper());
	private static Bus bus = new BusProvider();
	
	private BusProvider(){
		
	}

	public static Bus getInstance(){
		
		return bus;
	}
	
	@Override
	public void post(final Object event) {
		if (Looper.myLooper() == Looper.getMainLooper()) {
			super.post(event);
		}else {
			mHandler.post(new Runnable() {
				@Override
				public void run() {
					BusProvider.super.post(event);
				}
			});
		}
	}
}
