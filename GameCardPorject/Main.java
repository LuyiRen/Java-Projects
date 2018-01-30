import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //create suits and numbers
        String[] arraylist = {"Ace", "King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
        String[] suits = {"Club", "Diamond", "Heart", "Spades"};

        Cards[] deck = new Cards[52];
        int countnumbers = 0;
        int countsuits = 0;
        for (int i = 0; i < deck.length-1; i++){
            deck[i] = new Cards();

            deck[i].setNumber(arraylist[countnumbers]);
            countnumbers++;
            if (countnumbers >12 ){countnumbers=0;}

            deck[i].setSuits(suits[countsuits]);
            countsuits++;
            if(countsuits > 3){countsuits=0;}
        }
        shuffle(deck);
        System.out.println("Please insert your name!");
        PlayerAccount  player = new PlayerAccount();
        Scanner scan = new Scanner(System.in);
        player.setName(scan.nextLine());
        player.setMoney(500);

        displayTitle(player);
        int answser = scan.nextInt();
        while (answser != 999){
            while(answser == 1){
                HighandLow(deck[0], deck[1]);
                shuffle(deck);
                System.out.println("would you like to go again? or back to the main menu?");
                System.out.println("hit 1 to play again or anything else to go back");
                answser = scan.nextInt();
            }
            while (answser == 2){
                Cards[] compdeck = new Cards[5];
                Cards[] playerhand = new Cards[5];
                for (int i = 0; i < 5; i++){
                    compdeck[i] = deck[i];
                }
                for (int i = 0 ; i < 5; i++){
                    playerhand[i] = deck[i+5];
                }
                Poker(playerhand, compdeck, deck);
                shuffle(deck);
                System.out.println("would you like to go again? or back to the main menu?");
                System.out.println("hit 1 to go back or anything else to play again");
                answser = scan.nextInt();
            }
            displayTitle(player);
            answser= scan.nextInt();
        }
    }

    public static void HighandLow(Cards deck, Cards deck1){
        //play high or low
        System.out.println("This game is called high or low!");
        System.out.println("The first card will be shown and you guess if the next card is higher or lower");
        System.out.println(deck.getNumber() + " of " + deck.getSuits());
        System.out.println("Will the next card be higher or lower?");
        System.out.println("hit 1 for higher, 2 for lower, 3 the same");
        Scanner scan = new Scanner(System.in);
        int answer = scan.nextInt();
        System.out.println("Your card was: " + deck1.getNumber() + " of " + deck1.getSuits());

        if(deck1.compareTo(deck) > 0){
            if(answer == 1){
                System.out.println("correct!~");
            }
            else {
                System.out.println("wrong");
            }
        }
        else if (deck1.compareTo(deck) == 0){
            if(answer == 3){
                System.out.println("correct");
            }
            else{
                System.out.println("wrong");
            }
        }
        else {
            if(answer == 2){
                System.out.println("correct");
            }
            else {
                System.out.println("wrong");
            }
        }
    }
    public static void Poker(Cards[] playerhand, Cards[] Computer, Cards[] deck){
        System.out.println("Your cards are as follows: ");
        displayCards(playerhand);
        displayCombo(EvaluateCombos(playerhand));
        System.out.println("Would you like to throw away any cards? You are allowed to trade in 2");
        System.out.println("If you want to trade 2 cards enter their positions, if you only want to trade in one, put 0");
        Scanner scan1 = new Scanner(System.in);
        int answer1 = scan1.nextInt();
        int answer2 = scan1.nextInt();
        while (answer1 > 5 || answer2 >5){
            System.out.println("That doesnt exist! try entering another number");
            answer1 = scan1.nextInt();
            answer2 = scan1.nextInt();
        }
        if (answer1==0){
            playerhand[answer2-1] = deck[25];
        }
        else if(answer2 == 0){
            playerhand[answer1-1] = deck[26];
        }
        else if (answer1 == 0 && answer2 == 0){
            //do nothing
        }
        else {
            playerhand[answer1-1] = deck[26];
            playerhand[answer2-1] = deck[25];
        }
        System.out.println("You now have: ");
        displayCards(playerhand);
        displayCombo(EvaluateCombos(playerhand));

        System.out.println("Press enter to see if you won or lost!");
        String anything = scan1.nextLine();

        if (EvaluateCombos(Computer) > EvaluateCombos(playerhand)){
            System.out.println("You lose! The computers cards were: ");
            displayCards(Computer);
            displayCombo(EvaluateCombos(Computer));
        }
        else if(EvaluateCombos(Computer) == EvaluateCombos(playerhand)){
            int[] playerduplicates = new int[5];
            int[] computerduplicates = new int[5];
            for(int i = 0; i <5; i++){
                playerduplicates[i] = playerhand[i].toValueNumbers();
                computerduplicates[i] = Computer[i].toValueNumbers();
            }
            if(EvaluateCombos(Computer) == 1){
                //compare high card
                if (highCard(Computer) > highCard(playerhand)){
                    System.out.println("You lose! The computers cards were: ");
                    displayCards(Computer);
                    displayCombo(EvaluateCombos(Computer));
                }
                else {
                    System.out.println("You win! The computers cards were: ");
                    displayCards(Computer);
                    displayCombo(EvaluateCombos(Computer));
                }
            }
            else if (returnTheDuplicate(playerduplicates) > returnTheDuplicate(computerduplicates)){
                System.out.println("You win! The computers cards were: ");
                displayCards(Computer);
                displayCombo(EvaluateCombos(Computer));
            }
            else {
                System.out.println("You lose! The computers cards were: ");
                displayCards(Computer);
                displayCombo(EvaluateCombos(Computer));
            }
        }
        else {
            System.out.println("You win! The computers cards were: ");
            displayCards(Computer);
            displayCombo(EvaluateCombos(Computer));
        }
    }
    public static void shuffle(Cards[] deck){
        //shuffle the cards
        for(int i = 0; i<deck.length; i++){
            int index = (int)(Math.random()*deck.length);
            Cards temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
        }
    }
    public static void  displayTitle(PlayerAccount user){
        System.out.println("Welcome " + user.getName()+ " to Ren's Casino!! -By Ren");
        System.out.println("please select what game you want to play! or 999 to exit");
        for (int i = 0; i < 5; i++){
            System.out.print("#");
        }
        System.out.println();
        System.out.println("press 1 to play high and low");
        System.out.println("press 2 to play poker");
        for (int i = 0; i<5; i++){
            System.out.print("#");
        }

        System.out.println();
        System.out.println("Current Winnings: " + user.getMoney());
    }
    public static void displayCards(Cards[] hand){
        for(int i =0; i < hand.length; i++){
            System.out.println(i+1 + ": " + hand[i].getNumber() + " of " +  hand[i].getSuits());
        }
    }
    public static int EvaluateCombos(Cards[] hand){
        //turn the entire set of cards into values
        int[] valueofhand = new int[5];
        int[] valueofsuits = new int[5];
        for (int i = 0; i <5; i++){
            valueofhand[i] = hand[i].toValueNumbers();
            valueofsuits[i] = hand[i].toSuits();
        }
        int[] valueofhand1 = sortback(valueofhand);
        int[] valueofsuits1 = sortback(valueofsuits);

        if (isRoyalFlush(valueofhand1, valueofsuits1)){
            return 10;
        }
        if (isStraightFlush(valueofhand1,valueofsuits1)){
            return 9;
        }
        if (isFourKind(valueofhand1)){
            return 8;
        }
        if (isFullHouse(valueofhand1)){
            return 7;
        }
        if (isFlush(valueofsuits1)){
            return 6;
        }
        if (isStraight(valueofhand1)){
            return 5;
        }
        if (isThreeKind(valueofhand1)){
            return 4;
        }
        if(isTwoPair(valueofhand1)){
            return 3;
        }
        if (isPair(valueofhand1)){
            return 2;
        }
        else {
            return 1;
        }

    }
    public static int[] sortback(int[] list){
        Arrays.sort(list);
        int[] reversedlist = new int[list.length];

        for (int i = 0, k=list.length-1; i < list.length; i++, k--){
            reversedlist[i] = list[k];
        }
        return reversedlist;
    }
    public static boolean isRoyalFlush(int[] numbers, int[]suits){
        for (int i = 0; i < suits.length; i++){
            if(suits[0] != suits[i]){
                return false;
            }
        }
        for (int k = 14, i = 0; i < numbers.length; k--, i++){
            if(numbers[i] != k){
                return false;
            }
        }
        return true;
    }
    public static boolean isStraightFlush(int[]numbers, int[]suits){
        for (int i = 0; i < suits.length; i++){
            if(suits[0] != suits[i]){
                return false;
            }
        }
        for (int i = 0; i < numbers.length-1; i++){
            if(numbers[i+1]!= numbers[i]- 1){
                return false;
            }
        }
        return true;
    }
    public static boolean isFourKind(int[] numbers){
        int numbercompare = 0;
        int count = 0;
        for (int i = 0; i < numbers.length; i++){
            for (int j = i+1; j < numbers.length; j++){
                if (numbers[i] == numbers[j]){
                    count++;
                }
            }
        }
        if (count > 4){
            return true;
        }
        return false;

    }
    public static boolean isFullHouse(int[] numbers){
        if (numbers[0] == numbers[1] && numbers[1] == numbers[2]){
            if (numbers[3] == numbers[4]){
                return true;
            }
        }
        if (numbers[0] == numbers[1]){
            if (numbers[2] == numbers[3] && numbers[3] == numbers[4]){
                return true;
            }
        }
        return false;
    }
    public static boolean isFlush(int[] suits){
        for (int i = 0; i<5; i ++){
            if (suits[i] != suits[0]){
                return false;
            }
        }
        return true;
    }
    public static boolean isStraight(int[] numbers){
        for (int i = 0; i < 5; i++){
            if (i == 4){
                continue;
            }
            if (numbers[i] != numbers[i+1]+1){
                return false;
            }
        }
        return true;
    }
    public static boolean isThreeKind(int[] numbers){
        for (int i = 0, j = 1, k = 2; k <numbers.length; i++, j++, k++){
            if (numbers[i] == numbers[j] && numbers[j] == numbers[k]){
                return true;
            }
        }
        return false;
    }
    public static boolean isTwoPair(int[] numbers){
        int count = 0;
        for (int i = 0; i < numbers.length; i++){
            if (i==4){
                break;
            }
            if (numbers[i] == numbers[i+1]){
                i++;
                count++;
            }
        }
        if (count==2){
            return true;
        }
        return false;
    }
    public static boolean isPair(int[] numbers){
        int count = 1;
        int numDup = numbers[0];
        for(int i = 1; i < numbers.length; i++){
            if (numbers[i]==numDup){
                count++;
            }
            numDup = numbers[i];
        }
        if (count>1){
            return true;
        }
        return false;
    }
    public static int returnTheDuplicate(int[] numbers){
        int count = 1;
        int numDup = 0;
        for(int i = 0; i < numbers.length; i++){
            if (numbers[i]==numDup){
                count++;
            }
            numDup = numbers[i];
        }
        if (count>1){
            return numDup;
        }
        return 0;
    }
    public static void displayCombo(int number){

        if (number == 10){
            System.out.println("Royal Flush");
        }
        if (number == 9){
            System.out.println("Straight Flush");
        }
        if (number == 8){
            System.out.println("Four of a kind");
        }
        if (number == 7){
            System.out.println("Full House");
        }
        if (number == 6){
            System.out.println("Flush");
        }
        if (number == 5){
            System.out.println("Straight");
        }
        if (number == 4){
            System.out.println("Three kind");
        }
        if(number == 3){
            System.out.println("Two pair");
        }
        if (number == 2){
            System.out.println("One pair");
        }
        else {
            System.out.println("No Combo");
        }
    }
    public static int highCard(Cards[] hand){
//        int[] valueofhand = new int[5];
//        int[] valueofsuits = new int[5];
//        for (int i = 0; i <5; i++){
//            valueofhand[i] = hand[i].toValueNumbers();
//            valueofsuits[i] = hand[i].toSuits();
//        }
//        int highcard = 0;
//        for (int i =0; i < valueofhand.length; i ++){
//            if (valueofhand[i] > highcard){
//                highcard = valueofhand[i];
//            }
//        }
//        return highcard;
        int[] valueofhand=new int[5];
        int highcard=0;
        for(int i=0;i<5;i++){
            if (hand[i].toValueNumbers()>highcard){
                highcard=hand[i].toValueNumbers();
            }
        }
        return highcard;
    }
}
