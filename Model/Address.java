package Model;

public class Address {
    private int houseNo;
    private String streetName;
    private String townName;
    private String districtName;
    private String stateName;
    private int pinCode;

    public Address(int houseNo, String streetName, String townName, String districtName, String stateName, int pinCode) {
        this.houseNo = houseNo;
        this.streetName = streetName;
        this.townName = townName;
        this.districtName = districtName;
        this.stateName = stateName;
        this.pinCode = pinCode;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getTownName() {
        return townName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public String getStateName() {
        return stateName;
    }

    public int getPinCode() {
        return pinCode;
    }
}
