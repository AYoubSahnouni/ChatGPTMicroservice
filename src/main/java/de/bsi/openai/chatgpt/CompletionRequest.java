package de.bsi.openai.chatgpt;

public record CompletionRequest(String model, String prompt, 
		double temperature, int max_tokens) {
	
	public static CompletionRequest Signature(String prompt) {
		return new CompletionRequest("text-davinci-003", prompt, 0.7, 100);
	}
	
}
