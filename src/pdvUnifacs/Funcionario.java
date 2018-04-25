package pdvUnifacs;

import java.util.ArrayList;

public class Funcionario extends Cliente {
    private static int id = 0;
    private int id2;

    public Funcionario() {
    }

    public Funcionario(int id) {
        this.id2 = id;
    }

    public Funcionario(String nome, int cpf) {
        super(nome, cpf);
    }

    public int getId() {
        return id;
    }

    public int cadastro(ArrayList<Funcionario> f, String nome, int cpf) {
        Funcionario test = new Funcionario(nome, cpf);
        if (!f.contains(test)) {
            f.lastIndexOf(f.add(new Funcionario(nome, cpf)));
            id2=f.size()-1;
            System.out.println("Funcionario cadastrado!");
            id++;
            System.out.println("Id do funcionario: " + id);
        } else {
            System.out.println("Funcionario já existe!");
            return -1;
        }
        return id2;
    }

    public void remove(ArrayList<Funcionario> f, Funcionario c) {
        if (f.contains(c)) {
            f.remove(c);
            System.out.println("Funcionario removido!");
        } else {
            System.out.println("Funcionario não removido!");
        }
    }

    public int retornaIndiceFuncionario(ArrayList<Funcionario> f, int id) {
        int j = 0;
        for (int i = 0; i < f.size(); i++) {
            if (f.get(i).getId() == id) {
                j = i;
            } else {
                return -1;
            }
        }
        return j;
    }

}