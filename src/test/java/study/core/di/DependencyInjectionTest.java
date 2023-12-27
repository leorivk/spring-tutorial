package study.core.di;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


public class DependencyInjectionTest {

    @Test
    void diTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TempConfig.class);
        Ride ride = ac.getBean(Ride.class);
        Assertions.assertThat(ride).isInstanceOf(Car.class);
    }
}

@Configuration
@ComponentScan
class TempConfig {
    
}

interface Ride {
    void move();
}

@Component
@Primary
class Car implements Ride {
    @Override
    public void move() {
        System.out.println("Car.move");
    }
}

@Component
class Bike implements Ride {
    @Override
    public void move() {
        System.out.println("Bike.move");
    }
}