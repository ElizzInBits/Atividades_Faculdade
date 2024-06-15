# Sistema de Cadastro de Clientes - StarDustBugs

## Descrição
Este sistema será projetado para ajudar a StarDustBugs, uma nova empresa de informática no mercado que está buscando desenvolver um sistema de cadastro robusto e eficiente para gerenciar as informações de seus clientes.

## Requisitos do Sistema

### Interface do Usuário
O sistema deve apresentar uma interface intuitiva e fácil de usar, com campos claramente marcados para a entrada das seguintes informações do cliente:
- E-mail
- CEP
- Celular
- Telefone
- Cidade
- RG
- CPF
- Endereço
- Complemento
- Número
- Bairro
- Estado

### Armazenamento de Dados
As informações inseridas devem ser armazenadas em um banco de dados.

### Visualização de Dados
O sistema deve permitir aos usuários visualizar todas as informações dos clientes registrados.

### Atualização de Dados
Deve haver uma funcionalidade que permita a atualização das informações dos clientes. Os usuários devem ser capazes de editar facilmente as informações do cliente quando necessário.

### Remoção de Clientes
O sistema deve permitir a remoção de clientes registrados do banco de dados.

## Requisitos Funcionais do Sistema de Cadastro da StarDust Bugs de acordo com a IA

### Entrada de Dados (R1)
O sistema deve fornecer uma interface intuitiva que permita aos usuários inserir informações de clientes. Esta interface deve incluir um formulário de cadastro com campos claramente marcados para cada tipo de informação necessária.

### Armazenamento de Dados (R2)
As informações inseridas pelos usuários devem ser armazenadas de forma segura e persistente em um banco de dados. Isso garante que os dados não sejam perdidos e possam ser recuperados quando necessário.

### Visualização de Registros (R3)
O sistema deve fornecer uma funcionalidade que permita aos usuários visualizar os registros de clientes de maneira organizada. Isso deve incluir a exibição de todos os campos cadastrados para cada cliente.

### Edição de Dados (R4)
Os usuários autorizados devem ser capazes de atualizar os dados dos clientes já cadastrados. O sistema deve fornecer uma interface que permita a modificação fácil e eficiente de qualquer informação do cliente.

### Exclusão de Registros (R5)
O sistema deve permitir a remoção segura de registros de clientes do banco de dados. Esta funcionalidade deve ser implementada com cuidado para evitar exclusões acidentais e garantir a integridade dos dados.

## Descrição Textual do Diagrama de Classes

### Classes do Sistema

#### Classe Clientes
- **Pacote:** br.com.sistema.model
- **Descrição:** Representa os clientes do sistema, encapsulando todas as informações relacionadas a um cliente.
  
- **Propriedades:**
  - id: Identificador único do cliente. (int)
  - nome: Nome completo do cliente. (String)
  - rg: Registro Geral do cliente. (String)
  - cpf: Cadastro de Pessoa Física do cliente. (String)
  - email: Endereço de e-mail do cliente. (String)
  - telefone: Número de telefone fixo do cliente. (String)
  - celular: Número de telefone celular do cliente. (String)
  - cep: Código de Endereçamento Postal do cliente. (String)
  - endereco: Endereço residencial do cliente. (String)
  - numero: Número do endereço residencial do cliente. (int)
  - complemento: Complemento do endereço do cliente. (String)
  - bairro: Bairro do endereço do cliente. (String)
  - cidade: Cidade do endereço do cliente. (String)
  - estado: Estado do endereço do cliente. (String)

- **Métodos:**
  - Getters e setters para cada propriedade, permitindo a manipulação dos dados de um cliente.

#### Classe ClientesDAO
- **Pacote:** br.com.sistema.dao
- **Descrição:** Interage com a base de dados para realizar operações CRUD (Create, Read, Update, Delete) relacionadas aos clientes.
  
- **Propriedades:**
  - conn: Conexão com o banco de dados. (Connection)
  
