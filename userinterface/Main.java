package userinterface;

import java.time.LocalDate;
import java.util.Scanner;

import br.com.imobiliaria.*;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Imobiliaria imobiliaria = new Imobiliaria();
        int opcao = 0;

        System.out.println("Seja bem vindo ao sistema de imóveis!");

        do {

            System.out.println("========== Menu Imobiliária ==========");
            System.out.println("1 - Cadastrar Imóvel");
            System.out.println("2 - Listar Imóvel");
            System.out.println("3 - Buscar Imóvel por ID");
            System.out.println("4 - Atualizar Informações");
            System.out.println("5 - Cadastrar Cliente: ");
            System.out.println("6 - Cadastrar Corretor");
            System.out.println("7 - Gerar Contrato (Venda / Aluguel)");
            System.out.println("8 - Registrar Pagamento");
            System.out.println("9 - Sair do Sistema");

            opcao = teclado.nextInt();
            teclado.nextLine(); //limpando o queridao do buffer

            switch (opcao) {
                case 1:
                    System.out.println("Cadastrando um novo Imóvel");
                    System.out.println("--------------------------");

                    System.out.println("ID do imóvel: ");
                    int id = teclado.nextInt();
                    teclado.nextLine(); // limpando buffer

                    System.out.println("Tipo do imóvel (casa, apartamento, terreno) ");
                    String entradaTipo = teclado.next().toUpperCase();
                    teclado.nextLine(); // limpando o buffer

                    // Converte a String para o tipo enum
                    TipoImovel tipoImovel = TipoImovel.valueOf(entradaTipo);

                    System.out.println("Endereço: ");
                    String endereco = teclado.nextLine();

                    System.out.println("Cidade: ");
                    String cidade = teclado.nextLine();

                    System.out.println("Status do imóvel(disponível, alugado, vendido)");
                    String entradaStatus = teclado.next().toUpperCase();
                    // Converte String para enum
                    StatusImovel statusImovel = StatusImovel.valueOf(entradaStatus);

                    System.out.println("Área m²: ");
                    double area = teclado.nextDouble();

                    System.out.println("Quantidade de quartos: ");
                    int quantQuartos = teclado.nextInt();

                    System.out.println("Quantidade de banheiros: ");
                    int quantBanheiros = teclado.nextInt();

                    System.out.println("Quantidade de vagas de garagem: ");
                    int vagasGaragem = teclado.nextInt();
                    teclado.nextLine(); // limpando o abençoado do buffer;

                    // Criando de cadastrando
                    Imovel novoImovel = new Imovel(id, tipoImovel, endereco, cidade, statusImovel, area, quantQuartos,
                            quantBanheiros, vagasGaragem);
                    imobiliaria.cadastrarImovel(novoImovel);
                    break;

                case 2:
                    imobiliaria.listarImoveis();
                    break;

                case 3:
                    System.out.println("===== Busca de Imóveis =====");
                    System.out.println("Informe o ID do imóvel que deseja procurar: ");
                    int idBuscar = teclado.nextInt();
                    teclado.nextLine(); // e limpa o buffer

                    // Chamando o metodo de busca e guardando o resultado em uma var temporaria
                    Imovel imovelEncontrado = imobiliaria.buscarImovelPorId(idBuscar);

                    // se nao retornar null imprime o objeto
                    if (imovelEncontrado != null) {
                        System.out.println(imovelEncontrado);
                    }
                    break;

                case 4:
                    System.out.println("Digite o ID do imóvel que deseja atualizar:");
                    int idAlt = teclado.nextInt();
                    teclado.nextLine(); // limpando o buffer
                    Imovel imovelAtualizar = imobiliaria.buscarImovelPorId(idAlt);

                    if (imovelAtualizar != null) {
                        System.out.println("Imóvel encontrador: " + imovelAtualizar.getEndereco());
                        System.out.println("Informe qual informação deseja alterar");
                        System.out.println("1 - Endereço | 2 - Status | 3- Área | 4 - Voltar");
                        System.out.println("Opção: ");
                        int subopcao = teclado.nextInt();
                        teclado.nextLine();

                        // Switch subopcoes
                        switch (subopcao) {
                            case 1:
                                System.out.println("Atualizar Endereço: "); // Caso tenha algum erro de digitação no endereço ou endereço cadastrado errado no sistema
                                imovelAtualizar.setEndereco(teclado.nextLine());
                                System.out.println("Endereço atualizado com sucesso!");
                                break;

                            case 2:
                                System.out.println("Atualizar Status: ");
                                imovelAtualizar.setStatus(StatusImovel.valueOf(teclado.next().toUpperCase()));
                                System.out.println("Status atualizado com sucesso!");
                                break;

                            case 3:
                                System.out.println("Atualizar Área: ");
                                imovelAtualizar.setArea(teclado.nextDouble());
                                System.out.println("Área atualizada com sucesso!");
                                break;

                            case 4:
                                System.out.println("Cancelado.");
                                break;
                        }

                    } // fechamento do if
                    break; //fechamento do case 4

                case 5:
                    teclado.nextLine(); //limpa buffer do nextInt

                    System.out.println("----- Cadastro de Cliente -----");
                    System.out.println("Nome: ");
                    String nomeCliente = teclado.nextLine();
                    
                
                    System.out.println("CPF: ");
                    String cpfCliente = teclado.nextLine();
                    System.out.println("E-mail: ");
                    String emailCliente = teclado.nextLine();
                    System.out.println("Telefone: ");
                    String telefoneCliente = teclado.nextLine();

                    imobiliaria.cadastrarCliente(new Cliente(nomeCliente, cpfCliente, telefoneCliente, emailCliente));
                    System.out.println("Cliente cadastrado com sucesso!");

                    break;

                case 6:
                    System.out.println("----- Cadastro do Corretor -----");
                    System.out.println("Nome: ");
                    String nomeCorretor = teclado.nextLine();
                    System.out.println("CRECI: ");
                    String creci = teclado.nextLine();
                    System.out.println("Telefone: ");
                    String telefoneCorretor = teclado.nextLine();

                    imobiliaria.cadastrarCorretor(new Corretor(nomeCorretor, creci, telefoneCorretor));
                    System.out.println("Corretor cadastrado com sucesso!");

                    break;

                case 7:
                    System.out.println("----- Gerar Novo Contrato -----");

                    // identificacao do contrato
                    System.out.println("ID do Contrato: ");
                    int idContrato = teclado.nextInt();

                    // Localizando imovel
                    System.out.println("ID Imóvel: ");
                    int idImovel = teclado.nextInt();
                    Imovel imovelContrato = imobiliaria.buscarImovelPorId(idImovel);

                    // Localizando cliente (bucando pelo cpf)
                    System.out.println("CPF do Cliente: ");
                    teclado.nextLine(); // e limpa o buffer
                    String cpfCli = teclado.nextLine();
                    Cliente clienteContrato = imobiliaria.buscarClientePorCpf(cpfCli);

                    // Localizando o corretor (buscando pelo creci)
                    System.out.println("CRECI do Corretor: ");
                    String creciCorretor = teclado.nextLine();
                    Corretor corContrato = imobiliaria.buscarCorretorPorCreci(creciCorretor);

                    // Fazendo um verificacao de seguranca
                    if (imovelContrato != null && clienteContrato != null && corContrato != null) {
                        try {
                            System.out.println("Tipo de contrato (VENDA OU ALUGUEL): ");
                            TipoContrato tipo = TipoContrato.valueOf(teclado.next().toUpperCase());

                            System.out.println("Valor da transação: R$");
                            double valorCont = teclado.nextDouble();

                            // Usando o LocalDate para pegar a data do sistema de forma automatica pra facilitar
                            Contrato novoContrato = new Contrato(idContrato, clienteContrato, imovelContrato,
                                    corContrato, tipo, valorCont, LocalDate.now());

                            imobiliaria.cadastrarContrato(novoContrato);
                            System.out.println("Sucesso: Contrato gerado e Status do imóvel atualizado!");

                        } catch (IllegalArgumentException e) {
                            System.out.println("ERRO ao gerar contrato: " + e.getMessage());
                        }

                    } else {
                        System.out
                                .println("ERRO: um ou mais dados não foram encontrados (Imóvel, Cliente ou Corretor)");
                    }
                     break;

                    case 8:
                        System.out.println("----- Registrar Pagamento -----");
                        System.out.println("ID do contrato: ");
                        int idContratoPagamento = teclado.nextInt();

                        System.out.println("Valor a pagar R$");
                        double valorAPagar = teclado.nextDouble();

                        System.out.println("Forma de pagamento (PIX,BOLETO, CARTAO, DINHEIRO");
                        String formaStr = teclado.next().toUpperCase();

                        try{

                            FormaPagamento formaPagamento = FormaPagamento.valueOf(formaStr); 
                            imobiliaria.registrarPagamento(idContratoPagamento, valorAPagar, formaPagamento);
                        }catch(IllegalArgumentException e){
                            System.out.println("ERRO: Dados de pagamento inválidos!");
                        }
                        break;

                    case 9: 
                        System.out.println("Encerrando sistema...");
                        break;

                default:
                    System.out.println("Opção Inválida!");
            }

        } while (opcao != 9);

        teclado.close();
    }
}
