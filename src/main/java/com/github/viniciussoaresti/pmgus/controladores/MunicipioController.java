/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.viniciussoaresti.pmgus.controladores;


import com.github.viniciussoaresti.pmgus.infraestrutura.repositorios.comportamentos.RepositorioGenerico;
import com.github.viniciussoaresti.pmgus.infraestrutura.repositorios.implementacoes.RepositorioMunicipioImplBD;
import com.github.viniciussoaresti.pmgus.negocio.Municipio;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author BarrosPedro
 */

@ManagedBean
@SessionScoped
public class MunicipioController {
     private RepositorioGenerico<Municipio,Integer> repositorioMunicipio = null;
    private Municipio municipioCadastro;
    private Municipio selectedMunicipio;
   
    Municipio municipio = new Municipio();
    
    public MunicipioController(){
        this.repositorioMunicipio = new RepositorioMunicipioImplBD();
        this.municipioCadastro = new Municipio();
    }
    
    public void inserir(){
        
        this.repositorioMunicipio.inserir(this.municipioCadastro);
        this.municipioCadastro = new Municipio();
        
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso!","A municipio foi cadastrada com sucesso!"));
    }
    
    public void alterar(Municipio c){
        this.repositorioMunicipio.alterar(c);
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso!","A municipio foi alterada com sucesso!"));
    }
    
    public Municipio recuperarMunicipio(int codigo){
        return this.repositorioMunicipio.recuperar(codigo);
    }
    
    public void deletar(){
        this.repositorioMunicipio.deletar(selectedMunicipio);
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso!","A municipio foi deletada com sucesso!"));
    }
    
    public List<Municipio> recuperarTodosMunicipios(){
        return this.repositorioMunicipio.recuperarTodos();
    }

    public Municipio getMunicipioCadastro() {
        return municipioCadastro;
    }

    public void setMunicipioCadastro(Municipio municipioCadastro) {
        this.municipioCadastro = municipioCadastro;
    }

    public Municipio getSelectedMunicipio() {
        return selectedMunicipio;
    }

    public void setSelectedMunicipio(Municipio selectedMunicipio) {
        this.selectedMunicipio = selectedMunicipio;
    }

    public RepositorioGenerico<Municipio,Integer> getRepositorioMunicipio() {
        return repositorioMunicipio;
    }

    public void setRepositorioMunicipio(RepositorioGenerico<Municipio, Integer> repositorioMunicipio) {
        this.repositorioMunicipio= repositorioMunicipio;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
}
