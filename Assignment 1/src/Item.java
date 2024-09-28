
/*Implementing a class called "Item" which is a parent class for Book, Journal, and Media classes*/
public class Item {

    /*Initializing a private long called "globalId" to 0*/
    protected static int globalId = 0;
    /*Declaring a protected long called "id"*/
    protected String id;
    /*Declaring a protected String called "name"*/
    protected String name;
    /*Declaring a protected String called "authorName"*/
    protected String authorName;
    /*Declaring a protected long called "publicationYear"*/
    protected long publicationYear;
    /*Declaring a protected boolean called " isLeased"*/
    protected boolean isLeased;
    /*Declaring a protected long called "clientID"*/
    protected String clientID;

    /*Implementing a default constructor for the Library class*/
    public Item(){
        this.id = "" + globalId;
        this.name = "";
        this.authorName = "";
        this.publicationYear = 0;
    }

    /**
     * Implementing a parametrized constructor for an item.
     *
     *
     * @param name              the name of an item
     * @param authorName        the name of the author of an item
     * @param publicationYear   the publication year of an item
     * */
    public Item(String name, String authorName, long publicationYear){
        this.id = "" + globalId++;
        this.name = name;
        this.authorName = authorName;
        this.publicationYear = publicationYear;
    }


    /**
     * Implementing a copied constructor for the Library class
     *
     * @param copy              the object item
     * */
    public Item(Item copy){
        this.id = copy.id;
        this.name = copy.name;
        this.authorName = copy.authorName;
        this.publicationYear = copy.publicationYear;
    }

    /*Implementing accessor methods for attributes*/
    protected String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getAuthorName(){
        return this.authorName;
    }
    public long getPublicationYear(){
        return this.publicationYear;
    }
    public boolean getIsLeased(){
        return this.isLeased;
    }
    public String getClientID(){
        return this.clientID;
    }

    /*Implementing mutator methods for every attributes*/
    public void setName(String name){
        this.name = name;
    }
    public void setAuthorName(String authorName){
        this.authorName = authorName;
    }
    public void setPublicationYear(long publicationYear){
        this.publicationYear = publicationYear;
    }
    public void setLeased(boolean isLeased){
        this.isLeased = isLeased;
    }
    public void setClientID(String clientID){
        this.clientID = clientID;
    }

    /**
     * Implementing an equals method to compare this object with another object
     *
     * @param otherObject       the object that will be compared
     * @return                  true if two objects are equal and false otherwise
     * */
    public boolean equals(Object otherObject){
        if(otherObject == null){
            return false;
        }
        if(this.getClass() != otherObject.getClass()){
            return false;
        }

        Item otherLibrary = (Item) otherObject;
        return (this.name.equals(otherLibrary.name)) && (this.authorName.equals(otherLibrary.authorName)) && (this.publicationYear == otherLibrary.publicationYear);
    }

    /**
     * Implementing a toString method to display the information of the item*
     *
     * @return                  the information of an item
     * */
    public String toString(){
        return "The item's information are listed below: " + "\n" +
                "ID: " + this.getId() + "\n" +
                "Name: " + this.name + "\n" +
                "Name of the author: " + this.authorName + "\n" +
                "Publication year: " + this.publicationYear + "\n";
    }
} /*End of Item class*/
