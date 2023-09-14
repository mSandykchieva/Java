package petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PetStoreTests {

    private static final String SPECIE = "Dog";
    private static final int MAX_KG = 30;
    private static final double COST = 100.00;


    private PetStore petStore;
    private Animal animal;

    @Before
    public void setUp() {
        this.petStore = new PetStore();
        this.animal = new Animal(SPECIE, MAX_KG, COST);

    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_unmodifiedCollection() {
        List<Animal> animals = petStore.getAnimals();
        animals.remove(1);
    }

    @Test
    public void test_size() {
        Assert.assertEquals(0, petStore.getCount());
        /*List<Animal> animals = new ArrayList<>();
        animals.add(animal);*/
        petStore.addAnimal(animal);
        Assert.assertEquals(1, petStore.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addAnimal(){
        petStore.addAnimal(null);
    }
//*
    @Test
    public void test_findAnimalBySpecie(){
        petStore.addAnimal(animal);
        List<Animal> animals = petStore.findAllAnimalBySpecie("Cat");
        Assert.assertTrue(animals.isEmpty());
    }

    @Test
    public void test_mostExpensive(){
        petStore.addAnimal(animal);
        petStore.addAnimal(new Animal("Lion",60,66.6));
        Assert.assertEquals("Dog",petStore.getTheMostExpensiveAnimal().getSpecie());
    }

    @Test
    public void test_mostExpensive2(){
        Animal animal = petStore.getTheMostExpensiveAnimal();
        Assert.assertNull(animal);
    }

    @Test
    public void test_findAnimalBySpecie2(){
        petStore.addAnimal(animal);
        petStore.addAnimal(new Animal("Lion",60,66.6));
        List<Animal>animals = petStore.findAllAnimalBySpecie(SPECIE);
        Assert.assertEquals(1,animals.size());
        Assert.assertEquals(SPECIE,animals.get(0).getSpecie());

    }

    @Test
    public void test_animalWithMaxKG(){
        petStore.addAnimal(animal);
        petStore.addAnimal(new Animal("Lion",60,66.6));


    }
}

