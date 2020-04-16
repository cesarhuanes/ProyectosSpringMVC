
package com.proyecto.service;

import hibernate.Clientes;
import java.util.List;


public interface ClienteService {
     List<Clientes> lstClientes();
    void saveCliente(Clientes cliente);
    void deleteCliente(int idCliente);
    Clientes getCliente(int idCliente); 
}
