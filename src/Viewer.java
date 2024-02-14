public class Viewer {
    public static void main(String[] args) {
        // Create and display the FortuneTellerFrame
        javax.swing.SwingUtilities.invokeLater(() -> {
            FortuneTellerFrame frame = new FortuneTellerFrame();
            frame.setVisible(true);
        });
    }
}
