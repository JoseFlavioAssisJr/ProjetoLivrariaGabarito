/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import classes.Cliente;
import classes.Livro;

/**
 *
 * @author Giuliano
 */
public class LivroDAO {
    private List<Livro> lista = null;

    public LivroDAO() {
        lista = new ArrayList<Livro>();
    }
    
    public void inserirLivro(Livro livro)
    {
        lista.add(livro);
    }
    
    public Livro buscarLivro(int codigo)
    {
        Livro lv = null;
        for(Livro livro: lista)
        {
            if(livro.getCodigo() == codigo)
                lv = livro;
        }
        
        return lv;
    }
    
    public void removerLivro(int codigo)
    {
        Livro livro = buscarLivro(codigo);
        if(livro != null)
        {
            lista.remove(livro);
        }
    }
    
    public void alterarLivro(Livro livro)
    {
        Livro l = buscarLivro(livro.getCodigo());
        if(livro != null)
        {
            int pos = lista.indexOf(l);
            lista.remove(pos);
            lista.add(pos,livro);
        }
    }
    
    public List<Livro> todosLivros()
    {
        return lista;
    }
    
    
}
