package catHouse.entities.cat;

public class ShorthairCat extends BaseCat{
    private final static int SH_KILOGRAMS=7;

    public ShorthairCat(String name, String breed, double price) {
        super(name, breed,SH_KILOGRAMS, price);


    }

    @Override
    public void eating() {
    setKilograms(getKilograms()+1);
    }
}
