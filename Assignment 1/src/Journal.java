/*Implementing a class called "Journal" which is a child class of the Item class*/
public class Journal extends Item {

    /*Initialising a private String called "volumeNum"*/
    protected String volumeNum;
    /*Initializing a static integer called "globalId"*/
    protected static int globalId = 0;

    /*Implementing a default constructor for the Journal class*/
    public Journal(){
        super();
        super.id = "J" + globalId;
        this.volumeNum = "";
    }

    /**
     * Implementing a parametrized constructor for a journal.
     *
     * @param name              the name of a journal
     * @param authorName        the name of the author of a journal
     * @param publicationYear   the publication year of a journal
     * @param volumeNum         the volume number of a journal
     * */
    public Journal(String name, String authorName, long publicationYear, String volumeNum){
        super(name, authorName, publicationYear);
        super.id = "J" + globalId++;
        this.volumeNum = volumeNum;
    }

    /**
     * Implementing a copied constructor for the journal
     *
     * @param copy              the object journal
     * */
    public Journal(Journal copy){
        super(copy.name, copy.authorName, copy.publicationYear);
        this.volumeNum = copy.volumeNum;
    }

    /*Implementing an accessor method for the attribute*/
    public String getVolumeNum(){
        return this.volumeNum;
    }

    /*Implementing a mutator method for the attribute*/
    public void setVolumeNum(String volumeNum){
        this.volumeNum = volumeNum;
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
        Journal otherJournal = (Journal) otherObject;
        return (this.volumeNum.equals(otherJournal.volumeNum));
    }

    /**
     * Overriding toString method to display the information of the journal*
     *
     * @return                  the information of a journal
     * */
    @Override
    public String toString(){
        return super.toString() +
                "Category: Journal" + "\n" +
                "Volume number: " + this.volumeNum + "\n";
    }
} /*End of Journal class*/
