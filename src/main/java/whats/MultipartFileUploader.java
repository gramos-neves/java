package whats;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class MultipartFileUploader {

    public static void main(String[] args) {
        String charset = "UTF-8";
        File uploadFile1 = new File("C:/Users/guilherme.ramos/Downloads/1_5055622140313731303.pdf");
        String requestURL = "https://graph.facebook.com/v15.0/101451992819275/media?messaging_product=WHATSAPP";

        try {
            MultipartUtility multipart = new MultipartUtility(requestURL, charset);

          //  multipart.addHeaderField("User-Agent", "CodeJava");
            multipart.addHeaderField("Content-Type", "application/pdf");
            multipart.addHeaderField("file", "C:/Users/guilherme.ramos/Downloads/1_5055622140313731303.pdf");

            multipart.addHeaderField("Authorization", "Bearer EAAPo21jnoSsBAE2jinGrKUOUt10ZAig8TrWQHjep1ddZAIZBxircKrIls9kvBOmdqY2KwWTn2L5trr3aVKwrsvCWBYZAiskoyvzNZBk1e2vkLIAB7QOcGtpU8ZAOQe3HBOkEZB8ahgaF2xbvzXsTwEn451Bp3m3k63BKJsO6PB21eb8KZCvPZCiwW4H2uKdh6YgZAUeCpsGZB4TjyYlKWtENZCJIZAZCxKliIvaQqMi0Xd4GtHDwZDZD");
          //  multipart.addFormField("description", "Cool Pictures");
         //   multipart.addFormField("keywords", "Java,upload,Spring");

            multipart.addFilePart("file", uploadFile1);
          //  multipart.addFilePart("fileUpload", uploadFile2);

            List<String> response = multipart.finish();

            System.out.println("SERVER REPLIED:");

            for (String line : response) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
