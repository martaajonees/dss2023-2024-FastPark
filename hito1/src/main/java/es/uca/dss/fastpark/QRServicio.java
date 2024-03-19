package es.uca.dss.fastpark;
import java.lang.String;

import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;  //Generar QR
import com.google.zxing.qrcode.QRCodeWriter;  //Generar QR

import javax.imageio.ImageIO;  //Generar Imagen QR
import java.awt.image.BufferedImage;  //Generar Imagen QR
import java.io.FileNotFoundException;  //Excepción de archivos de la ruta
import java.io.FileOutputStream;  //Generar un archivo de salida
import java.io.IOException;  //Excepción de archivos
import java.io.File;  //Para obtener la ruta
import com.google.zxing.LuminanceSource;  //Luminosidad en la escala de grises para interpretar correctamente la información del código QR
import java.util.Scanner;  //Para leer desde la terminal
 public class QRServicio {
     private static final int qrTamAncho = 400;
     private static final int qrTamAlto = 400;
     private static final String formato = "png";
     private static final String ruta = ObtenerRuta();
     QRServicio(){}

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
     void generarQR(String m) throws  FileNotFoundException, IOException{
        BitMatrix matrix = null;  //Crear una matriz de bits bidimensional para el QR
        Writer writer = new QRCodeWriter();  //Generar el objeto writer para generar posterioromente el QR
         try{
             matrix = writer.encode(m, BarcodeFormat.QR_CODE, qrTamAlto, qrTamAncho);  //Generación del QR
         } catch (WriterException e){
             e.printStackTrace();
         }
         BufferedImage imagen = new BufferedImage(qrTamAlto, qrTamAncho, BufferedImage.TYPE_INT_RGB);  //Generar la imagen del código QR
         for (int x = 0; x < qrTamAlto; x++)   //Dibujar la imagen del código QR
         {
             for (int y = 0; y < qrTamAncho; y++)
             {
                 int valor = (matrix.get(x, y) ? 0 : 1) & 0xff;
                 imagen.setRGB(x, y, (valor == 0 ? 0 : 0xFFFFFF));
             }
         }
         String result = m + ".png";
         String route = ruta + File.separator + result;
         FileOutputStream codigo = new FileOutputStream(route);  //Crear el archivo de salida donde se guardará el resultado
         ImageIO.write(imagen, formato, codigo);   //Escribir la imagen del código QR
         codigo.close();
     }
     String leerQR(String nomArch) throws  IOException, NotFoundException {
        String rutaComplete = ruta + File.separator + nomArch;
        File archQR = new File(rutaComplete);

        BufferedImage imagenQR = ImageIO.read(archQR);
        //LuminanceSource fuente = new BufferedImageLuminanceSource(imagenQR);

     }
}
