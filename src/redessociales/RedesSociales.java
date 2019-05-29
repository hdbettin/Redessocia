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
public class RedesSociales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Perfil perfil_juan = new Perfil("juan");
        PanelSuscripcion panel_sus = new PanelSuscripcion(perfil_juan);
        perfil_juan.anadir_tema("java vs c++", panel_sus);
        
        Perfil perfil_pedro = new Perfil("pedro");
        PanelSuscripcion panel_sus2 = new PanelSuscripcion(perfil_pedro);
        perfil_juan.anadir_tema("el nuevo estadio del real madrid", panel_sus2);
        
        Perfil perfil_enrique = new Perfil("enrique");
        
        ArrayList<Perfil> perfiles = new ArrayList<Perfil>();
        perfiles.add(perfil_juan);
        perfiles.add(perfil_pedro);
        perfiles.add(perfil_enrique);
        
        ArrayList<Panel> paneles = new ArrayList<Panel>();
        paneles.add(panel_sus);
        paneles.add(panel_sus2);
        
        
        for(Perfil perfil : perfiles){
            perfil.getPanel().publicar_mensaje("hola soy " + perfil.getIdentificador());
            paneles.add(perfil.getPanel());
        }
        
        for(Panel panel : paneles){
            if(panel instanceof PanelPrivado){
                PanelPrivado panel_privado = (PanelPrivado) panel;
                panel_privado.claves("hola", "real madrid", "futbol");
            }
        }
        
        for(Perfil perfil : perfiles){
            for(Panel panel : paneles){
                if(panel instanceof PanelSuscripcion){
                    PanelSuscripcion panel_suscripcion = (PanelSuscripcion) panel;
                    panel_suscripcion.anadir_colaborador(perfil);
                    panel_suscripcion.publicar_mensaje("Muy interesante", perfil, null);
                }
            }
        }
        
        for(Panel panel : paneles){
            System.out.println("propietario: " + panel.getPropietario().getIdentificador() + " mensajes: "  + 
                    panel.getMensajes().size() + " toString: " + panel.toString());
            /*if(panel instanceof PanelPrivado){
                PanelPrivado panel_privado = (PanelPrivado) panel;
                panel_privado.claves("hola", "real madrid", "futbol");
            }*/
        }
    }
    
}
