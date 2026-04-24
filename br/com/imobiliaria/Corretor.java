package br.com.imobiliaria;

public class Corretor {
    
    //Atributos privados
    private String nomeCorretor; 
    private final String creci; 
    private String telefoneCorretor;

    //Contrutor
    public Corretor(String nomeCorretor, String creci, String telefoneCorretor) {
        this.nomeCorretor = nomeCorretor;
        if(creci != null && creci.matches("\\d+") && (creci.length() == 4 || creci.length() == 6)){
            this.creci = creci;
        }
        else{
            throw new IllegalArgumentException("CRECI inválido");
        }

        setTelefoneCorretor(telefoneCorretor);
    }


    public String getNomeCorretor() {
        return nomeCorretor;
    }


    public void setNomeCorretor(String nomeCorretor) {
        this.nomeCorretor = nomeCorretor;
    }


    public String getCreci() {
        return creci;
    }


    public String getTelefoneCorretor() {
        return telefoneCorretor;
    }


    public void setTelefoneCorretor(String telefoneCorretor) {

        //Validacao de telefone do corretor
        if(telefoneCorretor != null && telefoneCorretor.matches("\\d{10,11}")){
            this.telefoneCorretor = telefoneCorretor;
        }
        else{
            throw new IllegalArgumentException("Telefone inválido");
        } 
    } 


    @Override
    public String toString(){
        return "====================" + "\n" + "Corretor: " + nomeCorretor + "\n" + "CRECI: " + creci + "\n" + telefoneCorretor;
    }
}
