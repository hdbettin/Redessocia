/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redessociales;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Usuario
 */
public abstract class Panel {
    protected final Perfil propietario;
    protected ArrayList<Mensaje> mensajes;

    public Panel(Perfil propietario) {
        this.propietario = propietario;
        this.mensajes = new ArrayList<Mensaje>();
    }
    
    public ArrayList<Mensaje> consultar_respuestas(Mensaje mensaje){
        ArrayList<Mensaje> retorno = new ArrayList<Mensaje>();
        for(Mensaje e : this.mensajes){
            if(e.getRespondiendo().getTexto() == mensaje.getTexto()){
                retorno.add(e);
            }
        }
        
        return retorno;
    }
    
    public Boolean borrar_mensaje(Mensaje mensaje){
        ArrayList<Mensaje> respuestas = this.consultar_respuestas(mensaje);
        if(respuestas.isEmpty()){
            this.mensajes.remove(mensaje);
            return true;
        }else{
            return false;
        }
    }
    
    public void ordenar(){
        Collections.sort(this.mensajes, new Ordenar());
    }

    public Perfil getPropietario() {
        return propietario;
    }

    public ArrayList<Mensaje> getMensajes() {
        return mensajes;
    }
    
    
    
    protected abstract Mensaje publicar_mensaje(String texto, Perfil autor, Mensaje mensaje);
    protected abstract Mensaje publicar_mensaje(String mensaje);
}
