package scut.jaybill.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Shiro服务类
 * @author jaybill
 * @date 2017年6月20日
 */
public class ShiroRealm extends AuthorizingRealm {

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
	        AuthenticationToken token) throws AuthenticationException {
	    System.out.println("身份认证方法：MyShiroRealm.doGetAuthenticationInfo()");
	    return new SimpleAuthenticationInfo("账号","123456", getName());
	}
	
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		return null;
	}
}

