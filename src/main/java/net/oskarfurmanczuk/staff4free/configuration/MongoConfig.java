package net.oskarfurmanczuk.staff4free.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@Configuration
@EnableMongoAuditing
public class MongoConfig {
	
	@Bean
    public AuditorAware<String> auditorAware(){
        return new EntityAuditing();
    }
}
