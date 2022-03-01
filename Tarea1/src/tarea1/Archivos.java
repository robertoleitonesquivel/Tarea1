package tarea1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Archivos {

    private final File archivoInicial;
    private final File archivoFinal;

    protected int totalPalabras = 0;
    protected int totalCaracteresSinEspacios = 0;
    protected int totalCaracteresConEspacios = 0;
    protected int totalLineas = 0;

    public Archivos() {
        this.archivoInicial = new File("texto.txt");
        this.archivoFinal = new File("resultado.txt");
    }

    //METODO PARA LEER EL ARCHIVO
    public void leerArchivo() {
        try {
            //VARIABLES PARA REALIZAR LA LECTURA DEL ARCHIVO
            FileReader fr = new FileReader(archivoInicial);
            BufferedReader bf = new BufferedReader(fr);

            String linea;

            while ((linea = bf.readLine()) != null) {
                calcular(linea);
            }

            bf.close();
            fr.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //METODO PARA ESCRIBIR EN EL ARCHIVO
    public void escribirEnArchivo() {
        try {
            //VARIABLES PARA REALIZAR LA ESCRITURA DEL ARCHIVO
            FileWriter fw = new FileWriter(archivoFinal);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Total de Palabras: " + this.totalPalabras + "\n");
            bw.write("Total Caracteres (sin espacios): " + this.totalCaracteresSinEspacios + "\n");
            bw.write("Total Caracteres (con espacios): " + this.totalCaracteresConEspacios + "\n");
            bw.write("Total de líneas: " + this.totalLineas + "\n");

            bw.close();
            fw.close();
        } catch (IOException ex) {

        }
    }

    //METODO PARA CALCULAR
    public void calcular(String linea) {
        try {
            totalLineas++;

            //Verifico que la linea no este en blanco
            if ("".equals(linea)) {
                totalCaracteresConEspacios++;
            } else {

                //Caracteres con espacios
                totalCaracteresConEspacios += linea.length();

                //Total de palabras
                String[] palabras = linea.split(" ");
                totalPalabras += palabras.length;

                //Total caracteres sin espacios
                for (int i = 0; i < palabras.length; i++) {
                    totalCaracteresSinEspacios += palabras[i].length();
                }
            }

        } catch (Exception ex) {

        }
    }

}
