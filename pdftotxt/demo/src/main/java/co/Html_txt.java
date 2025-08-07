package co;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Html_txt {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingresar la ruta del archivo HTML: ");
    String inputFilePath = scanner.nextLine();

    System.out.print("Ingresar el nombre con el que se quiere guardar: ");
    String outputFilePath = scanner.nextLine();

    convertHtmlToText(inputFilePath, outputFilePath);

    scanner.close();
  }

  public static void convertHtmlToText(
    String inputFilePath,
    String outputFilePath
  ) {
    try {
      File input = new File(inputFilePath);
      Document document = Jsoup.parse(input, "UTF-8");
      String textContent = document.text();

      FileWriter writer = new FileWriter(outputFilePath);
      writer.write(textContent);
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
