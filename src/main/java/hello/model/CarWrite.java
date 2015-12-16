/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author jllach
 */
@Document(collection = "#{@collectionNameProvider.getName('write')}")
public class CarWrite {
    @Id public Long id;
    public List<MadeBy<Engine>>  engine;    
}