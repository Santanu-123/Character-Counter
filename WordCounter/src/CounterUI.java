import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterUI extends JFrame {
    public static void main(String [] args){
        JFrame frame = new JFrame("Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);

        JLabel label = new JLabel("Enter your paragraph here");
        label.setFont(new Font("Times new Roman",Font.PLAIN, 15));
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        label.setForeground(Color.BLACK);
        label.setBackground(Color.CYAN);
        label.setOpaque(true);
        label.setBounds(10, 10, 365, 20);
        panel.add(label);

        JTextArea text = new JTextArea();
        text.setFont(new Font("Times new Roman",Font.PLAIN, 15));
        text.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        text.setBackground(Color.LIGHT_GRAY);
        text.setBounds(10, 40, 365, 150);
//        panel.add(text);

        JScrollPane scrollPane = new JScrollPane(text);
        scrollPane.setBounds(10, 40, 365, 150);
        panel.add(scrollPane);

        JLabel characterLabel = new JLabel("Character Count (alphabets only): 0");
        characterLabel.setFont(new Font("Times new Roman",Font.PLAIN, 15));
        characterLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        characterLabel.setForeground(Color.BLACK);
        characterLabel.setBackground(Color.YELLOW);
        characterLabel.setOpaque(true);
        characterLabel.setBounds(10, 200, 365, 20);

        text.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateCharCount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateCharCount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateCharCount();
            }

            public void updateCharCount(){
                String para = text.getText();
                int characterCounter = Counter.charCount(para);
                characterLabel.setText("Character Count (alphabets only): "+String.valueOf(characterCounter));
            }
        });
        panel.add(characterLabel);

        JLabel characterLabelSpecial = new JLabel("Character Count (includes everything): 0");
        characterLabelSpecial.setFont(new Font("Times new Roman",Font.PLAIN, 15));
        characterLabelSpecial.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        characterLabelSpecial.setForeground(Color.BLACK);
        characterLabelSpecial.setBackground(Color.YELLOW);
        characterLabelSpecial.setOpaque(true);
        characterLabelSpecial.setBounds(10, 225, 365, 20);

        text.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateCharCountSpecial();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateCharCountSpecial();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateCharCountSpecial();
            }
            public void updateCharCountSpecial(){
                String para2 = text.getText();
                int characterCounterSpecial = Counter.charCountWithoutSpace(para2);
                characterLabelSpecial.setText("Character Count (includes everything): "+String.valueOf(characterCounterSpecial));
            }
        });
        panel.add(characterLabelSpecial);


        JLabel wordLabel = new JLabel("Word Count: 0");
        wordLabel.setFont(new Font("Times new Roman",Font.PLAIN, 15));
        wordLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        wordLabel.setForeground(Color.BLACK);
        wordLabel.setBackground(Color.YELLOW);
        wordLabel.setOpaque(true);
        wordLabel.setBounds(10, 250, 290, 20);

        text.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateWordCount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateWordCount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateWordCount();
            }

            public void updateWordCount(){
                String para = text.getText();
                int wordCounter = Counter.wordCount(para);
                wordLabel.setText("Word Count: "+String.valueOf(wordCounter));
            }
        });
        panel.add(wordLabel);

        JButton button = new JButton("Clear");
        button.setFont(new Font("Times new Roman",Font.PLAIN, 12));
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        button.setForeground(Color.BLACK);
        button.setBackground(Color.GREEN);
        button.setBounds(305, 250, 65, 20);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
                wordLabel.setText("Word Count: 0");
            }
        });
        panel.add(button);

        frame.add(panel);
        frame.setSize(400, 320);
        frame.setLocation(500, 100);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
