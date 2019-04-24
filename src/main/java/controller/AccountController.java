package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import entity.BaseConfig;
import entity.MsgBean;
import entity.User;
import service.UserService;

@Controller
@ResponseBody
@RequestMapping("/Account")
public class AccountController extends HttpServlet {
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "account/index";
	}

	@RequestMapping("/Login")
	@ResponseBody
	public MsgBean login(HttpServletRequest request,String username, String password) {
		List<User> list = new ArrayList<>();
		User user1 = new User();
		user1.setUsername(username);
		user1.setPassword(password);
		User u = userService.login(user1);
		MsgBean msgBean = new MsgBean();
		if (u != null) {
			list.add(u);
			msgBean.setCode(BaseConfig.SUCCESSCODE);
			msgBean.setMsg(BaseConfig.SUCCESSMSG);
			// msgBean.setData(user);
		} else {
			msgBean.setCode(BaseConfig.ERRRORCODE);
			msgBean.setMsg(BaseConfig.ERRRORMSG);
		}
		return msgBean;
	}

//	@GetMapping("/Register")
//	@ResponseBody
//	public MsgBean register(HttpServletRequest request,String email, String username, String password, String password1) {
//		MsgBean msgBean = new MsgBean();
//		if (password.equals(password1)) {//判断两次密码是否相同
//			if (email.matches(BaseConfig.REGX)) {//判断邮箱格式是否正确
//				User user = new User();
//				user.setEmail(email);
//				user.setUsername(username);
//				user.setPassword(password);
//				boolean flag = userService.register(user);
//				if (flag) {
//					msgBean.setCode(BaseConfig.SUCCESSCODE);
//					msgBean.setMsg(BaseConfig.SUCCESSMSG);
//					//msgBean.setData(user);
//				} else {
//					msgBean.setCode(BaseConfig.ERRRORCODE);
//					msgBean.setMsg(BaseConfig.ERRRORMSG3);
//				}
//			} else {
//				msgBean.setCode(BaseConfig.ERRRORCODE);
//				msgBean.setMsg(BaseConfig.ERRRORMSG2);
//			}
//			return msgBean;
//		} else {
//			msgBean.setCode(BaseConfig.ERRRORCODE);
//			msgBean.setMsg(BaseConfig.ERRRORMSG1);
//			return msgBean;
//		}
//
//	}
	
	@GetMapping("/Register")
	@ResponseBody
	public MsgBean register(HttpServletRequest request,String email, String username, String password, String password1,String feature) {
		MsgBean msgBean = new MsgBean();
		if (password.equals(password1)) {//判断两次密码是否相同
			if (email.matches(BaseConfig.REGX)) {//判断邮箱格式是否正确
				User user = new User();
				user.setEmail(email);
				user.setUsername(username);
				user.setPassword(password);
				byte[] facefeature=Base64.decodeBase64(feature);
				user.setFacefeature(facefeature);
				boolean flag = userService.register(user);
				if (flag) {
					msgBean.setCode(BaseConfig.SUCCESSCODE);
					msgBean.setMsg(BaseConfig.SUCCESSMSG);
					//msgBean.setData(user);
				} else {
					msgBean.setCode(BaseConfig.ERRRORCODE);
					msgBean.setMsg(BaseConfig.ERRRORMSG3);
				}
			} else {
				msgBean.setCode(BaseConfig.ERRRORCODE);
				msgBean.setMsg(BaseConfig.ERRRORMSG2);
			}
			return msgBean;
		} else {
			msgBean.setCode(BaseConfig.ERRRORCODE);
			msgBean.setMsg(BaseConfig.ERRRORMSG1);
			return msgBean;
		}

	}

	@RequestMapping("/Forget")
	@ResponseBody
	public MsgBean forget(HttpServletRequest request,String email, String username) {
		User user = new User();
		User u = new User();
		MsgBean msgBean = new MsgBean();
		user.setEmail(email);
		user.setUsername(username);
		boolean flag = userService.findUser1(user);
		u = userService.findUser2(user);
		if (flag) {
			msgBean.setCode(BaseConfig.SUCCESSCODE);
			msgBean.setMsg(BaseConfig.SUCCESSMSG);
			msgBean.setData(u);
		} else {
			msgBean.setCode(BaseConfig.ERRRORCODE);
			msgBean.setMsg(BaseConfig.ERRRORMSG4);
		}
		return msgBean;
	}


//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	@GetMapping("/Register")
//	@ResponseBody
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		InputStream in=request.getInputStream();
//		OutputStream out;
//		byte[] facefeature=in.readAllBytes();
//		MsgBean msgBean = new MsgBean();
//		String email=request.getParameter("email");
//		String username=request.getParameter("username");
//		String password=request.getParameter("password");
//		String password1=request.getParameter("password1");
//		MsgBean msgBean1 = new MsgBean();
//		if (password.equals(password1)) {//判断两次密码是否相同
//			if (email.matches(BaseConfig.REGX)) {//判断邮箱格式是否正确
//				User user = new User();
//				user.setEmail(email);
//				user.setUsername(username);
//				user.setPassword(password);
//				user.setFacefeature(facefeature);
//				boolean flag = userService.register(user);
//				if (flag) {
//					msgBean1.setCode(BaseConfig.SUCCESSCODE);
//					msgBean1.setMsg(BaseConfig.SUCCESSMSG);
//					//msgBean.setData(user);
//		
//				} else {
//					msgBean1.setCode(BaseConfig.ERRRORCODE);
//					msgBean1.setMsg(BaseConfig.ERRRORMSG3);
//				}
//			} else {
//				msgBean1.setCode(BaseConfig.ERRRORCODE);
//				msgBean1.setMsg(BaseConfig.ERRRORMSG2);
//			}
//			return msgBean1;
//		} else {
//			msgBean1.setCode(BaseConfig.ERRRORCODE);
//			msgBean1.setMsg(BaseConfig.ERRRORMSG1);
//			return msgBean1;
//		}
//
//	}
	
}
