package Juego;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static numerorandom.NumeroRandom.numeroRandom;

public class Monstruo extends Personaje{

    Icon bicho1 = new ImageIcon("C:/Users/pinha/OneDrive/Documentos/DAM/PROG/Juego/Bichos/BichoAzul.png");
    Icon bicho2 = new ImageIcon("C:/Users/pinha/OneDrive/Documentos/DAM/PROG/Juego/Bichos/BichoVerde.png");
    Icon bicho3 = new ImageIcon("C:/Users/pinha/OneDrive/Documentos/DAM/PROG/Juego/Bichos/BichoAmarillo.png");
    Icon bicho4 = new ImageIcon("C:/Users/pinha/OneDrive/Documentos/DAM/PROG/Juego/Bichos/BichoRojo.png");
    Icon[] bichos = {bicho1,bicho2,bicho3,bicho4};

    public void nuevoMonstruo(Monstruo monster, JLabel bicho){
        monster.setHp(numeroRandom(30, 60));
        int bichorandom = numeroRandom(-1, 3);
        bicho.setIcon(bichos[bichorandom]);
    }

}
