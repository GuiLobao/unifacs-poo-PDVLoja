package pdvUnifacs;

import java.util.ArrayList;

public class Produto {
    private String nome;
    private int codigo;
    private int quantidade;
    private int posicao;
    private double valorUnitario;

    public Produto() {

    }

    public Produto(int codigo) {
        this.codigo = codigo;
    }

    public Produto(String nome, int codigo, double valorUnitario) {
        this.nome = nome;
        this.codigo = codigo;
        this.valorUnitario = valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public int cadastro(ArrayList<Produto> f, String nome, int codigo, double valorUnitario) {
        Produto test = new Produto(nome, codigo, valorUnitario);
        if (!f.contains(test)) {
            posicao = f.lastIndexOf(f.add(new Produto(nome, codigo, valorUnitario)));
            System.out.println("Produto cadastrado!");
            return posicao;
        } else {
            System.out.println("Produto já existe!");
            return -1;
        }
    }

    public boolean remove(ArrayList<Produto> f, Produto c) {
        if (f.contains(c)) {
            f.remove(c);
            return true;
        } else {
            return false;
        }
    }

    public int retornaIndiceProduto(ArrayList<Produto> f, int codigo) {
        int i, j = 0;
        for (i = 0; i < f.size(); i++) {
            if (f.get(i).getCodigo() == codigo) {
                j = i;
            } else {
                return -1;
            }
        }
        return j;
    }
}