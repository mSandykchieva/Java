package football.entities.player;

public class Women extends BasePlayer{

    private final static double KILOGRAMS =60.0;

    public Women(String name, String nationality, int strength) {
        super(name, nationality,KILOGRAMS, strength);
    }

    @Override
    public void stimulation() {
     setStrength(getStrength()+115);
    }
}
