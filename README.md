# 🏥 API de Gestão de Beneficiários (Plano de Saúde)

Esta é uma API REST completa desenvolvida para o gerenciamento de beneficiários e seus respectivos documentos, focada em boas práticas de desenvolvimento Java e Spring Boot.

## 🚀 Tecnologias Utilizadas
- **Java 17** (Linguagem principal)
- **Spring Boot 3** (Framework)
- **Spring Data JPA** (Persistência de dados)
- **H2 Database** (Banco de dados em memória para testes rápidos)
- **Maven** (Gerenciador de dependências)
- **Swagger/OpenAPI 3** (Documentação interativa)
- **Jakarta Validation** (Validação de dados)

## 🛠️ Funcionalidades Implementadas
- **CRUD Completo de Beneficiários**: Cadastro, listagem, atualização e exclusão.
- **Relacionamento One-to-Many**: Cada beneficiário pode possuir múltiplos documentos vinculados.
- **Auditoria Automática**: Controle de data de inclusão e data da última atualização.
- **DTO Pattern**: Implementação de Records para transferência de dados, garantindo imutabilidade e segurança.
- **Tratamento de Datas**: Uso correto de `LocalDate` para nascimento e `LocalDateTime` para registros de sistema.

## 🚦 Como Executar o Projeto
1. Clone este repositório:
   ```bash
   git clone [https://github.com/SEU_USUARIO/api-gestao-beneficiarios.git](https://github.com/SEU_USUARIO/api-gestao-beneficiarios.git)
