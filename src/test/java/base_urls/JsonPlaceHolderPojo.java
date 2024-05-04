package base_urls;

public class JsonPlaceHolderPojo {
        private long id;
        private String name;
        private Category category;
        private Status status;

        // Constructors, getters, and setters
    }

    enum Category {
        DOG, CAT, BIRD
    }

    enum Status {
        AVAILABLE, PENDING, SOLD
    }


