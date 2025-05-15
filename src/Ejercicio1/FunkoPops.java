package Ejercicio1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;

public class FunkoPops extends Figuras{
    private boolean edicionLimitada;

    public FunkoPops(String nombre, String year,boolean edicionLimitada, double precioBase, Estado estado) throws Exception {
        super(nombre, year, precioBase, estado);
        this.edicionLimitada = edicionLimitada;
    }

    public FunkoPops() {
        edicionLimitada=false;
    }

    public boolean getEdicionLimitada() {
        return edicionLimitada;
    }

    public void setEdicionLimitada(boolean edicionLimitada) {
        this.edicionLimitada = edicionLimitada;
    }

    public static FunkoPops toFiletxt(String linea) throws Exception {
        String[] dato=linea.split("#");
        return new FunkoPops(dato[0],dato[1],Boolean.getBoolean(dato[2]),Double.parseDouble(dato[3]),Estado.valueOf(dato[4]));
    }

    public String toTxt() throws Exception {
        return nombre+"#"+year+"#"+edicionLimitada+"#"+precioBase+"#"+estado;
    }

    @Override
    public double calcularPrecioReal() {
        return precioBase+((LocalDate.now().getYear()-Double.parseDouble(String.valueOf(year)))*10);
    }

    @Override
    public String toString() {
        return "FUNKO POP: "+super.toString()+"edicionLimitada=" + edicionLimitada +"Precio real:"+ calcularPrecioReal();
    }
}
