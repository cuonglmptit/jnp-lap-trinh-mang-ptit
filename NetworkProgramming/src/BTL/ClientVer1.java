/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.io.IOException;

public class ClientVer1 {

    public static Image scaledImage(BufferedImage image, JLabel jl) {
        int labelWidth = jl.getWidth();// Đổi kích thước này thành kích thước label của bạn
        int labelHeight = jl.getHeight();

        // Calculate the new width and height while preserving the aspect ratio
        double widthRatio = (double) labelWidth / image.getWidth();
        double heightRatio = (double) labelHeight / image.getHeight();

        double ratio = Math.min(widthRatio, heightRatio);

        int newWidth = (int) (image.getWidth() * ratio);
        int newHeight = (int) (image.getHeight() * ratio);

        // Resize the image using Java's Image and ImageIcon
        Image newImg = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        return newImg;
    }

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        Socket socket = new Socket("192.168.0.139", 1309);

        JFrame frame = new JFrame("Image Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InputStream is = socket.getInputStream();
        // Nhận hình ảnh từ máy chủ hoặc từ tệp
        ObjectInputStream ins = new ObjectInputStream(socket.getInputStream());

        byte[] imageData = (byte[]) ins.readObject();
        ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
        BufferedImage img = ImageIO.read(bais);
        JLabel label = new JLabel(new ImageIcon(img));
        frame.add(label);
        frame.setLocationRelativeTo(null); // Hiển thị cửa sổ ở giữa màn hình
        frame.setVisible(true);
        frame.pack();

        int i = 0;
        while (true) {
            imageData = (byte[]) ins.readObject();
            bais = new ByteArrayInputStream(imageData);
            BufferedImage receivedImage = ImageIO.read(bais);

            ImageIcon imageIcon = new ImageIcon(scaledImage(receivedImage, label));

            label.setIcon(imageIcon);

            System.out.println("Received a screen capture." + i++);
        }

    }
}
