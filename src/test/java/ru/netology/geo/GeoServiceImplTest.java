package ru.netology.geo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class GeoServiceImplTest {
    @Test
    void checkIpRussian() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = mock(Location.class);
        when(location.getCountry()).thenReturn(Country.RUSSIA);
        assertEquals(Country.RUSSIA, geoService.byIp("172.333.222").getCountry());
    }

    @Test
    void checkIpEnglish() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = mock(Location.class);
        when(location.getCountry()).thenReturn(Country.USA);
        assertEquals(Country.USA, geoService.byIp("96.11.11.11").getCountry());
    }

    @Test
    void checkIpEquals() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = mock(Location.class);
        when(location.getCountry()).thenReturn(null);
        assertEquals(null, geoService.byIp("127.0.0.1").getCountry());
    }

    @Test
    void checkIpMoscow() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = mock(Location.class);
        when(location.getCity()).thenReturn("Moscow");
        assertEquals(location.getCity(), geoService.byIp("172.0.32.11").getCity());
    }

    @Test
    void checkNewYork() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = mock(Location.class);
        when(location.getCity()).thenReturn("New York");
        assertEquals(location.getCity(), geoService.byIp("96.44.183.149").getCity());
    }

}