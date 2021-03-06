package co.bada.prj.comm;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {
	private static SqlSessionFactory sqlSessionFactory; //Mybatis를 사용하기 위해서 sqlsessionfactory를 이용한 것
	private DataSource() {}  //외부에서 생성하지 못 하도록 초기화. 
	
	public static SqlSessionFactory getInstance() {	//DataBase 연결된다. connection pool 기반으로. 
		String resource = "mybatis-config.xml";
		try{ 
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return sqlSessionFactory;
	}
}
