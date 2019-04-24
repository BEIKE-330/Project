package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.User;
import mapper.IUserMapper;

@Service
public class UserService {
	// 此处变量是接口类型，不加@Autowired private
	IUserMapper iUserMapper;

	@Autowired
	public UserService(IUserMapper iUserMapper) {
		this.iUserMapper = iUserMapper;
	}

	
	public boolean register(User user) {
		try
		{
		int cnt = iUserMapper.addUser(user);
		if (cnt != 0)
			return true;
		else {
			return false;
		}
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public User login(User user) {
		User u = iUserMapper.findUser(user);
		if (u != null)
			return u;
		else {
			return null;
		}
	}
	
	public User findUser2(User user) {
		User u = iUserMapper.findUser2(user);
		if (u != null)
			return u;
		else {
			return null;
		}
	}

	public boolean findUser(User user) {
		User u = iUserMapper.findUser(user);
		if (u != null)
			return true;
		else {
			return false;
		}
	}
	
	public boolean findUser1(User user) {
		User u = iUserMapper.findUser1(user);
		if (u != null)
			return true;
		else {
			return false;
		}
	}
}
