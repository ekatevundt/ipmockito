package ru.netology.sender;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static ru.netology.sender.MessageSenderImpl.IP_ADDRESS_HEADER;

class MessageSenderImplTest {


    @Test
    void sendRussian() {
        Map<String, String> headers = new HashMap<>();
        headers.put(IP_ADDRESS_HEADER, "172.123.12.19");
        GeoServiceImpl geoService = mock(GeoServiceImpl.class);
        LocalizationServiceImpl localizationService = mock(LocalizationServiceImpl.class);
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        Location location = mock(Location.class);
        when(location.getCountry()).thenReturn(Country.RUSSIA);
        when(localizationService.locale(location.getCountry())).thenReturn(String.valueOf(Country.RUSSIA));
        when(geoService.byIp("172.123.12.19")).thenReturn(location);
        assertEquals(String.valueOf(Country.RUSSIA), messageSender.send(headers));
    }

    @Test
    void sendEnglish() {
        Map<String, String> headers = new HashMap<>();
        headers.put(IP_ADDRESS_HEADER, "94.33.33.33");
        GeoServiceImpl geoService = mock(GeoServiceImpl.class);
        LocalizationServiceImpl localizationService = mock(LocalizationServiceImpl.class);
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        Location location = mock(Location.class);
        when(location.getCountry()).thenReturn(Country.USA);
        when(localizationService.locale(location.getCountry())).thenReturn(String.valueOf(Country.USA));
        when(geoService.byIp("94.33.33.33")).thenReturn(location);
        assertEquals(String.valueOf(Country.USA), messageSender.send(headers));
    }
}