package sg.nus.iss.visa.ssf.workshop11;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.SpringNamingPolicy;

@SpringBootApplication
public class Workshop11Application {

	public static final Logger logger = LoggerFactory.getLogger(Workshop11Application.class);

	public static final String DEFAULT_PORT = "3000";

	public static void main(String[] args) {

		logger.info("main method started....");
		// Initialize spring app

		SpringApplication app = new SpringApplication(Workshop11Application.class);

		// read args array and check for "port" parameter
		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);

		List opsValue = appArgs.getOptionValues("port");

		String portNumber = null;

		if (opsValue == null || opsValue.get(0) == null) {

			portNumber = System.getenv("PORT");

			if (portNumber == null) {

				portNumber = DEFAULT_PORT;

			}
		} else {

			// pass port number from CLI
			portNumber = opsValue.get(0).toString();
		}

		if (portNumber != null) {

			// set port number in the spring boot config
			app.setDefaultProperties(Collections.singletonMap("server.port", portNumber));
		}

		logger.info("Port number is : " + portNumber);

		app.run(args);

		
	}

	
}
