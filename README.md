# Sistema de Controle de Almoxarifado

API REST desenvolvida para o gerenciamento de inventário e controle de empréstimos de ferramentas. O projeto foca na organização de dados e na aplicação de regras de negócio para monitorar a posse e a disponibilidade de itens em um estoque central.

## Descrição

A aplicação utiliza a arquitetura em camadas para organizar a lógica de persistência, serviço e exposição de endpoints. O sistema garante que cada movimentação de ferramenta seja validada antes de ser registrada no banco de dados.

## Funcionalidades

* Cadastro de Itens: Registro de ferramentas com trava contra nomes duplicados.
* Controle de Saída: Registro de empréstimo vinculado a um responsável, com validação de disponibilidade prévia.
* Registro de Retorno: Devolução de itens com atualização automática do status para disponível e remoção do responsável.
* Consulta por Responsável: Localização de todas as ferramentas associadas a um nome específico.

## Regras de Negócio

* Ferramentas são inicializadas como disponíveis e sem responsável no momento do cadastro.
* Não é permitido o cadastro de ferramentas com nomes já existentes no banco de dados.
* O sistema impede a saída de ferramentas que já constam como emprestadas.
* A devolução só é permitida para itens que possuam um responsável vinculado.

## Tecnologias

* Java 17+.
* Spring Boot.
* Spring Data JPA e Hibernate.
* MySQL.
* Lombok.
* Maven.

## Endpoints

* POST /ferramentas: Cadastrar nova ferramenta.
* PUT /ferramentas/emprestar: Registrar empréstimo (requer nome da ferramenta).
* PUT /ferramentas/devolucao: Registrar devolução (requer nome da ferramenta).
* GET /ferramentas/{responsavel}: Listar ferramentas por nome do responsável.
