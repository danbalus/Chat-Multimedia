package Chat;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
//import org.w3c.dom.events.DocumentEvent;

public class HistoryFrame extends javax.swing.JFrame {
    
    public History hist;
    
    public HistoryFrame() {
        //initComponents();
        TestTableSortFilter();
    }
    
    public HistoryFrame(History hist, String name, boolean serverActive){
       // initComponents();
        
        this.hist = hist;
        hist.FillTable(this, name,serverActive );
        TestTableSortFilter();
        
    }
    String[] columnNames
    = {"Sender", "Receiver", "Message", "Time"};

Object[][] data = {

};

DefaultTableModel model = new DefaultTableModel(data, columnNames);
JTable jTable11 = new JTable(model);

TableRowSorter<TableModel> rowSorter
    = new TableRowSorter<>(jTable11.getModel());

JTextField jtfFilter = new JTextField();
JButton jbtFilter = new JButton("Filter");
    public void TestTableSortFilter() {

        

       
            jTable11.setRowSorter(rowSorter);

            JPanel panel = new JPanel(new BorderLayout());
            panel.add(new JLabel("Specify a word to match:"),
                    BorderLayout.WEST);
            panel.add(jtfFilter, BorderLayout.CENTER);
            this.setSize(700,500);
            setLayout(new BorderLayout());
            add(panel, BorderLayout.SOUTH);
            add(new JScrollPane(jTable11), BorderLayout.CENTER);
            //panel.setBounds(0,0,790,300);
            jtfFilter.getDocument().addDocumentListener(new DocumentListener(){

                @Override
                public void insertUpdate(DocumentEvent e) {
                    String text = jtfFilter.getText();

                    if (text.trim().length() == 0) {
                        rowSorter.setRowFilter(null);
                    } else {
                        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                    }
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    String text = jtfFilter.getText();

                    if (text.trim().length() == 0) {
                        rowSorter.setRowFilter(null);
                    } else {
                        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                    }
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

            });
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	 //jLabel2 = new javax.swing.JLabel();
    	 //tNumeDepozit=new JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
         myPanel = new javax.swing.JPanel();
         jtfFilter = new JTextField();
        // this.setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat History");
        DefaultTableModel model = (DefaultTableModel) jTable11.getModel();
        jLabel1.setText("History : ");
       /// jLabel2.setText("Search : ");
        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {}, new String [] {"Sender", "Receiver", "Message", "Time"}) 
        {
            Class[] types = new Class [] { java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class};
            
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
            
        });
     
       
       
        jScrollPane1.setViewportView(jTable11);
        jTable11.getColumnModel().getColumn(1).setPreferredWidth(200);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addContainerGap())
        );
        String [] x ={"aaa","aaa", "bbb", "SSS"};
        String [] y ={"aaa","ddd", "4r4", "SSS"};
        String [] z ={"aaa","aja", "zzz", "SSS"};
        addRow((DefaultTableModel) jTable11.getModel(),x);
        addRow((DefaultTableModel) jTable11.getModel(),x);
        addRow((DefaultTableModel) jTable11.getModel(),y);
        addRow((DefaultTableModel) jTable11.getModel(),z);
       //jLabel2.setText("Search : ");
        //jTable1.add(jLabel2);
        //JLabel lab1 = new JLabel("User Name", JLabel.RIGHT);
        setLayout(new FlowLayout()); 
        add(jLabel2 = new JLabel("Search: "));
        add(tf=new JTextField("",20));
        
       
		//layout.addLayoutComponent("panel", jLabel2);
        //add(jLabel2);
       // myPanel.setLayout(null);
         //addBtn = new JButton("Adauga");
		//addBtn.setBounds(100,300,100,30);
        //JTextField txtFind = new JTextField();
		//txtFind.setBounds(690,300,100,30);
        //myPanel.add(jLabel1);
        //myPanel.add(txtFind);
        //myPanel.add(addBtn);
        
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        jTable11.setRowSorter(rowSorter);
        tf.getDocument().addDocumentListener(new DocumentListener(){
        	@Override
            public void insertUpdate(DocumentEvent e) {
                String text = tf.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

        	@Override
            public void removeUpdate(DocumentEvent e) {
                String text = tf.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        //add(initComponents());
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
    //public  void play() {
    	//HistoryFrame hf = new HistoryFrame();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HistoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistoryFrame().setVisible(true);
                //new HistoryFrame().initComponents();
            }
        });
    }
    	/*public void stop(){
    		java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new HistoryFrame().setVisible(false);
                }
            });
    	}*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    public javax.swing.JPanel myPanel;
    JButton addBtn ;
    private javax.swing.JLabel jLabel2;
    JTextField tf;
   // JTextComponent jtfFilter;
   // private TableRowSorter<TableModel> rowSorter;
    // End of variables declaration//GEN-END:variables
    private void addRow(DefaultTableModel defaultTable,String[] rand){
 		defaultTable.addRow(rand);
 		//System.out.println("rand========================= "+rand);
 	}
}
