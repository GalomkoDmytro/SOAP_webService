package hello.utility;

import io.spring.guides.gs_producing_web_service.Alpha;
import io.spring.guides.gs_producing_web_service.Constellation;

import java.util.HashMap;
import java.util.Map;

public class Utility {

    private static final Map<String, Constellation> map = new HashMap<>();

    static {
        Constellation constellations1 = new Constellation();
        constellations1.setName("Polaris");
        constellations1.setArea(121);
        Alpha alpha1 = new Alpha();
        alpha1.setStarName("Canis Major");
        alpha1.setNumberId(111);
        constellations1.setAlpha(alpha1);


        Constellation constellations2 = new Constellation();
        constellations2.setName("Sirius");
        constellations2.setArea(122);
        Alpha alpha2 = new Alpha();
        alpha2.setStarName("Ursae Minoris");
        alpha2.setNumberId(111);
        constellations2.setAlpha(alpha2);

        Constellation constellations3 = new Constellation();
        constellations3.setName("Proxima Centauri");
        constellations3.setArea(123);
        Alpha alpha3 = new Alpha();
        alpha3.setStarName("Canis Major");
        alpha3.setNumberId(111);
        constellations1.setAlpha(alpha3);

        map.put(constellations1.getName(), constellations1);
        map.put(constellations2.getName(), constellations2);
        map.put(constellations3.getName(), constellations3);
    }

    public Constellation findConstellation(String name) {
        return map.get(name);
    }

    public void postConstellation(Constellation constellation) {
        map.put(constellation.getName(), constellation);
    }

    public void deleteConstellation(String name) {
        map.remove(name);
    }
}
