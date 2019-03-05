package com.esdrasmorais.joinnersystems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;
//import com.esdrasmorais.joinnersystems.Silhouette;

public class SilhouetteFlood {
    protected Integer numberCases;
    protected List<Silhouette> silhouettes;
    private Silhouette silhouette;
    private String response;

    public SilhouetteFlood(String filePath) throws IOException {
        this.silhouettes = new ArrayList<>();
        this.init(filePath);
        this.response = "";
    }
    
    private void setSilhouette(String line) throws Exception {
        this.silhouette = new Silhouette();
        this.silhouette.setHeight(0);
        this.silhouette.setWidth(Integer.parseInt(line));
    }

    private void setPositions(String line) throws Exception {
        String[] positions = line.split(" ");
        List<Integer> filledPositions = new ArrayList<>();
        for (String p : positions) {
            Integer height = Integer.parseInt(p);
            this.silhouette.setHeight(
                this.silhouette.getHeight() < height ? 
                    height : 
                    this.silhouette.getHeight()
            );
            System.out.print(p+" ");
            filledPositions.add(height);
        }
        System.out.print("\n+++\n");
        this.silhouette.setFilledPositions(filledPositions);
    }

    /**
     * a primeira linha contem um numero N (entre 1 e 100) que tem o número 
     * de casos do arquivo. Cada caso é composto por 2 linhas.
     */
    private void init(String filePath) 
        throws FileNotFoundException, IOException
    {
        FileReader fr = new FileReader(filePath);
        try (BufferedReader br = new BufferedReader(fr)) {
            String line;
            Integer i = 0;
            while ((line = br.readLine()) != null) {
                System.out.print(line);System.exit(0);
                if (i == 0) {
                    this.numberCases = Integer.parseInt(line);
                } else if (i % 2 == 0) {
                    this.setPositions(line);
                    this.silhouettes.add(this.silhouette);
                } else {
                    this.setSilhouette(line);
                }
                i++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void addLine(Integer result) {
        this.response += result + "\n";
    }

    protected void calculate() {
                  
    }

    protected void saveResponse() {
        OutputStream os = null;
        try {
            os = new FileOutputStream(new File("./response.txt"));
            os.write(this.response.getBytes(), 0, this.response.length());
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
