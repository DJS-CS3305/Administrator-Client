/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.HashMap;
import net.Connector;
import net.QueryMessage;
import net.ResultMessage;

/**
 * Pane for editing lecturer information or adding new lecturers.
 * 
 * @author saf3
 */
public class LecturerChangePane extends javax.swing.JPanel implements AcceptsInsertions {
    private javax.swing.JFrame insertWindow;
    
    /**
     * Creates new form LecturerChangePane
     */
    public LecturerChangePane() {
        initComponents();
        insertWindow = null;
    }
    
    /**
     * Creates new form LecturerChangePane from a selection.
     * @param row Map of column name : value representing a courses table row. Column names match the DB schema.
     */
    public LecturerChangePane(HashMap<String, String> row) {
        this();
        nameField.setText(row.get("name"));
        descriptionField.setText(row.get("description"));
        
        //disable editing of name to avoid errors
        nameField.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        insertImageButton = new javax.swing.JButton();
        insertVideoButton = new javax.swing.JButton();
        commitButton = new javax.swing.JButton();
        insertLinkButton = new javax.swing.JButton();
        feedback = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionField = new javax.swing.JTextArea();
        nameField = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(600, 380));
        setPreferredSize(new java.awt.Dimension(600, 380));

        insertImageButton.setText("Insert Image...");
        insertImageButton.setToolTipText("Insert an image into the lecturer's description.");
        insertImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertImageButtonActionPerformed(evt);
            }
        });

        insertVideoButton.setText("Insert Video...");
        insertVideoButton.setToolTipText("Insert a video into the lecturer's description.");
        insertVideoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertVideoButtonActionPerformed(evt);
            }
        });

        commitButton.setText("Commit Changes");
        commitButton.setToolTipText("Commit the changes to the database.");
        commitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commitButtonActionPerformed(evt);
            }
        });

        insertLinkButton.setText("Insert Hyperlink...");
        insertLinkButton.setToolTipText("Insert a customizable hyperlink into the course description.");
        insertLinkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertLinkButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(insertImageButton)
                        .addGap(18, 18, 18)
                        .addComponent(insertVideoButton)
                        .addGap(18, 18, 18)
                        .addComponent(insertLinkButton)
                        .addGap(18, 18, 18)
                        .addComponent(commitButton))
                    .addComponent(feedback))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertImageButton)
                    .addComponent(insertVideoButton)
                    .addComponent(insertLinkButton)
                    .addComponent(commitButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(feedback)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        nameLabel.setText("Name:");

        descriptionLabel.setText("Lecturer Description:");

        descriptionField.setColumns(20);
        descriptionField.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        descriptionField.setRows(5);
        jScrollPane1.setViewportView(descriptionField);

        nameField.setToolTipText("The name of the lecturer. WARNING: This is unable to be edited after it is added.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameField))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(descriptionLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void commitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commitButtonActionPerformed
        //bundle field values into an SQL query and send it.
        String name = nameField.getText();
        String description = descriptionField.getText();
        
        //check if there is a lecturer by this name in the database already
        boolean exists;
        String existsQuery = "SELECT * FROM Lecturers WHERE name = '" + name + "';";
        QueryMessage qm = new QueryMessage(Connector.getNextId(), existsQuery);
        Connector.getSocket().sendMessage(qm);
        ResultMessage existResults = (ResultMessage) Connector.getSocket().receiveMessage();
        exists = (existResults.isConstructed() &&
                    existResults.getContent().get(ResultMessage.RESULTS) != null);
        
        //construct & send query
        String query;
        
        if(exists) {
            query = "UPDATE Lecturers SET description = '" + 
                    SQLSanitize.sanitize(description) + "' WHERE name = '" + 
                    SQLSanitize.sanitize(name) + "';";
        }
        else {
            query = "INSERT INTO Lecturers VALUES ('" + SQLSanitize.sanitize(name)
                    + "', '" + SQLSanitize.sanitize(description) + "');";
        }
        
        qm = new QueryMessage(Connector.getNextId(), query);
        Connector.getSocket().sendMessage(qm);
        
        feedback.setText("Changes committed.");
    }//GEN-LAST:event_commitButtonActionPerformed

    private void insertLinkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertLinkButtonActionPerformed
        //open insert hyperlink window and take given pseudoHTML to insert into description.
        InsertLinkWindow window = new InsertLinkWindow(this);
        new Thread(window).start();
        insertWindow = window;
    }//GEN-LAST:event_insertLinkButtonActionPerformed

    private void insertVideoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertVideoButtonActionPerformed
        //open insert video window and take given pseudoHTML to insert into description.
        InsertMultimediaWindow window = new InsertMultimediaWindow(this, false);
        new Thread(window).start();
        insertWindow = window;
    }//GEN-LAST:event_insertVideoButtonActionPerformed

    private void insertImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertImageButtonActionPerformed
        //open insert image window and take given pseudoHTML to insert into description.
        InsertMultimediaWindow window = new InsertMultimediaWindow(this, true);
        new Thread(window).start();
        insertWindow = window;
    }//GEN-LAST:event_insertImageButtonActionPerformed

    /**
     * Inserts the given string into the description pane at the caret position.
     * 
     * @param insertion 
     */
    @Override
    public void insert(String insertion) {
        descriptionField.insert(insertion, descriptionField.getCaretPosition());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton commitButton;
    private javax.swing.JTextArea descriptionField;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JLabel feedback;
    private javax.swing.JButton insertImageButton;
    private javax.swing.JButton insertLinkButton;
    private javax.swing.JButton insertVideoButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    // End of variables declaration//GEN-END:variables
}
