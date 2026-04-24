# 📌 Sistema de Gestão Imobiliária (Java POO)

Este projeto é uma solução robusta desenvolvida em Java para gerenciar as operações principais de uma imobiliária, incluindo o cadastro de imóveis, clientes, corretores e o controle de contratos e pagamentos. O foco principal foi a aplicação prática de **Programação Orientada a Objetos** e a implementação de rigorosas **regras de negócio**.

## 🎯 Objetivo
O sistema resolve problemas reais de integridade de dados no setor imobiliário, automatizando a transição de status de imóveis e validando documentos críticos como CPF e CRECI, garantindo que o fluxo de venda e locação seja livre de erros operacionais.

## 🗂️ Estrutura do Projeto
O projeto está organizado para seguir boas práticas de separação de responsabilidades:
* `br.com.imobiliaria`: Contém as classes de domínio, Enums e toda a lógica de regras de negócio.
* `userinterface`: Contém a classe `Main.java`, responsável pela interação com o usuário via console.

## 🔑 Classes Principais e Validações

### 👤 Cliente & Corretor
* **CPF:** Validação obrigatória de exatamente 11 dígitos numéricos.
* **CRECI:** Validação de registro profissional (numérico de 4 ou 6 dígitos).
* **Telefone:** Padronização exigindo DDD (10 ou 11 dígitos).
* **Duplicidade:** O sistema impede o cadastro de clientes com o mesmo CPF.

### 🏠 Imóvel
* **Integridade:** Endereço, cidade, tipo e status não podem ser nulos ou vazios.
* **Medições:** Validação de área (sempre maior que zero).
* **Atributos:** Controle completo de ID, quartos, banheiros e vagas de garagem.

### 📜 Contrato & Pagamento
* **Regra de Negócio:** Um contrato só pode ser gerado se o imóvel estiver com o status `DISPONÍVEL`.
* **Automação de Status:** * Ao gerar contrato de **VENDA**, o imóvel muda automaticamente para `VENDIDO`.
    * Ao gerar contrato de **ALUGUEL**, o imóvel muda automaticamente para `ALUGADO`.
* **Financeiro:** Validação de pagamentos para que o valor pago não exceda o valor total do contrato.

## 🛠️ Tecnologias e Conceitos
* **Linguagem:** Java 21+ (Compilado com JDK 25).
* **POO:** Uso intenso de Encapsulamento, Coleções (Listas para busca por CPF/CRECI) e Composição de objetos.
* **Tratamento de Erros:** Uso de `try/catch` para capturar `IllegalArgumentException`, garantindo que o sistema não trave em caso de dados inválidos.
* **Enums:** Padronização total de `StatusImovel`, `TipoContrato`, `TipoImovel` e `FormaPagamento`.

---

## 🖥️ Interface (Menu Interativo)
O sistema conta com um menu via console que permite:
1.  **Cadastrar Imóvel**
2.  **Listar Imóveis**
3.  **Buscar Imóvel por ID**
4.  **Atualizar informações do Imóvel**
5.  **Cadastrar Cliente**
6.  **Cadastrar Corretor**
7.  **Gerar Contrato (Venda/Aluguel)**
8.  **Registrar Pagamento**
9.  **Sair do Sistema**

---

## 💻 Como Instalar e Rodar o Projeto

### Pré-requisitos
* **Java JDK 17** ou superior instalado (Recomendado 21+).
* **Git** instalado.
* Editor de código (Recomendado: **Visual Studio Code**).

### Passo a Passo

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/FabioKenzo/sistema-gestao-imobiliaria.git](https://github.com/FabioKenzo/sistema-gestao-imobiliaria.git)
    ```

2.  **Acesse a pasta do projeto:**
    ```bash
    cd sistema-gestao-imobiliaria
    ```

3.  **Execução:**
    * Abra o projeto no VS Code.
    * Certifique-se de que as extensões de Java estão ativas.
    * Execute a classe `Main.java`.

---

## 📈 Intuito Acadêmico
Projeto desenvolvido por **Fabio Kenzo Okamura** como parte do aprofundamento em Java POO.
