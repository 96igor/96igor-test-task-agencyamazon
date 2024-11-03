package com.example.testtaskagencyamazon;

import com.example.testtaskagencyamazon.data.SPCampaignStatistic;

public class ManualTest {
    public static void main(String[] args) {
        // Создание экземпляра SPCampaignStatistic
        SPCampaignStatistic statistic = new SPCampaignStatistic();

        // Настройка необходимых данных
        // Например можно установить некоторые поля
        // statistic.setSomeField(value); // Установить необходимые значения

        // Вызов метода finalise
        double result = statistic.finalise(); // Заменить на соответствующий метод

        // Ожидаемое значение
        double expected = 500.00; // Заменить на ожидаемое значение

        // Сравнение результата
        if (result == expected) {
            System.out.println("Тест пройден: результат совпадает с ожидаемым.");
        } else {
            System.out.println("Тест не пройден: ожидалось " + expected + ", но получено " + result);
        }
    }
}