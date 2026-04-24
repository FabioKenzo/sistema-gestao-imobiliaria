package br.com.imobiliaria;

import java.time.LocalDate;

public class Contrato {
    
private final int idContrato; 
private Cliente cliente; 
private Imovel imovel; 
private Corretor corretor; 
private TipoContrato tipoContrato; 
private double valor; 
private LocalDate data;


public Contrato(int idContrato, Cliente cliente, Imovel imovel, Corretor corretor, TipoContrato tipoContrato, double valor, LocalDate data) {
    

    if(cliente == null || imovel == null || corretor == null){
        throw new IllegalArgumentException("Dados inválidos!");
    }
    
    if(valor <= 0){
        throw new IllegalArgumentException("Valor deve ser maior que zero!");
    }

    if(tipoContrato == null){
        throw new IllegalArgumentException("Tipo de contrato inválido!");

    }

    if(data == null){
        throw new IllegalArgumentException("Data inválida!");
    }

    //regras de negocio
    if(imovel.getStatus() != StatusImovel.DISPONIVEL){
        throw new IllegalArgumentException("Imóvel indisponível!");
    }

    if(tipoContrato == TipoContrato.VENDA){
        imovel.setStatus(StatusImovel.VENDIDO);
    }
    else{
        imovel.setStatus(StatusImovel.ALUGADO);
    }
    
    
    this.idContrato = idContrato;
    this.cliente = cliente;
    this.imovel = imovel;
    this.corretor = corretor;
    this.tipoContrato = tipoContrato;
    this.valor = valor;
    this.data = data;
}


public int getIdContrato() {
    return idContrato;
}


public Cliente getCliente() {
    return cliente;
}


public Imovel getImovel() {
    return imovel;
}


public Corretor getCorretor() {
    return corretor;
}


public TipoContrato getTipoContrato() {
    return tipoContrato;
}


public double getValor() {
    return valor;
}


public LocalDate getData() {
    return data;
}



@Override
public String toString() {
    return String.format(
        "====================\n" +"ID do contrato: %d\n" +"Cliente: %s\n" +"Imóvel: %s\n" +"Corretor: %s\n" +"Tipo de contrato: %s\n" +"Valor: R$ %.2f\n" + "Data: %s",
        idContrato,  cliente.getNome(), imovel,  corretor.getNomeCorretor(), tipoContrato,  valor, data);
}


}
