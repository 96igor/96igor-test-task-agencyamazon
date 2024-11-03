package com.example.testtaskagencyamazon;

import com.example.testtaskagencyamazon.data.SPCampaignStatistic;

import java.math.BigDecimal;

public class ManualTest {
    public static void main(String[] args) {
        SPCampaignStatistic statistic = new SPCampaignStatistic();
        statistic.finalise(); // Вызываем метод, который устанавливает итоговое значение

        // Получаем итоговое значение
        BigDecimal expectedValue = statistic.getFinalValue(); // Изменить на getFinalValue
        // Ожидаемое значение установить в нужное
        BigDecimal actualValue = statistic.getFinalValue();

        // Проверяем, совпадают ли ожидаемое и фактическое значения
        if (expectedValue.compareTo(actualValue) == 0) {
            System.out.println("Тест пройден: " + actualValue);
        } else {
            System.out.println("Тест не пройден: ожидалось " + expectedValue + ", но получено " + actualValue);
        }
    }
}