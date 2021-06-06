package br.com.zup.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FipeResponse {

	    @JsonProperty("Valor")
	    private String valor;

	    public FipeResponse() {
	    }

	    public FipeResponse(String valor) {
	        this.valor = valor;
	    }

	    public String getValor() {
	        return valor;
	    }

	    public void setValor(String valor) {
	        this.valor = valor;
	    }

}
