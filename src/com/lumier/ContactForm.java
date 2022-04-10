package com.lumier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {

    private JTextField name_field, email_field;
    private JRadioButton male, female;
    private JCheckBox check;




    public ContactForm(){
        super("Контакная форма"); //title
        super.setBounds(100, 100, 320, 200); // первый параметр отступ по x , 2 параметр- y , 3 параметр- ширина, 4 - высота
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // при нажатии закрыть форму останавливаем проект
        Container container = super.getContentPane();
        container.setLayout(new GridLayout(5,2,2,2)); //

        JLabel name = new JLabel("Введите имя"); // добавляем текст
        name_field = new JTextField("", 1); // добавляем текстовое поле(пустое)
        JLabel email = new JLabel("Введите email");
        email_field = new JTextField("@", 1); // добавляем текстовое поле (внутри имеется @)

        container.add(name); //добавляем name в нашу форму
        container.add(name_field);
        container.add(email);
        container.add(email_field);

        male = new JRadioButton("Мужской"); // создаем radio button с текстом Мужской
        female = new JRadioButton("Женский");
        check = new JCheckBox("Потвердить", false); //создаем checkbox с текстом потвердить и предопределяем как false
        JButton send_button = new JButton("Отправить"); // создаем кнопку Отправить

        male.setSelected(true); // выбираем мужской по умолчанию
        container.add(male); // добавляем кнопки в форму
        container.add(female);

        ButtonGroup group = new ButtonGroup(); // создаем объект для группировки

        group.add(male); // группируем поля male, female
        group.add(female);

        container.add(check);
        container.add(send_button);

        send_button.addActionListener(new ButtonEventManager()); //кнопке Отправить добавляем обработчкик события
    }

    class ButtonEventManager implements ActionListener{ // описываем обработчик события

        @Override // унаследуем с родительского класса интерфейс
        public void actionPerformed(ActionEvent e) {
            String name = name_field.getText(); // создаем переменую name и приравниваем значение поля name_field получив из нее текст
            String mail = email_field.getText();

            String isMale = "Мужской";
            if (!male.isSelected()) // Если кнопка male НЕ выбрана, то
                isMale = "Женский";

            boolean checkBox = check.isSelected();
            String agree = "Да";
            if (!checkBox)
                agree = "Нет";



            JOptionPane.showMessageDialog(null,"Ваша почта:" + mail +
                    "\nВаш пол:" + isMale + "\nВы согласны? " + agree,
                    "Привет " + name, JOptionPane.PLAIN_MESSAGE); //Выводит дополнительное окно, где первый параметр наследование с родителя(null). 2- сообщение который будет в самой форме 3- заголовок формы, 4
        }
    }

}
