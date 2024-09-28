/*Implementing a class called "Media" which is a child class of the Item class*/
public class Media extends Item {

    /*Initialising a private String variable called "Type"*/
    protected String type;
    /*Initializing a static integer called "globalId"*/
    protected static int globalId = 0;

    /*Implementing a default constructor for the Media class*/
    public Media(){
        super();
        super.id = "M" + globalId;
        this.type = "";
    }

    /**
     * Implementing a parametrized constructor for a journal.
     *
     * @param name              the name of a media
     * @param authorName        the name of the author of a media
     * @param publicationYear   the publication year of a media
     * @param type              the type of media
     * */
    public Media(String name, String authorName, long publicationYear, String type){
        super(name, authorName, publicationYear);
        super.id = "M" + globalId++;
        this.type = type;
    }

    /**
     * Implementing a copied constructor for the media
     *
     * @param copy              the object media
     * */
    public Media(Media copy){
        super(copy.name, copy.authorName, copy.publicationYear);
        this.type = copy.type;
    }

    /*Implementing an accessor method for the attribute*/
    public String getType(){
        return this.type;
    }

    /*Implementing a mutator method for the attribute*/
    public void setType(String type){
        this.type = type;
    }

    /**
     * Overriding the equals() method to compare this object with another object
     *
     * @param otherObject       the object that will be compared
     * @return                  true if two objects are equal and false otherwise
     * */
    @Override
    public boolean equals(Object otherObject){
        if(otherObject == null){
            return false;
        }
        if(this.getClass() != otherObject.getClass()){
            return false;
        }
        Media otherMedia = (Media) otherObject;
        return (this.type.equals(otherMedia.type));
    }

    /**
     * Overriding toString method to display the information of the media*
     *
     * @return                  the information of a media
     * */
    @Override
    public String toString(){
        return super.toString() +
                "Category: Media" + "\n" +
                "Type: " + this.type + "\n";
    }
} /*End of Media class*/
