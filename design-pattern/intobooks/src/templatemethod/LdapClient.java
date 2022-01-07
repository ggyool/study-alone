package templatemethod;

public interface LdapClient {

    boolean authenticate(String id, String pw);

    LdapContext find(String id);
}
