package br.com.zup.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByEmail(String Email);
	Optional<Usuario> findByCpf(String cpf);
}
