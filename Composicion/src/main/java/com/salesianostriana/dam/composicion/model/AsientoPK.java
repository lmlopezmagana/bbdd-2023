package com.salesianostriana.dam.composicion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsientoPK implements Serializable {

    private Long avion;
    private Long id;

}
