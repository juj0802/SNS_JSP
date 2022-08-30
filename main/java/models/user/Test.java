package models.user;

import org.apache.ibatis.session.SqlSession;

import mybatis.Connection;

public class Test {
	public static void main(String[] args) {
		SqlSession sqlSession = Connection.getSession();

		UserInfoDto member = new UserInfoDto();
		member.setId("user3");
		member.setPassword("123456223");
		member.setName("사용자1");
	
		member.setPhone("01010001000");
		

		int affectedRows = sqlSession.insert("MemberMapper.register", member);
		System.out.println("반영된 레코드 수 : " + affectedRows);
		System.out.println(member);
		sqlSession.commit();
		sqlSession.close();
		
		/**
		List<MemberDto> members = sqlSession.selectList("MemberMapper.members");
		System.out.println(members);
		*/
		/**
		MemberDto param = new MemberDto();
		param.setMemId("user1");
		param.setMemNm("(수정)사용자1");
		param.setEmail("수정)이메일");
		param.setMobile("01011111111");
	
		int affectedRows = sqlSession.update("MemberMapper.update", param);
		System.out.println(affectedRows);
		
		param = new MemberDto();
		param.setMemId("user1");
		
		MemberDto member = sqlSession.selectOne("MemberMapper.member", param);
		System.out.println(member);		
		*/
		/**
		MemberDto param = new MemberDto();
		param.setMemId("user1");
		int affectedRows = sqlSession.delete("MemberMapper.delete", param);
		System.out.println(affectedRows);
		
		List<MemberDto> members = sqlSession.selectList("MemberMapper.members");
		System.out.println(members);
		
		sqlSession.commit();
		*/
		
		//int count = sqlSession.selectOne("MemberMapper.count");
		//System.out.println(count);
		//sqlSession.close();
	}
}
