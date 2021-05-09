package it.projecteat.finalproject;

import it.projecteat.finalproject.Entity.Ingredients;
import org.springframework.core.convert.converter.Converter;

public class StringToIngredientConverter implements Converter<String, Ingredients> {


    @Override
    public Ingredients convert(String s) {
        int a = Integer.parseInt(s);
        Ingredients i = new Ingredients();
        i.setId(a);
        return i;
    }
}
