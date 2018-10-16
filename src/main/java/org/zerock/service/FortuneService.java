package org.zerock.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource; //꼭 이걸로 등록하기

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service //스프링의 빈이 되기 위한 것 . 비지니스 쪽
@AllArgsConstructor
public class FortuneService {

	//의존성 주입
	@Setter(onMethod_= {@Autowired}) //세번째 방법
	private DataSource ds; //디비 연결 
	
//	@Autowired //두번째 방법
//	public void setDs(DataSource ds) {
//		this.ds = ds;
//	} //alt shift s 
	

	//결과 얘기해주기
	public String getResult(){
//		return "hello";
		
		//디비 연결
		String result = null;
		
		try(Connection con = ds.getConnection();){
			PreparedStatement pstmt = con.prepareStatement("select now()");
			ResultSet rs = pstmt.executeQuery();
			{
				rs.next();
				result=rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
