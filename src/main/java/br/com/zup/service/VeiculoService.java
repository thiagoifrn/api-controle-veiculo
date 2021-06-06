package br.com.zup.service;

import java.text.DateFormatSymbols;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.zup.model.Usuario;
import br.com.zup.model.Veiculo;
import br.com.zup.negocioexception.NegocioException;
import br.com.zup.repository.FipeRepository;
import br.com.zup.repository.UsuarioRepository;
import br.com.zup.repository.VeiculoRepository;
import feign.FeignException;

@Service
public class VeiculoService {
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private FipeRepository fipeRepository;

	@Transactional
	public Veiculo cadastrar(Veiculo veiculo) {
		Usuario usuario = usuarioRepository.findById(veiculo.getUsuario().getId())
				.orElseThrow(() -> new NegocioException("usuário não encontrado"));

		try {
			veiculo.setValor(fipeRepository.getFipeResponse(veiculo.getMarca(), veiculo.getModelo(), veiculo.getAno())
					.getValor());
		} catch (FeignException e) {
			throw new NegocioException("Marca, modelo ou ano não encontrado. Preço não encontrado na tabela FIPE");
		}
		
		calcularRodizio(veiculo);
		veiculo.setDiaRodizio(rodizioDoVeiculo(veiculo));
		veiculo.setUsuario(usuario);
		
		return veiculoRepository.save(veiculo);
	}

	public String rodizioDoVeiculo(Veiculo veiculo) {
		int ano = Integer.parseInt(veiculo.getAno().substring(0, 4)) % 10;

		switch (ano) {
		case 0:
		case 1:
			return "segunda-feira";
		case 2:
		case 3:
			return "terça-feira";
		case 4:
		case 5:
			return "quarta-feira";
		case 6:
		case 7:
			return "quinta-feira";
		case 8:
		case 9:
			return "sexta-feira";
		default:
			break;
		}

		return "placa não identificada";
	}

	public String weekDay(Calendar cal) {
		return new DateFormatSymbols().getWeekdays()[cal.get(Calendar.DAY_OF_WEEK)];

	}
	public void calcularRodizio(Veiculo veiculo) {
		if (weekDay(Calendar.getInstance()) == rodizioDoVeiculo(veiculo)) {
			veiculo.setRodizioAtivo(true);
		} else {
			veiculo.setRodizioAtivo(false);

		}
	}

}
