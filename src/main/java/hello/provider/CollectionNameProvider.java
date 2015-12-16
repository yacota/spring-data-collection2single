/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.provider;

import org.springframework.stereotype.Component;

/**
 * Build in order to trick spring data and avoid "Ambiguous field mapping detected"
 * when ApplicationContextEvent is received those check are done.
 * ...
 * org.springframework.data.mapping.model.MappingException: Ambiguous field mapping detected! Both @org.springframework.data.mongodb.core.mapping.Field(value=engine, order=2147483647) public java.util.List hello.model.Car.engineList and public hello.model.MadeBy hello.model.Car.engine map to the same field name engine! Disambiguate using @Field annotation!
 * at org.springframework.data.mongodb.core.mapping.BasicMongoPersistentEntity$AssertField
 * ...
 * @author jllach
 */
@Component("collectionNameProvider")
public class CollectionNameProvider {
    
    private final String CAR_COLLECTION_NAME  = "car";
    private final String FAKE_COLLECTION_NAME = "fake";
    
    private boolean realCarIsReadOne = false;
    
    public String getName(String readOrWrite) {
        if ("write".equals(readOrWrite)) {
           if (!realCarIsReadOne) return CAR_COLLECTION_NAME;
           else                   return FAKE_COLLECTION_NAME;
        } else {
           if (realCarIsReadOne) return CAR_COLLECTION_NAME;
           else                  return FAKE_COLLECTION_NAME;
        }
    }

    // invoking after populating data into mongodb with CarUsed2Write object, and read data with Car.java
    public void afterWritingData_CarUsed2Write_WillBeRenamed2_fake_and_Car_WillBeRenamed2_car() {
        this.realCarIsReadOne = true;
    }
}