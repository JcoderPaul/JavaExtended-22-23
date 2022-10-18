package Less_22_chap_4_Anonymous_Classes.MyAnonymusClasses;
/*
Приложение на основе AWT
По мотивам книги "Java. Полное руководство. 8-е издание. Герберт Шилдт"
 */
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AppWindow extends Frame{
    String keymsg = "This is a test";
    String mousemsg = "";
    int mouseX = 30, mouseY = 30;
    public AppWindow(){

        addKeyListener(new MyKeyAdapter(this)); // анонимный класс new MyKeyAdapter(this)
        addMouseListener(new MyMouseAdapter(this));

        // vvm добавляем слушатель перемещения мышки
        addMouseMotionListener(new MyMouseAdapter(this));

        addWindowListener(new MyWindowAdapter());


    }

    @Override
    public void paint(Graphics g){
        g.drawString(keymsg, 10, 40);
        g.drawString(mousemsg, mouseX, mouseY);
    }
    // создание окна
    public static void main(String[] args) {
        AppWindow appwin = new AppWindow();
        appwin.setSize( new Dimension(320,240));
        appwin.setTitle("Приложение на основе AWT");

        appwin.setVisible(true);
    }
}

// класс адаптера нажатия клавиш
class MyKeyAdapter extends KeyAdapter{
    AppWindow appWindow;
    public MyKeyAdapter(AppWindow appWindow){
        this.appWindow = appWindow;
    }
    @Override
    public void keyTyped(KeyEvent ke){
        appWindow.keymsg += ke.getKeyChar();
        appWindow.repaint();
    };
}
// класс адаптера для мышки
class MyMouseAdapter extends MouseAdapter{
    AppWindow appWindow;
    public MyMouseAdapter(AppWindow appWindow){
        this.appWindow = appWindow;
    }
    @Override
    public void mousePressed(MouseEvent me){

        appWindow.mouseX = me.getX();
        appWindow.mouseY = me.getY();
        appWindow.mousemsg = "Mouse Down at " + appWindow.mouseX +
                ", " + appWindow.mouseY;
        appWindow.repaint();
    }

    @Override
    //vvm добавляем перемещение мышки
    public void mouseMoved(MouseEvent me){
        appWindow.mouseX = me.getX();
        appWindow.mouseY = me.getY();
        appWindow.mousemsg = "Mouse moved at "+ appWindow.mouseX +
                ", " + appWindow.mouseY;

        appWindow.repaint();
    }
}

// класс адаптера окна для обработки выхода
class MyWindowAdapter extends WindowAdapter{
    @Override
    public void windowClosing(WindowEvent we){
        System.exit(0);
    }
}
