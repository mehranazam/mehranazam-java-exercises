package learn.data;


import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    @Bean
    public JdbcTemplate getTemplate(DataSource source){
        JdbcTemplate template = new JdbcTemplate(source);

        return template;
    }

    @Bean
    public DataSource getSource(){
        MysqlDataSource source = new MysqlDataSource();
        source.setUrl("jdbc:mysql://localhost:3306/university_mastery");
        source.setUser("root");
        source.setPassword("top-secret-password");

        return source;
    }
}
