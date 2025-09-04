# CRUD-JDBC

Um projeto Java completo que demonstra operações CRUD (Create, Read, Update, Delete) usando JDBC para conexão com banco de dados MySQL.

## 📋 Descrição

Este projeto implementa um sistema de gerenciamento de dados com múltiplas entidades (Funcionários, Alunos, Livros, Pedidos, Produtos e Usuários) utilizando Java JDBC para persistência em banco de dados MySQL. O sistema oferece uma interface de console interativa para gerenciar todas as entidades.

## 🚀 Tecnologias Utilizadas

- **Java 22** - Linguagem de programação
- **Maven** - Gerenciamento de dependências
- **MySQL** - Banco de dados
- **JDBC** - API para conexão com banco de dados
- **MySQL Connector/J 8.0.33** - Driver MySQL para Java

## 📁 Estrutura do Projeto

```
CRUD-JDBC/
├── pom.xml                          # Configuração Maven
├── README.md                        # Documentação do projeto
└── src/
    └── main/
        └── java/
            └── org/
                └── example/
                    ├── Main.java           # Classe principal com interface de console
                    ├── Conexao.java        # Classe de conexão com BD
                    ├── FuncionarioDAO.java # DAO para Funcionários
                    ├── AlunoDAO.java       # DAO para Alunos
                    ├── LivroDAO.java       # DAO para Livros
                    ├── PedidoDAO.java      # DAO para Pedidos
                    ├── ProdutoDAO.java     # DAO para Produtos
                    └── UsuarioDAO.java     # DAO para Usuários
```

## 🗄️ Entidades do Sistema

### 1. Funcionários
- **Campos**: nome, cargo, salario
- **Tabela**: `funcionarios`
- **Operações**: Inserir, Atualizar Salário, Deletar

### 2. Alunos
- **Campos**: nome, matricula, curso
- **Tabela**: `alunos`
- **Operações**: Inserir, Atualizar Curso, Deletar

### 3. Livros
- **Campos**: titulo, autor, ano_publicacao
- **Tabela**: `livros`
- **Operações**: Inserir, Atualizar Autor, Deletar

### 4. Pedidos
- **Campos**: cliente, data_pedido, total
- **Tabela**: `pedidos`
- **Operações**: Inserir, Atualizar Total, Deletar

### 5. Produtos
- **Campos**: nome, preco, quantidade
- **Tabela**: `produtos`
- **Operações**: Inserir, Atualizar Preço, Deletar

### 6. Usuários
- **Campos**: nome, email
- **Tabela**: `usuarios`
- **Operações**: Inserir, Atualizar Email, Deletar

## ⚙️ Configuração

### Pré-requisitos
- Java 22 instalado
- Maven instalado
- MySQL Server instalado e rodando
- IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

### Configuração do Banco de Dados
1. Crie um banco de dados MySQL chamado `MYSQLTESTE`
2. Configure as credenciais no arquivo `Conexao.java`:
   ```java
   private static final String USER = "root";
   private static final String SENHA = "sua_senha_aqui";
   ```

### Scripts SQL para Criação das Tabelas

```sql
-- Tabela de Funcionários
CREATE TABLE funcionarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cargo VARCHAR(50) NOT NULL,
    salario DECIMAL(10,2) NOT NULL
);

-- Tabela de Alunos
CREATE TABLE alunos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    matricula VARCHAR(20) NOT NULL,
    curso VARCHAR(50) NOT NULL
);

-- Tabela de Livros
CREATE TABLE livros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    ano_publicacao INT NOT NULL
);

-- Tabela de Pedidos
CREATE TABLE pedidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente VARCHAR(100) NOT NULL,
    data_pedido DATE NOT NULL,
    total DECIMAL(10,2) NOT NULL
);

-- Tabela de Produtos
CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    quantidade INT NOT NULL
);

-- Tabela de Usuários
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);
```

## 🏃‍♂️ Como Executar

### Via Maven
```bash
# Compilar o projeto
mvn compile

# Executar o projeto
mvn exec:java -Dexec.mainClass="org.example.Main"
```

### Via IDE
1. Abra o projeto na sua IDE
2. Execute a classe `Main.java`
3. Siga as instruções no console

## 📝 Funcionalidades Implementadas

### ✅ Operações Disponíveis
- **Inserção (CREATE)** - Implementada para todas as entidades
- **Atualização (UPDATE)** - Implementada para todas as entidades
- **Exclusão (DELETE)** - Implementada para todas as entidades
- **Interface de Console** - Menu interativo para todas as operações

### 🎯 Exemplo de Uso
O programa principal (`Main.java`) oferece um menu interativo que permite:

```java
// Exemplo de inserção de funcionário
FuncionarioDAO dao = new FuncionarioDAO();
dao.inserir("João Silva", "Desenvolvedor", 5000.00);

// Exemplo de atualização de salário
dao.atualizarSalario("João Silva", 5500.00);

// Exemplo de exclusão
dao.deletarFuncionario("João Silva");
```

## 🔧 Arquitetura

### Padrão DAO (Data Access Object)
O projeto utiliza o padrão DAO para separar a lógica de acesso aos dados:

- **`Conexao.java`**: Gerencia a conexão com o banco de dados
- **Classes DAO**: Implementam operações específicas para cada entidade
- **`Main.java`**: Interface de console que demonstra o uso das classes DAO

### Tratamento de Exceções
- Uso de `try-with-resources` para gerenciamento automático de conexões
- Tratamento de `SQLException` com `printStackTrace()`
- Validação de conexão antes de executar operações

### Interface de Usuário
- Menu principal com opções numeradas
- Submenus específicos para cada entidade
- Entrada de dados via console com validação
- Feedback visual para todas as operações

## 🚧 Melhorias Futuras

- [ ] Implementar operações de consulta (SELECT) com filtros
- [ ] Adicionar validação de dados mais robusta
- [ ] Implementar interface gráfica (Swing/JavaFX)
- [ ] Adicionar logs estruturados
- [ ] Implementar transações
- [ ] Adicionar testes unitários
- [ ] Implementar busca por ID
- [ ] Adicionar relatórios e estatísticas
- [ ] Implementar backup automático
- [ ] Adicionar autenticação de usuários

## 🎮 Como Usar o Sistema

1. **Iniciar o programa**: Execute `Main.java`
2. **Escolher entidade**: Selecione 1-6 para gerenciar diferentes entidades
3. **Escolher operação**: Para cada entidade, escolha entre:
   - 1: Inserir novo registro
   - 2: Atualizar campo específico
   - 3: Deletar registro
4. **Sair**: Digite 0 no menu principal

## 👨‍💻 Autor

Desenvolvido como projeto de estudo para demonstrar conceitos de JDBC e CRUD em Java.

## 📄 Licença

Este projeto é de uso educacional e pode ser utilizado livremente para fins de aprendizado.

## 🤝 Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para:
- Reportar bugs
- Sugerir novas funcionalidades
- Enviar pull requests
- Melhorar a documentação

---

**⭐ Se este projeto foi útil para você, considere dar uma estrela!**
