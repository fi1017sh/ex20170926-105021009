import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame {
    private Button btnexit=new Button("Exit");
    private Button btnadd=new Button("Add");
    private Button btnsub=new Button("Sub");
    private Label lab = new Label(">__<");
    private int n=0,LabX=100,LabY=100;
    private Timer t1;
    private boolean flag=true;

    public MainFrame(){
        initComp();
    }
    private  void initComp(){
        this.setBounds(100,100,500,500);
        this.setBackground(new Color(0x96CFF9));
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setLayout(null);
        btnexit.setBounds(200,400,100,50);
        btnexit.setBackground(new Color(0x5650F9));
        this.add(btnexit);
        btnexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnadd.setBounds(200,300,100,50);
        btnadd.setBackground(new Color(0x6B92F9));
        this.add(btnadd);
        btnsub.setBounds(300,300,100,50);
        btnsub.setBackground(new Color(0x6B92F9));
        this.add(btnsub);
        lab.setBounds(LabX,LabY,100,50);
        lab.setForeground(new Color(0x1C0260));
        this.add(lab);
        btnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.setTitle(Integer.toString(++n));
                //lab.setText(Integer.toString(n));
                t1.start();
                flag=true;
            }
        });
        btnsub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.setTitle(Integer.toString(--n));
                //lab.setText(Integer.toString(n));
                t1.start();
                flag=false;
            }
        });
        t1= new Timer(25, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(flag){
                    LabX+=5;
                    lab.setLocation(LabX,LabY);
                    if(LabX>=MainFrame.this.getWidth()){flag=false;}
                }else {
                    LabX-=5;
                    lab.setLocation(LabX,LabY);
                    if(LabX<=0){flag=true;}
                }

            }
        });

    }
}
//抓座標 lab.setText(Integer.toString(LabX)+","+Integer.toString(LabY));