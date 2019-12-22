
package paassalaskuharjoittelusovellus.domain;

/**
 * A class used for loggin in.
 * 
 */
public class User {
    private final String userName;
    private final String password;

    /**
     *
     * @param userName username
     * @param password password
     */
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
