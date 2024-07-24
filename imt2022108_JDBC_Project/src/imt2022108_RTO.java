//STEP 1. Import required packages

import java.sql.*;
import java.util.Scanner;

public class imt2022108_RTO {

   // Set JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost:3306/rto?useSSL=false";

   // Database credentials
   static final String USER = "root";// add your user
   static final String PASSWORD = "Education@123";// add password
   public static void main(String[] args) {
      Connection conn = null;
      Statement stmt = null;

      // STEP 2. Connecting to the Database
      try {
         Scanner sc=new Scanner(System.in);
         System.out.print("ENTER PASSWORD : ");
         String PASSWORD1 = sc.nextLine();

         if(PASSWORD1.equals(PASSWORD)==false){
            System.exit(0);
         }

         // STEP 2a: Register JDBC driver
         Class.forName(JDBC_DRIVER);
         // STEP 2b: Open a connection
         System.out.println("Connecting to database...");
         conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
         // STEP 2c: Execute a query
         System.out.println("Creating statement...");
         stmt = conn.createStatement();
         conn.setAutoCommit(false);

         while(true){
         System.out.println("---------------------------------------------------------------------------------");
         System.out.println("Here is a list of functionalities which you can choose from :                   |");
         System.out.println("                                                                                |");
         System.out.println("1 - Insert an Owner-Vehicle Pair                                                |");
         System.out.println("2 - Remove an Owner-Vehicle Pair                                                |");
         System.out.println("3 - Raise a new ticket(traffic fine)                                            |");
         System.out.println("4 - Get 'PENDING' or 'CLEARED' fines for a certain vehicle ID                   |");
         System.out.println("5 - List all vehicles with Insurance premium greater than a certain value       |");
         System.out.println("6 - Number of traffic fines issued for each violation type                      |");
         System.out.println("7 - Vehicle ID with maximum Fine amount (either due or paid)                    |");
         System.out.println("8 - List of all insurance companies                                             |");
         System.out.println("9 - List of vehicles registered in a particular year                            |");
         System.out.println("10 - Number of fines of vehicles of all brands                                  |");
         System.out.println("11 - List of owners who are born after a certain year                           |");
         System.out.println("12 - Average premium amount                                                     |");
         System.out.println("13 - Maximum and Minimum Insurance premium for each company                     |");
         System.out.println("                                                                                |");
         System.out.println("To Exit, use any other number                                                   |");
         System.out.println("---------------------------------------------------------------------------------");
         System.out.println("Enter your choice");
         int choice = sc.nextInt();
         sc.nextLine();
         if(choice<1 || choice>13){
            break;
         }
         switch (choice) {
            case 1:
                     System.out.println();
                     System.out.println("Enter the Owner details : ");
                     String OID=new String();
                     System.out.print("Owner_id : ");OID = sc.nextLine();
                     String TID=new String();
                     System.out.print("Token_id : ");TID = sc.nextLine();
                     String first_name=new String();
                     System.out.print("First_name : ");first_name = sc.nextLine();
                     String last_name=new String();
                     System.out.print("Last_name : ");last_name = sc.nextLine();
                     String addr=new String();
                     System.out.print("Address : ");addr = sc.nextLine();
                     String bdate=new String();
                     System.out.print("Bdate : ");bdate = sc.nextLine();
                     String phone=new String();
                     System.out.print("Phone number : ");phone = sc.nextLine();
               
                     String Ins1="INSERT INTO Owner (owner_id,token_id, v_id, first_name, last_name, address, b_date, phone_number) VALUES("+
                     OID+","+TID+","+"NULL,'"+first_name+"','"+last_name+"','"+addr+"','"+bdate+"','"+phone+"');";
                     stmt.executeUpdate(Ins1);

                     System.out.println("Enter the Vehicle details : ");
                     String VID=new String();
                     System.out.print("Vehicle_id : ");VID = sc.nextLine();
                     String make=new String();
                     System.out.print("Make : ");make = sc.nextLine();
                     String model=new String();
                     System.out.print("Model : ");model = sc.nextLine();
                     String year=new String();
                     System.out.print("Year : ");year = sc.nextLine();
                     String reg_date=new String();
                     System.out.print("Registration Date : ");reg_date = sc.nextLine();

                     String Ins2 = "INSERT INTO Vehicle (vehicle_id, o_id, make, model, year, registration_date) VALUES ("
                     +VID+",NULL,'"+make+"','"+model+"',"+year+",'"+reg_date+"');";
                     stmt.executeUpdate(Ins2);

                     String Update1="update owner set v_id="+VID+" where owner_id="+OID+" and "+"token_id = "+TID+";";
                     String Update2="update vehicle set o_id="+OID+" where vehicle_id="+VID+";";

                     stmt.executeUpdate(Update1);
                     stmt.executeUpdate(Update2);

                     conn.commit();
                     System.out.println();
                  break;
            case 2:
                     System.out.println();
                     System.out.println("Enter details for deletion");
                     System.out.print("Enter Owner ID : ");
                     String OID_2=sc.nextLine();
                     System.out.print("Vehicle ID : ");
                     String VID_2=sc.nextLine();

                     String UPDATE_2_1="update owner set v_id=NULL where owner_id="+OID_2+";";
                     String UPDATE_2_2="update vehicle set o_id=NULL where vehicle_id="+VID_2+";";

                     stmt.executeUpdate(UPDATE_2_1);stmt.executeUpdate(UPDATE_2_2);

                     String DELETE_2_1="delete from owner where owner_id="+OID_2+";";
                     String DELETE_2_2="delete from vehicle where vehicle_id="+VID_2+";";

                     stmt.executeUpdate(DELETE_2_1);stmt.executeUpdate(DELETE_2_2);
                     conn.commit();
                     System.out.println();
                  break;
            case 3:
                     System.out.println();
                     System.out.println("Enter the Ticket details : ");
                     String fine_id=new String();
                     System.out.print("Fine ID : ");fine_id = sc.nextLine();
                     String fine_amount=new String();
                     System.out.print("Fine amount (Enter decimal value): ");fine_amount = sc.nextLine();
                     String date=new String();
                     System.out.print("Date Issued : ");date = sc.nextLine();
                     String v_type=new String();
                     System.out.print("Violation Type : ");v_type = sc.nextLine();

                     String INSERT_4="INSERT into traffic_fines(fine_id,veh_id,fine_amount,date_issued,violation_type,fine_status)\r\n" +
                     "VALUES("+fine_id+", NULL, "+fine_amount+",'"+date+"','"+v_type+"','PENDING');";
                     System.out.println("Inserting ticket row with NULL Vehicle ID");
                     
                     stmt.executeUpdate(INSERT_4);
                     
                     System.out.println("Now, enter the Vehicle ID for which this ticket belongs");
                     String VID_4=new String();
                     System.out.print("Vehicle ID : ");VID_4=sc.nextLine();
                     
                     String UPDATE_4="update traffic_fines set veh_id="+VID_4+" where fine_id="+fine_id+";";
                     
                     stmt.executeUpdate(UPDATE_4);
                     
                     conn.commit();
                     System.out.println();
                  break;
            case 4:
                     System.out.println();
                     System.out.println("Enter appropriate details :");
                     System.out.print("Fine Status : ");
                     String fine_status=sc.nextLine();
                     System.out.print("Vehicle ID : ");
                     String Veh_ID=sc.nextLine();
      
                     String Query_4 = "SELECT tf.fine_amount,tf.veh_id,tf.violation_type,tf.fine_status\r\n" +
                                          "FROM Traffic_fines tf\r\n" +
                                          "WHERE tf.fine_status = '"+fine_status+"'\r\n" +
                                          "AND tf.veh_id = "+Veh_ID+";";
                     ResultSet rs = stmt.executeQuery(Query_4);
                     System.out.println("Here's the list of vehicles with status : "+fine_status);
                     System.out.println();
                     if(rs.next()==false){
                        System.out.println("EMPTY SET");
                     }
                     else{
      
                        // Retrieve by column name
                        Integer fine_amount_4 = rs.getInt("fine_amount");
                        Integer vid_4=rs.getInt("veh_id");
                        String v_type_4 = rs.getString("violation_type");
                        String f_status_4 = rs.getString("fine_status");
               
                        // Display values
                        System.out.print("owner_name: " + vid_4);
                        System.out.print(", violation_type: " + v_type_4);
                        System.out.print(", fine amount: " + fine_amount_4);
                        System.out.println(", fine status: " + f_status_4);

                     }
                     while (rs.next()) {
      
                        // Retrieve by column name
                        Integer fine_amount_4 = rs.getInt("fine_amount");
                        Integer vid_4=rs.getInt("veh_id");
                        String v_type_4 = rs.getString("violation_type");
                        String f_status_4 = rs.getString("fine_status");
               
                        // Display values
                        System.out.print("owner_name: " + vid_4);
                        System.out.print(", violation_type: " + v_type_4);
                        System.out.print(", fine amount: " + fine_amount_4);
                        System.out.println(", fine status: " + f_status_4);
                        }
                        System.out.println();
                        rs.close();
                  break;
            case 5:
                     System.out.println();
                     String premium_amount=new String();
                     System.out.print("Premium Lower limit : ");premium_amount = sc.nextLine();
                     
                     String Query_5=" select ip.vehi_id,v.make,v.model,ip.policy_number,ip.premium_amount FROM vehicle v\r\n" + //
                                 "    INNER JOIN insurance_policies ip ON ip.vehi_id=v.vehicle_id\r\n" + //
                                 "    WHERE ip.premium_amount>"+premium_amount+";";

                     ResultSet rs_5 = stmt.executeQuery(Query_5);
                     System.out.println("Here's the list of vehicles with premium greater than "+premium_amount);
                     System.out.println();
                     if(rs_5.next()==false){
                        System.out.println("EMPTY SET");
                     }
                     else{
                        Integer vid_5=rs_5.getInt("vehi_id");
                        String make_5 = rs_5.getString("make");
                        String model_5 = rs_5.getString("model");
                        String policy_number_5 = rs_5.getString("policy_number");
                        Integer prem_amount_5 = rs_5.getInt("premium_amount");
               
                        // Display values
                        System.out.print("Vehicle ID : " + vid_5);
                        System.out.print(", Make : " + make_5);
                        System.out.print(", Model: " + model_5);
                        System.out.print(", Policy Number : " + policy_number_5);
                        System.out.println(", Premium Amount : " + prem_amount_5);
                     }
                     while (rs_5.next()) {

                        // Retrieve by column name
                        Integer vid_5=rs_5.getInt("vehi_id");
                        String make_5 = rs_5.getString("make");
                        String model_5 = rs_5.getString("model");
                        String policy_number_5 = rs_5.getString("policy_number");
                        Integer prem_amount_5 = rs_5.getInt("premium_amount");
               
                        // Display values
                        System.out.print("Vehicle ID : " + vid_5);
                        System.out.print(", Make : " + make_5);
                        System.out.print(", Model: " + model_5);
                        System.out.print(", Policy Number : " + policy_number_5);
                        System.out.println(", Premium Amount : " + prem_amount_5);
                        }
                        System.out.println();
                        rs_5.close();

                     break;

            case 6:
                     System.out.println();
                     String Query_6="SELECT violation_type, COUNT(*) AS num_fines\r\n" + //
                                    "FROM Traffic_Fines\r\n" + //
                                    "GROUP BY violation_type;";
                     
                     ResultSet rs_6=stmt.executeQuery(Query_6);
                     if(rs_6.next()==false){
                        System.out.println("EMPTY SET");
                     }
                     else{
                        String v_type_6 = rs_6.getString("violation_type");
                        Integer count_6=rs_6.getInt("num_fines");

                        System.out.print("Violation Type : " + v_type_6);
                        System.out.println(", Number of fines : " + count_6);
                     }
                     while(rs_6.next()){
                        String v_type_6 = rs_6.getString("violation_type");
                        Integer count_6=rs_6.getInt("num_fines");

                        System.out.print("Violation Type : " + v_type_6);
                        System.out.println(", Number of fines : " + count_6);
                     }
                     System.out.println();
                     rs_6.close();
                     break;
            case 7:
                     System.out.println();
                     String Query_7="SELECT veh_id, fine_amount, fine_status\r\n" + //
                                    "FROM Traffic_Fines\r\n" + //
                                    "WHERE fine_amount = (SELECT MAX(fine_amount) FROM Traffic_Fines);";
                     ResultSet rs_7=stmt.executeQuery(Query_7);
                     if(rs_7.next()==false){
                        break;
                     }
                     Integer vid_7=rs_7.getInt("veh_id");
                     Integer fine_amt_7=rs_7.getInt("fine_amount");
                     String status_7=rs_7.getString("fine_status");
                     
                     if(status_7.equals("CLEARED")){
                        System.out.println("Maximum Fine amount : "+fine_amt_7+" is Paid By ID : "+vid_7);
                     }
                     else{
                        System.out.println("Maximum Fine amount : "+fine_amt_7+" to be Paid By ID : "+vid_7);
                     }
                     System.out.println();
                     rs_7.close();
                  break;
            case 8:
                     System.out.println();
                     System.out.println("Here's a list of all policy companies : ");
                     System.out.println();
                     String Query_8="select distinct insurance_company from insurance_policies;";
                     ResultSet rs_8 = stmt.executeQuery(Query_8);
                     while(rs_8.next()){
                        String insurance_company_8=rs_8.getString("insurance_company");

                        System.out.println(insurance_company_8);
                     }
                     System.out.println();
                     rs_8.close();
                  break;
            case 9:
                     System.out.println();
                     System.out.print("Year : ");String year_9=sc.nextLine();

                     String Query_9="select vehicle_id,make,model,year from vehicle where year ="+year_9+";";

                     ResultSet rs_9 = stmt.executeQuery(Query_9);

                     while(rs_9.next()){
                        Integer vid_9=rs_9.getInt("vehicle_id");
                        String make_9 = rs_9.getString("make");
                        String model_9 = rs_9.getString("model");
                        Integer yr_9= rs_9.getInt("year");

                        System.out.print("Vehicle ID : " + vid_9);
                        System.out.print(", Make : " + make_9);
                        System.out.print(", Model : " + model_9);
                        System.out.println("Year : "+yr_9);
                     }
                     System.out.println();
                     rs_9.close();
                  break;
            case 10:
                     System.out.println();
                     System.out.println("Here's the list of different car brands and their Fine counts");
                     System.out.println();
                     String Query_10="SELECT v.make, COUNT(tf.fine_id) AS num_fines\r\n" + //
                                    "FROM Vehicle v\r\n" + //
                                    "JOIN Traffic_Fines tf ON v.vehicle_id = tf.veh_id\r\n" + //
                                    "GROUP BY v.make;\r\n" + //
                                    "";
                     ResultSet rs_10=stmt.executeQuery(Query_10);
                     while(rs_10.next()){
                        String make_10 = rs_10.getString("make");
                        Integer count_10=rs_10.getInt("num_fines");
                        
                        System.out.print(" Make : " + make_10);
                        System.out.println(", Number of fines : " + count_10);
                     }
                     System.out.println();
                     rs_10.close();
                  break;
            case 11:
                     System.out.println();
                     System.out.print("Year : ");String year_11=sc.nextLine();

                     String Query_11="SELECT owner_id, first_name, last_name, b_date\r\n" + //
                                    "FROM Owner\r\n" + //
                                    "WHERE b_date > '"+year_11+"-01-01';\r\n" + //
                                    "";

                     ResultSet rs_11=stmt.executeQuery(Query_11);

                     while(rs_11.next()){
                        Integer oid_11=rs_11.getInt("owner_id");
                        String fname_11=rs_11.getString("first_name");
                        String lname_11=rs_11.getString("last_name");
                        String date_11=rs_11.getString("b_date");


                        System.out.print("Owner ID : "+oid_11);
                        System.out.print("First name : "+fname_11);
                        System.out.print("Last name: "+lname_11);
                        System.out.println("BirthDate : "+date_11);
                     }
                     System.out.println();
                     rs_11.close();
                  break;
                  
            case 12:
                     System.out.println();
                     String Query_12="SELECT AVG(premium_amount) AS average_premium_amount\r\n" + //
                                    "FROM Insurance_Policies;\r\n" + //
                                    "";
                     ResultSet rs_12=stmt.executeQuery(Query_12);
                     if(rs_12.next()==false){
                        System.out.println("Average Premium Amount : 0");
                        break;
                     }
                     Integer avg_12=rs_12.getInt("average_premium_amount");
                     System.out.println("Average Premium Amount : "+avg_12);
                     System.out.println();
                     rs_12.close();
                  break;
            case 13:
                     System.out.println();
                     System.out.println("Here's the list of Insurance Companies and their respective Maximum and Minimum Premiums : ");
                     String Query_13="SELECT insurance_company,\r\n" + //
                                             "       MAX(premium_amount) AS max_premium_amount,\r\n" + //
                                             "       MIN(premium_amount) AS min_premium_amount\r\n" + //
                                             "FROM Insurance_Policies\r\n" + //
                                             "GROUP BY insurance_company;";
                     
                     ResultSet rs_13=stmt.executeQuery(Query_13);

                     while(rs_13.next()){
                        String comp_13=rs_13.getString("insurance_company");
                        Integer max_13=rs_13.getInt("max_premium_amount");
                        Integer min_13=rs_13.getInt("min_premium_amount");

                        System.out.print("Company : "+comp_13);
                        System.out.print("Maximum : "+max_13);
                        System.out.println("Minimum : "+min_13);
                     }
                     System.out.println();
                     rs_13.close();
                  break;
            default:
               break;
         }
      }
         sc.close();
         stmt.close();
         conn.close();
      } catch(SQLException se){
         //Handle errors for JDBC
         se.printStackTrace();
         // If there is an error then rollback the changes.
         System.out.println("Rolling back data here....");
         try{
            if(conn!=null)
                conn.rollback();
         }catch(SQLException se2){
            System.out.println("Rollback failed....");
                 se2.printStackTrace();
         }
      } catch (Exception e) { // Handle errors for Class.forName
         e.printStackTrace();
      } finally { // finally block used to close resources regardless of whether an exception was
                  // thrown or not
         try {
            if (stmt != null)
               stmt.close();
         } catch (SQLException se2) {
         }
         try {
            if (conn != null)
               conn.close();
         } catch (SQLException se) {
            se.printStackTrace();
         } // end finally try
      } // end try
      System.out.println("End of Code");
   } // end main
} // end class

// Note : By default autocommit is on. you can set to false using
// con.setAutoCommit(false)
