package football.entities.player;

public class Men extends BasePlayer {
    private final static double KILOGRAMS = 85.50;

    public Men(String name, String nationality, int strength) {
        super(name, nationality, KILOGRAMS, strength);
    }

    @Override
    public void stimulation() {
        setStrength(getStrength() + 145);
    }
}
