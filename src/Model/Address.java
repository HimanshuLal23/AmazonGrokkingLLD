package Model;

import java.util.UUID;

public class Address {
    private UUID id;
    private String pinCode;
    private String state;
    private String city;

    public Address(String pinCode, String state, String city) {
        this.id = UUID.randomUUID();
        this.pinCode = pinCode;
        this.state = state;
        this.city = city;
    }

    public UUID getId() {
        return id;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }
}
