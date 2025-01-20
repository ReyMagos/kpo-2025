package studying;

public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService();
        CustomerStorage customerStorage = new CustomerStorage();
        HseCarService hseCarService = new HseCarService(carService, customerStorage);
        PedalCarFactory pedalCarFactory = new PedalCarFactory();
        HandCarFactory handCarFactory = new HandCarFactory();

        customerStorage.addCustomer(new Customer("Juan", 6, 4));
        customerStorage.addCustomer(new Customer("Alberto", 4, 6));
        customerStorage.addCustomer(new Customer("Pedro", 6, 6));
        customerStorage.addCustomer(new Customer("Mike", 4, 4));

        carService.addCar(pedalCarFactory, new PedalEngineParams(8));
        carService.addCar(pedalCarFactory, new PedalEngineParams(3));
        carService.addCar(handCarFactory, new EmptyEngineParams());
        carService.addCar(handCarFactory, new EmptyEngineParams());

        System.out.println("Before sell:");
        System.out.println(customerStorage);
        System.out.println(carService);

        hseCarService.sellCars();

        System.out.println("\nAfter sell: ");
        System.out.println(customerStorage);
        System.out.println(carService);
    }
}
