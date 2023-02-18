package de.bsi.openai.chatgpt;


import java.io.FileWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.bsi.openai.FormInputDTO;

import de.bsi.openai.ServiceChatGPT;

@Controller
public class ChatGptController {
	
	
	private static final String MAIN_PAGE = "index.html";
	
	@Autowired private ServiceChatGPT client;

	@Autowired private ObjectMapper jsonMapper;
	
	@GetMapping(path = "/")
	public String index() {
		return MAIN_PAGE;
	}
	
	private String chatWithGpt3(String message) throws Exception {
		var completion = CompletionRequest.Signature(message);
		var postBodyJson = jsonMapper.writeValueAsString(completion);
		var responseBody = client.ChatGPT(postBodyJson);
		var completionResponse = jsonMapper.readValue(responseBody, CompletionResponse.class);
		var answer = completionResponse.contenu().orElseThrow();
		FileWriter csvWriter = new FileWriter("data.csv", true);
		csvWriter.append("Question;answer");
	    csvWriter.append(message);
	    csvWriter.append(";");
	    csvWriter.append(answer);
	    csvWriter.append("\n");
	    csvWriter.flush();
	    csvWriter.close();
		return answer;
	}
	
	
	@PostMapping(path = "/")
	public String chat(Model model, @ModelAttribute FormInputDTO dto) {
		try {
			model.addAttribute("request", dto.prompt());
			model.addAttribute("response", chatWithGpt3(dto.prompt()));
		} catch (Exception e) {
			model.addAttribute("response", "Error in communication with OpenAI ChatGPT API.");
		}
		return MAIN_PAGE;
	}
	
	
}
