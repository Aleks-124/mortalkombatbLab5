package com.mycompany.laba5;



import com.mycompany.laba5.fight.ChangeTexts;
import com.mycompany.laba5.fight.CharacterAction;
import com.mycompany.laba5.fight.Fight;
import com.mycompany.laba5.player.Human;
import com.mycompany.laba5.player.Player;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Game {

    CharacterAction action = new CharacterAction();
    ChangeTexts change = new ChangeTexts();
    Fight fight = new Fight();
    ResultsOperation result;
    public Game(ResultsOperation result ){
        this.result=result;
    }

    public Player NewEnemy() {
        action.setEnemyes();
        Player enemy = action.ChooseEnemy(change);
        change.HP(enemy);
        change.getEnemyHPProgressBar().setMaximum(enemy.getMaxHealth());
        fight.setEnemy(enemy);
        return enemy;
    }
    
    public Human NewHuman(){
        Human human = new Human (1,80,16,1);
        change.HP(human);
        change.getPlayerHPProgressBar().setMaximum(human.getMaxHealth());
        fight.setHuman(human);
        return human;
    }



    }

