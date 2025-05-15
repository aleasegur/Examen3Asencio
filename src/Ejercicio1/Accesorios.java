package Ejercicio1;

public class Accesorios {
    private String nombre,material,descripcion;

    public Accesorios() {
        nombre="";
        material="";
        descripcion="";
    }

    public Accesorios(String nombre, String material, String descripcion) throws Exception {
        if (nombre!=null && material!=null && descripcion!=null) {
            this.nombre = nombre;
            this.material = material;
            this.descripcion = descripcion;
        }else{
            throw new Exception("Error en accesorio");
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) throws Exception {
        if (material!=null) {
            this.material = material;
        }else {
            throw new Exception("Error en el material");
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) throws Exception {
        if (descripcion!=null) {
            this.descripcion = descripcion;
        }else{
            throw new Exception("Error en la descripcion");
        }
    }


    @Override
    public String toString() {
        return "Accesorios{" +
                "nombre='" + nombre + '\'' +
                ", material='" + material + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
