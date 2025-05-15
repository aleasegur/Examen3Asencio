package Ejercicio1;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

//En esta clase solo contendra metodos que devuelve un valor, lo hago para reducir el tiempo de poner sout mas scanner.nextInt,Double...
public class MyMetodosInitVariables {
    public static double introducirNumReal(Scanner sc,String mensaje){
        double num=0;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextDouble();
                if (num<0){
                    System.err.println("El numero no puede ser negativo");
                }
            } catch (InputMismatchException | ArithmeticException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }while (num<0);
        return num;
    }

    public static String introducirCadena(Scanner sc,String mensaje){
        String res="";
        try {
            System.out.println(mensaje);
            res=sc.next();
        }catch (StringIndexOutOfBoundsException e){
            System.err.println(e.getMessage());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return res;
    }

    public static Estado introducirEstado(Scanner sc){
        Estado estado=null;
        int opcion;
        boolean compEstado=true;
        while (compEstado) {
            try {
                System.out.println("---INTRODUCE EL ESTADO DE LA FIGURA---");
                System.out.println("1.Precintada");
                System.out.println("2.Embalaje original");
                System.out.println("3.Sin embalaje original");
                System.out.println("Elige la opcion: ");
                opcion=sc.nextInt();
                switch (opcion){
                    case 1:
                        estado=Estado.PRECINTADA;
                        compEstado=false;
                        break;
                    case 2:
                        estado=Estado.EMBALAJE_ORIGINAL;
                        compEstado=false;
                        break;
                    case 3:
                        estado=Estado.SIN_EMBALAJE_ORIGINAL;
                        compEstado=false;
                        break;
                    default:
                        System.err.println("Opcion elegido invalida");
                }
            } catch (InputMismatchException | ArithmeticException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return estado;
    }

    public static boolean introducirEdicionLimitada(Scanner sc){
        boolean res=false;
        int opcion;
        boolean compEdicion=true;
        while (compEdicion) {
            try {
                System.out.println("---INTRODUCE SI ES EDICIO LIMITADA---");
                System.out.println("1.TRUE");
                System.out.println("2.FALSE");
                System.out.println("Elige la opcion: ");
                opcion=sc.nextInt();
                switch (opcion){
                    case 1:
                        res=true;
                        compEdicion=false;
                        break;
                    case 2:
                        res=false;
                        compEdicion=false;
                        break;
                    default:
                        System.err.println("Opcion elegido invalida");
                }
            } catch (InputMismatchException | ArithmeticException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return res;
    }

}
