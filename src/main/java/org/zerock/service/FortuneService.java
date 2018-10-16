package org.zerock.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource; //�� �̰ɷ� ����ϱ�

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service //�������� ���� �Ǳ� ���� �� . �����Ͻ� ��
@AllArgsConstructor
public class FortuneService {

	//������ ����
	@Setter(onMethod_= {@Autowired}) //����° ���
	private DataSource ds; //��� ���� 
	
//	@Autowired //�ι�° ���
//	public void setDs(DataSource ds) {
//		this.ds = ds;
//	} //alt shift s 
	

	//��� ������ֱ�
	public String getResult(){
//		return "hello";
		
		//��� ����
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
