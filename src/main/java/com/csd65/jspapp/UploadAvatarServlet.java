package com.csd65.jspapp;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadAvatarServlet extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		
		//Access the context param from web.xml
		ServletContext context = req.getServletContext();
		String filePath = context.getInitParameter("avatar-location");
		
		
		//Uploading the file.
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		
		try {
			
			List<FileItem> fileItems = servletFileUpload.parseRequest(req);
			
			for (FileItem fileItem : fileItems) {
				
				if(fileItem.isFormField() == false) {
					System.out.println("Yeah ---> "+fileItem.getName());
					
					File avatarFile = new File(filePath+fileItem.getName());
					
					fileItem.write(avatarFile);
					
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR : "+e.getMessage());
		}
		
	}

}
