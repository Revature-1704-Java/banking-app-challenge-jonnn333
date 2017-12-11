

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class File_ReadWrite {
    
    File_ReadWrite() {
        // empty constructor; using later
    }

    void readFile (String fileToRead, String accID) {
        //Scanner scan = null;
        BufferedReader buff = null;

        try(FileReader fr = new FileReader(fileToRead)) {
            /*
            int i;
            while ((i = fr.read()) != -1) {
              System.out.print((char) i);
            }
            */

            System.out.println("Reading: "+fileToRead);

            buff = new BufferedReader(new FileReader(fileToRead+".txt"));
            ArrayList<String> words = new ArrayList<>();
            String lineJustFetched = null;
            String[] wordsArray;

            while(true) {
                lineJustFetched = buff.readLine();
                if(lineJustFetched == null) {  
                    break; 
                }
                else{
                    wordsArray = lineJustFetched.split("\t");
                    for(String each : wordsArray){
                        if(!"".equals(each)){
                            words.add(each);
                        }
                    }
                }
            }

            if (accID.equals(words.get(2))) {
                System.out.println("fetched: "+ fileToRead);
                // authenticated; get info
            }

            else if(accID.equals("none")) {
                words.add("temporary12345");
            }
            
            else {
                System.out.println("not authenticated");
                // not authenticated; flag
            }

            buff.close();

          } catch (FileNotFoundException ex) {
            ex.printStackTrace();
          } catch (IOException ex) {
            ex.printStackTrace();
          } finally {
          }
    }

    void writeFile (String fileToWrite, String newBalance, String accID) {

        try(FileWriter fw = new FileWriter(fileToWrite+".txt")) {
            System.out.println("Saving: "+fileToWrite);
            fw.write(fileToWrite + "\t" + newBalance + "\t" + accID);
            fw.close();
        } 
        catch (IOException ex) {
             ex.printStackTrace();
        }
        finally {
        }
    }
}