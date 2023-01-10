package rtf;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.rtf.RTFEditorKit;
import java.io.*;

public class Teste03 {


    public static void main(String[] args) {
        try {
            String htmlText = rtfToHtml(new StringReader(teste));
        System.out.println(htmlText);

            String html = convertTextRTF2HTML(teste);
            System.out.println();
            System.out.println();
//            System.out.println(html);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    public static String rtfToHtml(Reader rtf) throws IOException {
        JEditorPane p = new JEditorPane();
        p.setContentType("text/rtf");
        EditorKit kitRtf = p.getEditorKitForContentType("text/rtf");
        try {
            kitRtf.read(rtf, p.getDocument(), 0);
            kitRtf = null;
            EditorKit kitHtml = p.getEditorKitForContentType("text/html");
            Writer writer = new StringWriter();
            kitHtml.write(writer, p.getDocument(), 0, p.getDocument().getLength());
            return writer.toString();
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static  String convertTextRTF2HTML(String text) {
        if (text == null) {
            return "";
        }
        StringReader reader = new StringReader(text);
        StringWriter writer = new StringWriter();
        RTFEditorKit rtfEditorKit = new RTFEditorKit();
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        Document doc = rtfEditorKit.createDefaultDocument();

        try {
            rtfEditorKit.read(reader, doc, 0);
            htmlEditorKit.write(writer, doc, 0, doc.getLength());
        } catch (IOException ex) {
            // logger.error("Erro na conversão de RTF2HTML.", ex);
        } catch (BadLocationException ex) {
            // logger.error("Erro na conversão de RTF2HTML.", ex);
        }
        return writer.toString();
    }





    static  String text = "<html> <head> <style> <!-- --> </style> </head> <body> <p class=default> <span style=\"font-size: 13pt; font-family: Calibri\">\n" +
          
            "font-size: 13pt; font-family: Calibri\"> <u><b></b></u> </span> </p> <p class=default> <span style=\"color: #000000; font-size: 11pt;\n" +
            "font-family: Calibri\"> <u><b></b></u> </span> </p> <p class=default> <span style=\"color: #000080; font-size: 10pt; font-family:\n" +
            "Arial\"> </span> </p> </body> </html>";


    private static String teste = "{\\rtf1\\fbidis\\ansi\\deff0{\\fonttbl{\\f0\\froman\\fprq2\\fcharset0 Times New Roman;}{\\f1\\fnil\\fcharset0 Times New Roman;}{\\f2\\fswiss\\fprq2\\fcharset77 MS Sans Serif;}{\\f3\\fnil Times New Roman;}}\n" +
            "{\\colortbl ;\\red0\\green0\\blue0;}\n" +
            "\\par \\pard\\ltrpar\\cf1\\f3\\fs28 \n" +
            "\\par }\n";




}
