package ar.edu.unnoba.poo2018.ods.converter;

import ar.edu.unnoba.poo2018.model.Convocatoria;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass=Convocatoria.class)
public class ConvocatoriaConverter extends AbstractConverter<Convocatoria>{

    @Override
    public String getDAOName() {
        return "ConvocatoriaDAO";
    }    
}
