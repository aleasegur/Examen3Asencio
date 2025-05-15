package Ejercicio2;

import Ejercicio1.Estado;
import Ejercicio1.FunkoPops;
import Ejercicio1.MyMetodosInitVariables;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//FIchero que contendra atributos y metodos para el ejercicio 2 de ficheros
public class MyFilesMethods {
    public static final String DIR="CarpetaFuko/";
    public static final String FILE="funkos.txt";

    public static void loadFile(ArrayList<FunkoPops> lista,String dir,String file){
        File ruta=new File(dir);
        if (!ruta.exists()){
            System.err.println("Error directorio no encontrado");
            ruta.mkdir();
            System.out.println("Se te ha creado un directorio llamado: "+ruta);
        }

        try(BufferedReader br=new BufferedReader(new FileReader(dir+file))) {
            String linea;
            while (Boolean.parseBoolean((linea= String.valueOf(br.readLine()!=null)))){
                String[] datos=linea.split("#");
                if (datos.length==5){
                    lista.add(FunkoPops.toFiletxt(linea));
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static FunkoPops crearFunko(Scanner sc){
        String nombre;
        String year;
        boolean edicionLimitada;
        double precioBase;
        Estado estado;
        try {
            nombre= MyMetodosInitVariables.introducirCadena(sc,"Introduce el nombre: ");
            year=MyMetodosInitVariables.introducirCadena(sc,"Introduce el año: ");
            edicionLimitada=MyMetodosInitVariables.introducirEdicionLimitada(sc);
            precioBase=MyMetodosInitVariables.introducirNumReal(sc,"Introduce el precio: ");
            estado=MyMetodosInitVariables.introducirEstado(sc);
            FunkoPops funkoPops=new FunkoPops(nombre,year,edicionLimitada,precioBase,estado);
            return funkoPops;
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return null;
    }

}
