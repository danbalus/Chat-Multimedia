package Chat;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.mysql.jdbc.Statement;


public class History {
	
	ClientDAO cli;
	
    public History(ClientDAO cli){
    	 this.cli = cli;
    }
    
    private void addRow(DefaultTableModel defaultTable,String[] rand){
		defaultTable.addRow(rand);
		//System.out.println("rand========================= "+rand);
	}
    
	 public void FillTable(HistoryFrame frame, String nume, boolean serverActive){
	      
	        DefaultTableModel model = (DefaultTableModel) frame.jTable11.getModel();
	        String [][] msj = new String[900][900];
	        if(serverActive == false)
	        	msj = cli.findByName(nume);
	        else
	        	msj = cli.showAll(nume);
	        int nrLinii = cli.getNrLinii();
	        int x = msj.length;
	        System.out.println(nrLinii);
	        for (int i = 0; i < nrLinii; i++)
	        	addRow(model, msj[i] );

	    }
}
