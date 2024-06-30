/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laba5.fight;


import com.mycompany.laba5.Location;
import com.mycompany.laba5.Result;
import com.mycompany.laba5.enemy.*;
import com.mycompany.laba5.fabrics.EnemyFabric;
import com.mycompany.laba5.player.Human;
import com.mycompany.laba5.player.Items;
import com.mycompany.laba5.player.Player;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;

/**
 *
 * @author Мария
 */
public class Fight {

    private Player human;
    private Player enemy;
    private ChangeTexts change = new ChangeTexts();
    private int kind_attack[] = {0};
    private int experiences[] = {40, 90, 180, 260, 410};
    private EnemyFabric fabric = new EnemyFabric();
    public int i = 1;
    private int k = -1;
    private int stun = 0;

    Location location;
    public void Move(Player p1, Player p2) {
        if (stun == 1) {
            p1.setAttack(-1);
        }
        System.out.println(p1.getAttack() + " || " + p2.getAttack());
        switch (Integer.toString(p1.getAttack()) + Integer.toString(p2.getAttack())) {
            case "10":
                if (p1 instanceof ShaoKahn & Math.random() < 0.15) {
                    p2.setHealth(-(int) (p1.getDamage() * 0.5));
                    change.getInformationLabel().setText("Your block is broken");

                } else {
                    p1.setHealth(-(int) (p2.getDamage() * 0.5));
                    change.getInformationLabel().setText(p2.getName() + " counterattacked");
                }
                break;
            case "11":
                p2.setHealth(-p1.getDamage());
                change.getInformationLabel().setText(p1.getName() + " attacked");
                break;
            case "00":
                if (Math.random() <= 0.5) {
                    stun = 1;
                }
                change.getInformationLabel().setText("Both defended themselves");
                break;
            case "01":
                change.getInformationLabel().setText(p1.getName() + " didn't attacked");
                break;
            case "-10":
                change.getjLabel29().setText(p1.getName() + " was stunned");
                stun = 0;
                change.getInformationLabel().setText(p2.getName() + " didn't attacked");
                break;
            case "-11":
                p1.setHealth(-p2.getDamage());
                change.getjLabel29().setText(p1.getName() + " was stunned");
                stun = 0;
                change.getInformationLabel().setText(p2.getName() + " attacked");
                break;
            case "20":
            case  "2-1":
                    if (Math.random() < 0.75){
                            p2.setDebuff(p2.getLevel());
                        change.getjLabel29().setText(p1.getName() + "used Weakness");
                        change.getInformationLabel().setText(p2.getName() + " are weakened");}
                    break;
            case "02" :
            case "-12":
                 if (Math.random() < 0.75){
                        p1.setDebuff(p1.getLevel());
                     change.getInformationLabel().setText(p2.getName() + "used Weakness");
                     change.getjLabel29().setText(p1.getName() + " are weakened"); }
                 break;
            case "12":
                       p2.setHealth(-p1.getDamage() * 1.15);
                change.getjLabel29().setText(p1.getName() + " attacked");
                change.getInformationLabel().setText("Failed to weak oppponent");
                    break;
            case "21":
                     p1.setHealth(-p2.getDamage() * 1.15);
                change.getjLabel29().setText(p1.getName() + " attacked");
                change.getjLabel29().setText("Failed to weak oppponent");
                     break;
            case  "30" :
            case  "3-1":
              p1.setHealth((p1.getMaxHealth()-p1.getHealth())*0.5);
                change.getjLabel29().setText( p1.getName() + " regenerated");
                break;
           case  "03" :
           case  "-13":     
                p2.setHealth((p2.getMaxHealth()-p2.getHealth())* 0.5);
               change.getInformationLabel().setText( p2.getName() + " regenerated");
                break;
           case "13":
               p2.setHealth(-p1.getDamage() * 2);
               change.getjLabel29().setText(p1.getName() + " attacked");
               change.getInformationLabel().setText("Failed to regenerate");
                break;
           case "31":
                p1.setHealth(-p2.getDamage() * 2);
               change.getInformationLabel().setText(p2.getName() + " attacked");
               change.getjLabel29().setText("Failed to regenerate");
                break;
           case "23":
               p2.setDebuff(p1.getLevel());
              p2.setHealth((p2.getMaxHealth()-p2.getHealth())* 0.5);
               change.getjLabel29().setText(p1.getName() + " used Weakness");
               change.getInformationLabel().setText(p2.getName() + " regenerated");
               break;
           case  "32":
               p1.setDebuff(p2.getLevel());
               p1.setHealth((p1.getMaxHealth()-p1.getHealth())*0.5);
               change.getInformationLabel().setText(p2.getName() + " used Weakness");
               change.getjLabel29().setText(p1.getName() + "regenerated");
               break;
        }
        
    }

