package kr.kimyonghwan.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.kimyonghwan.config.ApplicationConfig;
import kr.kimyonghwan.dao.RoleDao;
import kr.kimyonghwan.dto.Role;

public class JDBCTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		RoleDao roleDao = ac.getBean(RoleDao.class);
		
		Role role = new Role();
		role.setOrder_NO(1);
		role.setNATION_ID("KOR");
		role.setNATION_NAME("한국짱");
		
		int count = roleDao.insert(role);
		System.out.println(count + "건 입력하였습니다.");	
		int count2 = roleDao.update(role);
		System.out.println(count + "건 수정하였습니다.");
		
		Role resultRole = roleDao.selectById(2);
		System.out.println(resultRole);
		
		int deleteCount = roleDao.deleteById(6);
		System.out.println(deleteCount+ "건 삭제하였습니다.");
		
		Role resultRole2 = roleDao.selectById(6);
		System.out.println(resultRole2);
		
	}

}
