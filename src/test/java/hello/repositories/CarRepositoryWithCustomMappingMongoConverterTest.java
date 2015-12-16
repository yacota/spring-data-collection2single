package hello.repositories;

import hello.Application;
import hello.MongoEmbeddedConfiguration;
import hello.model.Car;
import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import proposal.MongoDbConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {MongoEmbeddedConfiguration.class, MongoDbConfiguration.class, Application.class})
public class CarRepositoryWithCustomMappingMongoConverterTest {
    
    @Autowired
    private CarRepository carRepository;

    @Test
    public void testMappingWorksBecauseOfCustomMappingMongoConverterIsUsed() {
        Car findOne = carRepository.findOne(1L);
        Assert.assertNotNull(findOne);
        Assert.assertEquals("toyota", findOne.engine.component.id);
    }
}