package PDF;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import escola.Objetos.Aluno;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GerarPDF {

    public void GerarPDF(List<Aluno> dados) {
        Document doc = new Document();

        try {
            PdfWriter.getInstance(doc, new FileOutputStream("Arquivo.pdf"));

            Font ftitulo = new Font(Font.FontFamily.TIMES_ROMAN, 50.0f, Font.BOLD, BaseColor.ORANGE);
            Font fheader = new Font(Font.FontFamily.TIMES_ROMAN, 14.0f, Font.BOLD, BaseColor.BLACK);
            Font fcorpo = new Font(Font.FontFamily.TIMES_ROMAN, 12.0f, Font.NORMAL, BaseColor.BLACK);

            doc.open();
            Paragraph p = new Paragraph("Relatório", ftitulo);
            p.setAlignment(1);
            doc.add(p);
            p = new Paragraph("   ");
            doc.add(p);
            
            PdfPTable table = new PdfPTable(3);
            table.setWidths(new int[]{8,8,4});
            table.setWidthPercentage(100);
            
            PdfPCell coluna1 = new PdfPCell(new Paragraph("Nome",fheader));
            PdfPCell coluna2 = new PdfPCell(new Paragraph("Email",fheader));
            PdfPCell coluna3 = new PdfPCell(new Paragraph("RA",fheader));
            
            table.addCell(coluna1);
            table.addCell(coluna2);
            table.addCell(coluna3);
            
            for (Aluno a : dados) {
                coluna1 = new PdfPCell(new Paragraph(a.getNome(), fcorpo));
                coluna2 = new PdfPCell(new Paragraph(a.getEmail(), fcorpo));
                coluna3 = new PdfPCell(new Paragraph(a.getRa(), fcorpo));
                table.addCell(coluna1);
                table.addCell(coluna2);
                table.addCell(coluna3);
            }
            
            doc.add(table);
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(GerarPDF.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            doc.close();
        }
        
        try {
            Desktop.getDesktop().open(new File("Arquivo.pdf"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Erro ao abrir arquivo");
        }

    }

}
