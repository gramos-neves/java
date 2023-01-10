package activedirectory;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.ldap.InitialLdapContext;
import java.util.Hashtable;

public class ActiveDirectory2 {

    private static String[] userAttributes = { "distinguishedName", "cn", "name", "uid", "sn", "givenname", "memberOf",
            "samaccountname", "userPrincipalName" };


    public ActiveDirectory2() {
        super();
    }

    public static void main(String[] args) {

        String domainName= "";
        String username ="";
        String password = "";
        String serverName = "";

            try {
                String fqdn = java.net.InetAddress.getLocalHost().getCanonicalHostName();
                if (fqdn.split("\\.").length > 1)
                    domainName = fqdn.substring(fqdn.indexOf(".") + 1);
            } catch (java.net.UnknownHostException e) {
            }


            System.out.println(domainName);

        // bind by using the specified username/password
        Hashtable props = new Hashtable();
        String principalName = username + "@" + domainName;
        props.put(Context.SECURITY_PRINCIPAL, principalName);
        if (password != null)
            props.put(Context.SECURITY_CREDENTIALS, password);

       // String ldapURL = "ldap://" + ((serverName == null) ? domainName : serverName + "." + domainName) + '/';
        String ldapURL = "ldap://local/";
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        props.put(Context.PROVIDER_URL, ldapURL);


        System.out.println(ldapURL);


        try {
             new InitialLdapContext(props, null);
        } catch (javax.naming.CommunicationException e) {
            System.out.println("Failed to connect to " + domainName + ((serverName == null) ? "" : " through " + serverName));
           // throw new NamingException(
              //      "Failed to connect to " + domainName + ((serverName == null) ? "" : " through " + serverName));
        } catch (NamingException e) {
            System.out.println( "Failed to authenticate " + username + "@" + domainName + ((serverName == null) ? "" : " through " + serverName));
           // throw new NamingException("Failed to authenticate " + username + "@" + domainName
             //       + ((serverName == null) ? "" : " through " + serverName));
        }

    }



}
