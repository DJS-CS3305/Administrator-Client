package gui;

/**
 * Class for the main frame of the GUI. The frame holds the menu and the
 * main pane that can be changed to other panes as needed.
 * 
 * @author Stephen
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contents = new javax.swing.JScrollPane();
        menuBar = new javax.swing.JMenuBar();
        connectionMenu = new javax.swing.JMenu();
        connectMenuItem = new javax.swing.JMenuItem();
        disconnectMenuItem = new javax.swing.JMenuItem();
        logOutMenuItem = new javax.swing.JMenuItem();
        viewMenu = new javax.swing.JMenu();
        viewUsersMenuItem = new javax.swing.JMenuItem();
        viewCoursesMenuItem = new javax.swing.JMenuItem();
        viewLecturersMenuItem = new javax.swing.JMenuItem();
        viewRegistrationsMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        editCourseMenuItem = new javax.swing.JMenuItem();
        editLecturerMenuItem = new javax.swing.JMenuItem();
        addMenu = new javax.swing.JMenu();
        addCourseMenuItem = new javax.swing.JMenuItem();
        addLecturerMenuItem = new javax.swing.JMenuItem();
        managementMenu = new javax.swing.JMenu();
        messageInboxMenuItem = new javax.swing.JMenuItem();
        refundsMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UCC Summer Courses Office Administrator Tool");
        setMinimumSize(new java.awt.Dimension(640, 480));
        setPreferredSize(new java.awt.Dimension(640, 480));

        connectionMenu.setText("Connection");

        connectMenuItem.setText("Connect...");
        connectionMenu.add(connectMenuItem);

        disconnectMenuItem.setText("Disconnect");
        connectionMenu.add(disconnectMenuItem);

        logOutMenuItem.setText("Log Out");
        connectionMenu.add(logOutMenuItem);

        menuBar.add(connectionMenu);

        viewMenu.setText("View");

        viewUsersMenuItem.setText("View Users...");
        viewMenu.add(viewUsersMenuItem);

        viewCoursesMenuItem.setText("View Courses...");
        viewMenu.add(viewCoursesMenuItem);

        viewLecturersMenuItem.setText("View Lecturers...");
        viewMenu.add(viewLecturersMenuItem);

        viewRegistrationsMenuItem.setText("View Registrations...");
        viewMenu.add(viewRegistrationsMenuItem);

        menuBar.add(viewMenu);

        editMenu.setText("Edit");

        editCourseMenuItem.setText("Edit Course...");
        editMenu.add(editCourseMenuItem);

        editLecturerMenuItem.setText("Edit Lecturer...");
        editMenu.add(editLecturerMenuItem);

        menuBar.add(editMenu);

        addMenu.setText("Add");

        addCourseMenuItem.setText("Add Course...");
        addMenu.add(addCourseMenuItem);

        addLecturerMenuItem.setText("Add Lecturer...");
        addMenu.add(addLecturerMenuItem);

        menuBar.add(addMenu);

        managementMenu.setText("Management");

        messageInboxMenuItem.setText("Message Inbox...");
        managementMenu.add(messageInboxMenuItem);

        refundsMenuItem.setText("Issue Refunds...");
        managementMenu.add(refundsMenuItem);

        menuBar.add(managementMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contents, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contents, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addCourseMenuItem;
    private javax.swing.JMenuItem addLecturerMenuItem;
    private javax.swing.JMenu addMenu;
    private javax.swing.JMenuItem connectMenuItem;
    private javax.swing.JMenu connectionMenu;
    private javax.swing.JScrollPane contents;
    private javax.swing.JMenuItem disconnectMenuItem;
    private javax.swing.JMenuItem editCourseMenuItem;
    private javax.swing.JMenuItem editLecturerMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem logOutMenuItem;
    private javax.swing.JMenu managementMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem messageInboxMenuItem;
    private javax.swing.JMenuItem refundsMenuItem;
    private javax.swing.JMenuItem viewCoursesMenuItem;
    private javax.swing.JMenuItem viewLecturersMenuItem;
    private javax.swing.JMenu viewMenu;
    private javax.swing.JMenuItem viewRegistrationsMenuItem;
    private javax.swing.JMenuItem viewUsersMenuItem;
    // End of variables declaration//GEN-END:variables
    
    public void setContents(javax.swing.JPanel panel) {
        contents.setViewportView(panel);
    }
}
