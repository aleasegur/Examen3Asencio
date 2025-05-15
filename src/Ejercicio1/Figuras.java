package Ejercicio1;


import java.time.LocalDate;

public abstract class Figuras {
    protected String nombre,year;
    protected double precioBase;//CO0nsidero que si es menor 0 salta la exception, en otras palabras admito el valor 0 en el precio
    protected Estado estado;//Considero estado como un enum

    public Figuras() {
        nombre="";
        year=null;
        precioBase=0.0;
        estado=null;
    }

    public Figuras(String nombre, String year, double precioBase, Estado estado)throws Exception {
        if (comprobarEstado(estado) && nombre!=null && year!=null && precioBase>=0) {
            this.nombre = nombre;
            this.year = year;
            this.precioBase = precioBase;
            this.estado = estado;
        }else{
            throw new Exception("Error en la figura");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        if (nombre!=null) {
            this.nombre = nombre;
        }else{
            throw new Exception("Error en el nombre");
        }
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) throws Exception {
        if (year!=null) {
            this.year = year;
        }else{
            throw new Exception("Error en el año");
        }
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) throws Exception {
        if (precioBase>=0) {
            this.precioBase = precioBase;
        }else{
            throw new Exception("Error en el precio base");
        }
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) throws Exception {
        if (comprobarEstado(estado)) {
            this.estado = estado;
        }
    }

    //Metodo que compruebo que estado tenga los valores correctos y este inicializado
    public static boolean comprobarEstado(Estado estado) throws Exception {
        if (estado.equals(Estado.EMBALAJE_ORIGINAL) || estado.equals(Estado.SIN_EMBALAJE_ORIGINAL) || estado.equals(Estado.PRECINTADA)){
            return true;
        }
        throw new Exception("Error en el estado");
    }

    //Considero que es un String para mostarar el precio real de la figura
    public abstract double calcularPrecioReal();

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", year='" + year + '\'' +
                ", precioBase=" + precioBase +
                ", estado=" + estado;
    }
}
