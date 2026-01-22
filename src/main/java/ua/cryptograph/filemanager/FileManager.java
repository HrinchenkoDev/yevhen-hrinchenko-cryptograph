package ua.cryptograph.filemanager;

import ua.cryptograph.exceptionsapp.FileProcessingException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    public String readFile(String filePath) {
        try{
            return Files.readString(Path.of(filePath));
        }catch (IOException e){
            throw new FileProcessingException("Could not read file at path: " + filePath, e);
        }
    }

    public void writeFile(String filePath, String content, String suffix) {
        try{
            String clearPath = filePath.replace("[ENCRYPTED]", "").replace("[DECRYPTED]", "");

            int dotIndex = clearPath.lastIndexOf(".");
            String newPath;

            if(dotIndex != -1) {
                newPath = clearPath.substring(0, dotIndex) + suffix + clearPath.substring(dotIndex);
            }else {
                newPath = clearPath + suffix;
            }

            Files.writeString(Path.of(newPath), content);
            System.out.println("File saved: " + newPath);
        }catch (IOException e) {
            throw new FileProcessingException("Failed to write file: " + filePath, e);
        }
    }
}
