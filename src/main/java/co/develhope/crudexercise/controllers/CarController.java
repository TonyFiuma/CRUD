package co.develhope.crudexercise.controllers;

import co.develhope.crudexercise.entities.Car;
import co.develhope.crudexercise.repositories.CarRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController{
    @Autowired
    CarRepository carRepository;

    @PostMapping("")
    public Car createCar(@RequestBody Car car){
        car.setId_car(null);
        return carRepository.saveAndFlush(car);
    }

    @GetMapping("")
    public List<Car> getCarList(){
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Car getACar(@PathVariable long id){
        return carRepository.existsById(id) ? carRepository.getById(id) : new Car();
    }

    @PutMapping("")
    public Car updateCar(@RequestParam long id,@RequestParam String type){
        Car car;
        if(carRepository.existsById(id)){
            car = carRepository.getById(id);
            car.setType(type);
            car = carRepository.saveAndFlush(car);
        } else {
            car = new Car();
        }
        return car;
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id,HttpServletResponse httpServletResponse){
        if(carRepository.existsById(id)){
            carRepository.deleteById(id);
        } else {
            httpServletResponse.setStatus(409);
        }
    }

    @DeleteMapping("")
    public void deleteAll(){
        carRepository.deleteAll();
    }
}
