import java.security.Key;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class Car {
    private final String brand;
    private final String model;
    private final double engineVolume;
    private final String color;
    private final Integer year;
    private final String country;

    private final String bodyType;
    private boolean isSummerRubber;
    private String transmission;
    private String number;
    private final int seatCount;
    private double enginePower;

    private Key key;

    public Car (String brand, String model, double engineVolume, String color, Integer year, String country,
                String bodyType, boolean isSummerRubber, String transmission, String number, int seatCount,
                Key key) {
        this.brand = validateCarParameters(brand);
        this.model = validateCarParameters(model);
        this.engineVolume = validateEngineVolume(engineVolume);
        this.color = validateCarColor(color);
        this.year = validateYear(year);
        this.country = validateCarParameters(country);
        this.bodyType = validateCarParameters(bodyType);
        this.isSummerRubber = isSummerRubber;
        this.transmission = validateTransmission(transmission);
        this.number = validateCarNumber(number);
        this.seatCount = validateSeatCount(seatCount);
        this.key = key;
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getEngineVolume() { return engineVolume; }
    public String getColor() { return color; }
    public Integer getYear() { return year;  }
    public String getCountry() { return country; }
    public String getBodyType() { return bodyType; }
    public boolean isSummerRubber() { return isSummerRubber; }
    public void setSummerRubber(boolean summerRubber) { isSummerRubber = summerRubber; }
    public String getTransmission() { return transmission; }
    public void setTransmission(String transmission) { this.transmission = transmission; }
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }
    public int getSeatCount() { return seatCount; }
    public double getEnginePower() { return enginePower; }
    public void setEnginePower(double enginePower) { this.enginePower = enginePower; }
    public Key getKey() { return key; }
    public void setKey(Key key) { this.key = key; }



    public void changeTyres(int month){
        if ((month >= 11 && month <= 12) || (month >= 1 && month <= 3)){
            isSummerRubber = false;
        }
        if (month >= 4 && month <= 10){
            isSummerRubber = true;
        }
    }
    public String validateCarNumber(String number) {
        if (Pattern.matches("[а-я][0-9]{3}[а-я]{2}[0-9]{3}", number)){
            return number;
        }else {
            System.out.println("Номер не корректен");
            return "неверный номер";
        }
    }
    public int validateSeatCount(int seatCount){ return seatCount <= 0 ? 4 : seatCount; }
    public static String validateTransmission (String value){ return validateString(value, "автомат");}
    public static double validateEngineVolume(double value) {return  value < 0 ? 1.5 : value;}
    public static Integer validateYear(Integer value){ return  value <= 0 ? 2000 : value;}
    public static String validateCarParameters(String value) { return validateString(value, "default");}
    public static String validateCarColor(String value){ return  validateString(value, "белый");}


    public static class Key {
        private final Boolean remoteStart;
        private final Boolean keylessAccess;

        public Key(Boolean remoteStart, Boolean keylessAccess){
            this.remoteStart = validateBoolean(remoteStart);
            this.keylessAccess = validateBoolean(keylessAccess);
        }

        @Override
        public String toString() {
            return "Key{ " + " remoteStart " + remoteStart + " keylessAccess " + keylessAccess + "}";
        }
    }




    @Override
    public String toString() {
        return "Car{" + "brand = " + brand + ", model = " + model +
                ", engineVolume = " + engineVolume + ", color = " + color +
                ", year = " + year + ", country = " + country + ", bodyType = " + bodyType +
                ", isSummerRubber = " + isSummerRubber + ", transmission = " + transmission +
                ", number = " + number + ", seatCount = " + seatCount + ", key = " + key+ "}";

    }



    public static String validateString(String value, String defaultValue) {
        return (value == null || value.isBlank() || value.isEmpty()) ? defaultValue : value;
    }
    public static Integer validateNum(Integer value) {return value == null || value < 0 ? 0 : value;}

    public static Boolean validateBoolean(Boolean value){
        return  value != null && value;
    }
}
