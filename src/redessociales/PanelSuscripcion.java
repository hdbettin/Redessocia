/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redessociales;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class PanelSuscripcion extends Panel {
    private ArrayList<Perfil> colaboradores;

    public PanelSuscripcion(Perfil propietario) {
        super(propietario);
        this.colaboradores = new ArrayList<Perfil>();
    }
    
    public void anadir_colaborador(Perfil colaborador){
        this.colaboradores.add(colaborador);
    }
    public void eliminar_colaborador(Perfil eliminado){
        this.colaboradores.remove(eliminado);
    }

    public ArrayList<Perfil> getColaboradores() {
        return colaboradores;
    }
    
    protected Mensaje publicar_mensaje(String texto, Perfil autor, Mensaje mensaje){
        Mensaje mensaje_retorno = null;
        if(mensaje == null){
            if(autor.getIdentificador() == this.propietario.getIdentificador()){
                mensaje_retorno = new Mensaje(texto, autor);
                this.mensajes.add(mensaje_retorno);
            }else{
                for(Perfil colaborador : this.colaboradores){
                    if(autor.getIdentificador() == colaborador.getIdentificador()){
                        mensaje_retorno = new Mensaje(texto, autor);
                        this.mensajes.add(mensaje_retorno);
                    }
                }
            }
        }else{
            if(autor.getIdentificador() == this.propietario.getIdentificador()){
                mensaje_retorno = new Mensaje(texto, autor, mensaje);
                this.mensajes.add(mensaje_retorno);
            }else{
                for(Perfil colaborador : this.colaboradores){
                    if(autor.getIdentificador() == colaborador.getIdentificador()){
                        mensaje_retorno = new Mensaje(texto, autor, mensaje);
                        this.mensajes.add(mensaje_retorno);
                    }
                }
            }
            
        }
        return mensaje_retorno;
    }
    
    protected Mensaje publicar_mensaje(String texto){
        Mensaje mensaje_retorno = null;
        mensaje_retorno = new Mensaje(texto, this.propietario);
        this.mensajes.add(mensaje_retorno);
        return mensaje_retorno;
    }
    
    
    
}
