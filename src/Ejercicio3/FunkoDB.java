package Ejercicio3;


import java.sql.*;

public class FunkoDB {
    public static void main(String[] args) {
        MyMethodsDB.loadProperties();
        try(Connection con= DriverManager.getConnection(MyMethodsDB.getURL(),MyMethodsDB.getUSER(),MyMethodsDB.getPASS())) {
            consultaSql(con);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public static void consultaSql(Connection con){
        String sql="SELECT * FROM Funko";
        try(PreparedStatement pst=con.prepareStatement(sql);
        ResultSet res=pst.executeQuery() ){
            while (res.next()){
                String nombre=res.getString("nombre");
                System.out.println(nombre);
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

}
