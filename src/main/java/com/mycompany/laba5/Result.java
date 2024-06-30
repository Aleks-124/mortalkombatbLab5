package com.mycompany.laba5;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Result {
    
    private String name;
    private int points;

     public Result(String n, int p){
        this.name=n;
        this.points=p;
    }

    
    public String getName(){
        return this.name;
    }
    public int getPoints(){
        return this.points;
    }



}
