/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.directorystructure;

/**
 *
 * @author Nathalie
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//Cree una clase principal llamada DirectoryStructure
public class DirectoryStructure {

    public static void main(String[] args) {
        String rootPath = "bitacora"; //Este es el directorio donde cree la estructura de archivos
        
       //Método que se encarga de crear la estructura del directorio con sus archivos dentro del directorio ´bitacora´.
       crearEstructura(rootPath);
        System.out.println("Estructura de directorio y archivos creada con exito.");
        
         // Genera el reporte final de los archivos creados en la estructura del directorio, llamando al metodo generateFinalReport de la clase ReportGenerator y rootPath como argumento
         ReportGenerator.generateFinalReport(rootPath);
    }
    
    //Declaro el metodo crearEstructura, llamando al rootPath donde se crerán los nuevos directorios
    public static void crearEstructura(String rootPath){
        try{
            // Creo los directorios principales
            File noviembre2023Dir = new File(rootPath + "/noviembre_2023");//Creo un File que representa el directorio noviembre_2023 dentro del directorio rootPath
            noviembre2023Dir.mkdirs();//Uso el metodo mkdirs() para crear el directorio y todos los subdirectorios necesarios.
            
            File enero2024Dir = new File(rootPath + "/enero_2024");//Creo un File que representa el directorio enero_2024 dentro del directorio rootPath
            enero2024Dir.mkdirs();//Uso el metodo mkdirs() para crear el directorio y todos los subdirectorios necesarios.
            
            File abril2024Dir = new File(rootPath + "/abril_2024");//Creo un File que representa el directorio abril_2024 dentro del directorio rootPath
            abril2024Dir.mkdirs();//Uso el metodo mkdirs() para crear el directorio y todos los subdirectorios necesarios.
            
            // Creo los subdirectorios y archivos para noviembre_2023
            File novCapturasDir = new File(noviembre2023Dir, "capturas");//Creo un file que representa el subdirectorio capturas dentro del directorio noviembre_2023
            novCapturasDir.mkdirs();//Uso el metodo mkdirs() para crear el directorio y todos los subdirectorios necesarios.
            
            archivoContenido(new File(novCapturasDir, "prueba.jpn"), " "); //Cree el metodo ArchivoContenido dentro del subdirectorio capturas para el archivo prueba.jpg
            archivoContenido(new File(novCapturasDir, "captura.png"), " "); //Cree el metodo ArchivoContenido dentro del subdirectorio capturas para el archivo captura.png
            
            //Cree el archivo reporte_03_11_2023.txt dentro del directorio noviembre_2023
            archivoContenido(new File(noviembre2023Dir, "reporte_03_11_2023.txt"),
                    "# Topico del reporte\n"+
                            "- Mal olor en las personas\n"+
                            "\n"+
                            " #Notas\n"+
                            "- Nota 1: Investigar causas comunes del mal olor corporal \n "+
                            "- Nota 2: Analizar métodos existentes para el control del olor corporal \n"+
                            "- Nota 3: Recopilar datos sobre la prevalencia del problema en diferentes grupos de edad \n"+
                            "\n"+
                            "#Dificultales\n"+
                            "- Dificultad 1: Obtener muestras para el estudio\n "+
                            "- Dificultad 2: Manejar posibles variaciones individuales en la percepcion del olor\n"+
                            "- Dificultad 3: Considerar efectos secundarios de las soluciones propuestas\n"+
                            "\n"+
                            "# Hallazgos\n"+
                            "- Se descubre una vacuna para el mal olor\n"+
                            "- La vacuna funciona durante un mes\n"+
                            "- Puede causar nauseas y mareos\n");
            //Cree el archivo reporte_06_11_2023.txt dentro del directorio noviembre_2023
            archivoContenido(new File(noviembre2023Dir, "reporte_06_11_2023.txt"),
                    "# Topico del reporte\n"+
                            "- Dolor de espalda por dormir\n"+
                            "\n"+
                            " #Notas\n"+
                            "- Nota 1: Evaluar el impacto del tipo de colchon \n "+
                            "- Nota 2: Revisar las posturas recomendadas para dormir \n"+
                            "- Nota 3: Investigar tecnologías emergentes en materiales para colchones ortopédicos\n"+
                            "\n"+
                            "#Dificultales\n"+
                            "- Dificultad 1: Recopilar datos sobre la incidencia del dolor de espalda\n "+
                            "- Dificultad 2: Identificar usuarios adecuados para pruebas de colchones optopédicos\n"+
                            "- Dificultad 3: Cosniderar limitaciones presupuestarias para la producción de colchones especialisados\n"+
                            "\n"+
                            "# Hallazgos\n"+
                            "- Se descubre un colchon para reducir el dolor de espalda\n"+
                            "- El material toma la forma de la espalda de la persona\n"+
                            "- El precio del colchon puede ser muy caro\n"+
                            "- La persona debe dormir boca arriba\n");
             // Creo los subdirectorios y archivos para enero_2024
             File eneNotasDir = new File(enero2024Dir, "notas");//Creo un file que representa el subdirectorio ´notas´ dentro del directorio enero_2024
             eneNotasDir.mkdirs();//Uso el metodo mkdirs() para crear el directorio y todos los subdirectorios necesarios.
             
             archivoContenido(new File(eneNotasDir, "costos.csv"), " ");//Cree el metodo ArchivoContenido dentro del subdirectorio capturas para el archivo costos.csv
             archivoContenido(new File(eneNotasDir, "trabajos.pdf"), " ");//Cree el metodo ArchivoContenido dentro del subdirectorio capturas para el archivo trabajos.pdf
             
             File eneCapturasDir =new File(enero2024Dir, "capturas");//Creo un file que representa el subdirectorio ´capturas´ dentro del directorio enero_2024
             eneCapturasDir.mkdirs();//Uso el metodo mkdirs() para crear el directorio y todos los subdirectorios necesarios.
             
             archivoContenido(new File(eneCapturasDir, "prueba.png"), " ");//Cree el metodo crearArchivoConContenido dentro del subdirectorio capturas para el archivo prueba.png
             
             File eneReportesDir = new File(enero2024Dir, "reportes");//Creo un file que representa el subdirectorio ´reportes´ dentro del directorio enero_2024
             eneReportesDir.mkdirs();//Uso el metodo mkdirs() para crear el directorio y todos los subdirectorios necesarios.
             
             //Cree el archivo reporte_15_01_2024.txt dentro del directorio enero_2024
             archivoContenido(new File(eneReportesDir, "reporte_15_01_2024.txt"),
                     "# Topico del reporte\n"+
                            "- Cansancio acumulado por correr\n"+
                            "\n"+
                            " #Notas\n"+
                            "- No se logra reducir \n "+
                            "- Es natural \n"+
                            "\n"+
                            "#Dificultales\n"+
                            "- Dificultad 1: Identificar las causas precisas del cansancio acumulado\n "+
                            "- Dificultad 2: Establecer metodos efectivos para mitigar el cansancio\n"+
                            "- Dificultad 3: Evaluar la variabilidad individual en la repsuesta al entrenamiento fisico\n"+
                            "- Dificultad 3: Considerar los efectos a largo plazo del cansancio acumulado\n"+
                            "\n"+
                            "# Hallazgos\n"+
                            "- Se observa una correlación entre la intensidad del entrenamiento y el nivel de cansancio acumulado\n"+
                            "- Algunos corredores reportan mejoras significativas con tecnicas de recuperación especificas\n"+
                            "- Existe variabilidad en la percepción del cansancio acumulado según el tipo de entrenamiento y experiencia \n");
             
             //Cree el archivo reporte_06_04_2024.txt dentro del directorio abril_2024
             archivoContenido(new File(abril2024Dir, "reporte_06_04_2024.txt"),
                   "# Topico del reporte\n"+
                            "- Impacto de la contaminacion del aire en la salud publica\n"+
                            "\n"+
                            " #Notas\n"+
                            "- Investigar los principales contaminantes presentes en el aire \n "+
                            "- Analizar los efectos a corto y largo plazo de la exposicion a la contaminacion del aire\n"+
                            "\n"+
                            "#Dificultales\n"+
                            "- Dificultad 1: Obtener datos precisos sobre la calidad del aire en areas especificas\n "+
                            "- Dificultad 2: Evaluar la relacion causal entre la contaminacion del aire y enfermedades especificas\n"+
                            "\n"+
                            "# Hallazgos\n"+
                            "- Se identifica una correlacion directa entre niveles altos de contaminacion del aire y aumtento de caos de enfermedades respiratorias \n"+
                            "- Algunas medidas regulatorias han demostrado ser efectivas en la reducción de contaminantes atmosfericos\n"+
                            "- Existe una necesidad urgente de politicas mas estrictas y acciones concertadas para mejorar lacalidad del aire en áreas urbanas\n"); 
             
        } catch (IOException e){// captura cualquier error de entrada/salida del bloque try
            e.printStackTrace();//imprime el error
        }
    }
        
    //Declaro el metodo ArchivoContenido, llamando al File archivo y String contenido 
    public static void archivoContenido(File archivo, String contenido) throws IOException {
        archivo.getParentFile().mkdirs();// Obtiene el directorio padre del archivo y mkdirs() crea los directorios necesarios
        try (FileWriter writer = new FileWriter(archivo)) { //escribe el contenido en el archivo
            writer.write(contenido);
        }
    }
}

