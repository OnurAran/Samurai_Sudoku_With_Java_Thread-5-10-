
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.Thread;

public class solver extends Thread implements Runnable {

    int[][] board;
    public static final int EMPTY = 0; // empty cell
    public static final int SIZE = 9; // size of our Sudoku grids
    String m;
    int bi, bj;
   
    int[] degerler;
    int [] suredegerleri;
    int [] adimdegerleri;
    public solver(int[][] board, String m, int bi, int bj) {
        this.m = m;
        this.board = new int[21][21];
        this.bi = bi;
        this.bj = bj;
        for (int i = 0; i < 21; i++) {

            for (int j = 0; j < 21; j++) {
                this.board[i][j] = board[i][j];

            }
        }
    }

    // we check if a possible number is already in a row
    private boolean isInRow(int row, int number) {
        for (int i = bj; i < bj + SIZE; i++) {
            if (board[row][i] == number) //
            {
                return true;
            }
        }

        return false;
    }

    private boolean isInRow2(int row, int number) {
        for (int i = bj; i > bj - SIZE; i--) {
            if (board[row][i] == number) //
            {
                return true;
            }
        }

        return false;
    }

    // we check if a possible number is already in a column
    private boolean isInCol(int col, int number) {
        for (int i = bi; i < bi + SIZE; i++) {
            if (board[i][col] == number) {
                return true;
            }
        }

        return false;
    }

    private boolean isInCol2(int col, int number) {
        for (int i = bi; i > bi - SIZE; i--) {
            if (board[i][col] == number) {
                return true;
            }
        }

        return false;
    }

    // we check if a possible number is in its 3x3 box
    private boolean isInBox(int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == number) {

                    return true;
                }
            }
        }

        return false;
    }

    private boolean isInBox2(int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == number) {

                    return true;
                }
            }
        }

        return false;
    }

    // combined method to check if a number possible to a row,col position is ok
    private boolean isOk(int row, int col, int number) {
        return !isInRow(row, number) && !isInCol(col, number) && !isInBox(row, col, number);
    }

    private boolean isOk2(int row, int col, int number) {
        return !isInRow2(row, number) && !isInCol2(col, number) && !isInBox2(row, col, number);
    }

    //special funcktion
    // Solve method. We will use a recursive BackTracking algorithm.
    // we will see better approaches in next video :)
    int a = 0;

    int[][] degertut = new int[500][500];
    int[] sira_satir = new int[500];
    int[] sira_sütün = new int[500];
    long [] time_value=new long[1000];
    int [] adim_value=new int [1000];
    String[] m_degeri = new String[500];
     
    int i = 0;

    int sira1 = 0, sira2 = 0;

    int satir = 0, sütün = 0;
 long start = 0, end = 0;
    public boolean solve() throws IOException {
       
        Random generator = new Random(System.currentTimeMillis());
        start = System.currentTimeMillis();
        for (int row = bi; row < bi + SIZE; row++) {
            for (int col = bj; col < bj + SIZE; col++) {
                // we search an empty cell
                if (board[row][col] == EMPTY) {
                    // we try possible numbers
                    for (int number = 1; number <= SIZE; number++) {
                        if (isOk(row, col, number)) {
                            // number ok. it respects sudoku constraints
                            this.board[row][col] = number;

                            if (solve()) { // we start backtracking recursively
                                end=System.currentTimeMillis();
                                long sure=end-start;
                                 time_value[sira1]=end-start;
                                 adim_value[sira1]=sira1+1;
                                String str = m + "\n";
                                String str2 = row + "\n";
                                String str3 = col + "\n";
                                String str4 = this.board[row][col] + "\n";

                              //  System.out.println(" " + m);

                                File tempFile = new File("temphamle.txt");
                               
                                this.degertut[satir][sütün] = number;

                                sira_satir[sira1] = row;
                                sira_sütün[sira2] = col;
                                m_degeri[sira1] = m;
                                 System.out.println(m+" sure  "+time_value[sira1]+ " sayaç "+ adim_value[sira1]);
                                sira1++;
                                sira2++;
                              
                                satir++;
                                sütün++;

                                if (!tempFile.exists()) {
                                    tempFile.createNewFile();
                                }

                                FileWriter tempFileWriter = new FileWriter(tempFile, true);
                                BufferedWriter tempbWriter = new BufferedWriter(tempFileWriter);

                                tempbWriter.write(str);
                                tempbWriter.close();

                                return true;

                            } else { // if not a solution, we empty the cell and we continue
                                board[row][col] = EMPTY;
                            }
                        }
                    }

                    return false; // we return false
                }
            }
        }

        return true; // sudoku solved
    }

    public boolean solve2() throws IOException {
         Random generator = new Random(System.currentTimeMillis());
        start = System.currentTimeMillis();
        for (int row = bi; row > (bi - SIZE); row--) {
            for (int col = bj; col > (bj - SIZE); col--) {
                // we search an empty cell
                if (board[row][col] == EMPTY) {
                    // we try possible numbers
                    for (int number = 1; number <= SIZE; number++) {

                        if (isOk2(row, col, number)) {
                            // number ok. it respects sudoku constraints
                            
                            this.board[row][col] = number;
                            

                            if (solve2()) { // we start backtracking recursively
                                 end=System.currentTimeMillis();
                                long sure=end-start;
                                System.out.println(m+" sure  "+sure+ " sayaç "+sira1);
                                String str = m + "\n";
                                String str2 = row + "\n";
                                String str3 = col + "\n";
                                String str4 = this.board[row][col] + "\n";

                                File file = new File("temphamle.txt");
                                if (!file.exists()) {
                                    file.createNewFile();
                                }

                                this.degertut[satir][sütün] = number;

                                sira_satir[sira1] = row;
                                sira_sütün[sira2] = col;
                                m_degeri[sira1] = m;

                                sira1++;
                                sira2++;

                                FileWriter fileWriter = new FileWriter(file, true);
                                BufferedWriter bWriter = new BufferedWriter(fileWriter);

                                fileWriter.write(str);
                                bWriter.close();
                                return true;

                            } else { // if not a solution, we empty the cell and we continue
                                board[row][col] = EMPTY;
                            }
                        }
                    }

                    return false; // we return false
                }
            }
        }
        return true; // sudoku solved
    }



    @Override
    public void run() {
     
   

        if (m.equals("m1") || m.equals("m2") || m.equals("m3") || m.equals("m4") || m.equals("m5")) {
          

                try {
                    if (this.solve()) {

                      // System.out.println("" + m);
                      
                    
                      
                      
                      
                    }

                } catch (IOException ex) {
                    Logger.getLogger(solver.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }

        if (m.equals("m6") || m.equals("m7") || m.equals("m8") || m.equals("m9") || m.equals("m10")) {
            

                try {
                    if (this.solve2()) {

                   //     System.out.println("" + m);

                    }

                } catch (IOException ex) {
                    Logger.getLogger(solver.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }

    }

}
