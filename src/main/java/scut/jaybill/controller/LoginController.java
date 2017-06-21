package scut.jaybill.controller;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 登录控制器
 * @author jaybill
 * @date 2017年6月20日
 */
@Controller
public class LoginController {
	
	/**
	 * 将所有没有认证的请求，重定向到login.html页面
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	/**
	 * 正式登陆。
	 * 由SecurityUtils调用ShiroRealm的方法
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/doLogin",method=RequestMethod.POST)
	public String doLogin(String username,String password){
		UsernamePasswordToken token = new UsernamePasswordToken();
		token.setUsername(username);
		token.setPassword(password.toCharArray());
		try{
			SecurityUtils.getSubject().login(token);
			return "index";
		}catch(AuthenticationException e){
			return "login";
		}
	}
}
