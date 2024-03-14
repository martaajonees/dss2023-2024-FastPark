package es.uca.dss.fastpark;
import java.lang.String;
import com.google.zxing.BarcodeFormat;  //Generar QR
import com.google.zxing.Writer;  //Generar QR
import com.google.zxing.WriterException;  //Generar QR
import com.google.zxing.common.BitMatrix;  //Generar QR
import com.google.zxing.qrcode.QRCodeWriter;  //Generar QR

import javax.imageio.ImageIO;  //Generar Imagen QR
import java.awt.image.BufferedImage;  //Generar Imagen QR
import java.io.FileNotFoundException;  //Excepción de archivos de la ruta
import java.io.FileOutputStream;  //Generar un archivo de salida
import java.io.IOException;  //Excepción de archivos
import java.io.File;  //Para obtener la ruta
import java.util.Scanner;  //Para leer desde la terminal
 public class QRServicio {
     QRServicio(){}
     private static final int qrTamAncho = 400;
     private static final int qrTamAlto = 400;
     private static final String formato = "png";
     private static final String ruta = ObtenerRuta();

     static String ObtenerRuta() {
         //Obtener la ruta del directorio principal de usuario
         String homeDirectory = System.getProperty("user.home");
         //Nombre de la carpeta donde se guardarán los QR generados
         String folderName = "QR";
         //Crear la ruta completa de la carpeta
         String folderPath = homeDirectory + File.separator + folderName;
         //Crear el objeto File que representa la carpeta
         File folder = new File(folderPath);

         //Verificar si la carpeta no existe y crearla si es necesario
         if (!folder.exists())
         {
             boolean created = folder.mkdirs();  //Para crear todos los directorios especificados en la ruta contenida de folder
             if (!created)
             {
                 System.err.println("No se pudo crear la carpeta");
                 System.exit(1);  //Terminar el programa al ocurrir el error
             }
             System.out.println("Carpeta creada en: " + folderPath);
         } else {
             System.out.println("La carpeta ya existe en: " + folderPath);
         }
        return folderPath;
     }
     void generarQR(String m){

     }
     String leerQR(){
         return "Hola";
     }
}
