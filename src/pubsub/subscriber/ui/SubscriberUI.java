/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pubsub.subscriber.ui;

import static java.lang.Thread.sleep;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import pubsub.message.NetworkMessage;
import pubsub.message.NetworkMessage.Messages.Builder;
import pubsub.subscriber.PubSubSubscriber;

/**
 *
 * @author AL
 */
public class SubscriberUI extends javax.swing.JFrame {

    /**
     * Creates new form Subscriber
     */
    public SubscriberUI(PubSubSubscriber sub) {
        try {
            SubscriberUI.hostAddrIP = InetAddress.getLocalHost().getHostAddress().toString();
        } catch (UnknownHostException ex) {
            Logger.getLogger(PubSubSubscriber.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        this.subscriber = sub;
        if(this.isRegistered == true){
            toRegister.setVisible(false);
            registered.setVisible(true);
        }
        else{
            toRegister.setVisible(true);
            registered.setVisible(false);
        }
        
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        toRegister = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        ip = new javax.swing.JTextField();
        viaEmail = new javax.swing.JButton();
        viaIP = new javax.swing.JButton();
        registered = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        allTopicsList = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        onSubscribe = new javax.swing.JButton();
        onUnSubscribe = new javax.swing.JButton();
        onRefresh = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        subscribedTopicsList = new javax.swing.JList();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        msgList = new javax.swing.JList();
        deleteMsg = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("E-Mail");

        jLabel2.setText("IP");

        ip.setText(hostAddrIP);

        viaEmail.setText("via E-Mail");
        viaEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viaEmailActionPerformed(evt);
            }
        });

        viaIP.setText("via IP");
        viaIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viaIPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout toRegisterLayout = new javax.swing.GroupLayout(toRegister);
        toRegister.setLayout(toRegisterLayout);
        toRegisterLayout.setHorizontalGroup(
            toRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toRegisterLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(toRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(toRegisterLayout.createSequentialGroup()
                        .addComponent(viaEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(viaIP)
                        .addGap(0, 79, Short.MAX_VALUE))
                    .addGroup(toRegisterLayout.createSequentialGroup()
                        .addGroup(toRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(toRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(email)
                            .addComponent(ip))))
                .addContainerGap())
        );
        toRegisterLayout.setVerticalGroup(
            toRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toRegisterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(toRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(toRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(toRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viaEmail)
                    .addComponent(viaIP))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel3.setText("Registered as a Subscriber !");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout registeredLayout = new javax.swing.GroupLayout(registered);
        registered.setLayout(registeredLayout);
        registeredLayout.setHorizontalGroup(
            registeredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registeredLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );
        registeredLayout.setVerticalGroup(
            registeredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registeredLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(toRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(96, 96, 96))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(registered, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(136, 136, 136))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(toRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registered, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(87, 87, 87))
        );

        jTabbedPane1.addTab("Register", jPanel2);

        allTopicsList.setModel(allTopicsListModel);
        jScrollPane1.setViewportView(allTopicsList);

        jLabel4.setText("Topics Available");

        onSubscribe.setText("Subscribe");
        onSubscribe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSubscribeActionPerformed(evt);
            }
        });

