package br.com.imobiliaria;
import java.time.LocalDate;
public class Pagamento {
    
    private final Contrato contrato; 
    private final double valorPago; 
    private final LocalDate dataPagamento; 
    private final FormaPagamento formaPagamento;


    public Pagamento(Contrato contrato, double valorPago, LocalDate dataPagamento, FormaPagamento formaPagamento) {
        
        if(contrato == null){
            throw new IllegalArgumentException("Contrato inválido!");
        }

        if(valorPago <= 0){
            throw new IllegalArgumentException("Valor pago deve ser maior que zero!");
        }

        if(valorPago > contrato.getValor()){
            throw new IllegalArgumentException("Valor pago maior que o valor do contrato!");
        }

        if(dataPagamento == null){
            throw new IllegalArgumentException("Data de pagamento inválida!");
        }

        if(formaPagamento == null){
            throw new IllegalArgumentException("Forma de pagamento inválida!");
        }

        this.contrato = contrato;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.formaPagamento = formaPagamento;
    }


    public Contrato getContrato() {
        return contrato;
    }


    public double getValorPago() {
        return valorPago;
    }


    public LocalDate getDataPagamento() {
        return dataPagamento;
    }


    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }


    @Override
    public String toString(){
        return String.format("====================\n" + "Contrato ID: %d\n" + "Valor Pago: R$ %.2f\n" + "Data: %s\n" +" Forma de Pagamento: %s", contrato.getIdContrato(), 
        valorPago, dataPagamento, formaPagamento);
    }




}
