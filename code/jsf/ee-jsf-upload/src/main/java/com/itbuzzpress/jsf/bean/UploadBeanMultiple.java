package com.itbuzzpress.jsf.bean;

import jakarta.enterprise.inject.Model;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.http.Part;

import java.io.*;
import java.nio.file.Paths;
import java.util.List;

@Model
public class UploadBeanMultiple {
    private List<Part> files;

    public List<Part> getFiles() {
        return files;
    }

    public void setFiles(List<Part> files) {
        this.files = files;
    }

    public String uploadFile() throws IOException {

        for (Part part : files) {
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();


            // Extract file name from content-disposition header of file part

            String basePath = "/tmp/";
            File outputFilePath = new File(basePath + fileName);
            // Copy uploaded file to destination path
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                inputStream = part.getInputStream();
                outputStream = new FileOutputStream(outputFilePath);

                int read = 0;
                final byte[] bytes = new byte[1024];
                while ((read = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
                printMessage("Success! File upload completed!");
            } catch (IOException e) {
                e.printStackTrace();
                printMessage("Error! File upload error!");
            } finally {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        }
        return null;
    }

    private void printMessage(String message) {

        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, message, null);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);


    }

    private String getFileName(Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim()
                        .replace("\"", "");
            }
        }
        return null;
    }
}