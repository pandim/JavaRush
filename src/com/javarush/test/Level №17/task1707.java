package com.javarush.task.task17.task1707;

/* 
МВФ

Условие:

Singleton паттерн - синхронизация в методе.
Класс IMF - это Международный Валютный Фонд.
Внутри метода getFund создайте синхронизированный блок.
Внутри синхронизированного блока инициализируйте поле imf так, чтобы метод getFund всегда возвращал один и тот же объект.


Требования:

1. Класс IMF должен содержать приватное статическое поле IMF imf.
2. Класс IMF должен содержать приватный конструктор.
3. Класс IMF должен содержать публичный статический метод IMF getFund().
4. Метод getFund() должен содержать синхронизированный блок.
5. Внутри синхронизированного блока должно быть проинициализировано поле imf.
6. Метод getFund() должен всегда возвращать один и тот же объект.
*/

public class Solution {
    public static void main(String[] args) {
        IMF fund = IMF.getFund();
        IMF anotherFund = IMF.getFund();
        System.out.println(fund == anotherFund );
    }
}


package com.javarush.task.task17.task1707;


public class IMF {
    private static IMF imf;

    private IMF() {

    }

    public static IMF getFund() {
        synchronized (IMF.class){
            if(imf == null) {
                imf = new IMF();
            }
        }
        return imf;
    }


}
