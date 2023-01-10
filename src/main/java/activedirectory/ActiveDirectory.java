package activedirectory;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.Hashtable;

public class ActiveDirectory {


    public static void main(String[] args) {

        String domainName= "";
        String username ="";
        String password = "";
        String serverName = null ;

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

        String ldapURL = "ldap://" + domainName  + '/';
        //String ldapURL = "ldap://local/";
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        props.put(Context.PROVIDER_URL, ldapURL);


        System.out.println(props);

        try {
                LdapContext ctx = new InitialLdapContext(props, null);
                SearchControls searchControls = getSearchControls();
                NamingEnumeration<SearchResult> answer = ctx.search("DC=local,DC=local", "sAMAccountName=" + username,
                        searchControls);

              //pegar os dados
            Attributes attrs = answer.next().getAttributes();
            String givenName = attrs.get("givenname").toString().replaceAll("givenName:", "");
            String sobrenome = attrs.get("sn").toString().replaceAll("sn:", "");
            String grupo = attrs.get("memberOf").toString();

            System.out.println(givenName);
            System.out.println(sobrenome);
            System.out.println(grupo);
            System.out.println(grupo.contains("grupo"));

            ctx.close();

        } catch (javax.naming.CommunicationException e) {
            System.out.println("Failed to connect to " + domainName + ((serverName == null) ? "" : " through " + serverName));
           // throw new NamingException(
              //      "Failed to connect to " + domainName + ((serverName == null) ? "" : " through " + serverName));
        } catch (NamingException e) {
            System.out.println( "Failed to authenticate " + username + "@" + domainName + ((serverName == null) ? "" : " through " + serverName));
           // throw new NamingException("Failed to authenticate " + username + "@" + domainName
             //       + ((serverName == null) ? "" : " through " + serverName));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private static SearchControls getSearchControls() throws Exception {
        SearchControls cons = new SearchControls();
        cons.setSearchScope(SearchControls.SUBTREE_SCOPE);
        String[] attrIDs = { "distinguishedName", "sn", "givenname", "mail", "telephonenumber", "thumbnailPhoto",
                "memberOf" };
        cons.setReturningAttributes(attrIDs);
        return cons;
    }


}
