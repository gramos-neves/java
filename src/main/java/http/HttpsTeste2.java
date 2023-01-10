package http;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import java.util.stream.Collectors;




public class HttpsTeste2 {


    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, IOException {


        javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[] {
                new javax.net.ssl.X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    @Override
                    public void checkClientTrusted(java.security.cert.X509Certificate[] arg0, String arg1)
                            throws CertificateException {}

                    @Override
                    public void checkServerTrusted(java.security.cert.X509Certificate[] arg0, String arg1)
                            throws CertificateException {}
                }
        };

        javax.net.ssl.SSLContext sc=null;
        try {
            sc = javax.net.ssl.SSLContext.getInstance("SSL");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        // Create all-trusting host name verifier
        javax.net.ssl.HostnameVerifier validHosts = new javax.net.ssl.HostnameVerifier() {
            @Override
            public boolean verify(String arg0, javax.net.ssl.SSLSession arg1) {
                return true;
            }
        };
        // All hosts will be valid
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(validHosts);


        URL url = new java.net.URL("https://localhost:8443/api/extensions/dashboardstatus/channelStates/18b35405-9d8c-41ec-a505-a1018b43ddbe");
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("Authorization", "Basic YWRtaW46YWRtaW4=");
        urlConnection.setRequestProperty("X-Requested-With", "XMLHttpRequest");
        urlConnection.setRequestProperty("Content-Type", "application/json");

        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(urlConnection.getInputStream())));

        System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">",">\n"));


    }


}
