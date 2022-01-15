
import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;

public class arayüz extends javax.swing.JFrame {

    JFrame a = new JFrame("Button Example");

    int[][] sudoku_array;
    int[][] matris1;
    int[][] matris2;
    int[][] matris3;
    int[][] matris4;
    int[][] matris5;

    public arayüz(int[][] a) {
        this.sudoku_array = a;
        this.matris1 = matris1;
        this.matris2 = matris2;
        this.matris3 = matris3;
        this.matris4 = matris4;
        this.matris5 = matris5;
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.translate(50, 50);
        g.fillRect(0, 0, 700, 700);
        
        for (int i = 0; i < sudoku_array.length; i++) {
            for (int j = 0; j < sudoku_array[i].length; j++) {
                Color color = null;
                Color color2 = null;
                int px = 30;
                if (sudoku_array[i][j] != 0) {

                    g.setColor(color.white);
                    g.drawString("" + sudoku_array[i][j], 30 * (j + 1) + 15, 30 * (i + 2) - 15);
                }
              //  System.out.print(" " + sudoku_array[i][j]);

                if (color == null) {
                    // samurai sudoku boş kısımlarda çizgi çizdirmemesi için
                    if (i <= 5 & j >= 9 & j < 12) {
                        continue;
                    }
                    if (i >= 9 & i < 12 & j <= 5) {
                        continue;
                    }
                    if (i >= 9 & i < 12 & j > 14) {
                        continue;
                    }
                    if (i > 14 & j >= 9 & j < 12) {
                        continue;
                    }
                    g.setColor(color.blue);
                    g.drawRect(px * (j + 1), px * (i + 1), px, px);

                    g.setColor(color);
                    continue;
                }


            }
        //    System.out.println("");
        }
        //System.out.println("");
    }

}
