/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assesmenta4;

/**
 *
 * @author RENTCOM SASA
 */
//usted debe contruir una aplicacion que riciba imagenes en formato JPG de cualquier dimension
//la aplicacion debe procesar la imagen y definir el tamaño que debbe tener la misma para entrar en una hoja a4 (798 + 1123px)
//sin margenes. El resultado debe contemplar los siguientes criterios de aceptación
//no puede perder el ratio
//se debe aprovechar maximo de la hoja A4
//ninguna de las imagenes debe ser agrandada en el proceso, solo encojida cuando corresponda
//la orientación de la pagina debe definir a partir de la orientación de la imagen (Horizontal/vertical)
//puedes decidir entre construir una pantalla para recibir la imagen o recibirla desde una ruta fija
//la aplicación debe entregar tres respuesta para cada imagen 
//1. Orientación
//2. Ancho de la imagen
//3. Alto de la imagen
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class AssesmentA4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Ruta de la imagen de entrada

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la ruta de la imagen: ");
        String imagePath = scanner.nextLine();

        try {
            // Leer la imagen de entrada
            BufferedImage inputImage = ImageIO.read(new File(imagePath));

            // Obtener las dimensiones de la imagen de entrada
            int ancho = inputImage.getWidth();
            int alto = inputImage.getHeight();

            int a4Width = 798; // Ancho de una hoja A4 en píxeles
            int a4Height = 1123; // Alto de una hoja A4 en píxeles
            int anchoSalida, altoSalida;
            if (ancho >= alto) {
                // La imagen es más ancha (o cuadrada) que una hoja A4
                anchoSalida = a4Width;
                altoSalida = (int) ((double) a4Width / ancho * alto);
            } else {
                // La imagen es más alta que una hoja A4
                altoSalida = a4Height;
                anchoSalida = (int) ((double) a4Height / alto * ancho);
            }
            

            // Imprimir los resultados
            if (ancho >= alto) {
                System.out.println("Orientación: Horizontal");
            } else {
                System.out.println("Orientación: Vertical");
            }
            
 
            System.out.println("Ancho de la imagen: " + ancho);
            System.out.println("Alto de la imagen: " + alto);
            System.out.println("Ancho de la imagen ajustado: " + anchoSalida);
            System.out.println("Alto de la imagen ajustado: " + altoSalida);
        } catch (IOException e) {
            System.out.println("Error al leer la imagen: " + e.getMessage());

        }
        
    }
    
   
}




