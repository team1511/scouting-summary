/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scouting.summary;

public class TeamDisplay extends javax.swing.JPanel {

    /**
     * Creates new form TeamDisplay
     */
    public TeamDisplay() {
        initComponents();
        teamData = null;
        teamNum.setText("????");

        display1.setType("Auto");
        display2.setType("Foul");
        display3.setType("Truss");
        display4.setType("Catch");
        display5.setType("High");
        display6.setType("Low");
    }

    private TeamRecord teamData;

    public void setTeam(TeamRecord team) {
        teamData = team;
        teamNum.setText(String.format("%d", teamData.getTeamNum()));
        loadStats();
        display1.loadData(teamData);
        display2.loadData(teamData);
        display3.loadData(teamData);
        display4.loadData(teamData);
        display5.loadData(teamData);
        display6.loadData(teamData);
        this.repaint();
    }

    private void loadStats() {
        String[] s = teamData.getScouting();
        StringBuilder k = new StringBuilder();
        k.append("<html>");
        if (s.length >= 1) {
            k.append(s[0]);
        }
        for (int i = 1; i < s.length; i++) {
            k.append("<br/>");
            k.append(s[i]);
        }
        k.append("</html>");

        statsText.setText(k.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        teamNum = new javax.swing.JLabel();
        display4 = new scouting.summary.Display();
        display3 = new scouting.summary.Display();
        display2 = new scouting.summary.Display();
        statsText = new javax.swing.JLabel();
        display6 = new scouting.summary.Display();
        display1 = new scouting.summary.Display();
        stats = new javax.swing.JPanel();
        display5 = new scouting.summary.Display();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMaximumSize(new java.awt.Dimension(900, 200));
        setMinimumSize(new java.awt.Dimension(900, 200));
        setPreferredSize(new java.awt.Dimension(900, 200));
        setLayout(new java.awt.GridLayout(2, 4, 10, 10));

        teamNum.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        teamNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        teamNum.setText("####");
        add(teamNum);
        add(display4);
        add(display3);
        add(display2);

        statsText.setText("<html>statistics<br/>Foo</html>");
        statsText.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(statsText);
        add(display6);
        add(display1);

        stats.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        stats.setLayout(new java.awt.BorderLayout());
        stats.add(display5, java.awt.BorderLayout.CENTER);

        add(stats);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private scouting.summary.Display display1;
    private scouting.summary.Display display2;
    private scouting.summary.Display display3;
    private scouting.summary.Display display4;
    private scouting.summary.Display display5;
    private scouting.summary.Display display6;
    private javax.swing.JPanel stats;
    private javax.swing.JLabel statsText;
    private javax.swing.JLabel teamNum;
    // End of variables declaration//GEN-END:variables
}
