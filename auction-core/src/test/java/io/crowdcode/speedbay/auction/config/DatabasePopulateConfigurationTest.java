package io.crowdcode.speedbay.auction.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabasePopulateConfiguration.class})
public class DatabasePopulateConfigurationTest {

    private static final String INSERT_ONE =
            "INSERT INTO Application_Log (id, message, createdAt, createdBy) " +
            "VALUES (nextVal('LogSequence'), :message, :createdAt, :createdBy)";
    private static final String SELECT_ONE = "SELECT message FROM Application_Log WHERE id=:id";
    private static final String SELECT_ALL = "SELECT message FROM Application_Log";

    @Autowired
    private DataSource dataSource;

    @Test
    @Repeat(3)
//    @Sql(statements = "DELETE FROM Application_Log")
    @Sql(scripts = "classpath:application_log_schema_h2.sql")
    public void testJdbcTemplate() throws Exception {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

        jdbcTemplate.update(INSERT_ONE, new MapSqlParameterSource()
                .addValue("message", "Log Message 1")
                .addValue("createdBy", "USER")
                .addValue("createdAt", Timestamp.valueOf(LocalDateTime.now())));

        jdbcTemplate.update(INSERT_ONE, new MapSqlParameterSource()
                .addValue("message", "Log Message 2")
                .addValue("createdBy", "USER2")
                .addValue("createdAt", Timestamp.valueOf(LocalDateTime.now())));

        MapSqlParameterSource parameters = new MapSqlParameterSource("id", 1l);
        String result = jdbcTemplate.queryForObject(SELECT_ONE, parameters, String.class);
        assertThat(result, is("Log Message 1"));

        List<String> msgs = jdbcTemplate.query(SELECT_ALL, (rs, rowNum) -> rs.getString("message"));
        msgs.forEach(System.out::println);

        List<Bean> beans = jdbcTemplate.query(SELECT_ALL,
                (rs, rowNum) -> new Bean().setMessage(rs.getString("message")));
        beans.forEach(System.out::println);

        List<String> messages = jdbcTemplate.queryForList(SELECT_ALL, new MapSqlParameterSource(), String.class);
        messages.forEach(System.out::println);

        assertThat(messages, hasSize(2));
    }

    @Getter @Setter @Accessors(chain = true) @ToString
    public final class Bean {
        private String message;
    }

    public final class BeanRowMapper implements RowMapper<Bean> {

        @Override
        public Bean mapRow(ResultSet rs, int rowNum) throws SQLException {
            return null;
        }
    }
}