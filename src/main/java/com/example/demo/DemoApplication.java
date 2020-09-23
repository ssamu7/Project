package com.example.demo;

import com.example.demo.nativeinterface.test.HelloSpring;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @: 스프링어노테이션
// @SpringBookApplication 스프링의 메인어플리케이션이 되는 애들은 무조건 쓰고 시작. 스프링프레임워크를 연동 (m, v, c 전부 연동)해서 작동할 준비를 마침.
// view는 일반적으로 resources-templates에 작성.
// controller는 java-com.example.demo-controller에 모아둠.
@SpringBootApplication
public class DemoApplication {
	final static Logger log = LoggerFactory.getLogger(DemoApplication.class);
	// SpringApplication.run 하면 웹서버가 구동된다 - 서비스 번호: 8080
	public static void main(String[] args) {
		// 파이썬에선 hs = HelloSpring
		HelloSpring hs = new HelloSpring();
		log.info(hs.print());
		SpringApplication.run(DemoApplication.class, args);
	}

}
