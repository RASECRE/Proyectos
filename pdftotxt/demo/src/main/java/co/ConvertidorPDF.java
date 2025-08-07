package co;

import java.io.File;
import java.io.IOException;
import java.util.Scanner; // Importar la clase Scanner

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ConvertidorPDF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 

        System.out.print("Ingresa la ruta del archivo PDF: ");
        String rutaPDF = scanner.nextLine(); 

        try {
            PDDocument document = PDDocument.load(new File(rutaPDF));
            PDFTextStripper stripper = new PDFTextStripper();

            String texto = stripper.getText(document);
            System.out.println(texto);

            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close(); 
        }
    }
}
