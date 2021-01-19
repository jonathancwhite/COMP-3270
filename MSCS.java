/** 
 * AUTHOR: Jonathan White
 * COURSE: COMP 3270-002
 * DATE: November 1, 2020
 * Revision: 2
 **/

import java.util.Arrays;
import java.io.File;
import java.lang.Math;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.lang.StringBuilder;

public class MSCS {

  /*********************************** CLASS VARIABLES ******************************************/
  private Integer[][] algorithmSeq;

  private long[][] avgTime = new long[19][8];

  private ArrayList<Integer> firstArr = new ArrayList<Integer>(); 
  private ArrayList<Integer> intSequence10 = new ArrayList<Integer>();
  private ArrayList<Integer> intSequence15 = new ArrayList<Integer>();
  private ArrayList<Integer> intSequence20 = new ArrayList<Integer>();
  private ArrayList<Integer> intSequence25 = new ArrayList<Integer>();
  private ArrayList<Integer> intSequence30 = new ArrayList<Integer>();
  private ArrayList<Integer> intSequence35 = new ArrayList<Integer>();
  private ArrayList<Integer> intSequence40 = new ArrayList<Integer>();
  private ArrayList<Integer> intSequence45 = new ArrayList<Integer>();
  private ArrayList<Integer> intSequence50 = new ArrayList<Integer>();
  private ArrayList<Integer> intSequence55 = new ArrayList<Integer>();
  private ArrayList<Integer> intSequence60 = new ArrayList<Integer>();
  private ArrayList<Integer> intSequence65 = new ArrayList<Integer>();
  private ArrayList<Integer> intSequence70 = new ArrayList<Integer>();
  private ArrayList<Integer> intSequence75 = new ArrayList<Integer>();
  private ArrayList<Integer> intSequence80 = new ArrayList<Integer>();
  private ArrayList<Integer> intSequence85 = new ArrayList<Integer>();
  private ArrayList<Integer> intSequence90 = new ArrayList<Integer>();
  private ArrayList<Integer> intSequence95 = new ArrayList<Integer>();
  private ArrayList<Integer> intSequence100 = new ArrayList<Integer>();

  /**
   * CONSTRUCTOR.
   **/
  public MSCS() {
    generateRandomNumbers();
    generateAlgorithmSequence();
    populateMatrix();
  }

  /******************************** FUNCTIONS ****************************************************/

  /**
   * This will take a file from user and add all integers in file
   * onto an ArrayList. Uses comma as the delimiter in order
   * to break apart the line from the Scanner obj.
   * @param fileName - is used.
   * @return nothing - this will populate the firstArr.
   **/
  public void readFile(String fileName) throws IOException{
    BufferedReader reader = new BufferedReader(new FileReader(fileName));
    while (true) {
      String line = reader.readLine();
      if (line == null)
        break;
      String[] numbers = line.split(",");
      for (String num : numbers) {
        firstArr.add(Integer.parseInt(num));
      }
    }
    reader.close();
  }

  /**
   * Generates a string which displays the algorithm used and the answer recieved.
   * It will apply all the algorithm on the firstArr.
   * @param none.
   * @return str - is used.
   **/
  public void printEachAlgorithm() {
    StringBuilder str = new StringBuilder();
    str.append("algorithm-1: " + Algorithm_1(firstArr.toArray(new Integer[firstArr.size()])) + "; ");
    str.append("algorithm-2: " + Algorithm_2(firstArr.toArray(new Integer[firstArr.size()])) + "; ");
    str.append("algorithm-3: " + MaxSum(firstArr.toArray(new Integer[firstArr.size()]), 0, firstArr.size() - 1) + "; ");
    str.append("algorithm-4: " + Algorithm_4(firstArr.toArray(new Integer[firstArr.size()])) + "; ");
    System.out.println(str.toString());
  }


  /**
   * This function will allow for the generateRandomNumbers to have 
   * less difficulty in readability. 
   * @param none.
   * @return a number from {-100 to 100}
   **/
  public int randomNumber() {
    return (int) (Math.random() * 100 * ((Math.random()*100 > 33) ? 1 : -1));
  }


