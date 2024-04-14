
package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
    
    @Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class)
    //public void testPostUser(String userID, String userName, String fname, String lname, String useremail, String pwd, String ph) {
    public void testPostUser(String[] userData) {
    	
        // Extracting data from the array
        String userID = userData[0];
        String userName = userData[1];
        String fname = userData[2];
        String lname = userData[3];
        String useremail = userData[4];
        String pwd = userData[5];
        String ph = userData[6];
        
        User userPayload = new User();
        
        userPayload.setId(Integer.parseInt(userID));
        userPayload.setUsername(userName);
        userPayload.setFirstName(fname);
        userPayload.setLastName(lname);
        userPayload.setEmail(useremail);
        userPayload.setPassword(pwd);
        userPayload.setPhone(ph);   
    
        Response response = UserEndPoints.createUser(userPayload);
        
        // Basic assertion for status code
        Assert.assertEquals(response.getStatusCode(), 200, "Failed to create user: " + userName);
        
        // Additional assertions can be added here to verify response body, etc.
    }
    
    @Test(priority=2, dataProvider="UserNames", dataProviderClass=DataProviders.class)
    public void testDeleteUserByName(String userName) {
        Response response = UserEndPoints.deleteUser(userName);
        
        // Basic assertion for status code
        Assert.assertEquals(response.getStatusCode(), 200, "Failed to delete user: " + userName);
        
        // Additional assertions can be added here if needed
    }
}
