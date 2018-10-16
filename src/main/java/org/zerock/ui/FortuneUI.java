package org.zerock.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zerock.service.FortuneService;

import lombok.Setter;

@Component //스프링의 빈이 되기 위한 것
@Setter
public class FortuneUI {
	
	private Scanner scanner = new Scanner(System.in);
	@Autowired
	private FortuneService service;
	
	public void start() {
		System.out.println("마음의 준비를 하고 엔터");
		scanner.nextLine();//엔터 인식
		String result = service.getResult();//결과 가져오기
		System.out.println(result);
	}
	

}
