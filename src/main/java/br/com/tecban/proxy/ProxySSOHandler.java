package br.com.tecban.proxy;

import java.util.Locale;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class ProxySSOHandler implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		final Message message = exchange.getIn();
        final String body = message.getBody(String.class);
        message.setBody(body.toUpperCase(Locale.US));

	}

}
