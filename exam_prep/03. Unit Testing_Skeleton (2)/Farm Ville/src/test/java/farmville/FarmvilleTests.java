package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Farm

    Farm farm;

    Animal animal;
    Animal animal2;
    Animal animal3;

    @Before
    public void setUp(){
        farm = new Farm ("FarmVil",3);
        animal=new Animal("bozainik",1.1);
        animal2=new Animal("divech",1.2);
        animal3=new Animal("vlechugi",1.3);

    }

    @Test
    public void test_getCount(){
        farm.add(animal);
        Assert.assertEquals(1,farm.getCount());

    }


    @Test
    public void test_getName(){
        farm.getName();
        Assert.assertEquals("FarmVil",farm.getName());
    }




    @Test (expected = IllegalArgumentException.class)
    public void test_farmIsFull (){
        farm.add(animal);
        farm.add(animal2);
        farm.add(animal3);
        farm.add(new Animal("mammal",2.2));
    }
    @Test (expected = IllegalArgumentException.class)
    public void test_animalExist() {
        boolean animalExist = false;
        farm.add(animal);
        animalExist = true;
        farm.add(animal);
    }
    @Test
    public void test_addAnimal(){
        farm.add(animal);
    }

    @Test
    public void test_remove(){
        farm.add(animal3);
        farm.remove(animal3.getType());
        Assert.assertEquals(0,farm.getCount());

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_setCapacity(){
        farm= new Farm("Magi",-1);
    }

    @Test(expected = NullPointerException.class)
    public void test_setName(){
        farm= new Farm("",2);
    }
}
