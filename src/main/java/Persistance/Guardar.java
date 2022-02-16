package Persistance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Guardar {

    private static final String path = "D:/testGenMap/fichero.txt";
    public void arrayToFichero(int[][] map){
     FileWriter fw = null;
     String elemento;
        try {
            fw = new FileWriter(path);
            for (int x = 0; x < 200; x++) {
                for (int y = 0; y < 200; y++) {
                    elemento = String.valueOf(map[x][y]);
                    fw.write(elemento);
                    elemento = " ";
                    fw.write(elemento);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                fw = null;
            }
        }
    }
    
    public int[][] lee() {

        try {
            String path2= "D:\\testGenMap\\fichero.txt";
            FileReader arch = new FileReader(path2); // Lector de archivo

            BufferedReader buff = new BufferedReader(arch); // Buffer de lectura

            String linea = buff.readLine();
            StringTokenizer st = new StringTokenizer(linea);
            int[][] mapa = new int[200][200];
            // Rellenar la matriz
            for (int i = 0; i < 200; ++i) {
                for (int j = 0; j < 200; ++j) {
                    mapa[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            buff.close();
            arch.close();
            return mapa;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
