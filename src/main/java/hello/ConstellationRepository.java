package hello;

import io.spring.guides.gs_producing_web_service.Alpha;
import io.spring.guides.gs_producing_web_service.Constellation;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;


/**
 * provide data to the web service
 */
@Component
public class ConstellationRepository {
    private static final Map<String, Constellation> constellations = new HashMap<>();

    @PostConstruct
    public void initData() {
        Constellation constPolaris = new Constellation();
        constPolaris.setName("Polaris");
        constPolaris.setArea(123);
        Alpha alpha1 = new Alpha();
        alpha1.setStarName("Ursae Minoris");
        alpha1.setNumberId(111);
        constPolaris.setAlpha(alpha1);

        constellations.put(constPolaris.getName(), constPolaris);

        Constellation constSirius = new Constellation();
        constSirius.setName("Sirius");
        constSirius.setArea(789);
        Alpha alpha2 = new Alpha();
        alpha2.setStarName("Canis Major");
        alpha2.setNumberId(111);
        constSirius.setAlpha(alpha2);

        constellations.put(constSirius.getName(), constSirius);

        Constellation constProxima = new Constellation();
        constProxima.setName("Proxima Centauri");
        constProxima.setArea(123);
        Alpha alpha3 = new Alpha();
        alpha3.setStarName("Alpha Centauri");
        alpha3.setNumberId(654);
        constProxima.setAlpha(alpha3);

        constellations.put(constProxima.getName(), constProxima);
    }

    public Constellation findConstellation(String name) {
        Assert.notNull(name, "The constellation's name must not be null");
        return constellations.get(name);
    }

    public void deleteConstellation(String name) {
        constellations.remove(name);
    }

    public void postConstellation(Constellation constellation) {
        constellations.put(constellation.getName(), constellation);
    }


}
