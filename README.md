# PicPay Challenge

API REST desenvolvida em Java com Spring Boot para simular transferências de dinheiro entre usuários, inspirada no desafio técnico do PicPay.

## 📋 Descrição

Este projeto implementa uma API de pagamentos simplificada que permite:
- Cadastro de usuários (comum e lojista)
- Transferências de dinheiro entre carteiras
- Validação de saldo e tipo de usuário
- Integração com serviços externos de autorização e notificação

### Regras de Negócio

- Usuários do tipo **USER** podem enviar e receber transferências
- Usuários do tipo **MERCHANT** (lojista) apenas recebem transferências
- Antes de finalizar a transferência, é consultado um serviço externo de autorização
- Após a transferência, é enviada uma notificação ao recebedor

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.9**
- **Spring Data JPA** - Persistência de dados
- **Spring Cloud OpenFeign** - Cliente HTTP declarativo
- **Bean Validation** - Validação de dados
- **MySQL** - Banco de dados
- **Docker** - Containerização do banco de dados
- **Maven** - Gerenciamento de dependências

## 📁 Estrutura do Projeto

```
src/main/java/matalvesdev/picpay_challenge/
├── PicpayChallengeApplication.java  # Classe principal
├── client/                          # Clientes Feign para APIs externas
│   ├── AuthorizationClient.java
│   ├── NotificationClient.java
│   └── dto/
├── config/                          # Configurações da aplicação
├── controller/                      # Controllers REST
│   ├── TransferController.java
│   ├── WalletController.java
│   ├── RestExceptionHandler.java
│   └── dto/
│       ├── TransferDto.java
│       └── WalletDto.java
├── entities/                        # Entidades JPA
│   ├── Transfer.java
│   ├── WalletEntity.java
│   └── WalletType.java
├── exceptions/                      # Exceções customizadas
├── repository/                      # Repositórios JPA
└── service/                         # Camada de serviços
    ├── AuthorizationService.java
    ├── NotificationService.java
    ├── TransferService.java
    └── WalletService.java
```

## ⚙️ Pré-requisitos

- Java 21+
- Docker e Docker Compose
- Maven 3.8+

## 🔧 Instalação e Execução

### 1. Clone o repositório

```bash
git clone https://github.com/matalvesdev/picpay-challenge.git
cd picpay-challenge
```

### 2. Inicie o banco de dados MySQL

```bash
cd docker
docker-compose up -d
```

### 3. Execute a aplicação

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`

## 📡 Endpoints da API

### Criar Carteira

```http
POST /wallets
Content-Type: application/json

{
    "fullName": "João Silva",
    "cpfCnpj": "12345678900",
    "email": "joao@email.com",
    "password": "senha123",
    "walletEntityType": "USER"
}
```

**Tipos de carteira disponíveis:**
- `USER` - Usuário comum (pode enviar e receber transferências)
- `MERCHANT` - Lojista (apenas recebe transferências)

### Realizar Transferência

```http
POST /transfer
Content-Type: application/json

{
    "value": 100.00,
    "payer": 1,
    "payee": 2
}
```

**Parâmetros:**
- `value`: Valor da transferência (mínimo: 0.01)
- `payer`: ID da carteira que envia o dinheiro
- `payee`: ID da carteira que recebe o dinheiro

## 🗃️ Configuração do Banco de Dados

O arquivo `docker/docker-compose.yml` configura um container MySQL com as seguintes credenciais:

| Parâmetro | Valor |
|-----------|-------|
| Host | localhost |
| Porta | 3306 |
| Database | picpaydb |
| Usuário | admin |
| Senha | 123 |

## 🧪 Executar Testes

```bash
./mvnw test
```

## 📝 Variáveis de Ambiente

| Variável | Descrição | Valor Padrão |
|----------|-----------|--------------|
| `MYSQL_HOST` | Host do banco de dados MySQL | localhost |

## 👨‍💻 Autor

Desenvolvido por [matalvesdev](https://github.com/matalvesdev)

---

⭐ Este projeto foi desenvolvido como parte de um desafio técnico.
