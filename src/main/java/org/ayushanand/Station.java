package org.ayushanand;

import java.util.Objects;

public class Station {
    private final String code;
    private String name;

    public Station(String code,String name) {
        if(!isValid(code)) {
            throw new IllegalArgumentException("Station Code is invalid or null");
        }
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Station Name is invalid or null");
        }
        this.code=code;
        this.name=name;
    }
    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public void rename(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Station Name is invalid or null");
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(! (obj instanceof Station other))
            return false;
        return Objects.equals(this.code,other.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.code);
    }

    private static boolean isValid(String code){
        if(code == null || code.isBlank())
            return false;

        for(int i = 0;i < code.length();i++) {
            char ch = code.charAt(i);
            if(ch < 'A' || ch > 'Z')
                return false;
        }
        return true;
    }
}
