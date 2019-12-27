import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;


public class MyCalendar extends JFrame{
    /**
     * 
     */
    private static final long serialVersionUID = 1193245796699646333L;
    private JPanel imagePanel,datePanel,p,p2,p3;
    private JLabel label,l,l2,l3,l4,l5;
    private ImageIcon background;
    private JButton b,b2;
    private JTextField t;
    private JComboBox<String> month_list = new JComboBox<String>();
    private Font f = new Font("微软雅黑",Font.PLAIN,15);
    private String columns[] = {"一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"};
    private Date now = new Date();
    private JLabel[] day = new JLabel[42];
    public MyCalendar(){
        super("赵亮 201702701159");
        Image img=Toolkit.getDefaultToolkit().getImage("title.png");//窗口图标
        setIconImage(img);
        setSize(620,490);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //添加背景图片
        background = new ImageIcon("background.jpg");  
        label = new JLabel(background);  
        label.setBounds(0, 0, this.getWidth(), this.getHeight());   
        imagePanel = (JPanel) this.getContentPane();  
        imagePanel.setOpaque(false);  
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
        
        //设置布局
        l = new JLabel();
        l.setFont(new Font("微软雅黑",Font.ITALIC,40));
        l.setForeground(Color.red);//设置字体颜色
        add(l);
        l.setBounds(5, 5, 80, 45);
        l2 = new JLabel();
        l2.setFont(new Font("微软雅黑",Font.BOLD,20));
        l2.setForeground(Color.red);//设置字体颜色
        add(l2);
        l2.setBounds(90, 10, 150, 40);
        l3 = new JLabel();
        l3.setFont(new Font("华文彩云",Font.BOLD,30));
        l3.setForeground(Color.red);//设置字体颜色
        add(l3);
        l3.setBounds(500, 17, 100, 30);
        
        p = new JPanel();
        add(p);
        p.setBounds(5, 45, 600, 2);
        p.setBorder(BorderFactory.createLineBorder(Color.black));
        
        l4 = new JLabel("年份：");
        add(l4);
        l4.setBounds(10, 50, 80, 20);
        l4.setFont(f);
        t = new JTextField();
        add(t);
        t.setBounds(60, 50, 60, 20);
        t.setFont(f);
        l5 = new JLabel("月份：");
        add(l5);
        l5.setBounds(130, 50, 80, 20);
        l5.setFont(f);
        add(month_list);
        month_list.setBounds(180, 50, 70, 20);
        month_list.setFont(f);
        month_list.setOpaque(false);
        
        for(int i = 0;i < 12;i++)
        {
            month_list.addItem(columns[i]);
        }
        b = new JButton("上个月");
        add(b);
        b.setBounds(430, 50, 80, 20);
        b.setFont(f);
        b.setOpaque(false);
        b2 = new JButton("下个月");
        add(b2);
        b2.setBounds(520, 50, 80, 20);
        b2.setFont(f);
        b2.setOpaque(false);
        
        p2 = new JPanel();
        add(p2);
        p2.setBounds(15, 85, 580, 1);
        p2.setBorder(BorderFactory.createLineBorder(Color.blue));
        
        p3 = new JPanel();
        p3.setOpaque(false);
        add(p3);
        p3.setBounds(5, 90, 600, 20);
        p3.setLayout(new GridLayout(1,7,2,2));
        JLabel[] week = new JLabel[7];
        week[0] = new JLabel("       SUN");
        week[1] = new JLabel("       MON");
        week[2] = new JLabel("       TUE");
        week[3] = new JLabel("       WED");
        week[4] = new JLabel("        THU");
        week[5] = new JLabel("         FRI");
        week[6] = new JLabel("         SAT");
        for(int i = 0;i < 7;i++)
        {
            week[i].setForeground(Color.black);//设置字体颜色
            week[i].setFont(f);
            p3.add(week[i]);
        }
        
        
        datePanel = new JPanel();
        datePanel.setOpaque(false);
        add(datePanel);
        datePanel.setBounds(5, 110, 610, 340);
        datePanel.setLayout(new GridLayout(6,7,2,5));
        
        for(int i = 0;i < 42;i++)
        {
            day[i] = new JLabel("");
            day[i].setForeground(Color.red);//设置字体颜色
            //day[i].setBorder(BorderFactory.createLineBorder(Color.black));
            day[i].setFont(new Font("Jokerman",Font.BOLD,20));
            datePanel.add(day[i]);
        }
        
        Calendar cale = null;
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        int dow = cale.get(Calendar.DAY_OF_WEEK);//获取本月第一天是星期几

        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        int maxDate = cale.get(Calendar.DAY_OF_MONTH);//获取本月有多少天
        int ptr = 1;
        int ptr2 = dow -1;
        int today = now.getDate();
        for(int i = 0;i < maxDate;i++)
        {
            day[ptr2].setText("     " + ptr);
            if(ptr == today)
            {
                day[ptr2].setForeground(Color.black);
                day[ptr2].setFont(new Font("Jokerman",Font.BOLD,35));
                day[ptr2].setText("  " + ptr);
                day[ptr2].setBorder(BorderFactory.createLineBorder(new Color(220,20,60)));
            }
            ptr++;
            ptr2++;
        }
        
        //初始化顶部信息
        int m = now.getMonth() + 1;
        l.setText("" + m);
        //设置下拉列表的选中月份为当前月份
        month_list.setSelectedIndex( m-1);
        
        switch (m) {
        case 1:
            l2.setText("January");
            break;
        case 2:
            l2.setText("February");
            break;
        case 3:
            l2.setText("March");
            break;
        case 4:
            l2.setText("April");
            break;
        case 5:
            l2.setText("May");
            break;
        case 6:
            l2.setText("June");
            break;
        case 7:
            l2.setText("July");
            break;
        case 8:
            l2.setText("August");
            break;
        case 9:
            l2.setText("September");
            break;
        case 10:
            l2.setText("October");
            break;
        case 11:
            l2.setText("November");
            break;
        case 12:
            l2.setText("December");
            break;
        }
        int y = now.getYear() + 1900;
        l3.setText("" + y);
        t.setText("" + y);
        
        //添加监听器
        month_list.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent e){
                    Calendar cale = null;
                    String year;
                    boolean flag = true;
                    if(e.getStateChange() == ItemEvent.SELECTED)
                    {
                        year = t.getText();
                        if(year.equals(""))
                        {
                            JOptionPane.showMessageDialog(null,"年份不能为空!");
                        }
                        else
                        {
                            for(int i = 0;i < year.length();i++)
                            {
                                if(year.charAt(i) >= 48 && year.charAt(i) <= 57){}
                                else
                                {
                                    JOptionPane.showMessageDialog(null,"请按照正确格式输入年份!");
                                    flag = false;
                                    break;
                                }
                            }
                            
                            if(flag)
                            {
                                String date = "";
                                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                                int y = Integer.valueOf(year).intValue();
                                int m = month_list.getSelectedIndex() + 1;
                                System.out.println(y);
                                System.out.println(m);
                                cale = Calendar.getInstance();
                                date = "" + year + "-" + m + "-" + 1;
                                try {
                                    cale.setTime(format.parse(date));
                                } catch (ParseException e1) {
                                    // TODO 自动生成的 catch 块
                                    e1.printStackTrace();
                                }
                                int dow = cale.get(Calendar.DAY_OF_WEEK);//获取本月第一天是星期几
                                System.out.println(dow);
                                
                                cale.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天  
                                int maxDate = cale.get(Calendar.DAY_OF_MONTH);//获取本月有多少天
                                System.out.println(maxDate);
                                int ptr = 1;
                                int ptr2 = dow -1;
                                int today = now.getDate();
                                //再重新设置内容前重置所有内容
                                for(int i = 0;i < 42;i++)
                                {
                                    day[i].setText("");
                                    day[i].setForeground(Color.red);//设置字体颜色
                                    day[i].setFont(new Font("Jokerman",Font.BOLD,20));
                                    day[i].setBorder(null);
                                }
                                
                                for(int i = 0;i < maxDate;i++)
                                {
                                    day[ptr2].setText("     " + ptr);
                                    if(ptr == today)
                                    {
                                        if(y == now.getYear() + 1900 && m == now.getMonth() +1)
                                        {
                                            day[ptr2].setForeground(Color.black);
                                            day[ptr2].setFont(new Font("Jokerman",Font.BOLD,35));
                                            day[ptr2].setText("  " + ptr);
                                            day[ptr2].setBorder(BorderFactory.createLineBorder(new Color(220,20,60)));
                                        }
                                    }
                                    ptr++;
                                    ptr2++;
                                }
                                
                                //重置l,l2,l3的信息
                                l.setText("" + m);                            
                                switch (m) {
                                case 1:
                                    l2.setText("January");
                                    break;
                                case 2:
                                    l2.setText("February");
                                    break;
                                case 3:
                                    l2.setText("March");
                                    break;
                                case 4:
                                    l2.setText("April");
                                    break;
                                case 5:
                                    l2.setText("May");
                                    break;
                                case 6:
                                    l2.setText("June");
                                    break;
                                case 7:
                                    l2.setText("July");
                                    break;
                                case 8:
                                    l2.setText("August");
                                    break;
                                case 9:
                                    l2.setText("September");
                                    break;
                                case 10:
                                    l2.setText("October");
                                    break;
                                case 11:
                                    l2.setText("November");
                                    break;
                                case 12:
                                    l2.setText("December");
                                    break;
                                }
                                l3.setText("" + y);
                            }
                        }
                    }
                }
         });
        
        //上个月
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Calendar cale = null;
                String year;
                boolean flag = true;
                
                year = t.getText();
                if(year.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"年份不能为空!");
                }
                else
                {
                    for(int i = 0;i < year.length();i++)
                    {
                        if(year.charAt(i) >= 48 && year.charAt(i) <= 57){}
                        else
                        {
                            JOptionPane.showMessageDialog(null,"请按照正确格式输入年份!");
                            flag = false;
                            break;
                        }
                    }
                    
                    if(flag)
                    {
                        String date = "";
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        int y = Integer.valueOf(year).intValue();
                        int m = month_list.getSelectedIndex();
                        if(m==0)
                        {
                            m = 12;//1月往前就是去年12月
                            y -= 1;//去年
                        }
                        System.out.println(y);
                        System.out.println(m);
                        cale = Calendar.getInstance();
                        date = "" + year + "-" + m + "-" + 1;
                        try {
                            cale.setTime(format.parse(date));
                        } catch (ParseException e1) {
                            // TODO 自动生成的 catch 块
                            e1.printStackTrace();
                        }
                        int dow = cale.get(Calendar.DAY_OF_WEEK);//获取本月第一天是星期几
                        System.out.println(dow);
                        
                        cale.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天  
                        int maxDate = cale.get(Calendar.DAY_OF_MONTH);//获取本月有多少天
                        System.out.println(maxDate);
                        int ptr = 1;
                        int ptr2 = dow -1;
                        int today = now.getDate();
                        //再重新设置内容前重置所有内容
                        for(int i = 0;i < 42;i++)
                        {
                            day[i].setText("");
                            day[i].setForeground(Color.red);//设置字体颜色
                            day[i].setFont(new Font("Jokerman",Font.BOLD,20));
                            day[i].setBorder(null);
                        }
                        
                        for(int i = 0;i < maxDate;i++)
                        {
                            day[ptr2].setText("     " + ptr);
                            if(ptr == today)
                            {
                                if(y == now.getYear() + 1900 && m == now.getMonth() +1)
                                {
                                    day[ptr2].setForeground(Color.black);
                                    day[ptr2].setFont(new Font("Jokerman",Font.BOLD,35));
                                    day[ptr2].setText("  " + ptr);
                                    day[ptr2].setBorder(BorderFactory.createLineBorder(new Color(220,20,60)));
                                }
                            }
                            ptr++;
                            ptr2++;
                        }
                        
                        //重置l,l2,l3的信息
                        t.setText("" + y);
                        l.setText("" + m);
                        //设置下拉列表的选中月份为当前月份
                        month_list.setSelectedIndex( m-1 );
                        switch (m) {
                        case 1:
                            l2.setText("January");
                            break;
                        case 2:
                            l2.setText("February");
                            break;
                        case 3:
                            l2.setText("March");
                            break;
                        case 4:
                            l2.setText("April");
                            break;
                        case 5:
                            l2.setText("May");
                            break;
                        case 6:
                            l2.setText("June");
                            break;
                        case 7:
                            l2.setText("July");
                            break;
                        case 8:
                            l2.setText("August");
                            break;
                        case 9:
                            l2.setText("September");
                            break;
                        case 10:
                            l2.setText("October");
                            break;
                        case 11:
                            l2.setText("November");
                            break;
                        case 12:
                            l2.setText("December");
                            break;
                        }
                        l3.setText("" + y);
                    }
                }         
            }
        });
        
        //下个月
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Calendar cale = null;
                String year;
                boolean flag = true;
                
                year = t.getText();
                if(year.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"年份不能为空!");
                }
                else
                {
                    for(int i = 0;i < year.length();i++)
                    {
                        if(year.charAt(i) >= 48 && year.charAt(i) <= 57){}
                        else
                        {
                            JOptionPane.showMessageDialog(null,"请按照正确格式输入年份!");
                            flag = false;
                            break;
                        }
                    }
                    
                    if(flag)
                    {
                        String date = "";
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        int y = Integer.valueOf(year).intValue();
                        int m = month_list.getSelectedIndex();
                        if(m==11)
                        {
                            m = 1;//12月往后就是明年1月
                            y += 1;//明年
                        }
                        else
                        {
                            m +=2;
                        }
                        System.out.println(y);
                        System.out.println(m);
                        cale = Calendar.getInstance();
                        date = "" + year + "-" + m + "-" + 1;
                        try {
                            cale.setTime(format.parse(date));
                        } catch (ParseException e1) {
                            // TODO 自动生成的 catch 块
                            e1.printStackTrace();
                        }
                        int dow = cale.get(Calendar.DAY_OF_WEEK);//获取本月第一天是星期几
                        System.out.println(dow);
                        
                        cale.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天  
                        int maxDate = cale.get(Calendar.DAY_OF_MONTH);//获取本月有多少天
                        System.out.println(maxDate);
                        int ptr = 1;
                        int ptr2 = dow -1;
                        int today = now.getDate();
                        //再重新设置内容前重置所有内容
                        for(int i = 0;i < 42;i++)
                        {
                            day[i].setText("");
                            day[i].setForeground(Color.red);//设置字体颜色
                            day[i].setFont(new Font("Jokerman",Font.BOLD,20));
                            day[i].setBorder(null);
                        }
                        
                        for(int i = 0;i < maxDate;i++)
                        {
                            day[ptr2].setText("     " + ptr);
                            if(ptr == today)
                            {
                                if(y == now.getYear() + 1900 && m == now.getMonth() +1)
                                {
                                    day[ptr2].setForeground(Color.black);
                                    day[ptr2].setFont(new Font("Jokerman",Font.BOLD,35));
                                    day[ptr2].setText("  " + ptr);
                                    day[ptr2].setBorder(BorderFactory.createLineBorder(new Color(220,20,60)));
                                }
                            }
                            ptr++;
                            ptr2++;
                        }
                        
                        //重置l,l2,l3的信息
                        t.setText("" + y);
                        l.setText("" + m);
                        //设置下拉列表的选中月份为当前月份
                        month_list.setSelectedIndex( m-1 );
                        switch (m) {
                        case 1:
                            l2.setText("January");
                            break;
                        case 2:
                            l2.setText("February");
                            break;
                        case 3:
                            l2.setText("March");
                            break;
                        case 4:
                            l2.setText("April");
                            break;
                        case 5:
                            l2.setText("May");
                            break;
                        case 6:
                            l2.setText("June");
                            break;
                        case 7:
                            l2.setText("July");
                            break;
                        case 8:
                            l2.setText("August");
                            break;
                        case 9:
                            l2.setText("September");
                            break;
                        case 10:
                            l2.setText("October");
                            break;
                        case 11:
                            l2.setText("November");
                            break;
                        case 12:
                            l2.setText("December");
                            break;
                        }
                        l3.setText("" + y);
                    }
                } 
            }
        });
        
        this.addKeyListener(new KeyMonitor());
        p3.addKeyListener(new KeyMonitor());
        t.addKeyListener(new KeyMonitor());
        imagePanel.setFocusable(true);
        imagePanel.addKeyListener(new KeyMonitor());
        b.addKeyListener(new KeyMonitor());
        b2.addKeyListener(new KeyMonitor());
        month_list.addKeyListener(new KeyMonitor());
        setVisible(true);
    }
    
    class KeyMonitor extends KeyAdapter{
        public void keyPressed(KeyEvent e){
               int key = e.getKeyCode();
               if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT)
               {
                   Calendar cale = null;
                    String year;
                    boolean flag = true;
                    
                    year = t.getText();
                    if(year.equals(""))
                    {
                        JOptionPane.showMessageDialog(null,"年份不能为空!");
                    }
                    else
                    {
                        for(int i = 0;i < year.length();i++)
                        {
                            if(year.charAt(i) >= 48 && year.charAt(i) <= 57){}
                            else
                            {
                                JOptionPane.showMessageDialog(null,"请按照正确格式输入年份!");
                                flag = false;
                                break;
                            }
                        }
                        
                        if(flag)
                        {
                            String date = "";
                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            int y = Integer.valueOf(year).intValue();
                            int m = month_list.getSelectedIndex();
                            
                            if(key == KeyEvent.VK_LEFT)//前一个月
                            {
                                if(m==0)
                                {
                                    m = 12;//1月往前就是去年12月
                                    y -= 1;//去年
                                }
                            }
                            else if(key == KeyEvent.VK_RIGHT)//后一个月
                            {
                                if(m==11)
                                {
                                    m = 1;//12月往后就是明年1月
                                    y += 1;//明年
                                }
                                else
                                {
                                    m +=2;
                                }
                            }    
                            
                            System.out.println(y);
                            System.out.println(m);
                            cale = Calendar.getInstance();
                            date = "" + year + "-" + m + "-" + 1;
                            try {
                                cale.setTime(format.parse(date));
                            } catch (ParseException e1) {
                                // TODO 自动生成的 catch 块
                                e1.printStackTrace();
                            }
                            int dow = cale.get(Calendar.DAY_OF_WEEK);//获取本月第一天是星期几
                            System.out.println(dow);
                            
                            cale.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天  
                            int maxDate = cale.get(Calendar.DAY_OF_MONTH);//获取本月有多少天
                            System.out.println(maxDate);
                            int ptr = 1;
                            int ptr2 = dow -1;
                            int today = now.getDate();
                            //再重新设置内容前重置所有内容
                            for(int i = 0;i < 42;i++)
                            {
                                day[i].setText("");
                                day[i].setForeground(Color.red);//设置字体颜色
                                day[i].setFont(new Font("Jokerman",Font.BOLD,20));
                                day[i].setBorder(null);
                            }
                            
                            for(int i = 0;i < maxDate;i++)
                            {
                                day[ptr2].setText("     " + ptr);
                                if(ptr == today)
                                {
                                    if(y == now.getYear() + 1900 && m == now.getMonth() +1)
                                    {
                                        day[ptr2].setForeground(Color.black);
                                        day[ptr2].setFont(new Font("Jokerman",Font.BOLD,35));
                                        day[ptr2].setText("  " + ptr);
                                        day[ptr2].setBorder(BorderFactory.createLineBorder(new Color(220,20,60)));
                                    }
                                }
                                ptr++;
                                ptr2++;
                            }
                            
                            //重置l,l2,l3的信息
                            t.setText("" + y);
                            l.setText("" + m);
                            //设置下拉列表的选中月份为当前月份
//                            if(key == KeyEvent.VK_LEFT)//前一个月
//                            {
//                                
//                            }
//                            else if(key == KeyEvent.VK_RIGHT)//后一个月
//                            {
//                                
//                            }
                            month_list.setSelectedIndex( m-1 );
                            switch (m) {
                            case 1:
                                l2.setText("January");
                                break;
                            case 2:
                                l2.setText("February");
                                break;
                            case 3:
                                l2.setText("March");
                                break;
                            case 4:
                                l2.setText("April");
                                break;
                            case 5:
                                l2.setText("May");
                                break;
                            case 6:
                                l2.setText("June");
                                break;
                            case 7:
                                l2.setText("July");
                                break;
                            case 8:
                                l2.setText("August");
                                break;
                            case 9:
                                l2.setText("September");
                                break;
                            case 10:
                                l2.setText("October");
                                break;
                            case 11:
                                l2.setText("November");
                                break;
                            case 12:
                                l2.setText("December");
                                break;
                            }
                            l3.setText("" + y);
                        }
                    } 
               }
           }
    }
    
    public static void main(String args[]){
        new MyCalendar();
    }
}