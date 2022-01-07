package templatemethod;

public abstract class Authenticator {

    public Auth authenticate(String id, String pw) {
        if (doAuthenticate(id, pw)) {
            throw createException();
        }

        return createAuth(id);
    }

    private RuntimeException createException() {
        return new RuntimeException("Authentication Exception");
    }

    protected abstract boolean doAuthenticate(String id, String pw);

    protected abstract Auth createAuth(String id);
}
