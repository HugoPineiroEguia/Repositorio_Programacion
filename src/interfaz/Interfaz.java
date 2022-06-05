/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.applet.AudioClip;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import juego.*;


public class Interfaz extends javax.swing.JFrame {
    
    Icon sonidoMuted;
    Icon sonidoSuena;   
    static Jugador jugador = new Jugador();
    static Monstruo monster = new Monstruo();
    static File fich = new File("Registro.txt");        
    AudioClip musica = java.applet.Applet.newAudioClip(getClass().getResource("/interfaz/MusicaFondo.wav"));
    
    boolean musicaFondo = true;
            
    

    public Interfaz() {        
        initComponents();
        this.setLocationRelativeTo(null);        
        musica.loop();
        sonidoMuted = new ImageIcon("C:\\Users\\pinha\\Documents\\NetBeansProjects\\ProyectoProgramacion\\src\\images\\2849791_volume_sound_speaker_multimedia_icon.png");  
        sonidoSuena = new ImageIcon("C:\\Users\\pinha\\Documents\\NetBeansProjects\\ProyectoProgramacion\\src\\images\\2849792_volume_speaker_sound_media_music_icon.png");  
        jugador.iniciarJugador(jugador);
        monster.nuevoMonstruo(monster, jLabelMonstruos);        
    }    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        estats = new javax.swing.JToggleButton();
        ataque = new javax.swing.JToggleButton();
        adios = new javax.swing.JToggleButton();
        esquive = new javax.swing.JToggleButton();
        curasion = new javax.swing.JToggleButton();
        botonSonido = new javax.swing.JToggleButton();
        jLabelMonstruos = new javax.swing.JLabel();
        JLabel_Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        estats.setBackground(new java.awt.Color(255, 204, 0));
        estats.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 12)); // NOI18N
        estats.setForeground(new java.awt.Color(0, 0, 0));
        estats.setIcon(new ImageIcon(getClass().getResource("/images/Notas_FondoTrans.png"))); // NOI18N
        estats.setText("STATS");
        estats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estatsActionPerformed(evt);
            }
        });
        getContentPane().add(estats, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 520, 170, 110));

        ataque.setBackground(new java.awt.Color(255, 204, 0));
        ataque.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 12)); // NOI18N
        ataque.setForeground(new java.awt.Color(0, 0, 0));
        ataque.setIcon(new ImageIcon(getClass().getResource("/images/Espada_FondoTrans.png"))); // NOI18N
        ataque.setText("ATACAR");
        ataque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ataqueActionPerformed(evt);
            }
        });
        getContentPane().add(ataque, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 170, 110));

        adios.setBackground(new java.awt.Color(255, 51, 51));
        adios.setForeground(new java.awt.Color(255, 255, 255));
        adios.setText("X");
        adios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adiosActionPerformed(evt);
            }
        });
        getContentPane().add(adios, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, 40, 20));

        esquive.setBackground(new java.awt.Color(255, 204, 0));
        esquive.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 12)); // NOI18N
        esquive.setForeground(new java.awt.Color(0, 0, 0));
        esquive.setIcon(new ImageIcon(getClass().getResource("/images/Viento_FondoTrans.png"))); // NOI18N
        esquive.setText("ESQUIVAR");
        esquive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esquiveActionPerformed(evt);
            }
        });
        getContentPane().add(esquive, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 520, 170, 110));

        curasion.setBackground(new java.awt.Color(255, 204, 0));
        curasion.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 12)); // NOI18N
        curasion.setForeground(new java.awt.Color(0, 0, 0));
        curasion.setIcon(new ImageIcon(getClass().getResource("/images/Corazon_FondoTrans.png"))); // NOI18N
        curasion.setText("CURAR");
        curasion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curasionActionPerformed(evt);
            }
        });
        getContentPane().add(curasion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 520, 170, 110));

        botonSonido.setBackground(new java.awt.Color(255, 102, 0));
        botonSonido.setIcon(new ImageIcon(getClass().getResource("/images/2849792_volume_speaker_sound_media_music_icon.png"))); // NOI18N
        botonSonido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSonidoActionPerformed(evt);
            }
        });
        getContentPane().add(botonSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 50, 50));

        jLabelMonstruos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabelMonstruos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 360, 400));

        JLabel_Fondo.setIcon(new ImageIcon(getClass().getResource("/images/PlantillasinBotones.png"))); // NOI18N
        getContentPane().add(JLabel_Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void estatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estatsActionPerformed
       jugador.stats(jugador, monster);    
    }//GEN-LAST:event_estatsActionPerformed

    private void adiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adiosActionPerformed
        System.exit(0);
    }//GEN-LAST:event_adiosActionPerformed

    private void ataqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ataqueActionPerformed
        jugador.atacar(jugador, monster);
        jugador.chequeo(jugador, monster, jLabelMonstruos, fich);
    }//GEN-LAST:event_ataqueActionPerformed

    private void esquiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esquiveActionPerformed
        jugador.esquivar(jugador, monster);
        jugador.chequeo(jugador, monster, jLabelMonstruos, fich);
    }//GEN-LAST:event_esquiveActionPerformed

    private void curasionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curasionActionPerformed
        jugador.curar(jugador, monster);
        jugador.chequeo(jugador, monster, jLabelMonstruos, fich);
    }//GEN-LAST:event_curasionActionPerformed

    private void botonSonidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSonidoActionPerformed
        if (musicaFondo == true){
            musica.stop();
            botonSonido.setIcon(sonidoMuted);
            musicaFondo = false;
        } else if (musicaFondo == false){
            musica.play();
            botonSonido.setIcon(sonidoSuena);
            musicaFondo = true;
        }
    }//GEN-LAST:event_botonSonidoActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }
    
 
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel_Fondo;
    private javax.swing.JToggleButton adios;
    private javax.swing.JToggleButton ataque;
    private javax.swing.JToggleButton botonSonido;
    private javax.swing.JToggleButton curasion;
    private javax.swing.JToggleButton esquive;
    private javax.swing.JToggleButton estats;
    private javax.swing.JLabel jLabelMonstruos;
    // End of variables declaration//GEN-END:variables


 


}
