/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author professor
 */
public class Venda {
    private int numero;
    private Cliente cliente;
    private List<Item> lista;
    private float valorTotal;
    private Date data;

    public Venda() {
        lista = new ArrayList<Item>();
        data = new Date();
    }
    
    public void adicionarItem(Item item)
    {
        lista.add(item);
    }
    
    public Item buscarItem(int codigo)
    {
        Item it = null;
        for(Item i: lista)
        {
            if(codigo == i.getLivro().getCodigo())
                 it = i;
        }
        return it;
    }
    
    public void removerItem(int codigo)
    {
        Item i = buscarItem(codigo);
        if(i != null)
        {
            lista.remove(i);
        }
    }
    
    public void calcularTotal()
    {
        float soma = 0;
        for(Item i: lista)
        {
            soma += i.getValoritem();
        }
        this.valorTotal = soma;
    }
    
    @Override
    public String toString()
    {
        String str = "";
        str += "-------- DADOS DA VENDA Nº " + numero + " ---------";
        str += "\nData Venda: " + getData();
        str += "\nCPF do Cliente: " + cliente.getCpf();
        str += "\nNome do Cliente: " + cliente.getNome();
        for(Item i: lista)
        {
            str += i.toString();
        }
        str += "\nVALOR TOTAL = R$" + valorTotal;
        
        return str;               
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getData() {
        
        SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");                
        
        return fm.format(data);
    }
    
}
