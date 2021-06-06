package br.com.zup.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.model.Veiculo;
import br.com.zup.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo adicionar(@Valid @RequestBody Veiculo veiculo) {
		return veiculoService.cadastrar(veiculo);
	}
	
}
