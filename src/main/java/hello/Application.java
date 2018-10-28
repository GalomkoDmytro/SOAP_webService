package hello;

import javax.xml.ws.Endpoint;

public class Application {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/hello", new ConstellationEndpointImpl());
    }
}
