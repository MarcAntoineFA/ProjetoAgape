// CestasBasicas.java

import java.util.Scanner;
import java.util.ArrayList;

public class CestasBasicas {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        // Usamos um ArrayList para armazenar as famílias, pois ele pode crescer e diminuir
        ArrayList<Familia> listaDeFamilias = new ArrayList<>();

        // Adicionando as famílias iniciais à lista
        listaDeFamilias.add(new Familia(1, "João Silva", 30, "Rua A, 123", 11912345678L, 0));
        listaDeFamilias.add(new Familia(2, "Maria Oliveira", 25, "Rua B, 456", 11987654321L, 4));
        listaDeFamilias.add(new Familia(3, "José Santos", 40, "Rua C, 789", 11945612378L, 0));
        listaDeFamilias.add(new Familia(4, "Ana Costa", 35, "Rua D, 101",11945612378L , 0));
        listaDeFamilias.add(new Familia(5, "Carlos Pereira", 28, "Rua E, 202", 11945612378L,0));

        int opcao = 0;

        do {
            System.out.println("\n===== Pastoral Ágape - Cestas Básicas =====");
            System.out.println("1 - Cadastrar Família");
            System.out.println("2 - Remover Família");
            System.out.println("3 - Listar Famílias");
            System.out.println("4 - Registrar Retirada de Cesta");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                // Leitura de dados mais segura: lê a linha inteira e converte para número
                opcao = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, digite apenas um número.");
                opcao = 0; // Reseta a opção para não cair em um caso inválido
                continue;  // Pula para a próxima iteração do loop
            }

            switch (opcao) {
                case 1: // Cadastrar Família
                    System.out.println("\n--- Cadastro de Nova Família ---");
                    System.out.print("Digite o ID da família: ");
                    int id = Integer.parseInt(teclado.nextLine());
                    System.out.print("Digite o nome do responsável: ");
                    String nome = teclado.nextLine();
                    System.out.print("Digite a idade do responsável: ");
                    int idade = Integer.parseInt(teclado.nextLine());
                    System.out.print("Digite o endereço completo: ");
                    String endereco = teclado.nextLine();
                    System.out.print("Digite o cpf : ");
                    long cpf = Long.parseLong(teclado.nextLine());

                    listaDeFamilias.add(new Familia(id, nome, idade, endereco, cpf, 0));
                    System.out.println("Família cadastrada com sucesso!");
                    break;

                case 2: // Remover Família
                    System.out.print("\nDigite o ID da família que deseja remover: ");
                    int idParaRemover = Integer.parseInt(teclado.nextLine());

                    // O método removeIf é uma forma moderna e eficiente de remover itens de uma lista
                    boolean removido = listaDeFamilias.removeIf(familia -> familia.getId() == idParaRemover);

                    if (removido) {
                        System.out.println("Família removida com sucesso.");
                    } else {
                        System.out.println("Família com o ID informado não encontrada.");
                    }
                    break;

                case 3: // Listar Famílias
                    System.out.println("\n--- Lista de Famílias Cadastradas ---");
                    if (listaDeFamilias.isEmpty()) {
                        System.out.println("Nenhuma família cadastrada no momento.");
                    } else {
                        // Itera sobre cada família na lista e imprime seus dados usando o método toString()
                        for (Familia f : listaDeFamilias) {
                            System.out.println(f.toString());
                        }
                    }
                    break;

                case 4: // Retirada de Cestas
                    System.out.print("\nDigite o ID da família para registrar a retirada: ");
                    int idParaRetirada = Integer.parseInt(teclado.nextLine());

                    Familia familiaEncontrada = null;
                    // Procura a família na lista
                    for (Familia f : listaDeFamilias) {
                        if (f.getId() == idParaRetirada) {
                            familiaEncontrada = f;
                            break; // Para o loop assim que encontrar
                        }
                    }

                    if (familiaEncontrada != null) {
                        familiaEncontrada.registrarRetirada();
                    } else {
                        System.out.println("Família com o ID informado não encontrada.");
                    }
                    break;

                case 5: // Sair
                    System.out.println("\nSaindo do sistema... Obrigado!");
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha um número de 1 a 5.");
                    break;
            }

        } while (opcao != 5);

        teclado.close(); // Fecha o Scanner para liberar recursos
    }
}