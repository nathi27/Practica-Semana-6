/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.directorystructure;

/**
 *
 * @author Nathalie
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//Cree una clase principal llamada ReportGenerator
public class ReportGenerator {
    //Declaro el metodo generateFinalReport, llamando al rootPath donde se crerán el reporte final
    public static void generateFinalReport(String rootPath){
        
        File rootDirectory = new File(rootPath);
        if (!rootDirectory.isDirectory()) {
            System.out.println("El directorio raíz especificado no es válido");
            return;
        }
        //se crea un file llamado ´finalReport´ del archivo de reporte final "reporte_hallazgos.txt"
        File finalReport = new File("reporte_hallazgos.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(finalReport))) { //asegura que el BufferedWriter se cierre automáticamente al finalizar el bloque
            for (File monthDir : rootDirectory.listFiles()){
                if(monthDir.isDirectory()){
                    processMonthDirectory(monthDir, writer);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Reporte final generado: "+ finalReport.getAbsolutePath());
    }
    
    //Declaro el metodo privado processMonthDirectory llamando a monthDir para el directorio del mes y writet para escribir en el archivo reporte final
    private static void processMonthDirectory(File monthDir, BufferedWriter writer) throws IOException {
        String monthYear = monthDir.getName().replace("__", " ");//Se obtiene el nombre del directorio
        writer.write(monthYear);
        writer.write("\n");
        //Itera sobre todos los elementos que esten contenidos dentro del directorio ´monthDir´
        for(File file : monthDir.listFiles()){
            if (file.isFile() && file.getName().startsWith("reporte_")){
                processReportFile(file, writer);
            } else if (file.isDirectory()) {
                processSubDirectory(file, writer);
            }
        }
    }
    
    //Declaro el metodo privado processSubDirectory donde dir es el directorio que esta procesando si tiene archivos o sudirectorios y writer para escribir en el contenido
    private static void processSubDirectory(File dir, BufferedWriter writer) throws IOException {
        for(File file : dir.listFiles()){//devuelve un array de objetos ´File´ de los archivos y directorios contenidos dentro de dir
            if(file.isFile() && file.getName().startsWith("reporte_")){//verifica si ´file´ es un archivo y verifica el nombre que comience con reporte
                processReportFile(file, writer); //se encarga de leer elc ontenido y confirmarnos si file es un archivo
            }
        }
    }
    
    private static void processReportFile(File reportFile, BufferedWriter writer) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(reportFile))){// se leeran lineas de texto desde reportFile que se abre desde fileReader 
            String line;
            String topic = ""; //almacena el reporte
            boolean inFindings = false; //indica si el procesamiento esta dentro de hallazgos
            List<String> findings = new ArrayList<>();// lista que almacena hallazgos
            
            while ((line = reader.readLine()) !=null){//Itera el archivo reportFile
                if (line.startsWith("# Topico del reporte")) {//Lee la informacion de topico del reporte
                    topic = reader.readLine().trim().substring(2);
                } else if(line.equalsIgnoreCase("# Hallazgos")){ //Cuando se encuentre la linea hallazgos se activa inFindings y empezara a recolectar la informacion de esta
                    inFindings = true;
                } else if(inFindings) {
                    if(line.startsWith("#")) {
                        inFindings = false;
                    } else {
                        findings.add(line.trim());
                    }
                }
            }
            //escribe la informacion del reporte final en el formato deseado
            writer.write("# Reporte del "+ reportFile.getName().replace("reporte_", "").replace(".txt", "").replace("_", "/")+ "\n");
            writer.write("##"+ topic + "\n");
            for (String finding : findings){
                writer.write("- "+ finding + "\n");
            }
            writer.write("\n");
        }
    } 
}
