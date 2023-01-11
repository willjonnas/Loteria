import java.util.Random;
import java.util.Scanner;
public class Main {
    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();
    static int saldo = 100;
    static String nome = "";


    public static void main(String[] args) {
       /*System.out.println("Qual o saldo inicial?");
        saldo = in.nextInt();

        in = new Scanner(System.in);*/

        System.out.println("Qual o seu nome?");
        nome = in.nextLine();


        int op;

        do {
            System.out.println("Bem Vindo " + nome + " Seu Saldo: " + saldo + " €");
            System.out.println("Escolha uma das seguintes opções");
            System.out.println("1- Loteria");
            System.out.println("2- Raspadinha");
            System.out.println("3- Controlo");
            System.out.println("0- Sair");
            op = in.nextInt();

            switch (op) {
                case 1 -> Loteria();
                case 2 -> Raspadinha();
                case 3 -> Controlo();
                default -> System.out.println("Opção inválida");
            }
        } while (op != 0);

    }

    private static void Loteria() {
        //1. Lotaria
        //a. Deve permitir ao apostador escolher um número entre os limites mínimo (considere como limite mínimo
        //1000 bilhetes) e máximo de bilhetes e verificar se ganhou ou não.
        //b. Caso o apostador não tenha o número vencedor deve considerar que o 2º prémio será atribuído a todos
        //os apostadores com os 3 últimos dígitos do premiado e o 3º prémio a todos os apostadores com os 2
        //últimos dígitos do premiado.
        //Exemplo: 1º prémio 4567
        //2º prémio: todos os que terminem em 567
        //3º prémio: todos os que terminem em 67


        if (saldo - 5 < 0) {
            System.out.println("Saldo insuficiente, deposite antes de jogar");
        } else {
            saldo -= 5;
            int numPremiado = rnd.nextInt(1000, 10000);// [1000-9999]
            //System.out.println("Número premiado: " + numPremiado);    //USADO PARA TESTES

            //VALIDAÇÃO DO NÚMERO DO UTILIZADOR ENTRE 1000 E 9999
            int numJogador;
            do {
                System.out.println("Escolha um número para jogar [1000-9999]");
                numJogador = in.nextInt();
                if (numJogador < 1000 || numJogador > 9999) {
                    System.out.println("Valor inválido, tente novamente");
                }
            } while (numJogador < 1000 || numJogador > 9999);

            //VERIFICAÇÃO DO PRÉMIO APÓS NÚMERO DO JOGADOR VÁLIDO

            if (numJogador == numPremiado) {
                System.out.println("Número vencedor: " + numPremiado + "\nParabéns, ganhou o 1º prémio");
                saldo += 10000;
            } else if (numJogador % 1000 == numPremiado % 1000) {
                System.out.println("Número vencedor: " + numPremiado + "\nParabéns, ganhou o 2º prémio");
                saldo += 1000;
            } else if (numJogador % 100 == numPremiado % 100) {
                System.out.println("Número vencedor: " + numPremiado + "\nParabéns, ganhou o 3º prémio");
                saldo += 100;
            } else {
                System.out.println("Número vencedor: " + numPremiado + "\nNão ganhou qualquer prémio, tente novamente");
            }
        }
    }


    private static void Raspadinha() {
        if (saldo -2 <0 ) {
        }
        else {
            System.out.println("Você não tem saldo suficiente!");
        }
        int op;
        Scanner in = new Scanner(System.in);
        int saldo= -2;
        do {
            System.out.println("Aplicação 2: Raspadinha \t\t Saldo: " + saldo);
            System.out.println("1- Raspadinha tipo A");
            System.out.println("2- Raspadinha tipo B");
            System.out.println("0- Voltar ao menu anterior");
            op = in.nextInt();

            switch (op) {
                case (0):
                    break;
                case (1):
                    Tipo_A();
                    break;
                case (2):
                    Tipo_B();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;

            }

        } while (op != 0);
    }

