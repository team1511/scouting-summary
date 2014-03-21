/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scouting.summary;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class Chart extends JPanel {

    /**
     * Creates new form Chart
     */
    public Chart() {
        initComponents();
        data = new int[0][];
        shades = null;
        scales = null;
        max = 1;
    }

    public static final int FULL = 0;
    public static final int CLEAR = 1;
    public static final int MEDIUM = 2;

    public void paintIt(Graphics2D g) {
        int w = this.getWidth();
        int h = this.getHeight();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, w, h);
        w--;
        h--;

        if (data.length == 0) {
            return;
        }

        int wh = w / data.length;

        int q = data.length;
        int p = w - wh * data.length;
        int m = 0;

        int xs = 0;

        int hs = h / max + 1;

        for (int x = 0; x < data.length; x++) {
            int[] d = data[x];
            int b = 0;

            int boost = 0;
            m += p;
            if (m >= q) {
                m -= q;
                boost = 1;
            }
            for (int y = 0; y < shades.length; y++) {
                int v = d[y];
                if (v == 0) {
                    continue;
                }
                int j = v * hs * scales[y];

                drawRect(g, shades[y], xs, h - b - j, wh + boost, j);
                b += j;
            }
            xs += wh + boost;
        }
    }

    private static final Color DARK = new Color(50, 50, 50);
    private static final Color MID = new Color(150, 150, 150);
    private static final Color LIGHT = new Color(255, 255, 255);

    private static void drawRect(Graphics2D g, int color, int x, int y, int w, int h) {
        Rectangle area = new Rectangle(x, y, w, h);
        switch (color) {
            case FULL:
                g.setColor(DARK);
                break;
            case MEDIUM:
                g.setColor(MID);
                break;
            case CLEAR:
                g.setColor(LIGHT);
                break;
        }
        g.fill(area);
        g.setColor(Color.BLACK);
        g.draw(area);
    }

    @Override
    public void paintComponent(Graphics g) {
        paintIt((Graphics2D) g);
    }

    private int max;

    public void setMax(int m) {
        max = m;
    }

    private int[][] data;

    public void setData(int[][] d) {
        data = d;
    }
    private int[] shades;

    public void setShades(int[] s) {
        shades = s;
    }

    private int[] scales;

    public void setScales(int[] s) {
        scales = s;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(0, 0, 0));
        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
