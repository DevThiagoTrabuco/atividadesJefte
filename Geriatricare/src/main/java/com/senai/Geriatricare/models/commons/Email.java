package com.senai.Geriatricare.models.commons;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

import java.util.regex.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    private Pattern EMAIL_PADRAO = Pattern.compile(
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", Pattern.CASE_INSENSITIVE);

    private String email;

    @JsonCreator
    public Email(String email) {
        this.email = email;
    }

    @JsonValue
    public String getEmail() {
        return email;
    }

    public boolean validaEmail() {
        return email != null && EMAIL_PADRAO.matcher(email).matches();
    }
}
