package io.crowdcode.speedbay.auction.config;

import io.crowdcode.speedbay.auction.model.Message;
import io.crowdcode.speedbay.auction.service.ApplicationLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Created by SU00079 on 30.09.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationLogConfiguration.class, JdbcTransactionConfiguration.class})
public class ApplicationLogConfigurationTest {
    @Autowired
    private ApplicationLogService appLogService;

    @Test
    // SQL Statements vor dem Test laufen lassen
    @Sql(statements = "DELETE FROM Application_Log")
    public void testApplicationLogging() throws Exception {
        appLogService.log("JUNIT TEST %s", "LOG");
        List<Message> messages = appLogService
                .lastLogs(Duration.of(5, ChronoUnit.SECONDS));
        messages.forEach(System.out::println);
        assertThat(messages, contains(hasProperty("message", is("JUNIT TEST LOG"))));
    }
}