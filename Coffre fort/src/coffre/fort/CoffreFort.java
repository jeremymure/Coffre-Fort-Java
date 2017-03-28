/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffre.fort;

/**
 *
 * @author MURE Jérémy
 */

import java.util.Random;
import java.util.Timer;
import java.util.Scanner;

public class CoffreFort {

    public static void main(String[] args) {

        //Consigne
        System.out.println("Consigne :");
        System.out.println("Vous devez saisir votre combinaison, comprise entre 1 et 100, en trois fois. ");
        System.out.println("A chaque saisie, vous avez une indication vous permettant de savoir");
        System.out.println("si votre chiffre est trop haut, trop bas ou si votre chiffre est le bon par rapport au chiffre à déterminer.");
        System.out.println("Lorsqu'un chiffre a été trouvé, vous avez un message vous disant de saisir le second. Lorsque les trois chiffres ont été trouvés, un message vous indique que vous avez trouvé le trésor !!!");
        System.out.println("Cependant, votre tentative de cambriolage a déclenché une alarme silencieuse et l'arrivée de la police. Lorsque le temps est totalement écoulé, la police arrive et vous arrête.");

        System.out.println(""); //Saut à la ligne

        System.out.println("Voulez vous faire une partie ?  1=oui / 2=non");  //Permet à la personne de lire la consigne avant de lancer le chrono
        Scanner lancer = new Scanner(System.in);
        int lancer1 = lancer.nextInt();
        if (lancer1 != 1) {
            System.exit(0);
        } else {

            Timer timer = new Timer("Printer");         //Crée un chrono
            MyTask t = new MyTask();                    //Permet de créer une nouvelle page dans laquel il y aura le code du chrono
            timer.schedule(t, 0, 2000);                 //Permet de régler les seconds

            System.out.println("Entrer les chiffres entre 1 et 100 :");

            for (int i = 0; i < 3; ++i) {               //Permet de répeter la saisie des code trois fois
                System.out.println("");                  //Pour créer un espacement
                Random chiffrei = new Random();          //Créer une valeur aléatoire de nom chiffre1
                int chiffre1 = chiffrei.nextInt(99) + 1;    //Créer une variable int du nom de chiffre1 a qui est affecté le variable aléatoire  enntre 1 et 100
                

                switch (i) {                                               //L'utilisation de ce switch permet d'indiquer où en est l'utilisateur
                    case 0:
                        System.out.println("Premier chiffre:");
                      //System.out.println("Réponse : "+chiffre1);          //Pour afficher la réponse en cas de besoin
                        break;
                    case 1:
                        System.out.println("Second chiffre:");
                      //System.out.println("Réponse : "+chiffre1);          //Pour afficher la réponse en cas de besoin
                        break;
                    default:
                        System.out.println("Troisième chiffre:");
                      //System.out.println("Réponse : "+chiffre1);          //Pour afficher la réponse en cas de besoin
                        break;
                }

                int x = 12;                              //Création d'une variable quelconque qui prend une valeur quelconque

                while (chiffre1 != x) {                 //Créer une boucle qui dit que tant que le chifffre aleatoire est different de x alors la bloucle continu
                    Scanner entre = new Scanner(System.in);    //Créer un une valeur dans laquel l'utililisateur peut entrer un chiffre
                    int entre1 = entre.nextInt();              //Créer un variable int du nom entre1 a laquel on affecte la valeur de l'utilisateur  

                    if (chiffre1 == entre1) {                           //Si le chiffre aleatoire est égale au chiffre entré par l'utilisateur alors...
                        System.out.println("Chiffre trouvé !"); //... affiche le println et...
                        x = entre1;                                   //... et affecte la valeur de entre1 à x ce qui permet de fermer la boucle  

                    } else if (chiffre1 > entre1) {                     //Sinon si le chiffre aleatoire est strictement supérieur au chiffre entré par l'utilisateur alors...
                        System.out.println("Chiffre trop petit, réessayez !");     //... affiche le println
                    } else {                                            //Sinon il affche le println
                        System.out.println("Chiffre trop grand, réessayez !");
                    }
                }
            }
            System.out.println("Ouverture du coffre, vous vous enfuyez avec le butin avant que la police arrive !"); //Affiche se texte si les trois chiffre sont trouvés
            System.exit(0);                     //Arrete le progromme
        }
    }
}
