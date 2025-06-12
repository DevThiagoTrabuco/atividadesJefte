# Geriatricare

[![Java](https://img.shields.io/badge/Java-23-blue?logo=java)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.0-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)
[![Build](https://img.shields.io/badge/build-passing-brightgreen)]()
[![Status](https://img.shields.io/badge/status-em%20desenvolvimento-orange)]()

Sistema de gerenciamento de ILPIs (Instituições de Longa Permanência para Idosos), desenvolvido como parte da disciplina de Desenvolvimento de Sistemas. O sistema tem como principal objetivo facilitar o controle interno das instituições e oferecer acesso a informações dos pacientes para os familiares por meio de uma API RESTful.

## 🧭 Objetivo

O Geriatricare busca centralizar a administração das ILPIs e permitir que familiares tenham acesso a dados relevantes sobre seus entes internados, promovendo transparência, organização e praticidade.

## 🛠️ Tecnologias Utilizadas

- Java 23
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Validation
- MySQL (produção)
- Maven
- Lombok

## 🧱 Arquitetura

O sistema segue o padrão **N-Layer Architecture**, com as seguintes camadas:

- `models & entities`: entidades, repositórios e modelos de domínio
- `service`: serviços e lógica de negócio
- `repository`: configurações de banco de dados, segurança, etc.
- `controller`: controladores REST

Validações de domínio (como e-mail, telefone, CNPJ, senha etc.) são realizadas diretamente nas Models através de classes de `commons`, garantindo consistência e separação de responsabilidades.

## 👨‍👩‍👧‍👦 Funcionalidades

- Cadastro e autenticação de administradores e clientes
- Criação e gerenciamento de ILPIs por clientes
- Cadastro e controle de pacientes
- Cadastro de familiares com acesso restrito aos dados de seus parentes
- Gerenciamento de medicamentos, funcionários e outras entidades ligadas à ILPI
- API REST estruturada e validada para integração futura com um aplicativo móvel

## 👥 Autores

- [Thiago Trabuco](https://github.com/DevThiagoTrabuco)
- [Ismael Silva](https://github.com/AkiraNim)

## 📄 Licença

Este projeto está licenciado sob a Licença MIT. Consulte o arquivo [`LICENSE`](LICENSE) para mais informações.