  /**
   * Generate 19 integer sequences that obtain random numbers within
   * the range{-100 - 100}
   * @param len - length of the sequence.
   * @return none
   **/
  public void generateRandomNumbers() {
    for (int i = 0; i < 10; i++) 
      intSequence10.add(randomNumber());
    for (int i = 0; i < 15; i++)
      intSequence15.add(randomNumber());
    for (int i = 0; i < 20; i++) 
      intSequence20.add(randomNumber());
    for (int i = 0; i < 25; i++)
      intSequence25.add(randomNumber());
    for (int i = 0; i < 30; i++)
      intSequence30.add(randomNumber());
    for (int i = 0; i < 35; i++)
      intSequence35.add(randomNumber());
    for (int i = 0; i < 40; i++)
      intSequence40.add(randomNumber());
    for (int i = 0; i < 45; i++)
      intSequence45.add(randomNumber());
    for (int i = 0; i < 50; i++)
      intSequence50.add(randomNumber());
    for (int i = 0; i < 55; i++)
      intSequence55.add(randomNumber());
    for (int i = 0; i < 60; i++)
      intSequence60.add(randomNumber());
    for (int i = 0; i < 65; i++)
      intSequence65.add(randomNumber());
    for (int i = 0; i < 70; i++)
      intSequence70.add(randomNumber());
    for (int i = 0; i < 75; i++)
      intSequence75.add(randomNumber());
    for (int i = 0; i < 80; i++)
      intSequence80.add(randomNumber());
    for (int i = 0; i < 85; i++)
      intSequence85.add(randomNumber());
    for (int i = 0; i < 90; i++)
      intSequence90.add(randomNumber());
    for (int i = 0; i < 95; i++)
      intSequence95.add(randomNumber());
    for (int i = 0; i < 100; i++)
      intSequence100.add(randomNumber());
  }


  /**
   * Generates the algorithm sequence into arrays so that it can be used with the algorithms.
   **/
  private void generateAlgorithmSequence() {
    algorithmSeq = new Integer[][]{intSequence10.toArray(new Integer[intSequence10.size()]), intSequence15.toArray(new Integer[intSequence15.size()]), intSequence20.toArray(new Integer[intSequence20.size()]), intSequence25.toArray(new Integer[intSequence25.size()]), intSequence30.toArray(new Integer[intSequence30.size()]), intSequence35.toArray(new Integer[intSequence35.size()]), intSequence40.toArray(new Integer[intSequence40.size()]), intSequence45.toArray(new Integer[intSequence45.size()]), intSequence50.toArray(new Integer[intSequence50.size()]), intSequence55.toArray(new Integer[intSequence55.size()]), intSequence60.toArray(new Integer[intSequence60.size()]), intSequence65.toArray(new Integer[intSequence65.size()]), intSequence70.toArray(new Integer[intSequence70.size()]), intSequence75.toArray(new Integer[intSequence75.size()]), intSequence80.toArray(new Integer[intSequence80.size()]), intSequence85.toArray(new Integer[intSequence85.size()]), intSequence90.toArray(new Integer[intSequence90.size()]), intSequence95.toArray(new Integer[intSequence95.size()]), intSequence100.toArray(new Integer[intSequence100.size()]) };
  }

  /**
   * This function will populate the 19x8 matrix with average time and 
   * complexities within each element.
   **/
  private void populateMatrix() {
    for (int i = 0; i  < 19; i++) 
      avgTime[i][0] = calculateAvgTime(algorithmSeq[i], 1);
    for (int i = 0; i < 19; i++) 
      avgTime[i][1] = calculateAvgTime(algorithmSeq[i], 2);
    for (int i = 0; i < 19; i++)
      avgTime[i][2] = calculateAvgTime(algorithmSeq[i], 3);
    for (int i = 0; i < 19; i++)
      avgTime[i][3] = calculateAvgTime(algorithmSeq[i], 4);
    for (int i = 0; i < 19; i++)
      avgTime[i][4] = calculateComplexity(algorithmSeq[i].length, 1);
    for (int i = 0; i < 19; i++)
      avgTime[i][5] = calculateComplexity(algorithmSeq[i].length, 2);
    for (int i = 0; i < 19; i++)
      avgTime[i][6] = calculateComplexity(algorithmSeq[i].length, 3);
    for (int i = 0; i < 19; i++)
      avgTime[i][7] = calculateComplexity(algorithmSeq[i].length, 4);
  }

  /**
   * This method will assist with the implementation of populateMatrix.
   * It will accomplish this by calculating each complexity of the algorithms.
   *@param arrLength - array length.
   *@param arrNumber - array number.
   *@return complexity.
   */
  private long calculateComplexity(int arrLength, int arrNumber) {
    if (arrNumber == 1) {
      return (long)((Math.pow(arrLength,3)*12)+(Math.pow(arrLength,2)*12)+(2*arrLength)+3);
    }
    else if (arrNumber == 2) {
      return (long)((Math.pow(arrLength,2)*11)+(arrLength*13)+4);
    }
    else if (arrNumber == 3) {
      return (long)((arrLength*(Math.log10(arrLength)/Math.log10(2))+(25*arrLength/2)+13));
    }
    else {
      return (long)((11*arrLength)-6);
    }
  }


