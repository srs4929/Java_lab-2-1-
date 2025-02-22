// MLModel.java (Abstract base class for all ML models)
abstract class MLModel {
    String modelName;

    public MLModel(String modelName) {
        this.modelName = modelName;
    }

    abstract void process(Prompt prompt);
}

// RLUModel.java
class RLUModel extends MLModel {
    public RLUModel() {
        super("RLUModel");
    }

    void process(Prompt prompt) {
        System.out.println("Processing with RLUModel: " + prompt.content);
    }
}

// LSTMModel.java
class LSTMModel extends MLModel {
    public LSTMModel() {
        super("LSTMModel");
    }

    void process(Prompt prompt) {
        System.out.println("Processing with LSTMModel: " + prompt.content);
    }
}

// TransformerModel.java
class TransformerModel extends MLModel {
    public TransformerModel() {
        super("TransformerModel");
    }

    void process(Prompt prompt) {
        System.out.println("Processing with TransformerModel: " + prompt.content);
    }
}

// Prompt.java (Abstract class for all prompt types)
abstract class Prompt {
    String content;

    public Prompt(String content) {
        this.content = content;
    }

    abstract void displayCategory();
}

// EducationalPrompt.java
class EducationalPrompt extends Prompt {
    String subCategory; // (Technical, General, Basic)

    public EducationalPrompt(String content, String subCategory) {
        super(content);
        this.subCategory = subCategory;
    }

    void displayCategory() {
        System.out.println("Educational Prompt - " + subCategory);
    }
}

// EntertainmentPrompt.java
class EntertainmentPrompt extends Prompt {
    String subCategory; // (Movie-Series, Book)

    public EntertainmentPrompt(String content, String subCategory) {
        super(content);
        this.subCategory = subCategory;
    }

    void displayCategory() {
        System.out.println("Entertainment Prompt - " + subCategory);
    }
}

// MiscellaneousPrompt.java
class MiscellaneousPrompt extends Prompt {
    public MiscellaneousPrompt(String content) {
        super(content);
    }

    void displayCategory() {
        System.out.println("Miscellaneous Prompt - Random Article");
    }
}

// Subscription.java (Handles user subscription types)
class Subscription {
    String level; // (Basic, Medium, Pro)

    public Subscription(String level) {
        this.level = level;
    }

    MLModel getBestAvailableModel() {
        if (level.equals("Pro")) {
            return new TransformerModel();
        } else if (level.equals("Medium")) {
            return new LSTMModel();
        } else {
            return new RLUModel();
        }
    }
}

// User.java (Manages user details and subscription)
class User {
    String name;
    Subscription subscription;

    public User(String name, Subscription subscription) {
        this.name = name;
        this.subscription = subscription;
    }

    Subscription getSubscription() {
        return subscription;
    }
}

// SimpleBot.java (Main chatbot system)
class SimpleBot {
    void processPrompt(Prompt prompt, User user) {
        MLModel model = user.getSubscription().getBestAvailableModel();
        if (model != null) {
            model.process(prompt);
        } else {
            System.out.println("No available model to process the prompt.");
        }
    }
}

// Main.java (Testing the system)
public class Main {
    public static void main(String[] args) {
        // Create Users
        User user1 = new User("Alice", new Subscription("Medium")); // LSTMModel
        User user2 = new User("Bob", new Subscription("Pro")); // TransformerModel
        User user3 = new User("Charlie", new Subscription("Basic")); // RLUModel

        // Create Prompts
        Prompt eduPrompt = new EducationalPrompt("Explain OOP concepts.", "Technical");
        Prompt entPrompt = new EntertainmentPrompt("Suggest best movies.", "Movie-Series");
        Prompt miscPrompt = new MiscellaneousPrompt("Give me a fun fact!");

        // SimpleBot instance
        SimpleBot bot = new SimpleBot();

        // Process prompts
        bot.processPrompt(eduPrompt, user1);
        bot.processPrompt(entPrompt, user2);
        bot.processPrompt(miscPrompt, user3);
    }
}

// taken from gpt


