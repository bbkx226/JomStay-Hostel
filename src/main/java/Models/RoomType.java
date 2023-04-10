// @author Brandon Ban Kai Xian TP067094
package Models;

import java.util.Objects;

public class RoomType {
    private String typeName, facilities, specification;
    private double rentalFee;
    private int beds;
    private boolean isFreeWifi;

    public RoomType(String typeName, int beds, String specification, double rentalFee, String facilities, boolean isFreeWifi) {
        this.typeName = typeName;
        this.rentalFee = rentalFee;
        this.facilities = facilities;
        this.specification = specification;
        this.beds = beds;
        this.isFreeWifi = isFreeWifi;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getFacilities() {
        return facilities;
    }

    public String getFacilitiesString() {
        return facilities.replaceAll("_", " ").replaceAll(",", ", ");
    }
    
    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public double getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(double rentalFee) {
        this.rentalFee = rentalFee;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public boolean isFreeWifi() {
        return isFreeWifi;
    }

    public String getFreeWifiString() {
        if (isFreeWifi) {
            return "Yes";
        }
        return "No";
    }
    
    public void setIsFreeWifi(boolean isFreeWifi) {
        this.isFreeWifi = isFreeWifi;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.typeName);
        hash = 71 * hash + Objects.hashCode(this.facilities);
        hash = 71 * hash + Objects.hashCode(this.specification);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.rentalFee) ^ (Double.doubleToLongBits(this.rentalFee) >>> 32));
        hash = 71 * hash + this.beds;
        hash = 71 * hash + (this.isFreeWifi ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RoomType other = (RoomType) obj;
        if (Double.doubleToLongBits(this.rentalFee) != Double.doubleToLongBits(other.rentalFee)) {
            return false;
        }
        if (this.beds != other.beds) {
            return false;
        }
        if (this.isFreeWifi != other.isFreeWifi) {
            return false;
        }
        if (!Objects.equals(this.typeName, other.typeName)) {
            return false;
        }
        if (!Objects.equals(this.facilities, other.facilities)) {
            return false;
        }
        return Objects.equals(this.specification, other.specification);
    }
    
    @Override
    public String toString() {
        return String.format("%s\n%s\n%s\n%.2f\n%d\n%s\n",
                typeName, getFacilitiesString(),
                specification, rentalFee,
                beds, getFreeWifiString());
    }

    
    
}
