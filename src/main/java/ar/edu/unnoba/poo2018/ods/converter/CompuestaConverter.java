package ar.edu.unnoba.poo2018.ods.converter;

import ar.edu.unnoba.poo2018.model.Compuesta;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass=Compuesta.class)
public class CompuestaConverter extends AbstractConverter<Compuesta>{

    @Override
    public String getDAOName() {
        return "CompuestaDAO";
    }     
}