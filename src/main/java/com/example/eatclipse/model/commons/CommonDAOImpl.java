package com.example.eatclipse.model.commons;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDAOImpl implements CommonsDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public int login(CommonsDTO dto) {
		return sqlSession.selectOne("commons.login", dto);
	}

	@Override
	public void insert(CommonsDTO dto) {
		sqlSession.insert("commons.insert", dto);

	}

	@Override
	public String search_id(CommonsDTO dto) { // 아이디가 겹치는지 확인
		return sqlSession.selectOne("commons.search_id", dto);
	}

	@Override
	public Object view(int no) {
		return sqlSession.selectOne("commons.view", no);
	}

	@Override
	public void update(CommonsDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String userid) {
		// TODO Auto-generated method stub

	}

}
