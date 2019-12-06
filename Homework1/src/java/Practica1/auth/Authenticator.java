package Practica1.auth;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.security.GeneralSecurityException;
import javax.security.auth.login.LoginException;

public final class Authenticator {
    private static Authenticator authenticator = null;

    private final Map<String, String> usersStorage = new HashMap();
    private final Map<String, String> serviceKeysStorage = new HashMap();
    private final Map<String, String> authorizationTokensStorage = new HashMap();

    private Authenticator() {
        // The information should be in a DB
        usersStorage.put( "admin", "admin" );
        serviceKeysStorage.put( "f80ebc87-ad5c-4b29-9366-5359768df5a1", "admin" );
    }

    public static Authenticator getInstance() {
        if ( authenticator == null ) {
            authenticator = new Authenticator();
        }

        return authenticator;
    }

    public String login( String serviceKey, String username, String password ) throws LoginException {
        if ( serviceKeysStorage.containsKey( serviceKey ) ) {
            String usernameMatch = serviceKeysStorage.get( serviceKey );

            if ( usernameMatch.equals( username ) && usersStorage.containsKey( username ) ) {
                String passwordMatch = usersStorage.get( username );

                if ( passwordMatch.equals( password ) ) {

                    /**
                     * Once all params are matched, the authToken will be
                     * generated and will be stored in the
                     * authorizationTokensStorage. The authToken will be needed
                     * for every REST API invocation and is only valid within
                     * the login session
                     */
                    String authToken = UUID.randomUUID().toString();
                    authorizationTokensStorage.put( authToken, username );

                    return authToken;
                }
            }
        }

        throw new LoginException( "Don't Come Here Again!" );
    }

    /**
     * The method that pre-validates if the client which invokes the REST API is
     * from a authorized and authenticated source.
     *
     * @param serviceKey The service key
     * @param authToken The authorization token generated after login
     * @return TRUE for acceptance and FALSE for denied.
     */
    public boolean isAuthTokenValid( String serviceKey, String authToken ) {
        if ( isServiceKeyValid( serviceKey ) ) {
            String usernameMatch1 = serviceKeysStorage.get( serviceKey );

            if ( authorizationTokensStorage.containsKey( authToken ) ) {
                String usernameMatch2 = authorizationTokensStorage.get( authToken );

                if ( usernameMatch1.equals( usernameMatch2 ) ) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * This method checks is the service key is valid
     *
     * @param serviceKey
     * @return TRUE if service key matches the pre-generated ones in service key
     * storage. FALSE for otherwise.
     */
    public boolean isServiceKeyValid( String serviceKey ) {
        return serviceKeysStorage.containsKey( serviceKey );
    }

    public void logout( String serviceKey, String authToken ) throws GeneralSecurityException {
        if ( serviceKeysStorage.containsKey( serviceKey ) ) {
            String usernameMatch1 = serviceKeysStorage.get( serviceKey );

            if ( authorizationTokensStorage.containsKey( authToken ) ) {
                String usernameMatch2 = authorizationTokensStorage.get( authToken );

                if ( usernameMatch1.equals( usernameMatch2 ) ) {

                    /**
                     * When a client logs out, the authentication token will be
                     * remove and will be made invalid.
                     */
                    authorizationTokensStorage.remove( authToken );
                    return;
                }
            }
        }

        throw new GeneralSecurityException( "Invalid service key and authorization token match." );
    }
}