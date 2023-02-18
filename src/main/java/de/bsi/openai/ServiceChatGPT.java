package de.bsi.openai;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;



@Component
public class ServiceChatGPT {


	private String openaiApiKey="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";

	private final HttpClient client = HttpClient.newHttpClient();
	private static final URI uri_chatgpt = URI.create("https://api.openai.com/v1/completions");
	
	public String ChatGPT(String msg) throws Exception {
		var request = HttpRequest.newBuilder()
				.uri(uri_chatgpt)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.header(HttpHeaders.AUTHORIZATION, "Bearer " + openaiApiKey)
				.POST(BodyPublishers.ofString(msg))
				.build();
		return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
	}
	
	

}
