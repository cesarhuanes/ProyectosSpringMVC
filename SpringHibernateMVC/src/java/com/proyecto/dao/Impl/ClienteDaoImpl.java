
package com.proyecto.dao.Impl;

import com.proyecto.dao.ClienteDao;
import hibernate.Clientes;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class ClienteDaoImpl implements ClienteDao{
    private Session session;
    public void setSessionFactory(SessionFactory sessionFactory){
        this.session=sessionFactory.openSession();
    }
    
    @Override//usando hql
    public List<Clientes> lstClientes() {
        String hqlClientes="";
        Query queryCliente=session.createQuery(hqlClientes);
        List<Clientes> lstClientes=queryCliente.list();
        return lstClientes;        
    }

    @Override
    public void saveCliente(Clientes cliente) {
        session.getSessionFactory().getCurrentSession().saveOrUpdate(cliente);
    }

    @Override
    public void deleteCliente(int idCliente) {
        Clientes cli=new Clientes();
        cli.setCodigo(idCliente);
        session.getSessionFactory().getCurrentSession().delete(cli);
    }

    @Override
    public Clientes getCliente(int idCliente) {
       Clientes getCliente=(Clientes) session.get(Clientes.class, idCliente);
    return getCliente;
    }
    
}
