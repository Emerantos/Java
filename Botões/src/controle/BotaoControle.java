package controle;
import modelo.BotaoModel;
import visao.Frame;

public class BotaoControle {
    private BotaoModel BModel;
    private Frame frame;

    public BotaoControle(BotaoModel BModel, Frame frame) {
        this.BModel = BModel;
        this.frame = frame;
    }

    public void startAnimation() {
        while (true) {
            BModel.updateCoordinates(frame.getWidth(), frame.getHeight());
            frame.updateButtonPositions();

            checkCollision();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkCollision() {
        
        if (frame.getButton1().getBounds().intersects(frame.getButton2().getBounds())) {

            System.out.println("AQUI");
            if (frame.getButton1().getX() < frame.getButton2().getX()) {

                BModel.setL(-6);
                BModel.setL1(6);
            } else {

                BModel.setL(6);
                BModel.setL1(-6);
            }

            if (frame.getButton1().getY() < frame.getButton2().getY()) {

                BModel.setA(-6);
                BModel.setA1(6);

            } else {

                BModel.setA(6);
                BModel.setA1(-6);

            }

        }
    }
}
