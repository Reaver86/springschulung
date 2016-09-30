package io.crowdcode.speedbay.auction.config;

import io.crowdcode.speedbay.auction.repository.jdbc.ApplicationLogRepositoryBean;
import io.crowdcode.speedbay.auction.service.ApplicationLogServiceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by SU00079 on 30.09.2016.
 */
@Configuration
@Import({DatabasePopulateConfiguration.class})
public class ApplicationLogConfiguration {
    @Bean
    public ApplicationLogRepositoryBean applicationLogRepositoryBean() {
        return new ApplicationLogRepositoryBean();
    }

    @Bean
    public ApplicationLogServiceBean applicationLogServiceBean() {
        return new ApplicationLogServiceBean();
    }
}
