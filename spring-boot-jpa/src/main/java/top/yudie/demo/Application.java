package top.yudie.demo;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application  extends SpringBootServletInitializer {
	@RequestMapping("/")
    String home() {
        return "Hello Denza!";
    }
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
	        return application.sources(Application.class);
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {  
	    super.onStartup(servletContext);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
