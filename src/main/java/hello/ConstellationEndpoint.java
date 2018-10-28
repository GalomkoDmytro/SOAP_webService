package hello;

import io.spring.guides.gs_producing_web_service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ConstellationEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private ConstellationRepository constellationRepository;

    @Autowired
    public ConstellationEndpoint(ConstellationRepository constellationRepository) {
        this.constellationRepository = constellationRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getConstellationRequest")
    @ResponsePayload
    public GetConstellationResponse getConstellation(@RequestPayload GetConstellationRequest request) {
        GetConstellationResponse response = new GetConstellationResponse();
        response.setConstellation(constellationRepository.findConstellation(request.getName()));
        System.out.println("-------------- GET ------------------");

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteConstellationRequest")
    @ResponsePayload
    public void deleteCdeleteConstellation(@RequestPayload DeleteConstellationRequest request) {
        constellationRepository.deleteConstellation(request.getName());
        System.out.println("-------------- DELETE ---------------");
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postConstellationRequest")
    @ResponsePayload
    public PostConstellationRequest postCdeleteConstellation(@RequestPayload PostConstellationRequest request) {
        System.out.println("-------------- POST -----------------");
        PostConstellationRequest postConstellationResponse = new PostConstellationRequest();
        constellationRepository.postConstellation(request.getConstellation());
        PostConstellationRequest postConstellationResponse1 = new PostConstellationRequest();
        Constellation constellation = constellationRepository.findConstellation(request.getConstellation().getName());
        postConstellationResponse.setConstellation(constellation);
        return postConstellationResponse;
    }
}
