/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redessociales;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class Perfil {
    private final String identificador;
    private PanelPrivado panel;
    private HashMap<String, PanelSuscripcion> temas_interes;

    public Perfil(String identificador) {
        this.identificador = identificador;
        this.panel = new PanelPrivado(this);
        this.temas_interes = new HashMap<String, PanelSuscripcion>();
    }
    
    public void anadir_tema(String tema, PanelSuscripcion panelsus){
        this.temas_interes.put(tema, new PanelSuscripcion(this));
    }
    
    public PanelSuscripcion consultar_tema(String consulta){
        PanelSuscripcion retorno = null;
        for(Map.Entry<String, PanelSuscripcion> tema : this.temas_interes.entrySet()){
            if(tema.getKey() == consulta){
                retorno = tema.getValue();
            }
        }
        return retorno;
    }

    public String getIdentificador() {
        return identificador;
    }

    public PanelPrivado getPanel() {
        return panel;
    }

    public HashMap<String, PanelSuscripcion> getTemas_interes() {
        return temas_interes;
    }
    
    
    
    
    
}
