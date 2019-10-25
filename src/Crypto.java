import java.util.*;

public class Crypto {
    public static void main(String [] args){
        //A test sample below!
        //Who will win the election?! (Please Enter a Name dude, not "trump" though)
        start();
    }

    public static void start(){         //this is the interface of the program
        Scanner input = new Scanner(System.in);

        System.out.println("****** Welcome To Crypto The Text Encrypting/Decrypting Program! ******\n");
        System.out.println("1 - If you want some help enter enter(h).");
        System.out.println("2 - To enter a text you want to encrypt enter(e).");
        System.out.println("3 - To enter an encrypted text that you want to decrypt enter(d).");
        System.out.println("4 - To see these instructions again enter(i).");
        System.out.println("5 - To quit enter(q).");
        boolean quit = false;
        while (!quit){      //this is a way to make the program loop until the user tells it to quit
            String command;

            System.out.println("- Enter (h, e, d, i, q)");

            System.out.print("> ");
            command = input.next();

            switch (command) {
                case "h": case "H":
                    help();
                    break;
                case "e": case "E":
                    encryptingCommand();
                    break;
                case "d": case "D":
                    decryptingCommand();
                    break;
                case "i": case "I":
                    System.out.println("**********************************");
                    System.out.println("1 - If you want some help enter enter(h).");
                    System.out.println("2 - To enter a text you want to encrypt enter(e).");
                    System.out.println("3 - To enter an encrypted text that you want to decrypt enter(d).");
                    System.out.println("4 - To see these instructions again enter(i).");
                    System.out.println("5 - To quit enter(q).");
                    System.out.println("**********************************");
                    break;
                case "q": case "Q":
                    quit = true;
                    System.out.println("**********************************");
                    System.out.println("Good bye and thanks for using my program!");
                    System.out.println("**********************************");
                    break;
                default:
                    System.out.println("Enter a valid character!");
                    break;
            }
        }
    }

    public static void help(){ //this is similar to a documentation for users
        System.out.println("**********************************");

        System.out.println("- So you want some help!");
        System.out.println("- What function do you want help in?");
        System.out.println("1 - If you want to know more about shifting enter(s).");
        System.out.println("2 - If you want to know more about grouping enter(g).");
        System.out.println("3 - If you want to know more about encrypted text(d).");
        System.out.println("4 - To see this instructions again enter(i).");
        System.out.println("5 - To get back to the main menu enter(q).");

        boolean quit = false;
        while (!quit){      //this is a way to make the program loop until the user tells it to quit
            Scanner input = new Scanner(System.in);
            String command;

            System.out.println("- Enter (s, g, d, i, q)");
            System.out.print("> ");
            command = input.next();

            switch (command) {
                case "s": case "S":
                    System.out.println("**********************************");
                    System.out.println("-- Shifting --");
                    System.out.println("1 - shift is like a special key for every encryption.");
                    System.out.println("2 - try to remember it or write it down because you need\n    it to decrypt the encrypted text.");
                    System.out.println("3 - in fact it's real range is from -26 to 26\n    and any number you enter will be rounded down to that range.");
                    System.out.println("**********************************");
                    break;
                case "g": case "G":
                    System.out.println("**********************************");
                    System.out.println("-- Grouping --");
                    System.out.println("1 - Grouping is a way to a make the encryption less readable.");
                    System.out.println("2 - The \"x\" symbol in the end of the encryption\n    is to complete the last group if it isn't completed.");
                    System.out.println("3 - in fact it's real range is from 0 to the half of the text length\n    and any number you enter will be rounded down to that range.");
                    System.out.println("**********************************");
                    break;
                case "d": case "D":
                    System.out.println("**********************************");
                    System.out.println("-- Decryption --");
                    System.out.println("1 - The (#) symbols is used to indicate the ending of each word.\n    it's used to space the decrypted words.");
                    System.out.println("2 - Any punctuation will be lost in the process");
                    System.out.println("3 - The result will be in pascal case(This Is An Example)");
                    System.out.println("**********************************");
                    break;
                case "i": case "I":
                    System.out.println("**********************************");
                    System.out.println("1 - If you want to know more about shifting enter(s).");
                    System.out.println("2 - If you want to know more about grouping enter(g).");
                    System.out.println("3 - If you want to know more about encrypted text(d).");
                    System.out.println("4 - To see this instructions again enter(i).");
                    System.out.println("5 - To get back to the main menu enter(q).");
                    System.out.println("**********************************");
                    break;
                case "q": case "Q":
                    quit = true;
                    System.out.println("**********************************");
                    System.out.println("You've granted the power of understanding!");
                    System.out.println("You are back on the main menu now!");
                    System.out.println("**********************************");
                    break;
                default:
                    System.out.println("Enter a valid character!");
                    break;
            }
        }
    }

    public static void encryptingCommand(){ // this is the function that does the encryption for the user
        Scanner input = new Scanner(System.in);
        String text;
        int shift;
        int groupSize;

        System.out.println("**********************************");

        System.out.println("- Enter the text you want to Encrypt: ");
        System.out.print("> ");
        text = input.nextLine();

        System.out.println("- Enter how much you want to shift it: ");
        System.out.print("> ");
        shift = input.nextInt();

        System.out.println("- Enter how many characters you want in each group: ");
        System.out.print("> ");
        groupSize = input.nextInt();

        String encryptedText = encryptString(text, shift, groupSize);

        System.out.println("- The Encrypted version is: ");
        System.out.println(encryptedText);

        System.out.println("**********************************");
    }

