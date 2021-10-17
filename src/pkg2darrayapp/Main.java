/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2darrayapp;

import javax.swing.JOptionPane;

/**
 *
 * @author tresorkl
 */
public class Main {
    
    
    
    //populate method
    public static void populateData(int [][] athleteData){
        final int RAW = 4;
        final int column = 4;
         String raceCode,raceTime;
         
         for(int i = 0 ; i < RAW; i++){
            
            raceCode = JOptionPane.showInputDialog(null,"ENTER RACE CODE " +(i+1),"RACE CODE"+(i+1),JOptionPane.INFORMATION_MESSAGE);
            athleteData[i][0] = Integer.parseInt(raceCode);
            
            
            for(int j=1 ; j < column;j++){
                raceTime = JOptionPane.showInputDialog(null,"ENTER RACE TIME " +(j),"RACE TIME OF RACE CODE "+(i+1),JOptionPane.INFORMATION_MESSAGE);
                athleteData[i][j] = Integer.parseInt(raceTime);
                 
            }
            
        }
    }
    
    //DisplayData
    public static void DisplayData(int [][] athleteData){
        final int RAW = 4;
        final int column = 4;
        String concatData="";
        
        for(int i = 0; i< RAW;i++){
            
            for(int j = 0   ; j< column; j++){

                
                concatData  =   (concatData + ( athleteData[i][j])).concat(" ");
            }
            
            concatData = concatData.concat("\n");
        }
         
         JOptionPane.showMessageDialog(null,concatData,"ATHLETE DATA",JOptionPane.INFORMATION_MESSAGE);
    }

    //sort 2Darray
    
    public static void sortAthleteData(int [][] athleteData){
         final int RAW = 4;
        final int column = 4;
        int dataAtI, dataAtj, tempCode,tampTime;
        
        for(int i = 0; i< RAW; i++){
            
            for(int j = i+1; j< RAW; j++){
                dataAtI =  athleteData[i][0];
                dataAtj =  athleteData[j][0];
                
                if(dataAtI < dataAtj){
                    
                    
                    int data1AtI = athleteData[i][1];
                    int data2AtI = athleteData[i][2];
                    int data3AtI = athleteData[i][3];
                    
                    int data1AtJ = athleteData[j][1];
                    int data2AtJ = athleteData[j][2];
                    int data3AtJ = athleteData[j][3];
                    
                    
                    athleteData[i][0] = dataAtj;
                    athleteData[i][1] = data1AtJ;
                    athleteData[i][2] = data2AtJ;
                    athleteData[i][3] = data3AtJ;
                    
                    
                    athleteData[j][0] = dataAtI;
                    athleteData[j][1] = data1AtI;
                    athleteData[j][2] = data2AtI;
                    athleteData[j][3] = data3AtI;
                    
                }
            }
        }
        
        
    }
    
    //searchIN2D
    public static int search2D(int [][] athleteData,int code){
        
        int x=0;
        int isFound =-1;
        
        
        while(x < athleteData.length && code != athleteData[x][0]){
            x++;
        }
        if(x == athleteData.length){
            isFound = -1;
        }else{
            isFound = x;
        }
        
        return isFound;
    }
    
    
    public static void avarage2D(int isFound, int [][] athleteData){
        int average = 0,sum =0;
        
        for(int i = 1 ; i< 4; i++){
            
            sum += athleteData[isFound][i] ;
            average = sum/3;
            
        }
        
        JOptionPane.showMessageDialog(null,"CODE FOUND "+ athleteData[isFound][0] +" HAS THE AVERAGE TIME OF "+average ,"AVERAGE AKED",average);
        
    }
    
    
    
    
   
    public static void main(String[] args) {    
        // TODO code application logic here
        
        final int RAW = 4;
        final int column = 4;
        int [][] athleteData = new int[RAW][column];
        String raceCode,raceTime;
        int average, isFound;
        int code;
        
        populateData(athleteData);
        DisplayData( athleteData);
        sortAthleteData( athleteData);
        DisplayData( athleteData);
        
        
        String strCode = JOptionPane.showInputDialog(null,"PLEASE ENTER THE ATHLETE CODE", "SEARCHING ATHLETE CODE",JOptionPane.INFORMATION_MESSAGE);
        code = Integer.parseInt(strCode);
        
        isFound = search2D(athleteData, code);
        
        if(isFound == -1 ){
            
            JOptionPane.showConfirmDialog(null,code + "is not found","ERROR", JOptionPane.ERROR_MESSAGE);
            
        }else{
            
          
            
            String  dataFound = "";
             
             for(int i = 1; i < 4; i++){
                 dataFound = (dataFound + athleteData[isFound][i]).concat(", ");
             }
            
             JOptionPane.showConfirmDialog(null,code + " is found and the times races are "+  dataFound ,"FOUND AND AVERAGE", JOptionPane.INFORMATION_MESSAGE);
             
             
               avarage2D(isFound,  athleteData);
            
        }
        
    }
    
}
