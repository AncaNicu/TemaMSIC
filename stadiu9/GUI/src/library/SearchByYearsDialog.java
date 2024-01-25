package library;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//clasa pt fereastra raspunzatoare de cautarea dupa ani
public class SearchByYearsDialog implements Dialog {

    @Override
    public void showDialog() {
    	//fereastra are cate un camp pt cei 2 ani
    	//o eticheta pt mesaje si butonul Search
        var searchFrame = new JFrame("Search by Years");
        searchFrame.setSize(430, 200);
        var searchPanel = new JPanel();
        searchFrame.add(searchPanel);
        searchPanel.setLayout(null);

        var year1Label = new JLabel("Year 1:");
        year1Label.setBounds(10, 20, 80, 25);
        searchPanel.add(year1Label);

        var year1Text = new JTextField(20);
        year1Text.setBounds(100, 20, 250, 25);
        searchPanel.add(year1Text);

        var year2Label = new JLabel("Year 2:");
        year2Label.setBounds(10, 50, 80, 25);
        searchPanel.add(year2Label);

        var year2Text = new JTextField(20);
        year2Text.setBounds(100, 50, 250, 25);
        searchPanel.add(year2Text);

        var messageLabel = new JLabel("");
        messageLabel.setBounds(10, 80, 400, 25);
        searchPanel.add(messageLabel);

        var searchButton = new JButton("Search");
        searchButton.setBounds(10, 110, 120, 25);
        searchPanel.add(searchButton);

        //actiunea efectuata la apasarea lui Search
        searchButton.addActionListener(e -> {
            String year1 = year1Text.getText();
            String year2 = year2Text.getText();

            //daca nu e niciun camp gol
            if (!year1.isEmpty() && !year2.isEmpty()) {
            	messageLabel.setText("");
                ValidateYears yearsValidator = new ValidateYears();
                //daca anii sunt valizi => efectueaza cautarea
                if (yearsValidator.validate(year1 + "," + year2)) {
                    messageLabel.setText("");
                    int year1AsNr = Integer.parseInt(year1);
                    int year2AsNr = Integer.parseInt(year2);
                    SearchOperation searchOp = new SearchOperation();
                    String message = searchOp.searchBooksBetweenYears(year1AsNr, year2AsNr);
                    messageLabel.setText(message);
                } else {
                    messageLabel.setText("Year1 and Year2 should be positive integers, and Year1<Year2.");
                }
            } else {
                messageLabel.setText("Please fill in both Year1 and Year2 fields.");
            }
        });

        searchFrame.setVisible(true);
    }
}
