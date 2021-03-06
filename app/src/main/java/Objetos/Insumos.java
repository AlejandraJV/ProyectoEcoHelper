package Objetos;

import java.util.Arrays;
import java.util.Objects;

public class Insumos {
    private int id;
    private String[] insumos ={"Macetero clásico","Semillas de Zanahoria", "Semillas de Perejil Liso", "Tierra de hojas (50 lts)", "Semillas de girasol", "Pala de jardinería"};
    private int[] precios = {1500, 1900, 1700, 3650, 2500, 2190};
    private int[] stock  = {100, 30, 60, 80, 40, 15};

    public Insumos(){
    }

    public Insumos(int id, String[] insumos, int[] precios, int[] stock) {
        this.id = id;
        this.insumos = insumos;
        this.precios = precios;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getInsumos() {
        return insumos;
    }

    public void setInsumos(String[] insumos) {
        this.insumos = insumos;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
    }

    public int[] getStock() {
        return stock;
    }

    public void setStock(int[] stock) {
        this.stock = stock;
    }

    //Regla de negocio
    //Añade un adicional al valor base del insumo
    public int anadirAdicional(int valor, int adicional){
        return valor + adicional;
    }
}
