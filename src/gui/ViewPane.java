package gui;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.table.*;
import log.ErrorLogger;
import net.Connector;
import net.QueryMessage;
import net.ResultMessage;
import net.RefundMessage;
import net.AckMessage;

/**
 * Class for viewing the results of a database search through a GUI.
 * It has a context-sensitive button that will change it's function
 * based on the table the view pane is displaying results from.
 * 
 * @author Stephen
 */
public class ViewPane extends javax.swing.JPanel {
    private TableEnum tableType;
    
    /**
     * Creates new form ViewPane
     */
    public ViewPane(TableEnum tableType) {
        initComponents();
        this.tableType = tableType;
        
        //change context-sensitive button based on type
        if(tableType.isButtonEnabled()) {
            contextButton.setText(tableType.getButtonText());
        }
        else {
            contextButton.setEnabled(false);
            contextButton.setVisible(false);
            contextPane.setVisible(false);
        }
        
        //perform type's query and add results to table
        QueryMessage query = new QueryMessage(Connector.getNextId(), tableType.getQuery());
        Connector.getSocket().sendMessage(query);
        ResultMessage results = (ResultMessage) Connector.getSocket().receiveMessage();
        
        if(results.isConstructed() && results.getContent().get(ResultMessage.RESULTS) != null) {
            LinkedList<HashMap<String, String>> resultList = (LinkedList<HashMap<String, String>>) 
                    results.getContent().get(ResultMessage.RESULTS);
            DefaultTableModel model = new DefaultTableModel();
            
            //get headings
            LinkedList<String> headings = tableType.getHeadingsOrder();
            
            //add headings to model
            for(String heading : headings) {
                model.addColumn(heading);
            }
            
            //create data arrays
            for(int i = 0; i < resultList.size(); i++) {
                HashMap<String, String> row = resultList.get(i);
                String[] data = new String[headings.size()];
                
                for(int j = 0; j < headings.size(); j++) {
                    String heading = headings.get(j);
                    data[j] = tableType.translateForDisplay(row.get(heading), 
                            heading);
                }
                
                model.addRow(data);
            }
            
            //put into table and format
            table.setModel(model);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            TableColumnAdjuster automaticResizer = new TableColumnAdjuster(table);
            automaticResizer.adjustColumns();
        }
    }
    
    /**
     * Extracts all of the values of a selected row and puts them into a map.
     * 
     * @return A map of the form column name : selected row value
     */
    private HashMap<String, String> extractSelectedRow() {
        int rowIndex = table.getSelectedRow();
        TableModel model = table.getModel();
        HashMap<String, String> row = new HashMap<String, String>();
            
        for(int i = 0; i < table.getColumnCount(); i++) {
            row.put(table.getColumnName(i), model.getValueAt(rowIndex, i).toString());
        }
        
        return row;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contextPane = new javax.swing.JPanel();
        contextButton = new javax.swing.JButton();
        feedback = new javax.swing.JLabel();
        tablePane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(600, 380));

        contextPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        contextButton.setText("Context-Sensiitive Button");
        contextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contextPaneLayout = new javax.swing.GroupLayout(contextPane);
        contextPane.setLayout(contextPaneLayout);
        contextPaneLayout.setHorizontalGroup(
            contextPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contextPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contextButton)
                .addGap(18, 18, 18)
                .addComponent(feedback)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contextPaneLayout.setVerticalGroup(
            contextPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contextPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contextPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contextButton)
                    .addComponent(feedback))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        table.setColumnSelectionAllowed(true);
        table.getTableHeader().setReorderingAllowed(false);
        tablePane.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contextPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tablePane, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(tablePane, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contextPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void contextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contextButtonActionPerformed
        //do something based on table type
        
        if(table.getSelectedRow() != -1) {
            //valid row selected
            
            if(tableType == TableEnum.REGISTRATIONS) {
                //giving refunds
                HashMap<String, String> row = extractSelectedRow();
                String username = row.get("username");
                String courseCode = row.get("courseCode");

                RefundMessage msg = new RefundMessage(Connector.getNextId(), 
                        username, courseCode);
                Connector.getSocket().sendMessage(msg);
                AckMessage reply = (AckMessage) Connector.getSocket().receiveMessage();

                if((Boolean) reply.getContent().get(AckMessage.VALUE)) {
                    //refund processed successfully
                    feedback.setText("Refund given.");
                }
                else {
                    //refund processed unsuccessfully
                    feedback.setText("Refund transaction failed. There may have been a "
                            + "network or server fault. Please contact the system "
                            + "administrator as soon as possible.");
                }
            }
            else if(tableType == TableEnum.COURSES) {
                //editing selected course details
                HashMap<String, String> row = extractSelectedRow();
                MainFrame.getInstance().changeContents(new CourseChangePane(row));
            }
            else if(tableType == TableEnum.LECTURERS) {
                //editing selected lecturer details
                HashMap<String, String> row = extractSelectedRow();
                MainFrame.getInstance().changeContents(new LecturerChangePane(row));
            }
            else if(tableType == TableEnum.UNREPLIED_MESSAGES) {
                //reply to selected message
                HashMap<String, String> row = extractSelectedRow();
                MainFrame.getInstance().changeContents(new ReplyPanel(row));
            }
            else {
                //send error about button being used with no function
                ErrorLogger.get().log("Context-sensitive button hit for table of type " + 
                        tableType.name() + " but no code was found for it.");
            }
        }
        else {
            //no selection
            feedback.setText("Please select a row.");
        }
    }//GEN-LAST:event_contextButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton contextButton;
    private javax.swing.JPanel contextPane;
    private javax.swing.JLabel feedback;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tablePane;
    // End of variables declaration//GEN-END:variables

}
