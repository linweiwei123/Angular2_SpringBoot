package com.sonicwall;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
//Manually Added
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.sonicwall.model.security.User;
import com.sonicwall.model.security.Role;
import com.sonicwall.repo.UserRepository;
import com.sonicwall.repo.msw.NotificationPreferenceRepo;
import com.sonicwall.SeedData;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "com.sonicwall")
@EnableJpaRepositories(basePackages ={ "com.sonicwall.repo"})
@EntityScan(basePackages ={ "com.sonicwall.model"})
public class EmailSecurityApp implements CommandLineRunner {

	@Override
	public void run(String... arg0) throws Exception {
		if (arg0.length > 0 && arg0[0].equals("exitcode")) {
			throw new ExitException();
		}
	}

	public static void main(String[] args) throws Exception {
		new SpringApplication(EmailSecurityApp.class).run(args);
	}

	class ExitException extends RuntimeException implements ExitCodeGenerator {
		private static final long serialVersionUID = 1L;

		@Override
		public int getExitCode() {
			return 10;
		}
	}
		
	@Bean
    public InitializingBean insertDefaultUsers() {
		return new InitializingBean() {
			@Autowired
			private UserRepository userRepository;
			@Autowired
			private NotificationPreferenceRepo notificationPreferenceRepo;
			
			public void afterPropertiesSet() throws Exception {
				SeedData sd = new SeedData();
				System.out.println("\n------------------------------------");
				System.out.println("[ *** Mrin *** ]: Initializing data\n");
				sd.insertDefaultUsers(userRepository);
				sd.insertNotificationPref(notificationPreferenceRepo);
				System.out.println("\n------------------------------------");
			}
		};
    }
	
}



