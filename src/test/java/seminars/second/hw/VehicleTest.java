package seminars.second.hw;

import org.example.Seminar2.hw.Car;
import org.example.Seminar2.hw.Motorcycle;
import org.example.Seminar2.hw.Vehicle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    Проверить, что экземпляр объекта Car также является экземпляром транспортного средства (используя оператор instanceof).
    Проверить, что объект Car создается с 4-мя колесами.
    Проверить, что объект Motorcycle создается с 2-мя колесами.
    Проверить, что объект Car развивает скорость 60 в режиме тестового вождения (используя метод testDrive()).
    Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового вождения (используя метод testDrive()).
    Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) машина останавливается (speed = 0).
    Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) мотоцикл останавливается (speed = 0).
 */
class VehicleTest {
    private static Car car;
    private static Motorcycle motorcycle;

    @BeforeAll
    public static void createObjetsForTest(){
        car = new Car("ABS", "Model1", 1999);
        motorcycle = new Motorcycle("BCZ", "Model2", 1998);
    }

    /*
        Проверка, что экземпляр класса Car является экземпляром транспортного средства.
        Тест считается успешным если метод assertTrue() получает True
     */
    @Test
    public void carShouldVehicleObject(){
        assertTrue(car instanceof Vehicle);
    }

    /*
        Проверка, что экземпляр класса Car создается с 4-мя колесами
     */
    @Test
    public void carShouldHaveFourWheels(){
        int expectedWheels = 4;
        int actualWheels = car.getNumWheels();
        assertEquals(expectedWheels,
                actualWheels, "Конструктор класса Car некорректен, кол-во колес не равно 4");
    }

    /*
        Проверка, что экземпляр класса Motorcycle создается с 2-мя колесами
     */
    @Test
    public void motorcycleShouldHaveFourWheels(){
        int expectedWheels = 2;
        int actualWheels = motorcycle.getNumWheels();
        assertEquals(expectedWheels,
                actualWheels, "Конструктор класса Motorcycle некорректен, кол-во колес не равно 4");
    }

    /*
        Проверка на корректность работы метода testDrive(), для экземпляра класса Car.
        При начале движения скорость автомобиля должна равняться 60.
     */
    @Test
    public void carShouldDriveWithCorrectSpeed(){
        int expectedSpeed = 60;
        car.testDrive();
        int actualSpeed = car.getSpeed();
        assertEquals(expectedSpeed,
                actualSpeed, "Метод testDrive() некорректен, скорость машины не равна 60");
    }

    /*
        Проверка на корректность работы метода testDrive(), для экземпляра класса Car.
        При начале движения скорость мотоцикла должна равняться 60.
     */
    @Test
    public void motorcycleShouldDriveWithCorrectSpeed(){
        int expectedSpeed = 75;
        motorcycle.testDrive();
        int actualSpeed = motorcycle.getSpeed();
        assertEquals(expectedSpeed,
                actualSpeed, "Метод testDrive() некорректен, скорость мотоцикла не равна 60");
    }

    /*
        Проверка на корректность работы метода park(), для экземпляра класса Car.
        При остановке скорость автомобиля должна равняться 0.
     */
    @Test
    public void carShouldParkWithCorrectSpeed(){
        int expectedSpeed = 0;
        /*
            Т.к. объект Car является статическим и его скорость была изменена
            в методе проверки carShouldDriveWithCorrectSpeed(), повторный вызов метода излишен,
            но оставил для большей наглядности и т.к. его повторный вызов не влияет на логику программы.
            Второй способ создать новый экземпляр класса Car и провести проверку на нем, но в данном
            случае это опять будет избыточным.
         */
        car.testDrive(); //
        car.park();
        int actualSpeed = car.getSpeed();
        assertEquals(expectedSpeed,
                actualSpeed, "Метод park() некорректен, скорость машины не равна 0");
    }

    /*
        Проверка на корректность работы метода park(), для экземпляра класса Car.
        При остановке скорость мотоцикла должна равняться 0.
     */
    @Test
    public void motorcycleShouldParkWithCorrectSpeed(){
        int expectedSpeed = 0;
        /*
            Т.к. объект Motorcycle является статическим и его скорость была изменена
            в методе проверки motorcycleShouldDriveWithCorrectSpeed(), повторный вызов метода излишен,
            но оставил для большей наглядности и т.к. его повторный вызов не влияет на логику программы.
            Второй способ создать новый экземпляр класса Motorcycle и провести проверку на нем, но в данном
            случае это опять будет избыточным.
         */
        motorcycle.testDrive();
        motorcycle.park();
        int actualSpeed = motorcycle.getSpeed();
        assertEquals(expectedSpeed,
                actualSpeed, "Метод park() некорректен, скорость мотоцикла не равна 0");
    }
}