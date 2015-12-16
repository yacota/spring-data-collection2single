package hello.repositories;

import hello.Application;
import org.springframework.boot.test.SpringApplicationConfiguration;
import proposal.MongoDbConfiguration;

@SpringApplicationConfiguration(classes = {MongoDbConfiguration.class, Application.class})
public class CarRepositoryWithCustomMappingMongoConverterTest 
extends      AbstractCarRepositoryTest{
    
}