package catHouse.entities.houses;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static catHouse.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT;
import static catHouse.common.ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseHouse implements House {

    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    public BaseHouse(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.toys=new ArrayList<>();
        this.cats=new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        int softnessSum = 0;
        for (Toy toy : toys) {
            softnessSum += toy.getSoftness();

        }
        return softnessSum;
    }

    @Override
    public void addCat(Cat cat) {
        if (this.getCats().size() < this.capacity) {
            this.getCats().add(cat);
        }
        throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_CAT);


    }

    @Override
    public void removeCat(Cat cat) {
        if (this.getCats().contains(cat.getName())) {
            this.getCats().remove(cat);
        }

    }

    @Override
    public void buyToy(Toy toy) {
        this.getToys().add(toy);

    }

    @Override
    public void feeding() {
        for (Cat cat : this.getCats()) {
            cat.eating();

        }
    }

    @Override
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s:%n", this.getName(), this.getClass().getSimpleName()));
        builder.append("Cats: ");
        if (this.getCats().isEmpty()) {
            builder.append("none");
        } else {
            builder.append(this.getCats().stream().map(Cat::getName).collect(Collectors.joining(" ")).trim());
            builder.append(System.lineSeparator());
        }

        builder.append("Toys: ");
        builder.append(this.getToys().size() + " " + "Softness: ");
        builder.append(this.sumSoftness());
        return builder.toString();
    }

    @Override
    public String getName() {

        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;

    }

    public int getCapacity() {

        return this.getCats().size();
    }

    public void setCapacity(int capacity) {

        this.capacity = capacity;
    }

    @Override
    public Collection<Cat> getCats() {

        return this.cats;
    }

    @Override
    public Collection<Toy> getToys() {

        return this.toys;
    }
}
