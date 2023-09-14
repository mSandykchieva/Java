package catHouse.entities.cat;

public class LonghairCat extends BaseCat{
    private static final int LH_KILOGRAMS=9;

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, LH_KILOGRAMS, price);
    }

    @Override
    public void eating() {
        setKilograms(getKilograms()+3);
    }
}
