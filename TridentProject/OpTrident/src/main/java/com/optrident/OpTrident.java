package com.optrident;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OpTrident {
	
	private static final Logger log = LoggerFactory.getLogger(OpTrident.class);
	
//	@Autowired
//    private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(OpTrident.class, args);
		log.info("Spring Boot App Started");
	}

}
