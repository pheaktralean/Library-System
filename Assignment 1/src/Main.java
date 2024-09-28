
/*Importing a scanner package*/
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        /*Initializing a string called "welcomeMsg" to store a welcome message and displaying it*/
        String welcomeMsg = """
                ------------------------------------------------------------------
                                    Welcome to FunReadings Library
                ------------------------------------------------------------------
                """;
        System.out.print(welcomeMsg);

        System.out.print("Please enter 1 to go to the build-in system or 2 to go to the menu system: ");
        int option = scanner.nextInt();

        /*Implementing this operation if user enters 1*/
        if(option == 1) {
            hardCoded();
        }

        /*Implementing this method if user enters 2*/
        else if (option == 2) {
            boolean isRunning = true;
            do {
                System.out.println(mainMenu());
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> addingItem(scanner, library);
                    case 2 -> removingItem(scanner, library);
                    case 3 -> editingItem(scanner, library);
                    case 4 -> listingItem(scanner, library);
                    case 5 -> listingAllItems(library);
                    case 6 -> addingClient(scanner, library);
                    case 7 -> editingClient(scanner, library);
                    case 8 -> removingClient(scanner, library);
                    case 9 -> leasingItem(scanner, library);
                    case 10 -> returningItem(scanner, library);
                    case 11 -> displayingLeasedItem(scanner, library);
                    case 12 -> displayingAllLeasedItem(library);
                    case 13 -> gettingBiggestBook(library);
                    case 14 -> copyingBook(library);
                    case 15 -> {
                        System.out.println("You have successfully quit the system");
                        isRunning = false;
                    }
                    default -> System.out.println("Invalid Number. Try Again.");
                }
            } while (isRunning);
        }
    }

    /**Implementing a static method called "mainMenu()"
     *
     * @return           String that contains the main menu of the system
     * */
    public static String mainMenu() {
        return """
                ------------------------------------------------------------------------
                What would you like to do?
                    (1). Add an item
                    (2). Delete an item
                    (3). Change information of an item
                    (4). List all items in a specific category(book, journal, or media)
                    (5). Display all items(from all categories)
                    (6). Add a client
                    (7). Edit a client
                    (8). Delete a client
                    (9). Lease an item to a client
                    (10). Return an item from a client
                    (11). Display all items leased by a specific client
                    (12). Display all leased items(by all clients)
                    (13). Display the biggest book
                    (14). Make a copy of the books array
                    (15). To quit the system
                ------------------------------------------------------------------------
                Please enter your choice and press <Enter>:""";
    }

    /**Implementing a static method called "chooseCategory()
     *
     * @return      String that stores the category of the items*/
    public static String choosingCategory(){
        return """
                --------------------------------------------------------
                Which category do you want to perform the operation to?
                    (1). Book
                    (2). Journal
                    (3). Media
                ---------------------------------------------------------
                Please enter your choice and press <Enter>:""";
    }

    /**Implementing a static method called "bookCategory()
     *
     * @return      String that stores the category of the books*/
    public static String bookCategory(){
        return """
                --------------------------------------------------------
                What information of the book do you want to change?
                    (1). Name
                    (2). Author's Name
                    (3). Year of Publication
                    (4). Number of pages
                ---------------------------------------------------------
                Please enter your choice and press <Enter>:""";
    }

    /**Implementing a static method called "journalCategory()"
     *
     * @return      String that stores the category of the journal*/
    public static String journalCategory(){
        return """
                --------------------------------------------------------
                What information of the journal do you want to change?
                    (1). Name
                    (2). Author's Name
                    (3). Year of Publication
                    (4). Volume Number
                ---------------------------------------------------------
                Please enter your choice and press <Enter>:""";
    }

    /**Implementing a static method called "mediaCategory()"
     *
     * @return      String that stores the category of the media*/
    public static String mediaCategory(){
        return """
                --------------------------------------------------------
                What information of the media do you want to change?
                    (1). Name
                    (2). Author's Name
                    (3). Year of Publication
                    (4). Type
                ---------------------------------------------------------
                Please enter your choice and press <Enter>:""";
    }

    /**Implementing a static method called "clientCategory()"
     *
     * @return      String that stores the category of the client*/
    public static String clientCategory(){
        return """
                --------------------------------------------------------
                What would you like to change of a client?
                    (1). Name
                    (2). Phone number
                    (3). Email Address
                    (4). To quit the system
                --------------------------------------------------------
                Please enter your choice and press <Enter>:
                """;
    }


    /**Implementing a static method called "addingItem()"
     * Prompting the user for information
     * Adding new item into the system
     * Calling method addBook() if they want to add a book, addJournal() if they want to add a journal, addMedia() if they want to add a media
     *
     * @param scanner           scanner to store and read the user's input
     * @param library           library where the items will add to*/
    public static void addingItem(Scanner scanner, Library library){

        /*Displaying choosingCategory()*/
        System.out.println(choosingCategory());
        /*Initializing an integer scanner called "choice" to store and read the user's input*/
        int choice = scanner.nextInt();
        /*Consuming newline characters*/
        scanner.nextLine();

        /*Implementing this operation if user enter anything between 1 and 3*/
        if (choice >= 1 && choice <= 3) {
            /*Prompting the user to enter the information of the new item such as name, author's name, and year of publication*/
            System.out.println("Please enter the information of the new item.");
            System.out.print("Name: ");
            String itemName = scanner.nextLine();
            System.out.print("Author(s) name: ");
            String itemAuthor = scanner.nextLine();
            System.out.print("Year of publication: ");
            long itemYear = scanner.nextLong();
            scanner.nextLine();

            /*Implementing this operation if choice is 1(Book)*/
            if(choice == 1){
                /*Prompting the user enter the number of page*/
                System.out.print("Number of pages: ");
                /*Initializing a long scanner called "bookPage" to store and read user's input*/
                long bookPage = scanner.nextLong();
                scanner.nextLine();
                /*Creating a new book called "newBook" with the information prompted above*/
                Book newBook = new Book(itemName, itemAuthor, itemYear, bookPage);
                /*Adding the newBook into the library*/
                library.addBook(newBook);
                /*Displaying a confirmation message to the user*/
                System.out.println("You have successfully added a book into the system.");
            }

            /*Implementing this operation if choice is 2(Journal)*/
            else if(choice == 2){
                /*Prompting the user enter the volume number*/
                System.out.print("Volume number: ");
                /*Initializing a string scanner called "journalVol" to store and read user's input*/
                String journalVol = scanner.nextLine();
                /*Creating a new journal called "newJournal" with the information prompted above*/
                Journal newJournal = new Journal(itemName, itemAuthor, itemYear, journalVol);
                /*Adding the newJournal into the library*/
                library.addJournal(newJournal);
                /*Displaying a confirmation message to the user*/
                System.out.println("You have successfully added a journal into the system.");
            }

            /*Implementing this operation if choice is 3(Media)*/
            else {
                /*Prompting the user enter the type*/
                System.out.print("Type: ");
                /*Initializing a string scanner called "mediaType" to store and read user's input*/
                String mediaType = scanner.nextLine();
                /*Creating a new media called "newMedia" with the information prompted above*/
                Media newMedia = new Media(itemName, itemAuthor, itemYear, mediaType);
                /*Adding the newMedia into the library*/
                library.addMedia(newMedia);
                /*Displaying a confirmation message to the user*/
                System.out.println("You have successfully added a media into the system.");
            }
        }

        /*Implementing this operation if user enters a valid number*/
        else{
            System.out.println("You enter an invalid number. Please try again.");
        }
    } /*End of addingItem() method*/


    /**Implementing a static method called "removingItem"
     * Prompting user for information
     * Removing item from the system by using its ID
     * Removing a book by using removeBook(), removing a journal by using removeJournal(), and removing a media by using removeMedia()
     *
     * @param scanner           scanner to store and user's input
     * @param library           library where the items will be removed from*/
    public static void removingItem(Scanner scanner, Library library) {

        /*Displaying choosingCategory()*/
        System.out.println(choosingCategory());
        /*Initializing an integer scanner called "choice1" to store and read the user's input*/
        int choice1 = scanner.nextInt();

        /*Implementing this operation if user enters 1*/
        if(choice1 == 1){
            /*Implementing this operation if the number of books in the library is 0*/
            if(library.getNumBook()== 0){
                System.out.println("There is no book to remove from the system.");
            }
            /*Implementing this operation if the number of books in the library is not 0*/
            else {
                /*Prompting the user for the ID of the book they wish to remove*/
                System.out.print("Please enter the ID of the book you want to remove from the system:");
                /*Initializing a string scanner called "removeBookById" to store and read user's input*/
                String removeBookById = scanner.next();
                scanner.nextLine();
                /*Initializing a boolean called "removingBook" to remove a book from library by id*/
                boolean removingBook = library.removeBook(removeBookById);

                /*Implementing this operation if removingBook is true*/
                if (removingBook) {
                    System.out.println("You have successfully removed the book from the system.");
                }
                /*Implementing this operation if removingBook is false*/
                else {
                    System.out.println("Operation failed");
                }
            }
        }

        /*Implementing this operation if user enters 2*/
        else if(choice1 == 2){
            /*Implementing this operation if the number of journal in the system is 0*/
            if(library.getNumJournal() == 0){
                System.out.println("There is no journal to remove from the system.");
            }
            /*Implementing this operation if the number of journal in the system is greater than 0*/
            else{
                /*Prompting the user to enter the id of journal they wish to remove*/
                System.out.print("Please enter the ID of the journal you want to remove from the system:");
                /*Initializing a string scanner called "removeJournalById" to store and read user's input*/
                String removeJournalById = scanner.next();
                scanner.nextLine();
                /*Initializing a boolean called "removingJournal" to remove a journal by id*/
                boolean removingJournal = library.removeJournal(removeJournalById);

                /*Implementing this operation if removingJournal is true*/
                if(removingJournal){
                    System.out.println("You have successfully removed the journal from the system.");
                }
                /*Implementing this operation if removingJournal is false*/
                else{
                    System.out.println("Operation failed!");
                }
            }
        }

        /*Implementing this operation if user enters 3*/
        else if(choice1 == 3){
            /*Implementing this operation if the number of media in the system is 0*/
            if(library.getNumMedia() == 0){
                System.out.println("There is no media to remove from the system.");
            }
            /*Implementing this operation if the number of media in the system is greater than 0*/
            else {
                /*Prompting the user to enter id of the media they wish to remove*/
                System.out.print("Please enter the ID of the media you want to remove from the system");
                /*Initializing a string scanner called "removeMediaById" to store and read user's input*/
                String removeMediaById = scanner.next();
                scanner.nextLine();
                /*Initializing a boolean called "removingMedia" to remove a media by id*/
                boolean removingMedia = library.removeMedia(removeMediaById);

                /*Implementing this operation if removingMedia is true*/
                if (removingMedia) {
                    System.out.println("You have successfully removed the media from the system.");
                }
                /*Implementing this operation if removingMedia is false*/
                else {
                    System.out.println("Operation failed!");
                }
            }
        }
    }

    /**Implementing a static method called "editingItem"
     * Changing the information of a specific item (book, journal, media)
     * Output will be generated differently depending on user's input
     *
     * @param scanner       to store and read user's input
     * @param library       where the item will be modified */
    public static void editingItem(Scanner scanner, Library library){

        /*Displaying choosingCategory()*/
        System.out.println(choosingCategory());
        /*Initializing an integer scanner called "choice2" to store and read the user's input*/
        int choice2 = scanner.nextInt();

        /*Implementing this operation if user enters 1*/
        if(choice2 == 1){
            /*Implementing this operation if the number of books in the library is 0*/
            if(library.getNumBook() == 0){
                System.out.println("There is no book to edit in the system.");
            }
            /*Implementing this operation if the number of books in the library is greater than 0*/
            else {
                /*Prompting the user for the ID of the book they wish to edit*/
                System.out.println("Please enter the ID of the book you want to change the information of: ");
                /*Initializing a string scanner called "findBookById" to store and read user's input*/
                String findBookByID = scanner.next();
                scanner.nextLine();
                /*Initializing a book called "book"*/
                Book book = library.findBook(findBookByID);

                /*Implementing this operation if book is not null*/
                if (book != null) {
                    /*Displaying bookCategory()*/
                    System.out.println(bookCategory());
                    /*Initializing an integer scanner called "choice4" to store and read the user's input*/
                    int choice4 = scanner.nextInt();

                    /*Implementing this operation if user enters 1*/
                    if (choice4 == 1) {
                        /*Prompting the user for information*/
                        System.out.print("Please enter the new name of the book: ");
                        /*Initializing a string scanner called "newBookName" to store and read user's input*/
                        String newBookName = scanner.nextLine();
                        /*Setting a newBookName to the book*/
                        book.setName(newBookName);
                    }
                    /*Implementing this operation if the user enters 2*/
                    else if (choice4 == 2) {
                        /*Prompting the user for information*/
                        System.out.print("Please enter the new author's name of the book: ");
                        /*Initializing a string scanner called "newBookAuthor" to store and read user's input*/
                        String newBookAuthor = scanner.nextLine();
                        /*Setting a newBookAuthor to the book*/
                        book.setAuthorName(newBookAuthor);
                    }
                    /*Implementing this operation if the user enters 3*/
                    else if (choice4 == 3) {
                        /*Prompting the user for information*/
                        System.out.print("Please enter the new year of publication of the book: ");
                        /*Initializing a long scanner called "newBookYear" to store and read user's input*/
                        long newBookYear = scanner.nextLong();
                        /*Setting a newBookYear to the book*/
                        book.setPublicationYear(newBookYear);
                    }
                    /*Implementing this operation if the user enters 4*/
                    else if (choice4 == 4) {
                        /*Prompting the user for information*/
                        System.out.print("Please enter the new number of pages of the book: ");
                        /*Initializing a long scanner called "newNumPage" to store and read user's input*/
                        long newNumPage = scanner.nextLong();
                        /*Setting a newNumPage to the book*/
                        book.setNumPage(newNumPage);
                    }
                    /*Displaying a confirmation message to the user*/
                    System.out.println("You have successfully changed the book's information!");
                }
                /*Implementing this operation if the book is null*/
                else {
                    System.out.println("The book has no information to be changed.");
                }
            }
        }

        /*Implementing this operation if the user enters 2*/
        else if(choice2 == 2) {
            /*Implementing this operation if the number of journal is 0*/
            if(library.getNumJournal() == 0){
                System.out.println("There is no journal to edit in the system.");
            }
            /*Implementing this operation if the number of journal is greater than 0*/
            else {
                /*Prompting the user to enter the ID of the journal*/
                System.out.println("Please enter the ID of the journal you want to change the information of: ");
                /*Initializing a String scanner called "findJournalByID" to store and read the user's input*/
                String findJournalByID = scanner.next();
                scanner.nextLine();
                /*Initializing a journal called journal*/
                Journal journal = library.findJournal(findJournalByID);

                /*Implementing this operation if journal is not null*/
                if (journal != null) {
                    /*Displaying journalCategory()*/
                    System.out.println(journalCategory());
                    /*Initializing an integer scanner called "choice5" to store and read the user's input*/
                    int choice5 = scanner.nextInt();

                    /*Implementing this operation if user enters 1*/
                    if (choice5 == 1) {
                        /*Prompting the user for information*/
                        System.out.print("Please enter the new name of the journal: ");
                        /*Initializing a String scanner called "newJournalName" to store and read the user's input*/
                        String newJournalName = scanner.nextLine();
                        /*Setting a newJournalName to the journal*/
                        journal.setName(newJournalName);
                    }

                    /*Implementing this operation if user enters 2*/
                    else if (choice5 == 2) {
                        /*Prompting the user for information*/
                        System.out.print("Please enter the new author's name of the journal: ");
                        /*Initializing a String scanner called "newJournalAuthor" to store and read the user's input*/
                        String newJournalAuthor = scanner.nextLine();
                        /*Setting a newJournalAuthor to the journal*/
                        journal.setAuthorName(newJournalAuthor);
                    }

                    /*Implementing this operation if user enters 3*/
                    else if (choice5 == 3) {
                        /*Prompting the user for information*/
                        System.out.print("Please enter the new year of publication of the journal: ");
                        /*Initializing a String scanner called "newJournalYear" to store and read the user's input*/
                        long newJournalYear = scanner.nextLong();
                        /*Setting a newJournalYear to the journal*/
                        journal.setPublicationYear(newJournalYear);
                    }

                    /*Implementing this operation if user enters 4*/
                    else if (choice5 == 4) {
                        /*Prompting the user for information*/
                        System.out.print("Please enter the new volume of the journal: ");
                        /*Initializing a String scanner called "newVolNum" to store and read the user's input*/
                        String newVolNum = scanner.nextLine();
                        /*Setting a newVolNum to the journal*/
                        journal.setVolumeNum(newVolNum);
                    }
                    /*Displaying a confirmation message to the user*/
                    System.out.println("You have successfully changed the book's information!");
                }

                /*Implementing this operation if the journal is null*/
                else {
                    System.out.println("The journal has no information to be changed.");
                }
            }
        }

        /*Implementing this operation if user enters 3*/
        else if(choice2 == 3){
            /*Implementing this operation if the number of media in the system is 0*/
            if(library.getNumMedia() == 0){
                System.out.println("There is no media to edit in the system.");
            }
            /*Implementing this operation if the number of media in the system is greater than 0*/
            else {
                /*Prompting the user to enter the ID of the media*/
                System.out.println("Please enter the ID of the media you want to change the information of: ");
                /*Initializing a String scanner called "findMediaByID" to store and read the user's input*/
                String findMediaByID = scanner.next();
                scanner.nextLine();
                /*Initializing a media called "media"*/
                Media media = library.findMedia(findMediaByID);
                /*Implementing this operation if media is not null*/
                if (media != null) {
                    /*Displaying mediaCategory()*/
                    System.out.println(mediaCategory());
                    /*Initializing an integer scanner called "choice6" to store and read the user's input*/
                    int choice6 = scanner.nextInt();

                    /*Implementing this operation if user enters 1*/
                    if (choice6 == 1) {
                        /*Prompting the user to enter information*/
                        System.out.print("Please enter the new name of the media: ");
                        /*Initializing a String scanner called "newMediaName" to store and read the user's input*/
                        String newMediaName = scanner.nextLine();
                        /*Setting newMediaName to media*/
                        media.setName(newMediaName);
                    }

                    /*Implementing this operation if user enters 2*/
                    else if (choice6 == 2) {
                        /*Prompting the user to enter information*/
                        System.out.print("Please enter the new author's name of the media: ");
                        /*Initializing a String scanner called "newMediaAuthor" to store and read the user's input*/
                        String newMediaAuthor = scanner.nextLine();
                        /*Setting newMediaAuthor to media*/
                        media.setAuthorName(newMediaAuthor);
                    }

                    /*Implementing this operation if user enters 3*/
                    else if (choice6 == 3) {
                        /*Prompting the user to enter information*/
                        System.out.print("Please enter the new year of publication of the media: ");
                        /*Initializing a String scanner called "newMediaYear" to store and read the user's input*/
                        long newMediaYear = scanner.nextLong();
                        /*Setting newMediaYear to media*/
                        media.setPublicationYear(newMediaYear);
                    }

                    /*Implementing this operation if user enters 4*/
                    else if (choice6 == 4) {
                        /*Prompting the user to enter information*/
                        System.out.print("Please enter the new type of the media: ");
                        /*Initializing a String scanner called "newType" to store and read the user's input*/
                        String newType = scanner.nextLine();
                        /*Setting newType to media*/
                        media.setType(newType);
                    }

                    /*Displaying a confirmation message*/
                    System.out.println("You have successfully changed the media's information!");
                }
                /*Implementing this operation if the journal is null*/
                else {
                    System.out.println("The journal has no information to be changed.");
                }
            }
        }
    }/*End of editingItems() method*/


    /**Implementing a static method called "listingItem"
     * Displaying the item information depending on user's input
     *
     * @param scanner           to store and read user's input
     * @param library           where the contents of everything are coming from*/
    public static void listingItem(Scanner scanner, Library library){
        /*Displaying choosingCategory()*/
        System.out.println(choosingCategory());
        /*Initializing an integer called "choice3" to store and read the user's input*/
        int choice3 = scanner.nextInt();

        /*Implementing this operation if user enter 1*/
        if (choice3 == 1) {
            System.out.println("Content of all books in the library" + "\n" +
                     "-------------------------------------");
            System.out.println(library.bookContents());
        }

        /*Implementing this operation if user enter 2*/
        else if(choice3 == 2) {
            System.out.println("Content of all journals in the library" + "\n" +
                    "-------------------------------------");
            System.out.println(library.journalContents());
        }

        /*Implementing this operation if user enter 3*/
        else if(choice3 == 3){
            System.out.println("Content of all media in the library"+ "\n" +
                    "-------------------------------------");
            System.out.println(library.mediaContents());
        }
    }

    /**Implementing a static method called "listingAllItem"
     * Displaying all the item information
     *
     * @param library           where the contents of every item will be from
     * */
    public static void listingAllItems(Library library){
        /*Displaying all the information of items in the system*/
        System.out.println("Content of all items from all categories" + "\n"
                + "-------------------------------------");

        System.out.println("Books: ");
        System.out.println(library.bookContents());

        System.out.println("Journals: ");
        System.out.println(library.journalContents());

        System.out.println("Medias: ");
        System.out.println(library.mediaContents());
    }

    /**Implementing a method called "addingClient"
     * Prompting the user for information
     * Adding a new client to the system by creating a client with parametrized constructor
     *
     * @param library           where the client will be added to
     * @param scanner           to read and store user's input*/
    public static void addingClient(Scanner scanner, Library library){
        /*Prompting the user for input*/
        System.out.println("Please enter the client's information");
        scanner.nextLine();
        System.out.print("Name: ");
        /*Initializing a String scanner called "clientName" to store and read the user's input*/
        String clientName = scanner.nextLine();
        System.out.print("Phone number: ");
        /*Initializing a String scanner called "clientPhone" to store and read the user's input*/
        String clientPhone = scanner.nextLine();
        System.out.print("Email Address: ");
        /*Initializing a String scanner called "clientEmail" to store and read the user's input*/
        String clientEmail = scanner.nextLine();

        /*Creating a client called "newClient"*/
        Client newClient = new Client(clientName, clientPhone, clientEmail);
        /*Adding newClient into the system*/
        library.addClient(newClient);

        /*Displaying a confirmation message*/
        System.out.println("You have successfully added a client into the system");
    }/*End of addingClient()*/

    /**Implementing a method called "editingClient"
     * Prompting the user for information
     * Editing the information of a client
     *
     * @param library           where the number of clients will be known
     * @param scanner           to read and store user's input*/
    public static void editingClient(Scanner scanner, Library library){
        /*Implementing this operation if the number of client equals 0*/
        if(library.getNumClient() == 0){
            System.out.println("There is no client in the system. Please add a new client to the system to continue the operation. ");
        }
        /*Implementing this operation if the number of client is greater than 0*/
        else {
            /*Prompting the user to enter the information*/
            System.out.println("Please enter the ID of the client you want to change the information of: ");
            /*Initializing a String scanner called "editClientId" to read and store the user's input*/
            String editClientId = scanner.next();
            scanner.nextLine();
            /*Creating a client called "client"*/
            Client client = library.findClient(editClientId);

            /*Implementing this operation if client is not null*/
            if (client != null) {
                /*Displaying clientCategory()*/
                System.out.println(clientCategory());
                /*Initializing an integer called "choice3" to store and read the user's input*/
                int choice3 = scanner.nextInt();
                scanner.nextLine();

                /*Implementing this operation if user enters 1*/
                if (choice3 == 1) {
                    /*Prompting the user to enter information*/
                    System.out.print("Please enter the new name: ");
                    /*Initializing a String called "newClientName" to store and read the user's input*/
                    String newClientName = scanner.nextLine();
                    /*Setting newClientName to client*/
                    client.setClientName(newClientName);
                    /*Displaying a confirmation*/
                    System.out.println("You have successfully changed the client's name.");
                }
                /*Implementing this operation if user enters 2*/
                else if (choice3 == 2) {
                    /*Prompting the user to enter information*/
                    System.out.print("Please enter the new phone number: ");
                    /*Initializing a String called "newClientPhone" to store and read the user's input*/
                    String newClientPhone = scanner.nextLine();
                    /*Setting newClientPhone to client*/
                    client.setPhoneNum(newClientPhone);
                    /*Displaying a confirmation*/
                    System.out.println("You have successfully changed the client's phone number.");
                }
                /*Implementing this operation if user enters 3*/
                else if (choice3 == 3) {
                    /*Prompting the user to enter information*/
                    System.out.print("Please enter the new email address: ");
                    /*Initializing a String called "newClientPhone" to store and read the user's input*/
                    String newClientEmail = scanner.nextLine();
                    /*Setting newClientPhone to client*/
                    client.setEmail(newClientEmail);
                    /*Displaying a confirmation*/
                    System.out.println("You have successfully changed the client's email address.");
                }
            }
            /*Implementing this operation if client is null*/
            else {
                System.out.println("There is no client found in the system");
            }
        }
    } /*End of editingClient()*/

    /**Implementing a method called "removingClient"
     * Operating the method depending on the number of clients
     * Prompting the user's for client ID to check if that client exists in the system
     * Removing the client if it exists
     *
     * @param library           where the clients will be removed
     * @param scanner           to read and store user's input
     *  */
    public static void removingClient(Scanner scanner, Library library){
        /*Implementing this operation if the number of client equals 0*/
        if(library.getNumClient() == 0){
            System.out.println("There is no client in the system. Please add a client to the system to continue the operation.");
        }
        /*Implementing this operation if the number of client is greater than 0*/
        else {
            /*Prompting the user for information*/
            System.out.println("Please enter the ID of the client you want to remove from the system: ");
            /*Initializing a String scanner called "removeClientId" to store and read the user's input*/
            String removeClientId = scanner.next();
            scanner.nextLine();
            /*Initializing a boolean called "removingClient"*/
            boolean removingClient = library.removeClient(removeClientId);

            /*Implementing this operation if removingClient is true*/
            if (removingClient) {
                System.out.println("You have successfully removed a client.");
            }
            /*Implementing this operation if removingClient is false*/
            else {
                System.out.println("Operation failed! You might enter a wrong ID!");
            }
        }
    }

    /**Implementing this method called leasingItem()
     * Lease item to client by prompting for their ID
     *
     * @param scanner           to read and store the user's input
     * @param library           where the operation of leasing will be happened*/
    public static void leasingItem(Scanner scanner, Library library){
        /*Implementing this operation if the number of client equals 0*/
        if(library.getNumClient() == 0){
            System.out.println("There is no client in the system. Please add a client into the system before process the leasing operation.");
        }
        /*Implementing this operation if the number of client is greater than 0*/
        else {
            /*Prompting the user for information*/
            System.out.print("Please enter the ID of the client: ");
            String leasedClientID = scanner.next();
            scanner.nextLine();
            /*Implementing this operation if client is not null*/
            if (library.findClient(leasedClientID) != null) {
                /*Displaying choosingCategory*/
                System.out.println(choosingCategory());
                /*Initializing an integer scanner called "choice4" to store and read the user's input*/
                int choice4 = scanner.nextInt();

                /*Implementing this operation if user enters 1*/
                if (choice4 == 1) {
                    /*Implementing this operation if the number of book equals 0*/
                    if (library.getNumBook() == 0) {
                        System.out.println("There is no book in the system. Please add a book into the system before process the leasing operation.");
                    }
                    /*Implementing this operation if the number of book is greater than 0*/
                    else {
                        /*Prompting the user for information*/
                        System.out.print("Please enter the ID of the book: ");
                        String leasedBookID = scanner.next();
                        /*Implementing this operation if book is not null*/
                        if (library.findBook(leasedBookID) != null) {
                            if (library.leaseBookToClient(leasedBookID, leasedClientID)) {
                                System.out.println("The book with ID: " + leasedBookID + " has successfully leased to client with ID: " + leasedClientID);
                            }
                            else {
                                System.out.println("Failed to lease the book to client.");
                            }
                        }
                        /*Implementing this operation if book is null*/
                        else {
                            System.out.println("There is no book with the ID: " + leasedBookID + " found in the system.");
                        }
                    }
                }
                /*Implementing this operation if user enters 2*/
                else if (choice4 == 2) {
                    /*Implementing this operation if the number of journal equals 0*/
                    if (library.getNumJournal() == 0) {
                        System.out.println("There is no journal in the system. Please add a journal into the system before process the leasing operation.");
                    }
                    /*Implementing this operation if the number of journal is greater than 0*/
                    else {
                        /*Prompting the user for information*/
                        System.out.print("Please enter the ID of the book: ");
                        String leasedJournalID = scanner.next();
                        /*Implementing this operation if journal is not null*/
                        if (library.findJournal(leasedJournalID) != null) {
                            if (library.leaseJournalToClient(leasedJournalID, leasedClientID)) {
                                System.out.println("The journal with ID: " + leasedJournalID + " has successfully leased to client with ID: " + leasedClientID);
                            }
                            else {
                                System.out.println("Failed to lease the book to client.");
                            }
                        }
                        /*Implementing this operation if journal is null*/
                        else {
                            System.out.println("There is no journal with the ID: " + leasedJournalID + " found in the system.");
                        }
                    }
                }
                /*Implementing this operation if user enters 1*/
                else if (choice4 == 3) {
                    /*Implementing this operation if the number of media equals 0*/
                    if (library.getNumMedia() == 0) {
                        System.out.println("There is no media in the system. Please add a media into the system before process the leasing operation.");
                    }
                    /*Implementing this operation if the number of media is greater than 0*/
                    else {
                        /*Prompting the user for information*/
                        System.out.print("Please enter the ID of the journal: ");
                        String leasedMediaID = scanner.next();
                        /*Implementing this operation if media is null*/
                        if (library.findMedia(leasedMediaID) != null) {
                            if (library.leaseMediaToClient(leasedMediaID, leasedClientID)) {
                                System.out.println("The media with ID: " + leasedMediaID + " has successfully leased to client with ID: " + leasedClientID);
                            } else {
                                System.out.println("Failed to lease the book to client.");
                            }
                        }
                        /*Implementing this operation if media is not null*/
                        else {
                            System.out.println("There is no media with the ID: " + leasedMediaID + " found in the system.");
                        }
                    }
                }
            }
            /*Implementing this operation if client is null*/
            else {
                System.out.println("There is no client with the ID: " + leasedClientID + " found in the system.");
            }
        }
    }

    /**Implementing a static method called "returningItem"
     * Returning item from the user by using their ID
     *
     * @param scanner           to read and store the user's input
     * @param library           where the operation of un-leasing will be happened
     * */
    public static void returningItem(Scanner scanner, Library library){
        /*Implementing this operation if the number of client equals 0*/
        if(library.getNumClient() == 0){
            System.out.println("There is no client found in the system. Please add a client into the system.");
        }
        /*Implementing this operation if the number of client is greater than 0*/
        else{
            /*Prompting the user for information*/
            System.out.println("Please enter the ID of the client that wants to return the item: ");
            String clientID = scanner.next();
            scanner.nextLine();
            /*Implementing this operation if client is null*/
            if(library.findClient(clientID)== null){
                System.out.println("There is no client with ID: " + clientID + " found in the system.");
            }
            /*Implementing this operation if client is not null*/
            else{
                /*Prompting the user for information*/
                System.out.println("Please enter the ID of the item that the client wants to return: ");
                String itemID = scanner.next();
                scanner.nextLine();
                /*Implementing this operation if user enters ID start with B*/
                if(itemID.charAt(0) == 'B') {
                    if(library.findBook(itemID) == null){
                        System.out.println("There is no book with ID: " + itemID + " found in the system.");
                    }
                    else{
                        if(library.returnBookFromClient(clientID, itemID)) {
                            System.out.println("You have successfully returned a book.");
                        }
                    }
                }
                /*Implementing this operation if user enters ID start with J*/
                else if(itemID.charAt(0) == 'J'){
                    if(library.findJournal(itemID) == null){
                        System.out.println("There is no journal with ID: " + itemID + " found in the system.");
                    }
                    else{
                        if(library.returnJournalFromClient(clientID, itemID)) {
                            System.out.println("You have successfully returned a journal.");
                        }
                    }
                }
                /*Implementing this operation if user enters ID start with M*/
                else if(itemID.charAt(0) == 'M'){
                    if(library.findMedia(itemID) == null){
                        System.out.println("There is no media with ID: " + itemID + " found in the system.");
                    }
                    else{
                        if(library.returnMediaFromClient(clientID, itemID)) {
                            System.out.println("You have successfully returned a media.");
                        }
                    }
                }
            }
        }
    }

    /**Implementing a static method called "displayingLeasedItem"
     * The content of books, journals, or media that are leased by a specific client will be shown depending on user's input
     *
     * @param scanner           to read and store the user's input
     * @param library           where the leased items are stored
     * */
    public static void displayingLeasedItem(Scanner scanner, Library library){
        /*Implementing this operation if the number of client equals 0*/
        if(library.getNumClient() == 0 ){
            System.out.println("There is no client in the system. Please add a client into the system and continue to the leasing process.");
        }
        /*Implementing this operation if the number of client is greater than 0*/
        else{
            /*Prompting the user to enter information*/
            System.out.print("Please enter the client's ID: ");
            /*Initializing a String scanner called "clientID" to read and store the user's input*/
            String clientID = scanner.next();
            /*Creating a client called "leasedClient"*/
            Client leasedClient = library.findClient(clientID);

            /*Implementing this operation if leasedClient is null*/
            if(leasedClient == null){
                System.out.println("There is no client with ID: " + clientID + " found in the system.");
            }
            /*Implementing this operation if leasedClient is not null*/
            else{
                /*Implementing this operation if the number of leased journal equals 0*/
                if(leasedClient.getNumLeasedBook() == 0){
                    System.out.println("No Book is leased by this client.");
                }
                /*Implementing this operation if the number of leased book is greater than 0*/
                else if (leasedClient.getNumLeasedBook() == 1 || leasedClient.getNumLeasedBook() > 1){
                    /*Displaying the information of all leased journal*/
                    System.out.println("Book(s) leased by client with ID: " + clientID);
                    for(int g = 0; g < leasedClient.getNumLeasedBook(); g++){
                        System.out.println(leasedClient.leasedBooks[g].toString());
                    }
                }

                /*Implementing this operation if the number of leased journal equals 0*/
                if(leasedClient.getNumLeasedJournal() == 0){
                    System.out.println("No journal is leased by this client.");
                }
                /*Implementing this operation if the number of leased journal is greater than 0*/
                else if(leasedClient.getNumLeasedJournal() == 1 || leasedClient.getNumLeasedJournal() > 1){
                    /*Displaying the information of all leased journal*/
                    System.out.println("Journal(s) leased by client with ID: " + clientID);
                    for(int g = 0; g < leasedClient.getNumLeasedJournal(); g++){
                        System.out.println(leasedClient.leasedJournals[g].toString());
                    }
                }

                /*Implementing this operation if the number of leased media equals 0*/
                if(leasedClient.getNumLeasedMedia() == 0){
                    System.out.println("No media is leased by this client.");
                }
                /*Implementing this operation if the number of leased media is greater than 0*/
                else if(leasedClient.getNumLeasedMedia() == 1 || leasedClient.getNumLeasedMedia() > 1){
                    /*Displaying the information of all leased media*/
                    System.out.println("Media(s) leased by client with ID: " + clientID);
                    for(int g = 0; g < leasedClient.getNumLeasedMedia(); g++){
                        System.out.println(leasedClient.leasedMedias[g].toString());
                    }
                }
            }
        }
    }

    /**Implementing a static method called "displayingAllLeasedItem"
     * Displaying all the items that have been leased
     *
     * @param library           where the leased items are stored*/
    public static void displayingAllLeasedItem(Library library){
        /*Implementing this operation if the number of client is 0*/
        if(library.getNumClient() == 0){
            System.out.println("There is no client found in the system. Please add a client and do the leasing process.");
        }
        /*Implementing this operation if the number of client is greater than 0*/
        else{
            /*Displaying the information of all leased items*/
            System.out.println("Information of all leased items by all the clients in the system.");
            /*Initializing an array of clients called "client"*/
            Client[] clients = library.getClients();
            /*Iterating through the array of client*/
            for(int h = 0; h < library.getNumClient(); h++){
                Client client = clients[h];
                if(client != null) {
                    /*Implementing this operation if the number of leased book is greater or equals to 1*/
                    if (client.getNumLeasedBook() >= 1) {
                        for (int i = 0; i < client.getNumLeasedBook(); i++) {
                            System.out.println(client.leasedBooks[i].toString());
                        }
                    }
                    /*Implementing this operation if the number of leased journal is greater or equals to 1*/
                    if (client.getNumLeasedJournal() >= 1) {
                        for (int i = 0; i < client.getNumLeasedJournal(); i++) {
                            System.out.println(client.leasedJournals[i].toString());
                        }
                    }
                    /*Implementing this operation if the number of leased media is greater or equals to 1*/
                    if (client.getNumLeasedMedia() >= 1) {
                        for (int i = 0; i < client.getNumLeasedMedia(); i++) {
                            System.out.println(client.leasedMedias[i].toString());
                        }
                    }
                }
            }
        }

    }

    /**Implementing a static method called "getBiggestBook()"
     * Iterating through array of books
     * Displaying the book with the highest number of pages
     *
     * @param library           where the array of books is stored*/
    public static void gettingBiggestBook(Library library) {
        Book[] books = library.getBook();
        /*Implementing this operation if the number of book is 0*/
        if(books == null || library.getNumBook() == 0){
            System.out.println("There is no book in the system. Please add new books to process this operation.");
        }
        /*Implementing this operation if the number of book is greater than 0*/
        else{
            /*Displaying the information of the book with the highest number of pages*/
            System.out.println("Information of the book with highest number of pages: ");
            /*Initializing a book called "biggestBook"*/
            Book biggestBook = books[0];
            for(int i = 1; i < library.getNumBook(); i++){
                /*Implementing this operation if book is not null and biggestBook has the number of page greater than book at index i*/
                if(books[i] != null && biggestBook.getNumPage() > library.books[i].getNumPage()){
                    biggestBook = library.books[i];
                }
            }
            System.out.println(biggestBook.toString());
        }
    }

    /**Implementing a method called "copyingBook()"
     * Creating an array of books with the same size as the original array of books
     * Passing each element that is not null of the original array to the copy one
     *
     * @param library           where the array of books is store
     * */
    /*Implementing a static method called "copyingBook" to deep copy array of books*/
    public static void copyingBook(Library library){
        /*Implementing this operation if the number of book is 0*/
        if(library.getNumBook() == 0){
            System.out.println("There is no book found in the system to be copied.");
        }
        /*Implementing this operation if the number of book is greater than 0*/
        else {
            /*Initializing an array book called "copyBooks" with the size of number of book*/
            Book[] copyBooks = new Book[library.getNumBook()];
            System.out.println("The deep copy of the array of books");
            /*Iterating through the array of books*/
            for (int i = 0; i < library.getNumBook(); i++) {
                /*Implementing this operation if the book at index i is not null*/
                if (library.books[i] != null) {
                    /*Assigning books at index i to copyBooks*/
                    copyBooks[i] = new Book(library.books[i]);
                }
                /*Displaying the information of the book*/
                System.out.println(copyBooks[i]);
            }
        }
    }


    /**Implementing a method called hardCoded()
     * Handling the scenario when the user wants to use the pre-defined one
     * Client, book, journal, and media will be created
     * Array of client, book, journal, and media will also be implemented
     * Using equals() methods to compare objects
     * Using toString() to show the content of clients and items
     * Getting the book with the highest number of pages
     * Getting a deep copy of array of books
     * */
    public static void hardCoded(){

        /*Initializing three books: book1, book2, and book3*/
        Book book1 = new Book("Environment", "Justin Gold", 2013, 450);
        Book book2 = new Book("Global Warming", "Ryan. J, and Lana. DR", 2020, 370);
        Book book3 = new Book("Immigrations", "Sean", 2021, 450);

        /*Initializing three journals: journal1, journal2, and journal3*/
        Journal journal1 = new Journal("Health Care in Canada", "Elizabeth", 2019, "A99");
        Journal journal2 = new Journal("Society", "John", 2016, "55");
        Journal journal3 = new Journal("Climate Change", "Jo", 1999, "90");

        /*Initializing three media: media1, media2, and media3*/
        Media media1 = new Media("Beauty", "Christian", 2020, "Magazines");
        Media media2 = new Media("Beauty", "Christian", 2020, "Magazines");
        Media media3 = new Media("Health Care in Canada", "Eliza", 2019, "A99");

        /*Initializing three clients: client1, client2, and client3*/
        Client client1 = new Client("Monalisa", "123456789" , "mona@yahoo.com");
        Client client2 = new Client("Angel", "987654321", "angel@gmail.com");
        Client client3 = new Client("Joy", "111111111", "joy@concordia.ca");

        /*Displaying the information of all 9 items*/
        System.out.println("Items information");
        System.out.println(book1 + "\n" + book2 + "\n" + book3 + "\n" + journal1 + "\n" + journal2 + "\n" + journal3 + "\n" + media1 + "\n" + media2 + "\n" + media3);

        System.out.println("Client information");
        System.out.println(client1 + "\n" + client2 + "\n" + client3);

        /*Implementing equals() method to test two objects from the same class with different values*/
        if (book1.equals(book2)) {
            System.out.println("book1 and book2 share the same contents.");
        } else {
            System.out.println("book1 and book2 do not share the same contents.");
        }

        /*Implementing equals() method to test two objects from the same class with the same values*/
        if (media1.equals(media2)) {
            System.out.println("media1 and media2 share the same contents.");
        } else {
            System.out.println("media1 and media2 do not share the same contents");
        }

        /*Implementing equals() method to test two objects from the different class with same values*/
        if (journal1.equals(media3)) {
            System.out.println("journal1 and media3 share the same contents");
        } else {
            System.out.println("journal1 and media3 do not share the same contents");
        }

        /*Implementing equals() method to test two clients share the same values*/
        if(client1.equals(client2)){
            System.out.println("client1 and client2 share the same contents.");
        }
        else{
            System.out.println("client1 and client2 do not share the same contents.");
        }

        Book[] books = new Book[]{book1, book2, book3};
        Journal[] journals = new Journal[]{journal1, journal2, journal3};
        Media[] medias = new Media[]{media1, media2, media3};
        Client[] clients = new Client[]{client1, client2, client3};
        Item[] items = {book1, book2, book3, journal1, journal2, journal3, media1, media2, media3};

        Book biggestBook = books[0];
        for (Book book : books) {
            if (book != null && biggestBook.getNumPage() > book.getNumPage()) {
                biggestBook = book;
            }
        }
        System.out.println("\nThe book with the highest number of page is: " + biggestBook.toString());

        Book[] deepCopy = new Book[books.length];
        for(int i = 0; i < books.length; i++){
            if(books[i] != null) {
                deepCopy[i] = books[i];
            }
        }
        System.out.println("The deep copy of books: ");
        for(Book copiedBook : deepCopy){
            System.out.println(copiedBook.toString());
        }

    }
}