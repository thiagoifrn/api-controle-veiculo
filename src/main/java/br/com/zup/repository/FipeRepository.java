package br.com.zup.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.zup.model.FipeResponse;

@FeignClient(value = "FipeRepository", url = "https://parallelum.com.br/fipe/api/v1/carros")
public interface FipeRepository {

	@RequestMapping(value = "/marcas/{marca}/modelos/{modelo}/anos/{ano}", method = RequestMethod.GET)
    FipeResponse getFipeResponse(
            @PathVariable("marca") String marca,
            @PathVariable("modelo") String modelo,
            @PathVariable("ano") String ano
    );
}
