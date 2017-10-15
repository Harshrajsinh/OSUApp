package com.osuapp.constants;

public class ApplicationConstants {

	//MongoDB Connection Constants 
	public static String LOCALHOST = "localhost";
	public static int PORT = 27017;
	public static String DATABASE_NAME = "osuapp";
	
	//MongoDB Query Constants 
	public static String FIELD_EMAIL = "email";
	public static String FIELD_NAME = "name";
	public static String FIELD_COURSE_OFFERING = "course_offering";
	
	//API Address Constants 
	public static String GET_USER_END_POINT = "/api/getUser/";
	public static String GET_ALL_USERS = "/getAllUsers";
	public static String GET_USER = "/getUser/{email:.+}";
	public static String ADD_USER = "/addUser";
	public static String GET_TUTOR = "/getTutor/{subjectName}";
	
	//Front-End localhost constant
	public static String FRONT_END_LOCALHOST = "http://localhost:4200";
}
