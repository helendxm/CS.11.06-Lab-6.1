import java.io.*;
import java.util.Scanner;

public class AdventureTime {
    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int challengeOne = challengeOne("inputOneTwo.txt");
//        System.out.println("The answer to Challenge 1 is " + challengeOne + ".");
        int challengeTwo = challengeTwo( "inputOneTwo.txt");
//        System.out.println("The answer to Challenge 2 is " + challengeTwo + ".");
        int challengeThree = challengeThree("inputThreeFour.txt");
//        System.out.println("The answer to Challenge 3 is " + challengeThree + ".");
        int challengeFour = challengeFour("inputThreeFour.txt");
//        System.out.println("The answer to Challenge 4 is " + challengeFour + ".");

        writeFileAllAnswers("allAnswers.txt", challengeOne, challengeTwo, challengeThree, challengeFour);
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int counter = 0;
        int data[] = readFile(fileName);
        for (int i=1; i<data.length; i++){
            if (data[i]>data[i-1]){
                counter++;
            }
        }
        return counter;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int counter = 0;
        int data[] = readFile(fileName);
        for (int i=0; i<data.length-3; i++){
            if (data[i] + data[i+1] + data[i+2] < data[i+1] + data[i+2] + data[i+3]){
                counter++;
            }
        }
        return counter;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        int horizontal = 0;
        int depth = 0;

        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            String[] direction = scanner.nextLine().split(" ");
            int value = Integer.parseInt(direction[1]);

            if (direction[0].equals("forward")){
                horizontal += value;
            }
            else if (direction[0].equals("down")){
                depth += value;
            }
            else if (direction[0].equals("up")){
                depth -= value;
            }
        }
        scanner.close();
        return horizontal * depth;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        int horizontal = 0;
        int depth = 0;
        int aim = 0;

        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            String[] direction = scanner.nextLine().split(" ");
            int value = Integer.parseInt(direction[1]);

            if (direction[0].equals("forward")){
                horizontal += value;
                depth += aim + value;
            }
            else if (direction[0].equals("down")){
                aim += value;
            }
            else if (direction[0].equals("up")){
                aim -= value;
            }
        }
        scanner.close();
        return horizontal * depth;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}