  /**
   * Write to an outputfile named "guizar_phw_output.txt.
   * @param fileName - is used.
   * @return - none
   **/
  private void writeFile(String fileName) throws IOException{
    BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName)));
    bw.write("algorithm-1,algorithm-2,algorithm-3,algorithm-4,T1(n),T2(n),T3(n),T4(n)");
    bw.newLine();
    for (int i = 0; i < 19; i++) {
      for (int j = 0; j < 8; j++) {
        bw.write(avgTime[i][j] + ",");
      }
      bw.newLine();
    }
    bw.close();
  }

  /**
   * Returns type long so that populateMatrix has easier readability. 
   * @param - seq is an array of each number sequence.
   * @param - algoNumber tells the method which algorithm to use.
   **/
  private long calculateAvgTime(Integer[] seq, int algoNumber) {
    if (algoNumber == 1) {
      long startTime = System.nanoTime();
      for (int i = 0; i < 1000; i++) 
        this.Algorithm_1(seq);
      long endTime = System.nanoTime();
      return (endTime-startTime)/1000;
    }
    else if (algoNumber == 2) {
      long startTime = System.nanoTime();
      for (int i = 0; i < 1000; i++) 
        this.Algorithm_2(seq);
      long endTime = System.nanoTime();
      return (endTime-startTime)/1000;
    }
    else if (algoNumber == 3) {
      long startTime = System.nanoTime();
      for (int i = 0; i < 1000; i++) 
        this.MaxSum(seq, 0, seq.length - 1);
      long endTime = System.nanoTime();
      return (endTime-startTime)/1000;
    }
    else {
      long startTime = System.nanoTime();
      for (int i = 0; i < 1000; i++)
        this.Algorithm_4(seq);
      long endTime = System.nanoTime();
      return (endTime-startTime)/1000;
    }
  }

  /**
   * First algorithm which implements MSCS.
   * @param - array X which is a set of arbitrary numbers X{-infinity to infinity}
   * @return - max sum within set X. 
   **/
  public int Algorithm_1(Integer[] X) {
    int maxSoFar = 0;
    for (int L = 0; L < X.length; L++) {
      for (int U = L; U < X.length; U++) {
        int sum = 0;
        for (int I = L; I <= U; I++) {
          sum = sum + X[I];
        }
        maxSoFar = Math.max(maxSoFar, sum);
      }
    }
    return maxSoFar;
  }

  /**
   * Second algorithm which implements MSCS.
   * @param - array X which is a set of arbitrary numbers X{-infinity to infinity}
   * @return - max sum within set X.
   **/
  public int Algorithm_2(Integer[] X) {
    int maxSoFar = 0;
    for (int L = 0; L < X.length; L++) {
      int sum = 0;
      for (int U = L; U < X.length; U++) {
        sum = sum + X[U];
        maxSoFar = Math.max(maxSoFar, sum); 
      }
    }
    return maxSoFar;
  }

  /**
   * Third algorithm which implements MSCS.
   * @param - array X which is a set of arbitrary numbers X{-infinity to infinity}
   * @return - max between the left max and right max.
   **/
  public int MaxSum(Integer[] X, int L, int U) {
    if (L > U) { 
      return 0;
    }
    if (L == U) {
      return Math.max(0, X[L]);
    }

    int M = (L + U) / 2;
    // Find max Left.
    int sum = 0; int maxToLeft = 0;
    for (int I = M; I >= L; I--) {
      sum = sum + X[I];
      maxToLeft = Math.max(maxToLeft, sum);
    }
    // Find max right.
    sum = 0; int maxToRight = 0;
    for (int I = (M+1); I <= U; I++) {
      sum = sum + X[I];
      maxToRight = Math.max(maxToRight, sum);
    }
    int maxCrossing = maxToLeft + maxToRight;

    int maxInA = MaxSum(X, L, M);
    int maxInB = MaxSum(X, M+1, U); 

    return Math.max(Math.max(maxCrossing, maxInA), maxInB);
  }


  /**
   * Fourth algorithm which implements MSCS.
   * @param - array X which is a set of arbitrary numbers x{-infinity to infinity}
   * @return - maxSoFar
   **/
  public int Algorithm_4(Integer[] X) {
    int maxSoFar = 0;
    int maxEndingHere = 0;
    for (int I = 0; I < X.length; I++) {
      maxEndingHere = Math.max(0, maxEndingHere + X[I]);
      maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }
    return maxSoFar;
  }



  /************************************* MAIN *******************************************/

  public static void main(String[] args) throws IOException{
    MSCS algo = new MSCS();
    algo.readFile("phw_input.txt");
    algo.printEachAlgorithm();
    algo.writeFile("jonathanwhite_phw_output.txt");
  }
} 
