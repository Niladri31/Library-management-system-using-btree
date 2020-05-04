
import javax.swing.JFrame;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Niladri
 */
public class NewMain extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        mainpage mainpage = new mainpage();
ArrayList<String> ai=new ArrayList<>();
   Btree.t.insert(Btree.t, 10);
         ai.add("Dbms");
         ai.add("Navathe");
         Btree.hm.put(10,ai);
         ArrayList<String> ai1=new ArrayList<>();
   Btree.t.insert(Btree.t, 20);
         ai1.add("concept of Dbms");
         ai1.add("Abraham");
         Btree.hm.put(20,ai1);
         ArrayList<String> ai2=new ArrayList<>();
   Btree.t.insert(Btree.t, 30);
         ai2.add("Data Structure");
         ai2.add("Cormen");
         Btree.hm.put(30,ai2);
         ArrayList<String> ai3=new ArrayList<>();
   Btree.t.insert(Btree.t, 40);
         ai3.add("Artificial Intelligence");
         ai3.add("Russel");
         Btree.hm.put(40,ai3);
         ArrayList<String> ai4=new ArrayList<>();
   Btree.t.insert(Btree.t, 50);
         ai4.add("Computer Graphics");
         ai4.add("Pearson");
         Btree.hm.put(50,ai4);
         ArrayList<String> ai5=new ArrayList<>();
   Btree.t.insert(Btree.t, 60);
         ai5.add("Maths");
         ai5.add("Grewal");
         Btree.hm.put(60,ai5);
         ArrayList<String> ai6=new ArrayList<>();
   Btree.t.insert(Btree.t, 70);
         ai6.add("Data Structure");
         ai6.add("Sahani");
         Btree.hm.put(70,ai6);
         ArrayList<String> ai7=new ArrayList<>();
   Btree.t.insert(Btree.t, 80);
         ai7.add("Physics");
         ai7.add("Girish");
         Btree.hm.put(80,ai7);


Login l=new Login();
l.setVisible(true);
        
        
    }
    
}
