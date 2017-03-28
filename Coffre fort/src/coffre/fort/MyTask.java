/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */package coffre.fort;

import java.util.TimerTask;

/**
 *
 * @author murej
 */
class MyTask extends TimerTask {

    private int times = 30;    //Nombre de seconde

    @Override
    public void run() {
        times--;               //Enleve une seconde a chaque fois
        if (times != 0) {                                          // Si le temps est different de 0 alors ...
            System.out.println("                        " + times);  //Affiche le temps sur le coté
        } else {
            System.out.println("La police est arrivée et vous arrête, vous avez perdu !");  //Sinon affiche println et...
            this.cancel();                                  //... Arrete le chrono
            System.exit(0);                                 //Arrete le programme
        }
    }
}
