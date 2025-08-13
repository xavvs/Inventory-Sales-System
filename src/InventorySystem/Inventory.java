package InventorySystem;
import java.util.Scanner;

import java.util.ArrayList;


public class Inventory {
    private static ArrayList<Main> item = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
        boolean running = true;
        
		while (running) {
		System.out.println("\n-----Inventory & Sales System-----\n");
		System.out.println("1. Add Item\n2. View Inventory\n3. Sell Item\n4. Exit");
		System.out.print("Select an option (1-4): ");
		int userChoice = scanner.nextInt();
		
		switch(userChoice) {
			case 1:
				addItem();
				break;
			case 2:
				viewInventory();
				break;
			case 3:
				sellItem();
				break;
			case 4:
                 running = false;
                 System.out.println("Exiting the system. Goodbye!");
                 break;
			default:
                System.out.println("Invalid option. Try again.");
		}
		
		
			
		}
		scanner.close();
	}
		static void addItem() {
			scanner.nextLine();
			System.out.print("\nItem name: ");
			String itemName = scanner.nextLine();
			System.out.print("Price: $");
			double itemPrice = scanner.nextDouble();
			System.out.print("Quantity: ");
			int itemCount = scanner.nextInt();
			scanner.nextLine();
			
	        item.add(new Main(itemName, itemPrice, itemCount));
	        
			System.out.println("Item stored successfuly!");
	            return;
	        }
		
	    public static void displayItems(){
	        System.out.printf("%-15s %-10s %-10s %-12s%n", "Item", "Price", "Quantity", "Total Price");
	        System.out.println("----------------------------------------");
	        for (Main i : item) {
	         	double totalItem = i.itemPrice * i.itemCount;
	            System.out.printf("%-15s %-10s %-10s %-12s%n", i.itemName, i.itemPrice, i.itemCount, totalItem);
	        }
	    }
	    


	    
	    
		static void viewInventory() {
        	if (item.isEmpty()) {
        		System.out.println("\nNo Items Stored.");
        		return;
        	}
        	
            System.out.println("\n--- Item List ---");
            for (Main Main : item) {
                displayItems();
                System.out.println("------------------------\n");
            }
        	
        }
		

		
		static void sellItem() {
			scanner.nextLine();
			System.out.print("\nEnter item to sell: ");
			String name = scanner.nextLine();
			boolean found = false;
			for(Main i : item) {
			if(i.itemName.equalsIgnoreCase(name)) {
				found = true;
				System.out.print("Enter quantity to sell: ");
				int qty = scanner.nextInt();
				
				if(qty <= 0) {
					System.out.println("Invalid Quantity!");
					return;
				}
				
				if(qty > i.itemCount) {
					System.out.println("Not enough stock! Available: " + i.itemCount);
				} else {
					i.itemCount -= qty;
					double totalPrice = qty * i.itemPrice;
					System.out.println("Sold " + qty + " " + i.itemName + " (s) for $" + totalPrice);
					System.out.println("Available stock: " + i.itemCount);
				}
				break;
			}
			
			 
		  }
			if (!found) {
		        System.out.println("\nItem not found in inventory.");
		    }
		}
	}


