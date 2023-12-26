package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {

	private final UserMapper mapper;
	
	//全件取得
	public List<User> selectAll(){
		return mapper.selectAll();
	}
	
	//更新
	public void save(User user) {
		if(user.getId() == null) {
			mapper.insert(user);
		}else {
			mapper.updateByPrimaryKey(user);
		}
	}
	
	//削除
	public void deleteByPrimaryKey(Long id) {
		mapper.deleteByPrimaryKey(id);
	}
}