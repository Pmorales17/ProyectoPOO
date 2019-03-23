package ar.edu.unnoba.poo2018.ods.converter;

import ar.edu.unnoba.poo2018.model.Simple;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass=Simple.class)
public class SimpleConverter extends AbstractConverter<Simple>{

    @Override
    public String getDAOName() {
        return "SimpleDAO";
    }     
}
