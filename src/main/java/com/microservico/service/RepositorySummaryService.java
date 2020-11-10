package com.microservico.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.microservico.model.RepositorySummary;

@Service
public class RepositorySummaryService{
	
	
	public List<RepositorySummary> listaRepositorySummarys() {
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

	public List<RepositorySummary> listaRepositorySummarysId(String id) {
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
