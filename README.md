# 📌 Projeto: Sistema de Imobiliária (Java POO)

## 🎯 Objetivo
Sistema de gerenciamento de imobiliária com cadastro de imóveis, clientes, corretores, contratos e pagamentos. Inclui regras de negócio e validações para garantir integridade dos dados.

---

## 🗂️ Estrutura de Pastas
- **br.com.imobiliaria** → Classes de domínio e regras de negócio  
- **userinterface** → Interface de interação via console (classe Main)

---

## 🔑 Classes Principais e Validações

### 👤 Cliente
**Validações:**
- CPF deve conter exatamente 11 dígitos numéricos.  
- Telefone deve conter 10 ou 11 dígitos (DDD + número).  

**Atributos:** nome, cpf, telefone, email.

---

### 🧑‍💼 Corretor
**Validações:**
- CRECI deve ser numérico e ter 4 ou 6 dígitos.  
- Telefone deve conter 10 ou 11 dígitos.  

**Atributos:** nomeCorretor, creci, telefoneCorretor.

---

### 🏠 Imóvel
**Validações:**
- Tipo e Status não podem ser nulos.  
- Endereço e cidade não podem ser nulos ou vazios.  
- Área deve ser maior que zero.  

**Atributos:** id, tipo, endereço, cidade, status, área, quartos, banheiros, vagas.

---

### 📄 Contrato
**Validações:**
- Cliente, imóvel, corretor e tipoContrato não podem ser nulos.  
- Valor deve ser maior que zero.  
- Data não pode ser nula.  
- Imóvel deve estar **DISPONÍVEL** para gerar contrato.  

**Regras de negócio:**
- Se contrato for **VENDA**, imóvel passa para **VENDIDO**.  
- Se contrato for **ALUGUEL**, imóvel passa para **ALUGADO**.  

---

### 💳 Pagamento
**Validações:**
- Contrato não pode ser nulo.  
- Valor pago deve ser maior que zero e não pode exceder o valor do contrato.  
- Data e forma de pagamento não podem ser nulos.  

**Atributos:** contrato, valorPago, dataPagamento, formaPagamento.

---

### 🏢 Imobiliária
**Funcionalidades:**
- Cadastro de imóveis, clientes, corretores e contratos.  
- Busca de clientes por CPF, corretores por CRECI e imóveis por ID.  
- Registro de pagamentos vinculados a contratos.  
- Listagem de imóveis cadastrados.  

**Validações extras:**
- Impede cadastro de cliente duplicado pelo CPF.  
- Impede registro de pagamento inválido.  

---

## 📚 Enums
- **StatusImovel:** DISPONIVEL, VENDIDO, ALUGADO  
- **TipoContrato:** VENDA, ALUGUEL  
- **TipoImovel:** CASA, APARTAMENTO, TERRENO  
- **FormaPagamento:** PIX, BOLETO, CARTAO, DINHEIRO  

---

## 🖥️ Interface (Main.java)
Menu interativo via console com opções:
- Cadastrar Imóvel  
- Listar Imóveis  
- Buscar Imóvel por ID  
- Atualizar informações do Imóvel  
- Cadastrar Cliente  
- Cadastrar Corretor  
- Gerar Contrato (Venda/Aluguel)  
- Registrar Pagamento  
- Sair do Sistema  

**Tratamento de erros:**
- Uso de `try/catch` para capturar `IllegalArgumentException`.  
- Mensagens claras de sucesso ou erro para o usuário.

---

## 🎓 Intuito Acadêmico

Este projeto foi desenvolvido por **Fabio Kenzo Okamura** como parte de um plano estratégico de aprofundamento técnico em:
- **Java (POO)** e boas práticas de modelagem.  
- **Aplicação de conceitos de herança, polimorfismo e encapsulamento**.  
- **Estruturação de sistemas orientados a objetos**.  

---

## 👨‍💻 Autor

**Fábio Kenzo Okamura**  
Graduando em Análise e Desenvolvimento de Sistemas (ADS) - **UNITAU**.  
Foco em Desenvolvimento Backend e Programação Orientada a Objetos.

