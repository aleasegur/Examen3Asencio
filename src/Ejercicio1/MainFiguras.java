package Ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class MainFiguras {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Figuras> listaFiguras=new ArrayList<>();
        int opcion;
        boolean bucleMain=true;
        while (bucleMain){
            try {
                showMenu();
                opcion=sc.nextInt();
                switch (opcion){
                    case 1:
                        addFigura(sc,listaFiguras);
                        break;
                    case 2:
                        addAccesorio(sc,listaFiguras);
                        break;
                    case 3:
                        mostrarListado(listaFiguras);
                        break;
                    case 4:
                        mostrarFunkoPopEdicionLimitada(listaFiguras);
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        bucleMain=false;
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
        System.out.println("1.Añadir figura");
        System.out.println("2.Añadir nuevo accesorio");
        System.out.println("3.Mostrar listado");
        System.out.println("4.Mostrar funko pop de edicion limitada");
        System.out.println("5.Salir.");
        System.out.println("Elige la opcion: ");
    }

    public static void showSubMenu(){
        System.out.println("---FIGURA A AÑADIR---");
        System.out.println("1.Figura De Accion");
        System.out.println("2.Estatua");
        System.out.println("3.FUnko Pop");
        System.out.println("Elige la opcion: ");
    }

    public static void addFigura(Scanner sc,ArrayList<Figuras> listaFig){
        String nombre="",year=null;
        double precioBase=0.0;
        Estado estado=null;
        int opcion;
        boolean compFigura=true;
        while (compFigura){
            try {
                showSubMenu();
                opcion=sc.nextInt();
                if (opcion==1 || opcion==2 || opcion==3){
                    nombre= MyMetodosInitVariables.introducirCadena(sc,"Introduce el nombre de la figura(nombre_completo): ");
                    year=MyMetodosInitVariables.introducirCadena(sc,"Introduce el año de lanzamiento de la figura(YYYY): ");
                    precioBase=MyMetodosInitVariables.introducirNumReal(sc,"Introduce el precio base de la figura: ");
                    estado=MyMetodosInitVariables.introducirEstado(sc);
                }
                switch (opcion){
                    case 1:
                        FigurasAccion figurasAccion=new FigurasAccion(nombre,year,precioBase,estado);
                        listaFig.add(figurasAccion);
                        compFigura=false;
                        break;
                    case 2:
                        String franquicia=MyMetodosInitVariables.introducirCadena(sc,"Introduce el nombre de la franquicia(juego_de_tronos): ");
                        Estatuas estatuas=new Estatuas(nombre,year,precioBase,estado,franquicia);
                        listaFig.add(estatuas);
                        compFigura=false;
                        break;
                    case 3:
                        boolean edicionLimitada=MyMetodosInitVariables.introducirEdicionLimitada(sc);
                        FunkoPops funkoPops=new FunkoPops(nombre,year,edicionLimitada,precioBase,estado);
                        listaFig.add(funkoPops);
                        compFigura=false;
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

    public static Accesorios crearAccesorio(Scanner sc){
        String nombre,material,descripcion;
        try {
            nombre=MyMetodosInitVariables.introducirCadena(sc,"Introduce el nombre del accesorio(nombre_completo): ");
            material=MyMetodosInitVariables.introducirCadena(sc,"Introduce el material del accesorio: ");
            descripcion=MyMetodosInitVariables.introducirCadena(sc,"Introduce la descripcion del accesorio(descripcion_completo_del_accesorio): ");
            Accesorios accesorios=new Accesorios(nombre,material,descripcion);
            return accesorios;
        }catch (StringIndexOutOfBoundsException e){
            System.err.println(e.getMessage());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static void addAccesorio(Scanner sc,ArrayList<Figuras> listFig) throws Exception {
        ArrayList<Accesorios> listAccesorio=new ArrayList<>();
        String nombre=MyMetodosInitVariables.introducirCadena(sc,"Introduce el nombre de la figura de accion: ");
        for (Figuras figura: listFig){
            if (figura instanceof FigurasAccion) {
                FigurasAccion figurasAccion=(FigurasAccion) figura;
                if (figura.getNombre().equals(nombre)) {
                    Accesorios accesorios = crearAccesorio(sc);
                    listAccesorio.add(accesorios);
                    figurasAccion.setLista(listAccesorio);
                } else {
                    System.err.println("No se ha encontrado la figura con ese nombre");
                }
            }
        }
    }

    public static void mostrarListado(ArrayList<Figuras> listaFig){
        listaFig.forEach(System.out::println);
    }

    public static void mostrarFunkoPopEdicionLimitada(ArrayList<Figuras> listFig){
        System.out.println("---NOMBRE DE LOS FUNKO POP EDICION LIMITADA---");
        for (Figuras figuras : listFig){
            if (figuras instanceof FunkoPops) {
                FunkoPops funkoPops = (FunkoPops) figuras;
                if (funkoPops.getEdicionLimitada()) {
                    System.out.println(funkoPops.getNombre());
                }
            }
        }
    }

}
