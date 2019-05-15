
import java.awt.Toolkit;
import java.awt.event.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.*;


public class FinalBooking extends JFrame {
    ArrayList<String> Result = new ArrayList();
    public static String[] dataIn;
    Booking look_op;
    int passengers;
    //constractor gia tin enarksi tis epikoinonias meso RMI apo tin Main 
    public FinalBooking(Booking look_op,int passengers) throws RemoteException {
        this.look_op=look_op;
        this.passengers=passengers;
        Result=look_op.FlightPreview();
        Graphics();
    }

    //klasi gia ta grafika            
    private void Graphics() {

        jTextField1 = new JTextField();
        jLabel1 = new JLabel();
        jPanel1 = new JPanel();
        Continue = new JButton();
        Back = new JButton();
        jScrollPane1 = new JScrollPane();
        FlightArea = new JTextArea();
        jLabel3 = new JLabel();
        FCode = new JTextField();
        jLabel4 = new JLabel();
        Name = new JTextField();
        jLabel5 = new JLabel();
        SName = new JTextField();
        jLabel6 = new JLabel();
        Phone = new JTextField();
        jPanel2 = new JPanel();
        jLabel7 = new JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Book Flight");

        jPanel1.setLayout(null);

        Continue.setText("Continue");
        Continue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ContinueActionPerformed(evt);
            }
        });

        Back.setText("Back");
        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        FlightArea.setEditable(false);
        FlightArea.setColumns(20);
        FlightArea.setRows(5);
        FlightArea.append("FLIGHT ID\tDEPARTURE\tDESTINATION\tDEPART DATE\tARRIVAL DATE\tPRICE\tTIME\n");
        for(int i=0; i<Result.size(); i++)
        {
            System.out.println(Result.get(i));
            
            FlightArea.append(Result.get(i)+"\n");
        }
        try {
            look_op.cleanup();
        } catch (RemoteException ex) {
            
        }
        jScrollPane1.setViewportView(FlightArea);

        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("Flight Code");

        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setText("Name");

        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setText("Surname");

        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel6.setText("Phone");

        jPanel2.setLayout(null);

        jLabel7.setIcon(new ImageIcon(getClass().getResource("/pic2.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(0, 0, 600, 230);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(FCode)
                    .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(Name)
                    .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(SName)
                    .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(Phone)
                    .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Back)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 461, Short.MAX_VALUE)
                                .addComponent(Continue))
                            .addComponent(jLabel1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 221, Short.MAX_VALUE))
                    .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(FCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(Name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(SName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(Phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(Continue)
                    .addComponent(Back))
                .addContainerGap())
        );

        pack();
    }    
    
    //klasi gia to klisimo tis trexon selidas kata tin metafora stin epomeni
    public void close() {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    //ulopoihsi leitourgeion tin stigmi pou tha patithei to koumpi Continue
    private void ContinueActionPerformed(ActionEvent evt) {                                         
        if(FCode.getText().equals("") || Name.getText().equals("") || Phone.getText().equals("") || SName.getText().equals(""))//elenxos gia tin orthi simplirosi olon ton pedion
        {
            JOptionPane.showMessageDialog(this, "Please fill all the blank fields!");//emfanisi popup minimatos
        }
        else
        {
            try {
            look_op.BookFlight(FCode.getText(),passengers);//kaloume tin sinartisi BookFlight apo ton RMI server opou exei ulopoihthei
            String reserve = look_op.Confirm();//kaloume tin sinartisi Confirm apo ton RMI server opou exei ulopoihthei
            if(reserve.equals("FINE"))
            {
                JOptionPane.showMessageDialog(this, "Your reservation has been completed!");
            }
        } catch (RemoteException ex) {
        }
        
        close();
        }
        
    }                                        

    //metafora sthn arxiki othoni kai klisimo tis trexousas tin stigmi pou tha patithei to koumpi Back
    private void BackActionPerformed(ActionEvent evt) {                                     
        new Main().setVisible(true);
        close();
    }                                    

                    
    private JButton Back;
    private JButton Continue;
    private JTextField FCode;
    private JTextArea FlightArea;
    private JTextField Name;
    private JTextField Phone;
    private JTextField SName;
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTextField jTextField1;                 

}
