package com.vs.demo.s2sbi;

import com.vs.demo.s2sbi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

@Slf4j
@SpringBootApplication
public class Application extends SpringBootServletInitializer implements ApplicationRunner {

    private final Environment env;

    private final UserService userService;

    public Application(Environment env, UserService userService) {
        this.env = env;
        this.userService = userService;
    }

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(Application.class);
        Environment env = app.run(args).getEnvironment();
        String protocol = "http";
        if (Objects.nonNull(env.getProperty("server.ssl.enabled")) && env.getProperty("server.ssl.enabled").equalsIgnoreCase("true")
                || Objects.isNull(env.getProperty("server.ssl.enabled")) && env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        String port = env.getProperty("server.port") != null ? "" + env.getProperty("server.port") : "" +  env.getProperty("local.server.port");
        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\t{}://localhost:{}\n\t" +
                        "External: \t{}://{}:{}\n\t" +
                        "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol,
                port,
                protocol,
                InetAddress.getLocalHost().getHostAddress(),
                port,
                env.getActiveProfiles());
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userService.populateUsers();
    }
}
