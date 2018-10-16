package org.zerock.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zerock.service.FortuneService;

import lombok.Setter;

@Component //�������� ���� �Ǳ� ���� ��
@Setter
public class FortuneUI {
	
	private Scanner scanner = new Scanner(System.in);
	@Autowired
	private FortuneService service;
	
	public void start() {
		System.out.println("������ �غ� �ϰ� ����");
		scanner.nextLine();//���� �ν�
		String result = service.getResult();//��� ��������
		System.out.println(result);
	}
	

}
