package com.dietrich.jakarta2.converter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(value = "estadoConverter", forClass = Estado.class)
public class EstadoConverter implements Converter<Estado> {
    @Override
    public Estado getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return Estado.buscar(s);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Estado estado) {
        return estado.getSigla();
    }
}
