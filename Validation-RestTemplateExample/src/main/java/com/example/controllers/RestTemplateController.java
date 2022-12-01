package com.example.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.models.Post;

@RestController
@RequestMapping("/rest")
public class RestTemplateController {
	
	//The first of the three options is ...ForEntity getForEntity, postForEntity, putForEntity...
	@GetMapping("/getForEntity")
	public ResponseEntity<String> restTemplateGetForEntity(){
		RestTemplate template = new RestTemplate();
		
		String url = "https://jsonplaceholder.typicode.com/posts";
		
		ResponseEntity<String> res = template.getForEntity(url, String.class);
		return res;
	}
	
	//The second way of the three options is ...ForObject, getForObject, postForObject,...
	@PostMapping("/postForObject")
	public Post restTemplatePostForObject(@RequestBody Post p) {
		RestTemplate template = new RestTemplate();
		String url = "https://jsonplaceholder.typicode.com/posts";
		
		//With ForObject you need an HttpEntity object
		HttpEntity<Post> request = new HttpEntity<Post>(p);
		
		return template.postForObject(url, request, Post.class);
	}
	
	//The final option for making requests with a rest template is exchange
	@PostMapping("/exchange")
	public Post restTemplateExchange(@RequestBody Post p) {
		RestTemplate template = new RestTemplate();
		String url = "https://jsonplaceholder.typicode.com/posts";
		
		HttpEntity<Post> request = new HttpEntity<Post>(p);
		
		return template.exchange(url, HttpMethod.POST, request, Post.class).getBody();
	}

}
