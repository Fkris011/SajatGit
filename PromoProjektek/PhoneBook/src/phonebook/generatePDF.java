/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import javafx.collections.ObservableList;

/**
 *
 * @author f_kri
 */
public class generatePDF {

 

    void generatePDF(String fajlnev, ObservableList<Person> data) {

        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(fajlnev + ".pdf"));
            document.open();
            Image image1 = Image.getInstance(getClass().getResource("/logo.png"));
            image1.scaleToFit(image1);
            image1.setAbsolutePosition(200f, 700f);
            document.add(image1);

            document.add(new Paragraph("\n\n\n\n\n\n\n\n\n\n" + data, FontFactory.getFont("betűtípus", BaseFont.IDENTITY_H, BaseFont.EMBEDDED)));

            //Táblázat
            
            float[] columnWidths = {2,3,3,4};
            String string = "Kontaktlista";
            
            PdfPTable table = new PdfPTable(columnWidths);
            table.setWidthPercentage(100);
            PdfPCell cell = new PdfPCell( new Phrase (string));
            cell.setBackgroundColor(BaseColor.DARK_GRAY);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            table.addCell("Sorszám");
            table.addCell("Vezetéknév");
            table.addCell("Keresztnév");
            table.addCell("E-Mail cím");
            table.setHeaderRows(1);
            
            table.setHeaderRows(1);
            
            table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            
            for (int i = 1; i <= data.size(); i++) {
               Person actualPerson = data.get(i-1);
                
                table.addCell("" + i);
                table.addCell(actualPerson.getLastName());
                table.addCell(actualPerson.getFirstName());
                table.addCell(actualPerson.getEmail());
            }
            
            document.add(table);
            
            
            //Aláírás
            Chunk signature = new Chunk("\n\n Generálva a Telefonkönyv alaklmazás segítségel.");

            Paragraph base = new Paragraph(signature);
            document.add(base);

        } catch (Exception e) {

            e.printStackTrace();
        }
        document.close();

    

}
}
