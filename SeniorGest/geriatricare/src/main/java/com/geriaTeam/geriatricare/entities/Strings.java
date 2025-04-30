package com.geriaTeam.geriatricare.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Strings {
    private String string;

    public static boolean isNotNullOrEmpty(String str) {
        return str != null && !str.trim().isEmpty();
    }
}
