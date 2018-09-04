package com.teclab.ws.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teclab.ws.entity.TokenizerRequest;
import com.teclab.ws.entity.TokenizerResponse;

@RestController
@RequestMapping("/tokenizer")
public class TokenizerControler {
	@RequestMapping(produces = "application/json", method = RequestMethod.POST, path="data")
	public ResponseEntity<TokenizerResponse> tokenizer(@RequestBody TokenizerRequest request) {
		TokenizerResponse response = new TokenizerResponse();
		
		String pan = request.getData();
		String bin = pan.substring(0,6);
		String token =  pan.substring(6, pan.length()-4);
		String fourLast = pan.substring(pan.length()-4, pan.length());
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=0;i<token.length();i++) {
			 sb.append('X');
		}
		
		response.setCode(0);
		response.setToken(bin+sb.toString()+fourLast);
		return ResponseEntity.ok(response);
	}
	
	
	@RequestMapping(produces = "application/json", method = RequestMethod.GET)
	public ResponseEntity<TokenizerResponse> randomToken() {
		TokenizerResponse response = new TokenizerResponse();
		
		response.setCode(0);
		response.setToken("123456123456789123456");
		return ResponseEntity.ok(response);
	}
}
