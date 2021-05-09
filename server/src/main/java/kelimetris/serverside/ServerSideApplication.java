package kelimetris.serverside;

import org.h2.tools.Server;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.SQLException;

@SpringBootApplication
@ComponentScan({"kelimetris.core", "kelimetris.serverside"})
@EntityScan("kelimetris.core.lib.model")
@EnableJpaRepositories("kelimetris.core.lib.repository")
public class ServerSideApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerSideApplication.class, args);
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }
}
