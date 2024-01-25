package library;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//clasa pt fereastra raspunzatoare de cautarea dupa domeniu
public class SearchByDomainDialog implements Dialog {

    @Override
    public void showDialog() {
    	//fereastra are camp pt domeniu
    	//o eticheta pt mesaje si butonul Search
    	
        var searchFrame = new JFrame("Search by Domain");
        searchFrame.setSize(400, 150);
        var searchPanel = new JPanel();
        searchFrame.add(searchPanel);
        searchPanel.setLayout(null);

        var domainLabel = new JLabel("Domain:");
        domainLabel.setBounds(10, 20, 80, 25);
        searchPanel.add(domainLabel);

        var domainText = new JTextField(20);
        domainText.setBounds(100, 20, 250, 25);
        searchPanel.add(domainText);

        var validationLabel = new JLabel("");
        validationLabel.setBounds(10, 50, 300, 25);
        searchPanel.add(validationLabel);

        var searchButton = new JButton("Search");
        searchButton.setBounds(10, 80, 120, 25);
        searchPanel.add(searchButton);

        //actiunea efectuata la apasarea lui Search
        searchButton.addActionListener(e -> {
        	//ia domeniul din camp
            String domain = domainText.getText();

            //daca e completet domeniul => efectueaza cautarea
            if (!domain.isEmpty()) {
            	validationLabel.setText("");
                SearchOperation searchOp = new SearchOperation();
                String message = searchOp.searchBooksByDomain(domain);
                validationLabel.setText(message);
            } else {
                validationLabel.setText("Please fill in the domain field.");
            }
        });

        searchFrame.setVisible(true);
    }
}
