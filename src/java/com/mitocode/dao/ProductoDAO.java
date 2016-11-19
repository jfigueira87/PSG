package com.mitocode.dao;

import com.mitocode.model.Producto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public List<Producto> listar() throws SQLException {
        List<Producto> lista = null;
        ResultSet rs;
        Connection cn = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3307/producto?user=root&password=30111988");

            PreparedStatement st = cn.prepareStatement("SELECT codigo, nombre, precio FROM elemento");

            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Producto pro = new Producto();
                pro.setCodigo(rs.getInt("codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setPrecio(rs.getDouble("precio"));
                lista.add(pro);
            }
            rs.close();

        } catch (Exception e) {
            //Alguna logica de excepcion
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return lista;
    }
}
