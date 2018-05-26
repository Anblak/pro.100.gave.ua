package ua.game.pro.entity.enums;

import java.util.HashMap;
import java.util.Map;

public enum Role {
    ROLE_ADMIN("Admin"), ROLE_CREATOR("Starosta"), ROLE_USER("Student");
    private static final Map<String, Role> map;

    static {
        map = new HashMap<>();
        for (Role role : Role.values()) {
            map.put(role.nameForHumans, role);
        }
    }

    private String nameForHumans;

    Role(String nameForHumans) {
        this.nameForHumans = nameForHumans;
    }

    public static Role findByKey(String nameForHumans) {
        return map.get(nameForHumans);
    }

    public String getNameForHumans() {
        return nameForHumans;
    }
}
