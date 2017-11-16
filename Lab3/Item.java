package Lab3;

public class Item implements Comparable<Item> {

    private String title, producer, country;
    private int year;
    private double price;

    //Empty and default constructor
    private Item() {
        title = "Title";
        producer = "Producer";
        country = "Country";
        year = 2010;
        price = 10;
    }

    //Complete constructor
    protected Item(String title, String producer, String country, int year, double price) {
        this.title = title;
        this.producer = producer;
        this.country = country;
        this.year = year;
        this.price = price;
    }

    //Getters
    public String getTitle(){
        return title;
    }

    public String getProducer() {
        return producer;
    }

    public String getCountry() {
        return country;
    }

    public int getYear(){
        return year;
    }

    public double getPrice() {
        return price;
    }


    //Setters
    public void setTitle(String title) {
        this.title = title;
    }

    //Printing all the information of the item and increasing the price
    private void printInformationAndIncreasePrice(double percentage) {
        price += price * percentage;
        System.out.println("Item title: " + title);
        System.out.println("Item producer: " + producer);
        System.out.println("Item country of origin: " + country);
        System.out.println("Item production year: " + year);
        System.out.println("Item new price: " + price+'€');
    }

    //Item's price in Litas
    private double getPriceInLitas() {
        double litas = price * 3.4528;
        System.out.println("Price of " + title + " in litas: " + litas);
        return litas;
    }


    @Override
    public int compareTo(Item o) {
        int compareTitles = title.compareTo(o.title);
        if (compareTitles==0) {
            int compareProducers = producer.compareTo(o.producer);
            if (compareProducers==0)
                return country.compareTo(o.country);
            return compareProducers;
        }
        return compareTitles;
    }

    @Override
    public String toString(){
        return title + "\n\t Producer: " + producer + ". Country: " + country + ". Year: " + year + ". Price: " + price+"\n";
    }
}
