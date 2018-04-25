package pdvUnifacs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NotaFiscal {
    private ArrayList<Produto> prod = new ArrayList();
    private ArrayList<Cliente> cli = new ArrayList();
    private ArrayList<Funcionario> fun = new ArrayList();
    private int indiceCliente = 0;
    private int indiceFuncionario = 0;
    private double valorTotal = 0;

    public double getValorTotal() {
        return valorTotal;
    }
    
    
    public NotaFiscal(ArrayList<Funcionario> f,
            ArrayList<Cliente> c, 
            ArrayList<Produto> p, 
            int indiceFuncionario, 
            int indiceCliente) {
        fun = f;
        cli = c;
        prod = p;
        this.indiceCliente=indiceCliente;
        this.indiceFuncionario=indiceFuncionario;
    }
    
    public double ValorTotalCompra(ArrayList <Produto> p) {
        
        for (int i = 0; i < p.size(); i++) {      
            this.valorTotal += p.get(i).getValorUnitario() * p.get(i).getQuantidade();
        }
        return this.valorTotal;
    }
    
    public void ImprimeNota(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        
        System.out.println("Minha loja: ");
        System.out.println("Funcionario: " + fun.get(indiceFuncionario).getNome());
        System.out.println("Cliente: " + cli.get(indiceCliente).getNome());
        System.out.println("Cpf cliente: " + cli.get(indiceCliente).getCpf());
        
        System.out.println("Produtos: ");
        
        for (int i = 0; i < prod.size(); i++) {

            System.out.println("Posição no array: "
                    + i + ", nome do produto: " + prod.get(i).getNome()
                    + ", código: " + prod.get(i).getCodigo()
                    + ", quantidade: " + prod.get(i).getQuantidade()
                    + ", valor unitário: " + prod.get(i).getValorUnitario()
                    + ", valor total do produto: "
                    + prod.get(i).getValorUnitario() * prod.get(i).getQuantidade());
        }
        System.out.println();
        
        System.out.println("Valor total da compra: " + this.valorTotal);
    }
}