    public static void decryptingCommand(){ // this is the function that does the decryption for the user
        Scanner input = new Scanner(System.in);
        String text;
        int shift;

        System.out.println("**********************************");

        System.out.println("- Enter the text you want to decrypt: ");
        System.out.print("> ");
        text = input.nextLine();

        System.out.println("- Enter how much was it shifted: ");
        System.out.print("> ");
        shift = input.nextInt();

        String decryptedText = decryptString(text, shift);
        System.out.println("- The Decrypted version is: ");
        System.out.println(decryptedText);

        System.out.println("**********************************");
    }


    public static String encryptString(String txt, int shift, int groupSize){ //this is a function to do the whole encryption process
        txt = normalizeText(txt);
        txt = caesarify(txt, shift);
        txt = groupify(txt, groupSize);

        return txt;
    }

    public static String normalizeText(String someText){ //this is a function that removes all the punctuation and replaces spaces with (#)
        someText = someText.replace('.', ' ');
        someText = someText.replace(",", "");
        someText = someText.replace(":", "");
        someText = someText.replace("-", "");
        someText = someText.replace("_", "");
        someText = someText.replace(";", "");
        someText = someText.replace("+", "");
        someText = someText.replace("=", "");
        someText = someText.replace("!", "");
        someText = someText.replace("\"", "");
        someText = someText.replace("@", "");
        someText = someText.replace("$", "");
        someText = someText.replace("^", "");
        someText = someText.replace("%", "");
        someText = someText.replace("*", "");
        someText = someText.replace("&", "");
        someText = someText.replace("~", "");
        someText = someText.replace(">", "");
        someText = someText.replace("<", "");

        someText = someText.replaceAll(" ", "#");  //replaces spaces with (#)

        someText = someText.replace('(', ' ');
        someText = someText.replace(')', ' ');
        someText = someText.replace('\'', ' ');
        someText = someText.replace('?', ' ');
        someText = someText.replaceAll(" ", "");
        someText = someText.toUpperCase();
        return someText;
    }

    //here we replace each character in the text with it's counterpart in the shifted alphabet
    public static String caesarify(String txtToEncrypt, int shift){
        String alphabet = shiftAlphabet(shift);    //shifting the alphabet
        StringBuilder result  = new StringBuilder(txtToEncrypt);  //making the text a StringBuilder to be more modifiable

        //looping through the target text characters to modify them
        for (int j = 0; j < txtToEncrypt.length(); j++) {
            char currChar = 'A'; //The first character in the normal alphabet
            //we loop through the whole normal alphabet for each character in the txtToEncrypt
            //and when we find a match we replace the character in the txtToEncrypt
            //with the counterpart of the currChar in the shiftedAlphabet
            for (int i = 0; currChar <= 'Z'; ++currChar) { //here the comparison is done between the ASCII values of The Characters
                if (txtToEncrypt.charAt(j) == currChar) {
                    result.setCharAt(j, alphabet.charAt(i));
                }
                //the i holds the index of the currChar in the shiftedAlphabet
                i++;
            }
        }

        txtToEncrypt = result.toString();
        return txtToEncrypt;
    }

    public static String shiftAlphabet(int shift){
        int start = 0;
        shift = shift%26; // same as using shift but it's overflow proof
        if(shift < 0){ //if the user put negatives it gets reversed
            start = (int) 'Z' + shift + 1;
        }else {
            start = 'A' + shift;
        }

        String result = "";//the initial alphabet string
        char currChar = (char) start;

        for(; currChar <= 'Z'; ++currChar){//it adds the alphabet from the starting character to 'Z'
            result = result + currChar;
        }

        if(result.length() < 26){//if there is any missing characters in the alphabet add it
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }

        return result;
    }

    public static String groupify(String txtToBreak, int charsPerGroup){ //divides the text to groups
        charsPerGroup = charsPerGroup % (txtToBreak.length()/2);//it makes sure that the user don't make a mess
        int times = txtToBreak.length() + txtToBreak.length() / charsPerGroup;
        StringBuilder result = new StringBuilder(txtToBreak);
        for (int i = charsPerGroup; i < times; i += charsPerGroup) {
            result.insert(i, " ");
            i++;
        }
        if(txtToBreak.length()%charsPerGroup != 0) {
            for (int j = 0; j < charsPerGroup - txtToBreak.length() % charsPerGroup; j++) {
                result.insert(result.toString().length(), "x");
            }
        }
        txtToBreak = result.toString();

        return txtToBreak;
    }

    public static String unGroupify(String text){//undo the groupify
        text = text.replace(" ", "");
        text = text.replace("x", "");

        return text;
    }

    public static String decryptString(String txt, int shift){//undo the encryption
        txt = unGroupify(txt);
        txt = txt.replace("#", " ");
        txt = caesarify(txt, 26-shift);

        return toTitleCase(txt);
    }

    public static String toTitleCase(String givenString) {//makes the first character of each word capital
        givenString = givenString.toLowerCase();
        String[] arr = givenString.split(" ");
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < arr.length; i++) {
            sb.append(Character.toUpperCase(arr[i].charAt(0)))
                    .append(arr[i].substring(1)).append(" ");
        }
        return sb.toString().trim();
    }
}
