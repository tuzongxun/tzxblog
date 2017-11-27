package com.tzx.blog.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import com.tzx.blog.common.TzxData;

/**
 * request监听器，用来加访问量
 * 
 * @author tzx
 *
 */
@WebListener
public class TzxRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub

	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		String url = ((HttpServletRequest) sre.getServletRequest()).getRequestURL().toString();
		if (!url.contains(".")) {
			// 每一个新的request，访问量+1
			TzxData.readCounts += 1;
		}
	}

}
