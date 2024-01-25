package library;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//clasa pt fereastra raspunzatoare de cautarea dupa editura
public class SearchByPublisherDialog implements Dialog {

    @Override
    public void showDialog() {
    	//fereastra are camp pt editura
    	//o eticheta pt mesaje si butonul Search
    	
        var searchFrame = new JFrame("Search by Publisher");
        searchFrame.setSize(400, 150);
        var searchPanel = new JPanel();
        searchFrame.add(searchPanel);
        searchPanel.setLayout(null);

        var publisherLabel = new JLabel("Publisher:");
        publisherLabel.setBounds(10, 20, 80, 25);
        searchPanel.add(publisherLabel);

        var publisherText = new JTextField(20);
        publisherText.setBounds(100, 20, 250, 25);
        searchPanel.add(publisherText);

        var validationLabel = new JLabel("");
        validationLabel.setBounds(10, 50, 300, 25);
        searchPanel.add(validationLabel);

        var searchButton = new JButton("Search");
        searchButton.setBounds(10, 80, 120, 25);
        searchPanel.add(searchButton);

        //actiunea efectuata la apasarea lui Search
        searchButton.addActionListener(e -> {
        	//ia editura din camp
            String publisher = publisherText.getText();

            //daca e completata editura => efectueaza cautarea
            if (!publisher.isEmpty()) {
            	validationLabel.setText("");
                SearchOperation searchOp = new SearchOperation();
                String message = searchOp.searchBooksByPublisher(publisher);
                validationLabel.setText(message);
            } else {
                validationLabel.setText("Please enter a publisher to perform the search.");
            }
        });

        searchFrame.setVisible(true);
    }
}
