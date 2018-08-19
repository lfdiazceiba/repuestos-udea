package repuesto.repuestoapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class RepuestoApigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepuestoApigatewayApplication.class, args);
	}
}
