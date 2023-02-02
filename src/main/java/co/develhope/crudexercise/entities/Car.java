package co.develhope.crudexercise.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Car{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_car", nullable = false)
    private Long id_car;
    private String modelName;
    private String type;

    public Car(){
    }

    public Car(Long id_car,String modelName,String type){
        this.id_car = id_car;
        this.modelName = modelName;
        this.type = type;
    }

    public Long getId_car(){
        return id_car;
    }

    public void setId_car(Long id_car){
        this.id_car = id_car;
    }

    public String getModelName(){
        return modelName;
    }

    public void setModelName(String modelName){
        this.modelName = modelName;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }
}
