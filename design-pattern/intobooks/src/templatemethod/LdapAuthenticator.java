package templatemethod;

public class LdapAuthenticator extends Authenticator {

    private LdapClient ldapClient;

    @Override
    protected boolean doAuthenticate(String id, String pw) {
        return ldapClient.authenticate(id, pw);
    }

    @Override
    protected Auth createAuth(String id) {
        LdapContext ldapContext = ldapClient.find(id);
        return new Auth(id, ldapContext.getAttribute("name"));
    }
}
