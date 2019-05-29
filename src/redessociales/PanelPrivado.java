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
public class PanelPrivado extends Panel {
    private ArrayList<String> palabras_clave;
    private ArrayList<Mensaje> mensajes_seguimiento;

    public PanelPrivado(Perfil propietario) {
        super(propietario);
        this.mensajes_seguimiento = new ArrayList<Mensaje>();
        this.palabras_clave = new ArrayList<String>();
    }
    
    public void claves(String ... claves){
        this.mensajes_seguimiento.clear();
        for(String e : claves){
            this.palabras_clave.add(e);
        }
        for(Mensaje mensaje : this.mensajes){
            for(String clave : this.palabras_clave){
                if(mensaje.getTexto().contains(clave)){
                    this.mensajes_seguimiento.add(mensaje);
                }
            }
        }
    }
    
    protected Mensaje publicar_mensaje(String texto, Perfil autor, Mensaje mensaje){
        Mensaje mensaje_retorno = null;
        if(mensaje == null){
            if(autor.getIdentificador() == this.propietario.getIdentificador()){
                mensaje_retorno = new Mensaje(texto, autor);
                this.mensajes.add(mensaje_retorno);
            }
        }else{
            mensaje_retorno = new Mensaje(texto, autor, mensaje);
            this.mensajes.add(mensaje_retorno);
        }
        if(mensaje_retorno != null){
            for(String clave : this.palabras_clave){
                if(mensaje_retorno.getTexto().contains(clave)){
                    this.mensajes_seguimiento.add(mensaje_retorno);
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

    @Override
    public Boolean borrar_mensaje(Mensaje mensaje) {
        ArrayList<Mensaje> respuestas = this.consultar_respuestas(mensaje);
        if(respuestas.isEmpty()){
            boolean no_borrar = false;
            for(Mensaje e : this.mensajes_seguimiento){
                if(e == mensaje){
                    no_borrar = true;
                }
            }
            if(!no_borrar){
                this.mensajes.remove(mensaje);
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    
    

    public ArrayList<String> getPalabras_clave() {
        return palabras_clave;
    }

    public ArrayList<Mensaje> getMensajes_seguimiento() {
        return mensajes_seguimiento;
    }
    
    
    
    
    
    
}
