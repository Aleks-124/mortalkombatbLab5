
package com.mycompany.laba5.fight;

import com.mycompany.laba5.player.Human;
import com.mycompany.laba5.player.Items;
import com.mycompany.laba5.player.Player;

import javax.swing.*;


public class ChangeTexts {
    public void setPlayerHPProgressBar(JProgressBar playerHPProgressBar) {
        this.playerHPProgressBar = playerHPProgressBar;
    }

    public void setChooseOptionBox(JComboBox<String> chooseOptionBox) {
        this.chooseOptionBox = chooseOptionBox;
    }


    public void setEnemyDamageCount(JLabel enemyDamageCount) {
        this.enemyDamageCount = enemyDamageCount;
    }

    public void setEnemyDamageLabel(JLabel enemyDamageLabel) {
        this.enemyDamageLabel = enemyDamageLabel;
    }

    public void setEnemyHPPoints(JLabel enemyHPPoints) {
        this.enemyHPPoints = enemyHPPoints;
    }

    public void setEnemyName(JLabel enemyName) {
        this.enemyName = enemyName;
    }

    public void setEnemyPicture(JLabel enemyPicture) {
        this.enemyPicture = enemyPicture;
    }


    public void setInformationLabel(JLabel informationLabel) {
        this.informationLabel = informationLabel;
    }






    public void setjLabel20(JLabel jLabel20) {
        this.jLabel20 = jLabel20;
    }


    public void setjLabel29(JLabel jLabel29) {
        this.jLabel29 = jLabel29;
    }




    public void setEnemyLevel(JLabel enemyLevel) {
        this.enemyLevel = enemyLevel;
    }

    public void setEnemyHPProgressBar(JProgressBar enemyHPProgressBar) {
        this.enemyHPProgressBar = enemyHPProgressBar;
    }


    public void setHpPoints(JLabel hpPoints) {
        this.hpPoints = hpPoints;
    }

    private javax.swing.JLabel hpPoints;
    private javax.swing.JComboBox<String> chooseOptionBox;
    private javax.swing.JLabel enemyDamageCount;
    private javax.swing.JLabel enemyDamageLabel;
    private javax.swing.JLabel enemyHPPoints;
    private javax.swing.JProgressBar enemyHPProgressBar;
    private javax.swing.JLabel enemyLevel;
    private javax.swing.JLabel enemyName;
    private javax.swing.JLabel enemyPicture;
    private javax.swing.JLabel informationLabel;


    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JLabel newLevelLabel;
    private javax.swing.JProgressBar playerHPProgressBar;
    private javax.swing.JLabel playerLevel;
    private javax.swing.JLabel playerName;
    private javax.swing.JLabel playerPicture;
    private javax.swing.JLabel pointCountLabe;
    private javax.swing.JLabel pointsLabel;
    private javax.swing.JButton weakBtn;



    public void NewRoundTexts(Player human, Player enemy, JProgressBar pr1,
            JProgressBar pr2, JLabel label, JLabel label2, JLabel label3,
            JLabel label4, JLabel label5, JLabel label6, JLabel label7, JLabel label8, JLabel label9,
            int i, Items[] items, JRadioButton rb1, JRadioButton rb2, JRadioButton rb3) {
        label.setText(Integer.toString(((Human) human).getPoints()));
        label2.setText(Integer.toString(((Human) human).getExperience()) + "/" + ((Human) human).getNextExperience());
        label3.setText(Integer.toString(human.getLevel()) + " level");
        label4.setText(Integer.toString(enemy.getLevel()) + " level");
        label5.setText(Integer.toString(human.getMaxHealth()) + "/" + Integer.toString(human.getMaxHealth()));
        label6.setText(Integer.toString(enemy.getMaxHealth()) + "/" + Integer.toString(enemy.getMaxHealth()));
        label7.setText(Double.toString(human.getDamage()));
        if (i % 2 == 1) {
            label8.setText("Your turn");
        }
        else{
            label8.setText(enemy.getName()+"'s turn");
        }
        BagText(items, rb1, rb2, rb3);
        label9.setText("");
    }

    public void RoundTexts(Player human, Player enemy, int i) {
        if (enemy.getHealth() >= 0) {
            enemyHPPoints.setText(Integer.toString(enemy.getHealth()) + "/" + Integer.toString(enemy.getMaxHealth()));
        } else {
            enemyHPPoints.setText("0/" + Integer.toString(enemy.getMaxHealth()));
        }
        if (human.getHealth() >= 0) {
            hpPoints.setText(Integer.toString(human.getHealth()) + "/" + Integer.toString(human.getMaxHealth()));
        } else {
            hpPoints.setText("0/" + Integer.toString(human.getMaxHealth()));
        }
        if (i % 2 == 1) {
            this.getjLabel3().setText("Your turn");
        }
        else{
            this.getjLabel3().setText(enemy.getName()+"'s turn");
        }
    }
    
    public void EndGameText(Human human, JLabel label){
        if(human.getWin()==12){
            label.setText("Победа на вашей стороне");
        }
        else {
            label.setText("Победа не на вашей стороне");
        }
    }
    
    public void BagText( Items[] items, JRadioButton rb1, JRadioButton rb2, JRadioButton rb3){
        rb1.setText(items[0].getName()+", "+items[0].getCount()+" шт");
        rb2.setText(items[1].getName()+", "+items[1].getCount()+" шт");
        rb3.setText(items[2].getName()+", "+items[2].getCount()+" шт");
    }

    public JLabel getHpPoints() {
        return hpPoints;
    }

    public JComboBox<String> getChooseOptionBox() {
        return chooseOptionBox;
    }



    public JLabel getEnemyDamageCount() {
        return enemyDamageCount;
    }


    public JLabel getEnemyHPPoints() {
        return enemyHPPoints;
    }

    public JProgressBar getEnemyHPProgressBar() {
        return enemyHPProgressBar;
    }


    public JLabel getEnemyName() {
        return enemyName;
    }

    public JLabel getEnemyPicture() {
        return enemyPicture;
    }



    public JLabel getInformationLabel() {
        return informationLabel;
    }



    public JDialog getjDialog1() {
        return jDialog1;
    }

    public JDialog getjDialog2() {
        return jDialog2;
    }


    public JFrame getjFrame1() {
        return jFrame1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getjLabel20() {
        return jLabel20;
    }



    public JLabel getjLabel29() {
        return jLabel29;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }



    public JRadioButton getjRadioButton3() {
        return jRadioButton3;
    }


    public JLabel getNewLevelLabel() {
        return newLevelLabel;
    }

    public JProgressBar getPlayerHPProgressBar() {
        return playerHPProgressBar;
    }


    public void HP(Player player) {

        if (player.getHealth() >= 0 && player instanceof Human) {
            playerHPProgressBar.setValue(player.getHealth());
        }
        else if(player.getHealth() <= 0 && player instanceof Human) {
            playerHPProgressBar.setValue(0);
        }
        else if(player.getHealth() >= 0) {
            enemyHPProgressBar.setValue(player.getHealth());
        }
        else if(player.getHealth() <= 0 ) {
            playerHPProgressBar.setValue(0);
        }
    }

}
