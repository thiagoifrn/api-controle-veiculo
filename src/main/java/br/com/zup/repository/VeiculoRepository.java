package br.com.zup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	

}
