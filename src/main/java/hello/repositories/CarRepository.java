/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.repositories;

import hello.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author jllach
 */
public interface CarRepository extends MongoRepository<Car, Long> {   
}