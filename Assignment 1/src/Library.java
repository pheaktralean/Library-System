/*Implementing a class called "Library"*/
public class Library {

    /*Declaring an array of Client called "clients"*/
    public Client[] clients;
    /*Initializing an integer for the maximum size of the array*/
    private final int maxSize = 100;
    /*Declaring an array of book called "books"*/
    public Book[] books;
    /*Declaring an array of book called "journals"*/
    public Journal[] journals;
    /*Declaring an array of book called "medias"*/
    public Media[] medias;
    /*Declaring an integer called "numBook"*/
    private int numBook;
    /*Declaring an integer called "numJournal"*/
    private int numJournal;
    /*Declaring an integer called "numMedia"*/
    private int numMedia;
    /*Declaring an integer called "numClient"*/
    private int numClient;

    /*Implementing a default constructor for the Library class*/
    public Library(){
        /*Assigning all the arrays with the length of maxSize*/
        books = new Book[maxSize];
        journals = new Journal[maxSize];
        medias = new Media[maxSize];
        clients = new Client[maxSize];
        this.numBook = 0;
        this.numJournal = 0;
        this.numMedia = 0;
        this.numClient = 0;
    }

    /*Implementing accessor methods for attributes*/
    public int getNumBook(){
        return this.numBook;
    }
    public int getNumJournal(){
        return this.numJournal;
    }
    public int getNumMedia(){
        return this.numMedia;
    }
    public int getNumClient(){
        return this.numClient;
    }
    public Book[] getBook(){
        return this.books;
    }
    public Journal[] getJournal(){
        return this.journals;
    }
    public Media[] getMedias(){
        return this.medias;
    }
    public Client[] getClients(){
        return this.clients;
    }

    /**
     * Implementing a void method called "addBook"
     * Adding a book into books
     * Displaying a message if books is already full
     *
     * @param book        the book that has to be added into books
     * */
    public void addBook(Book book){
        if(this.numBook < this.maxSize){
            this.books[this.numBook++] = book;
        }
        else{
            System.out.println("The library is full. There is no available space to add more books.");
        }
    }

    /**
     * Implementing a void method called "addJournal"
     * Adding a journal into journals
     * Displaying a message if journals is already full
     *
     * @param journal        the journal that has to be added into journals
     * */
    public void addJournal(Journal journal){
        if(this.numJournal < this.maxSize){
            this.journals[numJournal++] = journal;
        }
        else{
            System.out.println("The library is full. There is no available space to add more journals.");
        }
    }

    /**
     * Implementing a void method called "addMedia"
     * Adding a media into medias
     * Displaying a message if medias is already full
     *
     * @param media        the media that has to be added into medias
     * */
    public void addMedia(Media media){
        if(this.numMedia < this.maxSize){
            this.medias[numMedia++] = media;
        }
        else{
            System.out.println("The library is full. There is no available space to add more media.");
        }
    }

    /**
     * Implementing a void method called "addClient"
     * Adding a client into clients
     * Displaying a message if clients is already full
     *
     * @param client        the client that has to be added into clients
     * */
    public void addClient(Client client){
        if(this.numClient < this.maxSize) {
            this.clients[numClient++] = client;
        }
        else{
            System.out.println("The library is full. There is no available space to add more client");
        }
    }

    /**
     * Implementing a method called "findBook"
     * Iterating through books to find a book by BookID
     *
     * @param bookID        the string ID of a book that want to be found
     * @return              a book if its ID match with bookID
     *                      null if nothing is found
     **/
    public Book findBook(String bookID){
        for(int a = 0; a < this.numBook; a++){
            if(this.books[a].getId().equals(bookID)){
                return this.books[a];
            }
        }
        return null;
    }

    /**
     * Implementing a method called "findJournal"
     * Iterating through journals to find a journal by journalID
     *
     * @param journalID     the string ID of a journal that want to be found
     * @return              a journal if its ID match with journalID
     *                      null if nothing is found
     **/
    public Journal findJournal(String journalID){
        for(int a = 0; a < numJournal; a++){
            if(journals[a].getId().equals(journalID)){
                return journals[a];
            }
        }
        return null;
    }

