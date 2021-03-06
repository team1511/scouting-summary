/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scouting.summary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TSVDoc {

    String[][] data;

    String[] header;

    /**
     * Delimeters: Tabs
     *
     * @param file
     */
    public TSVDoc(String file) {

        String[] lines;
        ArrayList<String> s = new ArrayList<>();

        BufferedReader r = null;
        try {
            r = new BufferedReader(new FileReader(file));
            String u;
            while ((u = r.readLine()) != null) {
                s.add(u);
            }
        } catch (IOException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                if (r != null) {
                    r.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(TSVDoc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        lines = s.toArray(new String[s.size()]);

        if (lines.length > 0) {
            header = lines[0].split(" *\t *");
            data = new String[lines.length - 1][];
            for (int i = 1; i < lines.length; i++) {
                data[i - 1] = lines[i].split(" *\t *");
            }
        } else {
            header = new String[0];
            data = new String[0][];
        }
    }

    public TSVDoc() {
        header = new String[0];
        data = new String[0][];
    }
}
