package com.example.EcreditFormation;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class EcreditFormationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcreditFormationApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
//	  @Bean
//	    public DataSource dataSource() {
//	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//	        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
//	        dataSource.setUsername("formation");
//	        dataSource.setPassword("formation");
//	        return dataSource;
//	    }
//}
