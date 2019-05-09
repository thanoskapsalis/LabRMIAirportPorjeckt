
import javax.swing.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;

public class Main extends JFrame {

    public Main() {
        Graphics();
    }

    private void Graphics() {

        jLabel1 = new JLabel();
        jPanel2 = new JPanel();
        jLabel2 = new JLabel();
        From = new JTextField();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        To = new JTextField();
        jLabel5 = new JLabel();
        FlightDate = new JTextField();
        jLabel6 = new JLabel();
        ReturnDate = new JTextField();
        jLabel7 = new JLabel();
        Travellers = new JTextField();
        Submit = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Welcome to BookTicket!");

        jPanel2.setLayout(null);

        jLabel2.setIcon(new ImageIcon(getClass().getResource("/pic2.jpg"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 0, 600, 230);

        From.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                FromActionPerformed(evt);
            }
        });

        jLabel3.setText("Από");

        jLabel4.setText("Πρός");

        To.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ToActionPerformed(evt);
            }
        });

        jLabel5.setText("Αναχώρηση");

        FlightDate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                FlightDateActionPerformed(evt);
            }
        });

        jLabel6.setText("Επιστροφή");

        ReturnDate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ReturnDateActionPerformed(evt);
            }
        });

        jLabel7.setText("Ταξιδιώτες");

        Travellers.setToolTipText("");
        Travellers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TravellersActionPerformed(evt);
            }
        });

        Submit.setIcon(new ImageIcon(getClass().getResource("/pic4.png"))); // NOI18N
        Submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 35, Short.MAX_VALUE)
                                        .addComponent(Submit, GroupLayout.PREFERRED_SIZE, 533, GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)))
                        .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(From)
                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(To)
                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(FlightDate)
                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(ReturnDate)
                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(Travellers)
                                .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(From, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(To, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(FlightDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(ReturnDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Travellers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(Submit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
        );

        pack();
    }

    private void FromActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void ToActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void FlightDateActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void ReturnDateActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void TravellersActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void SubmitActionPerformed(ActionEvent evt) {

        try {
            Booking look_op = (Booking) Naming.lookup("//192.168.1.7/RMIServer");

            Random rand = new Random();//dimiourgia random arithmwn 100-10000 gia ton monadiko kwdiko
            look_op.BookChecker(From.getText(), To.getText(), FlightDate.getText(), ReturnDate.getText(), Integer.parseInt(Travellers.getText()),rand.nextInt(10000));

            //System.out.println(look_op.update());
        } catch (NotBoundException ex) {
            ex.printStackTrace();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String args[]) {
        new Main().setVisible(true);
    }

    private JTextField FlightDate;
    private JTextField From;
    private JTextField ReturnDate;
    private JButton Submit;
    private JTextField To;
    private JTextField Travellers;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JPanel jPanel2;
}
