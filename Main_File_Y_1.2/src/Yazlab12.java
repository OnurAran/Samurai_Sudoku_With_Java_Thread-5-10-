
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Yazlab12 {

    static int tutX = 0;
    static int tutY = 0;

    public static void main(String[] args) throws IOException {

        File tempFile = new File("temphamle.txt");
        FileWriter tempFileWriter = new FileWriter(tempFile, false);

       
        String fileName = "src\\a.txt";
        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            list = stream
                    .filter(line -> line.startsWith(""))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
     

        char[][] matrix = new char[30][30];

        int x = 0;
        for (int i = 0; i < 6; i++, x++) {
            int y = 0;
            for (int j = 0; j < 9; j++) {
                if (list.get(i).charAt(j) == '*') {
                    matrix[i][j] = '0';
                } else {
                    matrix[x][y] = list.get(i).charAt(j);
                }
            
                y++;

            }
            
        }
        x = 0;
        for (int i = 0; i < 6; i++, x++) {
            int y = 9;
            for (int j = 0; j < 3; j++) {

                matrix[x][y] = '0';

              
                y++;

            }

        }
        x = 0;
        for (int i = 0; i < 6; i++, x++) {
            int y = 12;
            for (int j = 9; j < 18; j++) {
                if (list.get(i).charAt(j) == '*') {
                    matrix[x][y] = '0';
                } else {
                    matrix[x][y] = list.get(i).charAt(j);
                }
             
                y++;

            }
  
        }
        x = 6;
        for (int i = 6; i < 9; i++, x++) {
            int y = 0;
            for (int j = 0; j < 21; j++) {
                if (list.get(i).charAt(j) == '*') {
                    matrix[x][y] = '0';
                } else {
                    matrix[x][y] = list.get(i).charAt(j);
                }
           
                y++;

            }
       
        }

        x = 9;
        for (int i = 0; i < 3; i++, x++) {
            int y = 0;
            for (int j = 0; j < 6; j++) {

                matrix[x][y] = '0';
                y++;

            }
          
        }
        x = 9;
        for (int i = 9; i < 12; i++, x++) {
            int y = 6;
            for (int j = 0; j < 9; j++) {
                if (list.get(i).charAt(j) == '*') {
                    matrix[x][y] = '0';
                } else {
                    matrix[x][y] = list.get(i).charAt(j);
                }

                y++;

            }
   
        }
        x = 9;
        for (int i = 0; i < 3; i++, x++) {
            int y = 15;
            for (int j = 0; j < 6; j++) {
                matrix[x][y] = '0';
                y++;
            }
        }
        x = 12;
        for (int i = 12; i < 15; i++, x++) {
            int y = 0;
            for (int j = 0; j < list.get(i).length(); j++) {
                if (list.get(i).charAt(j) == '*') {
                    matrix[x][y] = '0';
                } else {
                    matrix[x][y] = list.get(i).charAt(j);
                }

                y++;
            }
        }
        x = 15;
        for (int i = 15; i < 21; i++, x++) {
            int y = 0;
            for (int j = 0; j < 9; j++) {
                if (list.get(i).charAt(j) == '*') {
                    matrix[x][y] = '0';
                } else {
                    matrix[x][y] = list.get(i).charAt(j);
                }

                y++;
            }
        }
        x = 15;
        for (int i = 0; i < 6; i++, x++) {
            int y = 9;
            for (int j = 0; j < 3; j++) {

                matrix[x][y] = '0';

                y++;
            }
        }
        x = 15;
        for (int i = 15; i < 21; i++, x++) {
            int y = 12;
            for (int j = 9; j < list.get(i).length(); j++) {
                if (list.get(i).charAt(j) == '*') {
                    matrix[x][y] = '0';
                } else {
                    matrix[x][y] = list.get(i).charAt(j);
                }

                y++;
            }
        }
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                if ((i <= 5 & j >= 9 & j < 12) | (i >= 9 & i < 12 & j <= 5) | (i >= 9 & i < 12 & j > 14) | (i > 15 & j >= 9 & j < 12)) {
                    matrix[i][j] = '0';
                }
            }
        }
        int[][] matris1 = new int[9][9];
        int[][] matris2 = new int[9][9];
        int[][] matris3 = new int[9][9];
        int[][] matris4 = new int[9][9];
        int[][] matris5 = new int[9][9];
       
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matris1[i][j] = Character.getNumericValue(matrix[i][j]);
              
            }
         
        }
       
        x = 0;
        for (int i = 0; i < 9; i++, x++) {
            int y = 12;
            for (int j = 0; j < 9; j++) {
                matris2[i][j] = Character.getNumericValue(matrix[x][y]);
               
                y++;
            }
         
        }
       
        x = 6;
        for (int i = 0; i < 9; i++, x++) {
            int y = 6;
            for (int j = 0; j < 9; j++) {
                matris3[i][j] = Character.getNumericValue(matrix[x][y]);
               
                y++;
            }
           
        }

      
        x = 12;
        for (int i = 0; i < 9; i++, x++) {
            int y = 0;
            for (int j = 0; j < 9; j++) {
                matris4[i][j] = Character.getNumericValue(matrix[x][y]);
            
                y++;
            }
     
        }
    
        x = 12;
        for (int i = 0; i < 9; i++, x++) {
            int y = 12;
            for (int j = 0; j < 9; j++) {
                matris5[i][j] = Character.getNumericValue(matrix[x][y]);
                
                y++;
            }
       
        }

        //solver çalışmaları //////////////////////
        int[][] tmp = new int[21][21];
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                tmp[i][j] = Character.getNumericValue(matrix[i][j]);
            }
        }
        solver m1 = new solver(tmp, "m1", 0, 0);//1.bölge
        solver m2 = new solver(tmp, "m2", 0, 12);//3.bölge
        solver m3 = new solver(tmp, "m3", 6, 6);//5.bölge
        solver m4 = new solver(tmp, "m4", 12, 0);//2.bölge
        solver m5 = new solver(tmp, "m5", 12, 12);//4.bölge

        solver m6 = new solver(tmp, "m6", 8, 8);//1.bölge
        solver m7 = new solver(tmp, "m7", 8, 20);//3.bölge
        solver m8 = new solver(tmp, "m8", 20, 8);//2.bölge
        solver m9 = new solver(tmp, "m9", 20, 20);//4.bölge
        solver m10 = new solver(tmp, "m10", 14, 14);//5.bölge

        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m2);
        Thread t3 = new Thread(m3);
        Thread t4 = new Thread(m4);
        Thread t5 = new Thread(m5);
        Thread t6 = new Thread(m6);
        Thread t7 = new Thread(m7);
        Thread t8 = new Thread(m8);
        Thread t9 = new Thread(m9);
        Thread t10 = new Thread(m10);

        t1.setName("m1");
        t2.setName("m2");
        t3.setName("m3");
        t4.setName("m4");
        t5.setName("m5");
        t6.setName("m6");
        t7.setName("m7");
        t8.setName("m8");
        t9.setName("m9");
        t10.setName("m10");


        arayüz a = new arayüz(tmp);
        a.setSize(1200, 900);
        a.setLayout(null);
        a.setLocationRelativeTo(null);
        JButton Beslicoz = new JButton();
        Beslicoz.setBounds(800, 100, 100, 40);
        JButton Onlucoz = new JButton();

        Onlucoz.setBounds(800, 200, 100, 40);

        JButton go_on = new JButton();
        go_on.setBounds(800, 300, 129, 40);
        JButton Cozum = new JButton();
        Cozum.setBounds(800, 400, 100, 40);
        Onlucoz.setText("10'lu Çöz");
        go_on.setText("Bir Sonraki Adim");
        Beslicoz.setText("5'li çöz");
        Cozum.setText("Çözüm");
        go_on.addActionListener(new ActionListener() {
            int i = 0;
            int j = 0;

            int mi_1 = 0, mi_2 = 0, mi_3 = 0, mi_4 = 0, mi_5 = 0, mi_6 = 0, mi_7 = 0, mi_8 = 0, mi_9 = 0, mi_10 = 0;
            int mj_1 = 0, mj_2 = 0, mj_3 = 0, mj_4 = 0, mj_5 = 0, mj_6 = 0, mj_7 = 0, mj_8 = 0, mj_9 = 0, mj_10 = 0;

            public void actionPerformed(ActionEvent e) {

                String tempFileName = "temphamle.txt";
                List<String> temp = new ArrayList<>();
                try (Stream<String> stream = Files.lines(Paths.get(tempFileName))) {
                    temp = stream
                            .filter(line -> line.startsWith(""))
                            .collect(Collectors.toList());
                } catch (IOException ex) {
                    Logger.getLogger(Yazlab12.class.getName()).log(Level.SEVERE, null, ex);
                }


                if (temp.get(i).equals("m1")) {



                    mi_1++;
                    mj_1++;

                }
                if (temp.get(i).equals("m2")) {

                    tmp[m2.sira_satir[mi_2]][m2.sira_sütün[mj_2]] = m2.board[m1.sira_satir[mi_2]][m2.sira_sütün[mj_2]];//1.bölge
         

                    mi_2++;
                    mj_2++;

                }
                if (temp.get(i).equals("m3")) {

                    tmp[m3.sira_satir[mi_3]][m3.sira_sütün[mj_3]] = m3.board[m3.sira_satir[mi_3]][m3.sira_sütün[mj_3]];//1.bölge
              

                    mi_3++;
                    mj_3++;

                }
                if (temp.get(i).equals("m4")) {

                    tmp[m4.sira_satir[mi_4]][m4.sira_sütün[mj_4]] = m4.board[m4.sira_satir[mi_4]][m4.sira_sütün[mj_4]];//1.bölge
  

                    mi_4++;
                    mj_4++;

                }
                if (temp.get(i).equals("m5")) {
                    tmp[m5.sira_satir[mi_5]][m5.sira_sütün[mj_5]] = m5.board[m5.sira_satir[mi_5]][m5.sira_sütün[mj_5]];//1.bölge
             

                    mi_5++;
                    mj_5++;

                }
                if (temp.get(i).equals("m6")) {

                    tmp[m6.sira_satir[mi_6]][m6.sira_sütün[mj_6]] = m6.board[m6.sira_satir[mi_6]][m6.sira_sütün[mj_6]];//1.bölge
             

                    mi_6++;
                    mj_6++;

                }
                if (temp.get(i).equals("m7")) {

                    tmp[m7.sira_satir[mi_7]][m7.sira_sütün[mj_7]] = m7.board[m7.sira_satir[mi_7]][m7.sira_sütün[mj_7]];//1.bölge
              

                    mi_7++;
                    mj_7++;

                }
                if (temp.get(i).equals("m8")) {

                    tmp[m8.sira_satir[mi_8]][m8.sira_sütün[mj_8]] = m8.board[m8.sira_satir[mi_8]][m8.sira_sütün[mj_8]];//1.bölge


                    mi_8++;
                    mj_8++;

                }
                if (temp.get(i).equals("m9")) {

                    tmp[m9.sira_satir[mi_9]][m9.sira_sütün[mj_9]] = m9.board[m9.sira_satir[mi_9]][m9.sira_sütün[mj_9]];//1.bölge
              

                    mi_9++;
                    mj_9++;

                }
                if (temp.get(i).equals("m10")) {

                    tmp[m10.sira_satir[mi_10]][m10.sira_sütün[mj_10]] = m10.board[m10.sira_satir[mi_10]][m10.sira_sütün[mj_10]];//1.bölge
       

                    mi_10++;
                    mj_10++;

                }

                i++;

                a.repaint();
            }  
    
        });

        Beslicoz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t1.start();
                t2.start();
                t3.start();
                t4.start();
                t5.start();

                a.repaint();

            }

        }
        );
        Onlucoz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t1.start();
                t2.start();
                t3.start();
                t4.start();
                t5.start();
                t6.start();
                t7.start();
                t8.start();
                t9.start();
                t10.start();
            }

        }
        );
          Cozum.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
             
               
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        tmp[i][j] = m1.board[i][j];

                    }

                }
                for (int i = 0; i < 9; i++) {
                    for (int j = 12; j < 21; j++) {
                        tmp[i][j] = m2.board[i][j];

                    }

                }
                for (int i = 6; i < 15; i++) {
                    for (int j = 6; j < 15; j++) {
                           tmp[i][j]=m3.board[i][j];

                    }

                }
                for (int i = 12; i < 21; i++) {
                    for (int j = 0; j < 9; j++) {
                        tmp[i][j] = m4.board[i][j];

                    }

                }
                for (int i = 12; i < 21; i++) {
                    for (int j = 12; j < 21; j++) {
                        tmp[i][j] = m5.board[i][j];

                    }

                }

                a.repaint();
            
               
            }

        }
        );
        a.add(Cozum);
        a.add(go_on);
        a.add(Onlucoz);
        a.add(Beslicoz);
        a.setVisible(true);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
