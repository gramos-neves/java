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
           // String htmlText = rtfToHtml(new StringReader(teste));
            //System.out.println(htmlText);

            String html = convertTextRTF2HTML(rtf);
            String novo=  html.replaceAll("<[^>]*>", "");
            System.out.println(novo);
            System.out.println(html);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
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


    public static  String convertTextRTF2HTML(String text) throws Exception {
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

        HtmlToText htmlToText = new HtmlToText();

         htmlToText.parse(writer.toString());
          System.out.println(htmlToText.getText());

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

  static   String rtf = "{\\rtf1\\ansi\\ansicpg1252\\deff0{\\fonttbl{\\f0\\fnil\\fcharset0 Arial;}{\\f1\\fnil Verdana;}{\\f2\\fnil MS Sans Serif;}}"
            +"	{\\colortbl ;\\red0\\green0\\blue0;\\red0\\green0\\blue128;} "
            +"	\\viewkind4\\uc1\\pard\\cf1\\lang1046\\fs20\\tab\\tab\\tab\\tab\\tab\\tab\\tab\\tab\\tab  \\b NUTRI\\'c7\\'c3O\\b0 "
            +"	\\par  "
            +"	\\par \\b Prescri\\'e7\\'e3o diet\\'e9tica:\\b0 "
            +"	\\par  "
            +"	\\par Dieta enteral polim\\'e9rica hipercal\\'f3rica normoproteica normolip\\'eddica com fibras (1080 ml - 60 ml/h) - \\ul reduzido volume por medidas de conforto\\ulnone "
            +"	\\par \\'c1gua (2 x  300 ml) "
            +"	\\par \\pard\\qj\\f1   "
            +"	\\par \\pard\\f0 In\\'edcio de dieta enteral: 11/02/2020. "
            +"	\\par Meta nutricional de dieta enteral (recalculada): 60 ml/h (18 horas de infus\\'e3o, 25 kcal/kg, medidas de conforto)\\cf2\\f2\\fs16 "
            +"	\\par \\pard\\qj\\cf1\\f1\\fs20 "
            +"	\\par } ";




}
