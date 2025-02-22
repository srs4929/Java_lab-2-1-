/*
A mobile application is being developed that deals with plant identification problem. To represent a plant 
the system requires five pieces of information. Description of roots(2 types : Upper root, Lower root),
Description of bodies(2 type ,think and thin), Description of plants(Green,red, yellow) , name(string data type)
and an image. The system demands a mechanism to enter plant information
into the database.Inserting an image representing a plant is optional.There should be
two types of search features. Name based searching and image processing based searching.
For printing each search there should be a method
*/
import java.util.Scanner;

// Abstract Root class
abstract class Root {
    String rootType;

    Root(String rootType) {
        this.rootType = rootType;
    }

    abstract void details();
}

// UpperRoot subclass
class UpperRoot extends Root {
    UpperRoot() {
        super("Upper Root");
    }

    public void details() {
        System.out.println("Grows above the ground and the type is " + rootType);
    }
}

// LowerRoot subclass
class LowerRoot extends Root {
    LowerRoot() {
        super("Lower Root");
    }

    public void details() {
        System.out.println("Grows underground and the type is " + rootType);
    }
}

// Abstract Body class
abstract class Body {
    String bodyType;

    Body(String bodyType) {
        this.bodyType = bodyType;
    }

    abstract void details();
}

// Thick Body subclass
class Thick extends Body {
    Thick() {
        super("Thick");
    }

    public void details() {
        System.out.println("This plant has a thick body.");
    }
}

// Thin Body subclass
class Thin extends Body {
    Thin() {
        super("Thin");
    }

    public void details() {
        System.out.println("This plant has a thin body.");
    }
}

// Plant class
class Plant {
    String name;
    Root root;
    Body body;
    String color;
    String image; // Image is optional (store as a file path or URL)

    // Constructor
    Plant(String name, Root root, Body body, String color, String image) {
        this.name = name;
        this.root = root;
        this.body = body;
        this.color = color;
        this.image = image;
    }

    // Display plant details
    public void displayPlant() {
        System.out.println("\nPlant Name: " + name);
        root.details();
        body.details();
        System.out.println("Plant Color: " + color);
        System.out.println("Image: " + (image.isEmpty() ? "No Image Available" : image));
    }
}

// Plant Database using Normal Array
class PlantDatabase {
    Plant[] plantRecords;
    int count;

    // Constructor to initialize array
    PlantDatabase(int size) {
        plantRecords = new Plant[size];
        count = 0;
    }

    // Add plant to database
    public void addPlant(Plant plant) {
        if (count < plantRecords.length) {
            plantRecords[count++] = plant;
            System.out.println("Plant " + plant.name + " added successfully!");
        } else {
            System.out.println("Database is full! Cannot add more plants.");
        }
    }

    // Name-based search
    public void searchByName(String name) {
        for (int i = 0; i < count; i++) {
            if (plantRecords[i].name.equalsIgnoreCase(name)) {
                System.out.println("\nPlant Found!");
                plantRecords[i].displayPlant();
                return;
            }
        }
        System.out.println("\nNo plant found with name: " + name);
    }

    // Image-based search (simulated)
    public void searchByImage(String imagePath) {
        System.out.println("\nSearching for plants by image...");
        // Placeholder logic (would use AI/image processing in real apps)
        System.out.println("Feature under development: Image-based search.");
    }
}

// Main class
public class D{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating plant database with size 10
        PlantDatabase database = new PlantDatabase(10);

        // Creating sample plants
        Plant plant1 = new Plant("Mango Tree", new LowerRoot(), new Thick(), "Green", "mango.jpg");
        Plant plant2 = new Plant("Rose", new UpperRoot(), new Thin(), "Red", "");

        // Adding plants to the database
        database.addPlant(plant1);
        database.addPlant(plant2);

        // User Interaction
        while (true) {
            System.out.println("\n----- PLANT IDENTIFICATION SYSTEM -----");
            System.out.println("1. Search by Name");
            System.out.println("2. Search by Image (Simulated)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Plant Name: ");
                    String name = scanner.nextLine();
                    database.searchByName(name);
                    break;
                case 2:
                    System.out.print("Enter Image Path: ");
                    String imagePath = scanner.nextLine();
                    database.searchByImage(imagePath);
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
