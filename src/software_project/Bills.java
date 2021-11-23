/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software_project;

import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP2020
 */
public class Bills implements Initializable {
    ObservableList <BillInformations> List ;
    int reply =-1; 
     Stage stage1; 
     
String uniform_resource_locator= "jdbc:mysql://localhost:3306/e-wallet?useSSL=true"; 
    String user = "Ezz_Addin_kukhun"; 
    String pass = "1092000waz"; 
    @FXML
    private TableView<BillInformations> table;
    @FXML
    private JFXComboBox<String> companies;
    @FXML
    private Label bankid;
    @FXML
    private TableColumn<BillInformations, String> ID;
    @FXML
    private TableColumn<BillInformations, String> Date;
    @FXML
    private TableColumn<BillInformations, String> Service;
    @FXML
    private TableColumn<BillInformations, String> Company;
    @FXML
    private TableColumn<BillInformations, String> Amount;
    @FXML
    private TableColumn<BillInformations, String> Select;
    String BID =""; 
    /**
     * Initializes the controller class.
     */
    
    public void setBankID (String BankID) throws ClassNotFoundException, SQLException
    {
        this.bankid.setText(BankID);
        BID = BankID; 
        
         
            Class.forName("com.mysql.cj.jdbc.Driver");
              Connection connection = DriverManager.getConnection(this.uniform_resource_locator,user,pass); 
             Statement stmt = connection.createStatement();   
             String selectuserdata = "select * from bills where sender_id='"+BID+"'"; 
             ResultSet rs = stmt.executeQuery(selectuserdata); 
                       List = FXCollections.observableArrayList(); 
  
           while (rs.next())
         {
         List.add(new BillInformations (""+rs.getInt(1),rs.getString(2),rs.getString(6),rs.getString(4),""+rs.getInt(3))); 
         this.ID.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("ID"));
         this.Date.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("Date"));
         this.Service.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("Service"));
         this.Company.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("Company"));
         this.Amount.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("Amount"));
         this.Select.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("Select"));     
         this.table.setItems(List);   
         }
            
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            
            this.companies.getItems().add("Hadara");
                        this.companies.getItems().add("Jawwal");
            this.companies.getItems().add("Oredoo");
            this.companies.getItems().add("Ashamal");
                        this.companies.getItems().add("Gaz Station");


            
            Class.forName("com.mysql.cj.jdbc.Driver");
              Connection connection = DriverManager.getConnection(this.uniform_resource_locator,user,pass); 
             Statement stmt = connection.createStatement();   
             String selectuserdata = "select * from bills where sender_id='"+BID+"'"; 
             ResultSet rs = stmt.executeQuery(selectuserdata); 
                       List = FXCollections.observableArrayList(); 
  
           while (rs.next())
         {
         List.add(new BillInformations (""+rs.getInt(1),rs.getString(2),rs.getString(6),rs.getString(4),""+rs.getInt(3))); 
         this.ID.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("ID"));
         this.Date.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("Date"));
         this.Service.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("Service"));
         this.Company.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("Company"));
         this.Amount.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("Amount"));
         this.Select.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("Select"));     
         this.table.setItems(List);   
         }
            
            
            
        }
        catch (Exception ex) {
            Logger.getLogger(Bills.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
    }    

    @FXML
    private void Pay(MouseEvent event) throws IOException {
            
     
       FXMLLoader loader = new FXMLLoader (getClass().getResource("Accept.fxml"));  
        Parent root = loader.load(); 
            Accept accept = loader.getController(); 
             accept.setInfo(this);
             stage1 = new Stage (); 
             stage1.setScene (new Scene (root)); 
             stage1.show(); 
           


    }
    
    public void setReply (int x) throws SQLException, ClassNotFoundException
    {
        this.reply=x;
        stage1.close();
        
         Class.forName("com.mysql.cj.jdbc.Driver");
              Connection connection = DriverManager.getConnection(this.uniform_resource_locator,user,pass); 
             Statement stmt = connection.createStatement();   
           
        if (reply == 0)
        {
            
        }
        
        else if (reply ==1)
        {
          
         ObservableList <BillInformations> RemoveList = FXCollections.observableArrayList();
             
     for (BillInformations bean : List)
     {
         if(bean.getSelect().isSelected())
         {
             RemoveList.add(bean); 
         }
     }
     
     
     for (int i=0; i<RemoveList.size() ; i++)
     {
        
         String ID = RemoveList.get(i).ID;      
         int currentamount = Integer.parseInt(RemoveList.get(i).getAmount()); 
         
         String select_person = "select * from user where BankID='"+this.bankid.getText()+"'"; 
         ResultSet rs = stmt.executeQuery(select_person); 
         rs.next(); 
         
         int databaseamount = rs.getInt(15);
         
         if (currentamount > databaseamount)
         {
              Alert alert = new Alert (Alert.AlertType.ERROR);
             alert.setTitle("Failed");
             alert.setContentText(    "you haven't enough money in your account to pay this bill "       ); 
             alert.showAndWait(); 
              
             
         }
         
         else
         {
         int newvalue =  databaseamount -  currentamount; 
         String update = "update user set amount='"+newvalue+"' where BankID='"+this.bankid.getText()+"'"; 
         stmt.executeUpdate(update); 
         
         String deleteTask = "delete from bills where ID='"+ID+"'"; 
         stmt.executeUpdate(deleteTask); 
         
         
         }
     }
     
        List.removeAll(RemoveList); 
        List = FXCollections.observableArrayList();
         String select = "select * from bills where sender_id='"+this.bankid.getText()+"'";  
         ResultSet rs = stmt.executeQuery(select);
         
         while (rs.next())
         {
          List.add(new BillInformations (""+rs.getInt(1),rs.getString(2),rs.getString(6),rs.getString(4),""+rs.getInt(3))); 
         this.ID.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("ID"));
         this.Date.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("Date"));
         this.Service.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("Service"));
         this.Company.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("Company"));
         this.Amount.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("Amount"));
         this.Select.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("Select"));     
         this.table.setItems(List);
         
         }
     
     
     
     
     
        }
        

    }

   
    @FXML
    private void search(ActionEvent event) throws ClassNotFoundException, SQLException {
         Class.forName("com.mysql.cj.jdbc.Driver");
              Connection connection = DriverManager.getConnection(this.uniform_resource_locator,user,pass); 
             Statement stmt = connection.createStatement();   
          
        
         List = FXCollections.observableArrayList();
         String way = this.companies.getValue();
         
         
         String select = "select * from bills where company_name='"+way+"' and sender_id='"+this.bankid.getText()+"'";  
         ResultSet rs = stmt.executeQuery(select);
         
         while (rs.next())
         {
          List.add(new BillInformations (""+rs.getInt(1),rs.getString(2),rs.getString(6),rs.getString(4),""+rs.getInt(3))); 
         this.ID.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("ID"));
         this.Date.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("Date"));
         this.Service.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("Service"));
         this.Company.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("Company"));
         this.Amount.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("Amount"));
         this.Select.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("Select"));     
         this.table.setItems(List);
         }
            
         }

    @FXML
    private void refresh(MouseEvent event) throws SQLException, ClassNotFoundException {
        
          Class.forName("com.mysql.cj.jdbc.Driver");
              Connection connection = DriverManager.getConnection(this.uniform_resource_locator,user,pass); 
             Statement stmt = connection.createStatement();   
          
        
         List = FXCollections.observableArrayList();
         String way = this.companies.getValue();
         
         
         String select = "select * from bills where sender_id='"+this.bankid.getText()+"'";   
         ResultSet rs = stmt.executeQuery(select);
         
         while (rs.next())
         {
          List.add(new BillInformations (""+rs.getInt(1),rs.getString(2),rs.getString(6),rs.getString(4),""+rs.getInt(3))); 
         this.ID.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("ID"));
         this.Date.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("Date"));
         this.Service.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("Service"));
         this.Company.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("Company"));
         this.Amount.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("Amount"));
         this.Select.setCellValueFactory(new PropertyValueFactory<BillInformations,String>("Select"));     
         this.table.setItems(List);
         }
        
    }
        
    
    
}
