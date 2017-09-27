# Gestão de Portfólio de projetos
Projeto de Gestão de portifólio de projetos - Intuito meramente acadêmico

## Principais tecnologias utilizadas
- Spring MVC 4
- Spring DATA
- Wildfly-10.1.0.Final
- PostgreSQL 
- Bootstrap 4

## API Rest para Pessoas
#### Buscar todas as pessoas
| Item | Descrição |
| ------ | ------ |
| Method | GET |
| Path | /api/pessoas/ |


#### Buscar uma pessoa por ID
| Item | Descrição |
| ------ | ------ |
| Method | GET |
| Path | /api/pessoas/{id} |

#### Cadastrar uma pessoa
| Item | Descrição |
| ------ | ------ |
| Method | POST |
| Path | /api/pessoas/ |
| Headers | Content-Type: application/json |
Exemplo Json - Body: 
```
	{
		"nome" : "Maria",
		"cpf" : "333.333.333-33",
		"funcionario" : "false"
	}
```

#### Alterar uma pessoa
| Item | Descrição |
| ------ | ------ |
| Method | PUT |
| Path | /api/pessoas/{id} |
Exemplo Json - Body: 
```
	{
		"nome" : "Nome Alterado"
	}
```

#### Excluir uma pessoa
| Item | Descrição |
| ------ | ------ |
| Method | DELETE |
| Path | /api/pessoas/{id} |
