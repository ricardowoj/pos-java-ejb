/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.model;

import java.util.ArrayList;

/**
 *
 * @author ricar
 */
public class CrudProduto {
    public ArrayList<Produto> getAll() {
        ArrayList<Produto> produtos = new ArrayList();
        produtos.add(new Produto(1, "Computador"));
        produtos.add(new Produto(2, "Mouse"));
        produtos.add(new Produto(3, "Teclado"));
        produtos.add(new Produto(4, "Monitor"));
        return produtos;
    }
}
