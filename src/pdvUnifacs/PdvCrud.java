package pdvUnifacs;

import java.util.ArrayList;
import java.util.Scanner;

public class PdvCrud {

    public static void main(String[] args) {

        ArrayList<Produto> prod = new ArrayList();
        ArrayList<Produto> prod2 = new ArrayList();
        ArrayList<Cliente> cli = new ArrayList();
        ArrayList<Funcionario> fun = new ArrayList();
        Scanner teclado = new Scanner(System.in);
        Scanner m = new Scanner(System.in);
        Scanner t = new Scanner(System.in);
        Scanner u = new Scanner(System.in);
        Scanner v = new Scanner(System.in);
        Scanner x = new Scanner(System.in);
        Scanner z = new Scanner(System.in);
        boolean whi = true;
        int i = 0;//Indice de um funcionario atual
        int ic = 0;//indice de um cliente atual
        int ip = 0;//indice de um produto atual
        int quantidadeLocal;
        int codigoP;
        String nome;

        while (whi) {
            
            System.out.println("--- Menu ---");
            System.out.println("1 - Identificar Funcionario");
            System.out.println("2 - Cadastrar produto");
            System.out.println("3 - Identificar cliente");
            System.out.println("4 - Realiza venda");
            System.out.println("5 - Imprime nota fiscal");
            System.out.println("6 - Sair");
            System.out.println();

            switch (teclado.nextInt()) {
                
                case 1://identificar funcionario
                    System.out.println("--- Menu Funcionario---");
                    System.out.println("1 - Cadastrar funcionario");
                    System.out.println("2 - Selecionar funcionario");
                    System.out.println("3 - Remove funcionario");
                    System.out.println("4 - volta");
                    
                    switch (m.nextInt()) {
                        
                        case 1://cadastrar funcionario
                            System.out.println("Digite o nome do Funcionario");
                            String nome1 = z.nextLine();

                            System.out.println("Digite o cpf do Funcionario");
                            int cpf = t.nextInt();

                            Funcionario g = new Funcionario(nome1, cpf);
                            i=g.cadastro(fun, g.getNome(), g.getCpf());
                            
                            g.setNome(null);
                            g.setCpf(0);                            
                            break;
                            
                        case 2://selecionar funcionario
                            System.out.println("Digite o id do funcionario");

                            int id = t.nextInt();
                            for (int ii = 0; ii < prod.size() - 1; ii++) {
                                if (fun.get(ii).getId() == id) {
                                    id=fun.indexOf(fun.get(ii));
                                }
                            }                        
                            //System.out.println(i);
                            break;
                            
                        case 3://remover funcionario
                            System.out.println
        ("Digite o id do funcionario a ser removido");
                            Funcionario f2 = new Funcionario();
                            int id2 = t.nextInt();
                            int i2 = f2.retornaIndiceFuncionario(fun, id2);
                            fun.remove(fun.get(i2));
                            break;
                            
                        case 4://volta menu principal
                            break;

                    }//fim Switch funcionario
                    break;

                case 2://cadastrar Produto
                    System.out.println("Digite o nome do produto");
                    nome = x.nextLine();

                    System.out.println("Digite o código");
                    codigoP = u.nextInt();

                    System.out.println("Digite o valor unitário");
                    double valorUnitario = u.nextDouble();

                    Produto p = new Produto(nome, codigoP, valorUnitario);
                    p.cadastro(prod, p.getNome(), 
                            p.getCodigo(), p.getValorUnitario());                  
                    break;

                case 3://identificar cliente
                    System.out.println("--- Menu Cliente ---");
                    System.out.println("1 - Cadastrar Cliente");
                    System.out.println("2 - Selecionar Cliente");
                    System.out.println("3 - Voltar ao menu anterior");
                    switch (m.nextInt()) {
                        case 1://cadastrar cliete
                            System.out.println("Digite o nome do Cliente");
                            String nome2 = x.nextLine();

                            System.out.println("Digite o cpf do Cliente");
                            int cpf = v.nextInt();

                            Cliente f = new Cliente(nome2, cpf);
                            ic = f.cadastrar(cli, f.getNome(), f.getCpf())-1;
                            break;
                            
                        case 2://selecionar cliente
                            System.out.println("Digite o cpf do cliente");

                            Cliente f1 = new Cliente();

                            int cppf = v.nextInt();

                            ic = f1.retornaIndiceCliente(cli, cppf);
                            break;
                            
                        case 3://volta menu principal
                            break;
                    }//fim switch cliente
                    break;
                    
                case 4://realizar venda

                    System.out.println("Digite o codigo do produto");
                    int codigoPro = u.nextInt();
                    for (int j = 0; j < prod.size(); j++) {
                        if (prod.get(j).getCodigo() == codigoPro) {
                            System.out.println(prod.get(j).getNome() 
                                    + " " + prod.get(j).getValorUnitario());
                            System.out.println("Digite a quantidade");
                            quantidadeLocal = x.nextInt();
                            prod2.lastIndexOf(prod2.add(prod.get(j)));
                            prod2.get(j).setQuantidade(quantidadeLocal);
                        }
                    }
                    break;
                
                case 5:
                    System.out.println("Selecione a forma de pagamento: ");
                    System.out.println("1 - Dinheiro");
                    System.out.println("2 - Cartão de Débito/Crédito");
                    Scanner q = new Scanner(System.in);
                    NotaFiscal n = new NotaFiscal(fun, cli, prod2, i, ic);
                    
                    switch(teclado.nextInt()) {
                        
                        case 1:
                            System.out.println("Valor Total da Compra: " 
                                    + n.ValorTotalCompra(prod2));
                            System.out.println();
                            System.out.println("Insira o valor do pagamento: ");
                            double pagamento = q.nextDouble();
                            double troco;
                            troco = pagamento - n.getValorTotal();
                            System.out.println
        ("Forma de pagamento selecionada: Dinheiro ");
                            n.ImprimeNota();
                            System.out.println("Troco: " + troco);
                            whi = false;
                            break;
                        
                        case 2:
                            System.out.println("Valor Total da Compra: " 
                                    + n.ValorTotalCompra(prod2));
                            System.out.println();
                            System.out.println
        ("Forma de pagamento selecionada: Cartão de Débito/Crédito ");
                            n.ImprimeNota();
                            whi = false;
                            break;
                    } // fim switch nota fiscal     
                case 6:
                    whi = false;
                    break;
            }//fecha switch principal
        }
    }//Main
}//classe