/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.probandoejb1.servicios;

import com.mycompany.probandoejb1.entidades.Cliente;
import java.util.List;

/**
 *
 * @author cesar
 */
public interface ClienteRemote {

    public List<Cliente> listarTodosLosClientes();

    public Cliente buscarClientePorID(Integer id);
}
