/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.repositories;

import hello.model.Car;
import hello.model.CarWrite;
import hello.model.Engine;
import hello.model.MadeBy;
import hello.provider.CollectionNameProvider;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author jllach
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractCarRepositoryTest {
    
    
    @Autowired
    protected CarWriteRepository carWriteRepository;
    @Autowired
    protected CarRepository      carRepository;
    
    @Autowired
    protected CollectionNameProvider nameProvider;
    
    @Before
    public void setUp() {
        Engine toyota = new Engine();
        toyota.id = "toyota";
        Engine porsche = new Engine();
        porsche.id = "porsche";
        
        MadeBy<Engine> madeByToyota = new MadeBy<>();
        madeByToyota.component = toyota;
        madeByToyota.assembled = new Date();
        
        MadeBy<Engine> madeByPorsche = new MadeBy<>();
        madeByPorsche.component = porsche;
        madeByPorsche.assembled = new Date();
        
        
        CarWrite car = new CarWrite();
        car.id = 1L;
        List<MadeBy<Engine>> engines = new ArrayList<>(2);
        engines.add(madeByToyota);
        engines.add(madeByPorsche);
                
        car.engine = engines;
        carWriteRepository.save(car);
        
        // switching document collection names in orer to avoid name colision
        nameProvider.afterWritingData_CarUsed2Write_WillBeRenamed2_fake_and_Car_WillBeRenamed2_car();
    }
    
    @After
    public void tearDown() {
        carRepository.deleteAll();
    }
    
    
    @Test
    public void testMapping() {
        Car findOne = carRepository.findOne(1L);
        Assert.assertNotNull(findOne);
        Assert.assertEquals("toyota", findOne.engine.component.id);
    }
}