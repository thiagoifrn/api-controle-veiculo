# thiagoifrn-api_rest_controle_veiculo
## Contexto
O projeto é uma API REST que faz o controle veículos de usuários e fornece 3 endpoints.

- cadastro de usuários, sendo obrigatórias as seguintes propriedades: nome, e-mail, CPF, e data de nascimento,
sendo que e-mail e CPF devem ser únicos.

- cadastro de veículos sendo obrigatórias as seguintes propriedades: Marca, Modelo do veículo e Ano e para conseguir o
valor desse veículo esse serviço consumiria a API da FIPE (https://deividfortuna.github.io/fipe/).

- retornar um usuário e a lista de veículo vinculado a esse usuário.

***Em essência serão três endpoints , cadastro de usuário, cadastro de veículo e listagem de veículo para um usuário específico***

## Tecnologias utilizadas
- Java 11
- Spring Boot Web
- Spring Data JPA
- Spring Starter Validation
- Spring Cloud OpenFeing)
- PostgreSql
- Spring Tools Suites
## Executar a Aplicação
Para executar a aplicação, faça um clone do projeto.

Tenha instalado e configurado o JDK 11.

## Banco de dados
Para acessar o Banco de dados PostgreSql, veja as configurações que estão em ***resources/application.properties***
Crie um banco com o nome api-control-veiculo, veja suas configurações e acesso (senha e usuário)
## Utilizando os endpoints
***POST*** em usuário:
``http://localhost:8080/usuarios``
Json Body:

    {
	"nome": "fakenilson da silva",
	"email": "fakenilson@fake.com",
	"cpf": "44565245785",
	"dataNacimento": "1984-02-20"
	}
Resposta:

    {
	"id": 1,
	"nome": "fakenilson da silva",
	"email": "fakenilson@fake.com",
	"cpf": "44565245785",
	"dataNacimento": "1984-02-20",
	"veiculos": null
	}
***POST*** em veículo:
``http://localhost:8080/veiculos``
Json Body:

    {
		"marca":"59",
		"modelo":"5940",
		"ano":"2016-3",
		"usuario":{
		"id":1
		}
	}
Resposta:

    {
	"id": 6,
	"marca": "59",
	"modelo": "5940",
	"ano": "2016-3",
	"valor": "R$ 127.571,00",
	"diaRodizio": "quinta-feira",
	"rodizioAtivo": false
	}
***GET*** em usuário:
``http://localhost:8080/usuarios/1``
Resposta:

    {
	"id": 1,
	"nome": "fakenilson da silva",
	"email": "fakenilson@fake.com",
	"cpf": "44565245785",
	"dataNacimento": "1984-02-20",
	"veiculos": [
			{
			"id": 4,
			"marca": "59",
			"modelo": "5940",
			"ano": "2016-3",
			"valor": "R$ 127.571,00",
			"diaRodizio": "quinta-feira",
			"rodizioAtivo": false
			}
		]	
	}
