package model.bean;

import java.util.List;
import model.dao.OrdemDeServicoDAO;


public class OrdemDeServico {
    
    private int os;
    private  int dia;
    private String modelo;
    

    public OrdemDeServico(int os, int dia, String modelo) {
        this.os = os;
        this.dia = dia;
        this.modelo = modelo;

    }

    public OrdemDeServico () {
        
        os = 0;
        dia = 0;
        modelo = null;
       
    }

    public int getOs() {
        return os;
    }

    public void setOs(int os) {
        this.os = os;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void add(List<OrdemDeServicoDAO> carros) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
    