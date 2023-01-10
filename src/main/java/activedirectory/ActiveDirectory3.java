package activedirectory;



import javax.naming.directory.DirContext;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.Hashtable;


public class ActiveDirectory3 {


    public static void main(String[] args) {
        System.out.println(isLdapRegistred("",""));
    }

    // validação de usuario no ldap
    public static  boolean isLdapRegistred(String username, String password) {

        String domainName = "local";

       /*
		if(true) {
    	  return true;
       }*/
		/*
		try {
			String fqdn = java.net.InetAddress.getLocalHost().getCanonicalHostName();
			if (fqdn.split("\\.").length > 1)
				domainName = fqdn.substring(fqdn.indexOf(".") + 1);
		  } catch (java.net.UnknownHostException e) {
		}*/
        // log.info(domainName);

        boolean result = false;
        try {
          String principalName = username + "@" + domainName;

            //	String principalName = username;

            Hashtable<String, String> env = new Hashtable<String, String>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldap://" + domainName);
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            // env.put(Context.SECURITY_PRINCIPAL, "OUR-DOMAIN\\" + username);
            env.put(Context.SECURITY_PRINCIPAL, principalName);
            env.put(Context.SECURITY_CREDENTIALS, password);

            LdapContext ctx2 =  new InitialLdapContext(env, null);
            SearchControls searchControls = getSearchControls();

            NamingEnumeration<SearchResult> answer = ctx2.search("DC=local,DC=local", "sAMAccountName=" + username,searchControls);
            //Attributes attrs = answer.next().getAttributes();
            //	String grupo = attrs.get("memberOf").toString();
			/*
			if(!grupo.toString().contains("Sistemas")) {
				log.error("Sem permissão de grupo:" + username);
				return false;

			}*/

            // Create the initial context
            DirContext ctx = new InitialDirContext(env);

            result = ctx != null;
            if (ctx != null)
                ctx.close();
            //	log.info("Logado : " + username);
            return result;
        } catch (Exception e) {
            System.out.println("Falha na autenticação:" + username);
           // log.error("Falha na autenticação:" + username);
            return result;
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
