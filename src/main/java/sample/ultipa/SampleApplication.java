package sample.ultipa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.ultipa.repository.config.EnableUltipaRepositories;

/**
 * @author Wangwang Tang
 * @since 1.0
 */
@EnableUltipaRepositories
@SpringBootApplication
public class SampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }

}
