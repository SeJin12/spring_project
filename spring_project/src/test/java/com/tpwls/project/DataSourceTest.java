package com.tpwls.project;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DataSourceTest {

	@Inject
	private DataSource ds;
	
	@Test
	public void test() throws Exception {
		System.out.println("asd");
		try(Connection con = ds.getConnection()){
			System.out.println(con);
			System.out.println("접속 완료");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}


