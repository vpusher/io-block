package com.vpusher;

import com.vpusher.domains.Block;
import com.vpusher.domains.Project;
import com.vpusher.domains.User;
import com.vpusher.services.BlockService;
import com.vpusher.services.ProjectService;
import com.vpusher.services.UserService;
import com.vpusher.services.WireService;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;

@SpringBootApplication
@EnableConfigurationProperties(Neo4jProperties.class)
public class Application {

    private final static Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


    @Bean
    public Configuration configuration(Neo4jProperties properties) {
        /*configuration.driverConfiguration()
                .setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver")
                .setURI("http://neo4j:secret@localhost:7474")
                .setCredentials("neo4j", "secret");*/
        Configuration configuration = properties.createConfiguration();
        configuration.autoIndexConfiguration().setAutoIndex("assert");

        return configuration;
    }

    @Bean
    public SessionFactory sessionFactory(Neo4jProperties properties) {
        return new SessionFactory(configuration(properties), "com.vpusher.domains" );
    }



    @Bean
    public Neo4jTransactionManager transactionManager(SessionFactory sessionFactory,
                                                      Neo4jProperties properties,
                                                      ObjectProvider<TransactionManagerCustomizers> transactionManagerCustomizers) {
        return customize(new Neo4jTransactionManager(sessionFactory),
                transactionManagerCustomizers.getIfAvailable());
    }

    private Neo4jTransactionManager customize(Neo4jTransactionManager transactionManager,
                                              TransactionManagerCustomizers customizers) {
        if (customizers != null) {
            customizers.customize(transactionManager);
        }
        return transactionManager;
    }

    @Bean
    CommandLineRunner playground(UserService userService,
                                 ProjectService projectService,
                                 BlockService blockService,
                                 WireService wireService, Configuration configuration) {
        return args -> {

            userService.clean();
            projectService.clean();
            blockService.clean();
            wireService.clean();

            User greg = new User("Greg");
            User roy = new User("Roy");
            User craig = new User("Craig");
            userService.update(greg);
            userService.update(roy);
            userService.update(craig);

            Project project1 = new Project("project1", "project1");
            Project project2 = new Project("project2", "project2");
            projectService.update(project1);
            projectService.update(project2);

            Block addition = new Block("b1", "io-block-addition", 220, 150);
            Block display = new Block("b2", "io-block-display", 400, 200);
            Block supplier1 = new Block("b3", "io-block-supplier", 30, 100);
            Block supplier2 = new Block("b4", "io-block-supplier", 30, 270);
            blockService.update(addition);
            blockService.update(display);
            blockService.update(supplier1);
            blockService.update(supplier2);

            /* --------------- */

            // Add users to project.
            projectService.addMembers(project1, greg, roy);

            // Add block to project.;
            projectService.addBlocks(project1, addition, display, supplier1, supplier2);

            // Wire blocks
            wireService.connect(supplier1, "0", addition, "0");
            wireService.connect(supplier2, "0", addition, "1");
            wireService.connect(addition, "0", display, "0");


        };
    }

}
