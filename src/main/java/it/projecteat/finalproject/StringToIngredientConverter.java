package it.projecteat.finalproject;

import it.projecteat.finalproject.Entity.Ingredients;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class StringToIngredientConverter implements Converter<String, Ingredients> {

    @Override
    public Ingredients convert(String s) {
        return new Ingredients(Integer.parseInt(s), "", 1);
//    coconut
    }
}

