/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.probandoejb1.beans;

import com.mycompany.probandoejb1.entidades.Cliente;
import com.mycompany.probandoejb1.servicios.ClienteLocal;
import com.mycompany.probandoejb1.servicios.ClienteRemote;
import com.mycompany.probandoejb1.servicios.ClienteService;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cesar
 */
@Named("clientebean")
@RequestScoped
public class ClienteBean {

//    @EJB
//    private ClienteLocal clienteLocalEJB;
//    
//    @EJB
//    private ClienteRemote clienteRemote;
    @EJB
    private ClienteService clienteService;

    @Inject
    private Cliente cliente;

    public void registrarCliente() {

        clienteService.registrarCliente(cliente);

        FacesContext ctx = FacesContext.getCurrentInstance();

        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente registrado", "Cliente de Id:" + cliente.getCodigo() + " se registro en la base de datos"));
    }
    
    
    public void EditarCliente(){
        
        
        
    }
    
    public void buscarCliente(){
        cliente = clienteService.buscarClientePorID(cliente.getCodigo());
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    public String busca(){
        
        String codigo =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codigo");
        
        cliente = clienteService.buscarClientePorID(Integer.parseInt(codigo));
        
        return "editarCliente3.xhtml";
    }
    
    public void busca22(){
       
        cliente = clienteService.buscarClientePorID(cliente.getCodigo());
    }
    
    

}