- **Métodos:**
  - Salvar(Clientes obj): Insere um novo cliente na tabela tb_clientes do banco de dados.
  - Editar(Clientes obj): Atualiza os dados de um cliente existente na tabela tb_clientes.
  - Excluir(Clientes obj): Remove um cliente da tabela tb_clientes com base no seu id.
  - buscarCliente(String nome): Busca e retorna um cliente pelo nome.
  - Listar(): Retorna uma lista com todos os clientes registrados.
  - Filtrar(String nome): Retorna uma lista de clientes que correspondem a um nome ou parte dele.
  - buscarClientesPorNome(String nome): Similar ao método Filtrar, busca clientes cujo nome contenha a string fornecida.
  
- **Relação com a classe Clientes:**
  - ClientesDAO utiliza a classe Clientes como parâmetro em seus métodos, criando e manipulando objetos Clientes para realizar operações no banco de dados.

#### Classe ConexaoBanco
- **Pacote:** br.com.sistema.jdbc
- **Descrição:** Gerencia a conexão com o banco de dados MySQL.
  
- **Propriedades:**
  - url: URL de conexão ao banco de dados. (String)
  - usuario: Nome de usuário para conexão ao banco de dados. (String)
  - senha: Senha para conexão ao banco de dados. (String)
  
- **Métodos:**
  - pegarConexao(): Estabelece e retorna uma conexão com o banco de dados.

- **Relação com a classe ClientesDAO:**
  - ClientesDAO depende de ConexaoBanco para obter a conexão necessária para realizar operações no banco de dados.

#### Classe TestarConexao
- **Pacote:** br.com.sistema.jdbc
- **Descrição:** Classe utilizada para testar a conexão com o banco de dados.
  
- **Métodos:**
  - main(String[] args): Método principal que tenta conectar ao banco de dados por um número definido de tentativas, exibindo mensagens de sucesso ou falha.
  
- **Relação com a classe ConexaoBanco:**
  - TestarConexao usa ConexaoBanco para tentar estabelecer uma conexão com o banco de dados.

#### Classe LoggerErroUtil
- **Pacote:** br.com.sistema.utilitarios
- **Descrição:** Configura e utiliza um logger para registrar erros ocorridos no sistema.
  
- **Propriedades:**
  - logger: Instância do Logger do Java Util Logging para gerenciar os registros de erro.
  
- **Métodos:**
  - log(String message): Registra uma mensagem de erro no nível SEVERE no arquivo de log.
  - log(String message, Throwable throwable): Registra uma mensagem de erro junto com a exceção lançada no arquivo de log.

- **Funcionamento:**
  - O logger é configurado para escrever registros no arquivo C:\\Users\\eliza\\OneDrive\\Documentos\\Curso de Java\\sistema estoque\\logs_erro\\erros.log.
  - Utiliza FileHandler para gerenciar a escrita no arquivo de log.
  - Define o formato de saída das mensagens de log com SimpleFormatter.
  - Nível de log configurado para Level.ALL, o que inclui todos os níveis de severidade de log.

- **Utilização:**
  - Pode ser invocado por outras partes do sistema para registrar erros de maneira padronizada e persistente.

### Relações entre as Classes

#### Dependência entre ClientesDAO e ConexaoBanco:
ClientesDAO depende de ConexaoBanco para obter a conexão com o banco de dados necessária para realizar operações CRUD relacionadas aos clientes.

#### Utilização de LoggerErroUtil por ClientesDAO:
LoggerErroUtil pode ser utilizado dentro de ClientesDAO para registrar erros relacionados às operações de banco de dados, facilitando a depuração e rastreamento de problemas.

#### Utilização de ConexaoBanco por TestarConexao:
TestarConexao utiliza ConexaoBanco para testar e verificar a conexão com o banco de dados, garantindo que a aplicação possa se conectar corretamente durante sua execução.


## Observações

Este projeto foi desenvolvido pelos alunos Elizabeth Guimarães e Gabriel Martins como parte de um trabalho da faculdade, na disciplina de Programação de Soluções Computacionais, sob orientação dos professores Otaviano Silverio e Alexandre de Oliveira. O foco foi na simplicidade e eficiência, garantindo uma interface amigável para os usuários e robustez na manipulação e armazenamento dos dados dos clientes.


