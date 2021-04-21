package dataObjects;

import core.PropertiesLoader;

public class CredentialsFactory {
    private static CredentialsFactory instance;
    private static final PropertiesLoader prLoader = new PropertiesLoader("credentials.properties");
    private static Credentials validUserCreds;
    private static Credentials lockedUserCreds;
    private static Credentials problemUserCreds;
    private static Credentials invalidUserCreds;

    public static CredentialsFactory loadCredentials() {
        if (instance == null) {
            instance = new CredentialsFactory();
            validUserCreds = new Credentials(
                    prLoader.getProperty("valid.username"),
                    prLoader.getProperty("password"));
            lockedUserCreds = new Credentials(
                    prLoader.getProperty("locked.username"),
                    prLoader.getProperty("password"));
            problemUserCreds = new Credentials(
                    prLoader.getProperty("problem.username"),
                    prLoader.getProperty("password"));
            invalidUserCreds = new Credentials(
                    prLoader.getProperty("invalid.username"),
                    prLoader.getProperty("invalid.password"));
        }
        return instance;
    }

    public Credentials getValidUserCreds() {
        return validUserCreds;
    }

    public Credentials getLockedUserCreds() {
        return lockedUserCreds;
    }

    public Credentials getProblemUserCreds() {
        return problemUserCreds;
    }

    public Credentials getInvalidUserCredsCreds() {
        return invalidUserCreds;
    }
}
