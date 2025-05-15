package Ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;

public class FigurasAccion extends Figuras{
     private ArrayList<Accesorios> lista;

    public FigurasAccion() {
        lista = null;
    }

    public FigurasAccion(String nombre, String year, double precioBase, Estado estado) throws Exception {
        super(nombre, year, precioBase, estado);
        lista=new ArrayList<>();
    }

    public ArrayList<Accesorios> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Accesorios> lista) throws Exception {
        if (lista!=null) {
            this.lista = lista;
        }else{
            throw new Exception("Error en la lista");
        }
    }

    //Metodo que muestra lo que contiene la lista de Accesorios
    public static void mostrarAccesorios(ArrayList<Accesorios> lista){
        lista.stream().forEach(System.out::println);
    }

    @Override
    public double calcularPrecioReal() {
        double precioReal=0;
        switch (estado){
            case PRECINTADA:
                precioReal+=precioBase*2;
                break;
            case EMBALAJE_ORIGINAL:
                precioReal+=precioBase;
                break;
            case SIN_EMBALAJE_ORIGINAL:
                precioReal=precioBase/2;
                break;
        }
        return precioReal;
    }

    @Override
    public String toString() {
        return "FIGURA DE ACCION: "+super.toString()+lista+",Precio real: "+calcularPrecioReal();
    }
}
