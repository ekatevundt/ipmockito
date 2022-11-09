package ru.netology.i18n;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {
    @Test
    void checkLocalRussian() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        Location location = mock(Location.class);
        when(location.getCountry()).thenReturn(Country.RUSSIA);
        assertEquals("Добро пожаловать", localizationService.locale(location.getCountry()));

    }

    @Test
    void checkLocalEnglish() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        Location location = mock(Location.class);
        when(location.getCountry()).thenReturn(Country.USA);
        assertEquals("Welcome", localizationService.locale(location.getCountry()));

    }
}