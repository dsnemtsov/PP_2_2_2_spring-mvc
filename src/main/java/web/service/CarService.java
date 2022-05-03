package web.service;

import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;
import web.model.Car;

@Service
public class CarService {
    private static final List<Car> cars = new LinkedList<>();

    static {
        cars.add(new Car(1L, "model1", "series1"));
        cars.add(new Car(2L, "model2", "series2"));
        cars.add(new Car(3L, "model3", "series3"));
        cars.add(new Car(4L, "model4", "series4"));
        cars.add(new Car(5L, "model5", "series5"));
    }

    public List<Car> findAll() {
        return cars;
    }

    public List<Car> findByCount(int count) {
        if (count >= 5) {
            return cars;
        } else {
            List<Car> result = new LinkedList<>();
            for (int i = 0; i < count; i++) {
                result.add(cars.get(i));
            }
            return result;
        }
    }
}
