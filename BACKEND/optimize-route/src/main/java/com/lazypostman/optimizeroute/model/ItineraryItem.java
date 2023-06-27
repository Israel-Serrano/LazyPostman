package com.lazypostman.optimizeroute.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lazypostman.optimizeroute.model.formcreator.Town;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItineraryItem {
    private String province;
    private Town town;
    private Integer postCode;
    private String roadType;
    private String roadName;
    private Integer roadNumber;
    @JsonIgnore
    private Double coordX;
    @JsonIgnore
    private Double coordY;

    @JsonIgnore
    public double distanceBetween(ItineraryItem otraCasa) {
        double dx = this.coordX - otraCasa.getCoordX();
        double dy = this.coordY - otraCasa.getCoordY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}