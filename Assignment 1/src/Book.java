

/*Implementing a class called "Book" which is a child class of the Item class*/
public class Book extends Item {

    /*Declaring a private long variable called "numPage"*/
    protected long numPage;
    /*Initializing a static integer called "globalId"*/
    protected static int globalId = 0;


    /*Implementing a default constructor for the Book class*/
    public Book(){
        super();
        super.id = "B" + globalId;
        this.numPage = 0;
    }

    /**
     * Implementing a parametrized constructor for a book.
     *
     * @param name              the name of a book
     * @param authorName        the name of the author of a book
     * @param publicationYear   the publication year of a book
     * @param numPage           the number of page of a book
     * */
    public Book(String name, String authorName, long publicationYear, long numPage){
        super(name, authorName, publicationYear);
        super.id = "B" + globalId++;
        this.numPage = numPage;
    }

    /**
     * Implementing a copied constructor for the book
     *
     * @param copy              the object book
     * */
    public Book(Book copy){
        super(copy.name, copy.authorName, copy.publicationYear);
        this.numPage = copy.numPage;
    }

    /*Implementing an accessor method for the attribute*/
    public long getNumPage(){
        return this.numPage;
    }

    /*Implementing a mutator method for the attribute*/
    public void setNumPage(long numPage){
        this.numPage = numPage;
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
        Book otherBook = (Book) otherObject;
        return (this.numPage == otherBook.numPage);
    }

    /**
     * Overriding toString method to display the information of the book*
     *
     * @return                  the information of a book
     * */
    @Override
    public String toString(){
        return super.toString() +
                "Category: Book" + "\n" +
                "Number of pages: " + this.numPage +"\n";
    }
} /*End of Book class*/
