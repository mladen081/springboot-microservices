package u.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@EnableFeignClients
@SpringBootApplication
@EnableEurekaClient // 3 no
public class EmployeeServiceApplication {

//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}

//	@Bean
//	public WebClient webClient() {
//		return WebClient.builder().build();
//	}



	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}

// java -jar -Dserver.port=8083 employee-service-0.0.1-SNAPSHOT.jar
// http://localhost:9191/api/employees/6
