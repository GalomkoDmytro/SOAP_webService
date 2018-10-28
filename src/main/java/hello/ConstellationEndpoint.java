package hello;


import io.spring.guides.gs_producing_web_service.Constellation;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ConstellationEndpoint {

    @WebMethod
    Constellation getConstellation(String name);

    @WebMethod
    Constellation postConstellation(Constellation constellation);

    @WebMethod
    void deleteConstellation(String name);

}
