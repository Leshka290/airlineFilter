package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;

import java.util.List;

public class OutputInfoService {
    public static void printFlights(List<Flight> flights) {
        System.out.println("Список полетов:\n");

        for (Flight flight : flights) {
            System.out.println(flight);
            System.out.println("---");
        }

        System.out.println("Выберите одну из цифр для фильтрации?");
        System.out.println("(1) Вылет до текущего момента времени.");
        System.out.println("(2) Полеты, у которых имеются сегменты с датой прилета раньше даты вылета.");
        System.out.println("(3) Полеты, у которых общее время проведенное на земле, превышает два часа.");
        System.out.println("(0) Выход из программы.");

    }
}
