package io.turntabl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClientRegister {
    private List<CorporateClient> corporateClientList;
    private List<PrivateClient> privateClientList;

    public ClientRegister(List<CorporateClient> corporateClientList, List<PrivateClient> privateClientList) {
        this.corporateClientList = corporateClientList;
        this.privateClientList = privateClientList;
    }
    public List<Client> totalList(){
        return Stream.concat(corporateClientList.stream(),privateClientList.stream()).collect(Collectors.toList());
    }

    public List<String> getGoldClients(){
        return totalList().stream().filter(s->s.getServiceLevel()==ServiceLevel.Gold).map(s->s.getContactName()).collect(Collectors.toList());
    }

    public String getClientNameById(String id){
        return totalList().stream().filter(cid -> cid.getId() == id).map(cid -> cid.getName()).findAny().orElse("");
    }

    public Map<ServiceLevel, Long> countClientsByServiceLevel(){
        return totalList().stream().collect(Collectors.groupingBy(l -> l.getServiceLevel(),Collectors.counting()));
    }
}
