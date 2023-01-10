package rtf;

public class Teste02 {

   static  String text = "<html> <head> <style> <!-- --> </style> </head> <body> <p class=default> <span style=\"font-size: 13pt; font-family: Calibri\">\n" +
            "font-family: Calibri\"> <u><b></b></u> </span> </p> <p class=default> <span style=\"color: #000080; font-size: 10pt; font-family:\n" +
            "Arial\"> </span> </p> </body> </html>";


    public static void main(String[] args) {

         String nova2 = text.replaceAll("<html> <head> <style> <!-- --> </style> </head> <body>","")
                 .replaceAll("</body>","")
                 .replaceAll("</html>","");



          String nova = text.replaceAll("<html>","")
                           .replaceAll("<head>","")
                           .replaceAll("<style>","")
                           .replaceAll("</style>","")
                           .replaceAll("</head>","")
                           .replaceAll("<body>","")
                           .replaceAll("</body>","")
                           .replaceAll("</html>","");


          System.out.println(nova2);

    }
}
