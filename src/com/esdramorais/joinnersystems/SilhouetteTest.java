package com.esdrasmorais.joinnersystems;

public class SilhouetteTest {
    public static void main(String[] args) {
        try {
            SilhouetteFlood silhouetteFlood = new SilhouetteFlood(
                "caso_exemplo.txt"
            );
            silhouetteFlood.calculate();
            silhouetteFlood.saveResponse();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
