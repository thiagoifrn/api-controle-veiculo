package br.com.zup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.zup.model.Usuario;
import br.com.zup.negocioexception.NegocioException;
import br.com.zup.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private VeiculoService veiculoService;

	@Transactional
	public Usuario cadastrar(Usuario usuario) {
		boolean emailEmUso = usuarioRepository.findByEmail(usuario.getEmail()).stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(usuario));
		boolean cpfEmUso = usuarioRepository.findByCpf(usuario.getCpf()).stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(usuario));

		if (emailEmUso == true || cpfEmUso == true) {
			throw new NegocioException("Lembre-se, email e cpf devem ser únicos. Dado ja existe");
		}

		return usuarioRepository.save(usuario);

	}

	public Usuario findById(Long usuarioId) {
		Usuario usuario = usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new NegocioException("usuario não encontrado"));
		
		usuario.getVeiculos().stream().forEach(veiculo -> {
			veiculoService.calcularRodizio(veiculo);
		});
		
		
		return usuario;
	}
	
}
