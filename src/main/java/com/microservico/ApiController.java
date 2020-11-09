package com.microservico;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservico.model.RepositorySummary;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Repositorio")
public class ApiController {

	private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

	@RequestMapping(
		    method = RequestMethod.GET,
		    value = "/repositorio",
		    produces = "application/json; charset=UTF-8")
	@ApiOperation(value = "git-hub-controller", notes = "Lista todos os repositórios do GitHub de um determinado do usuário torvalds")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 401, message = "Unauthorized"), 
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), })
	public @ResponseBody List<RepositorySummary> listaRepositorySummarys() {
		List<RepositorySummary> repositorySummarys;
		repositorySummarys = new ArrayList<RepositorySummary>();

		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, String>> repos = restTemplate
				.getForObject("https://api.github.com/users/torvalds/repos", List.class);

		for (LinkedHashMap<String, String> repo : repos) {
			RepositorySummary repositorySummary = new RepositorySummary();
			repositorySummary.setCreated_at(repo.get("created_at"));
			repositorySummary.setDescription(repo.get("description"));
			repositorySummary.setFull_name(repo.get("full_name"));
			repositorySummary.setName(repo.get("name"));
			repositorySummary.setLanguage(repo.get("language"));
			repositorySummary.setOwner(repo.get("login"));
			repositorySummary.setUpdated_at(repo.get("updated_at"));
			repositorySummarys.add(repositorySummary);
		}
		return repositorySummarys;
	}

	@RequestMapping("/repositorio/{id}")
	@ApiOperation(value = "git-hub-controller", notes = "Lista todos os repositórios do GitHub de um determinado usuário")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 401, message = "Unauthorized"), 
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), })
	public @ResponseBody List<RepositorySummary> listaRepositorySummarysId(@PathVariable String id) {
		List<RepositorySummary> repositorySummarys;
		repositorySummarys = new ArrayList<RepositorySummary>();

		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, String>> repos = restTemplate
				.getForObject("https://api.github.com/users/" + id + "/repos", List.class);

		for (LinkedHashMap<String, String> repo : repos) {
			RepositorySummary repositorySummary = new RepositorySummary();
			repositorySummary.setCreated_at(repo.get("created_at"));
			repositorySummary.setDescription(repo.get("description"));
			repositorySummary.setFull_name(repo.get("full_name"));
			repositorySummary.setName(repo.get("name"));
			repositorySummary.setLanguage(repo.get("language"));
			repositorySummary.setOwner(repo.get("login"));
			repositorySummary.setUpdated_at(repo.get("updated_at"));
			repositorySummarys.add(repositorySummary);
		}
		return repositorySummarys;

	}
}
