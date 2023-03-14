package com.musicshop.rewemusicshop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "studios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Studio extends BaseEntity  {
    private double pricePerHour;
    private double minPrice;
    private int dailyHourLimit;
    @ManyToOne
    private MusicCompany musicCompany;

}
