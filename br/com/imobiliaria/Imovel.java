package br.com.imobiliaria;

public class Imovel {
    
    //Atributos privados
    private final int id; 
    private final TipoImovel tipo; 
    private String endereco; 
    private String cidade; 
    private StatusImovel status; 
    private double area; 
    private int quantQuartos; 
    private int quantBanheiros; 
    private int vagasGaragem;

    //Construtor
    public Imovel(int id, TipoImovel tipo, String endereco, String cidade, StatusImovel status, double area, int quantQuartos, int quantBanheiros, int vagasGaragem) {

        //Validacao de status do imovel
        if(status == null){
            throw new IllegalArgumentException("Status inválido!");
        }

        if(tipo == null){
            throw new IllegalArgumentException("Tipo de imóvel inválido!");
        }

        if(endereco == null || endereco.isEmpty()){
            throw new IllegalArgumentException("Endereço inválido!");
        }

        if(cidade == null || cidade.isEmpty()){
            throw new IllegalArgumentException("Cidade inválida!");
        }

        if(area <=0){
            throw new IllegalArgumentException("Área deve ser maior que zero!");
        }

        this.id = id;
        this.tipo = tipo;
        this.endereco = endereco;
        this.cidade = cidade;
        this.status = status;
        this.area = area;
        this.quantQuartos = quantQuartos;
        this.quantBanheiros = quantBanheiros;
        this.vagasGaragem = vagasGaragem;
    }


    public int getId() {
        return id;
    }


    public TipoImovel getTipo() {
        return tipo;
    }


    public String getEndereco() {
        return endereco;
    }


    public void setEndereco(String endereco) {
        if(endereco == null || endereco.isEmpty()){
            throw new IllegalArgumentException("Endereço inválido!");
        }
        this.endereco = endereco;
    }


    public String getCidade() {
        return cidade;
    }


    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public StatusImovel getStatus() {
        return status;
    }


    public void setStatus(StatusImovel status) {
        if(status == null){
            throw new IllegalArgumentException("Status inválido!");
        }
        this.status = status;
    }


    public double getArea() {
        return area;
    }


    public void setArea(double area) {
        if(area <= 0){
            throw new IllegalArgumentException("Área inválida!");
        }
        this.area = area;
    }


    public int getQuantQuartos() {
        return quantQuartos;
    }


    public void setQuantQuartos(int quantQuartos) {
        this.quantQuartos = quantQuartos;
    }


    public int getQuantBanheiros() {
        return quantBanheiros;
    }


    public void setQuantBanheiros(int quantBanheiros) {
        this.quantBanheiros = quantBanheiros;
    }


    public int getVagasGaragem() {
        return vagasGaragem;
    }


    public void setVagasGaragem(int vagasGaragem) {
        this.vagasGaragem = vagasGaragem;
    } 

   @Override
   public String toString(){
    return String.format("ID: %d | %s | %s (%s) | Status: %s | %.2fm² | %dQ, %dB, %dV", id, tipo, endereco, cidade, status, area, quantQuartos, quantBanheiros, vagasGaragem);
   }


}
