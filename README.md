# Sistema Automotivo – Gestão de Estoque de Veículos

Projeto acadêmico de CRUD orientado a objetos com Java 17, Spring Boot, Spring Data JPA e MySQL.

## Requisitos
- Java JDK 17 ou superior
- Maven 3.8+
- MySQL 8+

## Como executar
1. Crie o banco: execute `database/schema.sql` no MySQL Workbench (ou deixe o Hibernate criar o banco se o usuário tiver permissão).
2. Ajuste usuário e senha em `src/main/resources/application.properties`, ou defina `DB_URL`, `DB_USER` e `DB_PASSWORD`.
3. Na pasta do projeto, execute: `mvn spring-boot:run`.
4. A API ficará disponível em `http://localhost:8080`.

## Endpoints principais
| Método | Caminho | Função |
|---|---|---|
| POST | `/api/marcas` | Cadastrar marca |
| GET | `/api/marcas` | Listar marcas |
| DELETE | `/api/marcas/{id}` | Excluir marca |
| POST | `/api/modelos` | Cadastrar modelo vinculado à marca |
| GET | `/api/modelos` | Listar modelos |
| DELETE | `/api/modelos/{id}` | Excluir modelo |
| POST | `/api/veiculos` | Cadastrar veículo |
| GET | `/api/veiculos` | Listar veículos |
| GET | `/api/veiculos/{id}` | Consultar um veículo |
| PUT | `/api/veiculos/{id}` | Atualizar veículo |
| DELETE | `/api/veiculos/{id}` | Remover veículo |

## Exemplos com JSON

Cadastrar marca:
```json
{"nome":"Toyota"}
```
Cadastrar modelo (use o id retornado ao cadastrar a marca):
```json
{"nome":"Corolla","marcaId":1}
```
Cadastrar veículo (use o id retornado ao cadastrar o modelo):
```json
{"modeloId":1,"ano":2022,"cor":"Prata","preco":115000.00,"quilometragem":35000,"status":"DISPONIVEL"}
```
Atualizar veículo: envie o mesmo formato para `PUT /api/veiculos/1`.

Filtrar:
- `GET /api/veiculos?marca=Toyota`
- `GET /api/veiculos?modelo=Corolla&ano=2022`
- `GET /api/veiculos?precoMin=50000&precoMax=150000`
- `GET /api/veiculos?status=DISPONIVEL`

Status permitidos: `DISPONIVEL`, `RESERVADO`, `VENDIDO`, `DESCONTINUADO`.

## Organização
- `model`: entidades persistidas (Marca, Modelo, Veiculo) e enumeração de status.
- `repository`: acesso ao banco por Spring Data JPA.
- `service`: regras de negócio.
- `controller`: endpoints REST.
- `dto`: dados recebidos para cadastro/edição e validação.
- `database`: script SQL de criação do banco e tabelas.

## Observação acadêmica
O projeto implementa a API e a persistência. Não inclui interface gráfica/front-end, pois o enunciado classifica essa integração como opcional. Antes da entrega, execute localmente, valide os endpoints e capture seus próprios prints para comprovar a execução real.
