package br.com.imobiliaria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Imobiliaria {

    private List<Imovel> listaImoveis;
    private List<Cliente> listaClientes;
    private List<Contrato> listaContratos;
    private List<Corretor> listaCorretores;
    private List<Pagamento> listaPagamento;

    public Imobiliaria() {
        this.listaImoveis = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaContratos = new ArrayList<>();
        this.listaCorretores = new ArrayList<>();
        this.listaPagamento = new ArrayList<>();
    }

    // Metodo para cadastro imovel
    public void cadastrarImovel(Imovel imovel) {
        if (imovel != null) {
            listaImoveis.add(imovel);
            System.out.println("Imóvel cadastrado com sucesso!");
        } else {
            System.out.println("ERRO: Não foi possível cadastrar o imóvel!");
        }
    }

    // Metodo para cadastro do cliente
    public void cadastrarCliente(Cliente cliente) {
        if (cliente == null){   //Guard Clause se o objeto cliente estiver vazio para o metodo de imediato
            return;
    }

        Cliente encontrado = buscarClientePorCpf(cliente.getCpf());

        if (encontrado != null) {
            System.out.println("ERRO: Já existe um cliente com o CPF " + cliente.getCpf());
        } else {
            listaClientes.add(cliente);
            System.out.println("Cliente cadastrado: " + cliente.getNome());
        }
    }

    // Metodo para cadastro de corretores
    public void cadastrarCorretor(Corretor corretor) {
        if (corretor != null) {
            listaCorretores.add(corretor);
            System.out.println("Corretor cadastrado: " + corretor.getNomeCorretor());
        }
    }

    // Metodo para cadastro do contrato
    public void cadastrarContrato(Contrato contrato) {
        if (contrato != null) {
            listaContratos.add(contrato);
            System.out.println("Contrato cadastrado com sucesso!");
        }
    }


    //Metodo para buscar contrato por id
    public Contrato buscarContratoPorID(int id){
        for(Contrato c : listaContratos){
            if(c.getIdContrato() == id){
                return c;
            }
        }
        return null;
    }


    //Garante que um contrato de venda so seja finalizado se tiver um pagamento vinculado 
    public void registrarPagamento(int idContrato, double valor, FormaPagamento forma){
        Contrato c = buscarContratoPorID(idContrato);

        if(c != null){
            try{
                Pagamento p = new Pagamento(c, valor, LocalDate.now(), forma);
                listaPagamento.add(p);
                System.out.println("Pagamento de R$" + valor + " registrado no contrato " + idContrato);

            }catch(IllegalArgumentException e){
                System.out.println("ERRO ao registrar pagamento: " + e.getMessage()); 
            }
        }
        else{
            System.out.println("ERRO: Contrato não encontrado!");
        }
    }


    // Metodo para listar
    public void listarImoveis() {
        System.out.println("===== Lista de Imóveis =====");

        for (Imovel i : listaImoveis) {
            System.out.println(i); // Chama o toString criado no imovel
        }
    }

    // Metodo para buscar imovel pelo id
    public Imovel buscarImovelPorId(int idProcurado) {

        for (Imovel imovel : listaImoveis) {
            if (imovel.getId() == idProcurado) {
                return imovel;
            }
        }

        System.out.println("Imóvel não encontrado!");
        return null;

    }

    // Metodo buscar cliente por cpf
    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente c : listaClientes) {
            if (c.getCpf().equals(cpf)) {
                return c; // encontrou o objeto cliente
            }
        }
        return null; // nao encontrou o objeto
    }

    // Metodo buscar corretor pelo creci
    public Corretor buscarCorretorPorCreci(String creci) {
        for (Corretor cor : listaCorretores) {
            if (cor.getCreci().equals(creci))
                return cor; // encontrou o objeto corretor
        }
        return null; // nao encontrou o objeto
    }

}
