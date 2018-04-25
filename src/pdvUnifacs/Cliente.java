package pdvUnifacs;

import java.util.ArrayList;

public class Cliente {

    private String nome;
    private int cpf;
    private ArrayList<Produto> prodC = new ArrayList();

    public Cliente() {
    }

    public Cliente(String nome, int cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public ArrayList<Produto> getProd() {
        return prodC;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int cadastrar(ArrayList<Cliente> f, String nome, int cpf) {
        Cliente test = new Cliente(nome, cpf);
        if (!f.contains(test)) {
            f.lastIndexOf(f.add(new Cliente(nome, cpf)));
            System.out.println("Cliente cadastrado!");
            return f.size()/*-1*/;
        } else {
            System.out.println("Cliente já existe!");
            return -1;
        }
    }

    public boolean remover(ArrayList<Cliente> f, Cliente c) {
        if (f.contains(c)) {
            f.remove(c);
            return true;
        } else {
            return false;
        }
    }

    public void recebeProdutos(ArrayList<Produto> p) {
        this.prodC = p;
    }
    
    public int retornaIndiceCliente(ArrayList<Cliente> f, int cpf) {
        int i, j=0;
        for (i = 0; i < f.size(); i++) {
            if (f.get(i).getCpf() == cpf) {
                j=i;
            }else return -1;
        }return j;
    }
}