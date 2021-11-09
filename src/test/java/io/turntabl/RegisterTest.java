package io.turntabl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterTest {
    List<CorporateClient> corporateClientList = List.of(new CorporateClient("Selasi", "123", ServiceLevel.Platinum, "Randy"),
            new CorporateClient("Jeff", "124", ServiceLevel.Gold, "Asmah"),
            new CorporateClient("Moses","125", ServiceLevel.Premium, "Alhassan"));

    List<PrivateClient> privateClientList = List.of(new PrivateClient("Philip", "127", ServiceLevel.Premium),
            new PrivateClient("Henry", "234", ServiceLevel.Gold),
            new PrivateClient("Romeo", "345", ServiceLevel.Platinum));

    ClientRegister clientRegister = new ClientRegister(corporateClientList, privateClientList);

    @Test
    public void testClientRegister(){
        int expectedNumber = 6;
        int totalClients = clientRegister.totalList().size();
        assertTrue(expectedNumber==totalClients);
    }

    @Test
    public void getContactNameTest(){
        Client clientss = new CorporateClient("Priscilla", "234", ServiceLevel.Platinum, "Odame");
        String expectedValue = "Odame";
        String contactName = clientss.getContactName();
        assertEquals(expectedValue, contactName);
    }

    @Test
    public void getAllGoldClientsTest(){
        List<String> expectedValue = List.of("Asmah", "Henry");
        List<String> contactNames = clientRegister.getGoldClients();
        assertEquals(expectedValue, contactNames);
    }

    @Test
    public void getClientNameByIdTest(){
//        Client clientss = new CorporateClient("Priscilla", "234", ServiceLevel.Platinum, "Odame");
        String expectedValue = "Henry";
        String getNameById = clientRegister.getClientNameById("234");
        assertEquals(expectedValue, getNameById);
    }

    @Test
    public void countClientsByServiceLevelTest(){

        Map<String, Long> mapCount= new HashMap<>();
        mapCount.put("Gold", 2l);
        mapCount.put("Platinum",2l);
        mapCount.put("Premium", 2l);

        //This is failing because it is not in the same arangement
        assertEquals(mapCount,clientRegister.countClientsByServiceLevel());
}
}
