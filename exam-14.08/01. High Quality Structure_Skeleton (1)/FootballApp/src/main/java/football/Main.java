package football;

import football.core.Controller;
import football.core.ControllerImpl;
import football.core.Engine;
import football.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        //Controller controller = new ControllerImpl();
        engine.run();
    }
}
