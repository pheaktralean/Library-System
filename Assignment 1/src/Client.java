/*Implementing a class called "Client"*/
public class Client {

    /*Initializing a static long called "globalId"*/
    private static long globalId = 0;
    /*Declaring a private String variable called "clientID"*/
    private String clientID;
    /*Declaring a private String variable called "clientName"*/
    private String clientName;
    /*Declaring a private String variable called "phoneNum"*/
    private String phoneNum;
    /*Declaring a private String variable called "email"*/
    private String email;
    /*Declaring an array of books called "leasedBooks"*/
    protected Book[] leasedBooks;
    /*Declaring an array of journals called "leasedJournals"*/
    protected Journal[] leasedJournals;
    /*Declaring an array of media called "leasedMedia"*/
    protected Media[] leasedMedias;
    /*Declaring an integer called "numLeasedBook"*/
    private int numLeasedBook;
    /*Declaring an integer called "numLeasedJournal"*/
    private int numLeasedJournal;
    /*Declaring an integer called "numLeasedJournal"*/
    private int numLeasedMedia;
    /*Declaring an integer called "leasedSize"*/
    private final int leasedSize = 20;

    /*Implementing a default constructor for the Client class*/
    public Client(){

    }

    /**Implementing a parametrized constructor for the Client class
     *
     * @param clientName        the name of client
     * @param phoneNum          teh client's phone number
     * @param email             the client's email address*/
    public Client(String clientName, String phoneNum, String email){
        this.clientID = "" + globalId++;
        this.clientName = clientName;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    /**Implementing a copied constructor for the Book class
     *
     * @param copy              the name of Client*/
    public Client(Client copy){
        this.clientID = copy.clientID;
        this.clientName = copy.clientName;
        this.phoneNum = copy.phoneNum ;
        this.email = copy.email;
    }

    /*Implementing accessor methods for every attributes*/
    public String getClientID(){
        return this.clientID;
    }
    public String getClientName(){
        return this.clientName;
    }
    public String getPhoneNum(){
        return this.phoneNum;
    }
    public String getEmail(){
        return this.email;
    }
    public Book[] getLeasedBooks(){
        return this.leasedBooks;
    }
    public Journal[] getLeasedJournals(){
        return this.leasedJournals;
    }
    public Media[] getLeasedMedias(){
        return this.leasedMedias;
    }
    public int getNumLeasedBook(){
        return this.numLeasedBook;
    }
    public int getNumLeasedJournal(){
        return this.numLeasedJournal;
    }
    public int getNumLeasedMedia(){
        return this.numLeasedMedia;
    }

    /*Implementing mutator methods for attributes*/
    public void setClientID(String clientID){
        this.clientID = clientID;
    }
    public void setClientName(String clientName){
        this.clientName = clientName;
    }
    public void setPhoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }
    public void setEmail(String email){
        this.email = email;
    }

    /**Implementing a void method called "addLeasedBook"
     * Adding book into leasedBook array
     *
     * @param book          the book that has to be added into leasedBook*/
    public void addLeasedBook(Book book){
        /*Implementing this operation if leasedBook is null*/
        if(this.leasedBooks == null){
            /*Assigning leasedSize to leasedBook*/
            this.leasedBooks = new Book[this.leasedSize];
        }
        /*Implement this operation if the numLeasedBook is less than the length of leasedBook*/
        if(this.numLeasedBook < this.leasedBooks.length){
            this.leasedBooks[this.numLeasedBook++] = book;
        }
    }

    /**Implementing a void method called "addLeasedJournal"
     * Adding journal into leasedJournal array
     *
     * @param journal          the journal that has to be added into leasedJournal*/
    public void addLeasedJournal(Journal journal){
        /*Implementing this operation if leasedJournal is null*/
        if(this.leasedJournals == null){
            /*Assigning leasedSize to leasedJournal*/
            this.leasedJournals = new Journal[this.leasedSize];
        }
        /*Implement this operation if the numLeasedBook is less than the length of leasedBook*/
        if(this.numLeasedJournal< this.leasedJournals.length){
            this.leasedJournals[this.numLeasedJournal++] = journal;
        }
    }

    /**Implementing a void method called "addLeasedMedia"
     * Adding media into leasedMedia array
     *
     * @param media          the media that has to be added into leasedMedia*/
    public void addLeasedMedia(Media media){
        /*Implementing this operation if leasedMedia is null*/
        if(this.leasedMedias == null){
            this.leasedMedias = new Media[this.leasedSize];
        }
        /*Implement this operation if the numLeasedMedia is less than the length of leasedBook*/
        if(this.numLeasedMedia < this.leasedMedias.length){
            this.leasedMedias[this.numLeasedMedia++] = media;
        }
    }

