package com.agenciadeviagens;

import java.util.Scanner;
import com.agenciadeviagens.dao.ClienteDAO;
import com.agenciadeviagens.database.DatabaseConnection;
import com.agenciadeviagens.model.Cliente;

public class Main {
    public static void main(String[] args) {
        var connection = DatabaseConnection.createConnection();
        ClienteDAO clienteDAO = new ClienteDAO(connection);
        Scanner scanner = new Scanner(System.in);

        int escolha;
        do {
            System.out.println("Bem-vindo à Agência de Viagens!");
            System.out.println("1. Novo Cadastro de Cliente");
            System.out.println("2. Consultar Cliente");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Deletar Cliente");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.println("Novo Cadastro de Cliente");
                    Cliente novoCliente = lerDadosCliente(scanner);
                    clienteDAO.createCliente(novoCliente);
                    break;
                case 2:
                    System.out.println("Consultar Cliente");
                    System.out.print("Informe o ID do cliente: ");
                    int idConsulta = scanner.nextInt();
                    Cliente clienteConsultado = clienteDAO.readCliente(idConsulta);
                    if (clienteConsultado != null) {
                        System.out.println("Cliente encontrado: " + clienteConsultado);
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Atualizar Cliente");
                    System.out.print("Informe o ID do cliente a ser atualizado: ");
                    int idAtualizacao = scanner.nextInt();
                    Cliente clienteAtualizar = clienteDAO.readCliente(idAtualizacao);
                    if (clienteAtualizar != null) {
                        Cliente dadosAtualizados = lerDadosCliente(scanner);
                        dadosAtualizados.setIDCliente(idAtualizacao);
                        clienteDAO.updateCliente(dadosAtualizados);
                        System.out.println("Cliente atualizado com sucesso.");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Deletar Cliente");
                    System.out.print("Informe o ID do cliente a ser excluído: ");
                    int idExclusao = scanner.nextInt();
                    Cliente clienteExcluir = clienteDAO.readCliente(idExclusao);
                    if (clienteExcluir != null) {
                        clienteDAO.deleteCliente(idExclusao);
                        System.out.println("Cliente excluído com sucesso.");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Saindo do programa. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 5);

        DatabaseConnection.closeConnection(connection);
        scanner.close();
    }

    private static Cliente lerDadosCliente(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        return new Cliente(nome, sobrenome, endereco, email, telefone);
    }
}
