public class Main {
    public static void main(String[] args) {
       Car lada = new Car("Lada", "Granta", -1.7, " ", -2015, "Россия",
               "hatchback", false, null, "h585ло185", -6,
               new Car.Key(true, true));
       Car.Key key = new Car.Key(true,true);
       System.out.println(lada);

    }
}