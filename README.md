# Cadastro de Funcionários e Departamentos

Este projeto é uma **API REST** desenvolvida em **Java** utilizando o framework **Spring Boot**. Ele permite o gerenciamento de **funcionários, departamentos** e seus respectivos **endereços**. A aplicação utiliza **JPA** para persistência de dados e está configurada para expor **endpoints** que podem ser consumidos via **Swagger**.

---

## 🔧 Funcionalidades

### **Gerenciamento de Funcionários**
- Criar, buscar, atualizar e deletar funcionários.
- Associar funcionários a departamentos.
- Associar endereços a funcionários.

### **Gerenciamento de Departamentos**
- Criar, buscar, atualizar e deletar departamentos.
- Listar funcionários associados a um departamento.

### **Gerenciamento de Endereços**
- Associar endereços a funcionários.
- Buscar endereços vinculados a funcionários.

---

## 💡 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Spring Web**
- **Spring Validation**
- **Jakarta Persistence API**
- **H2 Database** (banco de dados em memória para desenvolvimento e testes)
- **Swagger/OpenAPI** (documentação e teste de endpoints)
- **Maven** (gerenciador de dependências)
- **PostgresSql** (Conexão em um Banco de Dados Local)

---

## 🛠️ Estrutura do Projeto

```
/cadastro-funcionarios
├── src
│   ├── main
│   │   ├── java/me/dio
│   │   │   ├── model/     # Modelos (entidades JPA)
│   │   │   ├── repository/ # Repositórios (Spring Data JPA)
│   │   │   ├── service/    # Serviços (lógica de negócio)
│   │   │   ├── controller/ # Controladores (endpoints REST)
│   ├── resources
│   │   ├── application.properties # Configurações do Spring Boot

```

---

## 🛡️ Endpoints Disponíveis

### **Funcionários**
- `POST /funcionarios` - Criar um novo funcionário.
- `GET /funcionarios/{id}` - Buscar um funcionário pelo ID.
- `DELETE /funcionarios/{id}` - Deletar um funcionário pelo ID.(Ainda será Implementado)
- `UPDATE /funcionarios/{id}` - Atualizar um funcionário pelo ID.(Ainda será Implementado)

### **Departamentos**
- `POST /departamentos` - Criar um novo departamento.
- `GET /departamentos/{id}` - Buscar um departamento pelo ID.
- `GET /departamentos/{id}/funcionarios` - Listar os funcionários associados a um departamento. (Ainda Será Implementado

### **Endereços**
- Associado automaticamente ao criar ou atualizar um funcionário.

---

## 🏦 Configuração do Banco de Dados

O projeto utiliza o **banco de dados em memória H2** para facilitar o desenvolvimento e os testes. As configurações estão no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:funcionariosdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
```

O projeto também utiliza o **banco de dados PostgresSql** para o desenvolvimento e os testes. As configurações estão no arquivo `application.properties`:
```properties
spring.datasource.url=jdbc\:postgresql\://localhost\:Porta/seu_db
spring.datasource.username=username
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
spring.datasource.password=password
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.open-in-view=false
spring.jpa.hibernate.ddl-auto=create-drop

```

Para acessar o console do H2, use o seguinte URL após iniciar a aplicação:

```
http://localhost:8080/h2-console
```

---

## 🌐 Como Executar o Projeto

### **🔎 Pré-requisitos**

- Java 17 ou superior.
- Maven instalado.

### **🔧 Clonar o Repositório**

```bash
git clone https://github.com/seu-usuario/cadastro-funcionarios.git
cd cadastro-funcionarios
```

### **🛠️ Compilar e Executar**

```bash
mvn spring-boot:run
```

### **🌐 Acessar o Swagger**

Após iniciar a aplicação, acesse o Swagger para testar os endpoints:

```
http://localhost:8080/swagger-ui/index.html
```

---

## 📊 Exemplos de JSON para Testes

### **Criar Funcionário**
```json
{
  "nome": "João Silva",
  "cargo": "Desenvolvedor Back-end",
  "salario": 7500,
  "departamento": {
    "id": 1
  },
  "endereco": {
    "rua": "Rua das Palmeiras",
    "numero": "123",
    "bairro": "Centro",
    "cidade": "São Paulo",
    "estado": "SP",
    "cep": "01010-000"
  }
}
```

### **Criar Departamento**
```json
{
  "nome": "Tecnologia"
}
```

---

## 🛑 Tratamento de Exceções

O projeto utiliza um **manipulador global** para tratar exceções e retornar mensagens amigáveis ao cliente.

**Exemplo de resposta para recurso não encontrado:**
```json
{
  "timestamp": "2024-03-20T14:30:00",
  "status": 404,
  "error": "Not Found",
  "message": "Funcionário não encontrado",
  "path": "/funcionarios/99"
}
```

---

## 🌟 Melhorias Futuras

- Implementar **autenticação e autorização** com **Spring Security**.
- Adicionar **paginação e ordenação** nos endpoints de listagem.
- Criar **testes unitários e de integração** para garantir a qualidade do código.

---

## 👨‍💼 Autor

Projeto desenvolvido por **[Caliel Passos]**.

- 📧 E-mail: [caliel1023@yahoo.com]
- 👤 GitHub: [https://github.com/vinicaliel]


---

