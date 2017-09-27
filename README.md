# Gestão de Portfólio de projetos
Projeto de Gestão de portifólio de projetos - Intuito meramente acadêmico

## Tecnologias utilizadas
- Spring MVC 4
- Spring DATA

## API Rest para Pessoas
- Buscar todas as pessoas
|Method|GET|
|Path|/api/pessoas/|

- Buscar uma pessoa por ID
|Method|GET|
|Path|/api/pessoas/{id}|

- Cadastrar uma pessoa
|Method|POST|
|Path|/api/pessoas/|
|Headers|Content-Type: application/json|
Exemplo Json - Body: 
```
	{
		"nome" : "Maria",
		"cpf" : "333.333.333-33",
		"funcionario" : "false"
	}
```

- Alterar uma pessoa
|Method|PUT|
|Path|/api/pessoas/{id}|
Exemplo Json - Body: 
```
	{
		"nome" : "Nome Alterado"
	}
```

- Excluir uma pessoa
|Method|DELETE|
|Path|/api/pessoas/{id}|

