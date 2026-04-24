package br.com.imobiliaria;

public class Cliente {

    // Atributos privados
    private String nome;
    private final String cpf;
    private String telefone;
    private String email;

    // Contrutor
    public Cliente(String nome, String cpf, String telefone, String email) {
        this.nome = nome;

        // Validacao cpf
        if (cpf != null && cpf.matches("\\d{11}")) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF inválido");
        }

        setTelefone(telefone);
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone != null && telefone.matches("\\d{10,11}")) {
            this.telefone = telefone;
        } else {
            throw new IllegalArgumentException("ERRO: Telefone inválido! O número deve conter DDD + número");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "====================" + "\n" + "Cliente: " + nome + "\n" + "CPF: " + cpf + "\n" + "Telefone: "
                + telefone + "\n" + "Email: " + email;
    }

}
