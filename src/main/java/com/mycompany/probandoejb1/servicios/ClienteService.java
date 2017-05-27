/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.probandoejb1.servicios;

import com.mycompany.probandoejb1.entidades.Cliente;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

/**
 *
 * @author cesar
 */
@Named("clienteservice")
@Stateless
@Local(ClienteLocal.class)
@Remote(ClienteRemote.class)
@LocalBean
public class ClienteService implements ClienteLocal, ClienteRemote {

    @Inject
    private EntityManager em;

    @Override
    public Cliente registrarCliente(Cliente cliente) {
        em.persist(cliente);
        return cliente;

    }

    @Override
    public void removerCliente(Cliente cliente) {
        em.remove(em.merge(cliente));

    }

    @Override
    public Cliente editarCliente(Cliente cliente) {
        return em.merge(cliente);

    }

    @Override
    public List<Cliente> listarTodosLosClientes() {

        return em.createNamedQuery(Cliente.LISTAR_TODOS, Cliente.class).getResultList();
    }

    @Override
    public Cliente buscarClientePorID(Integer id) {

        return em.find(Cliente.class, id);

    }

}
