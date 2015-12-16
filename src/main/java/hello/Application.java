package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application  {
    
    
//    @Bean Autowired
//    public MongoMappingContext mongoMappingContext(ApplicationContext appContext) throws IOException {
//        MongoMappingContext mongoContext = new MongoMappingContext();
//        mongoContext.setApplicationContext(appContext);
//        return mongoContext;
//    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}