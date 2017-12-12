package br.com.fiap.pizzaria.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by logonrm on 11/12/2017.
 */

public class Pedido {

    private String cliente;

    private List<String> sabores;

    private String tamanho;

    private String formaPagamento;

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<String> getSabores() {
        return sabores;
    }

    public void setSabores(List<String> sabores) {
        this.sabores = sabores;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void addSabor(String sabor){

        if(sabores == null)
        {
            sabores = new ArrayList<>();
        }
        sabores.add(sabor);

    }

    public void removeSabor(String sabor){

        if(sabores.contains(sabor)){
            sabores.remove(sabor);
        }

    }

}
