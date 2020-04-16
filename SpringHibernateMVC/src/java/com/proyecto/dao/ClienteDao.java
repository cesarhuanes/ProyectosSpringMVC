
package com.proyecto.dao;

import hibernate.Clientes;
import java.util.List;


public interface ClienteDao {
    List<Clientes> lstClientes();
    void saveCliente(Clientes cliente);
    void deleteCliente(int idCliente);
    Clientes getCliente(int idCliente);
}
