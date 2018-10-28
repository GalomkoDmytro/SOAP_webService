package hello;

import hello.utility.Utility;
import io.spring.guides.gs_producing_web_service.Constellation;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "hello.ConstellationEndpoint")
public class ConstellationEndpointImpl implements ConstellationEndpoint {

    Utility utility = new Utility();

    @WebMethod
    public Constellation getConstellation(String name) {
        return utility.findConstellation(name);
    }

    @WebMethod
    public Constellation postConstellation(Constellation constellation) {
        utility.postConstellation(constellation);
        return utility.findConstellation(constellation.getName());
    }

    @WebMethod
    public void deleteConstellation(String name) {
        utility.deleteConstellation(name);
    }
}
