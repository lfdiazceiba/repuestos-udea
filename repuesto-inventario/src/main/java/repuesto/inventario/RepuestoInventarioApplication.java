package repuesto.inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RepuestoInventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepuestoInventarioApplication.class, args);
	}
}