    /**
     * Implementing a method called "findMedia"
     * Iterating through medias to find a media by mediaID
     *
     * @param mediaID       the string ID of a media that want to be found
     * @return              a media if its ID match with mediaID
     *                      null if nothing is found
     **/
    public Media findMedia(String mediaID){
        for(int a = 0; a < numMedia; a++) {
            if(medias[a].getId().equals(mediaID)){
                return medias[a];
            }
        }
        return null;
    }

    /**
     * Implementing a method called "findClient"
     * Iterating through clients to find a client by clientID
     *
     * @param clientID       the string ID of a client that want to be found
     * @return               a client if its ID match with clientID
     *                       null if nothing is found
     **/
    public Client findClient(String clientID){
        for(int c = 0; c < numClient; c++) {
            if (clients[c].getClientID().equals(clientID)) {
                return clients[c];
            }
        }
        return null;
    }

    /**
     * Implementing a method called "removeBook"
     * Removing a book by matching its ID with book's ID in books
     *
     * @param bookID        the string ID of the book that want to be removed
     * @return              false if there is no book in books
     *                      true if a book is removed and false otherwise
     **/
    public boolean removeBook(String bookID){
        if(this.numBook == 0){
            return false;
        }
        for(int a = 0; a < numBook; a++){
            if(books[a].getId().equals(bookID)){
                for(int b = a; b < numBook - 1; b++){
                    books[b] = books[b+1];
                }
                books[numBook -1] = null;
                numBook--;
                return true;
            }
        }
        return false;
    }

    /**
     * Implementing a method called "removeJournal"
     * Removing a journal by matching its ID with journal's ID in journals
     *
     * @param journalID     the string ID of the journal that want to be removed
     * @return              false if there is no journal in books
     *                      true if a journal is removed and false otherwise
     **/
    public boolean removeJournal(String journalID){
        if(this.numJournal == 0){
            return false;
        }
        for(int a = 0; a < numJournal; a++){
            if(journals[a].getId().equals(journalID)){
                for(int b = a; b < numJournal - 1; b++){
                    journals[b] = journals[b+1];
                }
                journals[numJournal -1] = null;
                numJournal--;
                return true;
            }
        }
        return false;
    }

    /**
     * Implementing a method called "removeMedia"
     * Removing a media by matching its ID with media's ID in medias
     *
     * @param mediaID       the string ID of the media that want to be removed
     * @return              false if there is no media in medias
     *                      true if a media is removed and false otherwise
     **/
    public boolean removeMedia(String mediaID){
        if(this.numMedia == 0){
            return false;
        }
        for(int a = 0; a < numMedia; a++){
            if(medias[a].getId().equals(mediaID)){
                for(int b = a; b < numMedia - 1; b++){
                    medias[b] = medias[b+1];
                }
                medias[numMedia -1] = null;
                numMedia--;
                return true;
            }
        }
        return false;
    }

    /**
     * Implementing a method called "removeClient"
     * Removing a client by matching its ID with client's ID in clients
     *
     * @param clientID      the string ID of the client that want to be removed
     * @return              false if there is no client in clients
     *                      true if a client is removed and false otherwise
     **/
    public boolean removeClient(String clientID){
        if(this.numClient == 0){
            return false;
        }
        for(int c = 0; c < numClient; c++){
            if(clients[c].getClientID().equals(clientID)){
                for(int d = c; d < numClient - 1; d++){
                    clients[d] = clients[d+1];
                }
                clients[numClient -1] = null;
                numClient--;
                return true;
            }
        }
        return false;
    }

    /**
     * Implementing a method called "bookContents()"
     *
     * return        String content of book in books
     **/
    public String bookContents(){
        String bookContents = "";
        if(this.numBook == 0) {
            bookContents += "There is no book in the system.";
        }
        else{
            for (int e = 0; e < numBook; e++) {
                bookContents += books[e].toString();
            }
        }
        return bookContents;
    }

    /**
     * Implementing a method called "journalContents()"
     * Displaying the contents of journals
     *
     * return        String content of journal in journals
     **/
    public String journalContents(){
        String journalContents = "";
        if(this.numJournal == 0){
            journalContents += "There is no journal in the system.";
        }
        else{
            for (int e = 0; e < numJournal; e++){
                journalContents += journals[e].toString();
            }
        }
        return journalContents;
    }

    /**
     * Implementing a method called "mediaContents()"
     *
     * return        String content of media in medias
     **/
    public String mediaContents(){
        String mediaContents = "";
        if(this.numMedia == 0){
            mediaContents = "There is no media in the system.";
        }
        else{
            for (int e = 0; e < numMedia; e++){
                mediaContents += medias[e].toString();
            }
        }
        return mediaContents;
    }

