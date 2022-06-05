package Juego;

import interfaz.Base_Datos;
import java.applet.AudioClip;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static numerorandom.NumeroRandom.numeroRandom;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Jugador extends Personaje implements Iesquivar, Iatacar, Icurar {

    Icon atacar = new ImageIcon("C:\\Users\\pinha\\Documents\\NetBeansProjects\\ProyectoProgramacion\\src\\images\\Espada_FondoVerde.png");
    Icon esquivar = new ImageIcon("C:\\Users\\pinha\\Documents\\NetBeansProjects\\ProyectoProgramacion\\src\\images\\Viento_FondoAzul.png");
    Icon curar = new ImageIcon("C:\\Users\\pinha\\Documents\\NetBeansProjects\\ProyectoProgramacion\\src\\images\\Corazon_FondoRosa.png");
    Icon stats = new ImageIcon("C:\\Users\\pinha\\Documents\\NetBeansProjects\\ProyectoProgramacion\\src\\images\\Notas_FondoRaro.png");
    
    Base_Datos bd = new Base_Datos();
    
    PreparedStatement ps;
    String nombre;
    int puntos;
    int objetivo;
    String objetivoCumplido;
    Scanner sc;
    BufferedWriter bf;
    FileWriter fich;
    
    boolean guardar = false;
    boolean message = false;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(int objetivo) {
        this.objetivo = objetivo;
    }

    public String getObjetivoCumplido() {
        return objetivoCumplido;
    }

    public void setObjetivoCumplido(String objetivoCumplido) {
        this.objetivoCumplido = objetivoCumplido;
    }
    
    

    public void iniciarJugador(Jugador jugador) {
        nombre = JOptionPane.showInputDialog(null, new JLabel("¿Como te llamas?", stats, JLabel.LEADING), "ATAQUE", JOptionPane.PLAIN_MESSAGE);
        objetivo = Integer.parseInt(JOptionPane.showInputDialog(null, new JLabel("¿Cuantos monstruos te ves capaz de derrotar?", stats, JLabel.LEADING), "ATAQUE", JOptionPane.PLAIN_MESSAGE));
        jugador.setHp(50);
        
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public void atacar(Jugador jugador, Monstruo monster) {
        int opcion;
        boolean bucle = true;
        jugador.setAd(numeroRandom(5, 20));
        monster.setAd(numeroRandom(5, 15));
        while (bucle == true) {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, new JLabel("<html>¿Como quieres atacar?<p>1.Espada<p>2.Magia<p>3.Informacion<p>4.Volver</html>", atacar, JLabel.CENTER), "ATAQUE", JOptionPane.PLAIN_MESSAGE));

                switch (opcion) {
                    case 1:
                        jugador.setHp(jugador.getHp() - monster.getAd());
                        monster.setHp(monster.getHp() - jugador.getAd());
                        JOptionPane.showMessageDialog(null, "Golpeaste con " + jugador.getAd() + " puntos de danho.\nEl monstruo te ataco y recibiste " + monster.getAd() + " puntos de danho.", "ATAQUE ESPADA", JOptionPane.WARNING_MESSAGE, atacar);
                        bucle = false;
                        break;
                    case 2:
                        int option = numeroRandom(0, 2);
                        switch (option) {
                            case 1:
                                monster.setHp(monster.getHp() - (jugador.getAd() / 2));
                                JOptionPane.showMessageDialog(null, "Golpeaste con " + jugador.getAd() / 2 + " puntos de danho.\nEsquivaste el ataque del monstruo", "ATAQUE MAGIA", JOptionPane.WARNING_MESSAGE, atacar);
                                break;
                            case 2:
                                jugador.setHp(jugador.getHp() - monster.getAd());
                                monster.setHp(monster.getHp() - (jugador.getAd() / 2));
                                JOptionPane.showMessageDialog(null, "Golpeaste con " + jugador.getAd() / 2 + " puntos de danho.\nEl monstruo te ataco y recibiste " + monster.getAd() + " puntos de danho.", "ATAQUE ESPADA", JOptionPane.WARNING_MESSAGE, atacar);
                                break;
                        }
                        bucle = false;
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Con la espada provocas daño al enemigo mediante un tajo,\npero recibes daño", "INFORMACION", JOptionPane.WARNING_MESSAGE, atacar);
                        JOptionPane.showMessageDialog(null, "Un ataque de magia hará que el enemigo reciba un daño menor,\npero existe la posibilidad de no ser dañado por el monstruo", "INFORMACION", JOptionPane.WARNING_MESSAGE, atacar);
                        break;
                    case 4:
                        bucle = false;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Escribe lo que quieres hacer de nuevo", "EXCEPCION", JOptionPane.WARNING_MESSAGE, atacar);
                        break;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Escribe lo que quieres hacer de nuevo", "EXCEPCION", JOptionPane.WARNING_MESSAGE, stats);
            }
        }
    }

    @Override
    public void esquivar(Jugador jugador, Monstruo monster) {
        boolean bucle = true;
        while (bucle == true) {
            try {
                int option = Integer.parseInt(JOptionPane.showInputDialog(null, new JLabel("<html>¿Quieres esquivar?<p>1.Esquive<p>2.Informacion<p>3.Volver</html>", esquivar, JLabel.LEADING), "ESQUIVAR", JOptionPane.PLAIN_MESSAGE));
                switch (option) {
                    case 1:
                        jugador.setAd(numeroRandom(5, 20));
                        monster.setAd(numeroRandom(5, 15));
                        int opcion = numeroRandom(0, 2);
                        switch (opcion) {
                            case 1:
                                jugador.setHp(jugador.getHp() - monster.getAd());
                                JOptionPane.showMessageDialog(null, "Te tropezaste y no pudiste esquivar el golpe,\nel monstruo te ataca y recibes un daño de " + monster.getAd() + " puntos de vida", "ESQUIVAR", JOptionPane.WARNING_MESSAGE, esquivar);
                                break;
                            case 2:
                                monster.setHp(monster.getHp() - jugador.getAd());
                                JOptionPane.showMessageDialog(null, "Esquivaste al monstruo sin problema,\natacas causando un total de " + jugador.getAd() + " puntos de danho", "ESQUIVAR", JOptionPane.WARNING_MESSAGE, esquivar);
                                break;
                        }
                        bucle = false;
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Si logras esquivar devolverás un golpe que danhará al enemigo\naunque puede que tropieces y recibas una ataque directo del enemigo", "INFORMACION", JOptionPane.WARNING_MESSAGE, esquivar);
                        break;
                    case 3:
                        bucle = false;
                        break;
                    default:
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Escribe lo que quieres hacer de nuevo", "EXCEPCION", JOptionPane.WARNING_MESSAGE, stats);
            }
        }
    }

    @Override
    public void curar(Jugador jugador, Monstruo monster) {
        boolean bucle = true;
        while (bucle == true) {
            try {
                int option = Integer.parseInt(JOptionPane.showInputDialog(null, new JLabel("<html>¿Quieres curarte?<p>1.Curar<p>2.Informacion<p>3.Volver</html>", curar, JLabel.LEADING), "ESQUIVAR", JOptionPane.PLAIN_MESSAGE));
                switch (option) {
                    case 1:
                        monster.setAd(numeroRandom(5, 15));
                        int curacion = numeroRandom(1, 15);
                        jugador.setHp(jugador.getHp() - monster.getAd());
                        jugador.setHp(jugador.getHp() + curacion);
                        JOptionPane.showMessageDialog(null, "Te has curado " + curacion + " puntos de vida.\nEl monstruo te ha infrigido un danho de " + monster.getAd(), "CURAR", JOptionPane.WARNING_MESSAGE, curar);
                        bucle = false;
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Te curaras haciendo que aumenten tus puntos de vida,\ntambien recibes un golpe directo del enemigo", "INFORMACION", JOptionPane.WARNING_MESSAGE, curar);
                        break;
                    case 3:
                        bucle = false;
                        break;
                    default:
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Escribe lo que quieres hacer de nuevo", "EXCEPCION", JOptionPane.WARNING_MESSAGE, stats);
            }
        }
    }

    public void stats(Jugador jugador, Monstruo monster) {
        JOptionPane.showMessageDialog(null, "Vida jugador: " + jugador.getHp() + "\nVida del monstruo: " + monster.getHp(), "STATS", JOptionPane.WARNING_MESSAGE, stats);
    }

    public void chequeo(Jugador jugador, Monstruo monster, JLabel bicho, File fich) {
        if (monster.getHp() <= 0) {
            monster.nuevoMonstruo(monster, bicho);
            jugador.setPuntos(jugador.getPuntos() + 1);
            JOptionPane.showMessageDialog(null, "Has derrotado al monstruo.\nHas matado ya a " + jugador.getPuntos() + " monstruos.", "ENEMIGO DERROTADO", JOptionPane.WARNING_MESSAGE, stats);
        }
        if (jugador.getHp() <= 0) {
            if (jugador.getObjetivo()<jugador.getPuntos()){
                jugador.setObjetivoCumplido("Cumplio con lo que se propuso");
            }
            else{
                jugador.setObjetivoCumplido("No cumplio con lo que esperaba");
            }
            boolean bucle = true;
            
            if (message == false){
                JOptionPane.showMessageDialog(null, "El monstruo te ha derrotado, tienes 0 puntos de vida.\nAcabaste la partida con " + jugador.getPuntos() + " puntos.", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE, stats);
                message = true;
            }
            while (bucle == true) {
                try {
                    int option = Integer.parseInt(JOptionPane.showInputDialog(null, new JLabel("<html>¿Que quieres hacer ahora?<p>1.Ver registro<p>2.Guardar registro de la partida<p>3. Consultar base de datos<p>4.Salir</html>", stats, JLabel.LEADING), "FIN DEL JUEGO", JOptionPane.PLAIN_MESSAGE));
                    switch (option) {
                        case 1:
                            mostrarRegistro(fich);
                            break;
                        case 2:
                            if (guardar == false) {
                                guardarRegistro(jugador, fich);
                                guardarBaseDatos(jugador);
                                JOptionPane.showMessageDialog(null, "Se ha guardado correctamente esta partida", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE, stats);
                                guardar = true;
                            } else {
                                JOptionPane.showMessageDialog(null, "Ya se ha guardado esta partida, no puedes volver a guardarla", "FIN DEL JUEGO", JOptionPane.WARNING_MESSAGE, stats);
                            }
                            break;
                        case 3:
                            bd.setVisible(true); 
                            bucle = false;
                            break;
                        case 4:
                            System.exit(0);
                            break;
                    }
                    
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Escribe lo que quieres hacer de nuevo", "EXCEPCION", JOptionPane.WARNING_MESSAGE, stats);
                }

            }

        }
        if (jugador.getHp() > 50) {
            jugador.setHp(50);
        }
    }
    
    public void guardarBaseDatos(Jugador jugador){
        
        Conexion.instance.getInstance();
        
        try {
            Connection con = Conexion.instance.establecerConexion();
            ps = con.prepareStatement("INSERT INTO partidas (NombreJugador, Objetivo, Monstruos, ObjetivoConseguido) VALUES (?,?,?,?)");
            ps.setString(1, jugador.getNombre());
            ps.setInt(2, jugador.getObjetivo());
            ps.setInt(3, jugador.getPuntos());
            ps.setString(4, jugador.getObjetivoCumplido());  
            ps.execute();           
            
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    

    
    
    
    

    public void guardarRegistro(Jugador jugador, File file) {
        try {
            fich = new FileWriter(file, true);
            bf = new BufferedWriter(fich);
            bf.write(nombre + ": " + puntos + " puntos\n");
        } catch (IOException ex) {
            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bf.close();
            } catch (IOException ex) {
                Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    public void mostrarRegistro(File fich){
        String puntuacion;
        String puntuaciones = "Puntuaciones:";
        try {
            sc = new Scanner(fich);
            while(sc.hasNextLine()){
                puntuacion = sc.nextLine();
                puntuaciones = puntuaciones + "\n" + puntuacion;
            }
            JOptionPane.showMessageDialog(null, puntuaciones, "PUNTUACION", JOptionPane.WARNING_MESSAGE, stats);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
