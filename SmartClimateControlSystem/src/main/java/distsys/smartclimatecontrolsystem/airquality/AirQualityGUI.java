package distsys.smartclimatecontrolsystem.airquality;

import distsys.smartclimatecontrolsystem.security.JwtClientInterceptor;
import distsys.smartclimatecontrolsystem.security.JwtUtil;
import generated.grpc.airquality.AirQualityMonitorGrpc;
import generated.grpc.airquality.AirQualityMonitorOuterClass.AirQualityAlert;
import generated.grpc.airquality.AirQualityMonitorOuterClass.AirQualityCheck;
import io.grpc.Channel;
import io.grpc.ClientInterceptors;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

/**
 *
 * @author guilhermesilveira
 */

public class AirQualityGUI extends javax.swing.JFrame {

    private AirQualityMonitorGrpc.AirQualityMonitorStub asyncStub;
    private StreamObserver<AirQualityCheck> requestObserver;
    private boolean monitoringActive = false;
    
    // Creates new form AirQualityGUI
    public AirQualityGUI() {
        initComponents();
        setTitle("Smart Climate Control - Air Quality Monitor");
        
        String jwt = JwtUtil.generateToken("clientUser");

        // Set up gRPC channel and async stub
        ManagedChannel baseChannel = ManagedChannelBuilder
            .forAddress("localhost", 50053)
            .usePlaintext()
            .build();

        // Attach JWT interceptor to the channel
        Channel securedChannel = ClientInterceptors.intercept(baseChannel, new JwtClientInterceptor(jwt));
    
        asyncStub = AirQualityMonitorGrpc.newStub(securedChannel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        btnSend = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOutput = new javax.swing.JTextArea();
        comboRooms = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Select Room:");

        btnStart.setText("Start Monitoring");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnSend.setText("Send Room");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        btnStop.setText("Stop Monitoring");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        txtOutput.setColumns(20);
        txtOutput.setRows(5);
        jScrollPane1.setViewportView(txtOutput);

        comboRooms.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "Living Room", "Kitchen", "Bedroom", "Bathroom", "Garage"
        }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                    .addComponent(comboRooms, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboRooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnStart)
                        .addGap(18, 18, 18)
                        .addComponent(btnSend)
                        .addGap(18, 18, 18)
                        .addComponent(btnStop)))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        // Start the bi-directional stream and handle server responses
        try{
            requestObserver = asyncStub.monitorAirQuality(new StreamObserver<AirQualityAlert>() {
        
                @Override
                public void onNext(AirQualityAlert alert) {
                    txtOutput.append("Alert: " + alert.getAlertMessage() + "\n");
                    txtOutput.setCaretPosition(txtOutput.getDocument().getLength());
                }

                @Override
                public void onError(Throwable t) {
                    String errorMsg = t.getMessage();
                    if (errorMsg.contains("UNAVAILABLE")) {
                        txtOutput.append("Server is not running or unreachable. Please start the server.\n");
                        txtOutput.setCaretPosition(txtOutput.getDocument().getLength());
                    } else {
                        txtOutput.append("Error: " + errorMsg + "\n");
                        txtOutput.setCaretPosition(txtOutput.getDocument().getLength());
                    }
                    monitoringActive = false;
                }

                @Override
                public void onCompleted() {
                    txtOutput.append("Monitoring completed by server.\n");
                    txtOutput.setCaretPosition(txtOutput.getDocument().getLength());
                    monitoringActive = false;
                }
            });
        
            monitoringActive = true;
            txtOutput.append("Started monitoring.\n");
            txtOutput.setCaretPosition(txtOutput.getDocument().getLength());
        
        } catch (Exception e) {
            txtOutput.append("Failed to start monitoring: " + e.getMessage() + "\n");
            txtOutput.setCaretPosition(txtOutput.getDocument().getLength());
            monitoringActive = false;
        }
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        if (monitoringActive && requestObserver != null) {
            String location = comboRooms.getSelectedItem().toString();
            AirQualityCheck check = AirQualityCheck.newBuilder()
                .setLocation(location)
                .build();
            requestObserver.onNext(check);
            txtOutput.append("Sent room: " + location + "\n");
            txtOutput.setCaretPosition(txtOutput.getDocument().getLength());
        } else {
            txtOutput.append("Start monitoring first.\n");
            txtOutput.setCaretPosition(txtOutput.getDocument().getLength());
        }
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        if (monitoringActive && requestObserver != null) {
            requestObserver.onCompleted();
            monitoringActive = false;
            txtOutput.append("Monitoring stopped.\n");
            txtOutput.setCaretPosition(txtOutput.getDocument().getLength());
        }
    }//GEN-LAST:event_btnStopActionPerformed

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
            java.util.logging.Logger.getLogger(AirQualityGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AirQualityGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AirQualityGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AirQualityGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AirQualityGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JComboBox<String> comboRooms;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtOutput;
    // End of variables declaration//GEN-END:variables
}