    public void Hit(Player human, Player enemy, int a, CharacterAction action,
              ArrayList<Result> results, Items[] items ) {
        human.setAttack(a);

        if (k < kind_attack.length - 1) {
            k++;
        } else {
            kind_attack = action.ChooseBehavior(enemy, action);
            k = 0;
        }
        
        if (enemy.isWizard() && Math.random() < 0.15){
            enemy.setAttack(2); // 2 - ОСЛАБЛЕНИЕ
        }
        else if (enemy.getName().equals("Shao Kahn") && Math.random() < 0.2) {
            enemy.setAttack(3); // 3 - РЕГЕНЕРАЦИЯ
        }
        else{
            enemy.setAttack(kind_attack[k]);
        }
        human.restartDebuff();
        enemy.restartDebuff();
        if (i % 2 == 1) {
            Move(human, enemy);
        } else {
            Move(enemy, human);
        }
        i++;
        change.RoundTexts(human, enemy, i);
        change.HP(human);
        change.HP(enemy);
        if (human.getHealth() <= 0 & items[2].getCount() > 0) {
            human.setNewHealth((int) (human.getMaxHealth() * 0.05));
            items[2].setCount(-1);
            change.HP(human);
            change.getHpPoints().setText(human.getHealth() + "/" + human.getMaxHealth());
            change.getjRadioButton3().setText(items[2].getName() + ", " + items[2].getCount() + " шт");
            change.getjLabel29().setText("Вы воскресли");
        }
       
        
        if (human.getHealth() <= 0 | enemy.getHealth() <= 0) {
            if (location.getCurrentRound() == location.getRoundsInLocation() || human.getHealth()<=0) {
                EndFinalRound(((Human) human), action, results);
                
            } else {
                EndRound(human, enemy, action, items );
            }
        }
    }

    public void EndRound(Player human, Player enemy,
            CharacterAction action, Items[] items ) {

        change.getjDialog1().setVisible(true);
        change.getjDialog1().setBounds(300, 150, 700, 600);
        if (human.getHealth() > 0) {

            change.getjLabel3().setText("You win");
            ((Human) human).setWin();

            if (enemy instanceof ShaoKahn) {
                action.AddItems(38, 23, 8, items);
                action.AddPointsBoss(((Human) human), action.getEnemyes());
                
            } else {
                action.AddItems(25, 15, 5, items);
                Boolean isLevelUp = action.AddPoints(((Human) human), action.getEnemyes());
                if (isLevelUp) {
                    change.getChooseOptionBox().setSelectedIndex(0);
                    change.getChooseOptionBox().setVisible(true);
                    change.getNewLevelLabel().setVisible(true);
                    
                }
                
            }
        } else {
            change.getjLabel3().setText(enemy.getName() + " win");
        }

        i = 1;
        k = -1;
        kind_attack = ResetAttack();
        

    }

    public void EndFinalRound(Human human, CharacterAction action,
            ArrayList<Result> results) {
        String text = "Победа не на вашей стороне";
         
        if (human.getHealth() > 0) {
            human.setWin();
            action.AddPoints(human, action.getEnemyes());
            text = "Победа на вашей стороне";
        }
         boolean top = false;
        if (results == null) {
            top = true;
        } else {
            int i = 0;
            for (int j = 0; j < results.size(); j++) {
                if (human.getPoints() < results.get(j).getPoints()) {
                    i++;
                }
            }
            if (i < 10) {
                top = true;
            }
        }
        
      
            if (top) {
                change.getjDialog1().setVisible(true);
                change.getjDialog1().setBounds(150, 150, 600, 500);
                change.getjLabel1().setText(text);
        } else {
                change.getjDialog2().setVisible(true);
                change.getjDialog2().setBounds(150, 150, 470, 360);
            change.getjLabel20().setText(text);
        }
        change.getjFrame1().dispose();
        }


    public int[] ResetAttack() {
        int a[] = {0};
        return a;
    }

    public Player NewRound(Player human, CharacterAction action) {
        this.human = human;

        if (location.getCurrentRound()==location.getRoundsInLocation()) {
            enemy = action.ChooseBoss( human.getLevel(), human, change);
            location.prepareNewLocation();
        } else  {
            
            enemy = action.ChooseEnemy(change);
            
        }
        location.increseCurrentLocationsCount();
        change.getPlayerHPProgressBar().setMaximum(human.getMaxHealth());
        change.getEnemyHPProgressBar().setMaximum(enemy.getMaxHealth());
        human.setNewHealth(human.getMaxHealth());
        enemy.setNewHealth(enemy.getMaxHealth());
        change.HP(human);
        change.HP(enemy);

        
        
        
        return enemy;
    }
    
    



    
    public void setHuman(Human human) {
        this.human = human;
    }
    
    public void setEnemy(Player enemy) {
        this.enemy = enemy;
    }
}
