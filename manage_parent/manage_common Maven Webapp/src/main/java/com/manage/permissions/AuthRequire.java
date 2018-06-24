package com.manage.permissions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;

import com.manage.ehcache.EhCache;
import com.manage.exceptions.UserNoLoginException;
import com.manage.model.Admin;
import com.manage.statics.SysConst;
import com.manage.utils.ValidateUtil;


public class AuthRequire {
	
	/**
	 * 权限验证
	 * @param req
	 * @param handler
	 * @return
	 */
	public static boolean validate(HttpServletRequest req,Object handler) throws PermissionException,UserNoLoginException{
		AuthValidate vali = ((HandlerMethod)handler).getMethodAnnotation(AuthValidate.class);
		if(vali == null){
			return true;
		}
		String permission = vali.value();
		Object attribute = req.getSession().getAttribute(SysConst.USER);
		Object object = null;
		if(attribute != null){
			object = EhCache.get(EhCache.permiss, ((Admin) attribute).getId());
			if(object == null){
				throw new UserNoLoginException("User is not login");
			}
		}else{
			throw new UserNoLoginException("User is not login");
		}
		
		
		if(AuthCode.Null.getPermission().equals(permission)){
			return true;
		}
		
		Auth auth = (Auth) object;
		if(!ValidateUtil.validateBlank(auth.getPermission())){
			if((AuthCode.Allow.getPermission() + ";").equals(auth.getPermission())){
				return true;
			}
			if((permission + ";").indexOf(auth.getPermission()) != -1){
				return true;
			}
		}
		throw new PermissionException("ERROR Permission denied");
	}
	
	public static void logout(HttpSession session){
		Object attribute = session.getAttribute(SysConst.USER);
		if(attribute != null){
			EhCache.del(EhCache.permiss, ((Admin) attribute).getId());
		}
		session.setAttribute(SysConst.USER, null);
	}
	
}
