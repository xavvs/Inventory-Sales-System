package InventorySystem;

public class Main {
    public String itemName;
    public double itemPrice;
    public int itemCount;

    public Main(String itemName, double itemPrice, int itemCount){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCount = itemCount;
    }

    public String getItem(){
        return itemName;
    }

    public double getPrice(){
        return itemPrice;
    }

    public int getCount(){
        return itemCount;
    }



    public void displayDetails(){
        System.out.println("Item: " + itemName);
        System.out.println("Price: $" + itemPrice);
        System.out.println("Quantity: " + itemCount);
    }
    

    

}
