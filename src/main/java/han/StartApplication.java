package han;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@ComponentScan(basePackages={"han.redisdemo"})
@RestController
public class StartApplication {


	public static void main(String[] args) {
		SpringApplication sApp= new SpringApplication(StartApplication.class);
		sApp.run(args);
	}
}
