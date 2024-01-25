package library;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//clasa pt fereastra raspunzatoare de cautarea dupa cuv cheie
public class SearchByKeywordsDialog implements Dialog {

    @Override
    public void showDialog() {
    	//fereastra are camp pt cuv cheie
    	//o eticheta pt mesaje si butonul Search
    	
        var searchFrame = new JFrame("Search by Keywords");
        searchFrame.setSize(400, 150);
        var searchPanel = new JPanel();
        searchFrame.add(searchPanel);
        searchPanel.setLayout(null);

        var keywordsLabel = new JLabel("Keywords:");
        keywordsLabel.setBounds(10, 20, 80, 25);
        searchPanel.add(keywordsLabel);

        var keywordsText = new JTextField(20);
        keywordsText.setBounds(100, 20, 250, 25);
        searchPanel.add(keywordsText);

        var validationLabel = new JLabel("");
        validationLabel.setBounds(10, 50, 300, 25);
        searchPanel.add(validationLabel);

        var searchButton = new JButton("Search");
        searchButton.setBounds(10, 80, 120, 25);
        searchPanel.add(searchButton);

      //actiunea efectuata la apasarea lui Search
        searchButton.addActionListener(e -> {
        	//ia cuv cheie din camp si le desparte 
            String[] keywords = keywordsText.getText().split(", ");
            
            //daca e completat campul => efectueaza cautarea
            if (!keywordsText.getText().isEmpty()) {
            	validationLabel.setText("");
                SearchOperation searchOp = new SearchOperation();
                String message = searchOp.searchBooksByKeywords(keywords);
                validationLabel.setText(message);
                
            } else {
                validationLabel.setText("Please enter keywords to perform the search.");
            }
        });

        searchFrame.setVisible(true);
    }
}
