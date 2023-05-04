//Adrián Mompó Fajardo
package PaqIAdrian;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

    public class MainFrame extends JFrame{
        private JTextField id;
        private JComboBox country;
        private JTextField weight;
        private JTextArea desc;
        private JTextArea plan, hubPlanTextArea;
        private JTextField sender;
        private JTextField reciever;
        private JCheckBox customs;
        private JButton pile;
        private JButton unpile;
        private JPanel mainPanel;
        private int priority;
        private JRadioButton p1;
        private JRadioButton p2;
        private JRadioButton p3;
        private JTextField columnNumberTextField;
        private JButton showInfo;
        private JButton ContainerNumber;
        private JComboBox country2;
        private JLabel numberPerCountry;
        private JTextPane textPane1;
        private JFormattedTextField Textfield;

        public boolean Missing() {
            return id.getText().isEmpty() || weight.getText().isEmpty() || sender.getText().isEmpty() || desc.getText().isEmpty() || reciever.getText().isEmpty() || (!p1.isSelected() && !p2.isSelected() && !p3.isSelected());
        }


        public void updatePlan() {
            plan.setText(Hub.getHubPlan());
        }


        public MainFrame() {
            setContentPane(mainPanel);
            setTitle("Port Management");
            setSize(1000, 500);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setVisible(true);
            setLayout(new BorderLayout());

            pile.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (Missing()) {
                        JOptionPane.showMessageDialog(null, "ERROR: Something missing ");
                        return;
                    }

                    if (p1.isSelected()) priority = 1;
                    else if (p2.isSelected()) priority = 2;
                    else if (p3.isSelected()) priority = 3;

                    try{
                        Hub.pile(new Container(Integer.parseInt(id.getText()), Integer.parseInt(weight.getText()), priority, Objects.requireNonNull(country.getSelectedItem()).toString(), desc.getText(), sender.getText(), reciever.getText(), customs.isSelected()));
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(null ,"error: "+ex.getMessage());
                    }

                    updatePlan();
                }
            });

            unpile.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (columnNumberTextField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Error. Enter the column from where you want to remove the top container.");
                        return;
                    }

                    Hub.unpile(Integer.parseInt(columnNumberTextField.getText()) - 1);

                    updatePlan();
                }
            });

            showInfo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, Hub.getData(Integer.parseInt(id.getText())));
                }
            });

            ContainerNumber.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    numberPerCountry.setText(String.valueOf(Hub.contNumber(Objects.requireNonNull(country2.getSelectedItem()).toString())));
                }
            });
        }

        public static void main(String[] args) {
            MainFrame myFrame = new MainFrame();
        }
    }

