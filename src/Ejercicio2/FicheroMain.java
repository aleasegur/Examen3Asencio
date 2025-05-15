package Ejercicio2;

import Ejercicio1.Estado;
import Ejercicio1.FunkoPops;
import Ejercicio1.MyMetodosInitVariables;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FicheroMain {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<FunkoPops> lista=new ArrayList<>();
        String dir= MyFilesMethods.DIR;
        String file= MyFilesMethods.FILE;
        boolean bucle=true;
        int opcion;
        while (bucle) {
            MyFilesMethods.loadFile(lista, dir, file);
            showMenu();
            try {
                opcion=sc.nextInt();
                switch (opcion){
                    case 0:
                        System.out.println("Saliendo...");
                        bucle=false;
                        break;
                    case 1:
                        FunkoPops funkoPops=MyFilesMethods.crearFunko(sc);
                        lista.add(funkoPops);
                        escribirFichero(lista,dir,file);
                        break;
                    case 2:
                        String nombre= MyMetodosInitVariables.introducirCadena(sc,"INtroduce el nobre del funko a eliminar: ");
                        boolean encontrado=lista.removeIf(f->f.getNombre().equalsIgnoreCase(nombre));
                        if (encontrado){
                            System.out.println("Funko eliminado");
                        }else{
                            System.err.println("Funko no encontrado");
                        }
                        break;
                    default:
                        System.err.println("Opcion invalida");
                }
            }catch (InputMismatchException | ArithmeticException e){
                System.err.println(e.getMessage());
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }

    public static void showMenu(){
        System.out.println("1.Añadir Funko pop");
        System.out.println("2.Borrar Funko pop");
        System.out.println("0.Salir");
        System.out.println("Elegir opcion: ");
    }

    public static void escribirFichero(ArrayList<FunkoPops> lista,String dir,String file){
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(dir+file,true))) {
            File archivo=new File(dir+file);
            if (archivo.length()>0){
                bw.newLine();
            }

            for (FunkoPops funkoPops : lista){
                bw.write(funkoPops.toTxt());
                bw.newLine();
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }


}
