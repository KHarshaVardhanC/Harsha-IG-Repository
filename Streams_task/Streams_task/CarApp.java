package com.Java.Collections.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

 class Car {
	private String careMake; //ex. Maruti 
	private String carName; // ex.Swift Dezire
	private double price;  // ex. 8120000.0
	
	public Car() {
		
	}

	public Car(String careMake, String carName, double price) {
		super();
		this.careMake = careMake;
		this.carName = carName;
		this.price = price;
	}

	public String getCareMake() {
		return careMake;
	}

	public String getCarName() {
		return carName;
	}

	public double getPrice() {
		return price;
	}

	public void setCareMake(String careMake) {
		this.careMake = careMake;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [careMake=" + careMake + ", carName=" + carName + ", price=" + price + "]";
	}
	
	
}

 interface CarService{
	public double sumOfPrices(List<Car> carList);
	public List<String> getCarNames(List<Car> carList);
	public Set<String> getCarMakers(List<Car> carList);
	//returns price of the car which has highest price
	public Car getHighPricedCar(List<Car> carList);
	//returns Car which has lowest price
	public Car getCarWithLowPricedCar(List<Car> carList);
}





public class CarApp{

	public static void main(String[] args){
		Car cars[]= {
						new Car("Maruti","Swift Dezire",810000.00),
						new Car("Hyundai","Verna",1100000.00),
						new Car("Toyota","Innova",2450000.00),
						new Car("Audi","Q3",4500000.00)
				
					};

		List<Car> carList = new ArrayList<>(Arrays.asList(cars));
		
		CarService cs=new CarServiceImpl();
		try {
			System.out.println(cs.sumOfPrices(carList));
			
			
			System.out.println(cs.getCarNames(carList));
			System.out.println(cs.getCarMakers(carList));
			System.out.println(cs.getHighPricedCar(carList));
			System.out.println(cs.sumOfPrices(carList));
			System.out.println(cs.getCarWithLowPricedCar(carList));
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


}



class CarServiceImpl implements CarService {

    @Override
    public double sumOfPrices(List<Car> carList) {
        return carList.stream()
                      .mapToDouble(Car-> Car.getPrice())
                      .sum();
    }

    @Override
    public List<String> getCarNames(List<Car> carList) {
        return carList.stream()
                      .map(Car-> Car.getCareMake())
                      .collect(Collectors.toList());
    }

    @Override
    public Set<String> getCarMakers(List<Car> carList) {
        return carList.stream()
                      .map(Car-> Car.getCareMake())
                      .collect(Collectors.toSet());
    }

    @Override
    public Car getHighPricedCar(List<Car> carList) {
        return carList.stream().max((c1,c2) -> Double.compare(c2.getPrice(), c1.getPrice())).orElse(null);
                      
    }

    @Override
    public Car getCarWithLowPricedCar(List<Car> carList) {
        return carList.stream()
                      .min((c1, c2) -> Double.compare(c1.getPrice(), c2.getPrice()))
                      .orElse(null);
    }
}
