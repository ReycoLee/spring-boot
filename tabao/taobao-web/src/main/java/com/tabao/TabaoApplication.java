package com.tabao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.tabao.bussiness.mapper")
public class TabaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TabaoApplication.class, args);
	}
}