        onUnSubscribe.setText("UnSubscribe");
        onUnSubscribe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onUnSubscribeActionPerformed(evt);
            }
        });

        onRefresh.setText("Refresh");
        onRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onRefreshActionPerformed(evt);
            }
        });

        jLabel5.setText("Subscriptions");

        subscribedTopicsList.setModel(subscribedTopicsListModel);
        jScrollPane2.setViewportView(subscribedTopicsList);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(onUnSubscribe)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(onSubscribe))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(onRefresh))))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 72, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(onSubscribe)
                        .addGap(26, 26, 26)
                        .addComponent(onUnSubscribe)
                        .addGap(33, 33, 33)
                        .addComponent(onRefresh))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Subscribe", jPanel3);

        msgList.setModel(messageListModel);
        jScrollPane3.setViewportView(msgList);

        deleteMsg.setText("Delete Message");
        deleteMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMsgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(deleteMsg)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteMsg)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Messages", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viaEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viaEmailActionPerformed
        // TODO add your handling code here:
        if(this.isRegistered == false){
            if(email.getText()!= null){
                System.out.println(email.getText());
                regMode = "email";
                host = email.getText();
                //Boolean reg = subscriber.registerViaEmail(email.getText());
                //this.isRegistered = reg;
                if(regMode !=null){
                    toRegister.setVisible(false);
                    registered.setVisible(true);
                }
            }
        }
        onRefreshActionPerformed(null);
    }//GEN-LAST:event_viaEmailActionPerformed

    private void viaIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viaIPActionPerformed
        // TODO add your handling code here:
        if(this.isRegistered == false){
            if(ip.getText()!= null){
                System.out.println(ip.getText());
                regMode = "ip";
                host = ip.getText();
                //Boolean reg = subscriber.registerViaIP(ip.getText());
                //this.isRegistered = reg;
                if(regMode!=null){
                    toRegister.setVisible(false);
                    registered.setVisible(true);
                }
            }
        }
        onRefreshActionPerformed(null);
    }//GEN-LAST:event_viaIPActionPerformed

    private void onRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onRefreshActionPerformed
        // TODO add your handling code here:
        refresh = false;
        subscriber.refresh(regMode, host);
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SubscriberUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("refresh:" + refresh);
        if(refresh == true){
            //allTopicsList = new JList(new DefaultListModel());
            //DefaultListModel listModel = new DefaultListModel();
            allTopicsListModel.clear();
            for(int i=0;i<allTopics.size();i++){
                //listModel.addElement(allTopics.get(i));
                allTopicsListModel.addElement(allTopics.get(i));
                System.out.println("allTopicslistModel(i): " + allTopicsListModel.get(i));
            }
            
            subscribedTopicsListModel.clear();
            for(int i=0;i<subscribedTopics.size();i++){
                
                subscribedTopicsListModel.addElement(subscribedTopics.get(i));
                System.out.println("subscribedTopicslistModel(i): " + subscribedTopicsListModel.get(i));
            }
        }
    }//GEN-LAST:event_onRefreshActionPerformed

    private void onSubscribeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onSubscribeActionPerformed
        // TODO add your handling code here:
        
        if(allTopicsList.getSelectedValue() == null){
            JOptionPane.showMessageDialog(this, "Choose from the available list of topics to subscribe");
        }
        else{
            System.out.println("onSubscribe " + allTopicsList.getSelectedValue().toString());
            //System.out.println("onSubScribe " + allTopicsList.getSelectedIndex());
            
            //if subscribed list already contains the value - display subscribed
            subscriber.subscribe(allTopicsList.getSelectedValue().toString(), regMode, host);
            onRefreshActionPerformed(null);
            
        }
    }//GEN-LAST:event_onSubscribeActionPerformed

    private void onUnSubscribeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onUnSubscribeActionPerformed
        if(subscribedTopicsList.getSelectedValue() == null){
            JOptionPane.showMessageDialog(this, "Choose from the subscribed list of topics to unsubscribe");
        }
        else{
            System.out.println("onUnSubscribe " + subscribedTopicsList.getSelectedValue().toString());
            //System.out.println("onUnSubScribe " + subscribedTopicsList.getSelectedIndex());
            
            subscriber.unSubscribe(subscribedTopicsList.getSelectedValue().toString(), regMode, host);
            onRefreshActionPerformed(null);
            
        }
    }//GEN-LAST:event_onUnSubscribeActionPerformed

    private void deleteMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMsgActionPerformed
        System.out.println("deleteMessage outsideloop");
        if(msgList.getSelectedValue()!=null){
            System.out.println(msgList.getSelectedValue());
            messageListModel.removeElement(msgList.getSelectedValue());
        }
    }//GEN-LAST:event_deleteMsgActionPerformed

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Subscriber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Subscriber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Subscriber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Subscriber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Subscriber().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList allTopicsList;
    private javax.swing.JButton deleteMsg;
    private javax.swing.JTextField email;
    private javax.swing.JTextField ip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList msgList;
    private javax.swing.JButton onRefresh;
    private javax.swing.JButton onSubscribe;
    private javax.swing.JButton onUnSubscribe;
    private javax.swing.JPanel registered;
    private javax.swing.JList subscribedTopicsList;
    private javax.swing.JPanel toRegister;
    private javax.swing.JButton viaEmail;
    private javax.swing.JButton viaIP;
    // End of variables declaration//GEN-END:variables
    PubSubSubscriber subscriber;
    boolean isRegistered = false;
    public static boolean refresh = false;
    public static ArrayList<String> allTopics = new ArrayList<String>();
    public DefaultListModel<String> allTopicsListModel = new DefaultListModel<String>();
    public static ArrayList<String> subscribedTopics = new ArrayList<String>();
    public DefaultListModel<String> subscribedTopicsListModel = new DefaultListModel<String>();
    public String regMode = null;
    public String host = null;
    public static String hostAddrIP = null;
    public static DefaultListModel<String> messageListModel = new DefaultListModel<String>();
}
