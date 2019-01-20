package creational.prototype.access;

import java.util.HashMap;
import java.util.Map;

public class AccessControlProvider {

    private static final Map<String, AccessControl> MAP = new HashMap<>();

    static {
        System.out.println("Fetching data from external resources and creating access control objects...");
        MAP.put("USER", new AccessControl("USER", "DO_WORK"));
        MAP.put("ADMIN", new AccessControl("ADMIN", "ADD/REMOVE USERS"));
        MAP.put("MANAGER", new AccessControl("MANAGER", "GENERATE/READ REPORTS"));
        MAP.put("VP", new AccessControl("VP", "MODIFY REPORTS"));
    }

    public static AccessControl getAccessControlObject(String controlLevel) {
        AccessControl ac = MAP.get(controlLevel);
        if (ac != null) {
            try {
                return ac.clone();
            } catch (CloneNotSupportedException ex) {
            }
        }
        return null;
    }
}
