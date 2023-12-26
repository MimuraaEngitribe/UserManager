package com.example.demo;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
	
	//全件取得
	@Select("SELECT * FROM user")
	List<User> selectAll();
	
	//登録
	@Insert({
		"INSERT INTO user(user_name, email)",
		"VALUES(#{userName}, #{email})"
	})
	int insert(User record);
	
	
	//更新
	@Update({
		"UPDATE user",
		"SET user_name = #{userName}, email = #{email}",
		"WHERE id = #{id}"
	})
	int updateByPrimaryKey(User record);
	
	
	//削除
	@Delete({
		"DELETE FROM user",
		"WHERE id = #{id}"
	})
	int deleteByPrimaryKey(Long id);
}