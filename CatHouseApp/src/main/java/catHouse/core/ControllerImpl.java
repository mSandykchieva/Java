package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        toys = new ToyRepository();
        houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;
        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                houses.add(house);
                break;
            case "LongHouse":
                house = new LongHouse(name);
                houses.add(house);
                break;
            default:
                throw new NullPointerException(INVALID_HOUSE_TYPE);

        }
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;
        if (type.equals("Ball")) {
            toy = new Ball();
            toys.buyToy(toy);
        } else if (type.equals("Mouse")) {
            toy = new Mouse();
            toys.buyToy(toy);
        } else {
            throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {

        // Взимаме играчка от Репозитори .

        Toy toy = this.toys.findFirst(toyType);
        if (toy == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }
        House house = getHouseByName(houseName);
        house.buyToy(toy);

        toys.removeToy(toy);

        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    //Допълнителен метод.Взима къща от списък с къщи

    private House getHouseByName(String houseName) {
        return this.houses.stream().filter(house -> house.getName().equals(houseName))
                .findFirst().get();


    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;
        switch (catType){
            case"ShorthairCat":
                cat = new ShorthairCat(catName,catBreed,price);
                break;
            case"LonghairCat":
                cat = new LonghairCat(catName,catBreed,price);
                break;
            default: throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }
        House house = getHouseByName(houseName);
        if(house.getName().startsWith("Short") && cat.getName().startsWith("Short") ||
        house.getName().startsWith("Long") && cat.getName().startsWith("Long"))
        {
            return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE,catType,houseName);
        }else {

        }return UNSUITABLE_HOUSE;

    }

    @Override
    public String feedingCat(String houseName) {
        House house = getHouseByName(houseName);
        house.feeding();


        return String.format(FEEDING_CAT,house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = getHouseByName(houseName);
        double sum=0.00;
        for (Cat cat: house.getCats()) {
            sum+=cat.getPrice();
        }
        for (Toy toy: house.getToys()) {
            sum+= toy.getPrice();
        }
        return String.format(VALUE_HOUSE,houseName,sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        for (House house:this.houses) {
            builder.append(house.getStatistics());
            
        }
        return builder.toString();
    }
}
