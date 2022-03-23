package learn.solarfarm.data;


import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@ComponentScan
public class DbTestConfig {

    @Bean
    public JdbcTemplate getTemplate(DataSource source){
        JdbcTemplate template = new JdbcTemplate(source);

        return template;
    }


    @Bean
    public DataSource getSource(){
        MysqlDataSource source = new MysqlDataSource();
        source.setUrl("jdbc:mysql://localhost:3306/solar_farm_test");
        source.setUser( "root" );
        source.setPassword( "top-secret-password" );

        return source;
    }
}
