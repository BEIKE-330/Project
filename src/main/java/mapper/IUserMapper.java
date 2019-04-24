package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.User;

@Repository
public interface IUserMapper {
	@Insert("insert into users(email,username,password,facefeature) values(#{email},#{username},#{password},#{facefeature})")
	public int addUser(User user);

	@Delete("delete from users where username=#{username}")
	public int deleteUser(String username);

	@Select("select * from users where email=#{email}and username=#{username}")
	public User findUser1(User user);

	@Select("select * from users where username=#{username} and password=#{password} ")
	public User findUser(User user);
	
	@Select("select * from users where email=#{email}and username=#{username} ")
	public User findUser2(User user);

	@Select("select * from users")
	public List<User> getAllUsers();
}