    /**Implementing a method called "hasLeasedBook"
     * Checking if the book has been leased
     * Going through array of leasedBook and compare the ID
     *
     * @param book          the book that wanted to be found in leasedBook
     * @return              true if book is found in leasedBook and false otherwise*/
    public boolean hasLeasedBook(Book book){
        /*Iterating through array of leasedBook*/
        for(int a = 0; a < this.numLeasedBook; a++){
            if(this.leasedBooks[a].getId().equals(book.getId())){
                return true;
            }
        }
        return false;
    }

    /**Implementing a method called "hasLeasedJournal"
     * Checking if the journal has been leased
     * Going through array of leasedJournal and compare the ID
     *
     * @param journal       the journal that wanted to be found in leasedJournal
     * @return              true if journal is found in leasedJournal and false otherwise*/
    public boolean hasLeasedJournal(Journal journal){
        for(int a = 0; a < this.numLeasedJournal; a++){
            if(leasedJournals[a].getId().equals(journal.getId())){
                return true;
            }
        }
        return false;
    }

    /**Implementing a method called "hasLeasedMedia"
     * Checking if the media has been leased
     * Going through array of leasedMedia and compare the ID
     *
     * @param media       the media that wanted to be found in leasedMedia
     * @return              true if media is found in leasedMedia and false otherwise*/
    public boolean hasLeasedMedia(Media media){
        for(int a = 0; a < this.numLeasedMedia; a++){
            if(this.leasedMedias[a].getId().equals(media.getId())){
                return true;
            }
        }
        return true;
    }

    /**Implementing a method called "removeLeasedBook"
     * Iterating through array of leasedBook and remove the book by comparing the ID
     *
     * @param book          the book that will be removed
     * @return              true if book has been removed from leasedBook and false otherwise*/
    public boolean removeLeasedBook(Book book){
        for(int b =0; b < this.numLeasedBook; b++){
            if(this.leasedBooks[b].getId().equals(book.getId())){
                for(int c = b; c < this.numLeasedBook; c++){
                    this.leasedBooks[c] = this.leasedBooks[c+1];
                }
                this.leasedBooks[this.numLeasedBook - 1] = null;
                this.numLeasedBook--;
                return true;
            }
        }
        return false;
    }

    /**Implementing a method called "removeLeasedJournal"
     * Iterating through array of leasedJournal and remove the journal by comparing the ID
     *
     * @param journal       the journal that will be removed
     * @return              true if journal has been removed from leasedJournal and false otherwise*/
    public boolean removeLeasedJournal(Journal journal){
        for(int b =0; b < this.numLeasedJournal; b++){
            if(this.leasedJournals[b].getId().equals(journal.getId())){
                for(int c = b; c < this.numLeasedJournal; c++){
                    this.leasedJournals[c] = this.leasedJournals[c+1];
                }
                this.leasedJournals[this.numLeasedJournal - 1] = null;
                this.numLeasedJournal--;
                return true;
            }
        }
        return false;
    }

    /**Implementing a method called "removeLeasedMedia"
     * Iterating through array of leasedMedia and remove the media by comparing the ID
     *
     * @param media         the media that will be removed
     * @return              true if media has been removed from leasedMedia and false otherwise*/
    public boolean removeLeasedMedia(Media media){
        for(int b =0; b < this.numLeasedMedia; b++){
            if(this.leasedMedias[b].getId().equals(media.getId())){
                for(int c = b; c < this.numLeasedMedia; c++){
                    this.leasedMedias[c] = this.leasedMedias[c+1];
                }
                this.leasedMedias[this.numLeasedMedia - 1] = null;
                this.numLeasedMedia--;
                return true;
            }
        }
        return false;
    }

    /**Implementing an equals() method
     * Comparing the contents of this client to another client
     *
     * @param otherClient           the other client that will be compared to
     * @return                      true if the contents are the same and false otherwise*/
    public boolean equals(Client otherClient){
        return this.clientName.equals(otherClient.clientName) && this.phoneNum.equals(otherClient.phoneNum) && this.email.equals(otherClient.email);
    }

    /**Implementing a toString() method
     * Displaying all the information of a client
     *
     * @return              a String that contain all the information of a client*/
    @Override
    public String toString(){
        return "The client information in the system: " + "\n" +
                "ID: " + this.clientID + "\n" +
                "Name: " + this.clientName + "\n" +
                "Phone number: " + this.phoneNum + "\n" +
                "Email Address: " + this.email + "\n";
    }
}
