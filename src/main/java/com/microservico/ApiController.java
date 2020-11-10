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
import com.microservico.service.RepositorySummaryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Repositorio")
public class ApiController {

	private static final Logger logger = LoggerFactory.getLogger(ApiController.class);
	private static RepositorySummaryService repositorySummary = new RepositorySummaryService();

	@RequestMapping(method = RequestMethod.GET, value = "/repositorio", produces = "application/json; charset=UTF-8")
	@ApiOperation(value = "git-hub-controller", notes = "Lista todos os repositórios do GitHub de um determinado do usuário torvalds")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 201, message = "Created"),
		   @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
		   @ApiResponse(code = 404, message = "Not Found"), })
	public @ResponseBody List<RepositorySummary> listaRepositorySummarys() {
		
		return repositorySummary.listaRepositorySummarys();
	}

	@RequestMapping("/repositorio/{id}")
	@ApiOperation(value = "git-hub-controller", notes = "Lista todos os repositórios do GitHub de um determinado usuário")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), })
	public @ResponseBody List<RepositorySummary> listaRepositorySummarysId(@PathVariable String id) {
		return repositorySummary.listaRepositorySummarysId(id);

	}
}
