package rtf;

import org.xml.sax.InputSource;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.rtf.RTFEditorKit;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class TesteRft {

     private static String teste = "{\\rtf1\\fbidis\\ansi\\deff0{\\fonttbl{\\f0\\froman\\fprq2\\fcharset0 Times New Roman;}{\\f1\\fnil\\fcharset0 Times New Roman;}{\\f2\\fswiss\\fprq2\\fcharset77 MS Sans Serif;}{\\f3\\fnil Times New Roman;}}\n" +
             "{\\colortbl ;\\red0\\green0\\blue0;}\n" +
             "\\par \\pard\\ltrpar\\cf1\\f3\\fs28 \n" +
             "\\par }\n";


    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
             //String  x =  convertTextRTF2HTML(teste);
           String y = stripRtfTags(teste);

            System.out.println(y);
    }



    public static String convertTextRTF2HTML(String text) {
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


    private static String stripRtfTags(String text) throws FileNotFoundException, UnsupportedEncodingException {
        RTFEditorKit rtfParser = new RTFEditorKit();
        //ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(text);
       // System.out.println(byteBuffer);

        // System.out.println(text);

         //FileInputStream f = new FileInputStream(text);
         // System.out.println(f);
         // InputStreamReader r=  new InputStreamReader(f , "UTF-8");
        //InputSource inSource = new InputSource(new InputStreamReader(f , "UTF-8"));

        //System.out.println(r);

        javax.swing.text.Document document = rtfParser.createDefaultDocument();

        try {
            rtfParser.read(new ByteArrayInputStream(text.getBytes()), document, 0);
            return document.getText(0, document.getLength());
        } catch (IOException | BadLocationException ex) {
           // LOGGER.log(Level.SEVERE, "Error stripping RTF tags", ex);
            return text;
        }
    }




    public static String rtfToHtml(String rtfText) {
        if (rtfText != null) {

            rtfText = rtfText.replaceAll("\\{\\\\\\*\\\\[m]?htmltag[\\d]*(.*)}", "$1")
                    .replaceAll("\\\\htmlrtf[1]?(.*)\\\\htmlrtf0", "")
                    .replaceAll("\\\\htmlrtf[01]?", "")
                    .replaceAll("\\\\htmlbase", "")
                    .replaceAll("\\\\par", "\n")
                    .replaceAll("\\\\tab", "\t")
                    .replaceAll("\\\\line", "\n")
                    .replaceAll("\\\\page", "\n\n")
                    .replaceAll("\\\\sect", "\n\n")
                    .replaceAll("\\\\emdash", "&#2014;")
                    .replaceAll("\\\\endash", "&#2013;")
                    .replaceAll("\\\\emspace", "&#2003;")
                    .replaceAll("\\\\enspace", "&#2002;")
                    .replaceAll("\\\\qmspace", "&#2005;")
                    .replaceAll("\\\\bullet", "&#2022;")
                    .replaceAll("\\\\lquote", "&#2018;")
                    .replaceAll("\\\\rquote", "&#2019;")
                    .replaceAll("\\\\ldblquote", "&#201C;")
                    .replaceAll("\\\\rdblquote", "&#201D;")
                    .replaceAll("\\\\row", "\n")
                    .replaceAll("\\\\cell", "|")
                    .replaceAll("\\\\nestcell", "|")
                    .replaceAll("([^\\\\])\\{", "$1")
                    .replaceAll("([^\\\\])}", "$1")
                    .replaceAll("[\\\\](\\{)", "$1")
                    .replaceAll("[\\\\](})", "$1")
                    .replaceAll("\\\\u([0-9]{2,5})", "&#$1;")
                    .replaceAll("\\\\'([0-9A-Fa-f]{2})", "&#x$1;")
                    .replaceAll("\"cid:(.*)@.*\"", "\"$1\"");

            System.out.println(rtfText);

            int index = rtfText.indexOf("<html");
            if (index != -1) {
                return rtfText.substring(index);
            }
        }

        return null;
    }






}
