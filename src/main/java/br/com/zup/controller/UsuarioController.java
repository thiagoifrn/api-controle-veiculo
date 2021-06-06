package br.com.zup.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.model.Usuario;
import br.com.zup.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario adicionar(@Valid @RequestBody Usuario usuario) {
		return usuarioService.cadastrar(usuario);
	}
	
	@GetMapping("/{usuarioId}")
	public ResponseEntity<Usuario> listarUsuario(@PathVariable Long usuarioId) {
		Usuario usuario = usuarioService.findById(usuarioId);
		 return ResponseEntity.ok(usuario);
	}
	
}
