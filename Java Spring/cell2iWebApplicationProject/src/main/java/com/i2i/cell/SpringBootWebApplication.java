package com.i2i.cell;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.i2i.cell.service.ServiceManager;

@SpringBootApplication
public class SpringBootWebApplication implements CommandLineRunner{

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootWebApplication.class, args);	
	}
	public void run(String... args) throws Exception {
    	// TODO Auto-generated method stub
    		String a =ServiceManager.test("5446787655","0000");
    		System.out.println(a + "asdasdgsdfasfgesdgsaf");
	}
}

/*
 * jboss tools spring tools
 * 
 * 
 */