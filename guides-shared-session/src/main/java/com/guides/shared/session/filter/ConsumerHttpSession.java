package com.guides.shared.session.filter;

import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import com.alibaba.fastjson.JSONObject;
import com.platform.boot.SpringContextUtil;

public class ConsumerHttpSession implements HttpSession {

	private final String SESSIONID = "sessionId";

	private final ThreadLocal<String> sessionIdLocal = new ThreadLocal<String>();

	private HttpServletRequest request;
	private HttpServletResponse response;

	public ConsumerHttpSession(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	@Override
	public long getCreationTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getLastAccessedTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMaxInactiveInterval(int interval) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getMaxInactiveInterval() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public HttpSessionContext getSessionContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getAttribute(String name) {

		String sessionId = getSessionIdFromCookie();
		if (sessionId == null) {
			sessionId = sessionIdLocal.get();
			if (sessionId == null) {
				return null;
			}
		}

		// 得到redisTemplate
		ApplicationContext context = SpringContextUtil.getApplication();
		RedisTemplate redisTemlate = context.getBean("redisTemplate", RedisTemplate.class);
		List<Object> list = redisTemlate.opsForList().range(sessionId, 0, -1);

		return getValueByKey(name, list);
	}

	private Object getValueByKey(String name, List<Object> list) {
		for (Object each : list) {
			JSONObject jo = JSONObject.parseObject(each.toString());
			if (jo.containsKey(name)) {
				return jo.get(name);
			}
		}
		return null;
	}

	@Override
	public Object getValue(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enumeration<String> getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getValueNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttribute(String name, Object value) {

		// 判断浏览器中是否带有sessionId
		String sessionId = getSessionIdFromCookie();

		// 判断服务器端是否生成了sessionId
		if (sessionId == null) {
			sessionId = sessionIdLocal.get();
			// 服务端没有生成cookie ， 则服务器端生成cookie 并写入浏览器
			if (sessionId == null) {
				sessionId = UUID.randomUUID().toString();
				sessionIdLocal.set(sessionId);
				Cookie cookie = new Cookie(SESSIONID, sessionId);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		}

		// 得到redisTemplate
		ApplicationContext context = SpringContextUtil.getApplication();
		RedisTemplate redisTemlate = context.getBean("redisTemplate", RedisTemplate.class);

		JSONObject jo = new JSONObject();
		jo.put(name, value);
		redisTemlate.opsForList().leftPush(sessionId, jo);

	}

	private String getSessionIdFromCookie() {
		Cookie[] cookies = request.getCookies();
		if(cookies == null) {
			return null;
		}
		for (Cookie cookie : cookies) {
			if (SESSIONID.equals(cookie.getName())) {
				return cookie.getValue();
			}
		}

		return null;
	}

	@Override
	public void putValue(String name, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAttribute(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeValue(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void invalidate() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}

}