    private static void Tipo_A() {
        //2. Raspadinhas
        //a. O primeiro tipo de raspadinhas contém um número principal e 5 números aleatórios (de 1 a 10), cada
        //um com um valor monetário associado. Caso o número principal seja igual a um ou mais dos números
        //aleatórios (de 1 a 10) o prémio é a soma dos montantes dos valores iguais ao número principal.
        if (saldo - 2 < 0) {
            System.out.println("Saldo insuficiente, deposite antes de jogar");
        } else {
            saldo -= 2;

            Random randomGenerator = new Random();
            int sorte1 = 1;
            int num_aleatorio;
            int sorte2 = 2;
            int sorte3 = 3;
            int sorte4 = 4;
            int sorte5 = 5;
            int soma = 0;


            num_aleatorio = randomGenerator.nextInt(1, 11); // o  numero da sorte

            if (num_aleatorio == sorte1) {
                System.out.println(" Você ganhou 10,00 ");
                soma = 10;
            }

            if (num_aleatorio == sorte2) {
                System.out.println(" Você ganhou  20,00 ");
                soma = soma + 20;
            }

            if (num_aleatorio == sorte3) {
                System.out.println(" Você ganhou 30,00 ");
                soma = soma + 30;
            }

            if (num_aleatorio == sorte4) {
                System.out.println(" Você ganhou 40,00 ");
                soma = soma + 40;
            }

            if (num_aleatorio == sorte5) {
                System.out.println(" Você ganhou 50,00 ");
                soma = soma + 50;

                System.out.println("Você ganhou um total de " + soma);
            }
            saldo += soma;
        }
    }
    private static void Tipo_B() {
        //2. Raspadinhas
        //b- O segundo tipo de raspadinhas tem um número principal aleatório entre 1 e 10 e um valor de prémio
        //previamente atribuídos e sorteados (1 a 10€). Caso nos 9 números sorteados apareçam 3 vezes o número
        //principal a raspadinha é premiada.
        if (saldo - 2 < 0) {
            System.out.println("Saldo insuficiente, deposite antes de jogar");
        } else {
            saldo -= 2;

            Random randomGenerator = new Random();
            int sorte;
            int num_aleatorio;
            int contador = 0;
            int premio = rnd.nextInt(1, 10);

            System.out.println("Digite um número de 1 a 10: ");
            sorte = in.nextInt(); // input utilizador

            for (int i = 0; i < 9; i++) {
                num_aleatorio = randomGenerator.nextInt(1, 11); // o  numero da sorte
                if (num_aleatorio == sorte) {
                    contador += 1;
                }
            }
            if (contador >= 3) {
                System.out.println(" Você ganhou " + premio + " €");
                saldo += premio;
            } else {
                System.out.println(" Você não ganhou, tente novamente");
            }
        }
    }


    private static void Controlo() {
        //Acrescente um mecanismo de controlo de prémios e custos de jogos.
        //a. Atribua 100€ a um jogador e sempre que este joga na lotaria gasta 5€ e nas raspadinhas 2€.
        //b. Sempre que o jogador ganha um prémio deve ser acrescentado o valor do mesmo ao seu saldo.

        int op;

        do {
            System.out.println("Conta Pessoal\t\tSaldo: " + saldo);
            System.out.println("1-Ver Saldo");
            System.out.println("2-Levantamento");
            System.out.println("3-Depósito");
            System.out.println("0-Voltar ao menu anterior");
            op = in.nextInt();

            if (op == 0) {
                break;
            } else if (op == 1) {
                VerSaldo();
            } else if (op == 2) {
                Levantamento();
            } else if (op == 3) {
                Deposito();
            } else {
                System.out.println("Opção inválida");
            }
        } while (op != 0);

    }
    private static void Deposito() {
        System.out.println("Valor do deposito: ");
        int valor = in.nextInt();
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso, novo saldo: " + saldo);
        } else {
            System.out.println("Valor inválido, tente novamente");
        }
    }

    private static void Levantamento() {
        System.out.println("Valor a levantar: ");
        int valor = in.nextInt();
        if (valor >= 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Levantamento realizado com sucesso, novo saldo: " + saldo);
        } else {
            System.out.println("Valor inválido, tente novamente");
        }
    }

    private static void VerSaldo() {
        System.out.println("Saldo: " + saldo);
    }

    }

