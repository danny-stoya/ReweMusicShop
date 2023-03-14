package com.musicshop.rewemusicshop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "music_companies")
@Getter
@Setter
@NoArgsConstructor
public class MusicCompany extends BaseEntity {
    private String name;
    @OneToMany(mappedBy = "musicCompany")
    List<Studio> musicStudios;
}