    /**
     * Implementing a method called "leaseBookToClient"
     * Leasing book to client by using their IDs
     *
     * @param bookID        the String ID of the book that will be leased
     * @param clientID      the String ID of the client that the book will be leased to
     *
     * @return              true if the book has been leased to client and false if not
     * */
    public boolean leaseBookToClient(String bookID, String clientID){
        Book book = findBook(bookID);
        if(book != null && !book.isLeased){
            Client client = findClient(clientID);
            if(client != null){
                book.setLeased(true);
                book.setClientID(clientID);
                client.addLeasedBook(book);
                return true;
            }
        }
        return false;
    }

    /**
     * Implementing a method called "leaseJournalToClient"
     * Leasing journal to client by using their IDs
     *
     * @param journalID         the String ID of the journal that will be leased
     * @param clientID          the String ID of the client that the journal will be leased to
     *
     * @return                  true if the journal has been leased to client and false if not
     * */
    public boolean leaseJournalToClient(String journalID, String clientID){
        Journal journal = findJournal(journalID);
        if(journal != null && !journal.isLeased){
            Client client = findClient(clientID);
            if(client != null){
                journal.setLeased(true);
                journal.setClientID(clientID);
                client.addLeasedJournal(journal);
                return true;
            }
        }
        return false;
    }

    /**
     * Implementing a method called "leaseMediaToClient"
     * Leasing media to client by using their IDs
     *
     * @param mediaID         the String ID of the media that will be leased
     * @param clientID          the String ID of the client that the media will be leased to
     *
     * @return                  true if the media has been leased to client and false if not
     * */
    public boolean leaseMediaToClient(String mediaID, String clientID){
        Media media = findMedia(mediaID);
        if(media != null && !media.isLeased){
            Client client = findClient(clientID);
            if(client != null){
                media.setLeased(true);
                media.setClientID(clientID);
                client.addLeasedMedia(media);
                return true;
            }
        }
        return false;
    }

     /**
     * Implementing a method called "returnBookFromClient"
     * Finding client by id and leased book by id, then disconnecting them
     *
     * @param bookID        the id of the book that will be returned
     * @param clientID      the id of the client that will return the book
     *
      * @return              true if client return book successfully and false otherwise
     * */
    public boolean returnBookFromClient(String clientID, String bookID){
        Client client = findClient(clientID);
        Book book = findBook(bookID);

        if(client != null && book != null) {
            boolean lease = client.hasLeasedBook(book);
            if (!lease){
                System.out.println("Client with ID: " + clientID + " has not leased the book with ID: " + bookID);
                return false;
            }
            book.setLeased(false);
            client.removeLeasedBook(book);
        }
        return true;
    }

     /**
     * Implementing a method called "returnJournalFromClient"
     * Finding client by id and leased journal by id, then disconnecting them
     *
     * @param journalID     the id of the journal that will be returned
     * @param clientID      the id of the client that will return the journal
     *
      * @return              true if client return journal successfully and false otherwise
     * */
    public boolean returnJournalFromClient(String clientID, String journalID){
        Client client = findClient(clientID);
        Journal journal = findJournal(journalID);

        if(client != null && journal != null) {
            boolean lease = client.hasLeasedJournal(journal);
            if (!lease){
                System.out.println("Client with ID: " + clientID + " has not leased the journal with ID: " + journalID);
                return false;
            }
            journal.setLeased(false);
            client.removeLeasedJournal(journal);
        }
        return true;
    }

    /**
     * Implementing a method called "returnMediaFromClient"
     * Finding client by id and leased media by id, then disconnecting them
     *
     * @param mediaID       the id of the media that will be returned
     * @param clientID      the id of the client that will return the media
     *
     * @return              true if client return media successfully and false otherwise
     * */
    public boolean returnMediaFromClient(String clientID, String mediaID){
        Client client = findClient(clientID);
        Media media = findMedia(mediaID);

        if(client != null && media != null) {
            boolean lease = client.hasLeasedMedia(media);
            if (!lease){
                System.out.println("Client with ID: " + clientID + " has not leased the media with ID: " + mediaID);
                return false;
            }
            media.setLeased(false);
            client.removeLeasedMedia(media);
        }
        return true;
    }
}
