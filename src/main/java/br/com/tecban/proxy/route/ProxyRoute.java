package br.com.tecban.proxy.route;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.RouteDefinition;
import org.springframework.stereotype.Component;

@Component
public class ProxyRoute extends RouteBuilder {
	
    @Override
    public void configure() throws Exception {
        from("netty4-http:proxy://0.0.0.0:8080")
            .process(ProxyRoute::uppercase)
	    .to("log:DEBUG?showBody=true&showHeaders=true")
            .toD("netty-http:"
                + "${headers." + Exchange.HTTP_SCHEME + "}://"
                + "${headers." + Exchange.HTTP_HOST + "}:"
                + "${headers." + Exchange.HTTP_PORT + "}"
                + "${headers." + Exchange.HTTP_PATH + "}")
	     .to("log:DEBUG?showBody=true&showHeaders=true")
            .process(ProxyRoute::uppercase);
    }

    public static void uppercase(final Exchange exchange) {
	 
         System.out.println(">>>>> PROCESSOR CHAMADO");
    }

}
