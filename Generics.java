package Day6_Tasks;

import java.util.ArrayList;

class Toyota {
    String name;

    Toyota(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Toyota{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Benz {
    String name;
    Benz(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Benz{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Car<T> {
    int index = 0;
    int size = 0;
    T[] cars;
    public Car(int size) {
        this.size = size;
        cars = (T[])new Object[size];
    }

    public T getCarName(int i) {
        if (i>-1 && i < cars.length) {
            return cars[i];
        }
        else {
            System.out.println("[ERROR: getCarName()] Index Out of Bounds");
            return null;
        }
    }

    public void setCarName(T car) {
        if (index < size) {
            cars[index++] = car;
        } else {
            System.out.println("[ERROR: setCarName()] Index Out of Bounds");
        }
    }
}

public class Generics {
    public static void main(String[] args) {
        Car<Toyota> tcars = new Car<>(5);
        tcars.setCarName(new Toyota("Toyota 1"));
        tcars.setCarName(new Toyota("Toyota 2"));
        tcars.setCarName(new Toyota("Toyota 3"));
        tcars.setCarName(new Toyota("Toyota 4"));
        tcars.setCarName(new Toyota("Toyota 5"));
        //tcars.setCarName(new Toyota("Toyota 6"));

        System.out.println(tcars.getCarName(0));
        System.out.println(tcars.getCarName(1));

        Car<Benz> bCars = new Car<>(3);
        bCars.setCarName(new Benz("Benz 1"));
        bCars.setCarName(new Benz("Benz 2"));
        bCars.setCarName(new Benz("Benz 3"));
        bCars.setCarName(new Benz("Benz 4"));

        System.out.println(bCars.getCarName(0));
        System.out.println(bCars.getCarName(1));
        System.out.println(bCars.getCarName(2));
        System.out.println(bCars.getCarName(3));

        ArrayList<String> arrList = new ArrayList<>();
        arrList.add("abc");
        arrList.add("def");
        //arrList.add(124); - ERROR (ArrayList Parameter is of type String)

        printNumbers(10, 45.7);
    }

    public static<T, U extends Number> void  printNumbers(T i, U j) {
        System.out.println("i = "+i +" j = "+j);
    }
}
