package com.pissouri;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;

/**
 * Static utility methods for type conversions
 */
public final class TypeConversions {

    /**
     * @return A conversion service, registered with a set of converters, to use in non-Spring test fixtures
     */
    public static ConversionService serviceOf(Converter<?, ?>... converters) {

        DefaultConversionService conversionService = new DefaultConversionService();
        for (Converter<?, ?> converter : converters) conversionService.addConverter(converter);

        return conversionService;
    }
}
