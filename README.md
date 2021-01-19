Jonathan White

   Files:
     MSCS.java, README.md, Algorithm_Complexity.pdf, COMP3270-ProgrammingHW.pdf, jonathanwhite_phw_output.xlsx
   Explanation of Compiling:
     VS Code, JGRASP & VIM was used to write and debug the program.
     "javac" in terminal was used to compile file.
   Description:
     A project which analysis 4 algorithms on on an array of size 10,15,20,...100. I gathered data on each algorithm
     and populated a matrix with this data. After, I placed the data from the matrix into a txt file (idea from a friend),
     I used this to create graphs in excel depicting each algorithms complexity.
   Assumptions of Each Algorithm:
     Algorithm-1: The algorithm appears to have 2 inner loops within its initial loop. Seems to be an inefficient
     brute force method.


     Algorithm-2: This algorithm is also inefficient, but slightly more efficient than the first. It only has one inner loop 
     and keeps track of the maxSoFar variable, which allows for the better efficiency when compared to Algorithm-1.


     Algorithm-3: A recursive algorithm much like merge sort. It uses the divide and conquer method and performs
     recursion on both parts equally. This algorithm has O(nlgn) complexity.


     Algorithm-4: The most efficient algorithm of the 4. This algorithm has one loop the size of the array. It works by 
     keeping track of the max at each and comparing it to the maxSoFar. This added variable allows O(n) time.
  Graph Explanation:
    This is a graphical depiciton of the algorithms time complexity. The graph that was generated fit my expectations based on my predictions.
  Certification Statement:
    I certify that I wrote the code I am submitting. I did not copy whole or parts of it from another student or have another 
	person write the code for me. Any code I am reusing in my program is clearly marked as such with its source clearly identified in comments.
