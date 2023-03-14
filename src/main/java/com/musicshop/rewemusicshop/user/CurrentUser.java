package com.musicshop.rewemusicshop.user;

import com.musicshop.rewemusicshop.models.Client;
import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrentUser {
    private Long id;
    private String name;

    public void login(Client client) {
        this.id = client.getId();
        this.name = client.getName();
    }

    public void logout() {
        this.id = null;
        this.name = null;
    }
}
