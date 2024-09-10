package api.endpoints;

// Swagger URI --> https://petstore.swagger.io/

/* Create User (Post) :	https://petstore.swagger.io/user
 * Get User (Get)  :	https://petstore.swagger.io/user/{username}
 * Update User (Put)  :	https://petstore.swagger.io/user/{username}
 * Delete User (Delete)  :	https://petstore.swagger.io/user/{username}
 */

	// CONTAINS URL'S

public class Routes {
	
	public static String base_URL = "https://petstore.swagger.io/v2";
	
	// USER MODULE
	
	public static String post_url = base_URL+"/user";
	public static String get_url = base_URL+"/user/{username}";
	public static String update_url = base_URL+"/user/{username}";
	public static String delete_url = base_URL+"/user/{username}";
	
	// STORE MODULE
	
	// Here you will create store module URL's
	
	// PET MODULE
	
	// Here you will create pet module URL's


	
	

}
