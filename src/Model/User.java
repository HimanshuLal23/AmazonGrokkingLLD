package Model;

import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private String phone;
    private String email;
    private Address defaultAddress;
    private UserType userType;

    public User(String name, String phone, String email, Address defaultAddress, UserType userType) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.defaultAddress = defaultAddress;
        this.userType = userType;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Address getDefaultAddress() {
        return defaultAddress;
    }

    public UserType getUserType() {
        return userType;
    }
}
