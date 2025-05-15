package Ejercicio1;

import java.time.LocalDate;

public class Estatuas extends Figuras{
    private String franquicia;

    public Estatuas() {
        franquicia=null;
    }

    public Estatuas(String nombre, String year, double precioBase, Estado estado, String franquicia) throws Exception {
        super(nombre, year, precioBase, estado);
        if (franquicia!=null) {
            this.franquicia = franquicia;
        }else{
            throw new Exception("Error en estatuas");
        }
    }

    public String getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(String franquicia) throws Exception {
        if (franquicia!=null) {
            this.franquicia = franquicia;
        }else {
            throw new Exception("Error en la franquicia");
        }
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
        return "ESTATUA: "+super.toString()+"franquicia='" + franquicia + "Precio real: "+calcularPrecioReal();
    }
}
