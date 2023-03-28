package main;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.MemberDto;

public class MainClass {

	public static void main(String[] args) throws Exception {
		
		// 설정파일 read
		InputStream is = Resources.getResourceAsStream("mybatis/config.xml");
		
		// SqlSessionFactory 객체를 생성
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		// SqlSession 객체를 취득
		SqlSession session = factory.openSession(); 
		
		// insert
		/*
		MemberDto dto = new MemberDto("def", "345", "이승철", "def@naver.com", 0);
		
		int count = session.insert("addmember", dto);
		if(count > 0) {
			session.commit();
			System.out.println("추가성공!");
		}else {
			session.rollback();
			System.out.println("추가실패");
		}
		*/
		
		// select (1개의 데이터)
		/*
		String id = "abc";
		MemberDto dto = session.selectOne("getMember", id);
	//	System.out.println(dto.toString());
		
		
		// select (다수의 데이터)
		List<MemberDto> list = session.selectList("allMember");
		for (MemberDto m : list) {
			System.out.println(m.toString());
		}
		*/
		
		// delete		
		String id = "cde";
		int count = session.delete("deleteMember", id);
		if(count > 0) {
			session.commit();
			System.out.println("정상적으로 삭제되었습니다");
		}else {
			session.rollback();
			System.out.println("정상적으로 삭제되지 않았습니다");
		}		
				
		// update
		/*
		MemberDto dto = new MemberDto("def", null, "김지수", "def@hotmail.com", 0);
		int count = session.update("updateMember", dto);
		if(count > 0) {
			session.commit();
			System.out.println("정상적으로 수정되었습니다");
		}else {
			session.rollback();
			System.out.println("정상적으로 수정되지 않았습니다");
		}
		*/
		
		func( 2 );	// 2 : argument(실(제)인수)
	}
	
	public static void func(int i) { // i : parameter(가(상)인수)
		
	}

}








