package org.example;

import java.util.Arrays;

public class CarrotCollectionWithLimits {
    public static void main(String[] args) {

        /**
         * Сделал Рахимбердиев Темур Джамалович

         * Техническое задание. Время для решение задачи до 12.07.2024 до 19.00
         * Задача такая "Составить эффективный алгоритм":
         * Есть 5 полянок. На каждой полянке огород с морковкой.
         * На первой полянке морковь массой в 1 кг, на второй полянке - морковь массой в 2 кг,
         * на третьей полянке - морковь массой в 3 кг, на 4 полянке - морковь массой в 4 кг,
         * на пятой полянке - морковь массой в 5 кг. Зайцу необходимо за 10 ходок унести максимальное количество моркови с полянок за 1 день,
         * причем заяц за раз может взять только 5 кг моркови. Необходимо составить эффективный алгоритм, который самостоятельно должен найти решение на java.
         */


        int[] fieldWeights = {1, 2, 3, 4, 5}; // Массив веса моркови на каждой полянке
        int weightPerTrip = 5;//Максимальный вес моркови за одну ходку (кг)
        int tripCount = 0; // Количество ходов
        int[] carrotFromField = new int[fieldWeights.length];// Массив для хранения веса моркови, взятой с каждой поляны

        // Цикл сбора моркови (ровна 10 ходов)

        while (tripCount <10 ){
            // Выбор полянок с наибольшим оставшимся весом, но не более weightPerTrip
            int fieldIndex = selectFieldWithMaxCarrot(fieldWeights, weightPerTrip);
            int carrotToTake = 0;

            if (fieldIndex != -1){
                carrotToTake = Math.min(fieldWeights[fieldIndex], weightPerTrip);// Вес моркови, которую можно взять
                // Обновления веса моркови
                fieldWeights[fieldIndex] -= carrotToTake;
                carrotFromField[fieldIndex] += carrotToTake;
            }

            tripCount++;

            //Вывод промежуточного состояния
            System.out.println("Ходка " + tripCount + ":");
            System.out.println("Полянка " + (fieldIndex + 1) + ": взято " + carrotToTake + " кг");
            System.out.println("Оставшийся вес на полянках: " + Arrays.toString(fieldWeights));
            System.out.println("Собрано с полянок: " + Arrays.toString(carrotFromField));
            System.out.println();
        }

        // Вычисление общего собранного веса моркови
        int totalCarrotWeightCollected = Arrays.stream(carrotFromField).sum();

        // Вывод информации о сборе моркови
        System.out.println("Количество ходок: " + tripCount);
        System.out.println("Собрано моркови: " + totalCarrotWeightCollected);
        System.out.println("Морковь с каждой поляны:");
        for (int i = 0; i < carrotFromField.length; i++) {
            System.out.println("Полянка " + (i + 1) + ": " + carrotFromField[i] + " кг");
        }
    }

    private static int selectFieldWithMaxCarrot(int[] fieldWeights, int weightPerTrip){
        int maxIndex = -1; // Инициализация maxIndex значением -1, что означает отсутствие выбранной поляны
        for (int i = 0; i < fieldWeights.length; i++){
            if (fieldWeights[i] > 0 && fieldWeights[i] <= weightPerTrip && (maxIndex == -1 || fieldWeights[i] > fieldWeights[maxIndex]));{
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
