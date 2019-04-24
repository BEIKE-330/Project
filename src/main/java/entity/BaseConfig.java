package entity;

public interface BaseConfig {
	
	//判断邮箱格式的正则表达式
	public static final String REGX="\\w+@\\w+(\\.[a-zA-Z]+)+";
	// 请求成功
	int SUCCESSCODE = 1;
	String SUCCESSMSG = "请求成功";
	// 请求失败
	int ERRRORCODE = -1;
	String ERRRORMSG = "请求失败";
	String ERRRORMSG1 = "两次密码不同";
	String ERRRORMSG2 = "邮箱格式错误";
	String ERRRORMSG3 = "用户名或密码已被注册";
	String ERRRORMSG4 = "用户名与邮箱验证错误";
}