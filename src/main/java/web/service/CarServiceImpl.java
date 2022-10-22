package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class CarServiceImpl implements CarService{
    private static List<Car> cars;
    @Override
    public List<Car> getCars(int count) {
        cars =  new ArrayList<>();
        cars.add(new Car(1,"Scoda", "white"));
        cars.add(new Car(2,"Mersedes", "black"));
        cars.add(new Car(3,"Toyota", "grey"));
        cars.add(new Car(4,"Aydi", "green"));
        cars.add(new Car(5,"BMW", "blue"));

        if (count > cars.size() | count < 0) {
            count = cars.size();
        }

        return cars.stream().limit(count).toList();
    }
}
