/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redessociales;

import java.util.Comparator;

/**
 *
 * @author Usuario
 */

public class Mensaje {
    private final String Texto;
    private final Perfil perfil;
    private Mensaje respondiendo;
    private Boolean independiente;

    public Mensaje(String Texto, Perfil perfil) {
        this.Texto = Texto;
        this.perfil = perfil;
        this.independiente = true;
        this.respondiendo = null;
    }

    public Mensaje(String Texto, Perfil perfil, Mensaje respondiendo) {
        this.Texto = Texto;
        this.perfil = perfil;
        this.respondiendo = respondiendo;
        this.independiente = false;
    }
    
    public String toString(){
        return "autor: " + this.getPerfil().getIdentificador() + "mensaje: " + this.getTexto() + "independiente: " + this.getIndependiente();
    }

    public String getTexto() {
        return Texto;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public Mensaje getRespondiendo() {
        return respondiendo;
    }

    public Boolean getIndependiente() {
        return independiente;
    }
    
}


class Ordenar implements Comparator<Mensaje> {
    @Override
    public int compare(Mensaje a, Mensaje b) {
        return a.getPerfil().getIdentificador().compareTo(b.getPerfil().getIdentificador());
    }
}
