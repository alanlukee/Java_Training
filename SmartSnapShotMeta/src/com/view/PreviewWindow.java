package com.view;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class PreviewWindow extends JFrame {

    private JPanel imagePanel;
    private ArrayList<File> selectedFiles = new ArrayList<>();

    public PreviewWindow() {
    	
        setTitle("Image Viewer");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setSize(1000, 600);
        setLocationRelativeTo(null);

        imagePanel = new JPanel();
        imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS)); 
        
        imagePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 

        JScrollPane scrollPane = new JScrollPane(imagePanel);
        add(scrollPane, BorderLayout.CENTER);

        loadImages();  
    }

    private void loadImages() {
        String folderPath = "src\\snapShots\\";
        File folder = new File(folderPath);
        if (!folder.exists() || !folder.isDirectory()) {
            JOptionPane.showMessageDialog(this, "Snapshot folder not found!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        File[] files = folder.listFiles((dir, name) ->
                name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".jpeg") || name.toLowerCase().endsWith(".png")
        );

        if (files != null && files.length > 0) {
            System.out.println("Found " + files.length + " image(s).");
            imagePanel.removeAll();
            selectedFiles.clear();
            for (File file : files) {
                addImageToPanel(file);
            }
            imagePanel.revalidate();
            imagePanel.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "No images found in the snapshot folder.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void addImageToPanel(File file) {
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            if (bufferedImage == null) {
                System.out.println("Failed to load image: " + file.getAbsolutePath());
                return;
            }

           
            int windowWidth = getWidth() - 40; 
            int scaledHeight = (bufferedImage.getHeight() * windowWidth) / bufferedImage.getWidth();
            Image scaledImage = bufferedImage.getScaledInstance(windowWidth, scaledHeight, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(scaledImage);

            JLabel imageLabel = new JLabel(icon);

            
            JCheckBox checkBox = new JCheckBox(file.getName());
            checkBox.setFont(new Font("Arial", Font.BOLD, 14));
            checkBox.setHorizontalAlignment(SwingConstants.CENTER);
            checkBox.setPreferredSize(new Dimension(windowWidth, 30));

            
            JPanel imageContainer = new JPanel();
            imageContainer.setLayout(new BorderLayout());
            
            imageContainer.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.GRAY, 1),
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)
            ));
            imageContainer.setBackground(new Color(240, 248, 255)); //light blue

            imageContainer.add(imageLabel, BorderLayout.CENTER);
            imageContainer.add(checkBox, BorderLayout.SOUTH);

           
            imageLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    checkBox.setSelected(!checkBox.isSelected());
                    if (checkBox.isSelected()) {
                        selectedFiles.add(file);
                    } else {
                        selectedFiles.remove(file);
                    }
                }
            });

            checkBox.addActionListener(e -> {
                if (checkBox.isSelected()) {
                    selectedFiles.add(file);
                } else {
                    selectedFiles.remove(file);
                }
            });

            imagePanel.add(imageContainer);
            imagePanel.add(Box.createVerticalStrut(15)); //to add spacing between the images
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
