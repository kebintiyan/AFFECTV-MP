package com.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by kevin on 6/13/2017.
 */
public class CSVWriter {

    private static final String FILENAME = "output.csv";
    private static final String START_STRING = "Theta, Alpha, Low_beta, High_beta, Gamma";

    public CSVWriter() {
        init();
    }

    private void init() {
        write(START_STRING, false);
    }

    public void write(String text) {
        write(text, true);
    }

    public void write(String text, boolean append) {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter(FILENAME, append);
            bw = new BufferedWriter(fw);
            bw.write(text);
            bw.newLine();

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();
            }

        }
    }
}
