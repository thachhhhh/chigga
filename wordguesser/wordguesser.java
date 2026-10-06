import java.util.Scanner;
public class wordguesser {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String secretWord = "";
      int attempts =5;
      System.out.println("Welcome to the Word Guesser Game!");
      System.out.println("----Rules----\n+)You let your friend enter the word for you to guess\n+)No peeking\n+)The guesser have 5 attempts before losing.");
      while (true){
          System.out.print("Enter the guess word today: ");
          secretWord = scanner.nextLine().toLowerCase();
          if (secretWord.matches("[a-zA-Z]+")){
            break;
          }
          else{
            System.out.println("Invalid word! Words can't be numbers or special characters!");
          }
      }
      
      for (int i = 0; i < 30; i++){
          System.out.println("");
      }
      char[] progress = new char[secretWord.length()];
      for (int i = 0; i < progress.length;i++){
          progress[i]='_';
      }
        //main game loop
      while(attempts > 0){
          System.out.print("Word: ");
          for (char c: progress){
            System.out.print(c+"");
          }
          System.out.println("\nRemainning attempts: "+ attempts);
          if (String.valueOf(progress).equals(secretWord)){
            System.out.println("Congratulations you have guessed the word: " + secretWord);
            return;
          }
          System.out.print("Guess a letter: ");
          String input = scanner.nextLine().toLowerCase();
          if (input.isEmpty()) {
              System.out.println("Please enter something!\n");
              continue;
            }
          char guess = input.charAt(0);
          if (!Character.isLetter(guess)){
            System.out.println("Please guess using a word not number or special characters!");
            continue;
          } 
          boolean correctedGuess = false;
          for (int i = 0; i < secretWord.length();i++){
            if (secretWord.charAt(i)== guess && progress[i]=='_'){
              progress[i]= guess;
              correctedGuess = true;
            }
          }
          if (correctedGuess){
            System.out.println("-------------------------------------");
            System.out.println("\nNice! That letter is in the word\n");
            System.out.println("-------------------------------------");
          } else{
            attempts--;
            if (attempts > 0) {
              System.out.println("-------------------------------------");
              System.out.println("\nNah, try again.\n");
              System.out.println("-------------------------------------");
            }

          }
      }
      System.out.println("GAME OVER! You have "+ attempts + " attempts left. The word was: " + secretWord);
      scanner.close();
    }
} 
