package Chat;



import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientDAO {
	protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());

    private final static String findStatementString = "SELECT * FROM messages where sender=? or receiver=? ORDER BY date DESC";
    private static final String insertStatementString = "insert into messages(sender,receiver,text,date,id)"+" VALUES (?,?,?,?,?)";
    //private static final String updateStatementString = "update clienti"+" set nume=?,adresa=?,email=?,varsta=?, nr_tel=? where id=?";
    //private static final String deleteStatementString = "delete from clienti"+" where id=?"; 
    private static final String showAllStatementString = "select * from messages ORDER BY date DESC";

    private static  String [][] updateMatrice = new String[900][900];
    private static int nrLinii, nrLiniiShow;
    
    
    public static String [][] findByName(String senderOrReceiver){//sender
        Client toReturn=null;
        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement findStatement=null;
        ResultSet rs=null;

        int i = 0;
        try {
            findStatement=dbConnection.prepareStatement(findStatementString);
           // findStatement.setInt(1,clientId);
            findStatement.setString(1, senderOrReceiver);
            findStatement.setString(2, senderOrReceiver);

            rs=findStatement.executeQuery();
            while(rs.next()){
            	 String sender=rs.getString("sender");
         		   updateMatrice[i][0] = sender;
         		 
                  String receiver=rs.getString("receiver");
         		    updateMatrice[i][1] = receiver;

                  String text=rs.getString("text");
         		    updateMatrice[i][2] = text;

         		    
                  String date = rs.getString("date");
         		    updateMatrice[i][3] = date;
         		    
         		    i++;
            }
         
   		  
   		 nrLinii = i;
    	 System.out.println();
    	 for (int x = 0; x < i; x++) {
     	    for (int j = 0; j < 4; j++) {
     	        System.out.print(updateMatrice[x][j] + " ");
     	    }
     	    System.out.println();
     	}
    	 System.out.println();
   		    // String nume=rs.getString("nume");
            //String adresa=rs.getString("adresa");
           // String email=rs.getString("email");
           // int varsta=rs.getInt("varsta");
           // String nrTel = rs.getString("nr_tel");
            //toReturn=new String[][](clientId,nume,adresa,email,varsta,nrTel);


        } 
        
        
        
        
        catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO:findById " + e.getMessage());
        }finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }

        return updateMatrice;

    }

    public static int insert(String sender, ArrayList<String> receiver, String messages, String date ){

        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement insertStatement=null;
        int insertedId=-1;


        try {
            insertStatement=dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            for (String temp : receiver) {
            	insertStatement.setString(1,sender);
                insertStatement.setString(2,temp);
                insertStatement.setString(3,messages);
                insertStatement.setString(4, date);
                //int randomNum = ThreadLocalRandom.current().nextInt(10, 6 + 1);
                int id = 10 + (int)(Math.random() * 64444); 
                insertStatement.setInt(5, id);
    		}
            
           

            
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }

        } catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO:insert " + e.getMessage());
        }finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }

        return insertedId;
    }

   /* public static void update(Client client){

        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement updateStatement=null;
       // int insertedId=-1;


        try {
            updateStatement=dbConnection.prepareStatement(updateStatementString);

            updateStatement.setString(1,client.getNume());
            updateStatement.setString(2,client.getAdresa());
            updateStatement.setString(3,client.getEmail());
            updateStatement.setInt(4,client.getVarsta());
            updateStatement.setString(5,client.getNrTel());
            updateStatement.setInt(6,client.getId());

            updateStatement.executeUpdate();



        } catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO:update " + e.getMessage());
        }finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }


    }

    public static void delete(Client client){

        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement deleteStatement=null;
        // int insertedId=-1;


        try {
            deleteStatement=dbConnection.prepareStatement(deleteStatementString);

            deleteStatement.setInt(1,client.getId());

            deleteStatement.executeUpdate();


        } catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO:delete " + e.getMessage());
        }finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }


    }*/
    public static String [][] showAll(String senderOrReceiver){//sender
        Client toReturn=null;
        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement showStatement=null;
        ResultSet rs=null;

        int i = 0;
        try {
        	showStatement=dbConnection.prepareStatement(showAllStatementString);
           // findStatement.setInt(1,clientId);
        	//showStatement.setString(1, senderOrReceiver);
        	//showStatement.setString(2, senderOrReceiver);

            rs=showStatement.executeQuery();
            while(rs.next()){
            	 String sender=rs.getString("sender");
         		   updateMatrice[i][0] = sender;
         		 
                  String receiver=rs.getString("receiver");
         		    updateMatrice[i][1] = receiver;

                  String text=rs.getString("text");
         		    updateMatrice[i][2] = text;

         		    
                  String date = rs.getString("date");
         		    updateMatrice[i][3] = date;
         		    
         		    i++;
            }
         
   		  
   		 nrLinii = i;
   		//nrLiniiShow = i;
    	 System.out.println();
    	 for (int x = 0; x < i; x++) {
     	    for (int j = 0; j < 4; j++) {
     	        System.out.print(updateMatrice[x][j] + " ");
     	    }
     	    System.out.println();
     	}
    	 System.out.println();
   		    // String nume=rs.getString("nume");
            //String adresa=rs.getString("adresa");
           // String email=rs.getString("email");
           // int varsta=rs.getInt("varsta");
           // String nrTel = rs.getString("nr_tel");
            //toReturn=new String[][](clientId,nume,adresa,email,varsta,nrTel);


        } 
        
        
        
        
        catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO:showall " + e.getMessage());
        }finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(showStatement);
            ConnectionFactory.close(dbConnection);
        }

        return updateMatrice;

    }
    
    
    /*public static void showAll()
    {
        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement showAllStatement=null;
        ResultSet rs=null;
        try {
            showAllStatement=dbConnection.prepareStatement(deleteStatementString);

            rs=showAllStatement.executeQuery();

            while(rs.next())
            {

            }


        } catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO:sw_all" + e.getMessage());
        }finally {
            ConnectionFactory.close(showAllStatement);
            ConnectionFactory.close(dbConnection);
        }
    }*/
    public  String [][] getMatrice()
    {
    	return this.updateMatrice;
    }
    public int getNrLinii()
    {
    	return nrLinii;
    }
    public int getNrLiniiShow()
    {
    	return nrLiniiShow;
    }
}
