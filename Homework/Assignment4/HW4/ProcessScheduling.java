package HW4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author SHAO
 */
public class ProcessScheduling {
    public static void main(String[] args) throws FileNotFoundException {
        
        //Input and Output txt files
        String input_txt = "process_scheduling_in.txt"; //If file not found, please go to Line 121
        String output_txt = "./src/HW4/process_scheduling_out.txt"; //User can change path here
        
        //Init current time and total wait time
        int currentTime = 0;
        int totalWaitTime = 0;
        
        //Set running status
        boolean running = false;
        
        //Declare variable: process list to store the data from input.txt
        List<Process> processList = readFile(input_txt);
        
        //Write output files
        File outputFile = new File(output_txt);
        PrintWriter fileOutput = new PrintWriter(outputFile);
        
        //Process list, used to calculate average wait time
        int size = processList.size();
        
        //Write all process detail info into output.txt
        for (Process p : processList) {
            fileOutput.println("Id = " + p.getId() + ", priority = " + p.getPriority() + 
                             ", duration = " + p.getDuration() + ", arrival time = " + p.getArrivalTime());
        }       
        fileOutput.println();
        
        //Declare HeapPriorityQueue, used to store the process from processList
        HeapPriorityQueue<Integer, Process> priorityQueue = new HeapPriorityQueue<>();

        //Declare variable: min priority process in Q (Priority Queue)
        Process minPriorityProcess = null;
        
        //Keep the loop when processList isn't empty or priorityQueue isn't empty or running status is true
        while (processList.isEmpty()==false || priorityQueue.isEmpty()==false || running == true) {
            
            //Do finding earliest arrival time process when processList isn't empty
            if (processList.isEmpty()==false) {
                //Finding earliest arrival time
                Process p = findEarliestArrivalTime(processList);
                //If process's arrival time <= current time, remove this process from processList into priorityQueue
                if (p.getArrivalTime() <= currentTime) {
                    processList.remove(p);
                    
                    //Check whether processList will be empty
                    if (processList.isEmpty()) {
                        fileOutput.println("\nProcess List becomes empty at time " + currentTime + "\n");
                    }
                    //Insert into priorityQueue
                    priorityQueue.insert(p.getPriority(), p);
                }
            }
            
            //Finding min priority process from priorityQueue
            if (priorityQueue.isEmpty()==false && running == false) {
                //Assign new value
                minPriorityProcess = priorityQueue.removeMin().getValue();
                
                //Changing running status
                running = true;
                
                //Calculating this process's wait time
                int waitTime = currentTime - minPriorityProcess.getArrivalTime();
                //Set wait time for this process
                minPriorityProcess.setWaitTime(waitTime);
                //Calculating total wait time
                totalWaitTime += waitTime;
                
                fileOutput.println("Process removed from queue is: " + minPriorityProcess.getId() + 
                                   ", at time " + currentTime + ", wait time = " + minPriorityProcess.getWaitTime() + 
                                   ", Total wait time = " + (double)totalWaitTime);
                
                fileOutput.println("Process id = " + minPriorityProcess.getId() + 
                                   "\n\tPriority = " + minPriorityProcess.getPriority() + 
                                   "\n\tArrival = " + minPriorityProcess.getArrivalTime() + 
                                   "\n\tDuration = " + minPriorityProcess.getDuration());
            }
            //Update current time
            currentTime++;
            
            //Check whether this process finished
            if (minPriorityProcess != null && currentTime == (minPriorityProcess.getArrivalTime()
                    + minPriorityProcess.getDuration()
                    + minPriorityProcess.getWaitTime())) {
                //Changing running status
                running = false;
                
                fileOutput.println("Process " + minPriorityProcess.getId() + " finished at time " + currentTime + "\n");
            }
        }
        
        fileOutput.println("Total wait time = " + (double)totalWaitTime +
                           "\nAverage wait time = " + ((double)totalWaitTime / size));
        
        //Close file output operation
        fileOutput.close();
        
        System.out.println("All in output txt file.");
    }
    
    //Function: read txt data and store into Process model
    public static List<Process> readFile(String file_name) throws FileNotFoundException {
        //Read txt file
        
        //In Windows
        //File iFile = new File(file_name);
        //Scanner fileInput = new Scanner(iFile);
        
        //In Mac OS
        Scanner fileInput = new Scanner(new File(ProcessScheduling.class.getResource(file_name).getFile()));
        
        List<Process> list = new ArrayList<>();

        while (fileInput.hasNext()) {
            //Split the line data
            String[] split = fileInput.nextLine().split("\\s+");
            
            //Create every Process Object
            Process p = new Process(Integer.parseInt(split[0]),
                    Integer.parseInt(split[1]),
                    Integer.parseInt(split[2]),
                    Integer.parseInt(split[3]));
            //Add into processList to return back
            list.add(p);
        }
        fileInput.close();
        return list;
    }
    
    //Finding the earliest arrive time process
    public static Process findEarliestArrivalTime(List<Process> processList) {
        //Sorting the list to find the earliest one
        processList.sort(Comparator.comparing(Process::getArrivalTime));
        //Return the first one process
        return processList.get(0);
    }
}
